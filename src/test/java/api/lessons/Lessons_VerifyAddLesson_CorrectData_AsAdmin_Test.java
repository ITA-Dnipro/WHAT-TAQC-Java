package api.lessons;

import api.base.AdminRequests;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lessons_VerifyAddLesson_CorrectData_AsAdmin_Test {

    LessonServiceApi lessonServiceApi;

    @BeforeClass
    public void setup() throws IOException {
        lessonServiceApi = new LessonServiceApi(new AdminRequests());
    }

    @Test
    public void addLessonAsAdmin() throws IOException {

        Lesson lesson = Lesson.getLessonObject();

        Lesson addedLesson = lessonServiceApi
                .addLesson(lesson)
                .then()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Lesson.class);

        assertThat(lesson).isEqualTo(addedLesson);
    }
}
