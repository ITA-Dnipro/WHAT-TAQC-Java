package api.services;

import api.base.BaseRequests;
import api.APIConstants;
import api.base.BaseRequests;
import api.entities.lessons.AddLessonJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class MentorsServiceApi {
    BaseRequests requests;

    public Response getGroupOfMentor(Integer id) {
        return requests.sendGet(APIConstants.Mentors.MENTORS, APIConstants.Mentors.GROUPS, id);
    }

    public Response getActiveMentors() {
        return requests.sendGet(APIConstants.Mentors.ACTIVE_MENTORS);
    }

    public MentorsServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }
}
