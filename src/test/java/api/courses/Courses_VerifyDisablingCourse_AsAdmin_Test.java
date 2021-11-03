package api.courses;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;

public class Courses_VerifyDisablingCourse_AsAdmin_Test {

    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();
    Integer id;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
        id = coursesServiceApi.addCourse(course).as(Course.class).getId();
    }

    @Test
    public void deleteCourse() throws JsonProcessingException {
        coursesServiceApi
                .deleteCourse(id)
                .peek()
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS);
    }
}
