package courses.coursesData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddCoursesData {

    private String сourseName;

    public String getСourseName() {
        return сourseName;
    }

    public void setСourseName(String сourseName) {
        this.сourseName = сourseName;
    }

    public static AddCoursesData[] getCoursesName(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), AddCoursesData[].class);
    }
}
