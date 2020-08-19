package com.company.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.company.ui.DriverManager.*;

public class BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        getDriver().manage().window().maximize();
        implicitWait();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        quit();
    }
}
