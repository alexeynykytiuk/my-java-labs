package edu.ntudp.pzks.fifthLab;

import edu.ntudp.pzks.fifthLab.database.StudentDAO;
import edu.ntudp.pzks.fifthLab.database.StudentDatabase;
import edu.ntudp.pzks.fifthLab.model.Student;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try {
            StudentDatabase studentDatabase = new StudentDatabase();
            StudentDAO studentDAO = new StudentDAO(studentDatabase.getConnection());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. View all students");
                System.out.println("2. Fill in student data from the keyboard");
                System.out.println("3. Search for students by birth month");
                System.out.println("0. Exit");

                int choice;
                try {
                    System.out.print("Select an option: ");
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("An incorrect format was entered. Please try again.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        displayAllStudents(studentDAO);
                        break;
                    case 2:
                        addStudentFromConsole(studentDAO, scanner);
                        break;
                    case 3:
                        searchStudentsByBirthMonth(studentDAO, scanner);
                        break;
                    case 0:
                        System.out.println("The program is complete.");
                        return;
                    default:
                        System.out.println("Wrong choice. Please try again.");
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void displayAllStudents(StudentDAO studentDAO) throws SQLException {
        List<Student> students = studentDAO.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void addStudentFromConsole(StudentDAO studentDAO, Scanner scanner) {
        System.out.println("Enter the new student's data:");

        System.out.print("Surname: ");
        String studentSurname = scanner.next();

        System.out.print("Name: ");
        String studentName = scanner.next();

        System.out.print("PatronymicName: ");
        String studentPatronymicName = scanner.next();

        System.out.print("Date of birth(yyyy-mm-dd): ");
        String studentBirthday = scanner.next();

        System.out.print("The number of the  studentIDCard: ");
        String studentIDCard = scanner.next();

        try {
            studentDAO.addStudent(studentSurname, studentName, studentPatronymicName, studentBirthday, studentIDCard);
            System.out.println("Student added successfully.");
        } catch (SQLException exception) {
            System.out.println("Error adding a student: " + exception.getMessage());
        }
    }

    private static void searchStudentsByBirthMonth(StudentDAO studentDAO, Scanner scanner) throws SQLException {
        System.out.print("Enter the month of birth (1-12): ");
        int birthMonth = scanner.nextInt();

        List<Student> students = studentDAO.getStudentsByBirthMonth(birthMonth);

        if (students.isEmpty()) {
            System.out.println("No students were found.");
        } else {
            System.out.println("Students found by month of birth:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
