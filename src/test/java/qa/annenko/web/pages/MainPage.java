package qa.annenko.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement logo = $("[data-marker='search-form/logo']");

    private SelenideElement buttonAllCategories = $("[data-marker='top-rubricator/all-categories']");

    private SelenideElement searchByBlanks = $("[data-marker='search-form/suggest']");

    private SelenideElement buttonSearch = $("[data-marker='search-form/submit-button']");

    private ElementsCollection listDropDownSearchByBlanks = $$("[data-marker='suggest/list/custom-option']");

    private ElementsCollection listAllCategories = $$("[data-marker^='top-rubricator/root-category-']");

    private SelenideElement popupYourCity = $(".tooltip-content-ITwm0");

    private SelenideElement buttonYesInPopupYourCity = $("[data-marker='location/tooltip-agree']");

    private SelenideElement buttonChangeInPopupYourCity = $("[data-marker='location/tooltip-change']");
    private SelenideElement selectRegion = $("[data-marker='search-form/region']");

    @Step("Нажимаем Да в автоопределении города")
    public MainPage clickYesInPopupYourCity() {
        buttonYesInPopupYourCity.click();
        return this;
    }

    @Step("Открываем главную страницу Авито")
    public MainPage openMainPage() {
        open("https://www.avito.ru/");
        return this;
    }

    @Step("Нажимаем кнопку Все категории")
    public MainPage clickButtonAllCategories() {
        buttonAllCategories.click();
        return this;
    }

    @Step("Устанавливаем курсор в Поиск по объявлениям")
    public MainPage focusToSearchByAdvt() {
        searchByBlanks.click();

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public void clickButtonSearch() {
        buttonSearch.click();
    }

    @Step("Выбираем {vacancy} из дропдауна поиска")
    public void selectFromSearchDropdown(String vacancy) {
        listDropDownSearchByBlanks.findBy(Condition.text(vacancy)).click();
    }

    @Step("Отображается логотип Авито")
    public void logoDisplay() {
        logo.shouldBe(visible);
        sleep(10000000);
    }

//    @Step("Проверяем, что отображается категория с именем")
//    public void categoryDisplay(String nameOfCategory) {
//        for (SelenideElement category : listAllCategories) {
//            category.shouldHave(text(nameOfCategory));
//        }
//    }


}
