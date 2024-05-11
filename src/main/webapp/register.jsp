<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="signIn.css">
    <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
</head>
<body>
    <div class="wrapper">
        <form action="Register" method="post">
            <h1>Create Account</h1>
            <div class="input-box">
                <input type="text" placeholder="Username" required name="username"> 
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="text" placeholder="Phone Number" required name="phonenum">
                <i class='bx bx-phone'></i>
            </div>
            <div class="input-box">
                <input type="text" placeholder="Emai" required name="email">
                <i class='bx bx-phone'></i>
            </div>
           
            <div class="input-box">
                <input type="text" placeholder="Password" required name="password">
                <i class='bx bxs-lock-alt'></i>
            </div>
                  
            <button type="submit" class="btn">LogIn</button>

        </form>
    </div>
</body>
</html>