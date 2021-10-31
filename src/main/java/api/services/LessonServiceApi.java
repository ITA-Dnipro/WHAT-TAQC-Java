package api.services;

import api.base.BaseRequests;
import api.entities.lessons.Lesson;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

import static api.APIConstants.Lessons.*;

public class LessonServiceApi extends BaseService{


    public LessonServiceApi(BaseRequests requests) {
        super(requests);
    }

    public Response addLesson(Lesson lesson) throws JsonProcessingException {
        return requests.sendPost(LESSONS, mapper.writeValueAsString(lesson));
    }

    public Response editLesson(Lesson lesson) throws JsonProcessingException {
        return requests.sendPut(LESSONS, lesson.getId(), mapper.writeValueAsString(lesson));
    }

    public Response getLessons(){
        return requests.sendGet(LESSONS);
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }
}
