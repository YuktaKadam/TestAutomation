package org.example.testng.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

  public static Properties props = new Properties();

  public static Properties loadapplicationproperties() throws IOException {
    FileInputStream inputStream = new FileInputStream("Y:\\Automation\\TestNG\\Application.properties");
    props.load(inputStream);
    return props;
  }

  public static Properties loadframeworkproperties() throws IOException {
    FileInputStream inputStream = new FileInputStream("Y:\\Automation\\TestNG\\Framework.properties");
    props.load(inputStream);
    return props;
  }

}
