package locators.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum MainMenuNavigation {


    WHATS_NEW("What's New", "ui-id-3"),
    WOMEN("Women", "ui-id-4");

    private final String name;
    private final String locator;

    MainMenuNavigation(String name, String locator) {

        this.name = name;
        this.locator = locator;
    }

    public String getName() {

        return this.name;
    }

    public String getLocator() {

        return this.locator;
    }

    public static void navigateToMenuOption(WebDriver driver, String optionToNavigateTo) {

        driver.findElement(By.id(optionToNavigateTo)).click();
    }
}
