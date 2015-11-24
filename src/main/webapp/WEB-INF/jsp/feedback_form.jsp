<%@ page session="false" %>
<jsp:directive.include file="/WEB-INF/jsp/include-portlet.jsp"/>

<div class='feedback-portlet'>
  <div class='container-fluid'>
    <div class="row">
      <div class="col-xs-12 col-sm-6 general-feedback">
        <h2 tabindex="0" aria-label="Give feedback">Give feedback</h2>
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
            <spring:bind path="command.referrer">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <p>
            <spring:bind path="command.subject">
            <input type="hidden" name="<c:out value="${status.expression}"/>" value="UW Feedback" />
            </spring:bind>
            <spring:bind path="command.details">
            <c:out value="${status.errorMessage}"/></font>
            <textarea aria-label="Give feedback text edited box" wrap="physical" rows="8" style='width: 100%;' class='form-control' name="<c:out value="${status.expression}" />"><c:out value="${status.value}"/></textarea>
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
            <input aria-label="send button" type="submit" value="Send" class='btn btn-primary btn-share-ideas' />
            </p>
        </form>
      </div>
      <div class="col-xs-12 col-sm-6 general-help">
        <jsp:directive.include file="/WEB-INF/jsp/include-righthand-links.jsp"/>
      </div>
    </div>
  </div>
</div>
