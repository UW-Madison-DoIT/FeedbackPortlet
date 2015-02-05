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
.feedback-portlet .thanks {
  margin-bottom:150px;
}
@media (max-width:768px) {
  .feedback-portlet .btn-share-ideas {
    padding:6px 12px;
  }
}

</style>

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
        <h2>Thank you!</h2>
        <p class="thanks">Thanks for getting in touch.  If you indicated that you wanted us to follow-up with you, we'll be in touch shortly.</p>
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
