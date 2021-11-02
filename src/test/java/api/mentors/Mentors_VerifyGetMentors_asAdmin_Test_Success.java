package api.mentors;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.Assertions.assertThat;

public class Mentors_VerifyGetMentors_asAdmin_Test_Success {
    User user;
    RegisteredUser registeredUser;
    RegisteredUser mentorAssign;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    RegisteredUser[] listOfMentors;

    public Mentors_VerifyGetMentors_asAdmin_Test_Success() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentorAssign = mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }

    @Test
    public void verifyGetMentors() {
        listOfMentors = mentorsServiceApi
                .getMentors()
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .as(RegisteredUser[].class);
        for (RegisteredUser mentorFromList : listOfMentors) {
            if (mentorFromList.getId().equals(mentorAssign.getId())) {
                assertThat(mentorFromList).isEqualTo(mentorAssign);
            }
        }
    }
    @AfterClass
    public void tearDown(){
        mentorsServiceApi.deleteMentor(mentorAssign.getId());
    }
}
