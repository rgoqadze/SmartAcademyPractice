package StepObject;

import DataObject.RegistrationData;
import PageObject.RegistrationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationPageSteps extends RegistrationPage {

    @Step("Go to registration page")
    public RegistrationPageSteps goToRegistration() {
        continueButton.click();
        return this;
    }

    @Step("Check empty inputs")
    public RegistrationPageSteps checkEmptyButtons(){
        sendButton.click();
        pisTab.hover();
        return this;
    }

    @Step("Set company Value")
    public RegistrationPage companyNameSetValueCheck(String companyNameValue) {
        companyNameInput.setValue(companyNameValue);
        sendButton.click();
        return this;
    }

    @Step("set String personal ID")
    public RegistrationPage personalIDStringValueCheck(String personalIDStringValue) {
        personalUIDInput.setValue(personalIDStringValue);
        return this;

    }

    @Step("Set Short personal ID")
    public RegistrationPage setShortPersonalID(int personalIDShortValue) {
        personalUIDInput.setValue(String.valueOf(personalIDShortValue));
        sendButton.click();
        return this;
    }

    @Step("Set long personal ID")
    public RegistrationPage setLongPersonalID(int personalIDLongValue) {
        personalUIDInput.setValue(String.valueOf(personalIDLongValue));
        sendButton.click();
        pisTab.hover();
        return this;
    }

    @Step("Set personal ID")
    public RegistrationPage setPersonalID(int personalIDValue) {
        personalUIDInput.setValue(String.valueOf(personalIDValue));
        sendButton.click();
        return this;
    }

    @Step("Clear personal ID input")
    public RegistrationPage PersonalIDInputClear(){
        personalUIDInput.clear();
        return this;
    }

    @Step("Set address value")
    public RegistrationPage setAddressValue(String addressValue) {
        addressInput.setValue(addressValue);
        sendButton.click();
        return this;
    }

    @Step("Set String phone value")
    public RegistrationPage setPhoneStringValue(String phoneStringValue) {
        phoneInput.setValue(phoneStringValue);
        return this;
    }

    @Step("Set short phone value")
    public RegistrationPage setPhoneShortValue(int phoneShortValue) {
        phoneInput.setValue(String.valueOf(phoneShortValue));
        sendButton.click();
        return this;
    }

    @Step("Set long phone value")
    public RegistrationPage setPhoneLongValue(int phoneLongValue){
        phoneInput.setValue(String.valueOf(phoneLongValue));
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Set phone value")
    public RegistrationPage setPhoneValue(int phoneValue) {
        phoneInput.setValue(String.valueOf(phoneValue));
        companyNameInput.click();
        return this;
    }

    @Step("Clear phone input")
    public RegistrationPage phoneInputClear() {
        phoneInput.clear();
        return this;
    }

    @Step("Set order date short value")
    public RegistrationPage setDateShortValue(String dateSortValue){
        orderDate.setValue(dateSortValue);
        sendButton.click();
        return this;
    }

    @Step("Set ordet date value")
    public RegistrationPage setDateValue(String dateValue){
        orderDate.setValue(dateValue);
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Clear order date input")
    public RegistrationPage orderDateInputClear(){
        orderDate.clear();
        return this;
    }

    @Step("Set email value")
    public RegistrationPage setEmailValue(String  emailValue){
        emailInput.setValue(emailValue);
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Set Wrong emai value 1")
    public RegistrationPage setEmailWrongValue1 (String emailWrongValue1){
        emailInput.setValue(emailWrongValue1);
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Set Wrong emai value 2")
    public RegistrationPage setEmailWrongValue2(String emailWrongValue2){
        emailInput.setValue(emailWrongValue2);
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Set Wrong emai value 3")
    public RegistrationPage setEmailWrongValue3(String emailWrongValue3){
        emailInput.setValue(emailWrongValue3);
        sendButton.click();
        companyNameInput.click();
        return this;
    }

    @Step("Clear email input")
    public RegistrationPage emailInputClear(){
        emailInput.click();
        sendButton.click();
        companyNameInput.click();
        return this;
    }
}
