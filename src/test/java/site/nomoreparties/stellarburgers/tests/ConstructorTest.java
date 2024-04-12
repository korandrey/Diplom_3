package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest{

    @Before
    public void setUp() {
        super.setUp();
        super.getDriver().get(MainPage.URL_MAIN);
    }

    @Test
    @DisplayName("Проверка активного раздела Булки в конструкторе бургеров")
    public void checkingTheActiveSectionBun() {
        boolean bunSection = new MainPage(super.getDriver())
                .clickOnTheFillingsItem()
                .clickOnTheBunItem()
                .theActiveSectionBunIsDisplayed();
        assertTrue(bunSection);
    }

    @Test
    @DisplayName("Проверка активного раздела Начинки в конструкторе бургеров")
    public void checkingTheActiveSectionFillings() {
        boolean bunSection = new MainPage(super.getDriver())
                .clickOnTheFillingsItem()
                .theActiveSectionFillingsIsDisplayed();
        assertTrue(bunSection);
    }

    @Test
    @DisplayName("Проверка активного раздела Соусы в конструкторе бургеров")
    public void checkingTheActiveSectionSouses() {
        boolean bunSection = new MainPage(super.getDriver())
                .clickOnTheSousesItem()
                .theActiveSectionSousesIsDisplayed();
        assertTrue(bunSection);
    }
}
