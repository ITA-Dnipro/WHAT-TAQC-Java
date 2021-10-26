package api.entities.lessons;

import java.util.List;

public class AddLessonJson {

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

    public AddLessonJson setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
        return this;
    }

    public AddLessonJson setStudentGroupId(Integer studentGroupId) {
        this.studentGroupId = studentGroupId;
        return this;
    }

    public String getThemeName() {
        return themeName;
    }

    public AddLessonJson setThemeName(String themeName) {
        this.themeName = themeName;
        return this;
    }

    public int getMentorId() {
        return mentorId;
    }

    public AddLessonJson setMentorId(int mentorId) {
        this.mentorId = mentorId;
        return this;
    }

    public List<ClassBookItem> getLessonVisits() {
        return lessonVisits;
    }

    public AddLessonJson setLessonVisits(List<ClassBookItem> lessonVisits) {
        this.lessonVisits = lessonVisits;
        return this;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public AddLessonJson setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
        return this;
    }
}
