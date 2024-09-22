package com.college.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.util.DatabaseConnection;
import com.college.model.Attendance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAttendance")
public class ViewAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentIdString = request.getParameter("studentId");
        List<Attendance> attendanceList = new ArrayList<>();

        if (studentIdString != null && !studentIdString.isEmpty()) {
            try {
                int studentId = Integer.parseInt(studentIdString);

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
                }
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Handle parsing error (invalid studentId format)
            }
        } else {
            // Handle case where studentId parameter is missing or empty
            // Optionally, redirect or display an error message
        }

        request.setAttribute("attendanceList", attendanceList);
        request.getRequestDispatcher("view_attendance.jsp").forward(request, response);
    }
}
