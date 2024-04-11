package site.nomoreparties.stellarburgers.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {

        super(driver);
    }

    //URL страницы регистрации
    public static final String URL_REGISTER = "https://stellarburgers.nomoreparties.site/register";

    //Локаторы

    //Поле Имя
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //Поле Email
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //Поле Пароль
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    //Кнопка Зарегистрироваться
    private final By registerButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    //Текст Некорректный пароль
    private final By textIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    //Ссылка Войти
    private final By linkLogin = By.xpath(".//a[text()='Войти']");


    //Шаги
    @Step("Заполнить поля Имя,Email,Пароль")
    public RegisterPage fillOutTheRegistrationFields(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public LoginPage clickOnButtonRegister() {
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    @Step("Нажать на кнопку Зарегистрироваться, когда пароль указан не верно")
    public RegisterPage clickOnButtonRegisterWhenThePasswordIsIncorrect() {
        driver.findElement(registerButton).click();
        return this;
    }

    @Step("Проверить,что есть текст 'Некорректный пароль'")
    public boolean checkThatThereIsTheTextIncorrectPassword() {
        return driver.findElement(textIncorrectPassword).isDisplayed();
    }

    @Step("Нажать на ссылку Войти")
    public LoginPage clickOnLinkLogin() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }

}
