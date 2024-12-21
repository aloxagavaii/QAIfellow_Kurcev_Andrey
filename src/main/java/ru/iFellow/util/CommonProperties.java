package ru.iFellow.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonProperties {
    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/variables.properties"));
        return properties.getProperty(key);
    }
}
