package edu.ntudp.pzks.fourthLab.models;

import java.util.List;
import java.util.Objects;

public class Department {
    private String departmentName;
    private Human headOfDepartmentName;
    private List<Group> groups;


    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setHeadOfDepartmentName(Human headOfDepartmentName) {
        this.headOfDepartmentName = headOfDepartmentName;
    }


    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Human getHeadOfDepartmentName() {
        return headOfDepartmentName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "departmentName = '" + departmentName + '\'' + "\n" +
                "headOfDepartmentName = " + headOfDepartmentName + "\n" +
                "groups = " + groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) && Objects.equals(headOfDepartmentName, that.headOfDepartmentName) && Objects.equals(groups, that.groups);
    }

}
