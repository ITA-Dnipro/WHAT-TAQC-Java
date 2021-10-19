package page.secretarys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.Locators.EditSecretary.*;

public class SecretarysDetailsTab extends SecretarysEditDetailsPage {


    @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    WebElement secretaryEditDetailsTab;
    @FindBy(tagName = SECRETARIES_DETAILS_TITLE)
    protected WebElement pageTitle;
    @FindBy(xpath = SECRETARIES_DETAILS_FNAME)
    protected WebElement firstName;
    @FindBy(xpath = SECRETARIES_DETAILS_LNAME)
    protected WebElement lastName;
    @FindBy(xpath = SECRETARIES_DETAILS_EMAIL)
    protected WebElement email;



    public SecretarysDetailsTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return secretaryEditDetailsTab.getText().equals("Secretary's details");
    }
}
