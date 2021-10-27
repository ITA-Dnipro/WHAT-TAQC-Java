package api.services;

import api.APIConstants;
import api.base.BaseRequests;
import api.entities.groups.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

public class GroupsService extends BaseService{

    public GroupsService(BaseRequests requests) {
        super(requests);
    }

    public Response addStudentGroup(Group group) throws JsonProcessingException {
        return requests.sendPost(APIConstants.StudentGroups.STUDENT_GROUPS,
                mapper.writeValueAsString(group));
    }
}
