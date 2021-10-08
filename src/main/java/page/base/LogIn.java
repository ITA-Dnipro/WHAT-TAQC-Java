package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.Locators.Auth.*;

public class LogIn extends BasePage{

    @FindBy(name = EMAIL_INPUT_FIELD_NAME)
    WebElement mailInput;

    @FindBy(name = PASSWORD_INPUT_FIELD_NAME)
    WebElement passInput;

    @FindBy(xpath = SIGN_IN_BUTTON)
    WebElement signInButton;

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public LogIn fillMail(String mail){
        fillField(mailInput, mail);
        return this;
    }

    public LogIn fillPass(String pass){
        fillField(passInput, pass);
        return this;
    }

    public void clickLogInButton(){
        clickElement(signInButton);
    }
}
