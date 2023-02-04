package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void editsProfile() throws InterruptedException {

        String phone = faker.phoneNumber().cellPhone();
        String city = "Cali";
        String country = "Serbia";
        String twitter = "https://"+faker.internet().url();
        String github = "https://"+faker.internet().url();
        String name = faker.name().firstName();


        loginPage.signupFillForm(faker.name().firstName(), faker.internet().emailAddress(), "555111", "555111");
        profilePage.getCloseMessage().click();
        profilePage.getMyProfileButton().click();
        profilePage.myProfileFillForm(phone,city,country,twitter,github );

        Assert.assertTrue(profilePage.getMessageSuccessfullySaved().getText().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getPhone().getAttribute("value"), phone);
        Assert.assertEquals(profilePage.getCity().getAttribute("value"), city);
        Assert.assertEquals(profilePage.getCountry().getAttribute("value"),country);
        Assert.assertEquals(profilePage.getTwitter().getAttribute("value"),twitter);
        Assert.assertEquals(profilePage.getGithub().getAttribute("value"), github);



    }
}
