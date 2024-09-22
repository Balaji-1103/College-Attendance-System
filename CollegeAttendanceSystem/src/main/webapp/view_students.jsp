<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.college.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
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
            max-width: 1000px;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h1 {
            text-align: center;
            color: #333;
            font-weight: 500;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 15px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .back-link a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>View All Students</h1>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Department</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                if (students != null && !students.isEmpty()) {
                    for (Student student : students) {
            %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getDepartment() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No students found</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <div class="back-link">
            <a href="admin_dashboard.jsp">Back to Dashboard</a>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
