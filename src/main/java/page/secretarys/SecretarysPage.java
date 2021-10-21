package page.secretarys;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.unassigned.UnassignedUsersPage;

import java.util.ArrayList;
import java.util.List;

import static constants.Locators.EditSecretary.SECRETARIES_LAY_OFF_BUTTON_XPATH;
import static constants.Locators.MentorsTablePage.MENTORS_ROW_XPATH;
import static constants.Locators.Secretaries.*;




public class SecretarysPage extends Page<SecretarysPage> {

    @FindBy(tagName = SECRETARY_PAGE_TITLE_XPATH)
    protected WebElement pageName;
    @FindBy(className = SEARCH_WINDOW_SECRETARIES_NAME_XPATH)
    protected WebElement searchInputFieldBox;
    @FindBy(id = SWITCH_VIEW_DISABLED_SECRETARIES_XPATH)
    protected WebElement showDisabledSwitcher;
    @FindBy(xpath = ADD_SECRETARY_BUTTON_XPATH)
    protected WebElement addSecretaryButton;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_SURNAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(xpath = SECRETARY_EDIT_ICON_XPATH)
    List <WebElement> editIcon;
    @FindBy(xpath = SECRETARY_ROW_XPATH)
    protected List<WebElement> secretaryRow;
    @FindBy(xpath = SECRETARIES_LAY_OFF_BUTTON_XPATH)
    protected WebElement layOffButton;

    public SecretarysEditDetailsTab deleteSecretary() {
        clickElement(layOffButton);
        return new SecretarysEditDetailsTab(driver);
    }


    public SecretarysPage(WebDriver driver) {
        super(driver);
    }


    public UnassignedUsersPage addSecretary() {
        clickElement(addSecretaryButton);
        return new UnassignedUsersPage(driver);
    }

    public SecretarysEditDetailsPage editSecretary(int pensilId) {
        clickElement(editIcon.get(pensilId));
        return new SecretarysEditDetailsTab(driver);

    }
    public List<String> getSecretaryData() {
        List<String> secretaryData = new ArrayList<>();

        for (int i = 0; i < secretaryRow.size(); i++) {
            secretaryData.add(secretaryRow.get(i).getText());
        }
        return secretaryData;
    }

    public static SecretarysPage init(WebDriver driver) {
        return new SecretarysPage(driver);
    }

    public SecretarysPage inputSearchSecretary(String nameSurname) {
        fillField(searchInputFieldBox, nameSurname);
        return this;
    }

    public SecretarysPage sortByName() {
        clickElement(tableHeadFirstName);
        return this;
    }

    public SecretarysPage sortBySurname() {
        clickElement(tableHeadLastName);
        return this;
    }

    public SecretarysPage sortByEmail() {
        clickElement(tableHeadEmail);
        return this;
    }
    public SecretarysPage showDisableSecretarys() {
        clickElement(showDisabledSwitcher);
        return this;
    }
       @Override
    public boolean isAt() {
        return pageName.getText().equals("Secretaries");
  }
}