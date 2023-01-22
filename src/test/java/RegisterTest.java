import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import main.UserGenerator;
import org.junit.Rule;
import org.junit.Test;
import pageobject.RegisterPage;
import pojo.User;

public class RegisterTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    User userData;

    @Test
    @DisplayName("Success registration")
    @Description("Result : login page")
    public void trueRegisterTest(){
        userData = UserGenerator.getNewUser();
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());
        registerPage
                .openRegisterUri()
                .sendNameToField(userData.getName())
                .sendEmailToField(userData.getEmail())
                .sendPasswordToField(userData.getPassword())
                .clickRegistartionButton()
                .checkTextEnter("Вход");
        UserGenerator
                .deleteUserRequest(userData.getEmail(), userData.getPassword());
    }

    @Test
    @DisplayName("Error registration")
    @Description("Result : incorrect password")
    public void falseRegisterTest(){
        userData = UserGenerator.getNewUser();
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());
        registerPage
            .openRegisterUri()
            .sendNameToField(userData.getName())
            .sendEmailToField(userData.getEmail())
            .sendPasswordToField(userData.getPassword().substring(0, 5))
            .clickRegistartionButton()
            .checkTextIncorrectPassword("Некорректный пароль");
    }
}
