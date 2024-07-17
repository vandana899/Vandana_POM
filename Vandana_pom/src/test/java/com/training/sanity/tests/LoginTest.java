package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.training.generics.Screenshot;
import com.training.generics.Screenshot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Screenshot screenShot;
	



	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		screenShot = new Screenshot(driver);
		
		baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@org.testng.annotations.Test
	public void loginPassTest() throws IOException {
		loginPOM.sendUserName("Admin");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("first");
		
	}

}
