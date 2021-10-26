package api.lessons;

import api.base.SecretaryRequests;
import api.services.LessonServiceApi;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class Lessons_VerifyGettingListOfLessons_AsSecretary_Test {

    LessonServiceApi lessonServiceApi;

    @BeforeClass
    public void setup() throws IOException {
        lessonServiceApi = new LessonServiceApi(new SecretaryRequests());
    }

    @org.testng.annotations.Test
    public void getLessons() {
        lessonServiceApi.getLessons()
                .then().assertThat()
                .statusCode(200);
    }
}