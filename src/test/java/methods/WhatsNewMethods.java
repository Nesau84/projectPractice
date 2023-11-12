package methods;

import containers.WhatsNew;
import org.openqa.selenium.WebDriver;
import testResources.Container;

public class WhatsNewMethods {

    WebDriver driver;
    WhatsNew whatsNew;

    public WhatsNewMethods(Container container, WebDriver driver) {

        this.driver = driver;
        this.whatsNew = container.getWhatsNew();
    }
}
