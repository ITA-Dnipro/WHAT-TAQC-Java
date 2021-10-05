package page.mentors;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import java.util.List;
import static constants.Locators.MentorsTablePage.*;

public class MentorsTablePage extends Page  {

    public MentorsTablePage(WebDriver driver) {
        super(driver);
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

    public MentorsTablePage showDisableMentors() {
        clickElement(disableMentorsSwitch);
        return this;
    }
    public MentorsTablePage showMentorsCard(int index){
        clickElement(switchViewButton.get(index));
        return this;
    }

    public MentorsTablePage inputSearchMentor(String nameSurname) {
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

    public EditMentorsDetailsPage editMentors(int index) {
        clickElement(editButtonXpath.get(index));
        return new EditMentorsDetailsPage(driver);
    }

}