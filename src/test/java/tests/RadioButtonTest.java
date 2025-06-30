package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RadioButtonTest extends BaseTest {

    @Test
    public void verifyRadioButton(){
        driver.get("https://demoqa.com");
        WebElement elementcard =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"Elements\"]")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elementcard);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()=\"Elements\"]")));

        elementcard.click();

        WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=\"item-2\"]//span[text()=\"Radio Button\"]")));
        radioBtn.click();

        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveRadio = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noRadio = driver.findElement(By.xpath("//input[@id='noRadio']"));


        Assert.assertTrue(yesRadio.isDisplayed());
        Assert.assertTrue(impressiveRadio.isDisplayed());





        yesRadio.click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"text-success\"]")));
        Assert.assertEquals(message.getText(),"Yes");

        impressiveRadio.click();
        message =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"text-success\"]")));
        Assert.assertEquals(message.getText(),"Impressive");

        Assert.assertFalse(noRadio.isEnabled(), "No radio button should be disabled");
    }
}
