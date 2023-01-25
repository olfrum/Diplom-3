package pageobject;

import main.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends Wrapper {

    private final By buttonExit = By.xpath(".//button[text()='Выход']");
    private final By buttonPersonalArea = By.xpath(".//*[text()='Личный Кабинет']");
    private final By inputTypeName = By.xpath(".//*[text()='Имя']");
    private final By inputTypeLogin = By.xpath(".//*[text()='Логин']");
    private final By inputTypePassword = By.xpath(".//*[text()='Пароль']");
    private final By textEnter = By.xpath(".//*[text()='Вход']");
    private final By textConstructor = By.xpath(".//*[text()='Конструктор']");
    private final By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    private final By stellarBurgers = By.xpath("//a[.//*[@id='filter0_f']]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickStellarBurgers() {
        click(stellarBurgers);
        return this;
    }

    public AccountPage clickTextConstructor() {
        click(textConstructor);
        return this;
    }
    public AccountPage clickButtonExit() {
        click(buttonExit);
        return this;
    }

    public AccountPage clickButtonPersonalArea() {
        click(buttonPersonalArea);
        return this;
    }

    public AccountPage isDisplayedTextEnter() {
        isDisplayed(textEnter);
        return this;
    }

    public AccountPage isDisplayedFieldName() {
        isDisplayed(inputTypeName);
        return this;
    }

    public AccountPage isDisplayedFieldLogin() {
        isDisplayed(inputTypeLogin);
        return this;
    }

    public AccountPage isDisplayedFieldPassword() {
        isDisplayed(inputTypePassword);
        return this;
    }

    public AccountPage checkTextCreateOrder(String expected) {
        checkText(buttonCreateOrder, expected);
        return this;
    }
}
