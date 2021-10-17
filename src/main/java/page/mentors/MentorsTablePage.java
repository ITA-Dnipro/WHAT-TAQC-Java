package page.mentors;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.ArrayList;
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

    public EditMentorsDetailsPage editMentors(Integer index) {
        clickElement(editButtonXpath.get(index));
        return new EditMentorsDetailsPage(driver);
    }
    public Integer getMentorsIdByName(String name){
        for (int i = 0; i < mentorsRow.size(); i++){
            if (mentorsRow.get(i).getText().equals(name)){
                return i;
            }
        }
        return null;
    }
    public EditMentorsDetailsPage editMentorsByName(String name){
        clickElement(editButtonXpath.get(getMentorsIdByName(name)));
        return new EditMentorsDetailsPage(driver);
    }
    public List<String> getMentorsName(){
        List<String> mentorsNames = new ArrayList<String>();
        for(int i=0;i<mentorsRow.size();i=i+3 ){
            mentorsNames.add(mentorsRow.get(i).getText());
        }
        return mentorsNames;
    }
    public List<String> getMentorsSurname(){
        List<String> mentorsSurname = new ArrayList<String>();
        for(int i=1;i<mentorsRow.size();i=i+3 ){
            mentorsSurname.add(mentorsRow.get(i).getText());
        }
        return mentorsSurname;
    }
    public List<String> getMentorsEmail(){
        List<String> mentorsEmail = new ArrayList<String>();
        for(int i=2;i<mentorsRow.size();i=i+3 ){
            mentorsEmail.add(mentorsRow.get(i).getText());
        }
        return mentorsEmail;
    }

}