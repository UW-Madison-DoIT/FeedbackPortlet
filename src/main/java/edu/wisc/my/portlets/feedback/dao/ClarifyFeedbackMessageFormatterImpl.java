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
package edu.wisc.my.portlets.feedback.dao;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;

import edu.wisc.my.portlets.feedback.beans.Feedback;

/**
 * IFeedbackMessageFormatter implementation that formats the feedback
 * data into the format required by the new case creation handler in
 * Clarify.
 *
 * @deprecated Use {@link FeedbackSender} instead.
 * @author nblair@doit.wisc.edu
 * @version $Header: /apps/my/CVS/portlets/FeedbackPortlet/src/main/java/edu/wisc/my/portlets/feedback/dao/ClarifyFeedbackMessageFormatterImpl.java,v 1.6 2014/10/31 18:32:48 vertein Exp $
 */
@Deprecated
public class ClarifyFeedbackMessageFormatterImpl implements
        IFeedbackMessageFormatter {

    // recipient - this is an address in the clarify system
    private String targetEmail;
    // from addressz - so bounces can be properly handled
    private String fromAddress;
    /**
     * @param fromAddress The fromAddress to set.
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    /**
     * @param targetEmail The targetEmail to set.
     */
    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    /* (non-Javadoc)
     * @see edu.wisc.my.portlets.feedback.dao.IFeedbackMessageFormatter#format(edu.wisc.my.portlets.feedback.beans.Feedback)
     */
    public SimpleMailMessage format(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(targetEmail);
        message.setFrom(fromAddress);

        message.setSubject("CALL_CREATE"+" "+feedback.getSubject());

        StringBuffer body = new StringBuffer();

        body.append("CUSTOMER_NETID: ");
        body.append(null == feedback.getNetid() ? "<empty>" : feedback.getNetid());
        body.append("\n");
        body.append("CALL_SERVICE: ");
        body.append("My UW");
        body.append("\n");
        body.append("CALL_REF: ");
        body.append("SEND TO HDI");
        body.append("\n");
        body.append("CALL_DESCRIPTION: ");
        body.append(feedback.getDetails());
        body.append("\n");
        body.append("Date:\n");
        body.append(new Date());
        body.append("\n");
        body.append("\n");
        body.append("Following Information user-inputted:");
        body.append("\n");

        body.append("\n");
        body.append("name: ");
        body.append(null == feedback.getName() ?  "<empty>" : feedback.getName());
        body.append("\n");

        body.append("phone: ");
        body.append(null == feedback.getPhoneNumber() ? "<empty>" : feedback.getPhoneNumber());
        body.append("\n");

        body.append("email: ");
        body.append(null == feedback.getEmailAddress() ? "<empty>" : feedback.getEmailAddress());
        body.append("\n");
        
        body.append("Would like reply: ");
        body.append(null == feedback.getReply() ? "<empty>" : feedback.getReply());
        body.append("\n");
        body.append("\n");
        
        body.append("Following Information auto-populated:");
        body.append("\n");
        body.append("\n");

        body.append("hidden netID: ");
        body.append(null == feedback.getHiddenNetid() ?  "<empty>" : feedback.getHiddenNetid());
        body.append("\n");

        body.append("hidden name: ");
        body.append(null == feedback.getHiddenName() ?  "<empty>" : feedback.getHiddenName());
        body.append("\n");

        body.append("hidden phone: ");
        body.append(null == feedback.getHiddenPhoneNumber() ? "<empty>" : feedback.getHiddenPhoneNumber());
        body.append("\n");

        body.append("hidden email: ");
        body.append(null == feedback.getHiddenEmailAddress() ? "<empty>" : feedback.getHiddenEmailAddress());
        body.append("\n");

        body.append("userAgent: ");
        body.append(null == feedback.getUserAgent() ? "<empty>" : feedback.getUserAgent());
        body.append("\n");

        body.append("browserName: ");
        body.append(null == feedback.getBrowserName() ? "<empty>" : feedback.getBrowserName());
        body.append("\n");

        body.append("browserVersion: ");
        body.append(null == feedback.getBrowserVersion() ? "<empty>" : feedback.getBrowserVersion());
        body.append("\n");

        body.append("platform: ");
        body.append(null == feedback.getPlatform() ? "<empty>" : feedback.getPlatform());
        body.append("\n");
        
        body.append("profile: ");
        body.append(null == feedback.getProfile() ? "<empty>" : feedback.getProfile());
        body.append("\n");

        message.setText(body.toString());

        return message;
    }

}
