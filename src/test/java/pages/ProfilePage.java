package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    Faker faker = new Faker();

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitter;

    @FindBy(id = "urlGitHub")
    private WebElement github;

    @FindBy(className = "btnClose")
    private WebElement  closeMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveProfileButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSuccessfullySaved;


    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getTwitter() {
        return twitter;
    }

    public WebElement getGithub() {
        return github;
    }

    public WebElement getMessageSuccessfullySaved() {
        return messageSuccessfullySaved;
    }

    public WebElement getCloseMessage() {
        return closeMessage;
    }

    public WebElement getMyProfileButton() {
        return myProfileButton;
    }

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void myProfileFillForm(String phone, String city, String country, String twitter, String github) throws InterruptedException {

        Thread.sleep(2000);
        this.phone.sendKeys(phone);
        Thread.sleep(2000);
        this.city.sendKeys(Keys.CONTROL + "a");
        this.city.sendKeys(Keys.DELETE);
        this.city.sendKeys(city);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        this.country.sendKeys(country);
        this.twitter.sendKeys(twitter);
        this.github.sendKeys(github);
        saveProfileButton.click();
    }
}
