package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;
    HelperUser user;
    String browser;
    Properties properties;
    public ApplicationManager(String browser) {

        this.browser = browser;
        properties =new Properties();
    }
   public void init()  {
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://propetscom.herokuapp.com/");
        wd.manage().window().maximize();
        user = new HelperUser(wd);
    }
    public void stop() {
        //  wd.close();
        //  wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }



}
