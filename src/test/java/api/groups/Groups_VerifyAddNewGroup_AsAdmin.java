package api.groups;

import api.base.AdminRequests;
import api.entities.groups.Group;
import api.services.AccountsServiceApi;
import api.services.GroupsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Groups_VerifyAddNewGroup_AsAdmin {

    AdminRequests requests;

    @BeforeClass
    public void setUp() throws IOException {
        requests = new AdminRequests();
    }

    @Test
    public void addNewGroup() throws IOException {
        new GroupsService(requests)
                .addStudentGroup(Group.getGroupObject
                        (new AccountsServiceApi(requests))).peek()
                .then().statusCode(200);
    }
}
