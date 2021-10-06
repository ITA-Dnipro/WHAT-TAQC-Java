package page.mentors;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.MentorsDetailsPage.*;

public class MentorsDetailsPage extends Page  {
    public MentorsDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = MENTORS_DETAILS_TAB_XPATH)
    protected WebElement mentorsDetailsTab;
    @FindBy (xpath =EDIT_MENTOR_TAB_XPATH)
    protected WebElement editMentorsTab;
    @FindBy (xpath =ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
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
}
