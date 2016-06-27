/*******************************************************************************
*  Copyright 2009 The Board of Regents of the University of Wisconsin System.
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*******************************************************************************/
package edu.wisc.my.portlets.feedback.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import edu.wisc.my.portlets.feedback.FeedbackSubmissionException;
import edu.wisc.my.portlets.feedback.beans.Feedback;

/**
 * {@link FeedbackSender} implementation that depends on 
 * Spring's {@link MailSender} and an {@link IFeedbackMessageFormatter}
 * implementation.
 *  
 *  
 * @author Nicholas Blair, nblair@doit.wisc.edu
 * @version $Id: EmailFeedbackSenderImpl.java,v 1.1 2009/08/11 17:08:20 dalquist Exp $
 */
public class EmailFeedbackSenderImpl implements FeedbackSender {

	private Log LOG = LogFactory.getLog(this.getClass());
	private IFeedbackMessageFormatter messageFormatter;
	private MailSender mailSender;
	/**
	 * @param messageFormatter the messageFormatter to set
	 */
	@Required
	public void setMessageFormatter(final IFeedbackMessageFormatter messageFormatter) {
		this.messageFormatter = messageFormatter;
	}
	/**
	 * @param mailSender the mailSender to set
	 */
	@Required
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/* (non-Javadoc)
	 * @see edu.wisc.my.portlets.feedback.dao.FeedbackSender#send(edu.wisc.my.portlets.feedback.beans.Feedback)
	 */
	public void send(final Feedback feedback) throws FeedbackSubmissionException {
		SimpleMailMessage mailMessage = messageFormatter.format(feedback);
		try {
			System.out.println("DO NOT COMMIT THIS");
			//			mailSender.send(mailMessage);
		} catch (MailException e) {
			LOG.error("unable to send email for " + feedback, e);
			throw new FeedbackSubmissionException(e);
		}
	}

}
