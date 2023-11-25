package edu.ntudp.pzks.fourthLab.models;

import java.util.List;
import java.util.Objects;

public class Group {
    private String groupName;
    private Human headOfGroup;
    private List<Student> students;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setHeadOfGroup(Human headOfGroup) {
        this.headOfGroup = headOfGroup;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public Human getHeadOfGroup() {
        return headOfGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "groupName = '" + groupName + '\'' + "\n" +
                "headOfGroup = " + headOfGroup + "\n" +
                "students = " + students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return Objects.equals(groupName, group.groupName) && Objects.equals(headOfGroup, group.headOfGroup) && Objects.equals(students, group.students);
    }


}
