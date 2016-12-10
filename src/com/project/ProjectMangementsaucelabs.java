package com.project;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProjectMangementsaucelabs {
	//public static final String username ="namrathareddy podduturi";
	//public static final String accesskey="b74db81a-9c67-47e2-85da-b7824ac7b4ff";
	public static final String url="https://namrathapodduturi:b74db81a-9c67-47e2-85da-b7824ac7b4ff@ondemand.saucelabs.com:443/wd/hub";
	WebDriver driver ;
	
	@Test
	public   void setup() throws MalformedURLException, InterruptedException{
		DesiredCapabilities	capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("version", "18");
		capabilities.setCapability("platform", "Android ");
		driver= new RemoteWebDriver(new URL(url),capabilities);
		driver.get("http://aristocratlabs.com/pmpgame/index.php");
		System.out.println(driver.getCurrentUrl());
		//Thread.sleep(2000);
	}
		@Test(priority=1)
		public void login() throws InterruptedException{
			//WebDriverWait wait = new WebDriverWait(driver, 300);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
			driver.findElement(By.xpath(".//*[@id='loginhere']/fieldset/div[2]/label"));
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("sudheerk");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("manager");
			driver.findElement(By.xpath(".//*[@id='loginhere']/fieldset/div[4]/div/button")).click();
			Thread.sleep(5000);
		}


		@Test(priority=2)
		public void profileupdate() throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver,300);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
			driver.findElement(By.id("user_name")).sendKeys("sudheerk");
			//driver.findElement(By.id(".//*[@id='user_name']")).sendKeys("namratha");
			driver.findElement(By.id("mobile")).sendKeys("8053870693");
			driver.findElement(By.id("two")).click();
			driver.findElement(By.id("country")).sendKeys("USA");
			driver.findElement(By.id("state")).sendKeys("california");
			driver.findElement(By.id("qualification")).sendKeys("student");
			driver.findElement(By.id("company")).sendKeys("abc");
			driver.findElement(By.id("department")).sendKeys("testing");
			driver.findElement(By.id("designation")).clear();
			driver.findElement(By.id("designation")).sendKeys("manager");
			driver.findElement(By.id("skills")).sendKeys("java");
			driver.findElement(By.id("hobbies")).sendKeys("playing");
			//	driver.findElement(By.xpath(".//*[@id='updateprofile']/fieldset/div[2]/div[5]/div")).click();
			driver.findElement(By.id("butupdate")).click();

			WebDriverWait wait1 = new WebDriverWait(driver, 15, 100);
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert  alert =driver.switchTo().alert();
			alert.accept();

		}
		@Test(priority=3)
		public void continueGame() throws InterruptedException{
			WebDriverWait wait1 = new WebDriverWait(driver, 30, 100);
			driver.findElement(By.xpath("//a[contains(.,'Continue to Game')]")).click();
			//driver.findElement(By.cssSelector("body > div.container > a")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//a[contains(.,' No Thanks, Continue to Game')]")).click();
			Thread.sleep(6000);
		}

		@Test(priority=4)
		public void quiz() throws InterruptedException{
			driver.findElement(By.xpath(".//*[@id='answer1'][2]")).click();
			Thread.sleep(50);
			driver.findElement(By.xpath(".//*[@id='answer2'][2]")).click();
			Thread.sleep(50);
			driver.findElement(By.xpath(".//*[@id='answer3'][2]")).click();
			Thread.sleep(50);
			driver.findElement(By.xpath(".//*[@id='submitvalue']")).click();
			
			//driver.findElement(By.xpath("//*[@id='first_popup']/div/div[2]/a")).click();
			

		}

	@Test(priority=5)
		public void logout() throws InterruptedException{
			Thread.sleep(5000);
		     driver.findElement(By.cssSelector("#first_popup > div > a.close")).click();
		    // driver.findElement(By.xpath("//img[contains(@src,'icon.png')]")).click();
			driver.findElement(By.xpath("//*[@id='headerregion']/div/div[2]/ul/li[5]/a/img")).click();
		}




		
		
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		ProjectMangementsaucelabs projectsaucelabs= new ProjectMangementsaucelabs();
		projectsaucelabs.setup();
		projectsaucelabs.login();
		projectsaucelabs.profileupdate();
		projectsaucelabs.continueGame();
		projectsaucelabs.quiz();
		projectsaucelabs.logout();
	}

}
