package pages;

import libs.BaseClass;
import libs.MouseActivity;
import libs.ScreenshotLib;
import libs.WaitEx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Messaging extends BaseClass {
    WebDriver driver;
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
        waitEx = new WaitEx(driver);
        mouseActivity = new MouseActivity(driver);
        jse = (JavascriptExecutor) driver;
    }

    public WebDriver enterMessagingDetails() {
        enterMessageTitle("Name");
        enterFallback("TitleTesting","Test Message","COUPON1","wertyu");
        jse.executeScript("window.scrollBy(0,-500)");
       actionsTab();
        String[] keys = {"1","2","3"};
        String[] values = {"4","5","6"};
        actionsKeys(keys,values);
        screenshot=new ScreenshotLib(driver);
        screenshot.takeScreenshot("Messaging");
        nextButton.click();
        return driver;
    }

    private void enterMessageTitle(String title){
        messageArea.sendKeys("@"+title);
        mouseActivity.perfomClick(suggestion);
    }

    private void enterFallback(String title,String text, String coup,String url){
        toggleButton.click();
        fallbackMessageTitle.sendKeys(title);
        fallbackMessageArea.sendKeys(text);
        richContent.click();
        mouseActivity.selectElementByText(select1,"Coupon");
        couponText.sendKeys(coup);
        addAnotherButton.click();
        mouseActivity.selectElementByText(select2,"Image");
        imageText.sendKeys(url);

    }

    private void actionsTab(){
        waitEx.waitElement(By.xpath("//label[contains(.,'Actions')]/../..//md-tab-item[3]"),4);
        mouseActivity.perfomClick(actionButton);
        mouseActivity.selectElementByText(actionSelect,"Navigate to a screen");
        mouseActivity.perfomClick(screenName);
        waitEx.waitElement(By.cssSelector(".push-dropdown [data-option-array-index='2']"),4);
        mouseActivity.perfomClick(screenSelect);
    }

    private void actionsKeys(String[] key,String[] value){
        key1.clear();
        value1.clear();
        key1.sendKeys("key1");
        value1.sendKeys("value1");
        addButton2.click();
        key2.clear();
        value2.clear();
        key2.sendKeys("key2");
        value2.sendKeys("value2");
        addButton2.click();
        key3.clear();
        value3.clear();
        key3.sendKeys("key3");
        value3.sendKeys("value3");
    }


}
