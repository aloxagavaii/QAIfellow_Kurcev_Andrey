package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement progectsList = $x("//a[@id='browse_link']");

    private final SelenideElement progectTest = $x("//a[@id='admin_main_proj_link_lnk']");

    private final SelenideElement quickSearchInput = $x("//input[@id='quickSearchInput']");

    private final SelenideElement createBugButton = $x("//a[@id='create_link']");

    private final SelenideElement createBugDone = $x("//a[@class='issue-created-key issue-link']");

    public void choiseProjectTest() {
        progectsList.shouldBe(Condition.visible).click();
        progectTest.shouldBe(Condition.visible).click();
    }

    public String getText() {
        return progectsList.shouldBe(Condition.visible).getText();
    }

    public void choiseTask(String name) {
        quickSearchInput.shouldBe(Condition.visible).setValue(name).pressEnter();
    }

    public void openCreateBug() {
        createBugButton.shouldBe(Condition.visible).click();
    }

    public void openMyBug() {
        createBugDone.shouldBe(Condition.visible).click();
    }
}
