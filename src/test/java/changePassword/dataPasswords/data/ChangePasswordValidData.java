package changePassword.dataPasswords.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ChangePasswordValidData {

    private String newPassword;

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public static ChangePasswordValidData[] passwordsList(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), ChangePasswordValidData[].class);
    }
}
