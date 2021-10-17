package lessons.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddLessonErrors extends AddLessonData{

    String theme_result;
    String g_name_result;
    String date_result;
    String email_result;

    public AddLessonErrors() {
    }

    public AddLessonErrors(String theme, String g_name, String date, String email,
                           String theme_result, String g_name_result,
                           String date_result, String email_result) {
        super(theme, g_name, date, email);
        this.theme_result = theme_result;
        this.g_name_result = g_name_result;
        this.date_result = date_result;
        this.email_result = email_result;
    }

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
