package api.services;

import api.base.BaseRequests;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static api.APIConstants.Lessons.ADD_LESSON;

public class AccountsServiceApi {

    protected BaseRequests requests;

    public AccountsServiceApi(){
        requests = new BaseRequests();
    }

    public Response registrationAccount(User user) throws JsonProcessingException {
        return requests.sendPost(ADD_LESSON, new ObjectMapper().writeValueAsString(user));
    }

}
