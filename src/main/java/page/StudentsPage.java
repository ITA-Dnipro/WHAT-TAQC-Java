package page;

import org.openqa.selenium.WebDriver;
import page.base.Page;

public class StudentsPage extends Page<StudentsPage> {


    public StudentsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public StudentsPage getStudent(){
        return this;
    }
}
