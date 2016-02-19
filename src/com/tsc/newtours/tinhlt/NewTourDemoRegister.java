package com.tsc.newtours.tinhlt;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTourDemoRegister {
private WebDriver driver;

@Before
public void setUp1() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");
	driver = new ChromeDriver();	
}

@Test
public void RegisterFail() throws Exception {
	driver.get("http://newtours.demoaut.com/");
	//find and click Register link
	WebElement regLink = driver.findElement(By.linkText("REGISTER"));
	regLink.click();	
	Thread.sleep(2000);
	//find and input First Name
	WebElement firstname = driver.findElement(By.name("firstName"));
	firstname.sendKeys("Tinh");
	//find and input Last Name
	WebElement lastname = driver.findElement(By.name("lastName"));
	lastname.sendKeys("Le");
	//find and input User Name
	WebElement username = driver.findElement(By.id("email"));
	username.sendKeys("a@b.com");
	//find and input password
	WebElement password = driver.findElement(By.name("password"));
	password.sendKeys("12345678");
	//click Submit button without input text into confirm password
	WebElement submit = driver.findElement(By.name("register"));
	submit.click();
	Thread.sleep(2000);
	String SuccessURL = driver.getCurrentUrl();
	if(SuccessURL.equals("http://newtours.demoaut.com/create_account_success.php"))
		System.out.println("TC3 - Hasn't input confirm password when register: This test case is NG");
	else
		System.out.println("TC3 - Hasn't input confirm password when register: This test case is OK");
		
}
@Test
public void RegisterSuccess() throws Exception {
	driver.get("http://newtours.demoaut.com/");
	//find and click Register link
	WebElement regLink = driver.findElement(By.linkText("REGISTER"));
	regLink.click();	
	Thread.sleep(2000);
	//find and input First Name
	WebElement firstname = driver.findElement(By.name("firstName"));
	firstname.sendKeys("Tinh");
	//find and input Last Name
	WebElement lastname = driver.findElement(By.name("lastName"));
	lastname.sendKeys("Le");
	//find and input User Name
	WebElement username = driver.findElement(By.id("email"));
	username.sendKeys("a@b.com");
	//find and input password
	WebElement password = driver.findElement(By.name("password"));
	password.sendKeys("12345678");
	//find and input confirm password
	WebElement confirmpassword = driver.findElement(By.name("confirmPassword"));
	confirmpassword.sendKeys("12345678");
	//click Submit button without input text into confirm password
	WebElement submit = driver.findElement(By.name("register"));
	submit.click();
	Thread.sleep(2000);
	String SuccessURL = driver.getCurrentUrl();
	if(SuccessURL.equals("http://newtours.demoaut.com/create_account_success.php"))
		System.out.println("TC4 - Hasn't input confirm password when register: This test case is OK");		
	else
		System.out.println("TC4 - Hasn't input confirm password when register: This test case is NG");	
	
}

@After
public void tearDown1() throws Exception {
	driver.quit();
	
}
	
}
