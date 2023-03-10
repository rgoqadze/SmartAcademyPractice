import PageObject.CartPage;
import StepObject.CartPageSteps;
import StepObject.SearchPageSteps;
import Utils.Retry;
import Utils.Runner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static DataObject.SearchPageData.keywordValue;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners(Utils.TestLister.class)
public class CartPageTests extends Runner {
    SearchPageSteps add = new SearchPageSteps();
    CartPageSteps steps = new CartPageSteps();
    CartPage element = new CartPage();

    @Test(retryAnalyzer = Retry.class, priority = 0)
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
    @Description("Product name must be visible, TestCase #5")
    public void productNameCheck(){
        Assert.assertTrue(element.itemTittle.isDisplayed());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product color must be visible, TestCase #6")
    public void productColorCheck(){
        Assert.assertTrue(element.itemColor.isDisplayed());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Product code must be visible, TestCase #7")
    public void productCodeCheck(){

        Assert.assertTrue(element.itemCode.isDisplayed());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product quantity must be visible, TestCase #8")
    public void productQuantityCheck(){

        Assert.assertTrue(element.itemQuantity.isDisplayed());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product price must be visible, TestCase #9")
    public void productPriceCheck(){
        Assert.assertTrue(element.itemPrice.isDisplayed());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Product full price must be visible, TestCase #10")
    public void productFullPriceCheck(){
        Assert.assertTrue(element.itemFullPrice.isDisplayed());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Increased product quantity and prices should increase, TestCase #11")
    public void quantityIncreaseCheck(){
        steps
                .increaseQuantity();
        Assert.assertEquals(Float.parseFloat(element.itemPrice.getText()) * 2, Float.parseFloat(element.itemFullPrice.getText()));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decrease product quantity and prices should increase, TestCase #12")
    public void decreaseQuantityCheck(){
        steps
                .decreaseQuantity();
        Assert.assertEquals(Float.parseFloat(element.itemFullPrice.getText()), Float.parseFloat(element.itemFullPrice.getText()));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Remove one item and Check, TestCase #13")
    public void itemRemoveCheck(){
        int itemCount = element.itemDeleteButton.size();
        steps
                .removeOneItem();
        refresh();
        Assert.assertEquals(itemCount -1,element.itemDeleteButton.size());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all item and Check, TestCase #14")
    public void allItemRemoveCheck(){
        steps
                .removeAllItem();
        Assert.assertTrue(element.emptyCart.isDisplayed());
        Assert.assertFalse(element.cartRemove.isDisplayed());
    }
    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all item and check empty art button, TestCase #15")
    public void emptyCartButtonCheck(){
        Assert.assertTrue(element.emptyCart.isDisplayed());

    }
    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all item and check empty art button, TestCase #16")
    public void continueButtonCheck(){
        Assert.assertFalse(element.continueButton.isDisplayed());
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all item and check empty art button, TestCase #17")
    public void cartRemoveButtonCheck(){
        Assert.assertFalse(element.cartRemove.isDisplayed());
    }
}
