package groups;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.groups.GroupsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditGroup_VerifyEditGroup_CorrectData_AdminRole extends BaseTest {

    protected GroupsPage groupsPage;

    @BeforeClass
    public void precondition() throws IOException {

        groupsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.GROUPS, GroupsPage.class)
                .isAtPage(waitTime);

        if (!groupsPage.isGroups()){
            groupsPage = groupsPage
                    .clickAddGroupButton()
                    .isAtPage(waitTime)
                    .addGroupForTest();
        }
    }

    @Test
    public void editLessonTest(){

        String expectedResult = "×\nClose alert\nThe lesson has been successfully edited!";

        String actualResult = groupsPage
                .clickEditIcon(0).isAtPage(this.waitTime)
                .fillGroupName(RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5))
                .selectCourse()
                .fillStartDate(LocalDate.now()
                        .format(DateTimeFormatter.ofPattern("ddMMyyyy")))
                .fillFinishDate(LocalDate.now().plusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyy")))
                .clickConfirmButton()
                .isAtPage(waitTime)
                .getAlertText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
