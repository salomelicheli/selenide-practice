package ge.tbc.tbcacademy.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.itacademy.util.Config;
import ge.tbc.tbcacademy.util.Config;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.itacademy.data.Constants.*;
import static ge.tbc.tbcacademy.data.Constants.*;

public class SelenideTests2 extends Config {
    @Test
    public void chainedLocatorsTest() {
        open(DEMOQA);

        ElementsCollection books = $(".rt-table")
                .$$("div.rt-tr-group")
                .filterBy(text("O'Reilly Media"))
                .filterBy(text("Javascript"));
        books.forEach( el ->
        el.$x(".//img").shouldNotHave(attribute("src", ""))
        );
    }

    @Test
    public void secondTest() {
        open(DEMOQA);

        ElementsCollection books = $(".rt-table")
                .find(".rt-tbody")
                .findAll(".rt-tr-group")
                .filterBy(text("O'Reilly Media"))
                .filterBy(text("Javascript"));

        sfa.assertEquals(books.size(), 10);
        String firstRowText = books.get(0).$(".rt-td:nth-child(2)").getText();
        sfa.assertEquals(firstRowText, "Learning JavaScript Design Patterns");
    }

    @Test
    public void collectionsTest() {
        open(DEMOQA_TEXTBOX);

        SelenideElement input = $("#userName");
        input.scrollTo();
        input.sendKeys(NAME);
        $(by("type", "email")).sendKeys(EMAIL);
        $("#currentAddress").sendKeys(CURRENT_ADDRESS);
        SelenideElement addressField = $("#permanentAddress");
        addressField.sendKeys(PERMANENT_ADDRESS);
        addressField.scrollTo();
        $("#submit").click();
        $$("#output p").shouldHave(texts(NAME, EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS));
    }

    @Test
    public void testName() {
        open(CHECKBOX_LINK);

        ElementsCollection checkboxes = $("#checkboxes").$$(byTagName("input"));
        checkboxes.get(0).setSelected(true);
        checkboxes.forEach(checkbox ->checkbox.shouldHave(attribute("type", "checkbox")));
    }

    @Test
    public void dropDownTest() {
        open(DROPDOWN_TEST);

        SelenideElement dropdown = $("select#dropdown");
        dropdown.getSelectedOption().shouldHave(text("Please select an option"));
        dropdown.selectOption("Option 2");
        dropdown.getSelectedOption().shouldHave(text("Option 2"));
    }
}
