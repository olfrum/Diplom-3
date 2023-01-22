package pageobject;

import main.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Wrapper {

    private final By inputEmailField = By.xpath(".//fieldset[1]//input");
    private final By passwordInpuntField =  By.xpath(".//fieldset[2]//input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By loginHeader = By.xpath(".//h2[text()='Вход']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sendEmailField(String email){
        input(inputEmailField, email);
        return this;
    }

    public LoginPage headerLogoWait(){
        waitForElement(loginHeader, 10);
        return this;
    }

    public LoginPage sendPasswordFiels(String pass){
        input(passwordInpuntField, pass);
        return this;
    }
    public LoginPage loginButtonClick(){
        click(loginButton);
        return this;
    }
}
