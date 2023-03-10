package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTests extends BaseTest {

    private LocalePage localePage;

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        localePage = new LocalePage(driver, driverWait);
        localePage.getLanguageButton().click();
    }

    @Test
    public void setLocaleToES1() {
        localePage.getEs().click();
        Assert.assertTrue(localePage.getHeaderText().getText().contains("Página de aterrizaje"));
    }

    @Test
    public void setLocaleToEN2(){
        localePage.getEn().click();
        Assert.assertTrue(localePage.getHeaderText().getText().contains("Landing"));
    }

    @Test
    public void setLocaleToFR3(){
        localePage.getFr().click();
        Assert.assertTrue(localePage.getHeaderText().getText().contains("Page d'atterrissage"));
    }


}
