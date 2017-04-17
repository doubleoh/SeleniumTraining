import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task7 {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void start() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			driver.get("http://localhost/litecart/");
			driver.findElement(By.cssSelector("div.image-wrapper > img.image")).click();
			WebElement el = driver.findElement(By.cssSelector("div#cart")).findElement(By.cssSelector("span.quantity"));
			try {
				Select sel = new Select(driver.findElement(By.cssSelector("select")));
				sel.selectByValue("Small");
			} catch (Exception e) {
			}

			driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
			wait.until(ExpectedConditions.attributeContains(el, "textContent", i + 1 + ""));
		}
		driver.findElement(By.cssSelector("div#cart")).click();
		List<WebElement> removeButtons;
		List<WebElement> skus;
		do {
			skus = driver.findElements(By.cssSelector("td.sku"));
			removeButtons = driver.findElements(By.cssSelector("button[name='remove_cart_item']"));
			wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
			removeButtons.get(0).click();
			wait.until(ExpectedConditions.stalenessOf(skus.get(0)));
			removeButtons.remove(0);
		} while (!removeButtons.isEmpty());

		driver.get("http://localhost/litecart/");
		assertTrue(driver.findElement(By.cssSelector("div#cart")).findElement(By.cssSelector("span.quantity")).getAttribute("textContent").equals("0"));
	}

	

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
