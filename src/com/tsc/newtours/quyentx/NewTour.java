package com.tsc.newtours.quyentx;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTour {

	public static WebDriver driver = new FirefoxDriver();
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		driver.get("http://www.newtours.demoaut.com");
//		checkLogIn();
//		checkSignUp();
//		
//	}

	@Test
	public void checkLogInValidCred(){
		String expectedTitle = "Sign-on: Mercury Tours";
        String actualTitle = "";
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		
		actualTitle = driver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)){
			
			System.out.println("Correct title! Logging in...");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")).sendKeys("tutorial");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("tutorial");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")).click();
			
			String currentTitle = "";
			currentTitle = driver.getTitle();
			if(currentTitle == "Find a flight: Mercury Tours"){
				System.out.println("PASS: Loggin successfully with VALID credentials");
			}
		}else{
			System.out.println("False title!");
		}
	}
	
	@Test
	public void checkLogInInvalidCred(){
		String expectedTitle = "Sign-on: Mercury Tours";
        String actualTitle = "";
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		
		actualTitle = driver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)){
			
			System.out.println("Correct title! Logging in with INVALID credentials...");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")).sendKeys("tutorial");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("password");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")).click();
			System.out.println("Test finished with INVALID credentials");

			String currentTitle = "";
			currentTitle = driver.getTitle();
			if(currentTitle == "Sign-on: Mercury Tours"){
				System.out.println("PASS: Loggin successfully with INVALID credentials");
			}
		}else{
			System.out.println("False title!");
		}	
	}
	
	@Test
	public void checkRegisterValidInfo(){
		String expectedTitle = "Register: Mercury Tours";
        String actualTitle = "";
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		actualTitle = driver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)){
			System.out.println("Correct title. Registering with INVALID info...");
			
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Quyen");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys("Ta");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys("0966997385");
			driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("username1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys("Address 1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys("Tuliem");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")).sendKeys("Hanoi");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input")).sendKeys("720110");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("quyentx");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys("password1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input")).sendKeys("password1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input")).click();
			
			String currentURL = "";
			currentURL = driver.getCurrentUrl();
			if(currentURL == "http://newtours.demoaut.com/create_account_success.php"){
				System.out.println("PASS: Test finished with VALID info");
			}
			
		}else{
			System.out.println("False title!");
		}
	}
	
	@Test
	public void checkRegisterInvalidInfo() throws InterruptedException {
		String expectedTitle = "Register: Mercury Tours";
        String actualTitle = "";
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		actualTitle = driver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)){
			System.out.println("Correct title. Registering with INVALID info...");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Quyen");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys("Ta");
			// input special characters in {Phone number} field 
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys("096699@#!$@");
			driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("username1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys("Address 1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys("Tuliem");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")).sendKeys("Hanoi");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input")).sendKeys("720110");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("quyentx");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys("password1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input")).sendKeys("password1");
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input")).click();
			
			String currentURL = "";
			currentURL = driver.getCurrentUrl();
			if(currentURL == "http://newtours.demoaut.com/create_account_unsuccess.php"){
				System.out.println("PASS: Registered UNsuccessful with INVALID info");
			}
		}else{
			System.out.println("False title!");
		}

	}	
}
