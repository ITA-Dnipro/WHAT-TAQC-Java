package api.entities.lessons;

public class ClassBookItem {

    Integer studentId;
    Integer studentMark;
    boolean presence;
    String comment;

    public ClassBookItem() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public ClassBookItem setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public ClassBookItem setStudentMark(Integer studentMark) {
        this.studentMark = studentMark;
        return this;
    }

    public int getStudentMark() {
        return studentMark;
    }

    public boolean getPresence() {
        return presence;
    }

    public ClassBookItem setPresence(boolean presence) {
        this.presence = presence;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ClassBookItem setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "ClassBookItem{" +
                "studentId=" + studentId +
                ", studentMark=" + studentMark +
                ", presence=" + presence +
                ", comment='" + comment + '\'' +
                '}';
    }
}
