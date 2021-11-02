package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	
	public ChromeDriver driver;
	public WebDriverWait wait;
	static String incidentNumber;
	
	@BeforeMethod
	public void precondtion() {

//		Driver Setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Opening ServiceNow Application
		driver.get("https://dev56998.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		SwitchTo frame by using index and Login ServiceNow Application
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Raghu@123");
		driver.findElement(By.id("sysverb_login")).click();
		
//		Switch back frame to main page and search "incident" in Filter Navigator then click create New
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		
		
	}

	@AfterMethod
	public void postcondition() {
		driver.findElement(By.id("user_info_dropdown")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}
