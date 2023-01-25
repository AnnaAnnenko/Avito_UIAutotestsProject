package avito.tests;

import avito.pages.MainPage;
import avito.pages.VacancyBlanks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SearchByVacancyTests extends TestBase {

    MainPage mainPage = new MainPage();
    VacancyBlanks vacancyBlanks = new VacancyBlanks();

    @Test
    public void openPageFromSearch() {
        mainPage.openPage().focusToSearchByAdvt().selectFromSearchDropdown("Вакансии");
        vacancyBlanks.logoDisplay()
                .popularVacancyDisplay();
    }

    @ValueSource(strings = {"Администратор", "Кладовщик"})
    @ParameterizedTest(name = "Проверка для значения {0}")
    public void searchAdvertisementOfPopularVacancy(String testData) {
        mainPage.openPage().focusToSearchByAdvt().selectFromSearchDropdown("Вакансии");
        vacancyBlanks.selectVacancy(testData);
        vacancyBlanks.advertisementHasText(testData);
    }

    @Test
    public void showVacancyOnMap() {
        mainPage.openPage().focusToSearchByAdvt().selectFromSearchDropdown("Вакансии");
        vacancyBlanks.showOnMap();
        vacancyBlanks.elementsOfMapDisplay();
    }
}
