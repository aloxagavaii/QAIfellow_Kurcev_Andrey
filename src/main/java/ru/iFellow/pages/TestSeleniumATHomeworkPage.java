package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumATHomeworkPage {
    private final SelenideElement statusTask = $x("//span[@id='status-val']/span").as("инфо Статус");
    private final SelenideElement version = $x("//span[@id='fixVersions-field']/a").as("инфо Версия");

    public String getInfoAboutTask() {
        return statusTask.shouldBe(Condition.visible).getText()+" "+version.getText();
    }
}
