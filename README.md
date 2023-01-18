#  Проект автоматизации тестирования Web-сайта Avito

<p align="center">
  <img width="" title="Jenkins" src="images/logo/Avito_logo.png">
</p>

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованныe проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)


## :technologist: Технологии и инструменты
<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>

</p>

## :bookmark_tabs: Реализованные проверки:

- Поиск по популярным вакансиям, отображение в соответствии с запросом поиска
- Просмотр вакансий на карте
- Отображение списка популярных вакансий в соответствующем разделе
- Проверка отображения попапа "Это ваш город?" при первом открытии сайта
- Проверка поведения при подтверждении города в попапе
- Проверка поведения при изменении города в попапе
- Изменение города на определенное значение, проверка сохранения

## :computer: Запуск тестов из терминала

### Удаленный запуск тестов

 Для запуска удаленных тестов необходимо заполнить remote.properties или передать значение:

* baseUrl (default = https://www.avito.ru)
* browser (default = chrome)
* browserVersion (default = 100)
* remoteUrl (url address from selenoid, e.g. https://{user}:{login}@selenoid.autotests.cloud/wd/hub)

Запускайте тесты с незаполненным remote.properties:
```bash
clean test -DremoteUrl=https://${user}:${login}@${selenoid.autotests.cloud}/wd/hub/
```

Запускайте тесты с заполненным remote.properties:
```bash
gradle clean test 
-Denvironment=remote
```

### Локальный запуск тестов

```bash
gradle clean test
-Denvironment=local
```

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/15_Avito_UIAutotestsProject_Abramova/)

Для запуска сборки необходимо нажать кнопку <code><strong>*Собрать с параметрами*</strong></code> и передать необходимые параметры сборки.


```
clean test -DremoteUrl=https://${LOGIN}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
```

<p align="center">
  <img src="images/screen/JenkinsUI1.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки отобразятся
иконки *Allure Report* и *Allure TestOPS*, которые по клику открывают страницы соответствующих отчетов.

<p align="center">
  <img src="images/screen/JenkinsUI2.png" alt="Jenkins" width="800">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/15_Avito_UIAutotestsProject_Abramova/6/allure/)

<p align="center">
  <img src="images/screen/allureUI2.png" alt="allure-report1" width="900">
</p>

<p align="center">
  <img src="images/screen/allureUI.png" alt="allure-report1" width="900">
</p>


## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/18506)

### Основной дашборд

<p align="center">
  <img src="images/screen/testOpsUI1.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="images/screen/testopsUI2.png" alt="dashboard" width="900">
</p>

### Список тест-кейсов, сформированных в результате прогона

<p align="center">
  <img src="images/screen/TestOpsUI3.png" alt="dashboard" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="images/screen/TelegramUI.png">

