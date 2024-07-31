package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LandingPage {
    private static final SelenideElement SECTION_ID = $("div[id*='C329']");
    public ElementsCollection hoveringImg = $$("div[id*='C329'] .HoverImg.u-mb1");
    public ElementsCollection kendoCollectionsList = SECTION_ID.$("img[title='Kendo Ui'] + div").$$(byTagName("a"));
    public SelenideElement webSection = $("h2#web");
    public SelenideElement desktopSection = $("h2#desktop");
    public SelenideElement mobileSection = $("h2#mobile");
    public SelenideElement webLabel = $(By.linkText("Web"));
    public SelenideElement desktopLabel = $(By.linkText("Desktop"));
    public SelenideElement mobileLabel = $(By.linkText("Mobile"));
    public SelenideElement reportingLabel = $(By.linkText("Reporting"));
    public SelenideElement testingLabel = $(By.linkText("Testing & Mocking"));
    public SelenideElement debuggingLabel = $(By.linkText("Debugging"));
    public SelenideElement controversialUILabel = $(By.linkText("Conversational UI"));
    public ElementsCollection xamarinElements = $("div[id*='C340_Col01']").findAll("a img");
    public ElementsCollection microsoftItems = $$("div[id*='C337'] a img")
            .filterBy(Condition.attribute("title", "Get It from Microsoft"));
}
