package libs;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class screenshotLib {
    WebDriver driver;

    public screenshotLib(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) throws IOException {
        String directoryName = System.getProperty("user.dir") + "screenshots";
        Date date = new Date();

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(directoryName + fileName + date.getTime() + ".png"));
    }
}
