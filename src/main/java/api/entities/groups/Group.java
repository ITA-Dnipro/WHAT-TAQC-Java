package api.entities.groups;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.CoursesServiceApi;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import static api.APIConstants.dateFormatForGroup;

public class Group {

    private static final Integer minSizeOfCourseName = 1;
    private static final Integer maxSizeOfCourseName = 100;


    Integer id;
    String name;
    Integer courseId;
    String startDate;
    String finishDate;
    Integer[] studentIds;
    Integer[] mentorIds;

    public static Group getGroupObject(AccountsServiceApi accountsServiceApi) throws IOException {

        return new Group()
                .setName(RandomStringsGenerator
                .getAlphabeticStringLowerCaseCharacters(
                        (int) (Math.random() *
                                (maxSizeOfCourseName - minSizeOfCourseName)) + minSizeOfCourseName))
                .setCourseId(new CoursesServiceApi(new AdminRequests())
                        .addCourse(Course.getCourseWithRandomName())
                        .as(Course.class).getId())
                .setStartDate(new SimpleDateFormat(dateFormatForGroup).format(new Date()))
                .setFinishDate(new SimpleDateFormat(dateFormatForGroup).format(new Date()))
                .setStudentIds(new Integer[]{
                        AccountsServiceApi
                        .getStudent(accountsServiceApi
                                .registrationAccount(User.getUserWithRandomValues())
                                .as(RegisteredUser.class)).getId()})
                .setMentorIds(new Integer[]{AccountsServiceApi
                        .getMentor(accountsServiceApi
                                .registrationAccount(User.getUserWithRandomValues())
                                .as(RegisteredUser.class)).getId()});
    }

    //region Getters and Setters
    public Integer getId() {
        return id;
    }

    public Group setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Group setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Group setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public Group setFinishDate(String finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public Integer[] getStudentIds() {
        return studentIds;
    }

    public Group setStudentIds(Integer[] studentIds) {
        this.studentIds = studentIds;
        return this;
    }

    public Integer[] getMentorIds() {
        return mentorIds;
    }

    public Group setMentorIds(Integer[] mentorIds) {
        this.mentorIds = mentorIds;
        return this;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return  group.id != null &&
                Objects.equals(name, group.name) &&
                Objects.equals(courseId, group.courseId) &&
                Objects.equals(startDate, group.startDate) &&
                Objects.equals(finishDate, group.finishDate) &&
                Arrays.equals(studentIds, group.studentIds) &&
                Arrays.equals(mentorIds, group.mentorIds);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, courseId, startDate, finishDate);
        result = 31 * result + Arrays.hashCode(studentIds);
        result = 31 * result + Arrays.hashCode(mentorIds);
        return result;
    }
}
