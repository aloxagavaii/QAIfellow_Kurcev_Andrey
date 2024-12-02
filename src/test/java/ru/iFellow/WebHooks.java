package ru.iFellow;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    @Before
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
