package lessons.data;

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

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public void setStudentGroupId(Integer studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(int studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public List<ClassBookItem> getLessonVisits() {
        return lessonVisits;
    }

    public void setLessonVisits(List<ClassBookItem> lessonVisits) {
        this.lessonVisits = lessonVisits;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }
}
