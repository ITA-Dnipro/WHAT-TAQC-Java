package page.secretarys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.Locators.EditSecretary.*;



public class SecretarysEditDetailsTab extends SecretarysEditDetailsPage <SecretarysEditDetailsTab>{

    public SecretarysEditDetailsTab(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = SECRETARY_DETAILS_TAB_XPATH)
    protected WebElement secretaryPageTitle;
    @FindBy(xpath = SECRETARIES_FIRST_NAME_WINDOW_XPATH)
    protected WebElement firstNameInput;
    @FindBy(xpath = SECRETARIES_LAST_NAME_WINDOW_XPATH)
    protected WebElement lastNameInput;
    @FindBy(xpath = SECRETARIES_EMAIL_WINDOW_XPATH)
    protected WebElement emailInput;
    @FindBy(xpath = SECRETARIES_SAVE_BUTTON_XPATH)
    protected WebElement saveButton;
    @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    protected WebElement editSecretaryTab;
    @FindBy(xpath = SECRETARY_DETAILS_ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = SECRETARY_DETAILS_TAB_XPATH)
    protected WebElement secretaryDetailsTab;
    @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    protected WebElement editSecretaryDetailsTab;
    @FindBy(xpath = SECRETARIES_CLEAR_BUTTON_XPATH)
    protected WebElement clearButton;
    @FindBy(xpath = SECRETARIES_SAVE_BUTTON_XPATH )
    protected WebElement getSaveButton;


        public SecretarysPage backToSecretariesTab() {
        clickElement(arrowButton);
        return new SecretarysPage(driver);
    }

    public SecretarysDetailsTab openSecretaryEditDetailsTab() {
        clickElement(editSecretaryTab);
        return new SecretarysDetailsTab(driver);
    }

    public SecretarysEditDetailsTab viewEditSecretaryDetailsTab() {
        clickElement(editSecretaryDetailsTab);
        return this;
    }

    public SecretarysEditDetailsTab editName(String name) {
        fillField(firstNameInput, name);
        verifyInputSurName(name);
        return this;
    }

    public SecretarysEditDetailsTab editSurname(String surname) {
        fillField(lastNameInput, surname);
        verifyInputSurName(surname);
        return this;
    }

    public SecretarysEditDetailsTab editEmail(String email) {
        verifyInputEmail(email);
        fillField(emailInput, email);
        return this;
    }

    public SecretarysEditDetailsTab saveSecretary() {
        clickElement(saveButton);
        return new SecretarysEditDetailsTab(driver);
    }

    public SecretarysEditDetailsTab verifyInputName(String name) {
        softAssert.assertEquals(firstNameInput.getText(), name);
        return new SecretarysEditDetailsTab(driver);
    }

    public SecretarysEditDetailsTab verifyInputSurName(String lastName) {
        softAssert.assertEquals(lastNameInput.getText(), lastName);
        return new SecretarysEditDetailsTab(driver);
    }

    public SecretarysEditDetailsTab verifyInputEmail(String email) {
        softAssert.assertEquals(emailInput.getText(), email);
        return new SecretarysEditDetailsTab(driver);
    }

    public SecretarysPage returnToSecretaryPage() {
        clickElement(arrowButton);
        return new SecretarysPage(driver);

    }

    public SecretarysEditDetailsTab openSecretaryDetailsTab() {
        clickElement(secretaryDetailsTab);
        return new SecretarysEditDetailsTab(driver);
    }

    public SecretarysEditDetailsTab viewSecretaryEditDetailsTab() {
        clickElement(secretaryDetailsTab);
        return this;
    }


    public SecretarysEditDetailsTab fillDetEmailInput(String email) {
        fillField(emailInput, email);
        return this;
    }

    public SecretarysEditDetailsTab fillDetFirstName(String firstName) {
        fillField(firstNameInput, firstName);
        return this;
    }

    public SecretarysEditDetailsTab fillDetLastName(String lastName) {
        fillField(lastNameInput, lastName);
        return this;
    }

    @Override
    public boolean isAt() {
        return secretaryDetailsTab.getText().equals("Secretary's details");
    }

}



