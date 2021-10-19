package page.groups;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.lessons.EditLessonPage;

import java.util.List;

import static constants.Locators.AddGroupPage.*;

public class EditGroupPage extends Page<EditGroupPage> {

    @FindBy(xpath = GROUP_NAME_INPUT_FIELD_XPATH)
    WebElement groupNameInput;

    @FindBy(xpath = COURSE_INPUT_FIELD_XPATH)
    WebElement courseInput;

    @FindBy(xpath = START_DATE_INPUT_FIELD_XPATH)
    WebElement startDateInput;

    @FindBy(xpath = FINISH_DATE_INPUT_FIELD_XPATH)
    WebElement finishDateInput;

    @FindBy(xpath = MENTOR_INPUT_FIELD_XPATH)
    WebElement mentorInput;

    @FindBy(xpath = STUDENT_INPUT_FIELD_XPATH)
    WebElement studentInput;

    @FindBy(xpath = ADD_MENTOR_BUTTON_XPATH)
    WebElement addMentorButton;

    @FindBy(xpath = ADD_STUDENT_BUTTON_XPATH)
    WebElement addStudentButton;

    @FindBy(xpath = CONFIRM_BUTTON_XPATH)
    WebElement confirmButton;

    @FindBy(xpath = CLEAR_BUTTON_XPATH)
    WebElement clearButton;

    @FindBy(xpath = LIST_OF_COURSES_XPATH)
    List<WebElement> listOfCourses;

    public EditGroupPage(WebDriver driver) {
        super(driver);
    }

    public static EditGroupPage init(WebDriver driver){
        return new EditGroupPage(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.EDIT_GROUP);
    }

    public EditGroupPage fillGroupName(String name){
        fillField(groupNameInput, name);
        return this;
    }

    public EditGroupPage selectCourse(){
        if(listOfCourses.size() != 0){
            fillField(courseInput, listOfCourses.get(0).getAttribute("value"));
        }
        return this;
    }

    public EditGroupPage fillStartDate(String date){
        fillField(startDateInput, date);
        return this;
    }

    public EditGroupPage fillFinishDate(String date){
        fillField(finishDateInput, date);
        return this;
    }

    public EditGroupPage clickClearButton(){
        clickElement(clearButton);
        return this;
    }

    public GroupsPage clickConfirmButton(){
        clickElement(confirmButton);
        return new GroupsPage(driver);
    }
}
