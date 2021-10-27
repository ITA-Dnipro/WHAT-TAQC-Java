package api.services;

import api.entities.users.RegisteredUser;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Helper {

    User user = User.getUserWithRandomValues();
    protected AccountsServiceApi accountsService;

    public RegisteredUser getUser() throws JsonProcessingException {
        User userReg = accountsService.registrationAccount(user).as(User.class);


                return new RegisteredUser();
    }
}
