package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.mentors.MentorsDetailsPage;
import java.util.List;
import static constants.Locators.LessonDetails.*;

public class LessonDetailsPage extends Page {

    @FindBy(xpath = MENTOR_NAME_LINK_XPATH)
    WebElement mentorName;

    @FindBy(xpath = GROUP_NAME_LINK_XPATH)
    WebElement groupName;

    @FindBy(className = LIST_OF_STUDENTS_CLASS)
    List<WebElement> students;

    public LessonDetailsPage(WebDriver driver) {
        super(driver);
    }

    public MentorsDetailsPage clickMentorNameLink(){
        clickElement(mentorName);
        return new MentorsDetailsPage(driver);
    }

    //Wait for Group
    public Page clickGroupNameLink(){
        clickElement(groupName);
        return null;
    }
}
