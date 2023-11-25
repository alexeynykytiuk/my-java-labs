package edu.ntudp.pzks.fourthLab.controllers;

import edu.ntudp.pzks.fourthLab.models.Department;
import edu.ntudp.pzks.fourthLab.models.Faculty;
import edu.ntudp.pzks.fourthLab.models.Human;

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
