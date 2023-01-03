package qa.annenko.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacancyAdvertisеment {

    private SelenideElement logo = $("[data-marker='search-form/logo']");

    private SelenideElement headerPopularVacancy = $("[data-marker='popular-rubricator/controls/header']");

    private ElementsCollection listOfPopularVacancy = $$("[data-marker='popular-rubricator']");

    private ElementsCollection listOfAdvertisement = $$("[data-marker='catalog-serp']");

    @Step("Отображается логотип Авито")
    public void logoDisplay() {
        logo.shouldBe(visible);
    }

    @Step("Отображается блок Популярные вакансии")
    public void popularVacancyDisplay() {
        headerPopularVacancy.shouldHave(text("Популярные вакансии"));
    }

    @Step("Выбрать из популярных вакансий {vacancy}")
    public VacancyAdvertisеment selectVacancy(String vacancy) {
        listOfPopularVacancy.findBy(text(vacancy)).click();
        return this;
    }

    @Step("Отображаемые вакансии содержат название вакансии {vacancy}")
    public void advertisementHasNameOfVacancy(String vacancy) {
    }

}
