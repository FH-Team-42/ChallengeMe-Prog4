<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Challenge" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 01.03.2018
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp"%>
<table class="table">
    <thead class="thead">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Titel</th>
            <th scope="col">Beschreibung</th>
            <th scope="col">Erstelldatum</th>
            <th scope="col">Abgeschlossen</th>
        </tr>
    </thead>

    <!--get the collection from the attribute from appropriate scope (here, request) -->
    <% ArrayList<Challenge> challenges = (ArrayList<Challenge>) request.getAttribute("challengeList");
    //<!--iterate over the arraylist-->
        for (int i = 0; i < challenges.size(); i++) {
        Challenge challenge = challenges.get(i);
    %>
    <!-- create an html table row -->
    <tr scope="row" class='clickable-row' data-href='/challenges?action=show&challengeId=<%out.print(challenge.getChallengeId());%>'>
        <!-- create cells of row -->
        <td><% out.print(challenge.getChallengeId()); %></td>
        <td><% out.print(challenge.getTitle()); %></td>
        <td><% out.print(challenge.getDescription()); %></td>
        <td>
            <%
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                out.print(format.format(challenge.getCreated()));

            %>
        </td>
        <td>
            <%
                if(challenge.isCompleted()) {
                    out.print("Ja");
                } else {
                    out.print("Nein");
                }
            %>
        </td>
        <!-- close row -->
    </tr>
    <!-- close the loop -->
    <% } %>
    <!-- close table -->
</table>

<script>
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });
</script>

<%@include file="../../footer.jsp"%>