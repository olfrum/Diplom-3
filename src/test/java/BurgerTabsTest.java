import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import pageobject.MainPage;

public class BurgerTabsTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("click 'Булки' tabs")
    @Description("result : 'Булки' available ")
    public void goToBun(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage
                .openBaseUri()
                .fillingButtonClick()
                .bunButtonClick()
                .checkCurrentButton("Булки");
    }

    @Test
    @DisplayName("click 'Начинки' tabs")
    @Description("result : 'Начинки' available ")
    public void goToFill(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage
                .openBaseUri()
                .sauceButtonClick()
                .fillingButtonClick()
                .checkCurrentButton("Начинки");
    }

    @Test
    @DisplayName("click 'Соусы' tabs")
    @Description("result : 'Соусы' available ")
    public void goToSauce(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage
                .openBaseUri()
                .fillingButtonClick()
                .sauceButtonClick()
                .checkCurrentButton("Соусы");
    }
}
