package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class PricingPage {
    private static final SelenideElement priceSupport = $("tr.Pricings-info");
    private static final SelenideElement individualLabels = $("div[id*='C713']");
    public SelenideElement DevcraftUi = priceSupport.$("th.UI");
    public SelenideElement DevcraftComplete = priceSupport.$("th.Complete");
    public SelenideElement devcraftUltimate = priceSupport.$("th.Ultimate");
    public SelenideElement bundleOfferTable = $("table.PricingTable");
    public SelenideElement detailedComparisonBtn = $("button[class*='show-details']");
    public SelenideElement uiStickyLabel = $("div.UI");
    public SelenideElement completeLabel = $("div.Complete");
    public SelenideElement ultimateLabel = $("div.Ultimate");
    public SelenideElement individualProductsTab = $(byTagAndText("span", "Individual Products"));
    public SelenideElement ninjaPic = $(byTitle("Kendo Ui Ninja"));
    public SelenideElement individualUiLabel = $(byTagAndText("h3", "Kendo UI"));
    public ElementsCollection priorityDropdowns = individualLabels.$$("a[class*='Dropdown-control']");
    public SelenideElement offerPrice(String offerName) {
        return individualLabels.$("div[data-opti-expid='" +offerName + "'] span.js-price");
    }

}
