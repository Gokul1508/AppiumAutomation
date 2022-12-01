package testcase;

import objectRepo.DatePickerPage;
import objectRepo.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonFunctionalities;

public class TC01ChangeDateTest extends CommonFunctionalities {

    HomePage homePage = null;

    DatePickerPage datePickerPage = null;

    Logger log = Logger.getLogger(TC01ChangeDateTest.class.getName());

    @BeforeClass
    public void initElements() {
        homePage = new HomePage(driver);
        datePickerPage = new DatePickerPage(driver);
    }



    @Test()
    public void changeDate() throws InterruptedException {
        click(homePage.getDatePickerButton(), "Date Picker Button");
        log.info("DatePicker Page is displayed.");
        click(datePickerPage.getCalenderButton(), "Calender Button");
        click(datePickerPage.getToNextMonth(), "Next Month Button");
        Thread.sleep(5000);
        clickAction(driver, datePickerPage.getDateTo(), "Day 7");
        log.info("Date is changed.");
        clickAction(driver, datePickerPage.getClockPicker(),"Time Picker Wheel");
        datePickerPage.scrollHour(driver, datePickerPage.getHourPicker(), 11, "Hour Picker");
        datePickerPage.tap(driver, datePickerPage.getHourPicker(), "Hour Picker");
        datePickerPage.scrollMinute(driver, datePickerPage.getMinutePicker(), 26, "Minute Picker");
        datePickerPage.tap(driver, datePickerPage.getMinutePicker(), "Minute Picker");
        datePickerPage.scrollAmPm(driver, datePickerPage.getAmPmPicker(), "PM", "AmPm Picker");
        clickAction(driver, homePage.getBackButton(), "Empty Region around the Time Picker");
        log.info("Time is changed.");
        click(homePage.getBackButton(), "UIKitCatalog Back Button");
    }

}
