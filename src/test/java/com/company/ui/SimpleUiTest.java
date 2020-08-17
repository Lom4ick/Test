package com.company.ui;

import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleUiTest {

    @Feature("authorization")
    @Test
    public void authorizationWrongLogin() throws InterruptedException {
        // driver initialize
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile firefoxProfile = profilesIni.getProfile("default");
        firefoxProfile.setPreference("reader.parse-on-load.enabled",false);
        FirefoxOptions fo = new FirefoxOptions();
        fo.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        fo.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //steps
        driver.get("https://rozetka.com.ua/");

        driver.findElement(By.xpath("//a[@class='header-topline__user-link link-dashed']")).click();
        driver.findElement(By.id("auth_email")).sendKeys("kjsbdfjkbdsfjb@gmail.com");
        driver.findElement(By.id("auth_pass")).sendKeys("wrongPassword");
        driver.findElement(By.xpath("//button[@class='button button_size_large button_color_green auth-modal__submit']")).click();

        driver.findElement(By.xpath("//p[@class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']"));

        Thread.sleep(3000);

        //finalize
        driver.quit();
    }
}
