package edu.ntudp.pzks.thirdLab.controllers;

import edu.ntudp.pzks.thirdLab.models.Group;
import edu.ntudp.pzks.thirdLab.models.Human;
import edu.ntudp.pzks.thirdLab.models.Student;

import java.util.List;

public class GroupCreator {
    public Group createGroup(List<Student> students, String groupName, Human headOfGroupName) {
        Group newGroup = new Group();
        newGroup.setStudents(students);
        newGroup.setGroupName(groupName);
        newGroup.setHeadOfGroup(headOfGroupName);
        return newGroup;
    }
}
