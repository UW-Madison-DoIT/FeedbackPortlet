<%@ page session="false" %>
<jsp:directive.include file="/WEB-INF/jsp/include-portlet.jsp"/>

<style>

.feedback-portlet .my-voice-container{
    display:table;
    background-color:#eee;
    width: 100%;
    height:140px;
    margin-top:15px;
    margin-bottom:15px;
}

.feedback-portlet .my-voice-container span{
    vertical-align: middle;
    display:table-cell;
}

.feedback-portlet .my-voice-container span img{
    vertical-align:middle;
    display:table-cell;
    margin-left:15px;
    margin-right:15px;
}

.feedback-portlet .btn-share-ideas {
  font-weight:100;
  font-size:1.4em;
  background-color:#b70101;
  padding:8px 30px;
  margin:10px 0px;
  color:#fff !important;
  border-radius:4px;
  border:0px solid transparent;
  box-shadow:0px 5px 0px #600;
  cursor:pointer;
  transition:0.1s ease-in-out;
  position:relative;
  
}
.feedback-portlet .btn-share-ideas:hover {
  transform: translateY(2px);
  background-color:#900;
  text-decoration:none;
  box-shadow:0px 3px 0px #000;
  transition:0.1s ease-in-out;
}

.feedback-portlet .general-feedback {
  border-right:1px solid #b70101;
  padding:0px 20px;
  margin-top:20px;
}
.feedback-portlet .general-help {
  padding:20px;
}
.feedback-portlet .general-help a {
  font-size:18px;
  padding:12px;
  background-color:#eee;
  margin-bottom:10px;
  border-radius:4px;
  display:block;
}
.feedback-portlet .general-help a:hover {
  text-decoration:none;
  background-color:#ddd;
}
.feedback-portlet .general-help i {
  font-size:1.3em;
  margin:0px 20px 0px 10px;
}
.feedback-portlet .general-feedback h2,
.feedback-portlet .general-help h2 {
  margin:0px 0px 10px;
  font-size:1.8em;
  color:#b70101;
}
@media (max-width:768px) {
  .feedback-portlet .btn-share-ideas {
    padding:6px 12px;
  }
}

</style>
<script language="JavaScript"><!--
function browserInfo(form) {
form.browserName.value=navigator.appName;
form.browserVersion.value=navigator.appVersion;
form.platform.value=navigator.platform;
form.userAgent.value=navigator.userAgent;
}
// --></script>

<div class='feedback-portlet'>
  <div class='container-fluid'>
    <div class="row">
      <div class="col-xs-12 col-sm-6 general-feedback">
        <h2>Give feedback</h2>
        <form method="post" action="<portlet:actionURL/>" onsubmit="browserInfo(this)">
            <spring:bind path="command.name">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <spring:bind path="command.netid">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <spring:bind path="command.phoneNumber">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <spring:bind path="command.emailAddress">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <p>
            <spring:bind path="command.subject">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="UW Feedback" />
            </spring:bind>
            <spring:bind path="command.details">
            <c:out value="${status.errorMessage}"/></font>
            <textarea wrap="physical" rows="8" style='width: 100%;' class='form-control' name="<c:out value="${status.expression}" />"><c:out value="${status.value}"/></textarea>
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
                Your name will be submitted with your feedback.
            </p>
            <p>
            <input type="submit" value="Send" class='btn btn-primary btn-share-ideas' />
            </p>
        </form>
      </div>
      <div class="col-xs-12 col-sm-6 general-help">
        <h2>Get help</h2>
          <a href='/portal/p/campus-chat-connections'><i class="fa fa-comments-o"></i>Live chat</a>
          <a href='http://helpdesk.doit.wisc.edu/page.php?id=1' target='_blank'><i class="fa fa-phone"></i>Call Us</a>
          <a href='https://kb.wisc.edu/myuw/' target='_blank'><i class="fa fa-question"></i>How-to Info</a>
      </div>
    </div>
    <div class="my-voice-container">
        <span> <img src="<%=renderRequest.getContextPath()%>/img/myuw-myvoice-logo.png"/></span>
        <span> MyUW MyVoice closed on March 30.  We received hundreds of ideas and are using them to enhance the site.  Thanks to everyone who contributed, and we hope you'll keep giving your feedback on MyUW!</span>
    </div>
  </div>
</div>
