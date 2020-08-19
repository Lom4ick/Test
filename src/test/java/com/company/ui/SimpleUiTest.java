package com.company.ui;

import com.company.ui.pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class SimpleUiTest extends BaseUiTest {

    private HomePage homePage = new HomePage();

    @Feature("authorization")
    @Test
    public void authorizationWrongLogin() {
        homePage
                .getHomePage()
                .clickCabinet()
                .setLogin("kjsbdfjkbdsfjb@gmail.com")
                .setPassword("wrongPassword")
                .clickEnterButton()
                .verifyLoginErrorMessage();
    }
}
