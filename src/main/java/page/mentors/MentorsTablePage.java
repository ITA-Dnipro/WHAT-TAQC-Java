package page.mentors;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.unassigned.UnassignedUsersPage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Locators.MentorsTablePage.*;

public class MentorsTablePage extends Page<MentorsTablePage> {

    public MentorsTablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.MENTORS);
    }

    @FindBy(xpath = ADD_MENTOR_BUTTON_XPATH)
    protected WebElement addMentorButton;
    @FindBy(xpath = DISABLE_MENTORS_SWITCH_XPATH)
    protected WebElement disableMentorsSwitch;
    @FindBy(xpath = SEARCH_INPUT_FIELD_XPATH)
    protected WebElement searchInputField;
    @FindBy(xpath = SORT_NAME_ARROW_XPATH)
    protected WebElement sortNameArrow;
    @FindBy(xpath = SORT_SURNAME_ARROW_XPATH)
    protected WebElement sortSurnameArrow;
    @FindBy(xpath = SORT_EMAIL_ARROW_XPATH)
    protected WebElement sortEmailArrow;
    @FindBy(xpath = EDIT_BUTTON_XPATH)
    protected List<WebElement> editButtonXpath;
    @FindBy(xpath = MENTORS_ROW_XPATH)
    protected List<WebElement> mentorsRow;
    @FindBy(xpath = SWITCH_VIEW_BUTTONS_XPATH)
    protected List<WebElement> switchViewButton;
    @FindBy(xpath = MENTORS_NOT_FOUND_MESSAGE_SEARS)
    protected WebElement notFoundMessage;

    public MentorsTablePage showDisableMentors() {
        clickElement(disableMentorsSwitch);
        return this;
    }

    public MentorsTablePage showMentorsCard(int index) {
        clickElement(switchViewButton.get(index));
        return this;
    }

    public MentorsTablePage inputSearchMentor(String nameSurname) {
        fillField(searchInputField, "a");
        fillField(searchInputField, nameSurname);
        return this;
    }

    public MentorsTablePage sortByName() {
        clickElement(sortNameArrow);
        return this;
    }

    public MentorsTablePage sortBySurname() {
        clickElement(sortSurnameArrow);
        return this;
    }

    public MentorsTablePage sortByEmail() {
        clickElement(sortEmailArrow);
        return this;
    }

    public MentorsDetailsPage viewMentorsDetails(int index) {
        clickElement(mentorsRow.get(index));
        return new MentorsDetailsPage(driver);
    }

    public UnassignedUsersPage addMentor() {
        clickElement(addMentorButton);
        return new UnassignedUsersPage(driver);
    }

    public EditMentorsDetailsPage editMentors(Integer index) {
        clickElement(editButtonXpath.get(index));
        return new EditMentorsDetailsPage(driver);
    }

    public Integer getMentorsIdByName(String name) {
        for (int i = 0; i < mentorsRow.size(); i++) {
            if (mentorsRow.get(i).getText().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public List<String> getMentorsName() {
        List<String> mentorsNames = new ArrayList<String>();
        for (int i = 0; i < mentorsRow.size(); i = i + 3) {
            mentorsNames.add(mentorsRow.get(i).getText());
        }
        return mentorsNames;
    }

    public List<String> getMentorsSurname() {
        List<String> mentorsSurname = new ArrayList<String>();
        for (int i = 1; i < mentorsRow.size(); i = i + 3) {
            mentorsSurname.add(mentorsRow.get(i).getText());
        }
        return mentorsSurname;
    }

    public List<String> getMentorsEmail() {
        List<String> mentorsEmail = new ArrayList<String>();
        for (int i = 2; i < mentorsRow.size(); i = i + 3) {
            mentorsEmail.add(mentorsRow.get(i).getText());
        }
        return mentorsEmail;
    }

    public List<String> getMentorsData() {
        List<String> mentorsData = new ArrayList<>();

        for (int i = 0; i < mentorsRow.size(); i++) {
            mentorsData.add(mentorsRow.get(i).getText());
        }
        return mentorsData;
    }

    public MentorsTablePage verifyInputSearchField(String search) {
        softAssert.assertEquals(searchInputField.getAttribute("value"), search);
        return this;
    }

    public MentorsTablePage verifyMentorsDataInTheTable(List<String> mentorsData) {
        softAssert.assertEquals(getMentorsData(), mentorsData);
        return this;
    }

    public MentorsTablePage verifySoftByNameASC() {
        List<String> actualResult = getMentorsName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifySoftByNameDEC() {
        List<String> actualResult = getMentorsName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifySoftBySurNameASC() {
        List<String> actualResult = getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifySoftBySurNameDEC() {
        List<String> actualResult = getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifySoftByEmailASC() {
        List<String> actualResult = getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifySoftByEmailDEC() {
        List<String> actualResult = getMentorsSurname();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }

    public MentorsTablePage verifyNotFoundResult() {
        softAssert.assertEquals(notFoundMessage.getText(), "Mentor is not found");
        return this;
    }
}