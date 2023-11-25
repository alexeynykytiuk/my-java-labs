package edu.ntudp.pzks.fourthLab.controllers;

import edu.ntudp.pzks.fourthLab.models.Department;
import edu.ntudp.pzks.fourthLab.models.Group;
import edu.ntudp.pzks.fourthLab.models.Human;

import java.util.List;

public class DepartmentCreator {
    public Department createDepartment(List<Group> groups, String departmentName, Human headOfDepartmentName) {
        Department newDepartment = new Department();
        newDepartment.setGroups(groups);
        newDepartment.setDepartmentName(departmentName);
        newDepartment.setHeadOfDepartmentName(headOfDepartmentName);
        return newDepartment;
    }
}
