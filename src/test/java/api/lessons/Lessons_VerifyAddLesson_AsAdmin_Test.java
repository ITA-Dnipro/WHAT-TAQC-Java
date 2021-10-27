package api.lessons;

import api.base.AdminRequests;
import api.services.LessonServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Lessons_VerifyAddLesson_AsAdmin_Test {

    LessonServiceApi lessonServiceApi;

    @BeforeClass
    public void setup() throws IOException {
        lessonServiceApi = new LessonServiceApi(new AdminRequests());
    }

    @Test
    public void addLessonAsAdmin(){
    }
}
