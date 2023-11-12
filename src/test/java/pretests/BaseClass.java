package pretests;

import containers.WhatsNew;
import lombok.extern.java.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import testResources.Container;

import static org.openqa.selenium.support.PageFactory.initElements;
import static pretests.PropertiesReader.*;

@Log
public class BaseClass extends DriverFactory {

    public final ThreadLocal<Container> container = new ThreadLocal<>();

    @BeforeClass
    public void beforeClass() {

        initLoader();
        getInformationFromProperties();
    }

    @BeforeTest
    public void beforeTest() {

        setDriver();
        containerInit();
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

    private void containerInit() {

        Container containerLocal = new Container();

        containerLocal.setWhatsNew(initElements(driver.get(), WhatsNew.class));
        container.set(containerLocal);
    }
}
