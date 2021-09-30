package constants;

public class Locators {

    private Locators(){}

    public interface CommonElements{
        String SIDE_BAR_XPATH = "//body//span[@class='sidebar__menu-item___1MMsk']";
    }

    public interface Lessons{
        String ADD_LESSON_BUTTON_XPATH = "//button[contains(.,'Add a lesson')]";
        String FILTER_BUTTON_XPATH = "//button[contains(.,'Filter')]";
    }
}