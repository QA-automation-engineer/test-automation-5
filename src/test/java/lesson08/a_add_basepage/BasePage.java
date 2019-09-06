package lesson08.a_add_basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebElement $(By locator) {
        return driver.findElement(locator);
    }

    List<WebElement> $$(By locator) {
        return driver.findElements(locator);
    }
}
