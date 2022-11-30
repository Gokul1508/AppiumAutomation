package testcase;

import objectRepo.HomePage;
import objectRepo.TextFieldsPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonFunctionalities;

public class TC02EnterAndCompareTextTest extends CommonFunctionalities {

    HomePage homePage = null;

    TextFieldsPage textFieldsPage = null;
    Logger log = Logger.getLogger(TC02EnterAndCompareTextTest.class.getName());

    @BeforeClass
    public void initElements() {
        homePage = new HomePage(driver);
        textFieldsPage = new TextFieldsPage(driver);
    }

    @Test
    public void getText() {
        click(homePage.getTextFieldsButton(), "Text Fields Button");
        log.info("TextFields Page is displayed");
        sendKeys(textFieldsPage.getDefaultTextField(),"Automation", "Default Text Field");
        log.info("Text 'Automation' is entered");
        click(textFieldsPage.getKeyDone(), "Done Key in Keyboard");
        Assert.assertEquals(textFieldsPage.getDefaultTextField().getText(), "Automation", "Text Is Matching");
        log.info("Test Passed");
        click(homePage.getBackButton(), "UIKitCatalog Back Button");
    }


}
