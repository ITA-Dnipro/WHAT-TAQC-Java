package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.Lessons.ADD_LESSON_BUTTON_XPATH;

public class LessonsPage extends Page {

    @FindBy(xpath = ADD_LESSON_BUTTON_XPATH)
    WebElement addLessonButton;



    public LessonsPage(WebDriver driver) {
        super(driver);
    }

    public AddLessonPage clickAddLessonButton(){
        clickElement(addLessonButton);
        return new AddLessonPage(driver);
    }
}
