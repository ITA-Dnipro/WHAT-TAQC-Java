package api.courses;

import api.base.SecretaryRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Courses_VerifyUpdatingCourse_AsSecretary_Test {
    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();
    Course updatedCourse;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new SecretaryRequests());
        updatedCourse = coursesServiceApi.addCourse(course).as(Course.class);
    }

    @Test
    public void updateCourse() throws JsonProcessingException, CloneNotSupportedException {

        Course oldCourse = updatedCourse.clone();

        updatedCourse = coursesServiceApi
                .updateCourse(updatedCourse
                        .setName(RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(12)))
                .peek()
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Course.class);

        assertThat(oldCourse).isNotEqualTo(updatedCourse);
    }
}