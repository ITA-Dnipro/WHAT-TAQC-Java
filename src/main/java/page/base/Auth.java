package page.base;

import constants.Endpoints;
import constants.PathsToFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.StudentsPage;
import page.lessons.LessonsPage;
import util.Role;
import util.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static constants.Locators.Auth.*;

public class Auth extends BasePage{

    @FindBy(name = EMAIL_INPUT_FIELD_NAME)
    WebElement mailInput;

    @FindBy(name = PASSWORD_INPUT_FIELD_NAME)
    WebElement passInput;

    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    WebElement signInButton;

    Map <String, Page> defaultPages;
    Map<String, User> users;


    public Auth(WebDriver driver) throws IOException {
        super(driver);
        users = User.get(PathsToFiles.CREDENTIALS);
        defaultPages = new HashMap<>();
        initDefaultPages();
    }

    public Auth fillMail(String mail){
        fillField(mailInput, mail);
        return this;
    }

    public Auth fillPass(String pass){
        fillField(passInput, pass);
        return this;
    }

     public static Auth init(WebDriver driver) throws IOException {
        return new Auth(driver);
     }



     public <T extends Page> T logInAs(Role role, Class<T> type){
        fillMail(users.get(role.getRoleName()).getMail())
                .fillPass(users.get(role.getRoleName()).getPass())
                .clickLogInButton();
         return type.cast(defaultPages.get(role.getRoleName()));
     }

    private void initDefaultPages(){
        defaultPages.put(Role.ADMIN.getRoleName(), new StudentsPage(driver));
        defaultPages.put(Role.MENTOR.getRoleName(), new LessonsPage(driver));
    }

    public boolean isAt(){
        return driver.getCurrentUrl().equals(Endpoints.AUTH);
    }

    public void clickLogInButton(){
        clickElement(signInButton);
    }
}
