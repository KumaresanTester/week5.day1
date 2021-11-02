package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ServiceNowCreateIncident extends BaseClassServiceNow {

	@Test
	public void createIncident() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='sn-widget-list-content']/div[text()='Create New']")));
		driver.findElement(By.xpath("//div[@class='sn-widget-list-content']/div[text()='Create New']")).click();

//		SwitchTo frame and click caller and select caller list by using windowHandeles
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gsft_main")));
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[2]")).click();

//		Switch back to parent window and SwitchTo frame then clicked short description
		driver.switchTo().window(windowHandlesList.get(0));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gsft_main")));
		driver.findElement(By.id("lookup.incident.short_description")).click();

//		By using windowHandles selected the short description
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandlesList2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windowHandlesList2.get(1));
		driver.findElement(By.linkText("Issue with a web page")).click();

//		Switch back to parent window and SwitchTo frame then get the incident number and Submit
		driver.switchTo().window(windowHandlesList2.get(0));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gsft_main")));
		incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().defaultContent();

//		SwitchTo frame and search the Incident number then switch back to main page
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gsft_main")));
		driver.findElement(By.xpath("//span[@id='incident_hide_search']//input[@placeholder='Search']"))
				.sendKeys(incidentNumber + Keys.ENTER);
		driver.switchTo().defaultContent();

//		SwitchTo frame get the Text of Incident Number and check whether created Inc matching with listed INC number
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gsft_main")));
		String getIncidentNum = driver.findElement(By.xpath("//td[@class='vt']/a[@class='linked formlink']")).getText();
		driver.switchTo().defaultContent();

		if (getIncidentNum.equals(incidentNumber)) {
			System.out.println("Incident Created Successfully with the Incident Number is " + incidentNumber);
		} else {
			System.out.println("Incident Not Created Successfully as Expected. Created Incident Number "
					+ incidentNumber + " not found in the List ");
		}

	}

}
