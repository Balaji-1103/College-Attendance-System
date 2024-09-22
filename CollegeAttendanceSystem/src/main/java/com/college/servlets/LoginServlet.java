package com.college.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.college.util.DatabaseConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM " + role + "s WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                request.getSession().setAttribute("user", email);
                request.getSession().setAttribute("role", role);
                request.getSession().setAttribute("userId", resultSet.getInt("id"));

                switch (role) {
                    case "student":
                        response.sendRedirect("studentDashboard.jsp");
                        break;
                    case "teacher":
                        response.sendRedirect("teacherDashboard.jsp");
                        break;
                    case "admin":
                        response.sendRedirect("admin_dashboard.jsp");
                        break;
                    default:
                        response.sendRedirect("login.jsp?error=1");
                        break;
                }
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=1");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}