package edu.ntudp.pzks.fourthLab.models;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private String facultyName;
    private Human headOfFacultyName;
    private List<Department> departments;

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setHeadOfFacultyName(Human headOfFacultyName) {
        this.headOfFacultyName = headOfFacultyName;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Human getHeadOfFacultyName() {
        return headOfFacultyName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "facultyName = '" + facultyName + '\'' + "\n" +
                "headOfFacultyName = " + headOfFacultyName + "\n" +
                "departments = " + departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyName, faculty.facultyName) && Objects.equals(headOfFacultyName, faculty.headOfFacultyName) && Objects.equals(departments, faculty.departments);
    }

}
