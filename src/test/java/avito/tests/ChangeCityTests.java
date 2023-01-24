package avito.tests;

import avito.pages.PopupChangeCity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import avito.pages.MainPage;

public class ChangeCityTests extends TestBase {

    MainPage mainPage = new MainPage();
    PopupChangeCity popupChangeCity = new PopupChangeCity();

    @Test
    public void popupYourCityDisplay() {
        mainPage.openPage().checkPopupYourCityDisplay();
    }

    @Test
    public void selectConfirmYourCity() {
        mainPage.openPage().clickYesInPopupYourCity();
        mainPage.popupCityOrRegionNotDisplay().checkPopupYourCityNotDisplay();
    }

    @Test
    public void selectChangeYourCity() {
        mainPage.openPage().clickChangeInPopupYourCity();
        mainPage.popupCityOrRegionDisplay();
    }

    @ValueSource(strings = {"Москва", "Оренбург"})
    @ParameterizedTest(name = "Проверка для значения {0}")
    public void changeCity(String testData) {
        mainPage.openPage().clickCity();
        popupChangeCity.inputCity(testData).clickShowBlanksFromCity();
        mainPage.displayedCity(testData);
    }
}
