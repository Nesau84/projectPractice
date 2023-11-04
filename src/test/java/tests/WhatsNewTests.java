package tests;

import asserts.WhatsNewValidations;
import dataProviders.WhatsNewMenuDataProvider;
import methods.WhatsNewMethods;
import org.testng.annotations.*;
import pretests.BaseClass;

import static locators.mainPage.MainMenuNavigation.WHATS_NEW;
import static locators.mainPage.MainMenuNavigation.navigateToMenuOption;

public class WhatsNewTests extends BaseClass {

    ThreadLocal<WhatsNewMethods> whatsNewMethods = new ThreadLocal<>();
    ThreadLocal<WhatsNewValidations> whatsNewValidations = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {

        super.beforeClass();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {

        super.beforeTest();

        whatsNewMethods.set(new WhatsNewMethods(driver.get()));
        whatsNewValidations.set(new WhatsNewValidations(driver.get()));
    }

    @Test
    public void checkWhatsNewPageLinkWorking() {

        navigateToMenuOption(driver.get(), WHATS_NEW.getLocator());
        whatsNewValidations.get().assertWhatsNewPageAccessed();
    }

    @Test(dataProvider = "whatsNewMenuBoolProvider"
            ,dataProviderClass = WhatsNewMenuDataProvider.class)
    public void verifyContentsCollection(Boolean booleanValue) {

        navigateToMenuOption(driver.get(), WHATS_NEW.getLocator());
        whatsNewValidations.get().assertNewMenuItems(booleanValue);
    }

    @AfterMethod
    public void afterTest() {

        super.afterTest();
    }

    @AfterClass
    public void afterClass() {

        super.afterClass();
    }
}
