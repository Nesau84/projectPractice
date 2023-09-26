package pretests;

import lombok.extern.java.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static pretests.PropertiesReader.getInformationFromProperties;
import static pretests.PropertiesReader.initLoader;

@Log
public class BaseClass extends DriverFactory {

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeTest
    public void beforeTest() {

        initLoader();
        getInformationFromProperties();

        setDriver();
        setScreen();
        setImplicitWait();

        log.info("Setup is initializing driver");

        driver.navigate().to(PropertiesReader.properties.getProperty("url"));

        log.info("Before test started.");
    }

    @AfterTest
    public void afterTest() {

        driver.quit();

        log.info("Quitting driver instance");
    }

    @AfterClass
    public void afterClass() {

        log.info("Tests closing");
    }
}
