<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 03.03.18
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrierung</title>

    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 300px;
            margin: auto;
            text-align: center;
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

        input {
            text-align: center;
            width: 95%;
            font-size: 18px;
            margin: 3px;
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
<div class="card">
    <form class="pure-form" action="register" method="post">
        <input type="text" placeholder="Name" id="username" name="username" required>
        <input type="password" placeholder="Passwort" id="password" name="password" required>
        <input type="password" placeholder="Passwort bestätigen" id="confirm_password" required>
        <input type="date" placeholder="Geburtstag" id="birthday" name="birthday" required>


        <button type="submit" class="pure-button pure-button-primary">Registrieren</button>



        <!--both passwords have to be the same-->
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
    </form>

</div>

</body>
</html>
