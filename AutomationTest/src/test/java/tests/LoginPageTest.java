package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;
public class LoginPageTest {
    private WebDriver driver;
    private String baseUrl;
    private loginPage loginPage;
    private GettingStarted gettingStarted;
    private Segmentation segmentation;
    private Messaging messaging;
    private Scheduling scheduling;
    Logger logger = LogManager.getLogger(LoginPageTest.class.getName());

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://app.moengage.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginPage = new loginPage(driver);
        this.driver = loginPage.login("moeautouser@gmail.com", "dosalike1!");
    }

//    @Test
//    public void testLogin() throws Exception {
//        Thread.sleep(10000);
//        logger.debug("Title of the Current Page: "+driver.getTitle());
//        gettingStarted = new GettingStarted(driver);
//        this.driver = gettingStarted.createCampaign();
////        Thread.sleep(10000);
//        segmentation = new Segmentation(driver);
//        this.driver = segmentation.enterSegmentationDetails();
//        messaging = new Messaging(driver);
//        this.driver = messaging.enterMessagingDetails();
////        scheduling = new Scheduling(driver);
////        this.driver = scheduling.scheduleCampaign();
//    }

    @Test(priority = 1)
    public void testGettingStarted(){
        gettingStarted = new GettingStarted(driver);
        this.driver = gettingStarted.createCampaign();
    }

    @Test(priority = 2)
    public void testSegmentation(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        segmentation = new Segmentation(driver);
        this.driver = segmentation.enterSegmentationDetails();

    }

    @Test(priority = 3)
    public void testMessaging(){
        messaging = new Messaging(driver);
        this.driver = messaging.enterMessagingDetails();
    }

    @Test(priority = 4)
    public void testScheduling(){
        scheduling = new Scheduling(driver);
        this.driver = scheduling.scheduleCampaign();
    }


    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }


}
