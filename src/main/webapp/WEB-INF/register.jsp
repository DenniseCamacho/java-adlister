<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<form class="text-center my-5" action="/register" method="POST">
    <h2 class="text-uppercase">Registration form</h2>

    <label>Username</label>
    <input type="text" name="username" id="username" class="input-field mb-3"><br>
    <label>Your Email</label>
    <input type="email" class="input-field mb-3" name="email" required><br>
    <label>Password</label>
    <input type="password" name="password" id="pwd" class="input-field mb-3"><br>

    <label class="option mb-3">I agree to the <a href="#">Terms and Conditions</a>
        <input type="checkbox" checked>
        <span class="checkmark"></span>
    </label><br>

    <input type="submit" value="Register" class="register" name="register">
</form>

</body>
</html>
