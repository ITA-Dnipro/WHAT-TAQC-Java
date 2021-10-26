package secretarys;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.secretarys.SecretarysPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class SortingOfActiveSecretary extends BaseTest {
    SecretarysPage secretarysPage;

    public SortingOfActiveSecretary() {
        secretarysPage = new SecretarysPage(driver);
    }

    @BeforeClass
    public void setUp() throws IOException {
        secretarysPage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, SecretarysPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                .isAtPage(waitTime);

    }

    @Test(description = "")
    public void sortingOfActiveSecretary() {
        secretarysPage
                .sortByName()
                .verifySorttBySurNameASC()
                .sortByName()
                .verifySortByNameDEC()
                .sortByName()
                .verifySorttBySurNameASC()
                .sortByName()
                .verifySortBySurNameDEC()
                .sortByEmail()
                .verifySortByEmailASC()
                .sortByEmail()
                .verifySortByEmailDEC();
    }
}








