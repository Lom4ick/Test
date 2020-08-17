package com.company.ui;

import com.company.ReadFileData;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver instance;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return getInstance(getBrowserType());
    }

    private enum BrowserType {
        FIREFOX_WINDOWS("firefox_windows"),
        CHROME_WINDOWS("chrome_windows");

        private String browser;

        BrowserType(String value) {
            browser = value;
        }

        private String getBrowserName() {
            return browser;
        }
    }

    private static WebDriver getInstance(BrowserType type) {
        if (instance == null) {
            switch (type) {
                case FIREFOX_WINDOWS:
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    ProfilesIni profilesIni = new ProfilesIni();
                    FirefoxProfile firefoxProfile = profilesIni.getProfile("default");
                    firefoxProfile.setPreference("reader.parse-on-load.enabled",false);
                    FirefoxOptions fo = new FirefoxOptions();
                    fo.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                    fo.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
                    instance = new FirefoxDriver(fo);
                    break;
                case CHROME_WINDOWS:
                default:
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
                    instance = new ChromeDriver();
                    break;
            }
        }
        return instance;
    }

    private static BrowserType getBrowserType() {
        BrowserType type = null;
        ReadFileData data = new ReadFileData();
        String browserName = data.getBrowser();
        for (BrowserType bType : BrowserType.values()) {
            if (bType.getBrowserName().equalsIgnoreCase(browserName)) {
                type = bType;
            }
        }
        return type;
    }

    static void quit() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }

    static void implicitWait() {
        instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}