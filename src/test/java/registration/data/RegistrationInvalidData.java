package registration.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RegistrationInvalidData {

    private String firstName;
    private String firstNameError;
    private String lastName;
    private String lastNameError;
    private String email;
    private String emailError;
    private String password;
    private String passwordError;

    public static RegistrationInvalidData[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), RegistrationInvalidData[].class);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameError() {
        return firstNameError;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailError() {
        return emailError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

}
