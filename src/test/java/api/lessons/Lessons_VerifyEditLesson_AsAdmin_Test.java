package api.lessons;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static api.APIConstants.HEADERS;
import static api.APIConstants.dateFormatForGroup;
import static api.APIConstants.StatusCodes.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lessons_VerifyEditLesson_AsAdmin_Test {

    Lesson lesson;
    BaseRequests requests;
    LessonServiceApi serviceApi;

    @BeforeTest
    public void setUp() throws IOException {
        requests = new AdminRequests();
        serviceApi = new LessonServiceApi(requests);
        lesson = serviceApi.addLesson(Lesson.getLessonObject()).as(Lesson.class);
    }

    @Test
    public void editLessonAsAdmin() throws JsonProcessingException, CloneNotSupportedException {

        Lesson oldLesson = (Lesson) lesson.clone();

        lesson = serviceApi.editLesson(lesson.setLessonDate(LocalDateTime.now().minusDays(1)
                                .format(DateTimeFormatter.ofPattern(dateFormatForGroup)))
                        .setThemeName("NewTheme")) //Waiting for random string with random count)))
                .then()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Lesson.class);

        assertThat(oldLesson).isNotEqualTo(lesson);

    }
}
