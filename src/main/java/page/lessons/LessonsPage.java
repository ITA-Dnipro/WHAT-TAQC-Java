package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;

import static constants.Locators.Lessons.ADD_LESSON_BUTTON_XPATH;
import static constants.Locators.Lessons.TABLE_ROWS_XPATH;

public class LessonsPage extends Page {

    @FindBy(xpath = ADD_LESSON_BUTTON_XPATH)
    WebElement addLessonButton;

    @FindBy(xpath = TABLE_ROWS_XPATH)
    List<WebElement> rows;



    public LessonsPage(WebDriver driver) {
        super(driver);
    }

    public AddLessonPage clickAddLessonButton(){
        clickElement(addLessonButton);
        return new AddLessonPage(driver);
    }

    public Integer getRowsCount(){
        return rows.size();
    }
}
