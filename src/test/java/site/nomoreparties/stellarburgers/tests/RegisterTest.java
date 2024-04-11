package site.nomoreparties.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.page.RegisterPage;
import site.nomoreparties.stellarburgers.utils.DataGeneration;

import static org.junit.Assert.assertTrue;

public class RegisterTest {

    protected WebDriver driver;
    private final DataGeneration dataGeneration = new DataGeneration();

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(RegisterPage.URL_REGISTER);
    }

    @After
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    //Тестовые данные

    @Test
    @DisplayName("Проверка успешной авторизации пользователя")
    public void verifyingSuccessfulUserAuthorization() {
        boolean authorizationPassed = new RegisterPage(driver)
                .fillOutTheRegistrationFields(dataGeneration.getName(), dataGeneration.getEmail(), dataGeneration.getPassword())
                .clickOnButtonRegister()
                .checkThatTheLoginTageIsOpen();

        assertTrue(authorizationPassed);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя, когда пароль меньше 6 символов")
    public void checkingAuthorizationWhenThePasswordHasFewCharacters() {
        boolean authorizationNotPassed = new RegisterPage(driver)
                .fillOutTheRegistrationFields(dataGeneration.getName(), dataGeneration.getEmail(), "12345")
                .clickOnButtonRegisterWhenThePasswordIsIncorrect()
                .checkThatThereIsTheTextIncorrectPassword();

        assertTrue(authorizationNotPassed);
    }
}
