package main;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wrapper {
    private final WebDriver driver;

    protected Wrapper(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open url")
    protected Wrapper open(String url) {
        driver.get(url);
        return this;
    }

    @Step("Wait element")
    protected WebElement waitForElement(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    @Step("Click element")
    protected Wrapper click(By element) {
        driver.findElement(element).click();
        return this;
    }

    @Step("Input text to field")
    protected Wrapper input(By element, String text) {
        driver.findElement(element).sendKeys(text);
        return this;
    }

    @Step("Text expected")
    protected Wrapper checkText(By element, String expected) {
        String txt = driver.findElement(element).getText();
        Assert.assertEquals(expected, txt);
        return this;
    }

    @Step("is Displayed element")
    protected Wrapper isDisplayed(By element) {
        waitForElement(element, 15);
        driver.findElement(element).isDisplayed();
        return this;
    }
}
