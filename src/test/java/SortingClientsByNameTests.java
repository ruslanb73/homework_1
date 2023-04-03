import com.google.common.collect.Ordering;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ManagerCustomerPage;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Основной класс с тестами SortingClientsByNameTests
 */
@DisplayName("Сортировка клиентов по имени (First Name)")
public class SortingClientsByNameTests extends BaseTest {

    @DisplayName("Сортировка клиентов на странице manager в порядке возрастания")
    @Test
    public void test() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);
        Allure.step("Шаг 1. Нажать кнопку Customers", managerCustomerPage::customerButton);

        Allure.step("Шаг 2:  Нажать на кнопку сортировки First Name два раза", () -> {
            managerCustomerPage.firstNameButton();
            managerCustomerPage.firstNameButton();
            Assert.isTrue(Ordering.natural()
                    .isOrdered(managerCustomerPage.getLostCustomerAll()), "Ошибка при сортировке данных");
        });
    }

    @DisplayName("Сортировка клиентов на странице manager в порядке убывания")
    @Test
    public void test2(){
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);
        Allure.step("Шаг 1. Нажать кнопку Customers", managerCustomerPage::customerButton);
        Allure.step("Шаг 2:  Нажать на кнопку сортировки First Name два раза", managerCustomerPage::firstNameButton);
        Assert.isTrue(Ordering.natural()
                .reverse()
                .isOrdered(managerCustomerPage.getLostCustomerAll()), "Ошибка при сортировке данных");
    }
}
