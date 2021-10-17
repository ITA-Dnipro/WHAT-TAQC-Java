package lessons.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class AddLessonData {

    protected String theme;
    protected String g_name;
    protected String date;
    protected String email;

    public AddLessonData() {
    }

    public AddLessonData(String theme, String g_name, String date, String email) {
        this.theme = theme;
        this.g_name = g_name;
        this.date = date;
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static AddLessonData[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), AddLessonData[].class);
    }
}
