package constants;

public class ErrorMessages {

    public interface GetChangePasswordErrorMessage {
        String CURRENT_PASSWORD_ERROR_XPATH = "//input[@id='currentPassword']/following-sibling::div";
        String NEW_PASSWORD_ERROR_PROVIDE_XPATH = "//input[@id='newPassword']/following-sibling::div";
        String CONFIRM_PASSWORD_ERROR_XPATH = "//input[@id='confirmNewPassword']/following-sibling::div";
    }

    public interface GetEditCourseErrorMessage {
        String COURSE_NAME_ERROR_MESSAGE_XPATH = "//p[contains(.,'Too long')]";
    }

    public interface AlertMessage {
        String ALERT_CHANGE_PASSWORD_XPATH = "//div[contains(@class,'alert-dismissible show')]";
    }
}
