package containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WhatsNew {

    @FindBy (css = ".base")
    public static WebElement pageHolderElement;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in women')]/following::ul[1]//li")
    public List<WebElement> newInWomansElements;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in men')]/following::ul[1]//li")
    public List<WebElement> newInMensElements;

    @FindBy(css = ".block-compare")
    public WebElement compareProductsElement;

    @FindBy(css = ".block-wishlist .block-content")
    public WebElement myWishListElement;
}
