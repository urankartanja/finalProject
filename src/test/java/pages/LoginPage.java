package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement submitFormButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message1;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message2;

    @FindBy(className = "btnLogout")
    private WebElement logoutButton;


    public WebElement getMessage2() {
        return message2;
    }

    public WebElement getMessage() {
        return message1;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(WebElement logoutButton) {
        this.logoutButton = logoutButton;
    }

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }






    public void login(){
        loginButton.click();
    }

    public String getEmailAtributeType(){
        return email.getAttribute("type");
    }

    public String getPasswordAtributeType(){
        return password.getAttribute("type");
    }

    public void loginFillForm(String email, String password){
        this.email.clear();
       this. email.sendKeys(email);
       this.email.clear();
        this.password.sendKeys(password);
        submitFormButton.click();
    }
}
