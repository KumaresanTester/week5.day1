package week5.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class DeleteLead extends BaseClass {

	@Test
	public void runDeleteLead() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		WebElement eleFindLead = driver.findElement(By.xpath("//a[text()='Find Leads']"));
		eleFindLead.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345678");
		WebElement eleFindLeadBtn = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		eleFindLeadBtn.click();
		Thread.sleep(2000);
		WebElement eleLeadId = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadId = eleLeadId.getText();
		System.out.println("First Resulting lead ID is : " + leadId);
		eleLeadId.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
//		eleFindLeadBtn.click();	
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String deletedMsg = driver.findElement(By.xpath("//div[contains(text(),'No records ')]")).getText();
		if (deletedMsg.equalsIgnoreCase("No records to display")) {
			System.out.println("Sucessfully Deleted the Lead ID: Expected Text Found " + deletedMsg);
		} else {
			System.out.println("Lead ID not Deleted: Actual Text Found " + deletedMsg);
		}

		

	}

}
