package page.courses;

import org.openqa.selenium.WebDriver;
import page.base.SideBar;

import static page.base.SideBar.SideMenuItem.COURSES;

public class MentorsPage extends PageObject{

    private String pageUrl = "http://localhost:8080/mentors";

    SideBar sideBar = new SideBar(driver);

    public MentorsPage(WebDriver driver) {
        super(driver);
    }

    public String getMentorPageUrl() {
        return pageUrl;
    }

    public Courses redirectToCoursesPage() {
        sideBar.getSideBarItem(COURSES).click();
        return new Courses(driver);
    }
}
