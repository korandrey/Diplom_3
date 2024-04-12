package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.api.User;
import site.nomoreparties.stellarburgers.api.UserActions;
import site.nomoreparties.stellarburgers.page.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.page.MainPage;
import site.nomoreparties.stellarburgers.page.RegisterPage;
import site.nomoreparties.stellarburgers.utils.DataGeneration;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private UserActions userActions;
    private User user;
    private String token;

    @Before
    public void setUp() {
        super.setUp();
        userActions = new UserActions();
        user = DataGeneration.generatingDataToCreateValidUser();
        //Создаем через API юзера и запоминаем токен
        ValidatableResponse response = userActions.create(user);
        response.assertThat().statusCode(200);
        token = response.extract().path("accessToken");
        StringBuilder sb = new StringBuilder(token);
        sb.delete(0, 7);
        token = sb.toString();
    }

    @After
    public void tearDown() {
        super.tearDown();
        userActions.delete(token).statusCode(202);
    }

    //Тестовые данные

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void LoginUsingTheLogInToYourAccountButtonOnTheMainPage() {
        super.getDriver().get(MainPage.URL_MAIN);
        boolean login = new MainPage(super.getDriver())
                .pressTheButtonLogin()
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .CheckThatTheMainPageIsOpenFromAnAuthorizedUser();
        assertTrue(login);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginThroughThePersonalAccountButton() {
        super.getDriver().get(MainPage.URL_MAIN);
        boolean login = new MainPage(super.getDriver())
                .pressTheButtonPersonalArea()
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .CheckThatTheMainPageIsOpenFromAnAuthorizedUser();
        assertTrue(login);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void LoginViaTheButtonInTheRegistrationForm() {
        super.getDriver().get(RegisterPage.URL_REGISTER);
        boolean login = new RegisterPage(super.getDriver())
                .clickOnLinkLogin()
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .CheckThatTheMainPageIsOpenFromAnAuthorizedUser();
        assertTrue(login);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void LoginViaTheButtonInThePasswordRecoveryForm() {
        super.getDriver().get(ForgotPasswordPage.URL_FORGOT);
        boolean login = new ForgotPasswordPage(super.getDriver())
                .pressTheLinkLogin()
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .CheckThatTheMainPageIsOpenFromAnAuthorizedUser();
        assertTrue(login);
    }
}

