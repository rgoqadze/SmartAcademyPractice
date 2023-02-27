import DataObject.RegistrationData;
import PageObject.RegistrationPage;
import StepObject.CartPageSteps;
import StepObject.RegistrationPageSteps;
import StepObject.SearchPageSteps;
import Utils.Retry;
import Utils.Runner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static DataObject.RegistrationData.*;
import static DataObject.SearchPageData.*;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;


public class RegistrationPageTests extends Runner {
    SearchPageSteps add = new SearchPageSteps();
    CartPageSteps cart = new CartPageSteps();
    RegistrationPageSteps steps = new RegistrationPageSteps();
    RegistrationPage element = new RegistrationPage();
    String colorBorder = "#ff0000";

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add products in to card and go registration, TestCase #18")
    public void goToRegistration() {
        add
                .clickSearchButton()
                .KeywordSearch(keywordValue);
        cart
                .addProducts()
                .goToCart();
        steps
                .goToRegistration();
        element.iurTab.shouldBe(Condition.visible, Duration.ofMillis(3000));
        Assert.assertTrue(element.iurTab.isDisplayed());
        Assert.assertTrue(element.pisTab.isDisplayed());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click send button and Check company name validation, TestCase #19")
    public void companyNameValidationCheck() throws InterruptedException {
        int index = element.companyNameInput.getCssValue("border").length();
        steps
                .checkEmptyButtons();
        Assert.assertEquals(Color.fromString(element.companyNameInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Personal ID validation, TestCase #20")
    public void personalIDValidationCheck() {
        int index = element.personalUIDInput.getCssValue("border").length();
        Assert.assertEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10,index)).asHex(), colorBorder);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Address validation, TestCase #21")
    public void addressValidationCheck() {
        int index = element.addressInput.getCssValue("border").length();
        Assert.assertEquals(Color.fromString(element.addressInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Phone validation, TestCase #22")
    public void phoneValidationCheck() {
        int index = element.phoneInput.getCssValue("border").length();
        Assert.assertEquals(Color.fromString(element.phoneInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Order date validation, TestCase #23")
    public void orderDateValidationCheck() {
        int index = element.orderDate.getCssValue("border").length();
        Assert.assertEquals(Color.fromString(element.orderDate.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }



    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Email validation, TestCase #24")
    public void emailValidationCheck() {
        int index = element.emailInput.getCssValue("border").length();
        Assert.assertEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set company name value, TestCase #25")
    public void fulCompanyNameInput() {
        refresh();
        int index = element.companyNameInput.getCssValue("border").length();
        steps
                .companyNameSetValueCheck(companyNameValue);
        Assert.assertNotEquals(Color.fromString(element.companyNameInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set personal ID String value, TestCase #26")
    public void personalIDStringInput() {
        steps
                .personalIDStringValueCheck(personalIDStringValue);
        Assert.assertTrue(element.personalUIDInput.has(Condition.empty));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set short personal ID value, TestCase #27")
    public void personalIDShortValueCheck() {
        int index = element.personalUIDInput.getCssValue("border").length();
        steps
                .setShortPersonalID(personalIDShortValue);
        Assert.assertEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .PersonalIDInputClear();

    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set long Personal ID value, TestCase #28")
    public void personalIDLongValueCheck() {
        refresh();
        int index = element.personalUIDInput.getCssValue("border").length();
        steps
                .setLongPersonalID(personalIDLongValue);
        steps
                .PersonalIDInputClear();
        Assert.assertNotEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);

    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set personal ID value, TestCase #29")
    public void personalIDValueCheck() {
        int index = element.personalUIDInput.getCssValue("border").length();
        steps
                .setPersonalID(personalIDValue);
        Assert.assertNotEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set address value, TestCase #30")
    public void setAddressValueCheck() {
        int index = element.addressInput.getCssValue("border").length();
        steps
                .setAddressValue(addressValue);
        Assert.assertNotEquals(Color.fromString(element.addressInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("set phone string value, TestCase #31")
    public void phoneStringValueCheck() {
        steps
                .setPhoneStringValue(phoneStringValue);
        Assert.assertTrue(element.phoneInput.has(Condition.empty));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set short phone value, TestCase #32")
    public void phoneShortValueCheck() {
        int index = element.phoneInput.getCssValue("border").length();
        steps
                .setPhoneShortValue(phoneShortValue);
        steps.phoneInputClear();
        Assert.assertEquals(Color.fromString(element.phoneInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set long phone value, TestCase #33")
    public void phoneLongValueCheck() {
        refresh();
        int index = element.phoneInput.getCssValue("border").length();
        steps
                .setPhoneLongValue(phoneLongValue);
        Assert.assertNotEquals(Color.fromString(element.phoneInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .phoneInputClear();
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set phone value, TestCase #34")
    public void phoneValueCheck() {
        int index = element.phoneInput.getCssValue("border").length();
        steps
                .setPhoneValue(phoneValue);
        Assert.assertNotEquals(Color.fromString(element.phoneInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set order date short value, TestCase #35")
    public void orderDateShortValueCheck() {
        int index = element.orderDate.getCssValue("border").length();
        steps
                .setDateShortValue(dateShortValue);
        Assert.assertEquals(Color.fromString(element.orderDate.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .orderDateInputClear();
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set order date value, TestCase #36")
    public void orderDateValueCheck() {
        refresh();
        int index = element.orderDate.getCssValue("border").length();
        steps
                .setDateValue(dateValue);
        Assert.assertNotEquals(Color.fromString(element.orderDate.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set email value, TestCase #37")
    public void emailValueCheck() {
        refresh();
        int index = element.emailInput.getCssValue("border").length();
        steps
                .setEmailValue(emailValue);
        Assert.assertNotEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .emailInputClear();
    }
// იმეილის არასწორი ფორმტით ჩაწერაზე ხარვეზიაქვს საიტს და ფეილდება ტესტები;
    @Test(priority = 20)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set Wrong email value1, TestCase #38")
    public void emailWrongValue1Check() {
        refresh();
        int index = element.emailInput.getCssValue("border").length();
        steps
                .setEmailWrongValue1(emailWrongValue1);
        Assert.assertEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .emailInputClear();
    }

    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set Wrong email value2, TestCase #39")
    public void emailWrongValue2Check() {
        refresh();
        int index = element.emailInput.getCssValue("border").length();
        steps
                .setEmailWrongValue2(emailWrongValue2);
        Assert.assertEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
        steps
                .emailInputClear();
    }

    @Test(priority = 22)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set Wrong email value3, TestCase #40")
    public void emailWrongValue3Check() {
        refresh();
        int index = element.emailInput.getCssValue("border").length();
        steps
                .setEmailWrongValue3(getEmailWrongValue3);
        Assert.assertEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, index)).asHex(), colorBorder);
    }
}
