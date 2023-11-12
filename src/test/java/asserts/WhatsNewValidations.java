package asserts;

import locators.mainPage.WhatsNew;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

import static org.openqa.selenium.By.cssSelector;
import static org.testng.AssertJUnit.assertEquals;

public class WhatsNewValidations {

    private final WebDriver driver;
    private final WhatsNew whatsNew;

    public WhatsNewValidations(WebDriver driver) {

        this.whatsNew = new WhatsNew(driver);
        this.driver = driver;
    }

    public void assertWhatsNewPageAccessed() {

        String expectedUrl = "https://magento.softwaretestingboard.com/what-is-new.html";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("Url mismatch", expectedUrl, actualUrl);
    }

    public void assertNewMenuItems(boolean isWoman) {

        List<String> elementsList = isWoman ? whatsNew.newInWomansElements.stream().map(WebElement::getText).toList() :
                whatsNew.newInMensElements.stream().map(WebElement::getText).toList();
        List<String> expectedElements = List.of("Hoodies & Sweatshirts", "Jackets", "Tees", (isWoman ? "Bras & Tanks" : "Tanks"), "Pants", "Shorts");

        assertEquals(expectedElements.size(), elementsList.size());
        IntStream.range(0, expectedElements.size()).forEach(i -> assertEquals(elementsList.get(i), expectedElements.get(i)));
    }

    public void assertCompareProductsDefaultStateText(String expectedText) {

        assertEquals("Text mismatch.", expectedText, defaultStateTextHelper(true));
    }

    public void assertMyWishListDefaultStateText(String expectedText) {

        assertEquals("Text mismatch", expectedText, defaultStateTextHelper(false));
    }

    private String defaultStateTextHelper(boolean isCompareProducts) {

        WebElement textElement = isCompareProducts? whatsNew.compareProductsElement : whatsNew.myWishListElement;

        return textElement.findElement(cssSelector(" .empty")).getText();
    }
}
