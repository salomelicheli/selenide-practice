package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.LandingPage;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();
    private SoftAssert sfa;
    public LandingPageSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    public LandingPageSteps navigateWebSection() {
        landingPage.webLabel.click();
        landingPage.webSection.should(appear);

        return this;
    }

    public LandingPageSteps validateOverlayEffects() {
        landingPage.hoveringImg.forEach(img -> img.hover()
                .shouldHave(Condition.cssValue("background-color", "rgba(40, 46, 137, 0.75)")));
        return this;
    }

    public LandingPageSteps validateKendoUiCollection(String unit) {
        sfa.assertTrue(landingPage.kendoCollectionsList.texts().contains(unit));
        return this;
    }

    public LandingPageSteps navigateDesktopSection() {
        landingPage.desktopLabel.click();
        landingPage.desktopSection.should(appear);

        return this;
    }

    public LandingPageSteps validateMicrosoftItems() {
        landingPage.microsoftItems.shouldHave(size(2));
        return this;
    }

    public LandingPageSteps navigateMobileSection() {
        landingPage.mobileLabel.click();
        landingPage.mobileSection.should(appear);

        return this;
    }

    public LandingPageSteps validatingXamarinCollection(String appStore, String googlePlay, String microsoft){
        landingPage.xamarinElements.shouldHave(CollectionCondition.attributes("title",
                appStore,
                googlePlay,
                microsoft));
        return this;
    }

    public void validateStickyBehaviour(SelenideElement... elements) {
        executeJavaScript("window.scrollBy(1000, 2050);");

        for(SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }
}
