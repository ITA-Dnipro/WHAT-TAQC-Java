package page.lessons;

import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import page.base.Page;
import static constants.Locators.EditLesson.*;

public class EditLessonPage extends Page {

    @FindBy(id = LESSON_THEME_INPUT_FIELD_ID)
    WebElement lessonThemeInput;

    @FindBy(id = LESSON_TIME_INPUT_FIELD_ID)
    WebElement timeInput;

    @FindBy(className = EDIT_LESSON_THEME_ERROR_CLASS)
    WebElement error;

    private static final Logger logger = Logger.getLogger(EditLessonPage.class.getName());

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

    private void verifyError(String errorMessage, WebElement error){
        try {
            softAssert.assertEquals(error.getText(), errorMessage);
            logger.info(error.getText());
        }
        catch (NotFoundException e){
            softAssert.assertTrue(false);
            logger.info("No ERROR! But should be: " + errorMessage);
        }

    }

    public WebElement getLessonThemeInput() {
        return lessonThemeInput;
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }
}
