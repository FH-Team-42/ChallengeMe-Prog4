<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Challenge" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 03.03.2018
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>

<%
    Challenge desiredChallenge = (Challenge) request.getAttribute("desiredChallenge");
%>

<h2>Es wird die Challenge "<% out.print(desiredChallenge.getTitle()); %>" angezeit. </h2> <br> <br>

<h4>Beschreibung:</h4>
<p><% out.print(desiredChallenge.getDescription()); %></p> <br> <br>

<h4>Zeit um die Challenge fertigzustellen:</h4>
<p><%out.print(desiredChallenge.getCompletionTime()); %></p> <br> <br>

<h4>Ersteller:</h4>
<p>${creatorUsername}</p> <br> <br>

<button><a href="challenges?action=start&userId=<%out.print(request.getSession().getAttribute("userId"));%>&challengeId=<%out.print(challenge.getChallengeId());%>">Starten</a></button>
<button><a href="challenges?action=showAll">Zurück</a></button>

<%@include file="includes/footer.jsp"%>