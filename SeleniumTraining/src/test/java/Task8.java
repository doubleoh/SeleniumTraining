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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task8 {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void start() {
		driver = new ChromeDriver();
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
		driver.findElement(By.linkText("Afghanistan")).click();
		List<WebElement> allLinks = driver.findElements(By.cssSelector("a>i.fa.fa-external-link"));
		String handle = driver.getWindowHandle();
		Set<String> newHandles;
		for (int i = 0; i < 7; i++) {
			allLinks.get(i).click();
			newHandles = driver.getWindowHandles();
			for (String a : newHandles) {
				if (!a.equals(handle)) {
					driver.switchTo().window(a);
					driver.close();
					driver.switchTo().window(handle);
				}
			}
		}
	}

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
