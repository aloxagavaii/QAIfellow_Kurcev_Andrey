package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectTestPage {
    private final SelenideElement openTasksCount = $x("//div[@class='showing']/span").as("счетчик количества открытых задач");
    private final SelenideElement nameProject = $x("//a[@id='project-name-val']").as("ссылка на проект");
    private Integer count;

    public void beforeCount() {
        count = Integer.parseInt(openTasksCount.getText().split(" из ")[1]);
    }

    @Step("Проверить первоначальное количество открытых задач")
    public Integer getOpenTasksCount1() {
        return count;
    }

    @Step("Проверить последующее количество открытых задач")
    public Integer getOpenTasksCount2() {
        return Integer.parseInt(openTasksCount.getText().split(" из ")[1]);
    }

    public String getNameProject() {
        return nameProject.shouldBe(Condition.visible).getText();
    }

}
