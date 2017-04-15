import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task9 {

	private EventFiringWebDriver driver;
	private WebDriverWait wait;
	
	public static class EventsListener extends AbstractWebDriverEventListener{
		
		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver){
			System.out.println(by);
		}
		
		@Override
		public void afterFindBy(By by, WebElement element, WebDriver driver){
			System.out.println(by + " found");
		}
		
		@Override
		public void onException(Throwable throwable, WebDriver driver){
			System.out.println(throwable);
		}
	}
	
	@Before
	public void start(){
		
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new EventsListener());
		wait = new WebDriverWait(driver, 10);
		
	}
	
	@Test
	public void steps(){
		driver.get("http://google.com.ua");
		driver.findElement(By.name("q")).sendKeys("event fired");
		driver.findElement(By.name("btnG")).submit();
		
	}
	@After
	public void stop(){
		driver.quit();
		driver = null;
	}
	
}
