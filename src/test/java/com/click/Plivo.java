package com.click;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Plivo {

	WebDriver driver;

	@BeforeMethod
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Assignment() throws InterruptedException {

		// JavaScript Executor intialize
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions class initialize
		Actions act = new Actions(driver);

		// Launch the URl
		driver.get("http://quickfuseapps.com/");
		driver.findElement(By.id("link-create")).click();

		// Wait for button to become clickable
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath(".//button[contains(text(),'get started!')]"))))
				.click();
		driver.findElement(By.id("add-page")).click();
		// Entering the name of new page
		driver.findElement(By.xpath("//*[@id='create-dialog']//child::input")).sendKeys("Work On Progress!!");
		driver.findElement(By.xpath("//*[@id='create-dialog']/following-sibling::div/child::button[text()='Create']"))
				.click();
		// click on Message link from side bar
		driver.findElement(By.xpath("//*[@id='accordion']//a[contains(text(),'Messaging')]")).click();
		Thread.sleep(1000);

		// Drag and Dropping the SMS Box
		act.dragAndDrop(driver.findElement(By.xpath("//*[@id='accordion']//li[contains(.,'Send an SMS')]")),
				driver.findElement(By.xpath("//*[@id='tabs-2']"))).build().perform();
		Thread.sleep(2000);

		// Performing connecting line to Module 1 from Start
		WebElement start = driver
				.findElement(By.xpath("//*[@id='tabs-2']/child::div[@id='module-1']//div[starts-with(@id,'node-')]"));
		WebElement FstTop = driver.findElement(
				By.xpath("//*[@id='tabs-2']/child::div[@id='module-2']/child::div//div[starts-with(@id,'rec-')]"));
		act.dragAndDrop(start, FstTop).build().perform();

		// Filling the Phone number and Text
		driver.findElement(By
				.xpath("//*[@id='tabs-2']//div[contains(text(),'Phone number:')]/following-sibling::div/child::textarea"))
				.sendKeys("9192939495");

		driver.findElement(By
				.xpath("//*[@id='tabs-2']//table[.//th[contains(.,'Message Text or Variable')]]//a[@title='Toggle between using a variable or a constant']/following-sibling::textarea"))
				.sendKeys("A Important message");

		// Drag and Dropping the Email Box
		act.dragAndDrop(driver.findElement(By.xpath("//*[@id='accordion']//li[contains(.,'Send an Email')]")),
				driver.findElement(By.xpath("//*[@id='tabs-2']"))).build().perform();
		Thread.sleep(2000);

		// Placing the Email Box
		js.executeScript(
				"document.getElementById('module-3').setAttribute('style','top: 233px; left: 690px; display: block; z-index: 1006;');");

		// Enter SMTP Host
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'SMTP Host:')]/following-sibling::div/input"))
				.sendKeys("smtp.gmail.com");
		// Enter Port
		driver.findElement(
				By.xpath("//*[@id='module-3']/descendant::div[contains(text(),'Port:')]/following-sibling::div/input"))
				.sendKeys("465");
		// Enter UserName
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'Username:')]/following-sibling::div/input"))
				.sendKeys("abc@gmail.com");
		// Enter Password
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'Password:')]/following-sibling::div/input"))
				.sendKeys("Password");
		// From
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'From:')]/following-sibling::div//textarea"))
				.sendKeys("abc@gmail.com");
		// To
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'To:')]/following-sibling::div//textarea"))
				.sendKeys("xyz@gmail.com");
		// Subject
		driver.findElement(By
				.xpath("//*[@id='module-3']/descendant::div[contains(text(),'Subject:')]/following-sibling::div//textarea"))
				.sendKeys("Sms not sent");
		// Message
		driver.findElement(By
				.xpath("//*[@id='module-3']//table[.//th[contains(.,'Message Text or Variable')]]//a[@title='Toggle between using a variable or a constant']/following-sibling::textarea"))
				.sendKeys("Sms to phone on 9192939495 not sent");

		// Perform Connection of Module 1 to Module 2
		WebElement FstNotSnt = driver
				.findElement(By.xpath("//*[@id='module-2']/descendant::div[text()='Sent']/preceding-sibling::div[2]"));
		WebElement ScndTop = driver.findElement(
				By.xpath("//*[@id='tabs-2']/child::div[@id='module-3']/child::div//div[starts-with(@id,'rec-')]"));
		act.dragAndDrop(FstNotSnt, ScndTop).build().perform();

		// Clicking on Basics
		driver.findElement(By.xpath("//*[@id='accordion']//a[contains(text(),'Basic')]")).click();

		// Drage and dropping the Exit box.
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@id='accordion']//li[contains(.,'Hang Up or Exit')]/a"))))
				.click();
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@id='accordion']//li[contains(.,'Hang Up or Exit')]/a"))))
				.click();
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@id='accordion']//li[contains(.,'Hang Up or Exit')]/a"))))
				.click();
		Thread.sleep(2000);
		js.executeScript(
				"document.getElementById('module-4').setAttribute('style','top: 319px; left: 130px; display: block; z-index: 1006;');");

		js.executeScript(
				"document.getElementById('module-5').setAttribute('style','top: 523px; left: 400px; display: block; z-index: 1005;');");

		js.executeScript(
				"document.getElementById('module-6').setAttribute('style','top: 453px; left: 921px; display: block; z-index: 1006;');");

		// Perform Connection of Module 2 NotSent to Exit
		WebElement FstSnt = driver
				.findElement(By.xpath("//*[@id='module-2']/descendant::div[text()='Sent']/preceding-sibling::div[3]"));
		WebElement Exit1 = driver.findElement(By.xpath("//*[@id='module-4']/descendant::div[starts-with(@id,'rec')]"));
		act.dragAndDrop(FstSnt, Exit1).build().perform();

		// Perform Connection of Module 2 Sent to Exit
		WebElement ScndSnt = driver
				.findElement(By.xpath("//*[@id='module-3']/descendant::div[text()='Sent']/preceding-sibling::div[3]"));
		WebElement Exit2 = driver.findElement(By.xpath("//*[@id='module-5']/descendant::div[starts-with(@id,'rec')]"));
		act.dragAndDrop(ScndSnt, Exit2).build().perform();

		// Perform Connection of Module 2 NotSent to Exit
		WebElement ScndNotSnt = driver
				.findElement(By.xpath("//*[@id='module-3']/descendant::div[text()='Sent']/preceding-sibling::div[2]"));
		WebElement Exit3 = driver.findElement(By.xpath("//*[@id='module-6']/descendant::div[starts-with(@id,'rec')]"));
		act.dragAndDrop(ScndNotSnt, Exit3).build().perform();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
