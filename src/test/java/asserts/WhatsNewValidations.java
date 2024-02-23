package asserts;

import containers.WhatsNew;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testResources.Container;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.AssertJUnit.assertEquals;

public class WhatsNewValidations {

    private final WhatsNew whatsNew;
    private final WebDriver driver;

    public WhatsNewValidations(Container container, WebDriver driver) {

        this.whatsNew = container.getWhatsNew();
        this.driver = driver;
    }

    public void assertWhatsNewPageAccessed() {

        String expectedUrl = "https://magento.softwaretestingboard.com/what-is-new.html";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("Url mismatch", expectedUrl, actualUrl);
    }

    public void assertNewMenuItems(boolean isWoman) {

        List<String> elementsList = isWoman ? whatsNew.newInWomanElements.stream().map(WebElement::getText).toList() :
                whatsNew.newInMensElements.stream().map(WebElement::getText).toList();
        List<String> expectedElements = List.of("Hoodies & Sweatshirts", "Jackets", "Tees", (isWoman ? "Bras & Tanks" : "Tanks"), "Pants", "Shorts");

        assertEquals(expectedElements.size(), elementsList.size());
        IntStream.range(0, expectedElements.size()).forEach(i -> assertEquals(elementsList.get(i), expectedElements.get(i)));
    }

    public void assertCompareProductsDefaultStateText(String expectedText) {

        assertEquals("Text mismatch.", expectedText, getDefaultStateText(true));
    }

    public void assertMyWishListDefaultStateText(String expectedText) {

        assertEquals("Text mismatch", expectedText, getDefaultStateText(false));
    }

    public void assertDefaultNumberOfProductsDisplayed(int expectedCount) {

        List<WebElement> productList = whatsNew.defaultProductList(driver);

        assertThat(productList.size()).as("Product default count not %d", expectedCount).isEqualTo(expectedCount);
    }

    public void assertDefaultProductPricing(double expectedSum) {

        assertEquals("Expected and Actual sum mismatch", expectedSum, getDefaultPriceSum());
    }

    private double getDefaultPriceSum() {

        double actualSum = 0;
        String withoutDollarSignPrice;

        for (int i = 0; i < whatsNew.defaultProductPriceList(driver).size(); i++) {
            withoutDollarSignPrice = getDefaultPriceConverted(i);
            actualSum += Double.parseDouble(withoutDollarSignPrice);
        }

        return actualSum;
    }

    private String getDefaultPriceConverted(int i) {

        return whatsNew.defaultProductPriceList(driver).get(i).getText().replaceAll("[^\\d.]", "");
    }

    private String getDefaultStateText(boolean isCompareProducts) {

        WebElement textElement = isCompareProducts ? whatsNew.compareProductsElement : whatsNew.myWishListElement;

        return textElement.findElement(cssSelector(" .empty")).getText();
    }
}
