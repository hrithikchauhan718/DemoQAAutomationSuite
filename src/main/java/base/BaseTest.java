package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String downloadPath;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome")String browser) {
        downloadPath = System.getProperty("user.dir") + "/downloads/" + browser.toLowerCase() ;
        new File(downloadPath).mkdirs();

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadPath);
            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("safebrowsing.enabled", true);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);


            driver = new ChromeDriver(options);

        } else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 2); // Use custom folder
            profile.setPreference("browser.download.dir", downloadPath);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,image/jpeg,image/png,application/pdf");
            profile.setPreference("pdfjs.disabled", true); // Disable built-in PDF viewer

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);

            driver = new FirefoxDriver(options);

        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }

}