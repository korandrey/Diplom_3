package site.nomoreparties.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.api.User;
import site.nomoreparties.stellarburgers.api.UserActions;
import site.nomoreparties.stellarburgers.page.LoginPage;
import site.nomoreparties.stellarburgers.utils.DataGeneration;

import static org.junit.Assert.assertTrue;

public class PersonalAreaTest {
    protected WebDriver driver;

    private UserActions userActions;
    private User user;
    private String token;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        userActions = new UserActions();
        user = DataGeneration.generatingDataToCreateValidUser();
        driver.get(LoginPage.URL_LOGIN);

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
        // Закрытие браузера
        driver.quit();
        userActions.delete(token).statusCode(202);
    }

    //Тестовые данные

    @Test
    @DisplayName("Переход с главной страницы по клику на «Личный кабинет»")
    public void GoFromTheMainPageByClickingOnPersonalAccount() {
        boolean goToYourPersonalAccount = new LoginPage(driver)
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .pressTheButtonPersonalAreaAuth()
                .checkThatTheProfilePageIsOpen();
        assertTrue(goToYourPersonalAccount);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void transitionFromYourPersonalAccountToTheDesigner() {
        boolean goToConstructor = new LoginPage(driver)
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .pressTheButtonPersonalAreaAuth()
                .clickOnTheConstructorLink()
                .checkThatTheBurgerDesignerIsDisplayed();
        assertTrue(goToConstructor);
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через логотип Stellar Burgers")
    public void transitionFromYourPersonalAccountToTheMainPageThroughTheStellarBurgersLogo() {
        boolean goToMainPage = new LoginPage(driver)
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .pressTheButtonPersonalAreaAuth()
                .clickOnTheStellarBurgersLogo()
                .CheckThatTheMainPageIsOpenFromAnAuthorizedUser();
        assertTrue(goToMainPage);
    }

    @Test
    @DisplayName("Выход из личного кабинета по кнопке «Выйти»")
    public void logOutOfYourPersonalAccount() {
        boolean logOut = new LoginPage(driver)
                .fillOutTheLoginFields(user.getEmail(), user.getPassword())
                .clickOnButtonLogin()
                .pressTheButtonPersonalAreaAuth()
                .clickOnTheExitButton()
                .checkThatTheLoginTageIsOpen();
        assertTrue(logOut);
    }
}
