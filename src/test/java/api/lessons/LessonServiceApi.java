package api.lessons;

import api.base.request.AdminRequests;
import api.base.request.BaseRequests;
import lessons.data.AddLessonJson;
import util.User;

public class LessonServiceApi implements LessonsService {

    BaseRequests requests = new AdminRequests(new User("james.smith@example.com", "_JkcG9dB"));

    @Override
    public <T> T addLesson(AddLessonJson addLessonJson) {
        return null;
    }

    public AddLessonJson[] getLessons(){

        return requests.sendGet("/lessons").getBody().as(AddLessonJson[].class);
    }
}
