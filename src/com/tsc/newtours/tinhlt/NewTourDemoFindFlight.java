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
		System.out.println("TC5: fromPort and ToPort are the same. This test case is NG");
	else
		System.out.println("TC5: fromPort and ToPort are the same. This test case is OK");
	
}
@Test
public void FindFinderSuccess() throws Exception {
	
	
}
@After
public void tearDown3() throws Exception {
	driver.quit();
}

}
