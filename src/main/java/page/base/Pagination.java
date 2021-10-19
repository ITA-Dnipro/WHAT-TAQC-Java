package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.Locators.Pagination.*;

public class Pagination extends BaseElement {

    @FindBy(xpath = PAGES_XPATH)
    private List<WebElement> pages;
    @FindBy(xpath = NEXT_PAGE_ARROW_BUTTON_XPATH)
    private WebElement nextPageArrowButton;

    public Pagination(WebDriver driver) {
        super(driver);
    }

    public <T extends Page<T>> T openNextPage(T page) {
        if (!isCurrentPageLast()) {
            clickElement(nextPageArrowButton);
        }
        return page;
    }

    public boolean isCurrentPageLast() {
        WebElement currentPage = pages.stream()
                .filter(element -> element.getAttribute("class").contains("active"))
                .findFirst().orElse(null);
        return pages.get(pages.size() - 1).getText().equals(currentPage.getText());
    }
}
