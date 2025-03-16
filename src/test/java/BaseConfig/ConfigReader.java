package BaseConfig;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;
    String baseDir = System.getProperty("user.dir");
    String path = baseDir + "/src/test/java/BaseConfig/config.properties";
    public ConfigReader(){
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(path);
            try{
                properties.load(fis);
            }catch (Exception e) {
                e.printStackTrace();}
        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String validUserName(){
        String user_name = properties.getProperty("valid_test_user");
        if (user_name != null)
            return user_name;
        else
            throw new RuntimeException("Valid User Name Is Not Defined On The Config File");
    }

    public String validPassword(){
        String user_password = properties.getProperty("valid_test_password");
        if (user_password != null)
            return user_password;
        else
            throw new RuntimeException("Valid User Password Is Not Defined On The Config File");
    }

}
