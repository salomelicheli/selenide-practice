package ge.tbc.tbcacademy.data.util;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;

public class HelperMethods {
    public static SelenideElement pricingTableHandler(SelenideElement table, String feature, String bundle) {
        SelenideElement tableBody = table.$("tbody.track--pricing-body");
        SelenideElement header = table.$("thead.track--pricing-head").$("tr.Pricings-name");
        ElementsCollection tableRows = tableBody.$$(byTagName("tr"));
        int rowIndex = 1;
        for (; rowIndex < tableRows.size(); rowIndex++) {
            SelenideElement rowName = tableRows.get(rowIndex - 1).$x(".//td[1]");
            if (rowName.innerText().contains(feature)) {
                break;
            }
        }
        ElementsCollection tableHeaders = header.$$(byTagName("th"));
        int headerIndex = 1;
        for (; headerIndex < tableHeaders.size(); headerIndex++) {
            if (tableHeaders.get(headerIndex - 1).innerText().contains(bundle)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        String xPath = sb.append(".//tr[").append(rowIndex).append("]/td[").append(headerIndex).append("]").toString();
        return tableBody.$x(xPath);
    }
}