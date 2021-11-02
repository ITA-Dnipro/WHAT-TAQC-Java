package api.services;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static api.APIConstants.AccountEndpoints.*;

public class AccountsServiceApi {

    protected BaseRequests request;
    protected Map<String, MentorsServiceApi> addUserRole;

    public AccountsServiceApi(BaseRequests request) {
        this.request = request;
    }

    public AccountsServiceApi() {
        request = new BaseRequests();
    }

    public Response registrationAccount(User user) throws JsonProcessingException {
        return request.sendPost(REGISTRATION, new ObjectMapper().writeValueAsString(user));
    }

    public Response getAllRegisteredAccounts() {
        return request.sendGet(GET_ALL_REGISTERED_USERS);
    }

    public static RegisteredUser getMentor(RegisteredUser registeredUser) throws IOException {
        return new MentorsServiceApi(new AdminRequests())
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }
    public static RegisteredUser getStudent(RegisteredUser registeredUser) throws IOException {
        return new StudentServiceApi(new AdminRequests())
                .postAssignStudent(registeredUser.getId())
                .as(RegisteredUser.class);
    }

}
