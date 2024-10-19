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

    public String platformName(){
        String platform_name = properties.getProperty("test_start_log");
        if (platform_name != null)
            return platform_name;
        else
            throw new RuntimeException("App Execution Platform Is Not Defined On The Config File");
    }

    public String iOSBundleID(){
        String ios_bundle = properties.getProperty("WDIOAPPBundleId");
        if (ios_bundle != null)
            return ios_bundle;
        else
            throw new RuntimeException("App bundle ID Is Not Defined On The Config File");
    }

}
