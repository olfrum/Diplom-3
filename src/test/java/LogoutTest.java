import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static main.Constance.EMAIL;
import static main.Constance.PASSWORD;

public class LogoutTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("exit from profile")
    @Description("result : auth success")
    public void logout() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());

        mainPage
            .openBaseUri()
            .loginButtonClick();
        loginPage
            .headerLogoWait()
            .sendEmailField(EMAIL)
            .sendPasswordFiels(PASSWORD)
            .loginButtonClick();
        accountPage
            .clickButtonPersonalArea()
            .clickButtonExit()
            .isDisplayedTextEnter();
    }
}
