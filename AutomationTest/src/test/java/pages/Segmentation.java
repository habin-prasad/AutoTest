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


public class Segmentation extends BaseClass {
    WebDriver driver;

    Logger logger = LogManager.getLogger(Segmentation.class.getName());
    ScreenshotLib screenshot;
//    WaitEx waitEx;


    @FindBy(css = "[ng-change='checkIfValid\\(\\)']")
    private WebElement campaignName;

    @FindBy(css = "#ANDROID .md-container")
    private WebElement android;

    @FindBy(css = "[value='custom_filters'] .md-container")
    private WebElement customersSatisfy;

    @FindBy(linkText = "Select User Actions")
    private WebElement selectActions;

    @FindBy(css = "[data-option-array-index='9']")
    private WebElement selection;

    @FindBy(xpath = "//div[1]/div[3]/select[1]")
    private WebElement repeatsSelection;

    @FindBy(xpath = "//div[1]/div[4]/input[@type='number']")
    private WebElement count;

    @FindBy(xpath = "//div[@class='ng-scope']/div[1]/div[@class='seg-padding-right']/select")
    private WebElement timeFrame;

    @FindBy(xpath = "//div[@class='ng-scope']/div[1]/div[2]/span/input[@type='text']")
    private WebElement days;

    @FindBy(xpath = ".//button[contains(.,'Add attribute')]")
    private WebElement addAttributeButton;

    @FindBy(xpath = ".//div/a[contains(.,'Select an attribute')]")
    private WebElement attributeList;

    @FindBy(xpath = "//ul[@class='chosen-results']/li[.='Platform']")
    private WebElement platform;

    @FindBy(xpath = "//div/div[3]/select[@required='']")
    private WebElement select3;

    @FindBy(xpath = "//div/div[4]/input[@type='text']")
    private WebElement text3;

    @FindBy(css = ".seg-padding-right thead [aria-disabled]")
    private WebElement heading;

    @FindBy(css = ".seg-padding-right [ng-repeat='row in rows track by \\$index']:nth-of-type(4) [ng-repeat='dt in row track by dt\\.date']:nth-of-type(4) [type]")
    private WebElement year;

    @FindBy(css = ".seg-padding-right [ng-repeat='row in rows track by \\$index']:nth-of-type(1) [ng-repeat='dt in row track by dt\\.date']:nth-of-type(3) [type]")
    private WebElement month;

    @FindBy(css = ".seg-padding-right [ng-repeat='row in rows track by \\$index']:nth-of-type(3) [ng-repeat='dt in row track by dt\\.date']:nth-of-type(5) [type]")
    private WebElement date;

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    public Segmentation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(driver);
        mouseActivity = new MouseActivity(driver);
        screenshot = new ScreenshotLib(driver);

    }

    public WebDriver enterSegmentationDetails(){
        enterCampaignName("Tesla");
        Actions action = new Actions(driver);
        clickPlatform("android");
        targetAudience("customers");
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        selectActionsCustomers("AUTO_TEST_Searched");
        iterationsCalc("at most");
        datePicker();
        addAttribute();
        nextButton.click();
        screenshot.takeScreenshot("Segmentation");
        return driver;
    }

    private void enterCampaignName(String name){
        waitEx.waitElement(By.cssSelector("[ng-change='checkIfValid\\(\\)']"),4);
        campaignName.sendKeys(name);
    }

    private void clickPlatform(String platformName){
        mouseActivity.perfomClick(android);
    }

    private void targetAudience(String type){
        mouseActivity.perfomClick(customersSatisfy);
    }

    private void selectActionsCustomers(String action){
        mouseActivity.perfomClick(selectActions);
        waitEx.waitElement(By.cssSelector("[data-option-array-index='9']"),4);
        mouseActivity.perfomClick(selection);
    }

    private void iterationsCalc(String repetitions){
        mouseActivity.selectElementByText(repeatsSelection,repetitions);
        count.clear();
        count.sendKeys("2");
    }
    private void datePicker(){
        mouseActivity.selectElementByText(timeFrame,"after");
        mouseActivity.perfomClick(days);
        mouseActivity.perfomClick(heading);
        mouseActivity.perfomClick(heading);
        mouseActivity.perfomClick(year);
        mouseActivity.perfomClick(month);
        mouseActivity.perfomClick(date);
    }

    private void addAttribute(){
        waitEx.waitForElement(By.xpath(".//button[contains(.,'Add attribute')]"),10);
        addAttributeButton.click();
        addAttributeButton.click();
        mouseActivity.perfomClick(attributeList);
        waitEx.waitElement(By.xpath("//ul[@class='chosen-results']/li[.='Platform']"),10);
        mouseActivity.perfomClick(platform);
        mouseActivity.selectElementByText(select3,"starts with");
        text3.sendKeys("and");

    }
}
