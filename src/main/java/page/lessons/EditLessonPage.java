package page.lessons;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import page.base.Page;
import static constants.Locators.EditLesson.*;

public class EditLessonPage extends Page<EditLessonPage> {

    @FindBy(id = LESSON_THEME_INPUT_FIELD_ID)
    WebElement lessonThemeInput;

    @FindBy(id = LESSON_TIME_INPUT_FIELD_ID)
    WebElement timeInput;

    @FindBy(className = EDIT_LESSON_THEME_ERROR_CLASS)
    WebElement error;

    @FindBy(xpath = PAGE_TITLE_XPATH)
    WebElement title;

    private static final Logger logger = Logger.getLogger(EditLessonPage.class.getName());

    ClassBookFeature classBook;
    SoftAssert softAssert;

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

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    public WebElement getLessonThemeInput() {
        return lessonThemeInput;
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }
}
