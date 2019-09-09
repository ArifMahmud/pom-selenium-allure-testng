package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(xpath = "//input[@class='form-control'][1]")
    WebElement email;

    @FindBy (xpath = "//input[@class='form-control'][2]")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ladda-button fadeIn animated']")
    WebElement logInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String userEmailAddress, String userPassword) throws ElementNotVisibleException {
        email.sendKeys(userEmailAddress);
        password.sendKeys(userPassword);
        logInButton.click();
    }
}
