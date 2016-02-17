package com.tsc.newtours.tinhlt;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class NewTourDemoLogin {
	private WebDriver driver;
	@Test
	public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");	
		System.setProperty("webdriver.chrome.driver", "D:/Working/Survey site/setup/setup/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		System.out.println("abcdef");
		System.out.println("zzzz");
	}	 
}


