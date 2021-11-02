package page.students;

import constants.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.mentors.MentorsTablePage;
import page.unassigned.UnassignedUsersPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsPage.*;

public class StudentsPage extends Page<StudentsPage> {

    @FindBy(tagName = PAGE_TITLE_TAG_NAME)
    protected WebElement pageName;
    @FindBy(className = SEARCH_INPUT_BOX_CLASSNAME)
    protected WebElement searchInputFieldBox;
    @FindBy(id = SHOW_DISABLED_SWITCHER_ID)
    protected WebElement showDisabledSwitcher;
    @FindBy(xpath = ADD_STUDENT_BUTTON_XPATH)
    protected WebElement addStudentButton;
    @FindBy(xpath = TABLE_STUDENTS_XPATH)
    protected WebElement tableStudents;
    @FindBy(xpath = TABLE_HEAD_FIRST_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = TABLE_HEAD_LAST_NAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(tagName = TABLE_ROW_TAG_NAME)
    protected List<WebElement> tableStudentsRows;

    public StudentsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.STUDENTS);
    }

    public UnassignedUsersPage addStudent() {
        clickElement(addStudentButton);
        return new UnassignedUsersPage(driver);
    }



    private List<WebElement> findRows(String value) {
        List<WebElement> suitableList = tableStudentsRows.stream()
                .filter(row -> {
                    List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                            .stream()
                            .limit(3)
                            .filter(cellValue -> cellValue.getText().equals(value))
                            .collect(Collectors.toList());
                    return !listCells.isEmpty();
                })
                .collect(Collectors.toList());
        return suitableList;
    }

    public WebElement findStudentRowInTableByEmail(String email){
        return findRows(email)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public boolean verifyAddStudentButtonIsEnable(){
        return addStudentButton.isEnabled();
    }

//    public StudentEditDetailsTab openStudentEditDetailsTab (User user){
//        WebElement row = findStudentRowInTableByEmail(user.getMail());
//        List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME));
//        WebElement cellWithPencilIcon = listCells.stream()
//                .skip(3)
//                .findAny()
//                .orElse(null);
//        clickElement(cellWithPencilIcon);
//        return new StudentEditDetailsTab(driver);
//    }
//
//    public StudentDetailsTab openStudentDetailsTab (User user){
//        WebElement row = findStudentRowInTableByEmail(user.getMail());
//        clickElement(row);
//        return new StudentDetailsTab(driver);
//    }

}