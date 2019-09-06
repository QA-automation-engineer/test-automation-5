package lesson08.c_add_enums_for_conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson08.c_add_enums_for_conditions.Conditions.CLICKABLE;

class LandingPage extends BasePage {

    By searchBox = By.id("search_query_top");
    By tips = By.xpath("//*[@id=\"index\"]/div[2]/ul/li");
    By firstTip = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    void openPage() {
        open("http://automationpractice.com/index.php");
    }

    void searchFor(String searchQuery) {
        $(searchBox, CLICKABLE).clear();
        $(searchBox).sendKeys(searchQuery);

        //$$(tips, 5);
    }

    String getFirstTipText() {
        return $(firstTip).getText();
    }

    String getFirstTipText(int expTipsNumber) {
        return $$(tips, expTipsNumber).get(0).getText();
    }
}
