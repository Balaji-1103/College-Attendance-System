<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.college.model.Attendance" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Attendance</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            width: 100%;
            max-width: 900px;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h1 {
            color: #333;
            font-weight: 500;
            margin-bottom: 20px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
        }
        .link {
            text-align: center;
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
        <h1>Attendance Records</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList");
                if (attendanceList != null && !attendanceList.isEmpty()) {
                    for (Attendance attendance : attendanceList) {
            %>
                <tr>
                    <td><%= attendance.getId() %></td>
                    <td><%= attendance.getDate() %></td>
                    <td><%= attendance.getStatus() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3" class="text-center">No records found</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <div class="link">
            <a href="studentDashboard.jsp">Back to Dashboard</a>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
