package api.courses;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Courses_VerifyAddExistedCourseNegative_asAdmin {
    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();


    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
        coursesServiceApi.addCourse(course);
    }

    @Test
    public void addCourseNegative() throws JsonProcessingException {
        coursesServiceApi.addExistCourse(course)
                .then().log().all()
                .assertThat()
                .statusCode(409);
    }
}
//.extract().statusLine().equals("Course already exists");