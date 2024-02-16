package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private SelenideElement errorMessage = $("[data-test-id='error-notification'] .notification__content");


    public void verificationPageIsVisible() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify (String code) {
        codeField.setValue(code);
        verifyButton.click();
        return new DashboardPage();
    }

    public void verify (String code) {
        codeField.setValue(code);
        verifyButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(text(expectedText)).shouldBe(visible);
    }
}
