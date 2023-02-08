package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.login();
    }

    @Test
    public void visitsTheLoginPage1() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checksInputTypes2() {
        Assert.assertEquals(loginPage.getAtributeType(loginPage.getEmail()),"email");
        Assert.assertEquals(loginPage.getAtributeType(loginPage.getPasswordSignup()), "password");

    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist3(){
        loginPage.loginFillForm(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue(loginPage.getMessage().getText().contains("User does not exist"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void DisplaysErrorsWhenPasswordIsWrong4(){
        loginPage.loginFillForm("admin@admin.com", "aaa111");
        Assert.assertTrue(loginPage.getMessage2().getText().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void  login5(){
        loginPage.loginFillForm("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home")); // ovo moze da bude metoda u BasePage kojoj se prosledjuje url koji cekas
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void logout6(){
        loginPage.loginFillForm("admin@admin.com", "12345");
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());
        loginPage.getLogoutButton().click();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
