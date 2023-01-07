package qa.annenko.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PopupChangeCity {

    private SelenideElement inputCityOrRegion = $("[data-marker='popup-location/region/input']");
    private SelenideElement buttonShowBlanks = $("[data-marker='popup-location/save-button']");
    private SelenideElement firstElementFromListCity = $("[data-marker='suggest(0)']");

    @Step("Установить город {city}")
    public PopupChangeCity inputCity(String city) {
        inputCityOrRegion.setValue(city);
        firstElementFromListCity.click();
        return this;
    }

    @Step("Нажать кнопку Показать X тыс. объявлений в попапе выбора города")
    public void clickShowBlanksFromCity() {
        buttonShowBlanks.click();
    }
}
