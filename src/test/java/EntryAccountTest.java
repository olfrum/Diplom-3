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

public class EntryAccountTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("auth into account")
    @Description("result : auth success")
    public void enterAccount() {
        AccountPage accountPage = new AccountPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .openBaseUri()
                .loginButtonClick();
        loginPage
                .headerLogoWait()
                .sendEmailField(EMAIL)
                .sendPasswordFields(PASSWORD)
                .loginButtonClick();
        accountPage
                .clickButtonPersonalArea()
                .isDisplayedFieldName()
                .isDisplayedFieldLogin()
                .isDisplayedFieldPassword();
    }
}
