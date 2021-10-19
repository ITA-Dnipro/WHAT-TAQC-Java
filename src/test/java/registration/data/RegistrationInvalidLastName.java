package registration.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RegistrationInvalidLastName {

    private String lastName;
    private String lastNameError;

    public static RegistrationInvalidLastName[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), RegistrationInvalidLastName[].class);
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameError() {
        return lastNameError;
    }
}
