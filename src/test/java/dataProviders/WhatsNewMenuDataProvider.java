package dataProviders;

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
}
