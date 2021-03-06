package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitEx {
    WebDriver driver;

    public WaitEx(WebDriver driver){
        this.driver=driver;
    }

    public void waitElement(By locator,int timeout){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void waitForElement(By locator,int timeout){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    public void waitToBeClickable(By locator,int timeout){
//        WebElement element = null;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver,timeout);
//            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }

}
