import DataObject.SearchPageData;
import PageObject.SearchPage;
import StepObject.SearchPageSteps;
import Utils.Runner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

import static DataObject.SearchPageData.*;

@Listeners(Utils.TestLister.class)
public class SearchPageTests extends Runner {
    SearchPage elements = new SearchPage();
    SearchPageSteps steps = new SearchPageSteps();


    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search button check")
    public void ClickSearchButton() {

    steps
            .clickSearchButton();
}
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search keyword check")
    public void checkSearch() {
        steps.KeywordSearch(keywordValue);
        Assert.assertEquals(elements.keywordValueCheck.getText().replace("'",""), SearchPageData.keywordValue);

    }

    @Test(priority = 2)
    public void addProductToCart() {
        steps
                .addCardAndCheck();
        elements.addCartText.shouldBe(Condition.visible, Duration.ofMillis(3000));
        Assert.assertTrue(elements.addCartText.isDisplayed());

    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Wrong keyword search check")
    public void checkSearchNegative() {
        steps
                .clickSearchButton()
                .checkKeywordSearchNegative(wrongKeyWordValue);
        Assert.assertTrue(elements.emptyResult.isDisplayed());
    }
}
