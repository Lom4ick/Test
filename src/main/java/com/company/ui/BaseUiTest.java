package com.company.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.company.ui.DriverManager.setUpBrowser;

public class BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        setUpBrowser();
        open("");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        closeWebDriver();
    }
}
