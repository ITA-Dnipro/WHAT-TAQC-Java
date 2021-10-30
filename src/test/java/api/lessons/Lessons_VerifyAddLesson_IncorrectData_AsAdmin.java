package api.lessons;

import api.APIConstants;
import api.base.AdminRequests;
import api.entities.error.Error;
import api.entities.error.ResponseError;
import api.entities.lessons.Lesson;
import api.services.LessonServiceApi;
import org.jsoup.Connection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static api.APIConstants.*;
import static api.APIConstants.StatusCodes.BAD_REQUEST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lessons_VerifyAddLesson_IncorrectData_AsAdmin {

    LessonServiceApi lessonServiceApi;
    Lesson lesson;
    static final Integer overSizeOfThemeName = 101;
    static final String futureDate = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern(dateFormat));

    @BeforeClass
    public void setUp() throws IOException {
        lessonServiceApi = new LessonServiceApi(new AdminRequests());
        lesson = Lesson.getLessonObject();
    }

    @DataProvider(name = "lesson")
    public Object[][] provide() throws CloneNotSupportedException {
        return new Object[][]{
                {lesson.clone().setLessonDate(LocalDateTime.now()
                        .minusYears(LocalDateTime.now().getYear()).format(DateTimeFormatter.ofPattern(dateFormat))),
                        new ResponseError(new Error().setMessage(Lessons.BAD_DATE_MESSAGE))},

                {lesson.clone().setLessonDate(futureDate),
                new ResponseError(new Error().setMessage(Lessons.BAD_DATE_MESSAGE))},

                {lesson.clone().setThemeName(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(overSizeOfThemeName)),
                            new ResponseError(new Error().setMessage(Lessons.TOO_LONG_THEME_NAME_MESSAGE))},

                {lesson.clone().setStudentGroupId(0),
                new ResponseError(new Error().setMessage(Lessons.EMPTY_STUDENT_GROUP_MESSAGE))},

                {lesson.clone().setMentorId(0),
                new ResponseError(new Error().setMessage(Lessons.EMPTY_MENTOR_ID_MESSAGE))},

                {lesson.clone().setThemeName(RandomStringsGenerator
                        .getAlphabeticStringLowerCaseCharacters(0)),
                new ResponseError(new Error().setMessage(Lessons.EMPTY_THEME_NAME_MESSAGE))}};
    }

    @Test(dataProvider = "lesson")
    public void addLessonIncorrectData(Lesson lesson, ResponseError error) throws IOException {

        ResponseError responseError = lessonServiceApi.addLesson(lesson)
                .then()
                .log().all()
                .statusCode(BAD_REQUEST)
                .extract()
                .as(ResponseError.class);

        assertThat(responseError.getError().getMessage())
                .isEqualTo(error.getError().getMessage());
    }
}
