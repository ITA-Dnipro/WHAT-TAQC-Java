package api.entities.lessons;

import java.util.List;

public class Lesson {

    Integer id;
    String themeName;
    Integer mentorId;
    Integer studentGroupId;
    List<ClassBookItem> lessonVisits;
    String lessonDate;


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

    public List<ClassBookItem> getLessonVisits() {
        return lessonVisits;
    }

    public Lesson setLessonVisits(List<ClassBookItem> lessonVisits) {
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
}
