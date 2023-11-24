package edu.ntudp.pzks.thirdLab.controllers;

import edu.ntudp.pzks.thirdLab.models.Sex;
import edu.ntudp.pzks.thirdLab.models.Student;

public class StudentCreator {
    public Student createStudent(String lastName, String firstName, String patronymicName, Sex sex) {
        return new Student(lastName, firstName, patronymicName, sex);
    }
}
