package utilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonFunctionalities {

    public static IOSDriver<?> driver;

    static DesiredCapabilities capabilities;


    @BeforeSuite
    public void launch() throws MalformedURLException {
        driver = initialize();
        BasicConfigurator.configure();
    }

    @AfterSuite
    public void quit() {
        driver.closeApp();
        driver.quit();
    }

    public static IOSDriver<?> initialize() throws MalformedURLException {
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

    @Step("Performed click action on {1}.")
    public void click(IOSElement element, String elementName) {
        element.click();
        System.out.println("Performed click action on "+ elementName);
    }

    @Step("Passed the text '{1}' into the default text-field {2}.")
    public void sendKeys(IOSElement element, String message, String elementName) {
        element.sendKeys(message);
        System.out.println("Passed the text"+ message +"into the default text-field "+ elementName);
    }

    @Step("Performed click action on {2}.")
    public void clickAction(IOSDriver<?> driver, IOSElement element, String elementName) {
        Actions action = new Actions(driver);
        action.click(element).perform();
        System.out.println("Performed click action on "+ elementName);
    }

}
