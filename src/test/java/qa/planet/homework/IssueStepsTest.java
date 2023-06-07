package qa.planet.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueStepsTest {
    public static final String PROFILE = "VeneraTolubaeva/";
    public static final String REPOSITORY = "VeneraTolubaeva/qa_guru_19_allure";

    @Test
    @Feature("'Issues' в репозитории")
    @Owner("VeneraTolubaeva/")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Лямбда тест")


    public void testLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });

        step("Ищем профиль на github " + PROFILE, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(PROFILE);
            $(".header-search-input").submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Проверка названия 'Issues' в репозитории", () -> {
            $("#repository-container-header").shouldHave(text("Issues"));
        });

    }
}
