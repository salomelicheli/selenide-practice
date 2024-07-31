package ge.tbc.tbcacademy.util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class Config {
    protected SoftAssert sfa;
    @BeforeClass(alwaysRun = true)
    public void AbeforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        sfa = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Selenide.closeWebDriver();
        sfa.assertAll();
    }
}
