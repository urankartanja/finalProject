package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void visitsTheSignupPage1() {
        loginPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void checksInputTypes2() {
        loginPage.getSignupButton().click();
        Assert.assertEquals(loginPage.getAtributeType(loginPage.getEmailSignup()), "email");
        Assert.assertEquals(loginPage.getAtributeType(loginPage.getPasswordSignup()), "password");
        Assert.assertEquals(loginPage.getAtributeType(loginPage.getConfirmPasswordSignup()), "password");
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists3() {
        loginPage.signupFillForm("Test Test", "admin@admin.com", "123654", "123654");
        Assert.assertTrue(loginPage.getMessage3().getText().contains("E-mail already exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void Signup4(){
        loginPage.signupFillForm("Tanja", faker.internet().emailAddress(), "a1a1a1", "a1a1a1");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(loginPage.getMessage4().getText().contains("IMPORTANT: Verify your account"));
    }

}
