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


public class FirstTest extends BaseTest {



    @Test
    public void verifyHomePagetitle(){
        driver.get("https://demoqa.com");
        String title =driver.getTitle();
        System.out.println("Title of the webpage "+title);
        Assert.assertTrue(title.contains("DEMOQA"));

    }

    @Test
    public void clickElementsCard() throws IOException {
        driver.get("https://demoqa.com");
        WebElement elementsCard=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsCard);
        elementsCard.click();

        String currentUrl=driver.getCurrentUrl();
        ScreenshotUtil.takeScreenshot(driver, "clickElementsCard");
        Assert.assertTrue(currentUrl.contains("element"));
    }





}


