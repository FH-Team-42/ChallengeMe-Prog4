<%@ page import="models.User" %>

<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 02.03.18
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<html>
<head>
    <title>Profile</title>
<!--
Design: https://www.w3schools.com/howto/howto_css_profile_card.asp
-->

    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 300px;
            margin: auto;
            text-align: center;
        }

        .title {
            color: grey;
            font-size: 18px;
        }

        button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        a {
            text-decoration: none;
        }

        button:hover, a:hover {
            opacity: 0.7;
        }
    </style>
</head>

<body>

<%
    User actualUser = (User) request.getAttribute("actualUser");
%>


<div class="card">
    <img src="<% out.print(actualUser.getProfilePic()); %>" alt="Profilbild" style="width:100%">
    <h1><% out.print(actualUser.getName()); %></h1>
    <p class="title "> Geburtsdatum: <% out.print(actualUser.getBirthday()); %></p>
    <p class="title">Geschaffte Challenges: <% out.print(actualUser.getChallengesCompleted()); %></p>

    <p><button onclick="location.href='changeprofile'">Ändern</button></p>
</div>


</body>
</html>
<%@include file="includes/footer.jsp"%>
