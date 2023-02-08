package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AdminPage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected final String BASE_URL = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected AdminPage adminPage;

    protected ProfilePage profilePage;
    Faker faker = new Faker();


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\d\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver, driverWait);
        adminPage = new AdminPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        faker = new Faker();
    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
