package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void precondition() {

    }

    @Test
    public void testLoginPositive() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(TestBase.app.getUser().isLogged());

    }

    @Test
    public void testLoginNegativePass() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234").build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(TestBase.app.getUser().getTextErrorLogin().contains("Submit"));
        app.getUser().closeLoginForm();
    }
    @Test
    public void testLoginNegativeEmail() {
        User user = User.builder().email("abcdmail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(TestBase.app.getUser().getTextErrorLogin().contains("Submit"));
        app.getUser().closeLoginForm();
    }

}
