package StepObject;
import DataObject.SearchPageData;
import PageObject.SearchPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.sleep;

import org.testng.Assert;

import static java.lang.Thread.sleep;


public class SearchPageSteps extends SearchPage {


    @Step("Click on search Button")
    public SearchPageSteps clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Check keyword search")
    public SearchPageSteps KeywordSearch(String keywordValue) {
        searchInput.setValue(SearchPageData.keywordValue).pressEnter();
        Assert.assertEquals(keywordValueCheck.getText().replace("'",""), SearchPageData.keywordValue);
        return this;
    }

    @Step("Write keyword and search")
    public SearchPageSteps checkKeywordSearchNegative(String wrongKeyWordValue) {
        searchInput.setValue(wrongKeyWordValue).pressEnter();
        return this;
    }

    

    @Step("ADD product to card and check message")
    public SearchPageSteps addCardAndCheck() {
        addCartButton.click();
        return this;
    }
}
