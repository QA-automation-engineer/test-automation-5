package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    By searchBox = By.id("search_query_top");
    By tips = By.xpath("//*[@id=\"index\"]/div[2]/ul/li");
    By firstTip = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        open("http://automationpractice.com/index.php");
        waitForDocumentCompleteState();
    }

    public void searchFor(String searchQuery) {
        setValue(searchBox, searchQuery);
    }

    public String getFirstTipText() {
        return $(firstTip).getText();
    }

    public String getFirstTipText(int expTipsNumber) {
        return $$(tips, expTipsNumber).get(0).getText();
    }
}
