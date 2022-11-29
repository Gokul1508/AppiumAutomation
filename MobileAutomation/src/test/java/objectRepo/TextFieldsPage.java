package objectRepo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class TextFieldsPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    IOSElement defaultTextField;

    @iOSXCUITFindBy(accessibility = "shift")
    IOSElement shiftKey;

    @iOSXCUITFindBy(accessibility = "Done")
    IOSElement keyDone;

    @iOSXCUITFindBy(accessibility = "A")
    IOSElement key_A;

    @iOSXCUITFindBy(accessibility = "a")
    IOSElement key_a;

    @iOSXCUITFindBy(accessibility = "i")
    IOSElement key_i;

    @iOSXCUITFindBy(accessibility = "m")
    IOSElement key_m;

    @iOSXCUITFindBy(accessibility = "n")
    IOSElement key_n;

    @iOSXCUITFindBy(accessibility = "o")
    IOSElement key_o;

    @iOSXCUITFindBy(accessibility = "t")
    IOSElement key_t;

    @iOSXCUITFindBy(accessibility = "u")
    IOSElement key_u;

    public TextFieldsPage(IOSDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public IOSElement getDefaultTextField() {
        return defaultTextField;
    }

    public IOSElement getShiftKey() {
        return shiftKey;
    }

    public IOSElement getKeyDone() { return keyDone; }

    public IOSElement getKey_A() { return key_A; }

    public IOSElement getKey_a() {
        return key_a;
    }

    public IOSElement getKey_i() {
        return key_i;
    }

    public IOSElement getKey_m() {
        return key_m;
    }

    public IOSElement getKey_n() {
        return key_n;
    }

    public IOSElement getKey_o() {
        return key_o;
    }

    public IOSElement getKey_t() {
        return key_t;
    }

    public IOSElement getKey_u() {
        return key_u;
    }
}
