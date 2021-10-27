package api.courses;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;

public class Courses_VerifyUpdatingCourse_AsSecretary_Test {
    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();
    int id;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
        id = coursesServiceApi.addCourse(course).as(Course.class).getId();
    }

    @Test
    public void updateCourse() {

        coursesServiceApi
                .updateCourse(id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}