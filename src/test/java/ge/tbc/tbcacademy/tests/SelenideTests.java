package ge.tbc.tbcacademy.tests;


import ge.tbc.tbcacademy.pages.LandingPage;
import ge.tbc.tbcacademy.pages.PricingPage;
import ge.tbc.tbcacademy.steps.CommonPageSteps;
import ge.tbc.tbcacademy.steps.LandingPageSteps;
import ge.tbc.tbcacademy.steps.PricingPageSteps;
import ge.tbc.tbcacademy.util.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.Constants.*;
import static ge.tbc.tbcacademy.data.LandingPageConstants.*;
import static ge.tbc.tbcacademy.data.PricingPageConstants.*;


public class SelenideTests extends Config {
    CommonPageSteps commonSteps;
    PricingPage pricingElements;
    PricingPageSteps pricingSteps;
    LandingPage landingPage;
    LandingPageSteps landingSteps;
    @BeforeClass
    public void beforeClass() {
        commonSteps = new CommonPageSteps();
        pricingElements = new PricingPage();
        pricingSteps = new PricingPageSteps();
        landingPage = new LandingPage();
        landingSteps = new LandingPageSteps(sfa);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        open(TELERIK_LINK);
    }

    @Test
    public void validateDemosDesign() {
        landingSteps.navigateWebSection()
                .validateOverlayEffects()
                .validateKendoUiCollection(VUE_DEMOS)
                .navigateDesktopSection()
                .validateMicrosoftItems()
                .navigateMobileSection()
                .validatingXamarinCollection(APP_STORE, GOOGLE_PLAY, MICROSOFT)
                .validateStickyBehaviour(landingPage.webLabel,
                        landingPage.desktopLabel,
                        landingPage.mobileLabel,
                        landingPage.desktopLabel,
                        landingPage.testingLabel,
                        landingPage.controversialUILabel,
                        landingPage.debuggingLabel,
                        landingPage.reportingLabel);
    }

    @Test
    public void validateBundleOffers() {
        commonSteps.clickPricingLink();
        pricingSteps.validateFeatureNotSupported(pricingElements.DevcraftUi, MOCKING_SOLUTION_FEATURE)
                .validateFeatureSupported(pricingElements.devcraftUltimate, REPORT_MANAGEMENT)
                .validateFeatureNotSupported(pricingElements.DevcraftUi, REPORT_MANAGEMENT)
                .validateFeatureNotSupported(pricingElements.DevcraftComplete, REPORT_MANAGEMENT)
                .clickDetailedComparison()
                .validateSupportedOnTable(ISSUE_ESCALATION, DEVCRAFT_ULTIMATE)
                .validateNotSupportedOnTable(ISSUE_ESCALATION, DEVCRAFT_COMPLETE)
                .validateNotSupportedOnTable(ISSUE_ESCALATION, DEVCRAFT_UI)
                .validateSupportedOnTable(DEV_EDITION, DEVCRAFT_ULTIMATE)
                .validateNotSupportedOnTable(DEV_EDITION, DEVCRAFT_COMPLETE)
                .validateNotSupportedOnTable(DEV_EDITION, DEVCRAFT_UI)
                .validateSupportedOnTable(KENDO_UI, DEVCRAFT_UI)
                .validateSupportedOnTable(KENDO_UI, DEVCRAFT_COMPLETE)
                .validateSupportedOnTable(KENDO_UI, DEVCRAFT_ULTIMATE)
                .validateSupportedOnTable(TELERIK_REPORTING, DEVCRAFT_COMPLETE)
                .validateSupportedOnTable(TELERIK_REPORTING, DEVCRAFT_ULTIMATE)
                .validateNotSupportedOnTable(TELERIK_REPORTING, DEVCRAFT_UI)
                .validateSupportedOnTable(VIDEO_ACCESS, DEVCRAFT_ULTIMATE)
                .validateSupportedOnTable(VIDEO_ACCESS, DEVCRAFT_COMPLETE)
                .validateSupportedOnTable(VIDEO_ACCESS, DEVCRAFT_UI)
                .validatingUltimateInstancesAndUsers(TELERIK_REPORT_SERVER, DEVCRAFT_ULTIMATE, USERS, INSTANCES )
                .validateStickyBehaviour();
    }

    @Test
    public void validateIndividualOffers() {
        commonSteps.clickPricingLink();
        pricingSteps.switchToIndividualProducts()
                .validateNinjaHasAppeared()
                .validateDefaultOption(DEFAULT_OPTION)
                .validateIndividualOfferPrice(KENDO_UI_OFFER, KENDO_UI_PRICE)
                .validateIndividualOfferPrice(KENDO_REACT, KENDOREACT_PRICE);
    }
}
