package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	WebDriver driver;
	public MainPage(WebDriver driver){
		this.driver = driver;
	}

	public void clickFirstProduct() {
		 driver.findElement(By.cssSelector("div.image-wrapper > img.image")).click();
		
	}

	public void goToMain() {
		driver.findElement(By.cssSelector("div#logotype-wrapper")).click();
	}

	

}
