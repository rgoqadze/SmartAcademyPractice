import PageObject.CartPage;
import StepObject.CartPageSteps;
import StepObject.SearchPageSteps;
import Utils.Runner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

import static DataObject.SearchPageData.keywordValue;
import static com.codeborne.selenide.Selenide.sleep;

public class CartPageTests extends Runner {
    SearchPageSteps add = new SearchPageSteps();
    CartPageSteps steps = new CartPageSteps();
    CartPage element = new CartPage();

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add products in to card")
    public void addProducts() {
        add
                .clickSearchButton()
                .KeywordSearch(keywordValue);
        steps
                .addProducts()
                .goToCart();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product name must be visible")
    public void productNameCheck(){
        Assert.assertTrue(element.itemTittle.isDisplayed());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product color must be visible")
    public void productColorCheck(){
        Assert.assertTrue(element.itemColor.isDisplayed());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Product code must be visible")
    public void productCodeCheck(){
        Assert.assertTrue(element.itemCode.isDisplayed());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product quantity must be visible")
    public void productQuantityCheck(){
        Assert.assertTrue(element.itemQuantity.isDisplayed());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product price must be visible")
    public void productPriceCheck(){
        sleep(3000);
        Assert.assertTrue(element.itemPrice.isDisplayed());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product full price must be visible")
    public void productFullPriceCheck(){
        Assert.assertTrue(element.itemFullPrice.isDisplayed());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Increased produqt quantiti and prices should increase ")
    public void QuantityIncreaseCheck(){
        steps
                .increaseQuantity();
    }


}
