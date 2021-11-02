package secretarys.UIsecretaryTest;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.secretarys.SecretarysPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListSecretaries_SortByDisableSecretary_AdminAndSecretary extends BaseTest {
    SecretarysPage secretarysPage;

    public ListSecretaries_SortByDisableSecretary_AdminAndSecretary(){
        secretarysPage =new SecretarysPage(driver);
    }

    @BeforeClass
    public void setUp() throws IOException{
        secretarysPage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                .isAtPage(waitTime)
                .showDisableSecretarys();

    }

    @Test (description = "")
    public void ListSecretaries_Sorting_AdminAndSecretary(){
        secretarysPage
                .sortByName()
                .verifySorttBySurNameASC()
                .sortByName()
                .verifySortByNameDEC()
                .sortByName()
                .verifySorttBySurNameASC()
                .sortBySurName()
                .verifySortBySurNameDEC()
                .sortByEmail()
                .verifySortByEmailASC()
                .sortByEmail()
                .verifySortBySurNameDEC();
    }
}
