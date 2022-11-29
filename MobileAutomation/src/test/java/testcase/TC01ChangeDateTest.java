package testcase;

import io.appium.java_client.ios.IOSDriver;
import objectRepo.DatePickerPage;
import objectRepo.HomePage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonFunctionalities;

import java.net.MalformedURLException;

public class TC01ChangeDateTest extends CommonFunctionalities {

    IOSDriver<?> driver = null;
    HomePage homePage = null;
    DatePickerPage datePickerPage = null;
    Logger log = Logger.getLogger(TC01ChangeDateTest.class.getName());

    @BeforeClass
    public void launch() {
        BasicConfigurator.configure();
        try {
            driver = desiredCapabilities();
            homePage = new HomePage(driver);
            datePickerPage = new DatePickerPage(driver);
            log.info("App is launched.");
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }

    }

    @Test
    public void changeDate() throws InterruptedException {
        click(homePage.getDatePickerButton());
        log.info("DatePicker Page is displayed.");
        click(datePickerPage.getCalenderButton());
        click(datePickerPage.getToNextMonth());
        Thread.sleep(5000);
        click(datePickerPage.getDateTo());
        clickAction(driver, datePickerPage.getDateTo());
        pressTabKey(datePickerPage.getDateTo());
        log.info("Date is changed.");
        clickAction(driver, datePickerPage.getClockPicker());
        click(datePickerPage.getHourPicker());
        click(datePickerPage.getKeyOne());
        click(datePickerPage.getKeyOne());
        click(datePickerPage.getKeyTwo());
        click(datePickerPage.getKeySix());
        clickAction(driver, homePage.getBackButton());
        log.info("Time is changed.");
        click(homePage.getBackButton());
    }

    @AfterClass
    public void quit() {
        driver.closeApp();
        driver.quit();
        log.info("TestCase executed successfully.");
    }

}
