<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 03.03.18
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LogIn</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
</head>
<body>

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

<div class="row">
    <div class="card">
        <form class="pure-form" action="login" method="post">
            <input type="text" placeholder="Name" id="username" name="username" required>
            <input type="password" placeholder="Passwort" id="password" name="password" required>

            <button type="submit" class="pure-button pure-button-primary">Anmelden</button>
            <button onclick="location.href='includes/pages/Register/register.jsp'">Registrieren</button>
        </form>

    </div>
</div>


</body>
</html>