<%@ page session="false" %>
<jsp:directive.include file="/WEB-INF/jsp/include-base.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>MyUW Feedback</title>
<style type="text/css" media="all">
	@import "css/style.css";
</style>
</head>

<body>
<script type="text/javascript"><!--
function browserInfo(form) {
form.browserName.value=navigator.appName;
form.browserVersion.value=navigator.appVersion;
form.platform.value=navigator.platform;
form.userAgent.value=navigator.userAgent;
}
// --></script>

<div class="header">
<img alt="MyUW-Madison" src="img/header_myuw1.gif" height="55" width="187">
</div>

<div class="content">
<p>
Use this form to send us your comments or suggestions about this web site
or its content.<br/>
<strong>For help or technical assistance</strong>, please check the 
<a href="http://helpdesk.wisc.edu">Help Desk</a> 
website for more information.
</p>

<p>
<strong>If you wish to be contacted</strong>, please provide
a valid email address and/or telephone number.
</p>
</div>

<div class="form">
<form method="post" action="" onsubmit="browserInfo(this)">

	<p>
	<spring:bind path="command.name">
	Name:<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
	<input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
	</spring:bind>
	</p>
	
	<p>
	<spring:bind path="command.netid">
	NetID (example: bbadger):<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
	<input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
	</spring:bind>
	</p>
	
	<p>
	<spring:bind path="command.phoneNumber">
	Telephone Number:<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
	<input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
	</spring:bind>
	</p>
	
	<p>
	<spring:bind path="command.emailAddress">
	Email Address:<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
	<input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
	</spring:bind>
	</p>
	
	<p>
	<spring:bind path="command.subject">
	Subject*:<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
	<input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
	</spring:bind>
	</p>
	
	<p>
	<spring:bind path="command.details">
	Details*:<span class="error-message">&nbsp;<c:out value="${status.errorMessage}"/></span><br/>
<textarea rows="10" cols="60" name="<c:out value="${status.expression}"/>">
<c:out value="${status.value}"/>
</textarea>
	</spring:bind>
	</p>
	
	<spring:bind path="command.userAgent">
	<input type="hidden" name="<c:out value="${status.expression}"/>" />
	</spring:bind>
	<spring:bind path="command.browserName">
	<input type="hidden" name="<c:out value="${status.expression}"/>" />
	</spring:bind>
	<spring:bind path="command.browserVersion">
	<input type="hidden" name="<c:out value="${status.expression}"/>" />
	</spring:bind>
	<spring:bind path="command.platform">
	<input type="hidden" name="<c:out value="${status.expression}"/>" />
	</spring:bind>
	
	<p>
	<strong>* denotes a required field.</strong>
	</p>

	<p>
	<input type="submit" value="Submit" />
	</p>
</form>
</div>

</body>
</html>
