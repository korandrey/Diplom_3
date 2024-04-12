package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page.RegisterPage;
import site.nomoreparties.stellarburgers.utils.DataGeneration;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    private final DataGeneration dataGeneration = new DataGeneration();

    @Before
    public void setUp() {
        super.setUp();
        super.getDriver().get(RegisterPage.URL_REGISTER);
    }

    //Тестовые данные

    @Test
    @DisplayName("Проверка успешной авторизации пользователя")
    public void verifyingSuccessfulUserAuthorization() {
        boolean authorizationPassed = new RegisterPage(super.getDriver())
                .fillOutTheRegistrationFields(dataGeneration.getName(), dataGeneration.getEmail(), dataGeneration.getPassword())
                .clickOnButtonRegister()
                .checkThatTheLoginTageIsOpen();

        assertTrue(authorizationPassed);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя, когда пароль меньше 6 символов")
    public void checkingAuthorizationWhenThePasswordHasFewCharacters() {
        boolean authorizationNotPassed = new RegisterPage(super.getDriver())
                .fillOutTheRegistrationFields(dataGeneration.getName(), dataGeneration.getEmail(), "12345")
                .clickOnButtonRegisterWhenThePasswordIsIncorrect()
                .checkThatThereIsTheTextIncorrectPassword();

        assertTrue(authorizationNotPassed);
    }
}
