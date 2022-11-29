package utilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonFunctionalities {

    static DesiredCapabilities capabilities = null;

    public static IOSDriver<?> desiredCapabilities() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/gokul/Downloads/UIKitCatalog.app");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.1");
        capabilities.setCapability(MobileCapabilityType.UDID, "B546F80C-D20A-4C3D-89E2-30AEE5062D92");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        // Telling appium to wait till the app gets loaded
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 10000);
        // Telling appium to wait till the command gets executed
        capabilities.setCapability("commandTimeouts", "20000");
        return new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void click(IOSElement element) {
        element.click();
    }

    public void clickAction(IOSDriver<?> driver, IOSElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void pressTabKey(IOSElement element) {
        element.sendKeys(Keys.TAB);
    }


}
