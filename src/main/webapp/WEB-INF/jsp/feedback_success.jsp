<jsp:directive.include file="/WEB-INF/jsp/include-portlet.jsp"/>

<div class='feedback-portlet'>
  <div class='container-fluid'>
    <div class="row">
      <div class="col-xs-12 col-sm-6 general-thanks">
        <div class="info-area">
            <p>Thanks for your feedback.</p>
        </div>
      </div>
      <div class="col-xs-12 col-sm-6 general-help">
        <h2>Get help</h2>
          <a href='/portal/p/campus-chat-connections'><i class="fa fa-comments-o"></i>Live chat</a>
          <a href='http://helpdesk.doit.wisc.edu/page.php?id=1' target='_blank'><i class="fa fa-phone"></i>Call Us</a>
          <a href='https://kb.wisc.edu/myuw/' target='_blank'><i class="fa fa-question"></i>How-to Info</a>
      </div>
    </div>
    <div class="my-voice-container info-area">
        <span> <img src="<%=renderRequest.getContextPath()%>/img/myuw-myvoice-logo.png"/></span>
        <span> MyUW MyVoice closed on March 30.  We received hundreds of ideas and are using them to enhance the site.  Thanks to everyone who contributed, and we hope you'll keep giving your feedback on MyUW!</span>
    </div>
  </div>
</div>
