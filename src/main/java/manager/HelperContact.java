package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Phone*']"),contact.getPhone());
        type(By.xpath("//input[position()=2]"),contact.getEmail());
        type(By.xpath("//input[position()=3]"),contact.getFacebookProfile());
    }

    public void submitPublishing() {
        click(By.xpath("//div[.='Publish']"));
    }
}
