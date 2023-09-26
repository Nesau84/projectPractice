package pretests;

import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static java.lang.String.format;

@Log
public class PropertiesReader {

    static Properties properties = new Properties();
    static URL url = ClassLoader.getSystemResource("Application.properties");

    public static void initLoader() {

        try {
            properties.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getInformationFromProperties() {

        log.info(format("Host name: %s", properties.getProperty("hostname")));
        log.info(format("Maximize window: %s", properties.getProperty("maximize")));
        log.info(format("Browser name: %s", properties.getProperty("browser")));
        log.info(format("URL: %s", properties.getProperty("url")));
    }
}