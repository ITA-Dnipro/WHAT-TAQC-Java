package page.myProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.changePassword.ChangePasswordPage;

import java.util.List;

import static constants.Locators.MyProfile.CHANGE_PASSWORD_BUTTON;
import static constants.Locators.MyProfile.LIST_OF_USER_DATA_XPATH;

public class MyProfilePage extends Page<MyProfilePage> {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = CHANGE_PASSWORD_BUTTON)
    private WebElement changePasswordButton;
    @FindBy(xpath = LIST_OF_USER_DATA_XPATH)
    private List<WebElement>listData;
    @Override
    public boolean isAt() {
        return changePasswordButton.isEnabled();
    }

    public ChangePasswordPage clickChangePasswordButton() {
        clickElement(changePasswordButton);
        return new ChangePasswordPage(driver);
    }
    public String nameUser(){
        return listData.get(0).getText();
    }
    public String surNameUser(){
        return listData.get(1).getText();
    }
    public String emailUser(){
        return listData.get(2).getText();
    }
    public MyProfilePage verifyFirstName(String name){
        softAssert.assertEquals(nameUser(),name);
        return this;
    }
    public MyProfilePage verifyLastName(String last){
        softAssert.assertEquals(surNameUser(),last);
        return this;
    }
    public MyProfilePage verifyEmail(String email){
        softAssert.assertEquals(emailUser(),email);
        return this;
    }
}
