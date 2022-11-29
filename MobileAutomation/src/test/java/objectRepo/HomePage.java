package objectRepo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {

    @iOSXCUITFindBy(accessibility = "Date Picker")
    IOSElement datePickerButton;

    @iOSXCUITFindBy(accessibility = "Text Fields")
    IOSElement textFieldsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")
    IOSElement backButton;

    public HomePage(IOSDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public IOSElement getDatePickerButton() {
        return datePickerButton;
    }

    public IOSElement getTextFieldsButton() {
        return textFieldsButton;
    }

    public IOSElement getBackButton() {
        return backButton;
    }
}
