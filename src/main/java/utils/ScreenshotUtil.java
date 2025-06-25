package utils;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Capture full page screenshot with scroll
        Screenshot fullPage = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100)) // scrolls every 100 ms
                .takeScreenshot(driver);

        Path screenshotsDir = Path.of(System.getProperty("user.dir"), "screenshots");
        Files.createDirectories(screenshotsDir);

        String filePath = screenshotsDir.resolve(screenshotName + "_" + timestamp + ".png").toString();
        ImageIO.write(fullPage.getImage(), "PNG", new File(filePath));
        System.out.println("✅ Full-page screenshot saved at: " + filePath);


    }
}
