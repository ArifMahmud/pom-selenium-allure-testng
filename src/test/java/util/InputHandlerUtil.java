package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InputHandlerUtil {
    public static String url;
    public static String email;
    public static String password;

    public static void loadConfigFile() throws IOException {

        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src\\test\\resources\\config.properties");
        prop.load(ip);

        email = prop.getProperty("emailaddress");
        password = prop.getProperty("password");
        url = prop.getProperty("url");
    }
}
