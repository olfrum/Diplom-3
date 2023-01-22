package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import main.Wrapper;
import static main.Constance.REGISTER_URI;

public class RegisterPage extends Wrapper {


    private final By inputNameField = By.xpath(".//fieldset[1]//input");
    private final By inputEmailField = By.xpath(".//fieldset[2]//input");
    private final By inputPasswordField = By.xpath(".//fieldset[3]//input");
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By textIncorrectPassword = By.xpath(".//*[text() = 'Некорректный пароль']");
    private final By textLoginExist = By.xpath(".//*[text() = 'Вход']");
    private final By loginButton = By.xpath(".//*[text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage openRegisterUri(){
        open(REGISTER_URI);
        return this;
    }

    public RegisterPage clickRegistartionButton(){
        click(buttonRegistration);
        return this;
    }

    public RegisterPage sendNameToField(String name) {
        input(inputNameField, name);
        return this;
    }

    public RegisterPage sendEmailToField(String email) {
        input(inputEmailField, email);
        return this;
    }

    public RegisterPage sendPasswordToField(String password) {
        input(inputPasswordField, password);
        return this;
    }

    public RegisterPage checkTextIncorrectPassword(String expected) {
        checkText(textIncorrectPassword, expected);
        return this;
    }

    public RegisterPage loginButtonClick(){
        click(loginButton);
        return this;
    }

    public RegisterPage checkTextEnter(String expected) {
        checkText(textLoginExist, expected);
        return this;
    }



}
