package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WhatsNew {

    public WhatsNew(WebDriver driver) {

        initElements(driver, this);
    }

    @FindBy(css = "ul[role='menu'] li[class='level0 nav-1 category-item first level-top ui-menu-item']")
    public WebElement whatsNewElement;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in women')]/following::ul[1]//li")
    public List<WebElement> newInWomansElements;

    @FindBy(xpath = "//div[@class='categories-menu']//strong/span[contains(text(),'New in men')]/following::ul[1]//li")
    public List<WebElement> newInMensElements;
}
