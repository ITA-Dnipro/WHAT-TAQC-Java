package lessons.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddLessonErrors extends AddLessonData{

    String theme_result;
    String g_name_result;
    String date_result;
    String email_result;

    public String getTheme_result() {
        return theme_result;
    }

    public String getG_name_result() {
        return g_name_result;
    }

    public String getDate_result() {
        return date_result;
    }

    public String getEmail_result() {
        return email_result;
    }

    public static AddLessonErrors[] getErrors(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), AddLessonErrors[].class);
    }
}
