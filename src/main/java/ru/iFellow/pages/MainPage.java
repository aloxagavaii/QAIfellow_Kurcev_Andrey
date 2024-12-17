package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement progectsList = $x("//a[@id='browse_link']").as("выпадающий список Проекты");
    private final SelenideElement progectTest = $x("//a[@id='admin_main_proj_link_lnk']").as("пункт Тест списка Проекты");
    private final SelenideElement quickSearchInput = $x("//input[@id='quickSearchInput']").as("поле Поиск");
    private final SelenideElement createBugButton = $x("//a[@id='create_link']").as("кнопка Создать");
    private final SelenideElement createBugDone = $x("//a[@class='issue-created-key issue-link']").as("всплывающая подсказка о создании бага");

    @Step("Выбрать проект Тест")
    public void choiseProjectTest() {
        progectsList.shouldBe(Condition.visible).click();
        progectTest.shouldBe(Condition.visible).click();
    }

    public String getText() {
        return progectsList.shouldBe(Condition.visible).getText();
    }

    @Step("Ввести в поле поиска: '{name}'")
    public void choiseTask(String name) {
        quickSearchInput.shouldBe(Condition.visible).setValue(name).pressEnter();
    }

    @Step("Нажать на кнопку Создать")
    public void openCreateBug() {
        createBugButton.shouldBe(Condition.visible).click();
    }

    @Step("Нажать на всплывающую подсказку о создании бага")
    public void openMyBug() {
        createBugDone.shouldBe(Condition.visible).click();
    }
}
