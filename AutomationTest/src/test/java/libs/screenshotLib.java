package libs;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotLib {
    WebDriver driver;

    public ScreenshotLib(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) {
        String directoryName = System.getProperty("user.dir") + "/screenshots/";
        Date date = new Date();

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(directoryName + fileName + date.getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
