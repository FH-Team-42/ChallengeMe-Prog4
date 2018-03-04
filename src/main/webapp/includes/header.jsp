<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 01.03.2018
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ChallengeMe</title>

    <!-- Bootstrap include -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>


    <link rel="stylesheet" type="text/css" href="/css/layout.css"/>

    <!-- JQuery include -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    <div class="row">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="challenges?action=showActive" class="nav-link">Meine aktiven Challenges</a></li>
            <li class="nav-item"><a href="challenges?action=showAll" class="nav-link">Challenges anzeigen</a></li>
            <li class="nav-item"><a href="challenges?action=showCreate" class="nav-link">Challenge erstellen</a></li>
            <li class="nav-item"><a href="profile" class="nav-link">Profil</a></li>
            <li class="nav-item"><a href="login?action=logout" class="nav-link">Logout</a></li>
        </ul>
    </div>


<% if(request.getSession(false).getAttribute("message") != null) { %>

    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="alert alert-success fade in">
                <p><strong>${sessionScope.message}</strong></p>
                <c:remove var="message" scope="session" />
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>

<% } %>

<div class="placeholder"></div>
