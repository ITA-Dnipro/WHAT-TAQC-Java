package api.groups;

import api.base.AdminRequests;
import api.entities.groups.Group;
import api.services.AccountsServiceApi;
import api.services.GroupsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Groups_VerifyAddNewGroup_CorrectData_AsAdmin_Test {

    AdminRequests requests;
    Group group;

    @BeforeClass
    public void setUp() throws IOException {
        requests = new AdminRequests();
        group = Group.getGroupObject(new AccountsServiceApi(requests));
    }

    @Test
    public void addNewGroup() throws IOException {

        Response response = new GroupsServiceApi(requests)
                .addStudentGroup(group);

        Group addedGroup = response
                .then()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Group.class);

        assertThat(group).isEqualTo(addedGroup);
    }
}
