package page.base;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.StudentsPage;
import page.lessons.LessonsPage;
import util.Admin;
import util.Mentor;
import util.Role;
import util.User;

import java.util.HashMap;
import java.util.Map;

import static constants.Locators.Auth.*;

public class LogIn extends BasePage{

    @FindBy(name = EMAIL_INPUT_FIELD_NAME)
    WebElement mailInput;

    @FindBy(name = PASSWORD_INPUT_FIELD_NAME)
    WebElement passInput;

    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    WebElement signInButton;

    Map <String, Page> defaultPages;

    public LogIn(WebDriver driver) {
        super(driver);
        defaultPages = new HashMap<>();
        defaultPages.put("admin", new StudentsPage(driver));
        defaultPages.put("mentor", new LessonsPage(driver));

    }

    public LogIn fillMail(String mail){
        fillField(mailInput, mail);
        return this;
    }

    public LogIn fillPass(String pass){
        fillField(passInput, pass);
        return this;
    }

     public static LogIn init(WebDriver driver){
        return new LogIn(driver);
     }


     public <T extends Page> T logInAs(Role role, Class<T> type){

         return type.cast(defaultPages.get("admin"));

     }

    public boolean isAt(){
        return driver.getCurrentUrl().equals(Endpoints.AUTH);
    }

    public void clickLogInButton(){
        clickElement(signInButton);
    }
}
