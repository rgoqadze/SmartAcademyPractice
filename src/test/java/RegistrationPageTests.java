import DataObject.RegistrationData;
import PageObject.RegistrationPage;
import StepObject.CartPageSteps;
import StepObject.RegistrationPageSteps;
import StepObject.SearchPageSteps;
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
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationPageTests extends Runner {
    SearchPageSteps add = new SearchPageSteps();
    CartPageSteps cart = new CartPageSteps();
    RegistrationPageSteps steps = new RegistrationPageSteps();
    RegistrationPage element = new RegistrationPage();
    String colorBorder = "#ff0000";

    @Test( priority = 0)
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

    @Test( priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click send button and Check company name validation, TestCase #19")
    public void companyNameValidationCheck() throws InterruptedException {
        steps
                .checkEmptyButtons();
        Assert.assertEquals(Color.fromString(element.companyNameInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Personal ID validation, TestCase #20")
    public void personalIDValidationCheck() {

        Assert.assertEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Address validation, TestCase #21")
    public void addressValidationCheck() {

        Assert.assertEquals(Color.fromString(element.addressInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Phone validation, TestCase #22")
    public void phoneValidationCheck() {

        Assert.assertEquals(Color.fromString(element.phoneInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Order date validation, TestCase #23")
    public void orderDateValidationCheck() {

        Assert.assertEquals(Color.fromString(element.orderDate.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Email validation, TestCase #24")
    public void emailValidationCheck() {

        Assert.assertEquals(Color.fromString(element.emailInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set company name value, TestCase #25")
    public void fulCompanyNameInput() {
        System.out.println(companyNameValue+ " " + "  ++++++++++++++++" );
        steps
                .companyNameSetValueCheck(companyNameValue);

        Assert.assertNotEquals(Color.fromString(element.companyNameInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set personal ID String value, TestCase #26")
    public void personalIDStringInput() {
        steps
                .personalIDStringValueCheck(personalIDStringValue);
        Assert.assertFalse(Boolean.parseBoolean(element.personalUIDInput.getText()));
    }

    @Test( priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set short personal ID value, TestCase #27")
    public void personalIDShortValueCheck() {
        steps
                .setShortPersonalID((int) personalIDShortValue);
        Assert.assertEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }
// გადაცემული ველიუ არ ფიქსირდება ინსპექტში.
    @Test( priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set long Personal ID value, TestCase #28")
    public void personalIDLongValueCheck() {
        steps
                .setLongPersonalID((int) personalIDLongValue);
        sleep(3000);
        Assert.assertEquals(element.personalUIDInput.getText().length(),0);
    }

    @Test( priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set personal ID value, TestCase #29")
    public void personalIDValueCheck() {
        steps
                .setPersonalID((int) personalIDValue);
        Assert.assertNotEquals(Color.fromString(element.personalUIDInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }

    @Test( priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Set address value, TestCase #30")
    public void setAddressValueCheck() {
        steps
                .setAddressValue(addressValue);
        Assert.assertNotEquals(Color.fromString(element.addressInput.getCssValue("border").substring(10, 24)).asHex(), colorBorder);
    }
}
