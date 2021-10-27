package api.services;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import page.lessons.LessonsPage;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import util.Role;

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

    private void initRole() throws IOException {
        addUserRole.put(Role.MENTOR.getRoleName(), new MentorsServiceApi(new AdminRequests()));
//        addUserRole.put(Role.STUDENT.getRoleName(), new LessonsPage(driver));
    }
    private RegisteredUser getUserWithRole(Role role, int id){
        RegisteredUser registeredUser = addUserRole
                .get(role.getRoleName())
                .postAssignMentor(id)
                .as(RegisteredUser.class);
        return registeredUser;
    }



}
