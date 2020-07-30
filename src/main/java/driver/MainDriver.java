package driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert; 
import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainDriver {
	public static void main(String[] args) { 
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		driver.navigate().to("http://secure.inspirave.com/"); 
		
		//maximize the screen
		System.out.println("test starts");
		driver.manage().window().maximize();
		try {
			Assert.assertEquals("SaveAway - Discover", driver.getTitle());
			System.out.println("Assertion 1 passed (home page test). You are in!");
		} 
		catch (AssertionError e) {
			System.out.println("Assertion 1 failed (home page test)");
			throw e;
		}
		
		//close welcome window
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("closeWelcome")).click();
		
		//test search
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchInput = driver.findElement(By.id("searchKey"));
		searchInput.sendKeys("iphone 11");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> searchElements = driver.findElements(By.id("searchButton"));
		searchElements.get(1).click();
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"divsort1\"]")).isDisplayed());
			System.out.println("Assertion 2 passed (search test)");
		} 
		catch (AssertionError e) {
			System.out.println("Assertion 2 failed (search test)");
			throw e;
		}
		
		//shift back to discover page
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("discoverLink")).click();
		
		//test login
		driver.findElement(By.xpath("//*[@id=\"size\"]/div[2]/header/div[2]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		WebElement emailAddress = driver.findElement(By.id("emailAddress"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("send"));
		emailAddress.sendKeys("jiuruchen@email.arizona.edu");
		password.sendKeys("Chen_5580767");
		login.click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("id01")));
			driver.findElement(By.xpath("//*[@id=\"compareTab\"]")).click();
			Assert.assertEquals("https://secure.inspirave.com/subWishlist", driver.getCurrentUrl());
			System.out.println("Assertion 3 passed (login test)");
		} 
		catch (AssertionError e) {
			System.out.println("Assertion 3 failed (login test)");
			throw e;
		}
	
	}
	
	
	
	
}
