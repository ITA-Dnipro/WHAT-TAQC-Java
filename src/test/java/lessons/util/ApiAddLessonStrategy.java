package lessons.util;

import api.base.AdminRequests;
import api.entities.lessons.Lesson;
import api.entities.users.RegisteredUser;
import api.services.LessonServiceApi;
import constants.PathsToFiles;
import util.User;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiAddLessonStrategy implements AddLessonStrategy{

    @Override
    public boolean addNewLesson(User user) throws Exception {
        RegisteredUser userApi = new AdminRequests().getRegisteredUser();
        return new LessonServiceApi(new AdminRequests()).addLesson(Lesson.getLessonObject()).as(Lesson.class) != null;
    }
}
