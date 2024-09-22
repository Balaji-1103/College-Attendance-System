package com.college.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.college.model.Attendance;
import com.college.util.DatabaseConnection;

@WebServlet("/studentDashboard")
public class StudentDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = (Integer) request.getSession().getAttribute("userId");
        if (studentId == null) {
            response.sendRedirect("login.jsp?error=Please login first");
            return;
        }

        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM attendance WHERE student_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance = new Attendance();
                attendance.setId(resultSet.getInt("id"));
                attendance.setStudentId(resultSet.getInt("student_id"));
                attendance.setDate(resultSet.getDate("date"));
                attendance.setStatus(resultSet.getString("status"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }

        request.setAttribute("attendanceList", attendanceList);
        request.getRequestDispatcher("studentDashboard.jsp").forward(request, response);
    }
}