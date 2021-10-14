package util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Users {

    @JsonProperty
    Admin admin;

    static class Admin {
        @JsonProperty
        String mail;

        @JsonProperty
        String pass;

    }

    @JsonProperty
    Mentor mentor;

    static class Mentor {
        @JsonProperty
        String mail;

        @JsonProperty
        String pass;
    }
    public static Users get(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), Users.class);
    }
}
