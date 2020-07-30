package test1;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SimpleTest {
	public static void main(String[] args) { 
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		driver.navigate().to("http://secure.inspirave.com/");  
		
		//maximize the screen
		System.out.println("test starts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//close welcome window
		System.out.println("close the window");
		driver.findElement(By.id("closeWelcome")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//*[@id="searchButton"]
		///html/body/div[7]/div/div/div[2]/div[1]/div/div[2]/div[2]/form/button
		List<WebElement> searchElements = driver.findElements(By.id("searchButton"));
		searchElements.get(1).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//to log in and shift to compare page
		System.out.println("go to the compare page");
		driver.findElement(By.id("compareTab")).click();		
		WebElement emailAddress = driver.findElement(By.id("emailAddress"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("send"));
		emailAddress.sendKeys("jiuruchen@email.arizona.edu");
		password.sendKeys("Chen_5580767");
		System.out.println("done putting into info");
		login.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//shift back to discover page
//		System.out.println("click on discover");
//		driver.findElement(By.id("discoverDiv")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable("openMyProfileDash2"));
		
//		JavascriptExecutor javascript = (JavascriptExecutor) driver;
//		javascript.executeScript("document.getElementById.('searchKey').value = 'iphone 11'; document.getElementById('searchButton').click();");
		
//		driver.findElement(By.id("searchButton")).click();
		
		
//		System.out.println(driver.findElement(By.id("openMyProfileDash2")));
//		System.out.println(driver.findElement(By.id("openMyProfileDash2")).isDisplayed());
		
//		driver.findElement(By.id("compareTab")).click();
//		driver.findElement(By.id("searchButton")).click();
//		
//		driver.findElement(By.id("openMyProfileDash2")).click();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.findElement(By.id("login")).click();
//		

//		WebElement emailAddress = driver.findElement(By.id("emailAddress"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement login = driver.findElement(By.id("send"));
//		
//		emailAddress.sendKeys("jiuruchen@email.arizona.edu");
//		password.sendKeys("Chen_5580767");
//		login.click();
	}
	
	
	
	
}
