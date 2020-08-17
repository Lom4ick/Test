package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFileData {

    private Properties prop = new Properties();

    public ReadFileData() {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHomePageUrl() {
        return prop.getProperty("HOME_PAGE_URL");
    }

    public String getBrowser() {
        return prop.getProperty("BROWSER");
    }
}