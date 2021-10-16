package page.lessons;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import java.util.List;

import static constants.Locators.Lessons.*;

public class LessonsPage extends Page<LessonsPage> {

    @FindBy(xpath = ADD_LESSON_BUTTON_XPATH)
    WebElement addLessonButton;

    @FindBy(xpath = TABLE_ROWS_XPATH)
    List<WebElement> rows;

    @FindBy(xpath = EDIT_LESSON_PENCIL_ICON_XPATH)
    List<WebElement> edit;

    @FindBy(xpath = ALERT_XPATH)
    WebElement alert;

    public LessonsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.LESSONS);
    }

    public static LessonsPage init(WebDriver driver){
        return new LessonsPage(driver);
    }

    public AddLessonPage clickAddLessonButton(){
        clickElement(addLessonButton);
        return new AddLessonPage(driver);
    }

    public Integer getRowsCount(){
        return rows.size();
    }

    public String getAlertText(){
        return alert.getText();
    }

    public LessonDetailsPage clickTableItem(int id){
        rows.get(id).click();
        return new LessonDetailsPage(driver);
    }

    public EditLessonPage clickEditIcon(int id){
        edit.get(id).click();
        return new EditLessonPage(driver);
    }

    public boolean isLessons(){
        return rows.size() != 0;
    }

    public List<WebElement> getEdit() {
        return edit;
    }

    public WebElement getAlert() {
        return alert;
    }


}
