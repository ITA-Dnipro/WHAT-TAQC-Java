package util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Roles {

    @JsonProperty
    Admin admin;

    public static class Admin {
        @JsonProperty
        String mail;

        @JsonProperty
        String pass;

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

    @JsonProperty
    Mentor mentor;

    static class Mentor extends Admin{
        @JsonProperty
        String mail;

        @JsonProperty
        String pass;

    }
    public static Roles get(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), Roles.class);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
