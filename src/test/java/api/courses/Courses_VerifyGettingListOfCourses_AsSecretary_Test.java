package api.courses;

import api.base.SecretaryRequests;
import api.services.CoursesServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Courses_VerifyGettingListOfCourses_AsSecretary_Test {

    CoursesServiceApi coursesServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new SecretaryRequests());
    }

    @Test
    public void getCourses() {
        coursesServiceApi.getCourses()
                .then().assertThat()
                .statusCode(200);
    }
}
