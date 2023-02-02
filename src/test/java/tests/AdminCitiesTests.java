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
    }

    @Test
    public void editCity3() {
        adminPage.getEditButton().click(); // traziti po listi veb elemenata koji je zrenjanin
        adminPage.getFillCitiName().sendKeys( "edited");
        adminPage.getSaveCiti().click();
        Assert.assertTrue(adminPage.getMessageCitiSave().getText().contains("Saved successfully"));

    }

    @Test
    public void searchCity4() {
        adminPage.getSearchCity().sendKeys(citi);
        adminPage.getEditedCitiName().click();
        Assert.assertTrue(adminPage.getCitiNameEdited().getText().equals(adminPage.getSearchCity().getAttribute("value")));

    }

    @Test
    public void deleteCity5() {
        adminPage.getSearchCity().sendKeys(citi);
        adminPage.getEditedCitiName().click();
        Assert.assertTrue(adminPage.getCitiNameEdited().getText().equals(adminPage.getSearchCity().getAttribute("value")));

        adminPage.getDeleteCitiButton().click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[7]/div/div/div[1]")));
        adminPage.getDeleteMessageWarningDeleteCiti().click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminPage.getMessageCitiDeleted().getText().contains("Saved successfully"));

    }


    @AfterMethod
    public void afterMethod(){
        adminPage.getLogoutAdminButton().click();
    }
}
