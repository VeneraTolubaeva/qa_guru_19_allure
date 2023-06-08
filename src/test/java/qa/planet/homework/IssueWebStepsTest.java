package qa.planet.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueWebStepsTest {

    public static final String PROFILE = "VeneraTolubaeva/";
    public static final String REPOSITORY = "VeneraTolubaeva/qa_guru_19_allure";

    public static final String ISSUE = "issue_to_test_allure_repor";

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        IssueWebSteps steps = new IssueWebSteps();
        steps.openMainPage();
        steps.searchProfile(PROFILE);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.clickIssuesTab();
        steps.checkingIssueTitle(ISSUE);
        steps.takeScreenshot();
    }
}
