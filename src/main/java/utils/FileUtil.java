package utils;

import java.io.File;

public class FileUtil {

    public static void waitForFileToDownload(File file, int timeoutSeconds) throws InterruptedException {
        int waited = 0;
        while (!file.exists() && waited < timeoutSeconds * 2) {  // 2 loops per second
            Thread.sleep(500);
            waited++;
        }
    }
}