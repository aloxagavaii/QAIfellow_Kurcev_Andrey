package ru.iFellow;

import org.junit.jupiter.api.*;
import ru.iFellow.pages.*;
import ru.iFellow.util.CommonProperties;

import java.io.IOException;

public class Tests extends WebHooks {
    private final AuthPage authPage = new AuthPage();
    private final MainPage mainPage = new MainPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private final TestSeleniumATHomeworkPage testSeleniumATHomeworkPage = new TestSeleniumATHomeworkPage();
    private final CreateBugPage createBugPage = new CreateBugPage();
    private final MyBugPage myBugPage = new MyBugPage();

    @Test
    @Tag("gr")
    @Order(1)
    @DisplayName("Вход в систему")
    public void checkAuth() throws IOException {
        authPage.auth(CommonProperties.getProperty("name"), CommonProperties.getProperty("pas"));
        Assertions.assertEquals("Проекты",mainPage.getText());
    }

    @Test
    @Tag("gr")
    @Order(2)
    @DisplayName("Переход в проект Тест")
    public void checkTransitionTest() throws IOException {
        authPage.auth(CommonProperties.getProperty("name"), CommonProperties.getProperty("pas"));
        mainPage.choiseProjectTest();
        Assertions.assertEquals("Test",projectTestPage.getNameProject());
    }

    @Test
    @Tag("gr")
    @Order(3)
    @DisplayName("Проверка количества заведенных задач")
    public void checkCountTasks() throws IOException {
        authPage.auth(CommonProperties.getProperty("name"), CommonProperties.getProperty("pas"));
        mainPage.choiseProjectTest();
        projectTestPage.beforeCount();
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема2","описание","chrome 131");
        mainPage.choiseProjectTest();
        Assertions.assertNotEquals(projectTestPage.getOpenTasksCount1(),projectTestPage.getOpenTasksCount2());
    }

    @Test
    @Tag("gr")
    @Order(4)
    @DisplayName("TestSeleniumATHomework")
    public void checkTestSeleniumATHomework() throws IOException {
        authPage.auth(CommonProperties.getProperty("name"), CommonProperties.getProperty("pas"));
        mainPage.choiseProjectTest();
        mainPage.choiseTask("TestSeleniumATHomework");
        Assertions.assertEquals("СДЕЛАТЬ Version 2.0",testSeleniumATHomeworkPage.getInfoAboutTask());
    }

    @Test
    @Tag("gr")
    @Order(5)
    @DisplayName("Создание нового бага")
    public void checkCreateNewBug() throws IOException {
        authPage.auth(CommonProperties.getProperty("name"), CommonProperties.getProperty("pas"));
        mainPage.choiseProjectTest();
        mainPage.choiseTask("TestSeleniumATHomework");
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема","описание","chrome 131");
        mainPage.openMyBug();
        myBugPage.changeBugStatus();
        Assertions.assertEquals("ГОТОВО",myBugPage.getStatusMyBug());
    }
}
