package pageObjects.rw;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final ElementsCollection routeElement = $$("[class='sch-table__route']");
    private final ElementsCollection travelTimeElement = $$("[class='sch-table__duration train-duration-time']");
    private final ElementsCollection departureTimeElement = $$("[class='sch-table__time train-from-time']");
    private final SelenideElement errorMassageElement = $("[class='error_content']");

    public Map<String, String> parseSearchResults(String route) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("Маршрут", routeElement.find(text(route)).getText());
        resultMap.put("Время в пути", travelTimeElement.findBy(visible).getText());
        resultMap.put("Время отправления", departureTimeElement.findBy(visible).getText());
        return resultMap;
    }

    public SearchPage map(String route) {
        for (Map.Entry<String, String> entry : parseSearchResults(route).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("___________________________________");
        return this;
    }

    public SearchPage error() {
        errorMassageElement.should(visible);
        return this;
    }
}
