package util;

import org.openqa.selenium.WebDriver;
import page.StudentsPage;

public class Admin extends User{

    public static StudentsPage getBasePage(WebDriver driver){
        return new StudentsPage(driver);
    }

}



