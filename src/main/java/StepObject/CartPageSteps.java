package StepObject;
import PageObject.CartPage;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CartPageSteps extends CartPage {

    public CartPageSteps addProducts() {

        for (int i = 0; i < addCartButton.size(); i++) {
             $(".add_cart",i).click();
        }
        return this;
    }

    public CartPageSteps goToCart(){
        cartButton.click();
        return this;
    }


    public CartPageSteps increaseQuantity(){
        itemPlusButton.click();
        float increasedPrice = Float.parseFloat(itemPrice.getText()) * 2;
        float fullPriceValue = Float.parseFloat(itemFullPrice.getText());
        Assert.assertEquals(increasedPrice,fullPriceValue);
        return this;
    }
}
