import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Task4 {
	WebDriver driver;
	WebDriverWait wait;
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
		
		List<WebElement> menuTree = driver.findElements(By.cssSelector("li#app-"));
		
		for(int i = 0; i<17; i++){
			menuTree = driver.findElements(By.cssSelector("li#app-"));
			menuTree.get(i).click();
			menuTree = driver.findElements(By.cssSelector("li#app-"));
			List<WebElement> subs = menuTree.get(i).findElements(By.cssSelector("li"));
			if (subs.size() > 1){
				for (int k = 1; k<subs.size(); k++){
					subs.get(k).click();
					menuTree = driver.findElements(By.cssSelector("li#app-"));
					subs = menuTree.get(i).findElements(By.cssSelector("li"));
				}
			}
			
		}
		}

	@After
	public void stop(){
		driver.quit();
		driver=null;
	}
}