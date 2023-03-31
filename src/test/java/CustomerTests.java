import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import pages.ManagerAddCustomerPage;

/**
 * Основной класс с тестами CustomerTests
 */
@DisplayName("Создание клиента (AddCustomer)")
public class CustomerTests extends BaseTest {

    @DisplayName("Успешное создание клиента на странице manager")
    @Test
    public void successAddClientsTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести имя клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 3. Ввести фамилию клиента в поле Last Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 4. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 5. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);

        Alert alerts = driver.switchTo().alert();
        String textAlert = alerts.getText().replaceAll("[\\d]", "");
        System.out.println(textAlert);
        alerts.accept();
        Assertions.assertEquals(
                textAlert,
                "Customer added successfully with customer id :",
                "Alert не соответствует");

    }

    @DisplayName("Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля Last Name")
    @Test
    public void PopUpFailedAddedClientsAbsenceLastNameTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 3. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assertions.assertEquals(managerAddCustomerPage.lastNameEnterField(),
                "Заполните это поле.",
               "Уведомление не соответствует");
    }

    @DisplayName("Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля First Name")
    @Test
    public void PopUpFailedAddedClientsAbsenceFirstNameTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 3. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assertions.assertEquals(managerAddCustomerPage.firstNameEnterField(),
                "Заполните это поле.",
                "Уведомление не соответствует");
    }

    @DisplayName("Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля Product Code")
    @Test
    public void PopUpFailedAddedClientsAbsenceProductCodeTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assertions.assertEquals(managerAddCustomerPage.productCodeEnterField(),
                "Заполните это поле.",
                "Уведомление не соответствует");
    }
}


