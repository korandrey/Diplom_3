package site.nomoreparties.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        //Выбираем на каком браузере хотим гонять тесты
        driver = getWebDriver("yandex");
    }

    @After
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }
}
