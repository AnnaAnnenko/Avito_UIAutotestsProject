package qa.annenko.web.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.annenko.web.pages.MainPage;
import qa.annenko.web.pages.PopupChangeCity;

public class TestsForChangeCity  extends TestBase {

    MainPage mainPage = new MainPage();
    PopupChangeCity popupChangeCity = new PopupChangeCity();

    @Test
    public void popupYourCityDisplay() {
        mainPage
                .openMainPage()
                .checkPopupYourCityDisplay();
    }

    @Test
    public void selectConfirmYourCity() {
        mainPage
                .openMainPage()
                .clickYesInPopupYourCity();
        mainPage
                .popupCityOrRegionNotDisplay()
                .checkPopupYourCityNotDisplay();
    }

    @Test
    public void selectChangeYourCity() {
        mainPage
                .openMainPage()
                .clickChangeInPopupYourCity();
        mainPage
                .popupCityOrRegionDisplay();
    }

    @ValueSource(strings = {"Москва"})
    @ParameterizedTest(name = "Проверка для значения {0}")
    public void changeCity(String testData) {
        mainPage
                .openMainPage()
                .clickCity();
        popupChangeCity
                .inputCity(testData)
                .clickShowBlanksFromCity();
        mainPage
                .displayedCity(testData);
    }
}
