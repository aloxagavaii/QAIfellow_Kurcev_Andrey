package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateBugPage {
    private final SelenideElement themeInput = $x("//input[@id='summary']");

    private final SelenideElement descriptionInput = $x("//textarea[@id='description']");

    private final SelenideElement versionOption = $x("//select[@id='fixVersions']//option[@value='10000']");

    private final SelenideElement environmentInput = $x("//textarea[@id='environment']");

    private final SelenideElement sprintInput = $x("//input[@id='customfield_10104-field']");

    private final SelenideElement seriousnessInput = $x("//select[@id='customfield_10400']");

    private final SelenideElement seriousnessInputOption = $x("//select[@id='customfield_10400']//option[@value='10103']");

    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']");

    public void performCreateBug(String theme, String desc, String env, String sprint) {
        themeInput.shouldBe(Condition.visible).setValue(theme);
        descriptionInput.setValue(desc);
        versionOption.click();
        environmentInput.setValue(env);
        sprintInput.setValue(sprint);
        seriousnessInput.click();
        seriousnessInputOption.click();
        createButton.click();
    }
}
