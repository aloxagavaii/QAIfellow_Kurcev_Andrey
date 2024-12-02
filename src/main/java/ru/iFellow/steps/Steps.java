package ru.iFellow.steps;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.*;

public class Steps {
    private final AuthPage authPage = new AuthPage();
    private final MainPage mainPage = new MainPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private final TestSeleniumATHomeworkPage testSeleniumATHomeworkPage = new TestSeleniumATHomeworkPage();
    private final CreateBugPage createBugPage = new CreateBugPage();
    private final MyBugPage myBugPage = new MyBugPage();

    private final String name = "AT2";
    private final String pas = "Qwerty123";

    @Когда("выполняется вход")
            public void authSite() {
        authPage.auth(name,pas);
    }

    @Тогда("проверить вход в аккаунт")
            public void checkAuth() {
        Assertions.assertEquals("Проекты",mainPage.getText());
    }

    @И("выбрать проект Тест")
            public void progTest() {
        mainPage.choiseProjectTest();
    }

    @Тогда("проверить название проекта")
            public void checkTest() {
        Assertions.assertEquals("Test",projectTestPage.getNameProject());
    }

    @И("проверить количество открытых задач")
            public void checkTasks() {
        projectTestPage.beforeCount();
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема2","описание","chrome 131");
        mainPage.choiseProjectTest();
        Assertions.assertNotEquals(projectTestPage.getOpenTasksCount1(),projectTestPage.getOpenTasksCount2());
    }

    @И("выбрать задачу")
            public void testSelenium() {
        mainPage.choiseTask("TestSeleniumATHomework");
    }

    @Затем("проверить статус и версию")
            public void checkStats() {
        Assertions.assertEquals("СДЕЛАТЬ Version 2.0",testSeleniumATHomeworkPage.getInfoAboutTask());
    }

    @И("создать новый баг")
            public void createBug() {
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема","описание","chrome 131");
    }

    @Затем("пройти все статусы")
            public void allStats() {
        mainPage.openMyBug();
        myBugPage.changeBugStatus();
        Assertions.assertEquals("ГОТОВО",myBugPage.getStatusMyBug());
    }
}
