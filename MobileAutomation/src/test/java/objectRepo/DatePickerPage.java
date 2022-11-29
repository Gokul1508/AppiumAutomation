package objectRepo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DatePickerPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Date and Time Picker']/XCUIElementTypeButton[@index = '0']")
    IOSElement calenderButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@index = '1']")
    IOSElement clockPicker;

    @iOSXCUITFindBy(accessibility = "Next Month")
    IOSElement toNextMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = '7']")
    IOSElement dateTo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@index = '0']")
    IOSElement hourPicker;

    @iOSXCUITFindBy(accessibility = "1")
    IOSElement keyOne;

    @iOSXCUITFindBy(accessibility = "2")
    IOSElement keyTwo;

    @iOSXCUITFindBy(accessibility = "6")
    IOSElement keySix;

    public DatePickerPage(IOSDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public IOSElement getCalenderButton() {
        return calenderButton;
    }

    public IOSElement getClockPicker() {
        return clockPicker;
    }

    public IOSElement getHourPicker() {
        return hourPicker;
    }

    public IOSElement getKeyOne() {
        return keyOne;
    }

    public IOSElement getKeyTwo() {
        return keyTwo;
    }

    public IOSElement getKeySix() {
        return keySix;
    }

    public IOSElement getDateTo() {
        return dateTo;
    }

    public IOSElement getToNextMonth() {
        return toNextMonth;
    }
}
