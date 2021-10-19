package page.mentors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;


import java.util.ArrayList;
import java.util.List;

import static constants.Locators.MentorsDetailsPage.*;

public class MentorsDetailsPage extends Page<MentorsDetailsPage> {
    public MentorsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }

    @FindBy(xpath = MENTORS_DETAILS_TAB_XPATH)
    protected WebElement mentorsDetailsTab;
    @FindBy(xpath = EDIT_MENTOR_TAB_XPATH)
    protected WebElement editMentorsTab;
    @FindBy(xpath = ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = MENTORS_FIRST_NAME_XPATH)
    protected WebElement firstNameMentor;
    @FindBy(xpath = MENTORS_LAST_NAME_XPATH)
    protected WebElement lastNameMentor;
    @FindBy(xpath = MENTOR_EMAIL_NAME_XPATH)
    protected WebElement emailMentor;
    @FindBy(xpath = LIST_OF_GROUP_LINK)
    protected List<WebElement> listOfGroups;
    @FindBy(xpath = LIST_OF_COURSE_LINK)
    protected List<WebElement> listOfCourses;


    public MentorsTablePage backToMentorsTable() {
        clickElement(arrowButton);
        return new MentorsTablePage(driver);
    }

    public EditMentorsDetailsPage viewEditMentorsTab() {
        clickElement(editMentorsTab);
        return new EditMentorsDetailsPage(driver);
    }

    public MentorsDetailsPage viewMentorsDetailTab() {
        clickElement(mentorsDetailsTab);
        return this;
    }

    public MentorsDetailsPage verifyFirstName(String firstName) {
        softAssert.assertEquals(firstNameMentor.getText(), firstName);
        return this;
    }

    public MentorsDetailsPage verifyLastName(String lastName) {
        softAssert.assertEquals(lastNameMentor.getText(), lastName);
        return this;
    }

    public MentorsDetailsPage verifyEmail(String email) {
        softAssert.assertEquals(emailMentor.getText(), email);
        return this;
    }

    public MentorsDetailsPage verifyGroups(List<String> expectGroups) {
        List<String> actualGroups = new ArrayList<>();
        for (int i=0;i<listOfGroups.size();i++){
            actualGroups.add(listOfGroups.get(i).getText());
        }
        softAssert.assertEquals(actualGroups,expectGroups);
        return this;
    }
    public MentorsDetailsPage verifyCourse(List<String> expectCourse) {
        List<String> actualCourse = new ArrayList<>();
        for (int i=0;i<listOfCourses.size();i++){
            actualCourse.add(listOfCourses.get(i).getText());
        }
        softAssert.assertEquals(actualCourse,expectCourse);
        return this;
    }

}
