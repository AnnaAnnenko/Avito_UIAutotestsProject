package qa.annenko.web.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import qa.annenko.web.pages.MainPage;
import qa.annenko.web.pages.VacancyAdvertisеment;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForSearch {

    MainPage mainPage = new MainPage();
    VacancyAdvertisеment vacancyAdvertisеment = new VacancyAdvertisеment();

    @Test
    public void mainPageHasLogo() {
        mainPage
                .openMainPage()
                .logoDisplay();
    }

    @Test
    public void popularVacancyDisplay() {
        mainPage
                .openMainPage()
                .focusToSearchByAdvt()
                .selectFromSearchDropdown("Вакансии");
        vacancyAdvertisеment
                .popularVacancyDisplay();
    }

    @Test
    public void searchAdvertisementOfVacancy() {
        mainPage
                .openMainPage()
                .focusToSearchByAdvt()
                .selectFromSearchDropdown("Вакансии");
        vacancyAdvertisеment
                .selectVacancy("Администратор")
                .advertisementHasNameOfVacancy("Администратор");
    }

    @Test
    public void checkDefaultElementsInAllCategories() {
        mainPage.openMainPage()
                .clickButtonAllCategories();
    }
}
