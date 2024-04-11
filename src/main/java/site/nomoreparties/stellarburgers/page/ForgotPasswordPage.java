package site.nomoreparties.stellarburgers.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    //URL страницы восстановления пароля
    public static final String URL_FORGOT = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Локаторы

    //Ссылка Войти
    private final By linkLogin = By.xpath(".//a[text()='Войти']");

    @Step("Кликнуть на ссылку Войти")
    public LoginPage pressTheLinkLogin() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }
}
