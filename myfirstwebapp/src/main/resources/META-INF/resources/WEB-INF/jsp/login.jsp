<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

    <head>
    <title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
Login Page
</title>
</head>
<body>
    <div class="container">

        <h1>Welcome to the login page</h1>
        <hr>
        <div class="from-control">
            <form method="post">
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type = "submit">
                ${ErrorMessage}
            </form>
        </div>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
