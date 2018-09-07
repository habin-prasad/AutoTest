package pages;

import libs.ScreenshotLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class loginPage {
    WebDriver driver;
    ScreenshotLib screenshot ;

    @FindBy(xpath = "//input[@id='signin-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='signin-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver login(String uname, String pwd) {
        emailField.clear();
        emailField.sendKeys(uname);
        passwordField.clear();
        passwordField.sendKeys(pwd);
        loginButton.click();
        screenshot = new ScreenshotLib(driver);
        screenshot.takeScreenshot("LoginPage");
        return driver;
    }
}
