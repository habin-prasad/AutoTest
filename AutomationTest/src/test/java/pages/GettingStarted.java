package pages;

import libs.ScreenshotLib;
import libs.WaitEx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GettingStarted {
    WebDriver driver;
    Logger logger = LogManager.getLogger(GettingStarted.class.getName());
    ScreenshotLib screenshot;
    WaitEx waitEx;

    @FindBy(xpath = "//li[contains(.,'Campaigns')]")
    private WebElement campaigns;

    @FindBy(xpath = "//a[@href='#/create']")
    private WebElement createCampaigns;

    @FindBy(xpath = "//a[@href='#/create/genpushV2/']")
    private WebElement createButton;

    public GettingStarted(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(driver);
    }

    public WebDriver createCampaign(){
        logger.info(driver.getCurrentUrl());
        waitEx.waitElement(By.xpath("//li[contains(.,'Campaigns')]"),10);
        campaigns.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitEx.waitElement(By.xpath("//a[@href='#/create']"),10);
        createCampaigns.click();
//        System.out.println(driver.getCurrentUrl());
        waitEx.waitElement(By.xpath("//a[@href='#/create/genpushV2/']"),10);
        screenshot = new ScreenshotLib(driver);
        screenshot.takeScreenshot("Getting Started");
        createButton.click();
        return driver;
    }
}
