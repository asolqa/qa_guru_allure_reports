import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.pageLoadStrategy = "eager";
        open("https://github.com");

        $(".search-input").click();
        $("#query-builder-test").setValue("asolqa/qa_guru_files").submit();
        $(byLinkText("asolqa/qa_guru_files")).click();

        $("#issues-tab").click();
        $(withText("First Issue")).should(Condition.exist);

        Selenide.closeWebDriver();
    }
}
