package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // read the data.properties file and give the value of key

    public static String readKey(String Key) {
        Properties p;
        try {
            String user_dir = System.getProperty("user.dir");
            String file_path = user_dir + "/src/main/resources/data.properties";

            FileInputStream fileInputStream = new FileInputStream(file_path);
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(Key);
    }
}
