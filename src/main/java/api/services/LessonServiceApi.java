package api.services;

import api.APIConstants;
import api.base.BaseRequests;
import api.entities.lessons.AddLessonJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import static api.APIConstants.Lessons.ADD_LESSON;

public class LessonServiceApi {

    BaseRequests requests;

    public LessonServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public Response addLesson(AddLessonJson addLessonJson) throws JsonProcessingException {
        return requests.sendPost(ADD_LESSON, new ObjectMapper().writeValueAsString(addLessonJson));
    }

    public Response getLessons(){
        return requests.sendGet(APIConstants.Lessons.LESSONS);
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }
}
