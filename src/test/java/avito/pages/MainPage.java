package avito.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement logo = $("[data-marker='search-form/logo']");
    private SelenideElement buttonAllCategories = $("[data-marker='top-rubricator/all-categories']");
    private SelenideElement searchByBlanks = $("[data-marker='search-form/suggest']");
    private SelenideElement buttonSearch = $("[data-marker='search-form/submit-button']");
    private ElementsCollection listDropDownSearchByBlanks = $$("[data-marker='suggest/list/custom-option']");
    private SelenideElement popupYourCity = $(".tooltip-content-ITwm0");
    private SelenideElement buttonYesInPopupYourCity = $("[data-marker='location/tooltip-leave-as-is']");
    private SelenideElement buttonChangeInPopupYourCity = $("[data-marker='location/tooltip-change']");
    private SelenideElement selectRegion = $("[data-marker='search-form/region']");
    private SelenideElement popupCityOrRegion = $("[data-marker='popup-location/content']");

    @Step("Открываем главную страницу Авито")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Нажимаем Да в автоопределении города")
    public MainPage clickYesInPopupYourCity() {
        buttonYesInPopupYourCity.shouldBe((visible), Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Нажимаем Изменить в автоопределении города")
    public MainPage clickChangeInPopupYourCity() {
        buttonChangeInPopupYourCity.shouldBe((visible), Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Отображается попап Ваш город")
    public void checkPopupYourCityDisplay() {
        popupYourCity.shouldBe((visible), Duration.ofSeconds(5));
    }

    @Step("Отображается попап Город или регион")
    public MainPage popupCityOrRegionDisplay() {
        popupCityOrRegion.shouldBe(visible);
        return this;
    }

    @Step("Не отображается попап Ваш город")
    public void checkPopupYourCityNotDisplay() {
        popupYourCity.shouldNotBe((visible), Duration.ofSeconds(5));
    }

    @Step("Не отображается попап Город или регион")
    public MainPage popupCityOrRegionNotDisplay() {
        popupCityOrRegion.shouldNotBe(visible);
        return this;
    }

    @Step("Нажать на элемент Город")
    public MainPage clickCity() {
        selectRegion.click();
        return this;
    }

    @Step("В элементе город отображается {city}")
    public void displayedCity(String city) {
        selectRegion.shouldHave(text(city));
    }

    @Step("Устанавливаем курсор в Поиск по объявлениям")
    public MainPage focusToSearchByAdvt() {
        searchByBlanks.click();
        return this;
    }

    @Step("Выбираем {vacancy} из дропдауна поиска")
    public void selectFromSearchDropdown(String vacancy) {
        listDropDownSearchByBlanks.findBy(Condition.text(vacancy)).click();
    }

    @Step("Отображается логотип Авито")
    public void logoDisplay() {
        logo.shouldBe(visible);
    }
}
