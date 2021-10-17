package page.groups;

import org.openqa.selenium.WebDriver;
import page.base.Page;

public class EditGroupPage extends Page<EditGroupPage> {
    public EditGroupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
