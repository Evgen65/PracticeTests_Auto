package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginRegistrationForm() {
        click(By.xpath("//div[text()='Sign in']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@placeholder='peter@gmail.com']"), user.getEmail());
        type(By.xpath("//input[@type='password']"), user.getPassword());
    }
    public void submitLogin() {
        click(By.xpath("//div[.='Submit']"));
    }

    public void closeLoginForm() {
        click(By.xpath("//div[text()='Cancel']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//div[text()='Home']"));
    }

    public String getTextErrorLogin() {
        return getText(By.xpath("//div[text()='Submit']"));
    }
}
