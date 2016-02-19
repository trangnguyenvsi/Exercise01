package com.tsc.newtours.tinhlt;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTourDemoSelectFlight {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");	
		System.setProperty("webdriver.chrome.driver", "D:/Working/Survey site/setup/setup/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void selectFlightSuccess() throws Exception {
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
		WebElement continuebtn1 = driver.findElement(By.name("findFlights"));
		continuebtn1.click();
		Thread.sleep(3000);		
		if(driver.getCurrentUrl().equals("http://newtours.demoaut.com/mercuryreservation2.php"))
		{
			//select any flight
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")).click();
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")).click();	
			String outFlightName = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")).getAttribute("Value");
			String inFlightName =  driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")).getAttribute("Value");
			System.out.println("outFilight name "+outFlightName);
			System.out.println("inFilight name "+inFlightName);
			outFlightName = outFlightName.substring(0,outFlightName.indexOf("$")+4);
			inFlightName = inFlightName.substring(0,outFlightName.indexOf("$")+4);
			outFlightName = outFlightName.replace("$", " ");
			inFlightName = inFlightName.replace("$", " ");
//			System.out.println("outFilight name "+outFlightName);
//			System.out.println("inFilight name "+inFlightName);
			WebElement continuebtn2 = driver.findElement(By.name("reserveFlights"));
			continuebtn2.click();
			Thread.sleep(3000);
			
			if(driver.getCurrentUrl().equals("http://newtours.demoaut.com/mercurypurchase.php"))
			{
				String temp1 = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/font/b")).getText();
				String temp2 = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]/font/font/font[1]/b")).getText();
				if(temp1.equals(outFlightName) && temp2.equals(inFlightName))
					System.out.println("TC7: This test case is OK");
				else
					System.out.println("TC7: This test case is NG");
			}			
			
			
		}
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}

}
