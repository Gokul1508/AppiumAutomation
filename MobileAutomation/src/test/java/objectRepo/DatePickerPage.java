package objectRepo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class DatePickerPage {

    Calendar cal = Calendar.getInstance();

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@index = '1']")
    IOSElement minutePicker;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@index = '2']")
    IOSElement amPmPicker;

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

    public IOSElement getDateTo() {
        return dateTo;
    }

    public IOSElement getToNextMonth() {
        return toNextMonth;
    }

    public IOSElement getMinutePicker() { return minutePicker; }

    public IOSElement getAmPmPicker() { return amPmPicker; }

    @Step("Performed scroll action on {3}.")
    public void scrollHour(IOSDriver<?> driver,IOSElement element, int setTo, String elementName) {
        int currentHour = cal.get(Calendar.HOUR);
        HashMap<String, Object> params = new HashMap<>();
        if(currentHour < setTo) {
            for(int i=0; i<(setTo - currentHour); i++) {
                params.put("order","next");
                params.put("offset",0.1);
                params.put("element",element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
        } else if(currentHour > setTo) {
            for(int i=0; i<(currentHour - setTo); i++) {
                params.put("order","previous");
                params.put("offset",0.1);
                params.put("element",element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
        }
        tap(driver, element, "Hour Picker");
        System.out.println("Performed scroll action on "+ elementName);
    }

    @Step("Performed scroll action on {3}.")
    public void scrollMinute(IOSDriver<?> driver,IOSElement element, int setTo, String elementName) {
        int currentMinute = cal.get(Calendar.MINUTE);
        HashMap<String, Object> params = new HashMap<>();
        if(currentMinute < setTo) {
            for(int i=0; i<((setTo - currentMinute)/2); i++) {
                params.put("order","next");
                params.put("offset",0.15);
                params.put("element",element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
        } else if (currentMinute > setTo) {
            for(int i=0; i<((currentMinute - setTo)/2); i++) {
                params.put("order","previous");
                params.put("offset",0.15);
                params.put("element",element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
        }
        tap(driver, element, "Minute Picker");
        System.out.println("Performed scroll action on "+ elementName);
    }

    @Step("Performed scroll action on {3}.")
    public void scrollAmPm(IOSDriver<?> driver,IOSElement element, String setTo, String elementName) {
        HashMap<String, Object> params = new HashMap<>();
        if((cal.get(Calendar.AM_PM) == Calendar.AM) && Objects.equals(setTo, "PM")) {
            for(int i=0; i<1; i++) {
                params.put("order", "next");
                params.put("offset", 0.15);
                params.put("element", element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
            tap(driver, element, "AmPm Picker");
        }
        else if ((cal.get(Calendar.AM_PM) == Calendar.PM) && Objects.equals(setTo, "AM")) {
            for(int i=0; i<1; i++) {
                params.put("order", "previous");
                params.put("offset", 0.15);
                params.put("element", element);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            }
            tap(driver, element, "AmPm Picker");
        }
        else if ((cal.get(Calendar.AM_PM) == Calendar.AM) && Objects.equals(setTo, "AM")) {
            tap(driver, element, "AmPm Picker");
        }
        else if ((cal.get(Calendar.AM_PM) == Calendar.PM) && Objects.equals(setTo, "PM")) {
            tap(driver, element, "AmPm Picker");
        }
        System.out.println("Performed scroll action on "+ elementName);
    }
    @Step("Performed tap action on {2}.")
    public void tap(IOSDriver<?> driver, IOSElement element, String elementName) {
        TouchAction<?> action = new TouchAction<>(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)));
        System.out.println("Performed tap action on "+ elementName);
    }
}
