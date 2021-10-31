package api.courses;

import api.base.SecretaryRequests;
import api.services.CoursesServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;

public class Courses_VerifyGettingListOfCourses_AsSecretary_Test {

    CoursesServiceApi coursesServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        coursesServiceApi = new CoursesServiceApi(new SecretaryRequests());
    }

    @Test
    public void getCourses() {
        coursesServiceApi.getCourses()
                .then()
                .assertThat()
                .headers(HEADERS)
                .statusCode(OK);
    }
}
