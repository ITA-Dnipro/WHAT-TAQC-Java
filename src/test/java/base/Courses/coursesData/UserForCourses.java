package base.Courses.coursesData;

public class UserForCourses {

    private String mail;
    private String pass;

    public UserForCourses(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
