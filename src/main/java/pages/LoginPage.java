package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void visit(){
		open("http://automationpractice.com/index.php?controller=authentication");
		waitForDocumentCompleteState();
	}

	public void logIn(String email, String pwd) {
		setValue(By.id("email"), email);
		setValue(By.id("passwd"), pwd);
		clickOn(By.id("SubmitLogin"));
		waitForDocumentCompleteState();
	}

	public String getErrorMessage() {
		return $("//*[@id=\"center_column\"]/div[1]/ol/li").getText();
	}
}
