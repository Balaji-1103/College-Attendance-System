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
import com.college.model.Student;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setEmail(resultSet.getString("email"));
                student.setName(resultSet.getString("name"));
                student.setDepartment(resultSet.getString("department"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("view_students.jsp").forward(request, response);
    }
}