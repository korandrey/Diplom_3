package site.nomoreparties.stellarburgers.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //URL страницы регистрации
    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    //Локаторы

    //Поле Email
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");

    //Поле Пароль
    private final By passwordField = By.xpath(".//input[@name='Пароль']");

    //Страница авторизации
    private final By pageLogin = By.xpath(".//div[@class='Auth_login__3hAey']");

    //Кнопка Войти
    private final By loginButton = By.xpath(".//button[contains(text(),'Войти')]");


    //Шаги
    @Step("Проверить,Что открыта страница Вход")
    public boolean checkThatTheLoginTageIsOpen() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageLogin));
        return driver.findElement(pageLogin).isDisplayed();
    }

    @Step("Заполнить поля Email,Пароль")
    public LoginPage fillOutTheLoginFields(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public MainPage clickOnButtonLogin() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

}
