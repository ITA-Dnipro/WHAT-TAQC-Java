package registration.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lessons.data.EditLessonError;

import java.io.File;
import java.io.IOException;

public class RegistrationInvalidFirstName {

    private String firstName;
    private String firstNameError;

    public static RegistrationInvalidFirstName[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), RegistrationInvalidFirstName[].class);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameError() {
        return firstNameError;
    }
}
