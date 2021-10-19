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
    @FindBy(xpath = SECRETARIES_CLEAR_BUTTON_XPATH)
    protected WebElement clearButton;
    @FindBy(xpath = SECRETARIES_SAVE_BUTTON_XPATH )
    protected WebElement saveButton;

    public SecretarysEditDetailsTab fillDetEmailInput(String email) {
            fillField(emailInput, email);
            return this;
        }

        public SecretarysEditDetailsTab fillDetFirstName(String firstName) {
            fillField(firstNameInput, firstName);
            return this;
        }
        public SecretarysEditDetailsTab fillDetLasttName(String lastName) {
            fillField(lastNameInput, lastName);
            return this;
        }



    @Override
    public boolean isAt() {
        return secretaryPageTitle.getText().equals("Edit Secretary's details");
   }
}
