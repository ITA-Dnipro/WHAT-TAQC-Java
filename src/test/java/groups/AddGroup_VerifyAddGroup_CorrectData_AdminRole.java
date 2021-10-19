package groups;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.groups.GroupsPage;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddGroup_VerifyAddGroup_CorrectData_AdminRole extends BaseTest {

    protected GroupsPage groupsPage;

    @BeforeClass
    public void precondition() throws IOException {
        groupsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.GROUPS, GroupsPage.class)
                .isAtPage(waitTime);
    }

    @Test
    public void verifyAddLesson() throws IOException {

        String expectedResult = "×\nClose alert\nThe group has been successfully added!";

        String actualResult = groupsPage
                .clickAddGroupButton().isAtPage(this.waitTime)
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
