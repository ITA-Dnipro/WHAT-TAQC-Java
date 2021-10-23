package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class User {

    protected String mail;
    protected String pass;

    public User() {
    }

    public User(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    public String getMail(){
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

    public static Map<String, User> get(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename),
                new TypeReference<Map<String, User>>() {});
    }

    @Override
    public String toString() {
        return "{ \"email\": \"" + mail +"\", \"password\":\"" + pass + "\"}";
    }
}
