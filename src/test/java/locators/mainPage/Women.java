package locators.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Women {

    public Women(WebDriver driver) {

        initElements(driver, this);
    }

    @FindBy(id = "[ui-id-4]")
    public WebElement womenMainMenuOption;
}
