package qa.annenko.web.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.annenko.web.pages.MainPage;
import qa.annenko.web.pages.VacancyBlanks;

public class TestsForSearchByVacancy extends TestBase {

    MainPage mainPage = new MainPage();
    VacancyBlanks vacancyBlanks = new VacancyBlanks();

    @Test
    public void openPageFromSearch() {
        mainPage
                .openMainPage()
                .focusToSearchByAdvt()
                .selectFromSearchDropdown("Вакансии");
        vacancyBlanks
                .logoDisplay()
                .popularVacancyDisplay();
    }

    @ValueSource(strings = {"Администратор", "Кладовщик"})
    @ParameterizedTest(name = "Проверка для значения {0}")
    public void searchAdvertisementOfPopularVacancy(String testData) {
        vacancyBlanks
                .openVacancyPage()
                .selectVacancy(testData);
        vacancyBlanks
                .advertisementHasText(testData);
    }

    @Test
    public void showVacancyOnMap() {
        vacancyBlanks
                .openVacancyPage()
                .showOnMap();
        vacancyBlanks
                .elementsOfMapDisplay();
    }
}
