package StepObject;
import PageObject.CartPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CartPageSteps extends CartPage {

    @Step("Add products to cart")
    public CartPageSteps addProducts() {

        for (int i = 0; i < addCartButton.size(); i++) {
             $(".add_cart",i).click();
        }
        return this;
    }

    @Step("Go to cart")
    public CartPageSteps goToCart(){
        cartButton.click();
        return this;
    }

    @Step("Icrease product quantity")
    public CartPageSteps increaseQuantity(){
        itemPlusButton.click();
        return this;
    }

    @Step("Decrease increased quantity")
    public CartPageSteps decreaseQuantity() {
        itemMinusButton.click();
        return this;
    }

    @Step("Remove one item in cart")
    public CartPageSteps removeOneItem(){
        itemDeleteButton.get(0).click();
        return this;
    }

    @Step("Remove all products")
    public CartPageSteps removeAllItem() {
        cartRemove.click();
        return this;
    }
}
