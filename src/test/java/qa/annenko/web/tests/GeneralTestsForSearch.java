package qa.annenko.web.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.annenko.web.pages.MainPage;
import qa.annenko.web.pages.VacancyBlanks;

public class GeneralTestsForSearch {

    MainPage mainPage = new MainPage();
    VacancyBlanks vacancyBlanks = new VacancyBlanks();

    @Test
    public void mainPageHasLogo() {
        mainPage
                .openMainPage()
                .logoDisplay();
    }

//    @ValueSource(strings = {"Транспорт", "Недвижимость", "Работа", "Услуги", "Личные вещи", "Для дома и дачи",
//            "Запчасти и аксессуары", "Электроника", "Хобби и отдых", "Животные", "Бизнес и оборудование"})
//    @ParameterizedTest(name = "Проверка для значения {0}")
//    public void checkAllCategoriesDisplayed(String testData) {
//        mainPage
//                .openMainPage()
//                .clickButtonAllCategories();
//        mainPage
//                .categoryDisplay(testData);
//    }
}
