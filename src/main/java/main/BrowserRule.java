package main;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.*;


public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {

        String browser = System.getenv("browser");

        if ("ya".equals(browser)) {
            driver = new ChromeDriver();
        } else {
            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
    }

    @Override
    protected void after() {
        driver.quit();
    }
}
