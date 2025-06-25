package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsUtil {
    WebDriver driver;

    public ElementsUtil(WebDriver driver) {
        this.driver=driver;
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }

}
