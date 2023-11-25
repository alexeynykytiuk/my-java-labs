package edu.ntudp.pzks.fourthLab.controllers;

import edu.ntudp.pzks.fourthLab.models.Sex;
import edu.ntudp.pzks.fourthLab.models.Student;

public class StudentCreator {
    public Student createStudent(String lastName, String firstName, String patronymicName, Sex sex) {
        return new Student(lastName, firstName, patronymicName, sex);
    }
}
