package com.company.ui;

import com.company.ui.pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationWrongLogin extends BaseUiTest {

    private HomePage homePage = new HomePage();

    @Feature("authorization")
    @Test
    public void authorizationWrongLogin() {

        homePage
                .getHomePage()
                .clickCabinet()
                .setLogin("sdgsdgsdg3535dfg@ukr.net")
                .setPassword("Qwerty123")
                .clickEnterButton();

        Assert.assertTrue(homePage.verifyLoginErrorMessage().isDisplayed());
    }
}
