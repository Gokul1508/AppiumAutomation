package testcase;

import objectRepo.DatePickerPage;
import objectRepo.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonFunctionalities;

public class TC03sampleTestCase extends CommonFunctionalities {

    HomePage homePage = null;
    DatePickerPage datePickerPage = null;

    @BeforeClass
    public void initElements() {
        homePage = new HomePage(driver);
        datePickerPage = new DatePickerPage(driver);
    }

    @Test
    public void scrollPickerWheelIOS() throws InterruptedException {
        click(homePage.getDatePickerButton(),"Date Picker Button");
        click(datePickerPage.getClockPicker(),"Time Picker Wheel");
        datePickerPage.scrollHour(driver, datePickerPage.getHourPicker(), 11, "Hour Picker");
        datePickerPage.scrollMinute(driver, datePickerPage.getMinutePicker(), 26, "Minute Picker");
        datePickerPage.scrollAmPm(driver, datePickerPage.getAmPmPicker(), "PM", "AmPm Picker");
        clickAction(driver, homePage.getBackButton(), "Home Button");
        Thread.sleep(5000);
        clickAction(driver, homePage.getBackButton(), "Home Button");
    }
}
