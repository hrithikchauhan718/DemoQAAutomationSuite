package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UploadDownloadTest extends BaseTest {

    @Test
    public void uploadFileTest(){
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));

        String filePath= System.getProperty("user.dir")+"\\Resources\\testfile.txt";
        uploadInput.sendKeys(filePath);

        WebElement uploadedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
        Assert.assertTrue(uploadedMsg.getText().contains("testfile.txt"), "File upload failed!");
        System.out.println("✅ File uploaded successfully: " + uploadedMsg.getText());
    }

}
