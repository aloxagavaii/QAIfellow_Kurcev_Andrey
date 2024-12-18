package ru.iFellow;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import ru.iFellow.util.CommonProperties;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    @BeforeEach
    public void initBrowser() throws IOException {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.browser = Browsers.CHROME;
        Selenide.open(CommonProperties.getProperty("url"));
        getWebDriver().manage().window().maximize();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
