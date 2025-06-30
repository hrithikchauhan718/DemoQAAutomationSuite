package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

import java.io.IOException;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkBox() throws IOException {
        driver.get("https://demoqa.com/");
        WebElement elementcard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()=\"Elements\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elementcard);
        elementcard.click();

        WebElement checkelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=\"item-1\"]//span[text()=\"Check Box\"]")));
        checkelement.click();

        WebElement expand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title=\"Expand all\"]")));
        expand.click();
        ScreenshotUtil.takeScreenshot(driver,"checkboxes");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/checkbox");


    }
}
