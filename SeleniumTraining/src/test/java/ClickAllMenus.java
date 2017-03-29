import static org.junit.Assert.assertEquals;

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

public class ClickAllMenus {
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
		
		assertEquals("My Store",driver.getTitle());
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=appearance&doc=template']")).click();
		
		assertEquals("Template | My Store",driver.getTitle());
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=appearance&doc=logotype']")).click();
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		
		assertEquals("Logotype | My Store",driver.getTitle());
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}

		assertEquals("Catalog | My Store",driver.getTitle());
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=product_groups']")).click();
		assertEquals("Product Groups | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=option_groups']")).click();
		assertEquals("Option Groups | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=manufacturers']")).click();
		assertEquals("Manufacturers | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=suppliers']")).click();
		assertEquals("Suppliers | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=delivery_statuses']")).click();
		assertEquals("Delivery Statuses | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=sold_out_statuses']")).click();
		assertEquals("Sold Out Statuses | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=quantity_units']")).click();
		assertEquals("Quantity Units | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=csv']")).click();
		assertEquals("CSV Import/Export | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
		assertEquals("Countries | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=currencies&doc=currencies'")).click();
		assertEquals("Currencies | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=customers&doc=customers']")).click();
		assertEquals("Customers | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=customers&doc=csv']")).click();
		assertEquals("CSV Import/Export | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=customers&doc=newsletter']")).click();
		assertEquals("Newsletter | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
		assertEquals("Geo Zones | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=languages&doc=languages']")).click();
		assertEquals("Languages | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=languages&doc=storage_encoding']")).click();
		assertEquals("Storage Encoding | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=jobs']")).click();
		assertEquals("Job Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=customer']")).click();
		assertEquals("Customer Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=shipping']")).click();
		assertEquals("Shipping Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=payment']")).click();
		assertEquals("Payment Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=order_total']")).click();
		assertEquals("Order Total Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=order_success']")).click();
		assertEquals("Order Success Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=order_action']")).click();
		assertEquals("Order Action Modules | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=orders']")).click();
		assertEquals("Orders | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=order_statuses']")).click();
		assertEquals("Order Statuses | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=pages&doc=pages']")).click();
		assertEquals("Pages | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']")).click();
		assertEquals("Monthly Sales | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=most_sold_products']")).click();
		assertEquals("Most Sold Products | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=most_shopping_customers']")).click();
		assertEquals("Most Shopping Customers | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=store_info']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=defaults']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=general']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=listings']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=images']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=checkout']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=advanced']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=security']")).click();
		assertEquals("Settings | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=slides&doc=slides']")).click();
		assertEquals("Slides | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']")).click();
		assertEquals("Tax Classes | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=tax&doc=tax_rates']")).click();
		assertEquals("Tax Rates | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=search']")).click();
		assertEquals("Search Translations | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=scan']")).click();
		assertEquals("Scan Files For Translations | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=csv']")).click();
		assertEquals("CSV Import/Export | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=users&doc=users']")).click();
		assertEquals("Users | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
		
		driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']")).click();
		assertEquals("vQmods | My Store",driver.getTitle());
		try{
			driver.findElement(By.tagName("h1"));
			System.out.println("Page with title " + driver.getTitle() + " has h1 element");
		} catch(Exception e){
			System.out.println("Page with title " + driver.getTitle() + " does not have h1 element");
		}
	}

	@After
	public void stop(){
		driver.quit();
		driver=null;
	}
}