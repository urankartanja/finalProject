package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void editsProfile() throws InterruptedException {
        loginPage.signupFillForm(faker.name().firstName(), faker.internet().emailAddress(), "555111", "555111");
        profilePage.getCloseMessage().click();
        profilePage.getMyProfileButton().click();
        profilePage.myProfileFillForm(faker.phoneNumber().cellPhone(), "Cali", "Serbia",
                "https://"+faker.internet().url(),"https://"+faker.internet().url());
        Assert.assertTrue(profilePage.getMessageSuccessfullySaved().getText().contains("Profile saved successfuly"));
    }
}
