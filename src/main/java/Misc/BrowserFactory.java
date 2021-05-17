package Misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startBrowser(WebDriver driver, String browserName, String URL) {
        Path currentDir = Paths.get("");
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", currentDir.toAbsolutePath() + "/src/main/java/Misc/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            //Can add as many browsers as you like
        } else {
            System.out.println("Browser not supported");
        }
        //Bellow settings are common for most drivers
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}


