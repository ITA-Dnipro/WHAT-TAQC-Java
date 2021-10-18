package page.lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BaseElement;
import java.util.List;
import static constants.Locators.ClassBook.*;

public class ClassBookFeature extends BaseElement {

    @FindBy(xpath = LIST_OF_STUDENTS_XPATH)
    private List<WebElement>  listOfStudents;

    @FindBy(xpath = LIST_OF_MARKS_XPATH)
    private List<WebElement> listOfMarks;

    @FindBy(xpath = LIST_OF_PRESENCE_TIP_XPATH)
    private List<WebElement> listOfTips;

    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement saveButton;

    public ClassBookFeature(WebDriver driver) {
        super(driver);
    }

    public Integer getStudentIdByName(String name){
        for (int i = 0; i < listOfStudents.size(); i++){
            if (listOfStudents.get(i).getText().equals(name)){
                return i;
            }
        }
        return null;
    }

    public ClassBookFeature setPresence(Integer studentId){
        clickElement(listOfTips.get(studentId));
        return this;
    }

    public ClassBookFeature putMark(Integer studentId, String mark){
        fillField(listOfMarks.get(studentId), mark);
        return this;
    }

    public LessonsPage clickSaveButton(){
        clickElement(saveButton);
        return new LessonsPage(driver);
    }

    public List<WebElement> getListOfStudents() {
        return listOfStudents;
    }

    public List<WebElement> getListOfMarks() {
        return listOfMarks;
    }

    public List<WebElement> getListOfTips() {
        return listOfTips;
    }
}
