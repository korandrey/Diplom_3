package site.nomoreparties.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    protected WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(MainPage.URL_MAIN);
    }

    @After
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    @Test
    @DisplayName("Проверка активного раздела Булки в конструкторе бургеров")
    public void checkingTheActiveSectionBun() {
        boolean bunSection = new MainPage(driver)
                .clickOnTheFillingsItem()
                .clickOnTheBunItem()
                .theActiveSectionBunIsDisplayed();
        assertTrue(bunSection);
    }

    @Test
    @DisplayName("Проверка активного раздела Начинки в конструкторе бургеров")
    public void checkingTheActiveSectionFillings() {
        boolean bunSection = new MainPage(driver)
                .clickOnTheFillingsItem()
                .theActiveSectionFillingsIsDisplayed();
        assertTrue(bunSection);
    }

    @Test
    @DisplayName("Проверка активного раздела Соусы в конструкторе бургеров")
    public void checkingTheActiveSectionSouses() {
        boolean bunSection = new MainPage(driver)
                .clickOnTheSousesItem()
                .theActiveSectionSousesIsDisplayed();
        assertTrue(bunSection);
    }
}
