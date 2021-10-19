package registration.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RegistrationInvalidEmail {

    private String email;
    private String emailError;

    public static RegistrationInvalidEmail[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), RegistrationInvalidEmail[].class);
    }

    public String getEmail() {
        return email;
    }

    public String getEmailError() {
        return emailError;
    }
}
