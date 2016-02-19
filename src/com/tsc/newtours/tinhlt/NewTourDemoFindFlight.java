package com.tsc.newtours.tinhlt;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTourDemoFindFlight {
private WebDriver driver;

@Before
public void setup3() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");
	driver = new ChromeDriver();	
}
@Test
public void FindFinderFail() throws Exception {
	driver.get("http://newtours.demoaut.com");
	//Login successfully
	WebElement user = driver.findElement(By.name("userName"));		
	user.sendKeys("tutorial");	
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys("tutorial");
	WebElement login = driver.findElement(By.name("login"));
	login.click();
	Thread.sleep(3000);
	//input: round trip but Departing From = Arriving In
	WebElement fromPort1 = driver.findElement(By.name("fromPort"));	
	Select sefPort1 = new Select(fromPort1);
	sefPort1.selectByIndex(2);
	
	WebElement toPort1 = driver.findElement(By.name("toPort"));
	Select setPort1 = new Select(toPort1);
	setPort1.selectByIndex(2);
	
	WebElement roundtrip = driver.findElement(By.name("tripType"));
	
	if((roundtrip.isSelected()) && (sefPort1.getFirstSelectedOption().getAttribute("value").equals(setPort1.getFirstSelectedOption().getAttribute("value"))))
	{
		WebElement continuebtn = driver.findElement(By.name("findFlights"));
		continuebtn.click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals("http://newtours.demoaut.com/mercuryreservation2.php"))
			System.out.println("TC5: fromPort and ToPort are the same. This test case is NG");
		else
			System.out.println("TC5: fromPort and ToPort are the same. This test case is OK");
			
	}	
	
}
@Test
public void FindFinderSuccess() throws Exception {
	driver.get("http://newtours.demoaut.com");
	//Login successfully
	WebElement user = driver.findElement(By.name("userName"));		
	user.sendKeys("tutorial");	
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys("tutorial");
	WebElement login = driver.findElement(By.name("login"));
	login.click();
	Thread.sleep(3000);
	//input: round trip but Departing From <> Arriving In
	WebElement fromPort1 = driver.findElement(By.name("fromPort"));	
	Select sefPort1 = new Select(fromPort1);
	sefPort1.selectByIndex(2);
	
	WebElement toPort1 = driver.findElement(By.name("toPort"));
	Select setPort1 = new Select(toPort1);
	setPort1.selectByIndex(3);
	
	WebElement roundtrip = driver.findElement(By.name("tripType"));
	
	if((roundtrip.isSelected()) && (!sefPort1.getFirstSelectedOption().getAttribute("value").equals(setPort1.getFirstSelectedOption().getAttribute("value"))))
	{
		WebElement continuebtn1 = driver.findElement(By.name("findFlights"));
		continuebtn1.click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals("http://newtours.demoaut.com/mercuryreservation2.php"))
			System.out.println("TC6: fromPort and ToPort are the different. This test case is OK");
		else
			System.out.println("TC6: fromPort and ToPort are the different. This test case is NG");
		
	}
	
}
@After
public void tearDown3() throws Exception {
	driver.quit();
}

}
