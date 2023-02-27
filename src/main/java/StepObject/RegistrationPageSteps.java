package StepObject;

import DataObject.RegistrationData;
import PageObject.RegistrationPage;


public class RegistrationPageSteps extends RegistrationPage {

    public RegistrationPageSteps goToRegistration() {
        continueButton.click();
        return this;
    }

    public RegistrationPageSteps checkEmptyButtons(){
        sendButton.click();
        pisTab.scrollIntoView(true);
        return this;
    }

    public RegistrationPage companyNameSetValueCheck(String companyNameValue) {
        companyNameInput.setValue(companyNameValue);
        sendButton.click();
        return this;
    }

    public RegistrationPage personalIDStringValueCheck(String personalIDStringValue) {
        personalUIDInput.setValue(personalIDStringValue);
        return this;

    }

    public RegistrationPage setShortPersonalID(int personalIDShortValue) {
        personalUIDInput.setValue(String.valueOf(personalIDShortValue));
        return this;
    }

    public RegistrationPage setLongPersonalID(int personalIDLongValue) {
        personalUIDInput.setValue(String.valueOf(personalIDLongValue));
        return this;
    }

    public RegistrationPage setPersonalID(int personalIDValue) {
        personalUIDInput.setValue(String.valueOf(personalIDValue));
        sendButton.click();
        return this;
    }

    public RegistrationPage setAddressValue(String addressValue) {
        addressInput.setValue(addressValue);
        sendButton.click();
        return this;
    }
}
