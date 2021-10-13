package lessons;

import base.BaseTest;
import base.Role;
import constants.Endpoints;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;

public class EditLesson_VerifyEditLesson_CorrectData_UsedAdminMentorRole extends BaseTest {

    private static final Logger logger =
            Logger.getLogger(EditLesson_VerifyEditLesson_CorrectData_UsedAdminMentorRole.class.getName());

    LessonsPage lessons;
    EditLessonPage editLessonPage;

    @BeforeClass
    public void preconditions(){
        lessons = new LessonsPage(driver);
        driver.get(Endpoints.BASE_URL);
    }

    @DataProvider(name = "roles")
    public Object[][] returnRoles(){
        return new Object[][]{{Role.ADMIN, "editedName", "0303202000:02"}, {Role.MENTOR, "emaNdetide", "0303202001:00"}};
    }

    @Test(dataProvider = "roles")
    public void verifyEditLesson(Role role, String name, String date){

        helper.logInAs(role);
        driver.get(Endpoints.LESSONS);

        if (lessons.getEdit().size() != 0){
            editLessonPage = lessons.clickEditIcon(1);
        }
        else {
            logger.info("Test is blocked! User haven't got lessons");
            return;
        }

        SoftAssert softAssert = new SoftAssert();
        editLessonPage.setSoftAssert(softAssert);
        helper.waitForRedirectFrom(Endpoints.LESSONS);
        editLessonPage.fillLessonThemeInput(name, null)
                .fillTimeInput(date)
                .clickSaveButton();
        helper.waitForRedirectFrom(driver.getCurrentUrl());
        softAssert.assertEquals(driver.getCurrentUrl(), Endpoints.LESSONS);
        softAssert.assertAll();

        helper.logOut(lessons);
    }
}
