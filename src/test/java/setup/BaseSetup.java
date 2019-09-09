package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.InputHandlerUtil;

import java.io.IOException;

public class BaseSetup {

    public WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        InputHandlerUtil.loadConfigFile();
        //ops.addArguments("--disable-notifications");
        ops.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
