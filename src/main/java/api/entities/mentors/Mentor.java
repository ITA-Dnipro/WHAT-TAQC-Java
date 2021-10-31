package api.entities.mentors;

import api.entities.users.RegisteredUser;

public class Mentor extends RegisteredUser {
    protected Integer[] courseIds;
    protected Integer[] studentGroupsIds;

    public Integer[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(Integer[] courseIds) {
        this.courseIds = courseIds;
    }

    public Integer[] getStudentGroupsIds() {
        return studentGroupsIds;
    }

    public void setStudentGroupsIds(Integer[] studentGroupsIds) {
        this.studentGroupsIds = studentGroupsIds;
    }
}
