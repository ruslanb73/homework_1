import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.openqa.selenium.By;
import pages.ManagerCustomerPage;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Основной класс с тестами SearchCustomerTests
 */
@DisplayName("Поиск клиента")
public class SearchCustomerTests extends BaseTest {
    @ResourceLock("1")
    @DisplayName("Поиск клиента по имени")
    @Test
    public void searchCustomerByFirstNameTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести имя существующего клиента", () -> {
            managerCustomerPage.addSearch("Ron");
            Assert.isTrue(managerCustomerPage.getListCustomer().contains("Ron"), "Клиент не найден");
        });
    }

    @DisplayName("Поиск клиента по фамилии")
    @Test
    public void searchCustomerByLastNameTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести фамилию существующего клиента", () -> {
            managerCustomerPage.addSearch("Dumbledore");
            Assert.isTrue(managerCustomerPage.getListCustomer().contains("Dumbledore"), "Клиент не найден");
        });
    }

    @DisplayName("Поиск клиента по индексу")
    @Test
    public void searchCustomerByProductCodeTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести индекс существующего клиента", () -> {
            managerCustomerPage.addSearch("E55555");
            Assert.isTrue(managerCustomerPage.getListCustomer().contains("E55555"), "Клиент не найден");
        });
    }

    @DisplayName("Поиск несуществующего клиента по имени")
    @Test
    public void searchCustomerNoClientTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести имя несуществующего клиента", () -> {
            managerCustomerPage.addSearch("NoClient");
            Assertions.assertEquals(0, driver.findElements(By.xpath("//div/table/tbody/tr[1]")).size());
        });
    }
}
