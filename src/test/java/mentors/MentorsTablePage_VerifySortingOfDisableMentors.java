package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
    public void verifySoftByNameASC() {
        List<String> actualResult = mentorsTablePage.sortByName().getMentorsName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

    @Test
    public void verifySoftByNameDEC() {
        List<String> actualResult = mentorsTablePage.sortByName().getMentorsName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

    @Test
    public void verifySoftBySurNAmeASC() {
        List<String> actualResult = mentorsTablePage.sortBySurname().getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

    @Test
    public void verifySoftBySurNameDEC() {
        List<String> actualResult = mentorsTablePage.sortBySurname().getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

    @Test
    public void verifySoftByEmailASC() {
        List<String> actualResult = mentorsTablePage.sortByEmail().getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

    @Test
    public void verifySoftByEmailDEC() {
        List<String> actualResult = mentorsTablePage.sortByEmail().getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }

}


