package page.secretarys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.mentors.EditMentorsDetailsPage;

import java.util.List;
import static constants.Locators.EditSecretary.*;
import static constants.Locators.Secretaries.*;


public class SecretarysEditDetailsPage extends Page<SecretarysEditDetailsPage>{
    public SecretarysEditDetailsPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = SECRETARY_DETAILS_ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = SECRETARY_DETAILS_TAB_XPATH )
    protected WebElement secretaryDetailsTab;
    @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    protected WebElement editSecretaryDetailsTab;
    @FindBy(tagName = SECRETARY_DETAILS_TAB_XPATH)
    protected WebElement secretaryPageTitle;
    @FindBy(xpath = SECRETARIES_FIRST_NAME_WINDOW_XPATH)
    protected WebElement firstNameInput;
    @FindBy(xpath = SECRETARIES_LAST_NAME_WINDOW_XPATH)
    protected WebElement lastNameInput;
    @FindBy(xpath = SECRETARIES_EMAIL_WINDOW_XPATH)
    protected WebElement emailInput;
        @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    protected WebElement editSecretaryTab;
    @FindBy(xpath = SECRETARIES_LAY_OFF_BUTTON_XPATH)
    protected WebElement layOffButton;
    @FindBy (xpath = REMOVE_SECRETARY_BUTTON)
    protected WebElement deleteSecretary;
    @FindBy(xpath = SECRETARIES_SAVE_BUTTON_XPATH)
    protected WebElement saveButton;

    public SecretarysEditDetailsPage deleteSecretary() {
        clickElement(layOffButton);
        return new SecretarysEditDetailsPage(driver);
    }
    public SecretarysEditDetailsPage saveSecretary(){
        clickElement(saveButton);
        return new SecretarysEditDetailsPage(driver);
    }
    public SecretarysEditDetailsPage loseFocus(){
        clickElement(secretaryPageTitle);
        return this;
    }

    public SecretarysEditDetailsPage acceptDeleteSecretary() {
        clickElement(deleteSecretary);
        return this;
    }


    public SecretarysPage returnToSecretarysPage() {
        clickElement(arrowButton);
        return new SecretarysPage(driver);
    }
    public SecretarysEditDetailsPage openSecretarysDetailsPage() {
            clickElement(secretaryDetailsTab);
            return new SecretarysEditDetailsPage (super.driver);
        }

    public SecretarysEditDetailsPage viewEditSecretaryDetailsPage() {
        clickElement(editSecretaryDetailsTab);
        return this;
    }

    public SecretarysEditDetailsPage editName(String name) {
        fillField(firstNameInput, name);
        verifyInputSurName(name);
        return this;
    }

    public SecretarysEditDetailsPage editSurname(String surname) {
        fillField(lastNameInput, surname);
        verifyInputSurName(surname);
        return this;
    }

    public SecretarysEditDetailsPage editEmail(String email) {
        verifyInputEmail(email);
        fillField(emailInput, email);
        return this;
    }

    public SecretarysEditDetailsPage verifyInputName(String name) {
        softAssert.assertEquals(firstNameInput.getAttribute("value"), name);
        return new SecretarysEditDetailsPage(driver);
    }

    public SecretarysEditDetailsPage verifyInputSurName(String lastName) {
        softAssert.assertEquals(lastNameInput.getAttribute("value"), lastName);
        return this;
    }

    public SecretarysEditDetailsPage verifyInputEmail(String email) {
        softAssert.assertEquals(emailInput.getAttribute("value"), email);
        return this;
    }

    public SecretarysPage returnToSecretaryPage() {
        clickElement(arrowButton);
        return new SecretarysPage(driver);

    }

    public SecretarysEditDetailsPage viewSecretaryEditDetailsTab() {
        clickElement(secretaryDetailsTab);
        return this;
    }

    public SecretarysEditDetailsPage fillDetEmailInput(String email) {
        fillField(emailInput, email);
        return this;
    }

    public SecretarysEditDetailsPage fillDetFirstName(String firstName) {
        fillField(firstNameInput, firstName);
        return this;
    }

    public SecretarysEditDetailsPage fillDetLastName(String lastName) {
        fillField(lastNameInput, lastName);
        return this;
    }

        public SecretarysEditDetailsPage viewEditSecretaryDetailsTab() {
            clickElement(editSecretaryDetailsTab);
            return this;
        }

    @Override
    public boolean isAt() {
        return secretaryDetailsTab.getText().equals("Secretary's details");
    }

}


