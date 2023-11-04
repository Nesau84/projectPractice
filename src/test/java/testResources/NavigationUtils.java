package testResources;

import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static locators.mainPage.WhatsNew.pageHolderElement;
import static org.openqa.selenium.By.id;

@Log
public class NavigationUtils {

    public static void navigateToMenuOption(WebDriver driver, String navigateElement, String navigateName) {

        try {
            driver.findElement(id(navigateElement)).click();
        } catch (NoSuchElementException e) {
            log.info(format("Element not clicked, expected: %s, but found %s", navigateName, pageHolderElement.getText()));
        }

        if ((!isCorrectPageOpened(navigateName))) {
            throw new IllegalArgumentException(format("Wrong page opened. Expected %s, but found %s", navigateName, pageHolderElement.getText()));
        }
    }

    private static boolean isCorrectPageOpened(String optionToNavigateTo) {

        return pageHolderElement.getText().equals(optionToNavigateTo);
    }
}
