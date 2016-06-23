/*******************************************************************************
* Copyright 2005, The Board of Regents of the University of Wisconsin System.
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
*******************************************************************************/
package edu.wisc.my.portlets.feedback.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.portlet.mvc.SimpleFormController;
import javax.portlet.PortletPreferences;
import edu.wisc.my.portlets.feedback.beans.Feedback;
import edu.wisc.my.portlets.feedback.dao.FeedbackSender;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Map;



import javax.portlet.PortletRequest;

/**
 * Spring PortletMVC FormController for feedback form.
 * Note the onSubmit method throws any Exception - this is desired behavior.
 * An exceptionResolver is defined in the portlet's Spring beans config that
 * will direct any error cases to a "pretty" view.
 * 
 * @author nblair@doit.wisc.edu
 * @version $Header: /apps/my/CVS/portlets/FeedbackPortlet/src/main/java/edu/wisc/my/portlets/feedback/web/FeedbackFormController.java,v 1.3 2014/10/31 18:32:48 vertein Exp $
 */
public class FeedbackFormController extends SimpleFormController {
	private Log logger = LogFactory.getLog(this.getClass());
	private FeedbackSender feedbackSender;
	
	private String callLink = "callLink";
	private String howToLink = "howToLink";
	private PortletPreferences preferences;
	
    /**
	 * @param feedbackSender the feedbackSender to set
	 */
	@Required
	public void setFeedbackSender(FeedbackSender feedbackSender) {
		this.feedbackSender = feedbackSender;
	}
    
    /* (non-Javadoc)
     * @see org.springframework.web.portlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
     */
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Feedback feedback = (Feedback) command;
        
        feedbackSender.send(feedback);
    }
    @Override
    protected Object formBackingObject(PortletRequest request) throws Exception {
    	if(this.preferences == null){
     	   this.preferences = request.getPreferences();
        }
    	
    	final Feedback feedback = new Feedback();
        feedback.setNetid(request.getRemoteUser());
        feedback.setHiddenNetid(request.getRemoteUser());

       
        @SuppressWarnings("unchecked")
        final Map<String, String> userInfo = (Map<String, String>)request.getAttribute(PortletRequest.USER_INFO);
        
        final String displayName = userInfo.get("displayName");
        feedback.setName(displayName);
        feedback.setHiddenName(displayName);
        
        final String mail = userInfo.get("mail");
        feedback.setEmailAddress(mail);
        feedback.setHiddenEmailAddress(mail);
        
        final String telephoneNumber = userInfo.get("telephoneNumber");
        feedback.setPhoneNumber(telephoneNumber);
        feedback.setHiddenPhoneNumber(telephoneNumber);
        feedback.setChatLink(this.preferences.getValue("chatLink", null));
        feedback.setCallLink(this.preferences.getValue("callLink", null));
        feedback.setHowToLink((this.preferences.getValue("howToLink", null)));
        
        if(request.isUserInRole("ROLE_BETA_PROFILE")){
            feedback.setProfile("Beta");
        }else if(request.isUserInRole("ROLE_UNIVERSALITY_MOBILE_PROFILE")){
            feedback.setProfile("Classic - Mobile");
        }else{
            feedback.setProfile("Classic - Universality");
        }

        String referrer = request.getProperty(HttpHeaders.REFERER);
        feedback.setReferrer(referrer);
        

        
        return feedback;
    }
    
}
