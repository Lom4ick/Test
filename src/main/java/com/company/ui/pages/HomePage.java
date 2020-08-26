package com.company.ui.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private static final String CABINET = "//a[@class='header-topline__user-link link-dashed']";
    private static final String LOGIN_INPUT = "//*[@id='auth_email']";
    private static final String PASSWORD_INPUT = "//*[@id='auth_pass']";
    private static final String ENTER_BUTTON = "//button[@class='button button_size_large button_color_green auth-modal__submit']";

    private static final String LOGIN_ERROR_MESSAGE = "//a[@class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']";

    public HomePage authorize() {
        clickCabinet();
        setLogin("tester123tester@i.ua");
        setPassword("Automation555");
        clickEnterButton();
        return this;
    }

    @Step
    public HomePage clickCabinet() {
        $x(CABINET).click();
        return this;
    }

    @Step
    public HomePage setLogin(String login) {
        $x(LOGIN_INPUT).setValue(login);
        return this;
    }

    @Step
    public HomePage setPassword(String password) {
        $x(PASSWORD_INPUT).setValue(password);
        return this;
    }

    @Step
    public HomePage clickEnterButton() {
        $x(ENTER_BUTTON).click();
        return this;
    }


    @Step
    public HomePage verifyLoginErrorMessage() {
        $x(LOGIN_ERROR_MESSAGE).shouldBe(Condition.appears);
        return this;
    }
}