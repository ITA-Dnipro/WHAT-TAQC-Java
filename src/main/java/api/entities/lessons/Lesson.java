package api.entities.lessons;

import api.base.AdminRequests;
import api.entities.groups.Group;
import api.services.AccountsServiceApi;
import api.services.GroupsServiceApi;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static api.APIConstants.dateFormat;

public class Lesson implements Cloneable{

    public static final Integer minLengthOfThemeName = 1;
    public static final Integer maxLengthOfThemeName = 100;
    public static final Integer minLengthOfComment = 0;
    public static final Integer maxLengthOfComment = 1024;
    public static final Integer minMark = 1;
    public static final Integer maxMark = 12;
    public static final Integer firstItem = 0;

    Integer id;
    String themeName;
    Integer mentorId;
    Integer studentGroupId;
    ClassBookItem[] lessonVisits;
    String lessonDate;


    public static int getRandomNumberFromRange(Integer min, Integer max){
        return (int) (Math.random() *
                (max - min)) + min;
    }

    public static Lesson getLessonObject() throws IOException {

        Group group = new GroupsServiceApi(new AdminRequests())
                .addStudentGroup(Group.getGroupObject(new AccountsServiceApi(new AdminRequests()))).as(Group.class);

        return new Lesson()
                .setThemeName(RandomStringsGenerator
                    .getAlphabeticStringLowerCaseCharacters(
                        getRandomNumberFromRange(minLengthOfThemeName, maxLengthOfThemeName)))
                .setMentorId(group.getMentorIds()[firstItem])
                .setStudentGroupId(group.getId())
                .setLessonVisits(new ClassBookItem[]{new ClassBookItem().setStudentId(group.getStudentIds()[firstItem])
                        .setPresence(true).setStudentMark(getRandomNumberFromRange(minMark, maxMark))
                        .setComment(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(
                                getRandomNumberFromRange(minLengthOfComment, maxLengthOfComment)))})
                .setLessonDate(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern(dateFormat)));
    }

    //region Getters and Setters
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
        return this;
    }

    public Lesson setStudentGroupId(Integer studentGroupId) {
        this.studentGroupId = studentGroupId;
        return this;
    }

    public String getThemeName() {
        return themeName;
    }

    public Lesson setThemeName(String themeName) {
        this.themeName = themeName;
        return this;
    }

    public int getMentorId() {
        return mentorId;
    }

    public Lesson setMentorId(int mentorId) {
        this.mentorId = mentorId;
        return this;
    }

    public ClassBookItem[] getLessonVisits() {
        return lessonVisits;
    }

    public Lesson setLessonVisits(ClassBookItem[] lessonVisits) {
        this.lessonVisits = lessonVisits;
        return this;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public Lesson setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
        return this;
    }

    public Integer getStudentGroupId() {
        return studentGroupId;
    }
//endregion

    @Override
    public Lesson clone() throws CloneNotSupportedException {
        return (Lesson) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return  lesson.id != null &&
                Objects.equals(themeName, lesson.themeName) &&
                Objects.equals(mentorId, lesson.mentorId) &&
                Objects.equals(studentGroupId, lesson.studentGroupId) &&
                Objects.equals(lessonDate, lesson.lessonDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeName, mentorId, studentGroupId, lessonDate);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", themeName='" + themeName + '\'' +
                ", mentorId=" + mentorId +
                ", studentGroupId=" + studentGroupId +
                ", lessonVisits=" + lessonVisits +
                ", lessonDate='" + lessonDate + '\'' +
                '}';
    }
}
