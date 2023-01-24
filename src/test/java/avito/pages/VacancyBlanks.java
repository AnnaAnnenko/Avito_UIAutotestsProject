package avito.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VacancyBlanks {

    private SelenideElement logo = $("[data-marker='search-form/logo']");
    private SelenideElement headerPopularVacancy = $("[data-marker='popular-rubricator/controls/header']");
    private ElementsCollection popularVacancylist = $$("[data-marker='popular-rubricator/link']");
    private ElementsCollection blankslist = $$("[data-marker='item-title']");
    private SelenideElement buttonShowOnMap = $("[data-marker='map-banner-button']");
    private SelenideElement buttonDrawOnMap = $("[data-marker='map/draw-button']");
    private SelenideElement buttonCloseMap = $("[data-marker='map-back-button']");
    private SelenideElement buttonZoomInMap = $("[data-marker='map-zoom-button_in']");
    private SelenideElement buttonZoomOutMap = $("[data-marker='map-zoom-button_out']");
    private SelenideElement buttonMyGeolocation = $("[data-marker='map-my-geolocation']");

    @Step("Отображается логотип Авито")
    public VacancyBlanks logoDisplay() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Отображается блок Популярные вакансии")
    public void popularVacancyDisplay() {
        headerPopularVacancy.shouldHave(text("Популярные вакансии"));
    }

    @Step("Выбрать из популярных вакансий {vacancy}")
    public VacancyBlanks selectVacancy(String vacancy) {
        popularVacancylist.findBy(text(vacancy)).click();
        return this;
    }

    @Step("Отображаемые объявления содержат текст {textInBlank}")
    public void advertisementHasText(String textInBlank) {
        for (SelenideElement advertisement : blankslist) {
            advertisement.shouldHave(text(textInBlank));
        }
    }

    @Step("Отображаются элементы карты")
    public void elementsOfMapDisplay() {
        buttonCloseMap.shouldBe(visible);
        buttonDrawOnMap.shouldBe(visible);
        buttonZoomInMap.shouldBe(visible);
        buttonZoomOutMap.shouldBe(visible);
        buttonMyGeolocation.shouldBe(visible);
    }

    @Step("Нажать кнопку Показать на карте")
    public VacancyBlanks showOnMap() {
        buttonShowOnMap.click();
        return this;
    }
}
