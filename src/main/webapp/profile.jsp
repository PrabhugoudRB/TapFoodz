<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Body styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        /* Container styles */
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
        }

        /* Profile info styles */
        .profile-info {
            margin-bottom: 20px;
        }

        .profile-info h2 {
            margin-top: 0;
            margin-bottom: 10px;
        }

        .profile-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>

<%
    // Retrieving user information from session
    User user = (User) session.getAttribute("user");
%>

<div class="container">
    <div class="profile-info">
        <h2>Profile</h2>
        <p><strong>Full Name:</strong> <%= user.getUserName() %></p>
        <p><strong>Email Address:</strong> <%= user.getEmail() %></p>
        <p><strong>Phone Number:</strong> <%= user.getPhoneNo() %></p>
        <!-- Add more profile information here if needed -->
    </div>
</div>

</body>
</html>
