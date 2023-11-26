package edu.ntudp.pzks.fifthLab.database;

import edu.ntudp.pzks.fifthLab.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int studentID = resultSet.getInt("id");
                String studentSurname = resultSet.getString("surname");
                String studentName = resultSet.getString("name");
                String studentPatronymic = resultSet.getString("patronymic");
                Date studentBirthday = resultSet.getDate("birthday");
                String studentIDCard = resultSet.getString("student_id_card");

                Student student = new Student(studentID, studentSurname, studentName, studentPatronymic, studentBirthday, studentIDCard);
                students.add(student);
            }
        }
        return students;
    }

    public void addStudent(String lastName, String firstName, String middleName, String birthDateStr, String studentId) throws SQLException {
        String sql = "INSERT INTO students (surname, name, patronymic, birthday, student_id_card) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, middleName);
            preparedStatement.setDate(4, Date.valueOf(birthDateStr));
            preparedStatement.setString(5, studentId);

            preparedStatement.executeUpdate();
        }
    }

    public List<Student> getStudentsByBirthMonth(int birthMonth) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE EXTRACT(MONTH FROM birthday) = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, birthMonth);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("id");
                String surname = resultSet.getString("surname");
                String studentName = resultSet.getString("name");
                String studentPatronymic = resultSet.getString("patronymic");
                Date studentBirthday = resultSet.getDate("birthday");
                String studentIDCard = resultSet.getString("student_id_card");
                Student student = new Student(studentID, surname, studentName, studentPatronymic, studentBirthday, studentIDCard);
                students.add(student);

            }
        }
        return students;
    }

}
