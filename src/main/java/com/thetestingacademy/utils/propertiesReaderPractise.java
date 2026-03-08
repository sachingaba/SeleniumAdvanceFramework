package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesReaderPractise {

    static Properties p;

    static String readKey(String key) throws IOException {

        String path = System.getProperty("user.dir") + "/src/main/java/resources/data.properties" ;

        try {
            FileInputStream fis = new FileInputStream(path);

            p = new Properties();

            p.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

return p.getProperty(key);
    }
}
