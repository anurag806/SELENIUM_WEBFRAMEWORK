package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
   private static FileInputStream fis;
     private static Properties prop = new Properties();

    static {
        try {
            fis = new FileInputStream("src//main//resources//config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getProperty(String key) {

        return prop.getProperty(key);
    }

}
