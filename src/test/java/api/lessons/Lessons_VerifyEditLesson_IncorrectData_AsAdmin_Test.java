package api.lessons;

import api.APIConstants;
import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.error.Error;
import api.entities.error.ResponseError;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static api.APIConstants.*;
import static api.APIConstants.StatusCodes.BAD_REQUEST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lessons_VerifyEditLesson_IncorrectData_AsAdmin_Test {

    Lesson lesson;
    BaseRequests requests;
    LessonServiceApi serviceApi;
    static final Integer overSizeOfThemeName = 101;
    static final String futureDate = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern(dateFormat));

    @BeforeTest
    public void setUp() throws IOException {
        requests = new AdminRequests();
        serviceApi = new LessonServiceApi(requests);
        lesson = serviceApi.addLesson(Lesson.getLessonObject()).as(Lesson.class);
    }

    @DataProvider(name = "lesson")
    public Object[][] provide() throws CloneNotSupportedException {
        return new Object[][]{
                {lesson.clone().setLessonDate(futureDate),
                        new ResponseError(new Error().setMessage(Lessons.BAD_DATE_MESSAGE))},

                {lesson.clone().setThemeName(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(overSizeOfThemeName)),
                        new ResponseError(new Error().setMessage(Lessons.TOO_LONG_THEME_NAME_MESSAGE))},

                {lesson.clone().setThemeName(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(0)),
                        new ResponseError(new Error().setMessage(Lessons.EMPTY_THEME_NAME_MESSAGE))}};
    }

    @Test(dataProvider = "lesson")
    public void editLessonAsAdmin(Lesson lesson, ResponseError responseError) throws
            JsonProcessingException {

        ResponseError error = serviceApi.addLesson(lesson)
                .then()
                .log().all()
                .statusCode(BAD_REQUEST)
                .extract()
                .as(ResponseError.class);

        assertThat(error.getError().getMessage())
                .isEqualTo(responseError.getError().getMessage());
    }
}
