import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.URL;

public class CalculatorTest {

    static AppiumDriver driver;

    public static void main(String [] args){
        try {
            openCalculator();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getStackTrace());
            System.out.println(exp.getCause());
        }
    }

    public static void openCalculator() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy S21 5G");
        capabilities.setCapability("udid", "R5CRB2LXTQE");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");

        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);

        System.out.println("Application Started...");

        WebElement btn_05 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        WebElement btn_add = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement btn_03 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        WebElement btn_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        WebElement result = driver.findElement(By.className("android.view.ViewGroup"));

        btn_05.click();
        btn_add.click();
        btn_03.click();
        btn_equal.click();
        String resultText = result.getText();

//        Verify the result
        Assert.assertEquals(resultText, "8");

        System.out.println("\n The result of adding five and three is : " + resultText);
        System.out.println("Test is Completed!");



    }
}
