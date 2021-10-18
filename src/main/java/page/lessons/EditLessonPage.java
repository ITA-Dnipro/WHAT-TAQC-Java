package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import static constants.Locators.EditLesson.*;

public class EditLessonPage extends Page<EditLessonPage> {

    @FindBy(id = LESSON_THEME_INPUT_FIELD_ID)
    WebElement lessonThemeInput;

    @FindBy(id = LESSON_TIME_INPUT_FIELD_ID)
    WebElement timeInput;

    @FindBy(className = EDIT_LESSON_THEME_ERROR_CLASS)
    WebElement themeError;

    @FindBy(xpath = PAGE_TITLE_XPATH)
    WebElement title;

    ClassBookFeature classBook;
    private final String VALUE = "value";

    public EditLessonPage(WebDriver driver) {
        super(driver);
        classBook = new ClassBookFeature(driver);
    }

    @Override
    public boolean isAt() {
        return title.getText().equals("Edit a Lesson");
    }

    public static EditLessonPage init(WebDriver driver){
        return new EditLessonPage(driver);
    }

    public EditLessonPage fillLessonThemeInput(String data){
        System.out.println(lessonThemeInput.getText());
        fillField(lessonThemeInput, data);
        return this;
    }

    public EditLessonPage fillTimeInput(String time){
        fillField(timeInput, time);
        return this;
    }

    public EditLessonPage loseFocus(){
        title.click();
        return this;
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }

    public EditLessonPage verifyThemeNameError(String error){
        softAssert.assertEquals(themeError.getText(), error);
        return this;
    }

    public EditLessonPage verifyThemeNameInputFieldIsFilled(String text){
        softAssert.assertEquals(lessonThemeInput.getAttribute(VALUE), text);
        return this;
    }

    public EditLessonPage verifyDateInputFieldIsFilled(){
        softAssert.assertFalse(timeInput.getAttribute(VALUE).equals(""));
        return this;
    }

    public EditLessonPage verifyAll(){
        softAssert.assertAll();
        return this;
    }
}
