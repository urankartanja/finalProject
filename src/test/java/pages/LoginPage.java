package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

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

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement signupButton;

    @FindBy(id = "name")
    private WebElement nameSignup;

    @FindBy(id = "email")
    private WebElement emailSignup;

    @FindBy(id = "password")
    private WebElement passwordSignup;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordSignup;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement submitSignUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement message3;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement message4;


    public WebElement getEmail() {
        return email;
    }

    public WebElement getMessage2() {
        return message2;
    }

    public WebElement getMessage() {
        return message1;
    }

    public WebElement getMessage3() {
        return message3;
    }

    public WebElement getMessage4() {
        return message4;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmailSignup() {
        return emailSignup;
    }

    public WebElement getPasswordSignup() {
        return passwordSignup;
    }

    public WebElement getConfirmPasswordSignup() {
        return confirmPasswordSignup;
    }





    public void login() {
        loginButton.click();
    }




    public String getAtributeType(WebElement webelement){
        return webelement.getAttribute("type");
    }

    public void loginFillForm(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);
        this.email.clear();
        this.password.sendKeys(password);
        submitFormButton.click();
    }

    public void signupFillForm(String name, String email, String password, String confirmPassword){
        signupButton.click();
        nameSignup.sendKeys(name);
        emailSignup.sendKeys(email);
        passwordSignup.sendKeys(password);
        confirmPasswordSignup.sendKeys(confirmPassword);
        submitSignUpButton.click();
    }
}
