package students;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class StudentsPage_VerifyAddStudentButtonDoesntExist_MentorRole extends BaseTest {

    @Test
    public void verifyAddStudentButtonIsDisabledForMentor() throws IOException {
        StudentsPage studentsPage = AuthPage.init(driver)
                .logInAs(Role.MENTOR, MentorsTablePage.class)
                .redirectTo(Endpoints.STUDENTS, StudentsPage.class);

        Assert.assertFalse(studentsPage.verifyAddStudentButtonIsEnable());
    }
}
