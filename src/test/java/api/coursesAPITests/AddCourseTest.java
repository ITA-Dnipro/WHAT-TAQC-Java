package api.coursesAPITests;

import api.APICourses.CoursesService.CourseService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Role;

import java.io.IOException;

public class AddCourseTest extends CourseService {
    String token;

    @BeforeTest
    public void setUp() throws IOException {
       token = getToken();
    }

    @Test
    public void addCourse() {
        addNewCourse(token);
    }
}
