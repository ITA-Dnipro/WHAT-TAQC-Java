package page.unassigned;

import constants.Endpoints;
import constants.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.courses.CoursesPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.Lessons.TABLE_ROWS_XPATH;
import static constants.Locators.Pagination.*;
import static constants.Locators.UnassignedUsers.*;

public class UnassignedUsersPage extends Page<UnassignedUsersPage>  {
    @FindBy(xpath = SEARCH_INPUT_FIELD_XPATH)
    protected WebElement searchInputField;
    @FindBy(xpath = TABLE_HEAD_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = TABLE_HEAD_SURNAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(xpath = TABLE_UNASSIGNED_USERS_XPATH)
    protected WebElement table;
    @FindBy(tagName = TABLE_ROW_TAG_NAME)
    protected List<WebElement> tableRows;
    @FindBy(xpath = FIRST_PAGE)
    protected WebElement firstPage;
    @FindBy(xpath = SECOND_PAGE)
    protected WebElement secondPage;
    @FindBy(xpath = THIRD_PAGE)
    protected WebElement thirdPage;
    @FindBy(xpath = FOURTH_PAGE)
    protected WebElement fourthPage;
    @FindBy(xpath = TABLE_ROWS_XPATH)
    protected WebElement usersFromTable;
    @FindBy(xpath = BACK_ARROW)
    protected WebElement backArrow;

    public UnassignedUsersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.UNASSIGNED_USERS);
    }

    public UnassignedUsersPage addRole(String email, UnassignedRole role) {
        WebElement row = findUserRowByEmail(email);
        clickElement(row
                .findElement(By.tagName(TABLE_ROLES_DROPDOWN_MENU_TAG_NAME)));
        List<WebElement> options = row
                .findElements(By.tagName(TABLE_ROLE_DROPDOWN_MENU_OPTIONS_TAG_NAME));
        for (WebElement option : options) {
            if (role.getOption().equals(option.getText()))
                clickElement(option);
        }
        clickElement(row.findElement(By.tagName(TABLE_ADD_ROLE_BUTTON_TAG_NAME)));
        return this;
    }

    public boolean isUserPresented(String email) {
        if (findUserRowByEmail(email) == null) {
            return false;
        }
        return true;
    }

    public WebElement findUserRowByEmail(String email) {
        WebElement rowUser;
        do {

            rowUser = tableRows.stream()
                    .filter(row -> {
                        List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                                .stream()
                                .limit(3)
                                .filter(cellValue -> cellValue.getText().equals(email))
                                .collect(Collectors.toList());
                        return !listCells.isEmpty();
                    })
                    .findFirst().orElse(null);
            if (pagination.isCurrentPageLast()) {
                return rowUser;
            }
            if (rowUser == null) {
                pagination.openNextPage(this);
            }
        } while (rowUser == null);
        return rowUser;
    }

    public UnassignedUsersPage sortByName() {
        clickElement(tableHeadFirstName);
        return this;
    }

    public UnassignedUsersPage sortBySurName() {
        clickElement(tableHeadLastName);
        return this;
    }

    public UnassignedUsersPage sortByEmail() {
        clickElement(tableHeadEmail);
        return this;
    }

    public List<String> getUnassignedUsersName() {
        List<String> mentorsNames = new ArrayList<String>();
        for (int i = 0; i < tableRows.size(); i = i + 3) {
            mentorsNames.add(tableRows.get(i).getText());
        }
        return mentorsNames;
    }

    public List<String> getUnassignedUsersSurname() {
        List<String> mentorsSurname = new ArrayList<String>();
        for (int i = 1; i < tableRows.size(); i = i + 3) {
            mentorsSurname.add(tableRows.get(i).getText());
        }
        return mentorsSurname;
    }

    public List<String> getUnassignedUsersEmail() {
        List<String> mentorsNames = new ArrayList<String>();
        for (int i = 0; i < tableRows.size(); i = i + 3) {
            mentorsNames.add(tableRows.get(i).getText());
        }
        return mentorsNames;
    }

    public UnassignedUsersPage clickOnPaginationPage(int numberOfPage) {
        if (numberOfPage == 1) {
            clickElement(firstPage);
        }
        if (numberOfPage == 2) {
            clickElement(secondPage);
        }
        if (numberOfPage == 3) {
            clickElement(thirdPage);
        }
        if (numberOfPage == 4) {
            clickElement(fourthPage);
        }
        return this;
    }

    public int getNumberOfUsersOnThePage() {
        List<WebElement> elements = driver.findElements(By.xpath(TABLE_ROWS_XPATH));
        return elements.size();
    }

    public UnassignedUsersPage clickOnBackArrow(int numberOfClick) {
        for (int i = 0; i < numberOfClick; i++) {
            clickElement(backArrow);
        }
        return this;
    }

}

