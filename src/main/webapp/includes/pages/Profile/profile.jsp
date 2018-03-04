<%@ page import="models.User" %>

<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 02.03.18
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp"%>


<%
    User actualUser = (User) request.getAttribute("actualUser");
%>


<div class="card">
    <img src="<% out.print(actualUser.getProfilePicture()); %>" alt="Profilbild" style="width:100%">
    <h1><% out.print(actualUser.getName()); %></h1>
    <p class="title "> Geburtsdatum: <% out.print(actualUser.getBirthday()); %></p>
    <p class="title">Geschaffte Challenges: ${completedChallenges}</p>

    <p><button onclick="location.href='/change-profile'">Ändern</button></p>
</div>

<%@include file="../../footer.jsp"%>
