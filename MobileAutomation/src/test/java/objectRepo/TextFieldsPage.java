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


    @iOSXCUITFindBy(accessibility = "Done")
    IOSElement keyDone;

    public TextFieldsPage(IOSDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public IOSElement getDefaultTextField() {
        return defaultTextField;
    }

    public IOSElement getKeyDone() { return keyDone; }

}
