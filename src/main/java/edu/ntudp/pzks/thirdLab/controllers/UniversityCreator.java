package edu.ntudp.pzks.thirdLab.controllers;

import edu.ntudp.pzks.thirdLab.models.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityCreator {
    private static final StudentCreator newStudent = new StudentCreator();
    private static final GroupCreator newGroup = new GroupCreator();
    private static final DepartmentCreator newDepartment = new DepartmentCreator();
    private static final FacultyCreator newFaculty = new FacultyCreator();

    public static University createUniversity(List<Faculty> faculties, String universityName, Human headOfUniversityName) {
        University newUniversity = new University();
        newUniversity.setFaculties(faculties);
        newUniversity.setUniversityName(universityName);
        newUniversity.setHeadOfUniversityName(headOfUniversityName);
        return newUniversity;
    }

    public static University createTypicalUniversity() {
        Human headOfPZKSName = new Human("Alekseev", "Mikhail", "Alekseev", Sex.MALE);
        Human headOfSAUName = new Human("Zheldak", "Timur", "Anatoliyovych", Sex.MALE);
        Human headOfFacultyName = new Human("Udovyk", "Irina", "Mikhailovna", Sex.FEMALE);
        Human headOfUniversityName = new Human("Azyukovsky", "Alexander", "Oleksandrovych", Sex.MALE);

        Student firstStudent = newStudent.createStudent("Nikitiuk", "Oleksii", "Volodymyrovych", Sex.MALE);
        Student secondStudent = newStudent.createStudent("Tereshchenko", "Anastasiia", "Serhiivna", Sex.FEMALE);
        Student thirdStudent = newStudent.createStudent("Maznichenko", "Ilya", "Vadymovych", Sex.MALE);
        Student fourthStudent = newStudent.createStudent("Borysenko", "Bohdan", "Yuriiovych", Sex.MALE);
        Student fifthStudent = newStudent.createStudent("Sidorov", "Dmytro", "Valeriyovych", Sex.MALE);
        Student sixthStudent = newStudent.createStudent("Zabroda", " Oleksandr", "Serhiiovych", Sex.MALE);
        Student seventhStudent = newStudent.createStudent("Gorbenko", "Maksym", "Mykhailovych", Sex.MALE);
        Student eighthStudent = newStudent.createStudent("Bantiuk ", "Ihor", "Ihorovych", Sex.MALE);
        Student ninthStudent = newStudent.createStudent("Tyshchenko", "Andrii", "Volodymyrovych", Sex.MALE);

        List<Student> studentsOfGroupComputerScience = new ArrayList<>();
        studentsOfGroupComputerScience.add(firstStudent);
        studentsOfGroupComputerScience.add(secondStudent);
        studentsOfGroupComputerScience.add(thirdStudent);
        studentsOfGroupComputerScience.add(fourthStudent);
        studentsOfGroupComputerScience.add(fifthStudent);
        studentsOfGroupComputerScience.add(sixthStudent);

        List<Student> studentsOfGroupSystemAnalynisis = new ArrayList<>();
        studentsOfGroupSystemAnalynisis.add(seventhStudent);
        studentsOfGroupSystemAnalynisis.add(eighthStudent);

        List<Student> studentsOfGroupSoftwareEngineering = new ArrayList<>();
        studentsOfGroupSoftwareEngineering.add(ninthStudent);


        Group firstGroup = createGroup("122-21SC-1", firstStudent, studentsOfGroupComputerScience);
        Group secondGroup = createGroup("124-21SC-1", seventhStudent, studentsOfGroupSystemAnalynisis);
        Group thirdGroup = createGroup("121-21SC-1", ninthStudent, studentsOfGroupSoftwareEngineering);

        List<Group> groupsOfPZKS = new ArrayList<>();
        groupsOfPZKS.add(firstGroup);
        groupsOfPZKS.add(thirdGroup);

        List<Group> groupsOfSau = new ArrayList<>();
        groupsOfSau.add(secondGroup);

        Department firstDepartment = createDepartment("PZKS", headOfPZKSName, groupsOfPZKS);
        Department secondDepartment = createDepartment("SAU", headOfSAUName, groupsOfSau);

        List<Department> departments = new ArrayList<>();
        departments.add(firstDepartment);
        departments.add(secondDepartment);

        Faculty newFaculty = createFaculty("FIT", headOfFacultyName, departments);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(newFaculty);

        return createUniversity(faculties, "Dnipro University of Technology", headOfUniversityName);

    }

    private static Group createGroup(String groupCode, Human headOfGroupName, List<Student> students) {
        return newGroup.createGroup(students, groupCode, headOfGroupName);
    }

    private static Department createDepartment(String departmentName, Human headOfDepartmentName, List<Group> groups) {
        return newDepartment.createDepartment(groups, departmentName, headOfDepartmentName);
    }

    private static Faculty createFaculty(String facultyName, Human headOfFacultyName, List<Department> departments) {
        return newFaculty.createFaculty(departments, facultyName, headOfFacultyName);
    }
}
