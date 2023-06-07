package qa.planet.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import qa.planet.homework.IssueWebSteps;

public class IssueWebStepsTest {

    public static final String PROFILE = "VeneraTolubaeva/";
    public static final String REPOSITORY = "VeneraTolubaeva/qa_guru_19_allure";

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        IssueWebSteps steps = new IssueWebSteps();
        steps.openMainPage();
        steps.searchProfile(PROFILE);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.checkingIssueTitle();
        steps.takeScreenshot();
    }
}
