import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task8 {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void start() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void test() {
		driver.get("http://localhost/litecart/admin");
		// login
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		driver.findElement(By.name("login")).click();
		driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
		driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(7) > a > i")).click();
		List<WebElement> allLinks = driver.findElements(By.cssSelector("a>i.fa.fa-external-link"));
		
		for(int i = 0; i<7; i++){
		allLinks.get(i).click();
		
		assertEquals(1+i+1,driver.getWindowHandles().size());
		}
	}

	

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
