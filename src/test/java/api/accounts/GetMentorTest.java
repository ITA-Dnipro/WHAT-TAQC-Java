package api.accounts;

import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class GetMentorTest {


    public static void main(String[] args) throws IOException {
        getMentor();
        System.out.println("-------------------------------------------");
        getStudent();
    }

    private static void getMentor() throws IOException {
        User unassignedUser = User.getUserWithRandomValues();

        AccountsServiceApi serviceApi = new AccountsServiceApi();

        RegisteredUser mentor = serviceApi
                .registrationAccount(unassignedUser)
                .as(RegisteredUser.class);
        System.out.println("Mentor: " + mentor.toString());

        mentor = AccountsServiceApi.getMentor(mentor);

        System.out.println(mentor.toString());
    }
    private static void getStudent() throws IOException {
        User unassignedUser = User.getUserWithRandomValues();

        AccountsServiceApi serviceApi = new AccountsServiceApi();

        RegisteredUser student = serviceApi
                .registrationAccount(unassignedUser)
                .as(RegisteredUser.class);
        System.out.println(student.toString());

        student = AccountsServiceApi.getStudent(student);

        System.out.println(student.toString());
    }
}
