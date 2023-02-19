package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public SelenideElement
            searchButton = $(".search"),
            searchInput = $(byAttribute("name","search")),
            keywordValueCheck = $(byClassName("color_text")),
            emptyResult = $(byText("ვერაფერი მოიძებნა")),
            addCartButton =  $(byClassName("add_cart"),0),
            addCartText = $(byText("პროდუქტი წარმატებით დაემატა კალათაში"));

}
