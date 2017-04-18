
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class Task5 {

	private WebDriver driver;

	@Before
	public void start() {

//		FirefoxDriverManager.getInstance().setup();
//		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver = new InternetExplorerDriver();
	}

	@Test
	public void step1() throws InterruptedException {
		driver.get("http://localhost/litecart/en/");
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		WebElement duck = driver.findElement(By.cssSelector("#box-campaigns"))
				.findElement(By.cssSelector("a.link"));

		String nameOnMain = duck.getAttribute("title");
		WebElement basePrice = duck.findElement(By.cssSelector("s.regular-price"));
		if (!browserName.equals("internet explorer")) {
			String basePriceDecorOnMain = basePrice.getCssValue("text-decoration-line");
			assertEquals("line-through", basePriceDecorOnMain); // strike-through
		} else {
			System.out.println("I could not find the strike-through style in IE. Blame the stupid tester.");
		}

		if (!browserName.equals("firefox")) {
			assertEquals("rgba(119, 119, 119, 1)", basePrice.getCssValue("color")); // verification
																					// that
																					// base
																					// price
																					// is
																					// grey
																					// on
																					// main
																					// page
		} else {
			assertEquals("rgb(119, 119, 119)", basePrice.getCssValue("color"));
		}

		String basePriceOnMain = basePrice.getAttribute("textContent");

		WebElement campaignPrice = duck.findElement(By.cssSelector("strong.campaign-price"));

		if (browserName.equals("chrome")) {
			assertEquals("bold", campaignPrice.getCssValue("font-weight")); // bold
		} else {
			assertEquals("900", campaignPrice.getCssValue("font-weight")); // bold
		}
		if (!browserName.equals("firefox")) {
			assertEquals("rgba(204, 0, 0, 1)", campaignPrice.getCssValue("color")); // verification
																					// that
																					// campaign
																					// price
																					// is
																					// red
																					// on
																					// main
																					// page
		} else {
			assertEquals("rgb(204, 0, 0)", campaignPrice.getCssValue("color"));
		}

		String campaignPriceOnMain = campaignPrice.getAttribute("textContent"); // needed
																				// later
																				// to
																				// assert
																				// if
																				// values
																				// are
																				// equal.

		duck.click();
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1.title"))));
		// unfortunately didn't work as expected. will use Thread.sleep >:D
		if (browserName.equals("firefox")) {
			Thread.sleep(2000); // 1000 didn't work also
		}
		duck = driver.findElement(By.cssSelector("h1.title"));
		String nameOnPage = duck.getAttribute("textContent");
		assertEquals(nameOnMain, nameOnPage);

		basePrice = driver.findElement(By.cssSelector("s.regular-price"));
		campaignPrice = driver.findElement(By.cssSelector("strong.campaign-price"));
		String basePriceDecorOnItemPage = basePrice.getCssValue("text-decoration-line");
		if (!browserName.equals("internet explorer")) {
			assertEquals("line-through", basePriceDecorOnItemPage); // strike-through,
																	// doesn't
																	// work in
																	// IE!!! :(
		}
		if (browserName.equals("chrome")) {
			assertEquals("bold", campaignPrice.getCssValue("font-weight")); // bold
		} else {
			assertEquals("700", campaignPrice.getCssValue("font-weight")); // bold
		}
		if (!browserName.equals("firefox")) {
			assertEquals("rgba(102, 102, 102, 1)", basePrice.getCssValue("color")); // grey
			assertEquals("rgba(204, 0, 0, 1)", campaignPrice.getCssValue("color")); // red
		} else {
			assertEquals("rgb(102, 102, 102)", basePrice.getCssValue("color")); // grey
			assertEquals("rgb(204, 0, 0)", campaignPrice.getCssValue("color")); // red
		}

		// compare base and campaign prices
		String basePriceOnItemPage = basePrice.getAttribute("textContent");
		String campaignPriceOnItemPage = campaignPrice.getAttribute("textContent");
		assertTrue(basePriceOnMain.equals(basePriceOnItemPage)); // Base price's
																	// values
																	// are equal
																	// on both
																	// pages
		assertTrue(campaignPriceOnMain.equals(campaignPriceOnItemPage)); // Campaign
																			// price's
																			// values
																			// are
																			// equal
																			// on
																			// both
																			// pages

	}

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}
}
