<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #ff6f61, #de3c3c);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            width: 100%;
            max-width: 800px;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h1 {
            color: #333;
            font-weight: 500;
            margin-bottom: 20px;
        }
        .link {
            display: block;
            margin: 20px 0;
        }
        .link a {
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .link a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, <%= request.getSession().getAttribute("user") %></h1>
         <div class="link">
            <a href="add_teacher.jsp">Add Teacher</a>
        </div>
        <div class="link">
            <a href="ViewTeachersServlet">View All Teachers</a>
        </div>
        <div class="link">
            <a href="add_student.jsp">Add Student</a>
        </div>
        <div class="link">
            <a href="ViewStudentsServlet">View All Students</a>
        </div>
        <div class="link">
            <a href="logout">Logout</a>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
