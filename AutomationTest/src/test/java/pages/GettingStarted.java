package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GettingStarted {
    WebDriver driver;
    Logger logger = LogManager.getLogger(GettingStarted.class.getName());

    @FindBy(xpath = "//li[contains(.,'Campaigns')]")
    private WebElement campaigns;

    @FindBy(xpath = "//a[@href='#/create']")
    private WebElement createCampaigns;

    @FindBy(xpath = "//a[@href='#/create/genpushV2/']")
    private WebElement createButton;

    public GettingStarted(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver createCampaign() throws InterruptedException {
        System.out.println(driver.getCurrentUrl());
        campaigns.click();
        Thread.sleep(2000);
        createCampaigns.click();
        System.out.println(driver.getCurrentUrl());
        createButton.click();
        return driver;
    }
}
