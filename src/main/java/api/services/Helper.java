package api.services;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.base.SecretaryRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Helper {

    protected static User user = User.getUserWithRandomValues();
    protected static AccountsServiceApi accountsService = new AccountsServiceApi();
    protected static MentorsServiceApi mentorsService;

    static {
        try {
            mentorsService = new MentorsServiceApi(new AdminRequests());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Helper() throws IOException {
    }

    public static RegisteredUser getMentor() throws JsonProcessingException {
        user = accountsService.registrationAccount(user).as(User.class);
        System.out.println(user);
        RegisteredUser mentor = mentorsService.postAssignMentor(user.getId()).as(RegisteredUser.class);
        return mentor;
    }
}
