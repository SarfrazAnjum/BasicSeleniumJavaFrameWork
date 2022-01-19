package utils;

import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    static Properties prop = new Properties();

    public static String readProperty(String key) throws Exception {
        FileInputStream readProps =
                new FileInputStream(
                        System.getProperty("user.dir") + "/src/main/resources/config.properties");

        prop.load(readProps);
        String value = prop.get(key).toString();
        if(StringUtils.isEmpty(value)){
            throw new Exception("The value for the "+key+" is not set");

        }
        return value;


    }
}
