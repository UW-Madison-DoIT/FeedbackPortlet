/**
 * Copyright 2009, The Board of Regents of the University of Wisconsin System.
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
 */
package edu.wisc.kb.infra.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;

import org.junit.Test;

/**
 * Test bench for the automatically generated classes in the edu.wisc.kb.infra.ws package.
 * 
 * Focus is only on the {@link CallCreateResponse} class, as this is the only method this
 * portlet invokes.
 * 
 * @author Nicholas Blair, nblair@doit.wisc.edu
 * @version $Id: ObjectMarshallingTest.java,v 1.1 2009/07/15 18:12:10 dalquist Exp $
 */
public class ObjectMarshallingTest {

	/**
	 * This method uses a real sample response from the Infra CallCreate method and attempts to unmarshal it.
	 * Asserts object is created and the value of the return field is set as expected.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCallCreateResponse() throws Exception {
		String example = "<ns1:CallCreateResponse xmlns:ns1=\"https://kb.wisc.edu/infra/interfaces/CallTransactions\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><return xsi:type=\"xsd:int\">1673</return></ns1:CallCreateResponse>";
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		CallCreateResponse response = (CallCreateResponse) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(example.getBytes()));
		assertNotNull(response);
		assertEquals(new BigInteger("1673"), response.getReturn());
	}
	
	/**
	 * Create a {@link CallCreateResponse} object, marshal it out to a {@link ByteArrayOutputStream} (and stdout),
	 * then attempt to unmarshal the stream back into an object.
	 * Assert object recreated as expected.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMarshallCallCreateResponse() throws Exception {
		CallCreateResponse request = new CallCreateResponse();
		request.setReturn(new BigInteger("1234"));
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		context.createMarshaller().marshal(request, output);
		
		// dump to stdout so console can see the response
		context.createMarshaller().marshal(request, System.out);
		System.out.println();
		
		CallCreateResponse result = (CallCreateResponse) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(output.toByteArray()));
		assertNotNull(result);
		assertEquals(new BigInteger("1234"), result.getReturn());
	}
	
	/**
	 * Create a {@link CallCreate} object, marshal it out to a {@link ByteArrayOutputStream} (and stdout),
	 * then attempt to unmarshal the stream back into an object.
	 * Assert object recreated as expected.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMarshallCallCreate() throws Exception {
		CallCreate request = new CallCreate();
		request.setCallDescription("description");
		request.setCallRef("ref");
		request.setCallService("myuw");
		request.setCallType("type");
		request.setSrc("myuw");
		request.setCustomerNetid("netid");
		
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		context.createMarshaller().marshal(request, output);
		
		// dump to stdout so console can see the response
		context.createMarshaller().marshal(request, System.out);
		System.out.println();
		
		CallCreate result = (CallCreate) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(output.toByteArray()));
		assertNotNull(result);
		assertEquals("description", result.getCallDescription());
		assertEquals("ref", result.getCallRef());
		assertEquals("myuw", result.getCallService());
		assertEquals("type", result.getCallType());
		assertEquals("myuw", result.getSrc());
		assertEquals("netid", result.getCustomerNetid());
	}
}
