package test;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CurrencyPage;
import pages.LocationListPage;
import pages.LogInPage;
import util.InputHandlerUtil;
import util.Utility;

import java.io.IOException;

public class TestCase {

    WebDriver driver;
    WebDriverWait wait;

    LogInPage logInPage;
    CurrencyPage currencyPage;
    LocationListPage locationListPage;

    @BeforeTest
    public void init() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        InputHandlerUtil.loadConfigFile();
        ops.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
    }

    @Test(priority = 0)
    @Description("Test Login with valid email and password")
    public void testLogIn() throws InterruptedException {
        driver.get(InputHandlerUtil.url);
        Thread.sleep(5000);
        logInPage = new LogInPage(driver);
        logInPage.logIn(InputHandlerUtil.email, InputHandlerUtil.password);
        Thread.sleep(5000);
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 1)
    @Description("Load Currency Page")
    public void testLoadCurrencyPage() {
        driver.findElement(By.xpath("//*[@id=\"social-sidebar-menu\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-ui\"]/li[2]/a")).click();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 2)
    @Description("Try to Create a new Cuurency")
    public void testAddCurrency() {
        currencyPage = new CurrencyPage(driver);
        currencyPage.addCurrency();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 3)
    @Description("Try to view a Currency details")
    public void testViewCurrency() throws InterruptedException {
        currencyPage = new CurrencyPage(driver);
        currencyPage.viewCurrencyDetails();
    }

    @Test(priority = 4)
    @Description("Try to edit a Currency details")
    public void testEditCurrency() {
        currencyPage = new CurrencyPage(driver);
        currencyPage.editCurrency();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 5)
    @Description("Try to delete a Currency")
    public void testDeleteCurrency() throws InterruptedException {
        currencyPage = new CurrencyPage(driver);
        currencyPage.deleteCurrency();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 6)
    @Description("Load Location page")
    public void testLoadLocationListPage() throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        driver.get(InputHandlerUtil.url);
        driver.findElement(By.xpath("//*[@id=\"social-sidebar-menu\"]/li[12]/a")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"Locations\"]/li/a"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        element.click();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 7)
    @Description("Try to add a location")
    public void testAddLocation() {
        locationListPage = new LocationListPage(driver);
        locationListPage.addLocation();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 8)
    @Description("Try to edit a location details")
    public void testEditLocation() {
        locationListPage = new LocationListPage(driver);
        locationListPage.editLocation();
        Utility.attachScreenShot(driver);
    }

    @Test(priority = 9)
    @Description("Try to delete a location")
    public void testDeleteLocation() {
        locationListPage = new LocationListPage(driver);
        locationListPage.deleteLocation();
        Utility.attachScreenShot(driver);
    }

    @AfterTest
    public void tearDown(){
        //driver.close();
    }

}
