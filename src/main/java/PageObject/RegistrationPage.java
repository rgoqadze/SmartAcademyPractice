package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public SelenideElement
        continueButton = $(".continue"),
        iurTab = $("#pis"),
        pisTab = $("#pis"),
        sendButton = $("#btn2"),
        companyNameInput = $(byAttribute("placeholder", "კომპანიის სახელწოდება")),
        personalUIDInput = $(".prs__id"),
        addressInput = $(byName("address")),
        phoneInput = $(byName("phone")),
        orderDate = $(byName("date")),
        emailInput = $(byName("email"));
}
