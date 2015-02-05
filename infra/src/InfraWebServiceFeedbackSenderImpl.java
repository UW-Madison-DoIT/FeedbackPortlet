/**
 * All rights reserved.
*
* A non-exclusive worldwide royalty-free license is granted for this Software.
* Permission to use, copy, modify, and distribute this Software and its
* documentation, with or without modification, for any purpose is granted
* provided that such redistribution and use in source and binary forms, with or
* without modification meets the following conditions:
*
* 1. Redistributions of source code must retain the above copyright notice,
* this list of conditions and the following disclaimer.
*
* 2. Redistributions in binary form must reproduce the above copyright notice,
* this list of conditions and the following disclaimer in the documentation
* and/or other materials provided with the distribution.
*
* 3. Redistributions of any form whatsoever must retain the following
* acknowledgement:
*
* "This product includes software developed by The Board of Regents of
* the University of Wisconsin System."
*
*THIS SOFTWARE IS PROVIDED BY THE BOARD OF REGENTS OF THE UNIVERSITY OF
*WISCONSIN SYSTEM "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING,
*BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
*PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE BOARD OF REGENTS OF
*THE UNIVERSITY OF WISCONSIN SYSTEM BE LIABLE FOR ANY DIRECT, INDIRECT,
*INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
*LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
*PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
*LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
*OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
*ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
**/
package edu.wisc.my.portlets.feedback.dao;

import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.destination.Wsdl11DestinationProvider;
import org.springframework.ws.transport.http.CommonsHttpMessageSender;

import edu.wisc.my.portlets.feedback.FeedbackSubmissionException;
import edu.wisc.my.portlets.feedback.beans.Feedback;

/**
 * {@link FeedbackSender} implementation that invokes methods
 * on the Infra web services endpoint.
 * 
 * Requires a {@link Resource} be set that locates the WSDL and a {@link String}
 * named "infraSrc" that is passed along as the "src" parameter for each method.
 * Optionally allows you to set the "call type" parameter.
 * 
 * @author Nicholas Blair, nblair@doit.wisc.edu
 * @version $Id: InfraWebServiceFeedbackSenderImpl.java,v 1.2 2009/07/24 16:07:55 nblair Exp $
 */
public class InfraWebServiceFeedbackSenderImpl implements FeedbackSender,
		InitializingBean {

	private Log LOG = LogFactory.getLog(this.getClass());
	protected final static BigInteger RESULT_FAIL = new BigInteger("0");
	
	protected final static String CALL_SERVICE = "MY WEBSPACE";
	
	private WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

	private Resource wsdlResource;
	private String infraSrc;
	private String callType = "Feedback";
	
	/**
	 * @param wsdlResource the wsdlResource to set
	 */
	@Required
	public void setWsdlResource(final Resource wsdlResource) {
		this.wsdlResource = wsdlResource;
	}

	/**
	 * @param infraSrc the infraSrc to set
	 */
	@Required
	public void setInfraSrc(final String infraSrc) {
		this.infraSrc = infraSrc;
	}

	/**
	 * @param callType the callType to set
	 */
	public void setCallType(String callType) {
		this.callType = callType;
	}

	/* (non-Javadoc)
	 * @see edu.wisc.mywebspace.web.feedback.FeedbackSender#send(edu.wisc.mywebspace.web.feedback.Feedback)
	 */
	public void send(final Feedback feedback) throws FeedbackSubmissionException {
		CallCreate request = new CallCreate();
		if(StringUtils.isBlank(feedback.getNetid())) {
			// infra ws requires empty strings at a minimum
			request.setCustomerNetid(" ");
		} else {
			request.setCustomerNetid(feedback.getNetid());
		}
		request.setCallService(CALL_SERVICE);
		request.setCallType(callType);
		request.setSrc(infraSrc);
		// infra ws requires empty strings
		request.setCallRef(" ");
	
		request.setCallDescription(feedback.getDetails());
		CallCreateResponse response = (CallCreateResponse) webServiceTemplate.marshalSendAndReceive(request);
		if(null == response.getReturn() || RESULT_FAIL.equals(response.getReturn())) {
			LOG.error("infra call submission failed, return code " + response.getReturn());
			throw new FeedbackSubmissionException("infra call submission failed, return code " + response.getReturn());
		} else {
			LOG.info("infra call submitted successfully, call number " + response.getReturn());
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		// initialize JAXB2
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("edu.wisc.kb.infra.ws");
		marshaller.afterPropertiesSet();
		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);

		// Tell webServiceTemplate to use CommonsHttpMessageSender
		CommonsHttpMessageSender messageSender = new CommonsHttpMessageSender();
		// allow 4 seconds for connect timeout
		messageSender.setConnectionTimeout(4000);
		// allow 20 seconds for infra web service to return
		messageSender.setReadTimeout(20000);
		webServiceTemplate.setMessageSender(messageSender);
		
		// create WSDL destination provider, override locationExpression to point to correct URI
		Wsdl11DestinationProvider provider = new Wsdl11DestinationProvider();
		provider.setWsdl(wsdlResource);
		webServiceTemplate.setDestinationProvider(provider);
		LOG.info("webServiceTemplate configuration complete; wsdl: " + wsdlResource.getURI().toString());
	}

}
