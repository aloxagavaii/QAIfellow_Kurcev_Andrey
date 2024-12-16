package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MyBugPage {
    private final SelenideElement myBugStatus = $x("//span[@id='status-val']/span").as("инфо Статус");
    private final SelenideElement jobButton = $x("//a[@id='action_id_21']").as("кнопка В работе");
    private final SelenideElement businessButton = $x("//a[@id='opsbar-transitions_more']").as("выпадающий список Бизнес-процесс");
    private final SelenideElement businessButtonOption = $x("//aui-item-link[@id='action_id_31']/a").as("пункт Выполнено списка Бизнес-поцесс");

    @Step("Проставить статусы бага")
    public void changeBugStatus() {
        jobButton.shouldBe(Condition.visible).click();
        myBugStatus.shouldHave(Condition.text("В работе"));
        businessButton.click();
        businessButtonOption.shouldBe(Condition.visible).click();
        myBugStatus.shouldHave(Condition.text("Готово"));
    }

    @Step("Проверить статус бага")
    public String getStatusMyBug() {
        return myBugStatus.getText();
    }
}
