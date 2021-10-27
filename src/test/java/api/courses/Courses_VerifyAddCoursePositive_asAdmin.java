package api.courses;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Courses_VerifyAddCoursePositive_asAdmin {
    CoursesServiceApi coursesServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
    }

    @Test
    public void addCoursePositive() throws JsonProcessingException {
        coursesServiceApi.addCourse(Course.getCourseWithRandomName())
                .then()
                .assertThat()
                .statusCode(200);
    }
}
