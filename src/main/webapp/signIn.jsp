<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignIn</title>
    <link rel="stylesheet" href="signIn.css">
    <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
</head>
<body>
   <div class="wrapper">
        <form action="SignIn" method="post">
            <h1>Log In</h1>
            <div class="input-box">
                <input type="text" placeholder="Username" name="username" required> 
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="text" placeholder="Password" name="password" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            
            <div class="remember-forgot">
                <label><input type="checkbox">Remember me</label>
                <a href="">Forgot password?</a>
            </div>

            <button type="submit" class="btn">Login</button>

            <div class="register-link"><p>Don't have an account? <a href="register.jsp">Register</a></p></div>
        </form>
    </div>
</body>
</html>