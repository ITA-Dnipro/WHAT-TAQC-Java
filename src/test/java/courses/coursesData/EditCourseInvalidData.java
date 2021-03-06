package courses.coursesData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EditCourseInvalidData {
    String courseName;
    String newCourseName;
    String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EditCourseInvalidData[] getEditCoursesInvalidData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), EditCourseInvalidData[].class);
    }
}
