package com.tsc.newtours.tinhlt;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class NewTourDemoLogin {
	private WebDriver driver;
	private String username;
	private String password;
	
	@Before
	public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");	
		System.setProperty("webdriver.chrome.driver", "D:/Working/Survey site/setup/setup/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void LoginFailInvalidUser() throws Exception {
		driver.get("http://newtours.demoaut.com");				
		
		//find and input user name
		WebElement user = driver.findElement(By.name("userName"));		
		user.sendKeys("tutorial11");
		//find and input password
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("tutorial");
		//find and click Login button
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(3000);
		String pageTitle2;
		pageTitle2 = driver.getTitle();		
		//System.out.println(pageTitle2);
		if (pageTitle2.equals("Find a Flight: Mercury Tours:"))
			System.out.println("TC1: This test case is NG");
		else
			System.out.println("TC1: This test case is OK");		
		
	}
	@Test
	public void LoginSuccess() throws Exception {
		driver.get("http://newtours.demoaut.com");
//		String pageTitle1;
//		pageTitle1 = driver.getTitle();		
//		System.out.println(pageTitle1);		
		
		//find and input user name
		WebElement user = driver.findElement(By.name("userName"));		
		user.sendKeys("tutorial");
		//find and input password
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("tutorial");
		//find and click Login button
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(3000);
		String pageTitle2;
		pageTitle2 = driver.getTitle();		
		//System.out.println(pageTitle2);		
		if (pageTitle2.equals("Find a Flight: Mercury Tours:"))
		{
			WebElement roundtrip = driver.findElement(By.name("tripType"));
			WebElement passCount = driver.findElement(By.name("passCount"));
			Select selectpassCount = new Select(passCount);	
			boolean Count = selectpassCount.getFirstSelectedOption().getAttribute("value").equals("1");			
			WebElement fromPort = driver.findElement(By.name("fromPort"));
			Select selectfromPort = new Select(fromPort);
			boolean fPort = selectfromPort.getFirstSelectedOption().getAttribute("value").equals("Acapulco");
			WebElement toPort = driver.findElement(By.name("toPort"));
			Select selecttPort = new Select(toPort);
			boolean tPort = selecttPort.getFirstSelectedOption().getAttribute("value").equals("Acapulco");
	
			WebElement servClass = driver.findElement(By.name("servClass"));
			WebElement airline = driver.findElement(By.name("airline"));
			Select selectairline = new Select(airline);
			boolean aline = selectairline.getFirstSelectedOption().getAttribute("value").equals("No Preference");
//			WebElement fromMonth = driver.findElement(By.name("fromDay"));			
//			System.out.println(selectpassCount.getFirstSelectedOption().getAttribute("value"));
			
			if ((roundtrip.isSelected()) && Count && fPort  && tPort && (servClass.isSelected()) && aline)
//			if ((roundtrip.isSelected()) && (selectpassCount.getFirstSelectedOption().getAttribute("value").equals("1")) && (selectfromPort.getFirstSelectedOption().getAttribute("value").equals("Acapulco")))
			{
				System.out.println("TC2: This test case is OK");
			}
			
		}
			
		else
		{
			System.out.println("TC2: This test case is NG");
		}
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}
	
}


