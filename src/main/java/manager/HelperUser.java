package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginRegistrationFormFirstWay() {
        click(By.xpath("//div[text()='Sign in']"));
    }
    public void openLoginRegistrationFormSecondWay() {click(By.xpath("//span[text()='join']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@placeholder='peter@gmail.com']"), user.getEmail());
        type(By.xpath("//input[@type='password']"), user.getPassword());
    }
    public void submit() {
        click(By.xpath("//div[.='Submit']"));
    }

    public void closeLoginRegistrationForm() {
        click(By.xpath("//div[text()='Cancel']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//div[text()='Home']"));
    }

    public String getTextErrorLogin() {
        return getText(By.xpath("//div[text()='Submit']"));
    }

    public void logout() {click(By.xpath("//div[.='Logout']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.xpath("//input[@placeholder='Peter']"), user.getName());
        type(By.xpath("//input[@placeholder='peter@gmail.com']"), user.getEmail());
        type(By.xpath("//input[@type='password']"), user.getPassword());
        type(By.xpath("(//input[@type='password'])[2]"), user.getPassword());
    }


    public void crossToSignUpForm() {
        click(By.xpath("//div[.='Sign up']"));
    }

    public String getTextExistUser() {
        return getText(By.xpath("//div[text()='User with this email already exists']"));
    }
}
