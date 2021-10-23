package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Sort extends BaseTest{


    UnassignedUsersPage unassignedUsersPage;

    public Sort() {
        unassignedUsersPage = new UnassignedUsersPage(driver);
    }

    @BeforeClass
    public void precondition() throws IOException {
        unassignedUsersPage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime);
    }
    @Test
    public void verifySoftByNameASC() {
        List<String> actualResult = unassignedUsersPage.sortByName().getUnassignedUsersName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
    @Test
    public void verifySoftByNameDEC() {
        List<String> actualResult = unassignedUsersPage.sortByName().getUnassignedUsersName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
    @Test
    public void verifySoftBySurNameASC() {
        List<String> actualResult = unassignedUsersPage.sortBySurName().getUnassignedUsersSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
    @Test
    public void verifySoftBySurNameDEC() {
        List<String> actualResult = unassignedUsersPage.sortBySurName().getUnassignedUsersSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
    @Test
    public void verifySoftByEmailASC() {
        List<String> actualResult = unassignedUsersPage.sortByEmail().getUnassignedUsersEmail();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
    @Test
    public void verifySoftEmailDEC() {
        List<String> actualResult = unassignedUsersPage.sortByEmail().getUnassignedUsersEmail();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        Assert.assertEquals(actualResult, expectResult);
    }
}
