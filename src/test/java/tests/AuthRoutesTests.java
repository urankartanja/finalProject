package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.login();
    }

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated1() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated2() {
        driver.get(BASE_URL+"/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitToAdminCitiesUrlIfNotAuthenticated3() {
        driver.get(BASE_URL+"/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated4(){
        driver.get(BASE_URL+"/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
