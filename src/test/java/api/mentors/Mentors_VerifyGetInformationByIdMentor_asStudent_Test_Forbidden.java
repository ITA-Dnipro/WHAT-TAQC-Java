package api.mentors;

import api.base.AdminRequests;
import api.base.StudentRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.FORBIDDEN;

public class Mentors_VerifyGetInformationByIdMentor_asStudent_Test_Forbidden {

    User user;
    RegisteredUser registeredUser;
    RegisteredUser mentor;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    MentorsServiceApi mentorsServiceApiForbidden;

    public Mentors_VerifyGetInformationByIdMentor_asStudent_Test_Forbidden() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentorsServiceApiForbidden =new MentorsServiceApi(new StudentRequests());
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);

        mentor= mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }
    @Test
    public void verifyGetInformationByIdMentors() {
         mentorsServiceApiForbidden
                 .getMentorsById(mentor.getId())
                .then()
                .assertThat()
                .statusCode(FORBIDDEN);
    }
}
