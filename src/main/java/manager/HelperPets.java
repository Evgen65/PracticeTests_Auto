package manager;

import models.Pets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperPets extends HelperBase {
    public HelperPets(WebDriver wd) {
        super(wd);
    }

    public void openCreatePetsForm() {
        click(By.xpath("//div[.='I found a pet']"));

    }

    public void fillFoundPetForm(Pets pets) {
        type(By.xpath("//input[@placeholder='Dog']"), pets.getType());
        type(By.xpath("//input[@placeholder='Male']"), pets.getSex());
        type(By.xpath("//input[@placeholder='Golden Retriever']"), pets.getBreed());
        type(By.xpath("//input[@placeholder='Beige']"), pets.getColor());
        type(By.xpath("//input[@placeholder='30-55']"), pets.getHeight());
        type(By.xpath("//textarea[@height='3vw']"), pets.getDistinctiveFeatures());
        fillDescription(pets.getDescription());
        type(By.xpath("//textarea[@placeholder='Florentin Street, Tel Aviv']"), pets.getLocation());
    }

    private void fillDescription(String description) {
        type(By.xpath("//input[@value='']"), description);
        click(By.xpath("//div[contains(text(),'Add')]"));
    }

    public void uploadPhoto(String link) {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.id("pet-image"))).pause(500).click().release().perform();
        //click(By.id("pet-image"));
        wd.findElement(By.id("pet-image")).clear();
        wd.findElement(By.id("//input[@id='pet-image']")).sendKeys(link);



    }


}
