package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumATHomeworkPage {
    private final SelenideElement statusTask = $x("//span[@id='status-val']/span").as("инфо Статус");
    private final SelenideElement version = $x("//span[@id='fixVersions-field']/a").as("инфо Версия");

    @Step("Проверить статус и версию TestSeleniumATHomework")
    public String getInfoAboutTask() {
        return statusTask.shouldBe(Condition.visible).getText()+" "+version.getText();
    }
}
