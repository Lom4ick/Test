package com.company.ui.pages;

import com.company.ReadFileData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.company.ui.DriverManager.getDriver;

public class HomePage {

    private static final String CABINET = "//a[@class='header-topline__user-link link-dashed']";
    private static final String LOGIN_INPUT = "auth_email";
    private static final String PASSWORD_INPUT = "auth_pass";
    private static final String ENTER_BUTTON = "//button[@class='button button_size_large button_color_green auth-modal__submit']";

    private static final String LOGIN_ERROR_MESSAGE = "//p[@class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']";

    private ReadFileData data = new ReadFileData();

    @Step
    public HomePage getHomePage() {
        getDriver().get(data.getHomePageUrl());
        return this;
    }

    @Step
    public HomePage clickCabinet() {
        getDriver().findElement(By.xpath(CABINET)).click();
        return this;
    }

    @Step
    public HomePage setLogin(String login) {
        getDriver().findElement(By.id(LOGIN_INPUT)).sendKeys(login);
        return this;
    }

    @Step
    public HomePage setPassword(String password) {
        getDriver().findElement(By.id(PASSWORD_INPUT)).sendKeys(password);
        return this;
    }

    @Step
    public HomePage clickEnterButton() {
        getDriver().findElement(By.xpath(ENTER_BUTTON)).click();
        return this;
    }


    @Step
    public WebElement verifyLoginErrorMessage() {
        return getDriver().findElement(By.xpath(LOGIN_ERROR_MESSAGE));
    }
}