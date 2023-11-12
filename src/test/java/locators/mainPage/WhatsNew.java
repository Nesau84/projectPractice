package locators.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WhatsNew {

    public WhatsNew(WebDriver driver) {

        initElements(driver, this);
    }

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
