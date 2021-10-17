package courses.coursesData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EditCourseValidData {
    String courseName;
    String newCourseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getNewCourseName() {
        return newCourseName;
    }

    public void setNewCourseName(String newCourseName) {
        this.newCourseName = newCourseName;
    }

    public static EditCourseValidData[] getEditCoursesValidData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), EditCourseValidData[].class);
    }
}
