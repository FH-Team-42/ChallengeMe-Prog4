<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 02.03.2018
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp"%>

<form method="post" action="/challenges?action=create">
    <input type="number" value="1" style="visibility: hidden;" id="id" name="id"/><br>
    <input type="text" placeholder="Titel" id="title" name="title" required /><br>
    <input type="text" placeholder="Beschreibung" id="description" name="description" required /><br>
    <input type="number" placeholder="Zeit in s" id="time" name="time" required /><br>
    <input type="submit" value="Bestätigen" id="submit" name="submit" />
</form>


<%@include file="../../footer.jsp"%>