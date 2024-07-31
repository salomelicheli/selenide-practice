package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class CommonPage {
    public SelenideElement pricingLink = $$("a[class*='Menu-Item-Link']").findBy(text("Pricing"));
}
