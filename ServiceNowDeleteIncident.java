package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

@Test
public class ServiceNowDeleteIncident extends BaseClassServiceNow {

	public void deleteIncident() throws InterruptedException {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]")));
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[contains(text(),'submit the search')]/following-sibling::input"))
				.sendKeys(incidentNumber + Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']")).click();

		driver.findElement(By.xpath("//button[text()='Delete']")).click();

		driver.findElement(By.id("ok_button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'submit the search')]/following-sibling::input"))
				.sendKeys(incidentNumber + Keys.ENTER);
		String text = driver.findElement(By.xpath("//tr[@class='list2_no_records']")).getText();

		driver.switchTo().defaultContent();

		if (text.equals("No records to display")) {
			System.out.println(incidentNumber + " Deleted Successfully");
		} else {
			System.out.println(incidentNumber + " Not Deleted");
		}

	}

}
