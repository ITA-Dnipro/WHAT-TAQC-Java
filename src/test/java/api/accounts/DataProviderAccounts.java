package api.accounts;

import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderAccounts {

    private AccountsServiceApi accountsServiceApi;
    private RegisteredUser user;
    private static final Integer STUDENT_ROLE_ID = 1;
    private static final Integer MENTOR_ROLE_ID = 2;
    private static final Integer SECRETARY_ROLE_ID = 8;
    private static final String ROLE_NAME_STUDENT = "student";
    private static final String ROLE_NAME_MENTOR = "mentor";
    private static final String ROLE_NAME_SECRETARY = "secretary";
    private String password;

    public DataProviderAccounts() {
        accountsServiceApi = new AccountsServiceApi();
    }

    @DataProvider(name = "singIn")
    public Object[][] singInData() throws IOException {

        return new Object[][]{{getStudent(), STUDENT_ROLE_ID, ROLE_NAME_STUDENT},
                {getMentor(), MENTOR_ROLE_ID, ROLE_NAME_MENTOR},
                {getSecretary(), SECRETARY_ROLE_ID, ROLE_NAME_SECRETARY}};
    }

    private RegisteredUser getNewAccount() throws JsonProcessingException {
        User unassignedUser = User.getUserWithRandomValues();
        password = unassignedUser.getPassword();

        RegisteredUser registeredUser = accountsServiceApi
                .registrationAccount(unassignedUser)
                .as(RegisteredUser.class);

        return registeredUser;
    }

    private RegisteredUser getStudent() throws IOException {
        user = AccountsServiceApi.assignRoleStudent(getNewAccount());
        user.setPassword(password);
        return user;
    }

    private RegisteredUser getMentor() throws IOException {
        user = AccountsServiceApi.assignRoleMentor(getNewAccount());
        user.setPassword(password);
        return user;
    }

    private RegisteredUser getSecretary() throws IOException {
        user = AccountsServiceApi.assignRoleSecretary(getNewAccount());
        user.setPassword(password);
        return user;
    }

}
