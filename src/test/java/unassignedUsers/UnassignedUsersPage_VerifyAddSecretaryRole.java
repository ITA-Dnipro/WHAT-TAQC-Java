package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.secretarys.SecretarysPage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UnassignedUsersPage_VerifyAddSecretaryRole extends BaseTest {
    private UnassignedUser secretary;

    @BeforeClass
    public void setUp (){
        secretary = UnassignedUser.getUnassignedUser();
    }
    @Test
    public void verifyAddSecretaryRole() throws IOException {
        List<String> actualData= AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(secretary)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
                .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                .inputSearchSecretary("a")
                .inputSearchSecretary(secretary.getFirstName()+" "+ secretary.getLastName())
                .getSecretaryData();
        List<String> exceptData= Arrays.asList(secretary.getFirstName(),secretary.getLastName(),secretary.getEmail());
        Assert.assertEquals(actualData,exceptData);
    }

}