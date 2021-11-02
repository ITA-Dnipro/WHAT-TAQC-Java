package api.courses;

import api.base.SecretaryRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Courses_VerifyAddCoursePositive_asSecretary {
    CoursesServiceApi coursesServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new SecretaryRequests());
    }

    @Test
    public void addCoursePositive() throws JsonProcessingException {
        Course course = Course.getCourseWithRandomName();

        Course addCourse = coursesServiceApi
                .addCourse(course)
                .then()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Course.class);

        assertThat(course).isEqualTo(addCourse);
    }
}
