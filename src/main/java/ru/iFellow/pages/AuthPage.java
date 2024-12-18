package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement name = $x("//input[@id='login-form-username']").as("поле ввода информации");
    private final SelenideElement password = $x("//input[@id='login-form-password']").as("поле ввода пароля");
    private final SelenideElement AuthButton = $x("//input[@id='login']").as("кнопка Войти");

    @Step("Ввод аккаунта")
    public void auth(String userName, String userPassword) {
        name.shouldBe(Condition.visible).setValue(userName);
        password.setValue(userPassword);
        AuthButton.click();
    }
}
