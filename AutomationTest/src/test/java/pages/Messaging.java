package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Messaging {
    WebDriver driver;
    JavascriptExecutor jse;
    Logger logger = LogManager.getLogger(Messaging.class.getName());

    @FindBy(css = ".pushForm .pushDiv:nth-child(3) [tooltip]")
    private WebElement messageArea;

    @FindBy(xpath = "//a[contains(.,'Name')]")
    private WebElement suggestion;

    @FindBy(css = ".inapp-style-div.md-default-theme .md-container")
    private WebElement toggleButton;

    @FindBy(css = "[ng-if='androidFormData\\.FallBackFlagAndroid'] .pushDiv:nth-child(2) [type]")
    private WebElement fallbackMessageTitle;

    @FindBy(css = "[ng-if='androidFormData\\.FallBackFlagAndroid'] .pushDiv:nth-child(3) [type]")
    private WebElement fallbackMessageArea;

    @FindBy(css = "[ng-if='androidFormData\\.FallBackFlagAndroid'] [ng-class] > [aria-disabled='false']:nth-of-type(2)")
    private WebElement richContent;

    @FindBy(xpath="//div[@id='pushContent']/md-tabs/md-tabs-content-wrapper/md-tab-content[@role='tabpanel']/div/md-content//div[@class='pushForm']/md-content[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]//md-card/md-card-content/div[2]//select")
    private WebElement select1;

    @FindBy(css = "[ng-if='androidFormData\\.FallBackFlagAndroid'] [role='tabpanel']:nth-of-type(2) input")
    private WebElement couponText;

    @FindBy(css = "[ng-if='androidFormData\\.FallBackFlagAndroid'] [role='tabpanel']:nth-of-type(2) .button-info-color")
    private WebElement addAnotherButton;

    @FindBy(xpath = "//div[@id='pushContent']/md-tabs/md-tabs-content-wrapper/md-tab-content[@role='tabpanel']/div/md-content//div[@class='pushForm']/md-content[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-card[2]//select")
    private WebElement select2;

    @FindBy(xpath = "//div[@id='pushContent']/md-tabs/md-tabs-content-wrapper/md-tab-content[@role='tabpanel']/div/md-content//div[@class='pushForm']/md-content[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-card[2]//div[@class='ng-scope']//input")
    private WebElement imageText;

    @FindBy(linkText = "Next")
    private WebElement nextButton;

//    @FindBy(css = "//div[@id='pushContent']/md-tabs/md-tabs-content-wrapper/md-tab-content[@role='tabpanel']/div/md-content//div[@class='pushForm']/md-content[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-card[2]//div[@class='ng-scope']//input")

    @FindBy(xpath = "//label[contains(.,'Actions')]/../..//md-tab-item[3]")
    private WebElement actionButton;

    @FindBy(xpath = "//div[@id='pushContent']/md-tabs/md-tabs-content-wrapper/md-tab-content[@role='tabpanel']/div/md-content//div[@class='pushForm']/md-content[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[3]//div[@class='flex flex-60']/select")
    private WebElement actionSelect;

    @FindBy(linkText = "Select a screen name")
    private WebElement screenName;

    @FindBy(css = ".push-dropdown [data-option-array-index='2']")
    private WebElement screenSelect;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[2]//input[@placeholder='Name']")
    private WebElement key1;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[2]//input[@placeholder='Data']")
    private WebElement value1;

    @FindBy(css = "#androidnavigation [class='flex flex-10'] .journey-button-mini")
    private WebElement addButton2;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[3]//input[@placeholder='Name']")
    private WebElement key2;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[3]//input[@placeholder='Data']")
    private WebElement value2;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[4]//input[@placeholder='Name']")
    private WebElement key3;

    @FindBy(xpath = "//div[@class='md-padding']/div[contains(.,'Additional Key Value pairs ')]//../div[4]//input[@placeholder='Data']")
    private WebElement value3;



    public Messaging(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebDriver enterMessagingDetails() throws InterruptedException {
        messageArea.sendKeys("@Name");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(suggestion).click().perform();
//        actions.moveToElement(toggleButton).click().perform();
        toggleButton.click();
        fallbackMessageTitle.sendKeys("Testing");
        fallbackMessageArea.sendKeys("TEsting");
        richContent.click();
        Select select = new Select(select1);
        select.selectByVisibleText("Coupon");
        couponText.sendKeys("Testinf");
        addAnotherButton.click();
        Select select3 = new Select(select2);
        select3.selectByVisibleText("Image");
        imageText.sendKeys("Testing");
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-500)");

        actions.moveToElement(actionButton).click().perform();
        Select select4 = new Select(actionSelect);
        select4.selectByVisibleText("Navigate to a screen");
        actions.moveToElement(screenName).click().perform();
        Thread.sleep(1000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,50)");
        actions.moveToElement(screenSelect).click().perform();
        Select select5 = new Select(actionSelect);
        select5.selectByVisibleText("Navigate to screen");
        actions.moveToElement(screenName).click().perform();
        actions.moveToElement(screenSelect).click().perform();
        key1.sendKeys("key1");
        value1.sendKeys("value1");
        addButton2.click();
        key2.sendKeys("key2");
        value2.sendKeys("value2");
        addButton2.click();
        key3.sendKeys("key3");
        value3.sendKeys("value3");
        nextButton.click();
        return driver;
    }


}
