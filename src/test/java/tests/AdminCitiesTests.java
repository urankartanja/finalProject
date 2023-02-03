package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class AdminCitiesTests extends BaseTest {

    private String adminEmail = "admin@admin.com";
    private String adminPassword = "12345";

    private String citi = "Zrenjanin";

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.login();
        loginPage.loginFillForm(adminEmail, adminPassword);
        adminPage.getAdminButton().click();
        adminPage.getCitiesButton().click();
    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities1() {
        loginPage.loginFillForm("admin@admin.com", "12345");
        adminPage.getAdminButton().click();
        adminPage.getCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(adminPage.getLogoutAdminButton().isDisplayed());

    }

    @Test
    public void createNewCity2() {
        adminPage.getNewItemButton().click();
        adminPage.getFillCitiName().sendKeys(citi);
        adminPage.getSaveCiti().click();
        Assert.assertTrue(adminPage.getMessageCitiSave().getText().contains("Saved successfully"));
       // adminPage.getLogoutAdminButton().click();

    }

    @Test
    public void editCity3() {
        createNewCity2();
        adminPage.getEditButton().click();
        adminPage.getFillCitiName().sendKeys("edited");
        adminPage.getSaveCiti().click();
        Assert.assertTrue(adminPage.getMessageCitiSave().getText().contains("Saved successfully"));
        //adminPage.getLogoutAdminButton().click();


    }

    @Test
    public void searchCity4() {
        createNewCity2();
        editCity3();
        adminPage.getSearchCity().sendKeys(citi + "edited");
        adminPage.getEditedCitiName().click();
        Assert.assertTrue(adminPage.getCitiNameEdited().getText().equals(adminPage.getSearchCity().getAttribute("value")));
       // adminPage.getLogoutAdminButton().click();
    }

    @Test
    public void deleteCity5() {
        createNewCity2();
        editCity3();
        searchCity4();
        adminPage.getDeleteCitiButton().click();
        adminPage.getConfirmDeleteCity().click();
        Assert.assertTrue(adminPage.getConfirmMessageDeleteCity().getText().contains("Deleted successfully"));
        // adminPage.getLogoutAdminButton().click();



    }

//    @AfterClass
//    @Override
//    public void afterClass() {
//       // super.afterClass();
//        adminPage.getLogoutAdminButton().click();
//    }
}

