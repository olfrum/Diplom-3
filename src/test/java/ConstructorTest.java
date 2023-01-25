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

public class ConstructorTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("click constructor from profile")
    @Description("result : order button available")
    public void checkEnterConstructor(){
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
            .clickTextConstructor()
            .checkTextCreateOrder("Оформить заказ");
    }

    @Test
    @DisplayName("click logo burger")
    @Description("result : order button available")
    public void checkEnterBurger(){
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
                .clickStellarBurgers()
                .checkTextCreateOrder("Оформить заказ");
    }
}
