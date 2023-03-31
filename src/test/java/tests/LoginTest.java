package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void precondition() {
            }

    @Test
    public void testLoginPositiveFirstWay() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
        Assert.assertTrue(TestBase.app.getUser().isLogged());
        app.getUser().logout();
    }
    @Test
    public void testLoginPositiveSecondWay() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationFormSecondWay();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
        Assert.assertTrue(TestBase.app.getUser().isLogged());
        app.getUser().logout();
    }

    @Test
    public void testLoginNegativePass() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234").build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
        Assert.assertTrue(TestBase.app.getUser().getTextErrorLogin().contains("Submit"));
        app.getUser().closeLoginRegistrationForm();
    }
    @Test
    public void testLoginNegativeEmail() {
        User user = User.builder().email("abcdmail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
        Assert.assertTrue(TestBase.app.getUser().getTextErrorLogin().contains("Submit"));
        app.getUser().closeLoginRegistrationForm();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //  wd.close();
        //  wd.quit();
    }
}
