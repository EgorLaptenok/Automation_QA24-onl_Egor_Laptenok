package pageObjects.rabotaBy;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import pageObjects.baseObjects.BaseTestSelenide;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class SearchPage extends BaseTestSelenide {
    private final SelenideElement catalogHeader = $("h1[data-qa]");
    private final SelenideElement vacanciesHeader = $("span.bloko-header-section-3 span");

    public SearchPage outputSearch(String catalog) {
        Assert.assertEquals(catalogHeader.getText(), catalog, "wrong massage");
        return this;
    }

    public SearchPage outputVacancies(String secondCount) {
        String vacancies = vacanciesHeader.getText();
        int numberOfVacancies = Stream.of(vacancies)
                .map(s -> s.replaceAll("\\D+", ""))
                .mapToInt(Integer::parseInt)
                .findFirst()
                .orElse(0);
        int count = Integer.parseInt(secondCount);
        boolean results = numberOfVacancies >= count;
        Assert.assertTrue(results, "Wrong vacancies");
        return this;
    }
}
