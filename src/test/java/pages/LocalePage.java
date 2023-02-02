package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(id = "list-item-73")
    private WebElement en;

    @FindBy(id = "list-item-75")
    private WebElement es;

    @FindBy(id = "list-item-77")
    private WebElement fr;

    @FindBy(id = "list-item-79")
    private WebElement cn;

    @FindBy(id = "list-item-81")
    private WebElement ua;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerText;


    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getEn() {
        return en;
    }

    public WebElement getEs() {
        return es;
    }

    public WebElement getFr() {
        return fr;
    }

    public WebElement getHederText() {
        return headerText;
    }
}
