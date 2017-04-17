package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application {

	ProductPage pp;
	WebDriverWait wait;
	MainPage mp;
	String baseUrl;
	WebDriver driver;
	CartPage cp;

	public Application(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		mp = new MainPage(this.driver);
		cp = new CartPage(this.driver);
		wait = new WebDriverWait(this.driver, 10);
		pp = new ProductPage(this.driver);
	}

	public void start() {
		driver.get(baseUrl);
	}

	public void clickFirstProduct() {
		mp.clickFirstProduct();

	}

	public void addToCart() {
		pp.addToCart();
		
	}

	public void goToMainPage() {
		mp.goToMain();
	}

	public String getQuantityOfItemsInCart() {
		return driver.findElement(By.cssSelector("div#cart")).findElement(By.cssSelector("span.quantity"))
				.getAttribute("textContent");
	}

	public void goToCart() {
		driver.findElement(By.cssSelector("div#cart")).click();;
	}

	public void removeItem() {
		cp.removeItem();
	}

}
