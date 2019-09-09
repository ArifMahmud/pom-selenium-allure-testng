package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import util.Utility;

public class CurrencyPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn btn-success xcrud-action']")
    WebElement addButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[9]/span/a[1]")
    WebElement viewButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[9]/span/a[2]")
    WebElement editButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[9]/span/a[3]")
    WebElement deleteButton;

    @FindBy(name = "cHRfY3VycmVuY2llcy5uYW1l")
    WebElement currencyName;

    @FindBy(name = "cHRfY3VycmVuY2llcy5zeW1ib2w-")
    WebElement currencySymbol;

    @FindBy(name = "cHRfY3VycmVuY2llcy5jb2Rl")
    WebElement currencyCode;

    @FindBy(name = "cHRfY3VycmVuY2llcy5jb2Rl")
    WebElement currencyRate;

    @FindBy(xpath = "//a[@class='btn btn-warning xcrud-action' and contains(.,'Return')]")
    WebElement saveAndReturnButton;

    @FindBy(xpath = "//a[@class='btn btn-warning xcrud-action' and contains(.,'Return')]")
    WebElement returnButton;

    public CurrencyPage(WebDriver driver) {
        super(driver);
    }

    public void addCurrency() {

        try {
            driver.get("https://www.phptravels.net/admin/settings/currencies");
            Thread.sleep(2000);
            addButton.click();
            Thread.sleep(2000);
            currencyName.sendKeys("ABC");
            Thread.sleep(1000);
            currencySymbol.sendKeys("@");
            Thread.sleep(1000);
            currencyCode.sendKeys("ABC");
            Thread.sleep(1000);
            saveAndReturnButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void viewCurrencyDetails() throws InterruptedException {
        driver.get("https://www.phptravels.net/admin/settings/currencies");
        viewButton.click();
        Thread.sleep(2000);
        Utility.attachScreenShot(driver);
        returnButton.click();

    }

    public void editCurrency() {
        try {
            driver.get("https://www.phptravels.net/admin/settings/currencies");
            Thread.sleep(1000);
            editButton.click();
            Thread.sleep(1000);
            currencyName.clear();
            currencyName.sendKeys("edited currency");
            currencyRate.clear();
            currencyRate.sendKeys("2");
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("window.scrollBy(0,1000)");
            saveAndReturnButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteCurrency() throws InterruptedException {
        driver.get("https://www.phptravels.net/admin/settings/currencies");
        Thread.sleep(2000);
        deleteButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.get("https://www.phptravels.net/admin/settings/currencies");
        Thread.sleep(5000);
    }

    public void addNegativeCurrency() {

        try {
            driver.get("https://www.phptravels.net/admin/settings/currencies");
            Thread.sleep(2000);
            addButton.click();
            Thread.sleep(2000);
            driver.findElement(By.name("cHRfY3VycmVuY2llcy5uYW1l")).sendKeys("বিডিটি");
            Thread.sleep(1000);
            driver.findElement(By.name("cHRfY3VycmVuY2llcy5zeW1ib2w-")).sendKeys("ক");
            Thread.sleep(1000);
            driver.findElement(By.name("cHRfY3VycmVuY2llcy5jb2Rl")).sendKeys("বিডিটি");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div/div[1]/div[1]/a[1]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void editNegativeCurrency() {
        try {
            driver.get("https://www.phptravels.net/admin/settings/currencies");
            Thread.sleep(1000);
            addButton.click();
            Thread.sleep(1000);
            driver.findElement(By.name("cHRfY3VycmVuY2llcy5yYXRl")).sendKeys("+");
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("window.scrollBy(0,1000)");
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div/div[1]/div[1]/a[1]")).click();
            String Result = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div/div[3]")).getText();
            Assert.assertTrue(Result.contains("contain errors"));
            System.out.print(Result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
