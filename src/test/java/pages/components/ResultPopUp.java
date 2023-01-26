package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultPopUp {
    public void verifyModalAppears() {
        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
