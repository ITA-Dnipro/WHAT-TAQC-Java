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

public class MentorsTablePage_VerifySortingOfDisableMentors extends BaseTest {
    MentorsTablePage mentorsTablePage;

    public MentorsTablePage_VerifySortingOfDisableMentors() {
        mentorsTablePage = new MentorsTablePage(driver);
    }

    @BeforeClass
    public void precondition() throws IOException {
        mentorsTablePage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime)
                .showDisableMentors();
    }

    @Test
    public void verifySort() {
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
                .verifySoftByEmailDEC();
    }

}


