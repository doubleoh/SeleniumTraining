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
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void test() {
		driver.get("http://localhost/litecart/");
		driver.findElement(By.cssSelector("div.image-wrapper > img.image")).click();

		for (int i = 0; i < 3; i++) {
			WebElement el = driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/checkout']"));
			try {
				Select sel = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
				sel.selectByValue("Small");
			} catch (Exception e) {
			}
//			driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys("1");
			driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("a.content"))));
			driver.findElement(By.cssSelector("a[title='My Store']")).click();
		}
	}

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
