package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreatLeadInLeaftaps extends BaseClass {

	@Test
	public void runCreatLead() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kumaresan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Loganathan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("L");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Hello");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("07/29/89");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Finance");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("20000");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("15");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("123456");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Our team is best in all times");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("NA");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("44");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("44");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7911 123456");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("7911");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("NA");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Kumaresh@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("NA");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Vijay");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("VJ");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Manor Farm Barns");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Framingham Pigot");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Liverpool");
		WebElement stateDetail = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		stateDetail.sendKeys("Utah");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("L1 0AA");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("L1");
		System.out.println(driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value"));
		driver.findElement(By.name("submitButton")).click();
		String getTitle = driver.getTitle();
		Thread.sleep(1000);
		System.out.println("Title page as " + getTitle);

		if (getTitle.contains("View Lead")) {

			System.out.println("Title Page Contains with View Lead");
		} else {
			System.out.println("Title Page is not Contains with View Lead");
		}

	}

}
