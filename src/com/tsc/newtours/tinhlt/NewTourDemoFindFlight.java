package com.tsc.newtours.tinhlt;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTourDemoFindFlight {
private WebDriver driver;

@Before
public void setup3() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\Working\\Survey site\\setup\\setup\\chromedriver.exe");
	driver = new ChromeDriver();	
}
@Test
public void FindFinderFail() throws Exception {
	
	
}
@After
public void tearDown3() throws Exception {
	driver.quit();
}

}
