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
           <a href="<c:out value="${chatLink}" />"><i class="fa fa-comments-o"></i>Live chat</a>
           <a href="<c:out value="${callLink}"/>" target='_blank'><i class="fa fa-phone"></i>Call us</a>
           <a href="<c:out value="${howToLink}"/>" target='_blank'><i class="fa fa-question"></i>How-to info</a>
    </div>
  </div>
</div>
