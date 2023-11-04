package methods;

import locators.mainPage.WhatsNew;
import org.openqa.selenium.WebDriver;

public class WhatsNewMethods {

    WebDriver driver;
    WhatsNew whatsNew;

    public WhatsNewMethods(WebDriver driver) {

        this.whatsNew = new WhatsNew(driver);
        this.driver = driver;
    }
}
