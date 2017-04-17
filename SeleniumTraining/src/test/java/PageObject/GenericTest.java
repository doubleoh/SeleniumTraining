package PageObject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GenericTest {

	Application app;
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void start() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		app = new Application(driver, "http://localhost/litecart/");
		app.start();

	}

	@After
	public void stop() {
		driver.quit();
		driver = null;
	}

}
