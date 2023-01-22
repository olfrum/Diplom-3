import com.mifmif.common.regex.Main;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PasswordRecoveryPage;
import pageobject.RegisterPage;

import static main.Constance.EMAIL;
import static main.Constance.PASSWORD;

public class AuthTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("auth on main page")
    @Description("result : auth success")
    public void authMainPage(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        mainPage
            .openBaseUri()
            .loginButtonClick();
        loginPage
            .headerLogoWait()
            .sendEmailField(EMAIL)
            .sendPasswordFiels(PASSWORD)
            .loginButtonClick();
        mainPage
            .isOrderButtonDisplayed();
    }

    @Test
    @DisplayName("auth on main page account")
    @Description("auth success")
    public void authMainPageAccount(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        mainPage
                .openBaseUri()
                .accountButtonClick();
        loginPage
                .headerLogoWait()
                .sendEmailField(EMAIL)
                .sendPasswordFiels(PASSWORD)
                .loginButtonClick();
        mainPage
                .isOrderButtonDisplayed();
    }

    @Test
    @DisplayName("auth on main page account")
    @Description("auth success")
    public void authRegisterPage(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());
        registerPage
                .openRegisterUri()
                .loginButtonClick();
        loginPage
                .headerLogoWait()
                .sendEmailField(EMAIL)
                .sendPasswordFiels(PASSWORD)
                .loginButtonClick();
        mainPage
                .isOrderButtonDisplayed();
    }

    @Test
    @DisplayName("auth on main page account")
    @Description("auth success")
    public void authRestorePassword(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(browserRule.getDriver());

        passwordRecoveryPage
                .openForgotPassUri()
                .signInClick();
        loginPage
                .headerLogoWait()
                .sendEmailField(EMAIL)
                .sendPasswordFiels(PASSWORD)
                .loginButtonClick();
        mainPage
                .isOrderButtonDisplayed();
    }
}
