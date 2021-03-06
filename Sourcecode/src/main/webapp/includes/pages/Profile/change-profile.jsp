<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 02.03.18
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp"%>



<div class="card">
    <form class="pure-form" action="change-profile" method="post">
        <fieldset>
            <legend>Passwort ändern</legend>
            <input type="password" placeholder="Passwort" id="password" name="password" required>
            <input type="password" placeholder="Passwort bestätigen" id="confirm_password" required>

            <button type="submit" class="pure-button pure-button-primary">Confirm</button>

            <script>
                var password = document.getElementById("password")
                    , confirm_password = document.getElementById("confirm_password");

                function validatePassword(){
                    if(password.value != confirm_password.value) {
                        confirm_password.setCustomValidity("Passwort muss übereinstimmen!");
                    } else {
                        confirm_password.setCustomValidity('');
                    }
                }

                password.onchange = validatePassword;
                confirm_password.onkeyup = validatePassword;
            </script>

        </fieldset>
    </form>

    <form class="pure-form" action="change-profile" method="post">
        <fieldset>
            <legend>Profilbild ändern</legend>
            <input type="text" placeholder="neuer Profilbildlink" id="profilePicture" name="profilePicture" required>

            <button type="submit" class="pure-button pure-button-primary">Confirm</button>

        </fieldset>
    </form>

</div>

<%@include file="../../footer.jsp"%>