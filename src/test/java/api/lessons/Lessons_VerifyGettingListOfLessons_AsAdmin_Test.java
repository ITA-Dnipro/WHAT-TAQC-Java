package api.lessons;

import api.base.AdminRequests;
import api.base.SecretaryRequests;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.*;
import java.io.IOException;

import static api.APIConstants.Headers.*;

public class Lessons_VerifyGettingListOfLessons_AsAdmin_Test {

    LessonServiceApi lessonServiceApi;

    @BeforeClass
    public void setup() throws IOException {
        lessonServiceApi = new LessonServiceApi(new AdminRequests());
    }

    @Test
    public void getLessons() {

        Response response = lessonServiceApi.getLessons();
        response
                .then().assertThat()
                .statusCode(200)
                .assertThat()
                .header(CONTENT_TYPE, "application/json; charset=utf-8");

        response.as(Lesson[].class);
    }
}
