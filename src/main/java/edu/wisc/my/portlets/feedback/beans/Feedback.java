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
package edu.wisc.my.portlets.feedback.beans;

import java.io.Serializable;

/**
 * JavaBean-style class to be used as a FormBackingObject for the 
 * feedback form.
 * 
 * @author nblair@doit.wisc.edu
 * @version $Header: /apps/my/CVS/portlets/FeedbackPortlet/src/main/java/edu/wisc/my/portlets/feedback/beans/Feedback.java,v 1.4 2014/10/31 18:32:48 vertein Exp $
 */
public class Feedback implements Serializable {

    private static final long serialVersionUID = 53706L;
    
    private String name;
    private String netid;
    private String phoneNumber;
    private String emailAddress;
    private String hiddenName;
    private String hiddenNetid;
    private String hiddenPhoneNumber;
    private String hiddenEmailAddress;
    private String campus;
    private String feedbackResponseEmail;
    private String subject;
    private String details;
    private String userAgent;
    private String browserName;
    private String browserVersion;
    private String platform;
    private String reply;
    private String profile;
    private String referrer;
       
    /**
     * @return Returns the campus.
     */
    public String getCampus() {
        return campus;
    }
    /**
     * @param campus The campus to set.
     */
    public void setCampus(final String campus) {
        this.campus = campus;
    }
    /**
    
    /**
     * @return Returns the details.
     */
    public String getDetails() {
        return details;
    }
    /**
     * @param details The details to set.
     */
    public void setDetails(final String details) {
        this.details = details;
    }
    /**
     * @return Returns the emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * @param emailAddress The emailAddress to set.
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * @return Returns the netid.
     */
    public String getNetid() {
        return netid;
    }
    /**
     * @param netid The netid to set.
     */
    public void setNetid(final String netid) {
        this.netid = netid;
    }
    /**
     * @return Returns the phoneNumber.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber The phoneNumber to set.
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getHiddenEmailAddress() {
        return hiddenEmailAddress;
    }
    /**
     * @param emailAddress The emailAddress to set.
     */
    public void setHiddenEmailAddress(final String emailAddress) {
        this.hiddenEmailAddress = emailAddress;
    }
    
    
    /**
     * @return Returns the name.
     */
    public String getHiddenName() {
        return hiddenName;
    }
    /**
     * @param name The name to set.
     */
    public void setHiddenName(final String name) {
        this.hiddenName = name;
    }
    /**
     * @return Returns the netid.
     */
    public String getHiddenNetid() {
        return hiddenNetid;
    }
    /**
     * @param netid The netid to set.
     */
    public void setHiddenNetid(final String netid) {
        this.hiddenNetid = netid;
    }
    /**
     * @return Returns the phoneNumber.
     */
    public String getHiddenPhoneNumber() {
        return hiddenPhoneNumber;
    }
    /**
     * @param phoneNumber The phoneNumber to set.
     */
    public void setHiddenPhoneNumber(final String phoneNumber) {
        this.hiddenPhoneNumber = phoneNumber;
    }
    /**
     * @return Returns the subject.
     */
    public String getSubject() {
        return subject;
    }
    /**
     * @param subject The subject to set.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }
    /**
     * @return Returns the browserName.
     */
    public String getBrowserName() {
        return browserName;
    }
    /**
     * @param browserName The browserName to set.
     */
    public void setBrowserName(final String browserName) {
        this.browserName = browserName;
    }
    /**
     * @return Returns the browserVersion.
     */
    public String getBrowserVersion() {
        return browserVersion;
    }
    /**
     * @param browserVersion The browserVersion to set.
     */
    public void setBrowserVersion(final String browserVersion) {
        this.browserVersion = browserVersion;
    }
    /**
     * @return Returns the platform.
     */
    public String getPlatform() {
        return platform;
    }
    /**
     * @param platform The platform to set.
     */
    public void setPlatform(final String platform) {
        this.platform = platform;
    }
    /**
     * @return Returns the userAgent.
     */
    public String getUserAgent() {
        return userAgent;
    }
    /**
     * @param userAgent The userAgent to set.
     */
    public void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }
    
    public String getReply() {
        return reply;
    }
    
    public void setReply(String reply) {
        this.reply = reply;
    }
    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }
    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }
    /**
     * @return the referrer
     */
    public String getReferrer() {
        return referrer;
    }
    /**
     * @param referrer the referrer to set
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }
    
    /**
     * @return the campus-specific email address. Set in portlet preferences.
     */
	public String getFeedbackResponseEmail() {
		return feedbackResponseEmail;
	}
	
	/**
     * @param feedbackResponseEmail the email address to which feedback will be directed
     */
	public void setFeedbackResponseEmail(String feedbackResponseEmail) {
		this.feedbackResponseEmail = feedbackResponseEmail;
	}
}
