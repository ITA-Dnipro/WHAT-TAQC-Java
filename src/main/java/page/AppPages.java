package page;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import unauthorizedPages.Auth;
import page.lessons.AddLessonPage;
import page.lessons.EditLessonPage;
import page.lessons.LessonDetailsPage;
import page.lessons.LessonsPage;
import util.User;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class AppPages {
    Auth auth;
    LessonsPage lessons;
    AddLessonPage addLessonPage;
    EditLessonPage editLessonPage;
    LessonDetailsPage lessonDetailsPage;

    public AppPages(WebDriver driver) throws IOException {
        auth = new Auth(driver);
        lessons = new LessonsPage(driver);
        addLessonPage = new AddLessonPage(driver);
        editLessonPage = new EditLessonPage(driver);
        lessonDetailsPage = new LessonDetailsPage(driver);
    }

    public final UnaryOperator<User> userLogin = (d) -> {
        assertTrue(auth.isAt());
        auth.fillMail(d.getMail())
                .fillPass(d.getPass())
                .clickLogInButton();
       return d;
    };
}
