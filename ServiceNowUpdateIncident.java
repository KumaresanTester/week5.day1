package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ServiceNowUpdateIncident extends BaseClassServiceNow {

	@Test
	public void updateIncident() {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]")));
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[contains(text(),'submit the search')]/following-sibling::input"))
				.sendKeys(incidentNumber + Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']")).click();

		WebElement eleUrgency = driver.findElement(By.xpath("//div[@id='element.incident.urgency']//select"));
		Select urgencyOption = new Select(eleUrgency);
		urgencyOption.selectByValue("1");

		WebElement eleState = driver.findElement(By.xpath("//div[@id='element.incident.state']//select"));
		Select stateOption = new Select(eleState);
		stateOption.selectByVisibleText("In Progress");

		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Updated the Urgency with High");

		driver.findElement(By.id("sysverb_update_bottom")).click();

		String priorityText = driver.findElement(By.xpath("(//td[@class='vt'])[5]")).getText();
		String stateText = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		driver.switchTo().defaultContent();

		System.out.println("Priority Updated with :" + priorityText);
		System.out.println("State Updated with :" + stateText);

	}

}
