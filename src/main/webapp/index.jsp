<%--
  Created by IntelliJ IDEA.
  User: davidwenkemann
  Date: 03.03.18
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>LogIn</title>

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
    <form class="pure-form" action="/login" method="post">
        <input type="text" placeholder="Name" id="username" name="username" required>
        <input type="password" placeholder="Passwort" id="password" name="password" required>

        <button type="submit" class="pure-button pure-button-primary">Anmelden</button>
        <button onclick="location.href='register'">Registrieren</button>
    </form>

</div>


<br>
<h1>${sessionScope.message}</h1>


</body>
</html>