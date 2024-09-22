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

import com.college.util.DatabaseConnection;
import com.college.model.Teacher;

@WebServlet("/ViewTeachesrServlet")
public class ViewTeachersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM teachers";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setName(resultSet.getString("name"));
                teacher.setDepartment(resultSet.getString("department"));

                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("view_teachers.jsp").forward(request, response);
    }
}