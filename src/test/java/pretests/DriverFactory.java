package pretests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DriverFactory {

   public WebDriver driver;

    public void setDriver() {

        driver = PropertiesReader.properties.getProperty("browser").equals("chrome") ? new ChromeDriver() : new FirefoxDriver();
    }

    public void setScreen() {

        if (PropertiesReader.properties.getProperty("maximize").equals("yes")) {
            driver.manage().window().maximize();
        }
    }

    public void setImplicitWait() {

        driver.manage().timeouts().implicitlyWait(Duration.of(2000, ChronoUnit.MILLIS));
    }
}
