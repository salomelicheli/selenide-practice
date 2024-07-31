package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.PricingPage;
import ge.tbc.tbcacademy.util.HelperMethods;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingPageSteps {
    PricingPage pricingPage = new PricingPage();

    public PricingPageSteps validateFeatureSupported(SelenideElement bundleElement, String featureName) {
        bundleElement.shouldHave(text(featureName));
        return this;
    }

    public PricingPageSteps validateFeatureNotSupported(SelenideElement bundleElement, String featureName) {
        bundleElement.shouldNotHave(text(featureName));
        return this;
    }

    public PricingPageSteps clickDetailedComparison() {
        executeJavaScript("window.scrollBy(0, 1000);");
        pricingPage.detailedComparisonBtn.shouldBe(interactable).click();
        return this;
    }

    public PricingPageSteps validateSupportedOnTable(String feature, String bundle) {
        SelenideElement cell = HelperMethods.pricingTableHandler(pricingPage.bundleOfferTable, feature, bundle);
        cell.shouldHave(innerText("●"));
        return this;
    }

    public PricingPageSteps validateNotSupportedOnTable(String feature, String bundle) {
        SelenideElement cell = HelperMethods.pricingTableHandler(pricingPage.bundleOfferTable, feature, bundle);
        cell.shouldNotHave(innerText("●"));
        return this;
    }

    public PricingPageSteps validatingUltimateInstancesAndUsers(String feature, String bundle, int users, int instances) {
        SelenideElement cell = HelperMethods.pricingTableHandler(pricingPage.bundleOfferTable, feature, bundle);
        cell.shouldHave(innerText(instances +" instance with " + users + " users"));
        return this;
    }

    public void validateStickyBehaviour() {
        executeJavaScript("window.scrollBy(1000, 2050);");

        pricingPage.completeLabel.shouldBe(visible);
        pricingPage.uiStickyLabel.shouldBe(visible);
        pricingPage.ultimateLabel.shouldBe(visible);
    }

    public PricingPageSteps switchToIndividualProducts() {
        pricingPage.individualProductsTab.click();
        return this;
    }

    public PricingPageSteps validateNinjaHasAppeared() {
        pricingPage.individualUiLabel.hover();
        pricingPage.ninjaPic.should(appear);

        return this;
    }

    public PricingPageSteps validateDefaultOption(String priorSupportText) {
        executeJavaScript("window.scrollBy(0, 350);");
        pricingPage.priorityDropdowns.forEach(dropdown -> dropdown.shouldHave(exactText(priorSupportText)));
        return this;
    }

    public PricingPageSteps validateIndividualOfferPrice(String offerName, String price) {
        pricingPage.offerPrice(offerName).shouldHave(exactText(price));

        return this;
    }
}
