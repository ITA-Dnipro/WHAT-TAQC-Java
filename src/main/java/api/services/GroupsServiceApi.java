package api.services;

import api.base.BaseRequests;
import api.entities.groups.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import static api.APIConstants.StudentGroups.STUDENT_GROUPS;

public class GroupsServiceApi extends BaseService{

    public GroupsServiceApi(BaseRequests requests) {
        super(requests);
    }

    public Response addStudentGroup(Group group) throws JsonProcessingException {
        return requests.sendPost(STUDENT_GROUPS,
                mapper.writeValueAsString(group));
    }
}
