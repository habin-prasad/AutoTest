package pages;

import libs.ScreenshotLib;
import libs.WaitEx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalTime;

public class Scheduling {

    WebDriver driver;
    Logger logger = LogManager.getLogger(Scheduling.class.getName());
    ScreenshotLib screenshot ;
    WaitEx waitEx;

    @FindBy(xpath = "//input[@ng-change='updateHours()']")
    private WebElement hour;

    @FindBy(xpath = "//input[@ng-change='updateMinutes()']")
    private WebElement minute;

    @FindBy(css = "[ng-click='incrementMinutes\\(\\)']")
    private WebElement upKey;

    @FindBy(css = "[value='later'] .md-container")
    private WebElement radioButton;

    @FindBy(css = "[href='\\#finish']")
    private WebElement finish;

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement responseMessage;

    public Scheduling(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitEx = new WaitEx(driver);

    }

    public WebDriver scheduleCampaign(){
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButton).click().perform();
        String[] time = String.valueOf(LocalTime.now()).split(":");
        String hourTime="";
        if(Integer.parseInt(time[0])>12){
            hourTime = String.valueOf(Integer.parseInt(time[0])-12);
        }
        System.out.println(hourTime+":"+time[1]);
        hour.clear();
        hour.sendKeys(hourTime);
        minute.clear();
        minute.sendKeys(time[1]);

        for(int i=0;i<20;i++) {
            actions.moveToElement(upKey).click().perform();
        }
        finish.click();
        waitEx.waitForElement(By.cssSelector("[href='\\#finish']"),100000);
//        waitEx.waitElement(By.xpath("//div[@class='toast-message']"),10);
        try{
            logger.info(responseMessage.getText());
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }

        screenshot = new ScreenshotLib(driver);
        screenshot.takeScreenshot("Scheduling");
        return driver;
    }

//    private void

}
