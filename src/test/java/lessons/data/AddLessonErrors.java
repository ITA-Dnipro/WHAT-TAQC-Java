package lessons.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddLessonErrors extends AddLessonData{

    String themeResult;
    String groupNameResult;
    String dateResult;
    String emailResult;

    public AddLessonErrors() {
    }

    public AddLessonErrors(String theme, String g_name, String date, String email,
                           String themeResult, String groupNameResult,
                           String date_result, String emailResult) {
        super(theme, g_name, date, email);
        this.themeResult = themeResult;
        this.groupNameResult = groupNameResult;
        this.dateResult = date_result;
        this.emailResult = emailResult;
    }

    public String getThemeResult() {
        return themeResult;
    }

    public String getGroupNameResult() {
        return groupNameResult;
    }

    public String getDateResult() {
        return dateResult;
    }

    public String getEmailResult() {
        return emailResult;
    }

    public static AddLessonErrors[] getErrors(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), AddLessonErrors[].class);
    }
}
