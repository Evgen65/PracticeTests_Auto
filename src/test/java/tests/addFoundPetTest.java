package tests;

import models.Contact;
import models.Pets;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addFoundPetTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        User user = User.builder().email("abcd@mail.com").password("Abcd1234$").build();
        app.getUser().openLoginRegistrationFormFirstWay();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
    }

    @Test
    public void addFoundPetPositiveTest() {
        Pets pets = Pets.builder()
                .type("Dog")
                .sex("Male")
                .breed("Retvier")
                .color("Gray")
                .height("42")
                .distinctiveFeatures("damaged tail")
                .description("A" + "little" + "stupid" + "empty")
                .location("Tel Aviv")
                .build();
        app.getPet().openCreatePetsForm();
        app.getPet().fillFoundPetForm(pets);
        Contact contact = Contact.builder()
                .phone("972456852153")
                .email("abcd@mail.com")
                .facebookProfile("Fasebook#gilad")
                .build();
        app.getPet().uploadPhoto("C:\\repositoris\\PracticeTests_Auto\\src\\test\\resources\\cat.jpg");
        app.getContact().fillContactForm(contact);
        app.getContact().submitPublishing();


    }
}
