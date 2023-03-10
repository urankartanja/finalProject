package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {


    @FindBy(className = "btnAdmin")
    private WebElement adminButton;

    @FindBy(className = "btnAdminCities")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutAdminButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(name = "name")
    private WebElement fillCitiName;

    @FindBy(className = "btnSave")
    private WebElement saveCiti;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageCitiSave;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(className = "text-left")
    private WebElement editedCitiName;

    @FindBy(id = "search")
    private WebElement searchCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement citiNameEdited;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    private WebElement deleteCitiButton;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement confirmDeleteCity;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/button/span")
    private WebElement confirmMessageDeleteCity;


    public WebElement getAdminButton() {
        return adminButton;
    }

    public WebElement getCitiesButton() {
        return citiesButton;
    }

    public WebElement getLogoutAdminButton() {
        return logoutAdminButton;
    }

    public WebElement getNewItemButton() {
        return newItemButton;
    }

    public WebElement getFillCitiName() {
        return fillCitiName;
    }

    public WebElement getSaveCiti() {
        return saveCiti;
    }

    public WebElement getMessageCitiSave() {
        return messageCitiSave;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEditedCitiName() {
        return editedCitiName;
    }

    public WebElement getSearchCity() {
        return searchCity;
    }

    public WebElement getCitiNameEdited() {
        return citiNameEdited;
    }

    public WebElement getDeleteCitiButton() {
        return deleteCitiButton;
    }

    public WebElement getConfirmDeleteCity() {
        return confirmDeleteCity;
    }

    public WebElement getConfirmMessageDeleteCity() {
        return confirmMessageDeleteCity;
    }
}
