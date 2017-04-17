import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.io.Files;

public class Task9 {

	private EventFiringWebDriver driver;

	public static class EventsListener extends AbstractWebDriverEventListener {

		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println(by);
		}

		@Override
		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println(by + " found");
		}

		@Override
		public void onException(Throwable throwable, WebDriver driver) {
			System.out.println(throwable);
			File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(tempFile, new File("screen-" + System.currentTimeMillis() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Before
	public void start() {

		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new EventsListener());

	}

	@Test
	public void steps() {
		// driver.get("http://localhost/litecart/admin/");
		driver.get("http://google.com.ua");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.name("login")).click();

		List<WebElement> menuTree = driver.findElements(By.cssSelector("li#app-"));

		for (int i = 0; i < 17; i++) {
			menuTree = driver.findElements(By.cssSelector("li#app-"));
			menuTree.get(i).click();
			menuTree = driver.findElements(By.cssSelector("li#app-"));
			List<WebElement> subs = menuTree.get(i).findElements(By.cssSelector("li"));
			if (subs.size() > 1) {
				for (int k = 1; k < subs.size(); k++) {
					subs.get(k).click();
					menuTree = driver.findElements(By.cssSelector("li#app-"));
					subs = menuTree.get(i).findElements(By.cssSelector("li"));
				}
			}

		}

		// wait.until()

	}

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}

}
