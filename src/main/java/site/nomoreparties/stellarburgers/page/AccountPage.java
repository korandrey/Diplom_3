package site.nomoreparties.stellarburgers.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    //Локаторы

    //Страница профиля
    private final By pageProfile = By.xpath(".//main[@class='App_componentContainer__2JC2W']");
    private final By linkConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By logoStellarBurgers = By.xpath("(.//a[@href='/'])[2]");
    //Кнопка Выход
    private final By exitBtn = By.xpath(".//button[contains(text(),'Выход')]");

    @Step("Проверить,что открыта страница профиля")
    public boolean checkThatTheProfilePageIsOpen() {
        return driver.findElement(pageProfile).isDisplayed();
    }

    @Step("Кликнуть на ссылку Конструктор")
    public MainPage clickOnTheConstructorLink() {
        driver.findElement(linkConstructor).click();
        return new MainPage(driver);
    }

    @Step("Кликнуть на логотип Stellar Burgers")
    public MainPage clickOnTheStellarBurgersLogo() {
        driver.findElement(logoStellarBurgers).click();
        return new MainPage(driver);
    }

    @Step("Кликнуть на кнопку Выход")
    public LoginPage clickOnTheExitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitBtn));
        driver.findElement(exitBtn).click();
        return new LoginPage(driver);
    }
}
