package api.entities.groups;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static Group getGroupObject() throws IOException {
        return new Group()
                .setName(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(
                                (int) (Math.random() *
                                        (maxSizeOfCourseName - minSizeOfCourseName)) + minSizeOfCourseName))
                .setCourseId(new CoursesServiceApi(new AdminRequests())
                        .addCourse(Course.getCourseWithRandomName())
                        .as(Course.class).getId())
                .setStartDate(new SimpleDateFormat(dateFormatForGroup).format(new Date()));
    //            .setStudentIds(new Integer[]{})
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
}
