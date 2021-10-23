package courses.coursesData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SearchFunctionTest {

    String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static SearchFunctionTest[] getCourseNameForSearch(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), SearchFunctionTest[].class);
    }
    public static SearchFunctionTest[] getUnassignedNameForSearch(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), SearchFunctionTest[].class);
    }
}
