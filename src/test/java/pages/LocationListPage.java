package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationListPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement addButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]/span/a[1]")
    WebElement editButton;

    @FindBy (xpath = "//table/tbody/tr[1]/td[8]/span/a[2]")
    WebElement deleteButton;

    @FindBy (id = "s2id_autogen1")
    WebElement countryDropDown;

    @FindBy (xpath = "//*[@id=\"select2-drop\"]/ul/li[10]/div")
    WebElement selectCountry;

    @FindBy (id = "location")
    WebElement location;

    @FindBy (xpath = "//button[@class='btn btn-primary' and @type='submit']")
    WebElement submitButton;

    public LocationListPage(WebDriver driver) {
        super(driver);
    }

    public void addLocation() {
        try {

        addButton.click();
        Thread.sleep(5000);
        countryDropDown.click();
        selectCountry.click();
        location.sendKeys("Dhaka University");
        Thread.sleep(2000);
        location.sendKeys(Keys.ARROW_DOWN);
        location.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,1000)");
        submitButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void editLocation()
    {
        try {
            driver.get("https://www.phptravels.net/supplier/locations");
            Thread.sleep(1000);
            editButton.click();
            Thread.sleep(1000);
            location.clear();
            location.sendKeys("Badda");
            Thread.sleep(2000);
            location.sendKeys(Keys.ARROW_DOWN);
            location.sendKeys(Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteLocation()
    {

        try {
            driver.get("https://www.phptravels.net/supplier/locations");
            Thread.sleep(1000);
            deleteButton.click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addLocationWithoutMandatoryValue() {
        try {
            driver.get("https://www.phptravels.net/supplier/locations");
            addButton.click();
            Thread.sleep(5000);
            location.sendKeys("Dhaka University");
            Thread.sleep(2000);
            location.sendKeys(Keys.ARROW_DOWN);
            location.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("window.scrollBy(0,1000)");
            submitButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
