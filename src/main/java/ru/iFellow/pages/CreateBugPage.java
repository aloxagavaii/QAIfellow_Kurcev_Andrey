package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateBugPage {
    private final SelenideElement themeInput = $x("//input[@id='summary']").as("поле Тема");
    private final SelenideElement descriptionInput = $x("//textarea[@id='description']").as("поле Описание");
    private final SelenideElement versionOption = $x("//select[@id='fixVersions']//option[@value='10000']").as("пункт Version1 в списке Исправить в версиях");
    private final SelenideElement environmentInput = $x("//textarea[@id='environment']").as("поле Окружение");
    private final SelenideElement seriousnessInput = $x("//select[@id='customfield_10400']").as("выпадающий список Серьезность");
    private final SelenideElement seriousnessInputOption = $x("//select[@id='customfield_10400']//option[@value='10103']").as("пункт Критический списка Серьезность");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']").as("кнопка Создать");

    public void performCreateBug(String theme, String desc, String env) {
        themeInput.shouldBe(Condition.visible).setValue(theme);
        descriptionInput.setValue(desc);
        versionOption.click();
        environmentInput.setValue(env);
        seriousnessInput.click();
        seriousnessInputOption.click();
        createButton.click();
    }
}
