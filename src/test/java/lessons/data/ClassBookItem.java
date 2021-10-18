package lessons.data;

public class ClassBookItem {

    Integer studentId;
    Integer studentMark;
    boolean presence;
    String comment;

    public ClassBookItem() {
    }

    public ClassBookItem(Integer studentId) {
        this.studentId = studentId;
        this.presence = false;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentMark(Integer studentMark) {
        this.studentMark = studentMark;
    }

    public int getStudentMark() {
        return studentMark;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
