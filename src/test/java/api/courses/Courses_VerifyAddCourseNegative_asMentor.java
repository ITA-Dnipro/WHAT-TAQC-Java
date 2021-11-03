package api.courses;

import api.base.MentorRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.FORBIDDEN;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Courses_VerifyAddCourseNegative_asMentor {
    CoursesServiceApi coursesServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new MentorRequests());
    }

    @Test
    public void addCourseNegative() throws JsonProcessingException {

        Course course = Course.getCourseWithRandomName();

        coursesServiceApi
                .addCourse(course)
                .then()
                .log().all()
                .statusCode(FORBIDDEN);
    }
}
