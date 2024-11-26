package ru.iFellow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.*;

public class Tests extends WebHooks {
    private final AuthPage authPage = new AuthPage();

    private final MainPage mainPage = new MainPage();

    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    private final TestSeleniumATHomeworkPage testSeleniumATHomeworkPage = new TestSeleniumATHomeworkPage();

    private final CreateBugPage createBugPage = new CreateBugPage();

    private final MyBugPage myBugPage = new MyBugPage();

    private final String name = "AT2";

    private final String pas = "Qwerty123";

    @Test
    @Order(1)
    @DisplayName("Вход в систему")
    public void checkAuth() {
        authPage.auth(name,pas);
        Assertions.assertEquals("Проекты",mainPage.getText());
    }

    @Test
    @Order(2)
    @DisplayName("Переход в проект Тест")
    public void checkTransitionTest() {
        authPage.auth(name,pas);
        mainPage.choiseProjectTest();
        Assertions.assertEquals("Test",projectTestPage.getNameProject());
    }

    @Test
    @Order(3)
    @DisplayName("Проверка количества заведенных задач")
    public void checkCountTasks() {
        authPage.auth(name,pas);
        mainPage.choiseProjectTest();
        projectTestPage.beforeCount();
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема2","описание","chrome 131","Спринт 2");
        mainPage.choiseProjectTest();
        Assertions.assertNotEquals(projectTestPage.getOpenTasksCount1(),projectTestPage.getOpenTasksCount2());
//        Assertions.assertEquals(projectTestPage.getOpenTasksCount1()+1,projectTestPage.getOpenTasksCount2());
    }

    @Test
    @Order(4)
    @DisplayName("TestSeleniumATHomework")
    public void checkTestSeleniumATHomework() {
        authPage.auth(name,pas);
        mainPage.choiseProjectTest();
        mainPage.choiseTask("TestSeleniumATHomework");
        Assertions.assertEquals("СДЕЛАТЬ Version 2.0",testSeleniumATHomeworkPage.getInfoAboutTask());
    }

    @Test
    @Order(5)
    @DisplayName("Создание нового бага")
    public void checkCreateNewBug() {
        authPage.auth(name,pas);
        mainPage.choiseProjectTest();
        mainPage.choiseTask("TestSeleniumATHomework");
        mainPage.openCreateBug();
        createBugPage.performCreateBug("тема","описание","chrome 131","Спринт 2");
        mainPage.openMyBug();
        myBugPage.changeBugStatus();
        Assertions.assertEquals("ГОТОВО",myBugPage.getStatusMyBug());
    }
}
