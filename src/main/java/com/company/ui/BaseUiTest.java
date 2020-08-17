package com.company.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.implicitWait();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        DriverManager.quit();
    }
}
