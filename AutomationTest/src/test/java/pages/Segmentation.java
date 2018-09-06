package pages;

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


public class Segmentation {
    WebDriver driver;
    JavascriptExecutor jse;
    Logger logger = LogManager.getLogger(Segmentation.class.getName());


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


    }

    public WebDriver enterSegmentationDetails() throws Exception {
        campaignName.sendKeys("Test22");
        Actions action = new Actions(driver);
        action.moveToElement(android).click().perform();
        action.moveToElement(customersSatisfy).click().perform();
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        action.moveToElement(selectActions).click().perform();
        WebElement test = driver.findElement(By.cssSelector("[data-option-array-index='9']"));
        Thread.sleep(2000);
        action.moveToElement(selection).click().perform();
        Select dropDown = new Select(repeatsSelection);
        dropDown.selectByVisibleText("at most");
        count.sendKeys("2");
        Select dropDown2 = new Select(timeFrame);
        dropDown2.selectByVisibleText("after");
        action.moveToElement(days).click().perform();
        action.moveToElement(heading).click().perform();
        action.moveToElement(heading).click().perform();
        action.moveToElement(year).click().perform();
        action.moveToElement(month).click().perform();
        action.moveToElement(date).click().perform();
//        days.sendKeys("14-March-2019");
        Thread.sleep(2000);
        addAttributeButton.click();
//        Thread.sleep(4000);
//        addAttributeButton.click();
        action.moveToElement(attributeList).click().perform();
        action.moveToElement(attributeList).click().perform();
        Thread.sleep(2000);
        action.moveToElement(attributeList).click().perform();
        Thread.sleep(2000);
        action.moveToElement(platform).click().perform();
        Select dropDown3 = new Select(select3);
        dropDown3.selectByVisibleText("starts with");
        text3.sendKeys("and");
        nextButton.click();
        return driver;
    }
}
