package com.hw11.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent {

    public void setCity(String area, String city) {

        $("#state").click();
        $("#stateCity-wrapper").$(byText(area)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

}
