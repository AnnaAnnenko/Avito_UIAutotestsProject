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

    private SelenideElement searchByAdvt = $("[data-marker='search-form/suggest']");

    private SelenideElement buttonSearch = $("[data-marker='search-form/submit-button']");

    private ElementsCollection listDropDownSearchByAdvt = $$("[data-marker='suggest/list/custom-option']");

    private ElementsCollection listAllCategories = $$(".new-rubricator-content-leftcontent-my5E0");

    public static void checkVisibleElementByText(String elementText) {
        $(byText(elementText)).shouldBe(visible);
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
        searchByAdvt.click();

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public void clickButtonSearch() {
        buttonSearch.click();
    }

    @Step("Выбираем {vacancy} из дропдауна поиска")
    public void selectFromSearchDropdown(String vacancy) {
        listDropDownSearchByAdvt.findBy(Condition.text(vacancy)).click();
    }

    @Step("Отображается логотип Авито")
    public void logoDisplay() {
        logo.shouldBe(visible);
    }

    @Step("Проверяем, что все элементы отображаются")
    public void allElementsDisplayed(List<String> textList) {
        textList.forEach(MainPage:: checkVisibleElementByText);
    }
}
