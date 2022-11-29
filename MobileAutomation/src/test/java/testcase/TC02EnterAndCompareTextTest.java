package testcase;

import io.appium.java_client.ios.IOSDriver;
import objectRepo.HomePage;
import objectRepo.TextFieldsPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.CommonFunctionalities;

import java.net.MalformedURLException;

public class TC02EnterAndCompareTextTest extends CommonFunctionalities {

    IOSDriver<?> driver = null;
    HomePage homePage = null;
    TextFieldsPage textFieldsPage = null;
    Logger log = Logger.getLogger(TC02EnterAndCompareTextTest.class.getName());

    @BeforeClass
    public void launchApp() {
        try {
            driver = desiredCapabilities();
            homePage = new HomePage(driver);
            textFieldsPage = new TextFieldsPage(driver);
            log.info("App is launched.");
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void getText() {
        click(homePage.getTextFieldsButton());
        log.info("TextFields Page is displayed");
        click(textFieldsPage.getDefaultTextField());
        click(textFieldsPage.getShiftKey());
        click(textFieldsPage.getKey_A());
        click(textFieldsPage.getKey_u());
        click(textFieldsPage.getKey_t());
        click(textFieldsPage.getKey_o());
        click(textFieldsPage.getKey_m());
        click(textFieldsPage.getKey_a());
        click(textFieldsPage.getKey_t());
        click(textFieldsPage.getKey_i());
        click(textFieldsPage.getKey_o());
        click(textFieldsPage.getKey_n());
        click(textFieldsPage.getKeyDone());
        log.info("Text 'Automation' is entered");
        Assert.assertEquals(textFieldsPage.getDefaultTextField().getText(), "Automation", "Text Is Matching");
        log.info("Test Passed");
        click(homePage.getBackButton());
    }

    @AfterClass
    public void quit() {
        driver.closeApp();
        driver.quit();
        log.info("App is closed.");
    }


}
