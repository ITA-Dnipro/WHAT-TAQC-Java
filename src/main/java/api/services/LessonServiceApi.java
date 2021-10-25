package api.services;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.lessons.AddLessonJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.PathsToFiles;
import io.restassured.response.Response;
import util.User;
import java.io.IOException;

public class LessonServiceApi {

    BaseRequests requests;
    String lessons = "/lessons";
    {
        try {
            requests = new AdminRequests(User.get(PathsToFiles.getPathToCredentials()).get("admin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response addLesson(AddLessonJson addLessonJson) throws JsonProcessingException {
        return requests.sendPost(lessons, new ObjectMapper().writeValueAsString(addLessonJson));
    }

    public Response getLessons(){
        return requests.sendGet(lessons);
    }
}
