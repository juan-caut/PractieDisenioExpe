package com.practice.disenio;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void testGoogglePage() {
		WebElement searchbox=driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("software tests");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("software tests - Buscar con Google",driver.getTitle());
	}
	/*
	@Test void localizadores() {
		By locator=By.id("id_del_elemento");
		By locator_name=By.name("name_elemento");
		By locator_className=By.className("class_element");
		By locator_tagname=By.tagName("tag");
		By locator_linktest=By.linkText("texto_link");
		By locator_partialLinkText=By.partialLinkText("partiallinktxt");
		By cssSelector=By.cssSelector("input[name=]");
		
		By locator_Xpath=By.xpath("//input[@name='q']");
		
		//javascript
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement searchBox=(WebElement)js.executeScript("return document.getElementByName('q')[0]", null);
	}*/
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
	
}
