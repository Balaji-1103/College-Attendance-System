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

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String department = request.getParameter("department");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO teachers (email, password, name, department) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, department);

            statement.executeUpdate();
            response.sendRedirect("admin_dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("add_teacher.jsp?error=1");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("admin_dashboard.jsp");
    }
}