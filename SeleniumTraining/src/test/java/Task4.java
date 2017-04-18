import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.Assert;

public class Task4 {
	WebDriver driver;
	@Before
	public void start(){
		ChromeDriverManager.getInstance().setup();
		driver= new ChromeDriver();
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
			org.junit.Assert.assertNotNull(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
			menuTree = driver.findElements(By.cssSelector("li#app-"));
			List<WebElement> subs = menuTree.get(i).findElements(By.cssSelector("li"));
			if (subs.size() > 1){
				for (int k = 1; k<subs.size(); k++){
					subs.get(k).click();
					org.junit.Assert.assertNotNull(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
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