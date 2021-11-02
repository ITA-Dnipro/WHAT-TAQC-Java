package api.entities.mentors;

import api.entities.users.RegisteredUser;

import java.util.Objects;

public class Mentor extends RegisteredUser {
    protected Integer[] courseIds;
    protected Integer[] studentGroupsIds;

    public Integer[] getCourseIds() {
        return courseIds;
    }

    public Mentor setCourseIds(Integer[] courseIds) {
        this.courseIds = courseIds;
        return this;
    }

    public Integer[] getStudentGroupsIds() {
        return studentGroupsIds;
    }

    public Mentor setStudentGroupsIds(Integer[] studentGroupsIds) {
        this.studentGroupsIds = studentGroupsIds;
        return this;
    }

    public Mentor setMentorFirstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Mentor setMentorLastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Mentor setMentorEmail(String email) {
        setEmail(email);
        return this;
    }
}
