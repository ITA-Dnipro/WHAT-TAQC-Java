package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class MentorsTablePage_VerifySortingOfActiveMentors_AdminRole extends BaseTest {
    MentorsTablePage mentorsTablePage;

    public MentorsTablePage_VerifySortingOfActiveMentors_AdminRole() {
        mentorsTablePage = new MentorsTablePage(driver);
    }

    @BeforeClass
    public void setUp() throws IOException {
        mentorsTablePage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-67")
    public void verifySortingOfActiveMentors() {
        mentorsTablePage
                 .sortByName()
                .verifySoftByNameASC()
                .sortByName()
                .verifySoftByNameDEC()
                .sortBySurname()
                .verifySoftBySurNameASC()
                .sortBySurname()
                .verifySoftBySurNameDEC()
                .sortByEmail()
                .verifySoftByEmailASC()
                .sortByEmail()
                .verifySoftByEmailDEC()
                .assertAll();
    }
}
