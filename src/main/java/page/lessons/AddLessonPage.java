package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import java.util.List;
import static constants.Locators.AddLesson.*;

public class AddLessonPage extends Page {

    @FindBy(xpath = CANCEL_BUTTON_XPATH)
    WebElement cancelButton;

    @FindBy(id = CLASS_REGISTER_BUTTON_ID)
    WebElement classRegisterButton;

    @FindBy(id = LESSON_THEME_INPUT_FIELD_ID)
    WebElement lessonThemeInput;

    @FindBy(id = GROUP_NAME_INPUT_FIELD_ID)
    WebElement groupNameInput;

    @FindBy(id = LESSON_TIME_INPUT_FIELD_ID)
    WebElement dateInput;

    @FindBy(id = MENTOR_EMAIL_INPUT_FIELD_ID)
    WebElement emailInput;

    @FindBy(xpath = LIST_OF_GROUPS_XPATH)
    List<WebElement> listOfGroups;

    @FindBy(xpath = LIST_OF_MENTORS_XPATH)
    List<WebElement> listOfMentors;

    @FindBy(className = LESSON_THEME_ERROR_CLASS)
    WebElement themeError;

    @FindBy(id = GROUP_NAME_ERROR_ID)
    WebElement groupError;

    @FindBy(id = MENTOR_MAIL_ERROR_ID)
    WebElement mailError;

    ClassBookFeature classBook;

    public AddLessonPage(WebDriver driver) {
        super(driver);
        classBook = new ClassBookFeature(driver);
    }

    public AddLessonPage fillLessonTheme(String theme){
        fillField(lessonThemeInput, theme);
        return this;
    }

    public AddLessonPage fillGroupName(String group){
        fillField(groupNameInput, group);
        return this;
    }

    public AddLessonPage fillDateInput(String date){
        fillField(dateInput, date);
        return this;
    }

    public AddLessonPage fillEmailInput(String email){
        fillField(emailInput, email);
        return this;
    }

    public LessonsPage clickCancelButton(){
        clickElement(cancelButton);
        return new LessonsPage(driver);
    }

    public AddLessonPage clickClassRegisterButton(){
        clickElement(classRegisterButton);
        return this;
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }

}