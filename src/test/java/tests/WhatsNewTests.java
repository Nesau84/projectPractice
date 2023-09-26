package tests;

import asserts.WhatsNewValidations;
import methods.WhatsNewMethods;
import org.testng.annotations.*;
import pretests.BaseClass;

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

        whatsNewMethods.set(new WhatsNewMethods(driver));
        whatsNewValidations.set(new WhatsNewValidations(driver));
    }

    @Test
    public void checkWhatsNewPageLinkWorking() {

        whatsNewMethods.get().openWhatsNewMenu();
        whatsNewValidations.get().assertWhatsNewPageAccessed();
    }

    @Test
    public void verifyContentsAllWomansCollection() {

        whatsNewMethods.get().openWhatsNewMenu();
        whatsNewValidations.get().assertNewWomansMenuItems();
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
