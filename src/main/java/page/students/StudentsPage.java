package page.students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.Page;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsPage.*;

public class StudentsPage extends Page {

    @FindBy (xpath = TABLE_HEAD_FIRST_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy (xpath = TABLE_HEAD_LAST_NAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy (xpath = TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy (className = SEARCH_INPUT_BOX_CLASSNAME)
    protected WebElement searchInputFieldBox;
    @FindBy (tagName = PAGE_TITLE_TAG_NAME)
    protected WebElement pageName;
    @FindBy (xpath = TABLE_STUDENTS_XPATH)
    protected WebElement tableStudents;

    public StudentsPage(WebDriver driver){
        super(driver);
    }

    public List<List<String>> getItemsFromTable(){
        List<WebElement> tableStudentsRows = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfNestedElementsLocatedBy(tableStudents, By.tagName(TABLE_ROW_TAG_NAME)));
        List<List<String>> list = tableStudentsRows.stream()
                .map(row -> row.findElements(By.tagName("td"))
                        .stream()
                        .limit(3)
                        .map(WebElement::getText)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        return list;
    }

}
