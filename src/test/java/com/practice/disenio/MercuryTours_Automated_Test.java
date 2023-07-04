package com.practice.disenio;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_Automated_Test {
	
	private WebDriver driver;
	By register_link_locator=By.linkText("REGISTER");
	
	
	By register_page_locator=By.xpath("//img[@src='images/mast_register.gif']");
	By username_locator=By.id("email");
	By password_locator=By.name("password");
	By confirm_password_locator=By.cssSelector("input[name='confirmPassword']");
	By register_btn_locator=By.name("submit");
	
	
	By user_locator=By.name("userName");
	By pass_locator=By.name("password");
	By sigin_btn_locator=By.name("submit");
	
	By home_page_locator=By.xpath("//table[@width='492']");
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void register_user() throws InterruptedException {
		driver.findElement(register_link_locator).click();
		Thread.sleep(2000);
		if(driver.findElement(register_page_locator).isDisplayed()) {
			driver.findElement(username_locator).sendKeys("adminjuan");
			driver.findElement(password_locator).sendKeys("12345");
			driver.findElement(confirm_password_locator).sendKeys("12345");
			
			driver.findElement(register_btn_locator).click();
		}else {
			System.out.print("register pages was not found");
		}
		
		List<WebElement> fonts=driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is adminjuan.",fonts.get(5).getText());
	}
	
	@Test
	public void singIn() throws InterruptedException {
		if(driver.findElement(user_locator).isDisplayed()) {
			driver.findElement(user_locator).sendKeys("adminjuan");
			driver.findElement(pass_locator).sendKeys("12345");
			driver.findElement(sigin_btn_locator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(home_page_locator).isDisplayed());
		}else {
			System.out.println("username textbox was no present");
		}
	}

}





