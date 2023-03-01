package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {
    @BeforeMethod
    public void precondition() {

    }

    @Test
    public void registrationTestSuccessFirstWay() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .name("Gilad")
                .email("abcd" + i + "@mail.com")
                .password("Abcd" + i + "1234$")
                .build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().pause(2000);
        app.getUser().crossToSignUpForm();
        app.getUser().pause(2000);
        app.getUser().fillRegistrationForm(user);
        app.getUser().submit();
        app.getUser().pause(2000);
        //  Assert.assertTrue(TestBase.app.getUser().isRegistered());
        Assert.assertTrue(
                app.getUser().getText(By.xpath("//div[@style='margin-left:" +
                        " 12vw; display: flex; align-items: center;']")).contains(user.getName()));
        app.getUser().logout();

    }

    @Test
    public void registrationTestSuccessSecondWay() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .name("Gilad")
                .email("abcd" + i + "@mail.com")
                .password("Abcd" + i + "1234$")
                .build();
        app.getUser().openLoginRegistrationFormSecondWay();
        app.getUser().pause(2000);
        app.getUser().crossToSignUpForm();
        app.getUser().pause(2000);
        app.getUser().fillRegistrationForm(user);
        app.getUser().submit();
        app.getUser().pause(2000);
        //  Assert.assertTrue(TestBase.app.getUser().isRegistered());
        Assert.assertTrue(
                app.getUser().getText(By.xpath("//div[@style='margin-left:" +
                        " 12vw; display: flex; align-items: center;']")).contains(user.getName()));
        app.getUser().logout();
    }
    @Test
    public void registrationTestNegativeExistUser() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .name("Gilad")
                .email("abcd@mail.com")
                .password("Abcd1234$")
                .build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().pause(2000);
        app.getUser().crossToSignUpForm();
        app.getUser().pause(2000);
        app.getUser().fillRegistrationForm(user);
        app.getUser().submit();
        app.getUser().pause(2000);
        Assert.assertTrue(TestBase.app.getUser().getTextExistUser().contains("User with this email already exists"));
        app.getUser().closeLoginRegistrationForm();
    }
}