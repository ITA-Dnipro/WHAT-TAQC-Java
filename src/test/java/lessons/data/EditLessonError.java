package lessons.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EditLessonError {
    String theme;
    String result;
    String date;
    String dateResult;

    public String getTheme() {
        return theme;
    }

    public String getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }

    public String getDateResult() {
        return dateResult;
    }
    public static EditLessonError[] getErrors(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), EditLessonError[].class);
    }
}
