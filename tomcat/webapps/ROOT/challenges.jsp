<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Challenge" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 01.03.2018
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>
<table class="table">
    <thead class="thead">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">CompletionTime</th>
            <th scope="col">CreationTime</th>
            <th scope="col">creatorID</th>
            <th scope="col">challengedID</th>
        </tr>
    </thead>

    <!--get the collection from the attribute from appropriate scope (here, request) -->
    <% ArrayList<Challenge> challenges = (ArrayList<Challenge>) request.getAttribute("challengeList");
    //<!--iterate over the arraylist-->
        for (int i = 0; i < challenges.size(); i++) {
        Challenge challenge = challenges.get(i);
    %>
    <!-- create an html table row -->
    <tr>
        <!-- create cells of row -->
        <td scope="row"><% out.print(challenge.getChallengeId()); %></td>
        <td><% out.print(challenge.getTitle()); %></td>
        <td><% out.print(challenge.getDescription()); %></td>
        <td><% out.print(challenge.getCompletionTime()); %></td>
        <td><% out.print(challenge.getCreated()); %></td>
        <td><% out.print(challenge.getCreatorId()); %></td>
        <td><% out.print(challenge.getChallengedId()); %></td>
        <!-- close row -->
    </tr>
    <!-- close the loop -->
    <% } %>
    <!-- close table -->
</table>

<%@include file="includes/footer.jsp"%>