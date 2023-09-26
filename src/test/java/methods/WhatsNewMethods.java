package methods;

import Pom.WhatsNew;
import org.openqa.selenium.WebDriver;

public class WhatsNewMethods {

    WebDriver driver;
    WhatsNew whatsNew;

    public WhatsNewMethods(WebDriver driver) {

        this.whatsNew = new WhatsNew(driver);
        this.driver = driver;
    }

    public void openWhatsNewMenu() {

        whatsNew.whatsNewElement.click();
    }
}
