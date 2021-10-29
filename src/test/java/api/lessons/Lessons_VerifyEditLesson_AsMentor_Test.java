package api.lessons;

import api.base.BaseRequests;
import api.base.MentorRequests;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static api.APIConstants.HEADERS;
import static api.APIConstants.dateFormatForGroup;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lessons_VerifyEditLesson_AsMentor_Test {

    Lesson lesson;
    BaseRequests requests;
    LessonServiceApi serviceApi;

    @BeforeTest
    public void setUp() throws IOException {
        requests = new MentorRequests();
        serviceApi = new LessonServiceApi(requests);
        lesson = serviceApi.addLesson(Lesson.getLessonObject()).as(Lesson.class);
    }

    @Test
    public void editLessonAsMentor() throws JsonProcessingException, CloneNotSupportedException {

        Lesson oldLesson = (Lesson) lesson.clone();

        lesson = serviceApi.editLesson(lesson.setLessonDate(LocalDateTime.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern(dateFormatForGroup)))
                        .setThemeName("NewTheme")) //Waiting for random string with random count)))
                .then()
                .log().all()
                .statusCode(200)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Lesson.class);

        assertThat(oldLesson).isNotEqualTo(lesson);
    }
}
