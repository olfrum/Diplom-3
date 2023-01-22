package pageobject;

import main.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.Constance.*;

public class PasswordRecoveryPage extends Wrapper {

    private final By signInLink = By.xpath(".//*[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    public PasswordRecoveryPage openForgotPassUri(){
        open(FORGOT_PASSWORD_URI);
        return this;
    }

    public PasswordRecoveryPage signInClick(){
        click(signInLink);
        return this;
    }
}
