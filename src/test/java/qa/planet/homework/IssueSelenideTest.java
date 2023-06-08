package qa.planet.homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueSelenideTest {

        @Test
        @DisplayName("Тест с Listener")
        public void issueSelenideTest() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com/");

            $(".header-search-input").click();
            $(".header-search-input").sendKeys("VeneraTolubaeva/");
            $(".header-search-input").submit();

            $(linkText("VeneraTolubaeva/qa_guru_19_allure")).click();
            $("#issues-tab").click();
            $(withText("TEST ISSUE")).should(Condition.exist);
        }
}

