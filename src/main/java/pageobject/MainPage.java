package pageobject;

import main.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.Constance.BASE_URI;

public class MainPage extends Wrapper {

    private final By accountButton = By.xpath(".//nav/a[@class='AppHeader_header__link__3D_hX']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By buttonBun = By.xpath(".//span[text()='Булки']");
    private final By buttonSauce = By.xpath(".//span[text()='Соусы']");
    private final By buttonFilling = By.xpath(".//span[text()='Начинки']");
    private final By buttonAll = By.cssSelector(".tab_tab_type_current__2BEPc");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginButtonClick(){
        click(loginButton);
        return this;
    }

    public MainPage checkCurrentButton (String expected){
        checkText(buttonAll, expected);
        return this;
    }

    public MainPage openBaseUri(){
        open(BASE_URI);
        return this;
    }

    public MainPage accountButtonClick(){
        click(accountButton);
        return this;
    }

    public MainPage bunButtonClick(){
        click(buttonBun);
        return this;
    }

    public MainPage sauceButtonClick(){
        click(buttonSauce);
        return this;
    }

    public MainPage fillingButtonClick(){
        click(buttonFilling);
        return this;
    }

    public MainPage isOrderButtonDisplayed(){
        isDisplayed(orderButton);
        return this;
    }

}
