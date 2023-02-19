package DataObject;

import com.github.javafaker.Faker;

public interface SearchPageData {
    Faker faker = new Faker();
    String
    keywordValue = "კლავიატურა",
    wrongKeyWordValue = faker.nation().nationality();

}
