package site.nomoreparties.stellarburgers.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //URL главной страницы
    public static final String URL_MAIN = "https://stellarburgers.nomoreparties.site/";

    //Локаторы
    //Кнопка Войти в аккаунт
    private final By btnLogin = By.xpath(".//button[text()='Войти в аккаунт']");

    //Главная страница
    private final By pageMain = By.xpath(".//main[@class='App_componentContainer__2JC2W']");

    //Ссылка Личный кабинет
    private final By linkPersonalArea = By.xpath(".//p[text()='Личный Кабинет']");
    //Секция Собери бургер
    private final By burgerConstructor = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']");
    //Активный раздел Булки в конструкторе
    private final By activeSectionOfTheBun = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Булки']");
    //Активный раздел Соусы в конструкторе
    private final By activeSectionSouses = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Соусы']");
    //Активный раздел Начинки в конструкторе
    private final By activeSectionFillings = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Начинки']");
    //Раздел Булки в конструкторе
    private final By sectionOfTheBun = By.xpath(".//span[text()='Булки']");
    //Раздел Соусы в конструкторе
    private final By sectionSouses = By.xpath(".//span[text()='Соусы']");
    //Раздел Начинки в конструкторе
    private final By sectionFillings = By.xpath(".//span[text()='Начинки']");

    @Step("Кликнуть на кнопку Войти")
    public LoginPage pressTheButtonLogin() {
        driver.findElement(btnLogin).click();
        return new LoginPage(driver);
    }

    @Step("Проверить,что открыта главная страница от авторизованного пользователя")
    public boolean CheckThatTheMainPageIsOpenFromAnAuthorizedUser() {
        return driver.findElements(btnLogin).size() == 0 && driver.findElement(pageMain).isDisplayed();
    }

    @Step("Кликнуть на ссылку Личный кабинет,если пользователь не авторизован")
    public LoginPage pressTheButtonPersonalArea() {
        driver.findElement(linkPersonalArea).click();
        return new LoginPage(driver);
    }

    @Step("Кликнуть на ссылку Личный кабинет,если пользователь авторизован")
    public AccountPage pressTheButtonPersonalAreaAuth() {
        driver.findElement(linkPersonalArea).click();
        return new AccountPage(driver);
    }

    @Step("Проверить,что отображается конструктор бургеров 'Соберите бургер'")
    public boolean checkThatTheBurgerDesignerIsDisplayed() {
        return driver.findElement(burgerConstructor).isDisplayed();
    }

    @Step("Проверить,что отображается активный раздел Булки в конструкторе бургеров")
    public boolean theActiveSectionBunIsDisplayed() {
        return driver.findElement(activeSectionOfTheBun).isDisplayed();
    }

    @Step("Проверить,что отображается активный раздел Соусы в конструкторе бургеров")
    public boolean theActiveSectionSousesIsDisplayed() {
        return driver.findElement(activeSectionSouses).isDisplayed();
    }

    @Step("Проверить,что отображается активный раздел Начинки в конструкторе бургеров")
    public boolean theActiveSectionFillingsIsDisplayed() {
        return driver.findElement(activeSectionFillings).isDisplayed();
    }

    @Step("Кликнуть на раздел конструктора Булки")
    public MainPage clickOnTheBunItem() {
        driver.findElement(sectionOfTheBun).click();
        return this;
    }

    @Step("Кликнуть на раздел конструктора Соусы")
    public MainPage clickOnTheSousesItem() {
        driver.findElement(sectionSouses).click();
        return this;
    }

    @Step("Кликнуть на раздел конструктора Начинки")
    public MainPage clickOnTheFillingsItem() {
        driver.findElement(sectionFillings).click();
        return this;
    }
}
