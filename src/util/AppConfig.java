package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Échec du chargement du fichier de configuration.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Échec du chargement du fichier de configuration.");
        }
    }
    public static String getDbUrl()
    {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername()
    {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword()
    {
        return properties.getProperty("db.password");
    }
}
