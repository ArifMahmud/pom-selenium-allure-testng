package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

    @Attachment(value = "ScreenShot", type = "image/png")
    public static byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
