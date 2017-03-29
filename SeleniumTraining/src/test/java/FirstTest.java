import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//    	System.setProperty("webdriver.gecko.driver", "D:/Projects/tools/webDrivers/geckodriver.exe");
    	InternetExplorerDriverManager.getInstance().arch32().setup();
        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
    }

//  Create simple test which just open browser, navigates to www.google.com and then close the browser 

    @Test
    public void MyFirstTest() throws InterruptedException{
        driver.get("http://www.google.com");
        
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}