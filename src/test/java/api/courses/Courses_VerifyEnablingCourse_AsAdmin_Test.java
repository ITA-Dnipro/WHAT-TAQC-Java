package api.courses;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Courses_VerifyEnablingCourse_AsAdmin_Test {

    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();
    Integer id;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
        course = coursesServiceApi.addCourse(course).as(Course.class);
        id = course.getId();
        coursesServiceApi.deleteCourse(id);
    }

    @Test
    public void enableCourse() throws JsonProcessingException, CloneNotSupportedException {
        Course oldCourse = course.clone();

        coursesServiceApi
                .enableCourse(course)
                .peek()
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .extract()
                .response()
                .as(Course.class);

        assertThat(oldCourse).isEqualTo(course);
    }
}
