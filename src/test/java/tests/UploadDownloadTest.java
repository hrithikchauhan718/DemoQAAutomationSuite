package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;



public class UploadDownloadTest extends BaseTest {

//    @Test
//    public void uploadFileTest(){
//        driver.get("https://demoqa.com/upload-download");
//        WebElement uploadInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
//
//        String filePath= System.getProperty("user.dir")+"\\resources\\testfile.txt";
//        uploadInput.sendKeys(filePath);
//
//        WebElement uploadedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
//        Assert.assertTrue(uploadedMsg.getText().contains("testfile.txt"), "File upload failed!");
//        System.out.println(" File uploaded successfully: " + uploadedMsg.getText());
//    }

    @Test
    public void downloadBase64FileTest() throws  IOException {
        driver.get("https://demoqa.com/upload-download");

        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));

        //  Getting the Base64 string from the href
        String base64Href = downloadBtn.getAttribute("href");
        System.out.println("Base64 Link: " + base64Href);

        //  Removing the prefix and extract Base64 content
        String base64Data = base64Href.split(",")[1];

        //  Decoding Base64
        byte[] fileData = Base64.getDecoder().decode(base64Data);


        downloadPath += "/sampleFile.jpeg";
        FileOutputStream fos = new FileOutputStream(downloadPath);

        //  Writing the decoded bytes to file
        fos.write(fileData);
        fos.close();

        File downloadedFile = new File(downloadPath);
        Assert.assertTrue(downloadedFile.exists(), "File was not downloaded or saved correctly.");
        System.out.println("File downloaded successfully at: " + downloadedFile.getAbsolutePath());
    }
}
