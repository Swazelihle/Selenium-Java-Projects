package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot {


    public void takeSnapShot(WebDriver driver, String screenshotName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String homeDir = System.getProperty("user.dir") + "/Screenshot/" + screenshotName+"_" +System.currentTimeMillis()+ ".png";

        File destination = new File(homeDir);

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
