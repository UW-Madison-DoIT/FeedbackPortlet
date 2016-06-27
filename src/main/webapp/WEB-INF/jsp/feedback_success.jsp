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
          <spring:bind path="command.chatLink">
            <a href="<c:out value="${status.value}" />"><i class="fa fa-comments-o"></i>Live chat</a>
        </spring:bind>
        <spring:bind path="command.callLink">
           <a href="<c:out value="${status.value}"/>" target='_blank'><i class="fa fa-phone"></i>Call us</a>
        </spring:bind>
        <spring:bind path="command.howToLink">
         <a href="<c:out value="${status.value}"/>" target='_blank'><i class="fa fa-question"></i>How-to info</a>
        </spring:bind>
    </div>
  </div>
</div>
