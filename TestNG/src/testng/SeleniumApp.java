package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumApp {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\Tools\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        String title=driver.getTitle();
	    System.out.println("Title of the page is : "+title);
       }
	
	@Test (priority = 0)
	public void CreateAccount() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys("sinthuja30@gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitCreate")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customer_firstname")).sendKeys("Sinthuja");
		driver.findElement(By.id("customer_lastname")).sendKeys("M");
		driver.findElement(By.id("passwd")).sendKeys("12345s@");
		driver.findElement(By.id("firstname")).sendKeys("Sinthuja");
		driver.findElement(By.id("lastname")).sendKeys("M");
		driver.findElement(By.id("address1")).sendKeys("30 catskill, catskill");
		driver.findElement(By.id("city")).sendKeys("New York");
		driver.findElement(By.id("id_state")).sendKeys("New York");
		driver.findElement(By.id("postcode")).sendKeys("12414");
		driver.findElement(By.id("id_country")).sendKeys("United States");
		driver.findElement(By.id("phone_mobile")).sendKeys("6432123490");
		driver.findElement(By.id("alias")).sendKeys("3949 route 31, clay NY");
		driver.findElement(By.id("submitAccount")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1 )
	public void SignIn() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sinthuja30@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("12345s@");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitLogin")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Sign out the page");
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
	@Test (priority = 2)
	public void Search() {
		 
		driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("submit_search")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void quitApp() {
		driver.quit();
	}

}
