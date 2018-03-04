<%@ include file="includes/header.jsp" %>

<%
if(request.getSession().getAttribute("userId") == null) {
    request.getSession().setAttribute("userId", 1);
}
%>

<br>
<h1>${sessionScope.message}</h1>

<%@include file="includes/footer.jsp"%>