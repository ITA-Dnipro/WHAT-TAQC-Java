package lessons.data;

import java.util.List;

public class AddLessonJson {

    String themeName;
    int mentorId;
    int studentGroupId;
    List<ClassBookItem> lessonVisits;
    String lessonsDate;

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

    public String getLessonsDate() {
        return lessonsDate;
    }

    public void setLessonsDate(String lessonsDate) {
        this.lessonsDate = lessonsDate;
    }
}
