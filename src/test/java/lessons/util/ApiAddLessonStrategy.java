package lessons.util;

import api.entities.UserApi;
import constants.PathsToFiles;
import util.User;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiAddLessonStrategy implements AddLessonStrategy{

    final String endpoint = "https://charliebackendapi.azurewebsites.net/api/v1/lessons";
    final String path = PathsToFiles.Lessons.ADD_NEW_LESSON;

    @Override
    public boolean addNewLesson(User user) throws Exception {
        UserApi userApi = HttpHelper.logInAPI(user);

        return HttpHelper.postRequest(endpoint, new String(Files.readAllBytes(
                Paths.get(path))),
                userApi.getToken());
    }
}
