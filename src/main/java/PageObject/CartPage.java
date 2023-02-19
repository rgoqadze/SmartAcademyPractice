package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    public SelenideElement
        cartButton = $(byClassName("cart_info")),
        itemTittle = $(".item_title",0),
        itemColor = $(".item_head",1),
        itemCode = $(".item_id", 0),
        itemQuantity = $(byAttribute("name", "quantity"),0),
        itemPrice = $(By.xpath("//div[@class='prod_price']/span"),0),
        itemFullPrice = $(".fullPriceFor",0),
        itemPlusButton = $(".fa-plus",0),
        itemMinusButton =$(byAttribute("type","button"),1),
        itemDeleteButton = $(byAttribute("oncklick","removeProductFromCart(148150)"),0),
        cartRemove = $(".remove_carts"),
        emptyCart = $(".emptyCart");
     public ElementsCollection
        addCartButton = $$(".add_cart");

}