package base;


import page.StudentsPage;
import page.base.LogIn;
import util.Admin;
import java.io.IOException;

public class Test extends BaseTest{

    public Test() throws IOException {
    }

    @org.testng.annotations.Test
    public void test() {
        LogIn logIn = new LogIn(driver);
        logIn.logInAs(new Admin(), StudentsPage.class);
    }
}
