package com.hw11.pages;
import com.codeborne.selenide.SelenideElement;
import com.hw11.pages.components.CalendarComponent;
import com.hw11.pages.components.CityComponent;
import com.hw11.pages.components.VerifyComponent;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SimpleFormWithPageObjectsSteps {

    CalendarComponent calendarComponent = new CalendarComponent();
    CityComponent cityComponent = new CityComponent();
    VerifyComponent verifyResultWO = new VerifyComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            ganderWrapper = $("#genterWrapper").parent(),
            userNumberInput = $("#userNumber"),
            dayBirthInput = $("#dateOfBirthInput"),
            currentAddressInput = $("#currentAddress"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureFile = $("#uploadPicture"),
            submitButton = $("#submit");

    @Step("Открываем главную страницу")
    public SimpleFormWithPageObjectsSteps openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Удаляем банер")
    public SimpleFormWithPageObjectsSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Заносим Имя")
    public SimpleFormWithPageObjectsSteps setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заносим Отчество")
    public SimpleFormWithPageObjectsSteps setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заносим имейл")
    public SimpleFormWithPageObjectsSteps setUserEmailName(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Заносим пол")
    public SimpleFormWithPageObjectsSteps setGender(String value) {
        ganderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Заносим номер телефона")
    public SimpleFormWithPageObjectsSteps setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Заносим дату рождения")
    public SimpleFormWithPageObjectsSteps setBirthDay(String day,
                                                      String month,
                                                      String year) {
        dayBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Заносим текущий адрес")
    public SimpleFormWithPageObjectsSteps setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Заносим хобби")
    public SimpleFormWithPageObjectsSteps setHobby(String sport) {
        hobbiesWrapper.$(byText(sport)).click();
        return this;
    }

    @Step("Заносим область")
    public SimpleFormWithPageObjectsSteps setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        return this;
    }

    @Step("Заносим город")
    public SimpleFormWithPageObjectsSteps setCity(String area, String city) {
        cityComponent.setCity(area, city);
        return this;
    }

    @Step("Заносим имейл")
    public SimpleFormWithPageObjectsSteps uploadPicture(String value) {
        pictureFile.uploadFile(new File(value));
        return this;
    }

    @Step("Отправляем форму")
    public SimpleFormWithPageObjectsSteps clickSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Проверка данных в поле формы")
    public SimpleFormWithPageObjectsSteps checkResult(String fromTable, String fromUser) {
        verifyResultWO.verifyResults(fromTable, fromUser);
        return this;
    }

}

