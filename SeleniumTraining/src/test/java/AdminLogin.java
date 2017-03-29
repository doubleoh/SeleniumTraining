import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class AdminLogin {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Before
	public void start(){
		ChromeDriverManager.getInstance().setup();
		driver= new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void step1() throws InterruptedException{
		driver.get("http://localhost/litecart/admin/");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

	@After
	public void stop(){
		driver.quit();
		driver=null;
	}
}
