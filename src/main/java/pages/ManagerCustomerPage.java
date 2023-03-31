package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerCustomerPage extends BasePage {

    /**
     * Конструктор создания ManagerAddCustomerPage
     *
     * @param driver драйвер для управления браузером
     */
    public ManagerCustomerPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент кнопки "Customer" на странице Manager
     */
    @FindBy(xpath = "//button[contains(text(), 'Customers')]")
    private WebElement customerButton;

    /**
     * Элемент кнопки "First Name" на странице Manager
     */
    @FindBy(xpath = "//div/table/thead//td[1]/a")
    private WebElement firstNameButton;

    /**
     * Элемент поиска "Search" на странице Manager
     */
    @FindBy(xpath = "//div/form//div/input")
    private WebElement search;

    @Step("Метод нажатия на кнопку \"Customer\" на странице Manager")
    public void customerButton() {
        customerButton.click();
    }

    @Step("Метод нажатия на кнопку \"First Name\" на странице Manager")
    public void firstNameButton() {
        firstNameButton.click();
    }

    @Step("Метод ввода в поле поиска \"Search")
    public void addSearch(String name) {
        search.sendKeys(name);
    }

    @Step("Метод получения Имени в столбце First Name")
    public String textFirstName() {
        String firstName =  driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[1]")).getText();
        return firstName;
    }

    @Step("Метод получения Фамилии в столбце Last Name")
    public String textLastName() {
        String lastName =  driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]")).getText();
        return lastName;
    }

    @Step("Метод получения индекса в столбце Product Code")
    public String textProductCode() {
        String productCode =  driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[3]")).getText();
        return productCode;
    }
}
