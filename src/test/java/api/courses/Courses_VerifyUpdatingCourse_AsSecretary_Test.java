package api.courses;

import api.base.AdminRequests;
import api.entities.courses.Course;
import api.services.CoursesServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RandomStringsGenerator;

import java.io.IOException;

public class Courses_VerifyUpdatingCourse_AsSecretary_Test {
    CoursesServiceApi coursesServiceApi;
    Course course = Course.getCourseWithRandomName();
    Course updatedCourse;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new AdminRequests());
        updatedCourse = coursesServiceApi.addCourse(course).as(Course.class);
    }

    @Test
    public void updateCourse() throws JsonProcessingException {
        coursesServiceApi
                .updateCourse(updatedCourse
                        .setName(RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(12)))
                .peek()
                .then()
                .assertThat()
                .statusCode(200);
    }
}