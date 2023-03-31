package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;
    HelperUser user;
    HelperPets pets;
    HelperContact contact;

    String browser;
    Properties properties;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    public void init() {
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://propetscom.herokuapp.com/");
        wd.manage().window().maximize();
        pets = new HelperPets(wd);
        user = new HelperUser(wd);
        contact=new HelperContact(wd);
    }

    public void stop() {
        //  wd.close();
        //  wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperPets getPet() {
        return pets;
    }

    public HelperContact getContact() {
        return contact;
    }


}
