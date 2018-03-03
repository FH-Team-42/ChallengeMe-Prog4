<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Challenge" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 03.03.2018
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>
<table class="table">
    <thead class="thead">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Titel</th>
        <th scope="col">Beschreibung</th>
        <th scope="col">Startzeit</th>
        <th scope="col">Endzeit</th>
        <th scope="col">Fertigstellen</th>
    </tr>
    </thead>

    <!--get the collection from the attribute from appropriate scope (here, request) -->
    <% ArrayList<Challenge> challenges = (ArrayList<Challenge>) request.getAttribute("activeChallenges");
        //<!--iterate over the arraylist-->
        for (int i = 0; i < challenges.size(); i++) {
            Challenge challenge = challenges.get(i);
    %>
    <!-- create an html table row -->
    <tr scope="row">
        <!-- create cells of row -->
        <td><% out.print(challenge.getChallengeId()); %></td>
        <td><% out.print(challenge.getTitle()); %></td>
        <td><% out.print(challenge.getDescription()); %></td>
        <td>
            <%
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                out.print(format.format(challenge.getStarted()));

            %>
        </td>
        <td>
            <%
                Calendar cal = new GregorianCalendar();
                cal.setTime(challenge.getStarted());
                cal.add(Calendar.SECOND, challenge.getCompletionTime());
                Date endDate = cal.getTime();
                out.print(format.format(endDate));
            %>
        </td>
        <td><button>Abschließen</button></td>
        <!-- close row -->
    </tr>
    <!-- close the loop -->
    <% } %>
    <!-- close table -->
</table>

<%@include file="includes/footer.jsp"%>