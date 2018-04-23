package atsoy;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class AppTest 
{

    private static AppiumDriver<MobileElement> driver;

    @BeforeClass
    public static void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Nexus_5X_API_25");
        capabilities.setCapability("platformVersion","7.1.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("avd","Nexus_5X_API_25");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
    }

    @AfterClass
    public static void endTest() {
        driver.quit();
        closeEmulator();
    }

    @Test
    public void firstTest() {
        MobileElement number1 = driver.findElementById("com.android.calculator2:id/digit_2");
        number1.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_add");
        operation.click();

        MobileElement number2 = driver.findElementById("com.android.calculator2:id/digit_3");
        number2.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("НеверноЙ!!!!",result.getText().equals("5"));
    }


    @Test
    public void dotArithmeticsTest() {
        MobileElement number1 = driver.findElementById("com.android.calculator2:id/digit_2");
        number1.click();

        MobileElement dot = driver.findElementById("com.android.calculator2:id/dec_point");
        dot.click();

        MobileElement number5 = driver.findElementById("com.android.calculator2:id/digit_5");
        number5.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_add");
        operation.click();

        MobileElement number2 = driver.findElementById("com.android.calculator2:id/digit_3");
        number2.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("Неверно!!!!",result.getText().equals("5.5"));
    }

    @Test
    public void divideByZero() {
        MobileElement number1 = driver.findElementById("com.android.calculator2:id/digit_2");
        number1.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_div");
        operation.click();

        MobileElement number2 = driver.findElementById("com.android.calculator2:id/digit_0");
        number2.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("Неверно!!!!",result.getText().equals("Can't divide by 0"));
    }

    private static void closeEmulator() {
        System.out.println("END");
    }
}
