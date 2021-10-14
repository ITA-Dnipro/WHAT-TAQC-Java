package page;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import page.base.LogIn;
import page.lessons.AddLessonPage;
import page.lessons.EditLessonPage;
import page.lessons.LessonDetailsPage;
import page.lessons.LessonsPage;
import util.User;

import java.util.function.UnaryOperator;

public class AppPages {
    LogIn auth;
    LessonsPage lessons;
    AddLessonPage addLessonPage;
    EditLessonPage editLessonPage;
    LessonDetailsPage lessonDetailsPage;

    public AppPages(WebDriver driver) {
        auth = new LogIn(driver);
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
