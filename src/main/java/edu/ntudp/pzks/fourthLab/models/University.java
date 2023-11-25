package edu.ntudp.pzks.fourthLab.models;

import java.util.List;
import java.util.Objects;

public class University {
    private String universityName;
    private Human headOfUniversityName;
    private List<Faculty> faculties;

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setHeadOfUniversityName(Human headOfUniversityName) {
        this.headOfUniversityName = headOfUniversityName;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Human getHeadOfUniversityName() {
        return headOfUniversityName;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return "UniversityName = '" + universityName + '\'' + "\n" +
                "headOfUniversityName = " + headOfUniversityName + "\n" +
                "faculties = " + faculties + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        University that = (University) obj;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties);
    }
}
