package page.lessons;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import util.RandomStringsGenerator;
import util.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static constants.Locators.AddLesson.*;

public class AddLessonPage extends Page<AddLessonPage> {

    //region WebElements
    @FindBy(xpath = PAGE_TITLE_XPATH)
    WebElement pageTitle;

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
    //endregion

    ClassBookFeature classBook;
    private final String VALUE = "value";
    public static final Integer MIN_LENGTH_THEME = 2;
    public static final Integer MAX_LENGTH_THEME = 50;
    public static final String DATE_FORMAT = "ddMMyyyyHH:mm";

    public AddLessonPage(WebDriver driver) {
        super(driver);
        classBook = new ClassBookFeature(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.ADD_LESSON);
    }

    //region Actions
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

    public AddLessonPage clickClassRegisterButton(){
        clickElement(classRegisterButton);
        return this;
    }

    public LessonsPage clickSaveButton(){
        classBook.clickSaveButton();
        return new LessonsPage(driver);
    }

    public AddLessonPage selectExistedGroup(){
        if(listOfGroups.size() != 0){
            fillGroupName(listOfGroups.get(0).getAttribute(VALUE));
        }
        return this;
    }

    public AddLessonPage selectExistedMentor(){
        if(listOfMentors.size() != 0){
            fillEmailInput(listOfMentors.get(0).getAttribute(VALUE));
        }
        return this;
    }

    public AddLessonPage loseFocus(){
        pageTitle.click();
        return this;
    }

    public LessonsPage addLessonForTest(User user){
        fillLessonTheme(RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5))
                .selectExistedGroup()
                .fillDateInput(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm")))
                .fillEmailInput(user.getMail())
                .clickClassRegisterButton()
                .clickSaveButton();
        return new LessonsPage(driver);
    }
    //endregion

    //region Verify
    public AddLessonPage verifyThemeNameInputFieldIsFilled(String text){
        softAssert.assertEquals(lessonThemeInput.getAttribute(VALUE), text);
        return this;
    }

    public AddLessonPage verifyGroupNameInputFieldIsFilled(String text){
        softAssert.assertEquals(groupNameInput.getAttribute(VALUE), text);
        return this;
    }

    public AddLessonPage verifyGroupNameInputFieldIsFilled(){
        softAssert.assertFalse(groupNameInput.getAttribute(VALUE).equals(""));
        return this;
    }

    public AddLessonPage verifyDateInputFieldIsFilled(String text){
        softAssert.assertEquals(dateInput.getAttribute(VALUE), text);
        return this;
    }

    public AddLessonPage verifyDateInputFieldIsFilled(){
        softAssert.assertFalse(dateInput.getAttribute(VALUE).equals(""));
        return this;
    }

    public AddLessonPage verifyMentorEmailInputFieldIsFilled(String text){
        softAssert.assertEquals(emailInput.getAttribute(VALUE), text);
        return this;
    }

    public AddLessonPage verifyMentorEmailInputFieldIsFilled(){
        softAssert.assertFalse(emailInput.getAttribute(VALUE).equals(""));
        return this;
    }

    public AddLessonPage verifyAll(){
        softAssert.assertAll();
        return this;
    }

    public AddLessonPage verifyThemeNameError(String error){
        softAssert.assertEquals(themeError.getText(), error);
        return this;
    }

    public AddLessonPage verifyGroupNameError(String error){
        softAssert.assertEquals(groupError.getText(), error);
        return this;
    }

    public AddLessonPage verifyMentorMailError(String error){
        softAssert.assertEquals(mailError.getText(), error);
        return this;
    }
    //endregion

}