package tests;

import asserts.WhatsNewValidations;
import dataProviders.WhatsNewMenuDataProvider;
import methods.WhatsNewMethods;
import org.testng.annotations.*;
import pretests.BaseClass;
import ru.yandex.qatools.allure.annotations.Severity;
import testResources.NavigationUtils;
import testResources.TestGroups;

import static enums.MainPageElements.WHATS_NEW;
import static ru.yandex.qatools.allure.model.SeverityLevel.BLOCKER;
import static ru.yandex.qatools.allure.model.SeverityLevel.CRITICAL;
import static testResources.NavigationUtils.navigateToMenuOption;

public class WhatsNewTests extends BaseClass {

    private final ThreadLocal<WhatsNewMethods> whatsNewMethods = new ThreadLocal<>();
    private final ThreadLocal<WhatsNewValidations> whatsNewValidations = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    @Severity(BLOCKER)
    public void beforeClass() {

        super.beforeClass();
    }

    @BeforeMethod(alwaysRun = true)
    @Severity(BLOCKER)
    public void beforeTest() {

        super.beforeTest();

        whatsNewMethods.set(new WhatsNewMethods(container.get(), driver.get()));
        whatsNewValidations.set(new WhatsNewValidations(container.get(), driver.get()));
    }

    @Test(description = "Basic check if clicking on What's new page link is working",
            groups = {TestGroups.SANITY, TestGroups.WHATS_NEW})
    @Severity(CRITICAL)
    public void checkWhatsNewPageLinkWorking() {

        navigateToMenuOption(driver.get(), WHATS_NEW.getPageElement(), WHATS_NEW.getName());

        whatsNewValidations.get().assertWhatsNewPageAccessed();
    }

    @Test(description = "Check if Collection contains everything for both Male/Female sections",
            groups = {TestGroups.SANITY, TestGroups.WHATS_NEW},
            dataProvider = "whatsNewMenuBoolProvider",
            dataProviderClass = WhatsNewMenuDataProvider.class)
    @Severity(CRITICAL)
    public void verifyContentsCollection(Boolean booleanValue) {

        navigateToMenuOption(driver.get(), WHATS_NEW.getPageElement(), WHATS_NEW.getName());

        whatsNewValidations.get().assertNewMenuItems(booleanValue);
    }

    @Test(description = "Verify default state of Compare Products",
            groups = {TestGroups.SANITY, TestGroups.WHATS_NEW})
    @Severity(CRITICAL)
    public void verifyCompareProductsDefaultState() {

        String expectedText = "You have no items to compare.";

        navigateToMenuOption(driver.get(), WHATS_NEW.getPageElement(), WHATS_NEW.getName());

        whatsNewValidations.get().assertCompareProductsDefaultStateText(expectedText);
    }

    @Test(description = "Verify default state of My Wish List",
            groups = {TestGroups.SANITY, TestGroups.WHATS_NEW})
    @Severity(CRITICAL)
    public void verifyMyWishListDefaultState() {

        String expectedText = "You have no items in your wish list.";

        navigateToMenuOption(driver.get(), WHATS_NEW.getPageElement(), WHATS_NEW.getName());

        whatsNewValidations.get().assertMyWishListDefaultStateText(expectedText);
    }

    //TODO to be moved to "general tests"
    @Test(description = "Verify 4 products are displayed by default",
            groups = {TestGroups.SANITY},
            dataProvider = "pagesToNavigate",
            dataProviderClass = WhatsNewMenuDataProvider.class)
    @Severity(CRITICAL)
    public void verifyDefaultProductCountForEachPage(String pageElement, String name, int expectedCount) {

        navigateToMenuOption(driver.get(), pageElement, name);
        whatsNewValidations.get().assertDefaultNumberOfProductsDisplayed(expectedCount);
    }

    @Test(description = "Verify pricing for default displayed products",
    groups = {TestGroups.SANITY, TestGroups.WHATS_NEW})
    public void verifyPricingForDefaultPageProducts() {

        navigateToMenuOption(driver.get(), WHATS_NEW.getPageElement(), WHATS_NEW.getName());
        whatsNewValidations.get().assertDefaultProductPricing(192);
    }

    @AfterMethod(alwaysRun = true)
    @Severity(BLOCKER)

    public void afterTest() {

        super.afterTest();
    }

    @AfterClass(alwaysRun = true)
    @Severity(BLOCKER)
    public void afterClass() {

        super.afterClass();
    }
}
