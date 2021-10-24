package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.Pagination;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class PaginationUnassigned extends BaseTest {
    private UnassignedUsersPage unassignedUsersPage = new UnassignedUsersPage(driver);
    protected final Logger log = Logger.getLogger(getClass());

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void verifyPaginationInUnassignedUsersPage() throws IOException {
        waitTime = 10;
        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime);
        driver.get("http://localhost:8080/unassigned");

        int numberOfUsersOnTheSecondPage = unassignedUsersPage
                .clickOnPaginationPage(2)
                .getNumberOfUsersOnThePage();
        Assert.assertEquals(numberOfUsersOnTheSecondPage, 10);
        int numberOfUsersOnTheThirdPage = unassignedUsersPage
                .clickOnPaginationPage(3)
                .getNumberOfUsersOnThePage();
        Assert.assertEquals(numberOfUsersOnTheThirdPage, 10);
        unassignedUsersPage.clickOnBackArrow(2);

    }
}
