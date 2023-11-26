package edu.ntudp.pzks.fifthLab.model;

import java.sql.Date;

public class Student {
    private int studentID;
    private String studentSurname;
    private String studentName;
    private String studentPatronymic;
    private Date studentBirthday;
    private String studentIDCard;

    public Student(int studentID, String studentSurname, String studentName, String studentPatronymic, Date studentBirthday, String studentIDCard) {
        this.studentID = studentID;
        this.studentSurname = studentSurname;
        this.studentName = studentName;
        this.studentPatronymic = studentPatronymic;
        this.studentBirthday = studentBirthday;
        this.studentIDCard = studentIDCard;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPatronymic() {
        return studentPatronymic;
    }

    public void setStudentPatronymic(String studentPatronymic) {
        this.studentPatronymic = studentPatronymic;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentIDCard() {
        return studentIDCard;
    }

    public void setStudentIDCard(String studentIDCard) {
        this.studentIDCard = studentIDCard;
    }

    @Override
    public String toString() {
        return "studentID=" + studentID +
                ", studentSurname='" + studentSurname + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPatronymic='" + studentPatronymic + '\'' +
                ", studentBirthday=" + studentBirthday +
                ", studentIDCard='" + studentIDCard + '\'';
    }
}
