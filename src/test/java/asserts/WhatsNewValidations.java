package asserts;

import Pom.WhatsNew;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

import static org.testng.AssertJUnit.assertEquals;

public class WhatsNewValidations {

    WebDriver driver;
    WhatsNew whatsNew;

    public WhatsNewValidations(WebDriver driver) {

        this.whatsNew = new WhatsNew(driver);
        this.driver = driver;
    }

    public void assertWhatsNewPageAccessed() {

        String expectedUrl = "https://magento.softwaretestingboard.com/what-is-new.html";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("Url mismatch", expectedUrl, actualUrl);
    }

    public void assertNewWomansMenuItems() {

        List<String> elementsList = whatsNew.newInWomansElements.stream().map(WebElement::getText).toList();
        List<String> expectedElements = List.of("Hoodies & Sweatshirts", "Jackets", "Tees", "Bras & Tanks", "Pants", "Shorts");

        assertEquals(expectedElements.size(), elementsList.size());

        IntStream.range(0, elementsList.size()).forEach(i -> assertEquals(whatsNew.newInWomansElements.get(i).getText(), expectedElements.get(i)));
    }
}
