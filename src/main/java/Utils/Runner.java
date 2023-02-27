package Utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.open;

public class Runner {
    @BeforeTest
    public static void setupOfficeMart() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        open("https://officemart.ge");
    }
}
