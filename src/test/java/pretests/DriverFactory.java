package pretests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.MILLIS;

public class DriverFactory {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver() {

        driver.set(PropertiesReader.properties.getProperty("browser").equals("chrome") ? new ChromeDriver() : new FirefoxDriver());
    }

    public void setScreen() {

        if (PropertiesReader.properties.getProperty("maximize").equals("yes")) {
            driver.get().manage().window().maximize();
        }
    }

    public void setImplicitWait() {

        driver.get().manage().timeouts().implicitlyWait(Duration.of(2000, MILLIS));
    }
}
