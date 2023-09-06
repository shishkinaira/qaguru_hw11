package com.hw11.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyComponent {

    SelenideElement table = $(".table-responsive");
    public void verifyResults(String fromTableVC, String fromUserVC) {
        table.$(byText(fromTableVC)).sibling(0).shouldHave(text(fromUserVC));
    }

}
