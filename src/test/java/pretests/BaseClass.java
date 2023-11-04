package pretests;

import lombok.extern.java.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static pretests.PropertiesReader.*;

@Log
public class BaseClass extends DriverFactory {

    @BeforeClass
    public void beforeClass() {

        initLoader();
        getInformationFromProperties();
    }

    @BeforeTest
    public void beforeTest() {

        setDriver();
        setScreen();
        setImplicitWait();

        driver.get().navigate().to(properties.getProperty("url"));
    }

    @AfterTest
    public void afterTest() {

        log.info("Quitting driver instance");
        driver.get().quit();
    }

    @AfterClass
    public void afterClass() {

        log.info("Tests closing");
    }
}
