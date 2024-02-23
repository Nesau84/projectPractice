package dataProviders;

import enums.MainPageElements;
import org.testng.annotations.DataProvider;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class WhatsNewMenuDataProvider {

    @DataProvider(name = "whatsNewMenuBoolProvider"
            , parallel = true)
    public Object[][] whatsNewMenuBoolProvider() {

        return new Object[][]{
                {TRUE},
                {FALSE}
        };
    }

    @DataProvider(name = "pagesToNavigate")
    public Object[][] pagesToNavigate() {

        return new Object[][]{

                {MainPageElements.WHATS_NEW.getPageElement(), MainPageElements.WHATS_NEW.getName(), 4},
                {MainPageElements.MEN.getPageElement(), MainPageElements.MEN.getName(), 4},
                {MainPageElements.WOMEN.getPageElement(), MainPageElements.WOMEN.getName(), 4},
                {MainPageElements.GEAR.getPageElement(), MainPageElements.GEAR.getName(), 4}
        };
    }
}
