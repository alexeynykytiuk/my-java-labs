package edu.ntudp.pzks.thirdLab.controllers;

import edu.ntudp.pzks.thirdLab.models.Department;
import edu.ntudp.pzks.thirdLab.models.Faculty;
import edu.ntudp.pzks.thirdLab.models.Human;

import java.util.List;

public class FacultyCreator {
    public Faculty createFaculty(List<Department> departments, String facultyName, Human headOfFacultyName) {
        Faculty newFaculty = new Faculty();
        newFaculty.setDepartments(departments);
        newFaculty.setFacultyName(facultyName);
        newFaculty.setHeadOfFacultyName(headOfFacultyName);
        return newFaculty;
    }
}
