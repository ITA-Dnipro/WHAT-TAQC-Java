package page.secretarys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;


import static constants.Locators.EditSecretary.*;

abstract public class SecretarysEditDetailsPage <T extends Page<T>> extends Page<T> {
    @FindBy(xpath = SECRETARY_DETAILS_ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = SECRETARY_DETAILS_TAB_XPATH )
    protected WebElement secretaryDetailsTab;
    @FindBy(xpath = EDIT_SECRETARY_TAB_XPATH)
    protected WebElement editSecretaryDetailsTab;


    public SecretarysEditDetailsPage(WebDriver driver) {
        super(driver);
    }

    public SecretarysPage returnToSecretarysPage() {
        clickElement(arrowButton);
        return new SecretarysPage(driver);
    }
    public SecretarysDetailsTab openSecretarysDetailsPage() {
            clickElement(secretaryDetailsTab);
            return new SecretarysDetailsTab(super.driver);
        }

    public SecretarysEditDetailsTab openSecretarysDetailsTab() {
        clickElement(secretaryDetailsTab);
        return new SecretarysEditDetailsTab(driver);
    }

}


