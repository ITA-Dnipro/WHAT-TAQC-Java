package changePassword.dataPasswords.data;

import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import page.changePassword.ChangePasswordPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordInvalidData extends BaseTest {

    private String currantPassword;
    private String currantPasswordResult;
    private String newPassword;
    private String newPasswordResult;
    private String confirmPassword;
    private String confirmPasswordResult;

    public String getCurrantPassword() {
        return currantPassword;
    }

    public String getCurrantPasswordResult() {
            return currantPasswordResult;
        }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordResult() {
        return newPasswordResult;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getConfirmPasswordResult() {
        return confirmPasswordResult;
    }

    public static ChangePasswordInvalidData[] getPasswordsList(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), ChangePasswordInvalidData[].class);
    }
}
