package week5.day1;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ServiceNowAssignIncident extends BaseClassServiceNow {

	@Test
	public void assignIncident() {

		driver.findElement(By.xpath("//div[text()='Open']")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']//input[@placeholder='Search']"))
				.sendKeys(incidentNumber + Keys.ENTER);

		WebElement table = driver.findElement(By.id("incident_table"));
		table.findElement(By.xpath("//tbody[@class='list2_body']//td[@class='vt']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lookup.incident.assignment_group")));

		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		driver.switchTo().defaultContent();

		Set<String> setWindowHandles = driver.getWindowHandles();
		List<String> listWindowHandles = new ArrayList<String>(setWindowHandles);

		driver.switchTo().window(listWindowHandles.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Software" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Software")));
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(listWindowHandles.get(0));

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigned To Software Group");
		driver.findElement(By.id("sysverb_update_bottom")).click();

		String assignedGroup = driver.findElement(By.xpath("(//td[@class='vt']/a)[3]")).getText();
		String assignedIncidentNumber = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		driver.switchTo().defaultContent();

		assertEquals(assignedIncidentNumber, incidentNumber);
		assertEquals(assignedGroup, "Software");
	}

}
