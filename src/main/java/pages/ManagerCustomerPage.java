package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(xpath = "//tr//td[1]")
    private List<WebElement> firstNameList;

    @Step("Получает список всех значений firstName")
    public List<String> getLostCustomerAll() {
        return firstNameList.stream()
                .skip(1)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @FindBy(xpath = "//tr[1]/td")
    private List<WebElement> firstLineList;


    @Step("Получает строку из таблицы")
    public List<String> getListCustomer() {
        return firstLineList.stream()
                .skip(5)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
