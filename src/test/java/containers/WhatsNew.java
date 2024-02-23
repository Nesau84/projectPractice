package containers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class WhatsNew {

    @FindBy(css = ".base")
    public static WebElement pageHolderElement;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in women')]/following::ul[1]//li")
    public List<WebElement> newInWomanElements;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in men')]/following::ul[1]//li")
    public List<WebElement> newInMensElements;

    @FindBy(css = ".block-compare")
    public WebElement compareProductsElement;

    @FindBy(css = ".block-wishlist .block-content")
    public WebElement myWishListElement;

    public List<WebElement> defaultProductList(WebDriver driver) {

        return driver.findElements(cssSelector("div[class='block widget block-products-list grid'] [class='product-item']"));
    }

    public List<WebElement> defaultProductPriceList(WebDriver driver) {

        return driver.findElements(cssSelector("div[class='products-grid grid'] [class='product-item-info'] [class='product-item-details'] [class='price']"));
    }
}
