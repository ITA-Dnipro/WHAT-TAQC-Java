package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import page.base.Page;
import java.util.List;

import static constants.Locators.EditLesson.*;

public class EditLessonPage extends Page {

    @FindBy(id = LESSON_THEME_INPUT_FIELD_ID)
    WebElement lessonThemeInput;

    @FindBy(id = LESSON_TIME_INPUT_FIELD_ID)
    WebElement timeInput;

    @FindBy(className = EDIT_LESSON_THEME_ERROR_CLASS)
    List<WebElement> error;

    ClassBookFeature classBook;
    SoftAssert softAssert;

    public EditLessonPage(WebDriver driver) {
        super(driver);
        classBook = new ClassBookFeature(driver);
    }

    public EditLessonPage fillLessonThemeInput(String data, String errorMessage){
        fillField(lessonThemeInput, data);
        verifyError(errorMessage, error);
        return this;
    }

    public EditLessonPage fillTimeInput(String time){
        fillField(timeInput, time);
        return this;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    private void verifyError(String errorMessage, List<WebElement> error){
        if (error.size() != 0)
            softAssert.assertEquals(error.get(0).getText(), errorMessage);
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }
}
