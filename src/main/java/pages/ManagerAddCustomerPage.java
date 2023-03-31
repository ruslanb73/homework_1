package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.GenerateDateHelper.getRandomFirstName;
import static utils.GenerateDateHelper.getRandomLastName;
import static utils.GenerateDateHelper.getRandomProductCode;


/**
 * Класс в котором происходит взаимодействие со страницей Manager
 */
public class ManagerAddCustomerPage extends BasePage {

    /**
     * Конструктор создания ManagerAddCustomerPage
     *
     * @param driver драйвер для управления браузером
     */
    public ManagerAddCustomerPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент главное кнопки "AddCustomer" на странице Manager
     */
    @FindBy(css = "button[ng-click='addCust()']")
    private WebElement addCustomerButton;

    /**
     * Элемент кнопки "AddCustomer" на странице Manager при добавлении клиента
     */
    @FindBy(css = "button.btn.btn-default")
    private WebElement addCustomer;

    /**
     * Элемент поля "First Name" на странице Manager
     */
    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstName;

    /**
     * Элемент поля "Last Name" на странице Manager
     */
    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastName;

    /**
     * Элемент поля "Product Code" на странице Manager
     */
    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement productCode;

    @Step("Метод нажатия на кнопку \"AddCustomer\" на странице Manager")
    public void addCustomerButton() {
        addCustomerButton.click();
    }

    @Step("Метод нажатия на кнопку \"AddCustomer\" на странице Manager при создании клиента")
    public void addCustomer() {
        addCustomer.click();
    }

    @Step("Метод ввода в поле First Name")
    public void addFirstName() {
        firstName.sendKeys(getRandomFirstName());
    }

    @Step("Метод ввода в поле LastName")
    public void addLastName() {
        lastName.sendKeys(getRandomLastName());
    }

    @Step("Метод ввода в поле Product Code")
    public void addProductCode() {
        productCode.sendKeys(getRandomProductCode());
    }

    @Step("Метод возвращения всплывающего уведомления \"Заполните это поле\" в поле Last Name")
    public String lastNameEnterField() {
        return lastName.getAttribute("validationMessage");
    }

    @Step("Метод возвращения всплывающего уведомления \"Заполните это поле\" в поле First Name")
    public String firstNameEnterField() {
        return firstName.getAttribute("validationMessage");
    }

    @Step("Метод возвращения всплывающего уведомления \"Заполните это поле\" в поле Product Code")
    public String productCodeEnterField() {
        return productCode.getAttribute("validationMessage");
    }

}
