package api.services;

import api.base.BaseRequests;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static api.APIConstants.AccountEndpoints.GET_ALL_REGISTERED_USERS;
import static api.APIConstants.AccountEndpoints.REGISTRATION;

public class AccountsServiceApi {

    protected BaseRequests request;

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

}
