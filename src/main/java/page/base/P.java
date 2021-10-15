package page.base;

import org.openqa.selenium.WebDriver;

public class P extends Page<P>{


    public P(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
