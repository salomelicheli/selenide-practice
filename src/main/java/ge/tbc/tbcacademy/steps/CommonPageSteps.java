package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.CommonPage;

public class CommonPageSteps {
    CommonPage commonPage = new CommonPage();

    public void clickPricingLink() {
        commonPage.pricingLink.click();
    }
}
