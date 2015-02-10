<%@ page session="false" %>
<jsp:directive.include file="/WEB-INF/jsp/include-portlet.jsp"/>

<style>
.feedback-portlet .my-voice {
  border-radius: 4px;
  text-align:center;
  padding:30px;
  margin:10px 0px;
  background-color:#fff;
  border:1px solid #b70101;
}
.feedback-portlet .my-voice h1 {
  font-size:3em;
  color:#b70101;
  display:inline;
  border-bottom:0px solid transparent;
}
.feedback-portlet .my-voice h1.light {
  font-weight:100;
}
.feedback-portlet .my-voice h1.heavy {
  font-weight:600;
}
.feedback-portlet .my-voice img {
  width: 40px;
  display:inline;
  margin:-20px 10px 0px;
}
.feedback-portlet .my-voice h2 {
  margin-top:10px;
  font-size:1.4em;
  font-weight:100;
}
.feedback-portlet .icons h2 {
  color:#b70101;
  font-size:1.7em;
  font-weight:100;
}
.feedback-portlet .icons i {
  color:#b70101;
  font-size:3em;
  text-align:center;
  padding:0;
}
.feedback-portlet .icons li {
  display:inline-block;
  text-align:center;
  margin:0px 15px;
}
.feedback-portlet .icons li:before {
  content:"";
}
.feedback-portlet .icons ul {
  padding-left:0;
  text-align:center;
  margin-top:20px;
}
.feedback-portlet .btn-share-ideas {
  font-weight:100;
  font-size:1.4em;
  background-color:#b70101;
  padding:15px 50px;
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
.feedback-portlet .btn-gen-feedback {
  padding:8px 30px;
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
    <div class='row'>
      <div class='col-xs-12 my-voice'>
        <div class="my-voice-title">
          <span><h1 class="light">MyUW</h1><img src="http://umark.wisc.edu/brand/templates-and-downloads/downloads/web/uwcrest_web_sm_fpo.png"><h1 class="heavy">MyVoice</h1></span>
        </div>
        <h2>Tell us how we could improve your MyUW experience.</h2>
        <div class="icons">
          <ul>
            <li><i class="fa fa-lightbulb-o"></i><h2>Share</h2></li>
            <li><i class="fa fa-comments-o"></i><h2>Discuss</h2></li>
            <li><i class="fa fa-thumbs-o-up"></i><h2>Vote</h2></li>
          </ul>
        </div>
        <a href="https://myuw.ideascale.com/a/panel.do" target="_blank" class="btn btn-primary btn-large btn-share-ideas">Share your ideas <i class="fa fa-arrow-right"></i></a>
      </div>
    </div>
    <div class="row">
      <div class="col-xs-12 col-sm-6 general-feedback">
        <h2>Give General Feedback</h2>
        <p>If you have an idea for a new feature or an improvement, share your ideas using <a href="https://myuw.ideascale.com/a/panel.do" target="_blank">MyVoice</a>.</p>
        <p>Use the form below to ask a question or report a problem. Please note that your feedback is not anonymous. This is the test commit from git to prove that this works.  From Tim Vertein.</p>
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
            <p>Provide us with as much detail as possible:</p> <font color="#FF0000"><c:out value="${status.errorMessage}"/></font>
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

            <p style='font-size: smaller;'>
               (limit is 1200 characters)
            </p>

            <p class='reply'>
                <strong>Do you want a reply?</strong><br/>
                <spring:bind path="command.reply">
                    <input type="radio" name="<c:out value="${status.expression}" />" value="Yes"> Yes, I would like someone to follow up with me.</input><br/>
                    <input type="radio" name="<c:out value="${status.expression}"/>" value="No"> No thanks.</input>
                </spring:bind>
            </p>
            <p>
            <input type="submit" value="Send message" class='btn btn-primary btn-share-ideas btn-gen-feedback' />
            </p>
        </form>
      </div>
      <div class="col-xs-12 col-sm-6 general-help">
        <h2>Need Help?</h2>
          <a href='/portal/p/campus-chat-connections'><i class="fa fa-comments-o"></i>Live chat</a>
          <a href='http://helpdesk.doit.wisc.edu/page.php?id=1' target='_blank'><i class="fa fa-phone"></i>Call Us</a>
          <a href='https://kb.wisc.edu/myuw/' target='_blank'><i class="fa fa-question"></i>How-to Info</a>
      </div>
    </div>
  </div>
</div>

<!--                 <div class="row"> -->
<!--                     <div class="col-xs-12 instruction"> -->
<!--                         Otherwise, please use the form below to ask a question, report a problem, or suggest an improvement. Please note that your feedback is not anonymous. -->
<!--                     </div> -->
<!--                 </div> -->
