package page.secretarys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.mentors.MentorsTablePage;
import page.unassigned.UnassignedUsersPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Locators.EditSecretary.SECRETARIES_LAY_OFF_BUTTON_XPATH;
import static constants.Locators.EditSecretary.SECRETARIES_SAVE_BUTTON_XPATH;
import static constants.Locators.Secretaries.*;


public class SecretarysPage extends Page<SecretarysPage> {
    public SecretarysPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = SECRETARY_PAGE_TITLE_XPATH)
    protected WebElement pageName;
    @FindBy(xpath = SEARCH_WINDOW_SECRETARIES_NAME_XPATH)
    protected WebElement searchInputFieldBox;
    @FindBy(xpath = SWITCH_VIEW_DISABLED_SECRETARIES_XPATH)
    protected WebElement showDisabledSwitcher;
    @FindBy(xpath = ADD_SECRETARY_BUTTON_XPATH)
    protected WebElement addSecretaryButton;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_SURNAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = SECRETARY_TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(xpath = SECRETARY_ROW_XPATH)
    protected List<WebElement> secretaryRow;
    @FindBy(xpath = SECRETARY_EDIT_ICON_XPATH)
    List<WebElement> editIcon;

    public UnassignedUsersPage addSecretary() {
        clickElement(addSecretaryButton);
        return new UnassignedUsersPage(driver);
    }

    public List<String> getSecretaryData() {
        List<String> secretaryData = new ArrayList<String>();

        for (int i = 0; i < secretaryRow.size(); i++) {
            secretaryData.add(secretaryRow.get(i).getText());
        }
        return secretaryData;
    }
    public List<String> getSecretaryName() {
        List<String> secretaryName  = new ArrayList<String>();
        for (int i = 0; i < secretaryRow.size(); i= + 3) {
            secretaryName.add(secretaryRow.get(i).getText());
        }
        return secretaryName;
    }

    public static SecretarysPage init(WebDriver driver) {
        return new SecretarysPage(driver);
    }

    public SecretarysPage inputSearchSecretary(String nameSurName) {
        fillField(searchInputFieldBox, "a");
        fillField(searchInputFieldBox, nameSurName);
        return this;
    }

    public SecretarysPage verifyInputSearchSecretary(String search) {
        softAssert.assertEquals(searchInputFieldBox.getAttribute("value"), search);
        return this;
    }

    public SecretarysPage verifySecretarysDataInTheTable(List<String> secretarysData) {
        softAssert.assertEquals(getSecretaryData(), secretarysData);
        return this;
    }

    public SecretarysPage sortByName() {
        clickElement(tableHeadFirstName);
        return this;
    }

    public SecretarysPage sortBySurName() {
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
    public SecretarysPage verifySortByNameASC(){
        List<String> actualResult = getSecretaryName();
        List<String> expectedResult = actualResult;
        Collections.sort(expectedResult);
        softAssert.assertEquals(actualResult, expectedResult);
        return this;
    }
    public SecretarysPage verifySortByNameDEC(){
        List<String> actualResult = getSecretaryName();
        List<String> expectedResult = actualResult;
        Collections.sort(expectedResult);
        Collections.sort(expectedResult);
        softAssert.assertEquals(actualResult, expectedResult);
        return this;
    }
public SecretarysPage verifySorttBySurNameASC() {
    List<String> actualResult = getSecretarySurName();
    List<String> expectResult = actualResult;
    Collections.sort(expectResult);
    return this;
}
    public SecretarysPage verifySortBySurNameDEC() {
        List<String> actualResult = getSecretarySurName();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        Collections.reverse(expectResult);
        softAssert.assertEquals(actualResult,expectResult);
        return this;
    }

    public List<String> getSecretarySurName() {
        List<String> secretarySurName = new ArrayList();
        for (int i = 1; i < secretaryRow.size(); i = i + 3) {
            secretarySurName.add(secretaryRow.get(i).getText());
        }
        return secretarySurName;
    }
        public SecretarysPage verifySortByEmailDEC() {
            List<String> actualResult = getSecretaryEmail();
            List<String> expectResult = actualResult;
            Collections.sort(expectResult);
            Collections.reverse(expectResult);
            softAssert.assertEquals(actualResult, expectResult);
            return this;
        }

    public SecretarysPage verifySortByEmailASC() {
        List<String> actualResult = getSecretaryEmail();
        List<String> expectResult = actualResult;
        Collections.sort(expectResult);
        softAssert.assertEquals(actualResult, expectResult);
        return this;
    }
        public List<String> getSecretaryEmail() {
            List<String> secretaryEmail = new ArrayList<String>();
            for (int i = 2; i < secretaryRow.size(); i = i + 3) {
                secretaryEmail.add(secretaryRow.get(i).getText());
            }
            return secretaryEmail;
        }
    public SecretarysEditDetailsPage openSecretaryEditDetailsTab(Integer index) {
        clickElement(editIcon.get(index));
        return new SecretarysEditDetailsPage (driver);
    }
    public SecretarysPage verifySecretaryDataInTheTable(List<String> secretarysData) {
       softAssert.assertEquals(getSecretaryData(),secretarysData);
        return this;
    }

    @Override
    public boolean isAt() {
        return pageName.getText().equals("Secretaries");
    }
}