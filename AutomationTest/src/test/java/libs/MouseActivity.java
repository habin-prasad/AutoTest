package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class MouseActivity {
WebDriver driver;
    Actions actions;

public MouseActivity(WebDriver driver){
    this.driver=driver;
    actions = new Actions(driver);
}

public void perfomClick(WebElement element){
    actions.moveToElement(element).click().perform();
}

public void selectElementByText(WebElement element,String text){
    Select select = new Select(element);
    select.selectByVisibleText(text);
}
}
