package mentors.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class InvalidData {
    private String name;
    private String errorName;
    private String last_name;
    private String errorSurname;
    private String email;
    private String errorEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getErrorSurname() {
        return errorSurname;
    }

    public void setErrorSurname(String errorSurname) {
        this.errorSurname = errorSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }
    public static InvalidData[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), InvalidData[].class);
    }
}
