package com.college.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.college.util.DatabaseConnection;

@WebServlet("/RecordAttendanceServlet")
public class RecordAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(studentId));
            statement.setDate(2, java.sql.Date.valueOf(date));
            statement.setString(3, status);

            statement.executeUpdate();
            response.sendRedirect("teacherDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("record_attendance.jsp?error=1");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("teacherDashboard.jsp");
    }
}