package pages;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    /**
     * Экземпляр драйвера для управления браузером
     */
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
