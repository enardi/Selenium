package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetTitle {
	
		WebDriver driver;
		URL hubUrl;
		
		@BeforeMethod
		public void setUp() throws MalformedURLException{
		hubUrl = new URL("http://192.168.13.58:4444/wd/hub");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		driver = new RemoteWebDriver(hubUrl, cap);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		@Test
		public void getTitle() {
		driver.get("http://google.com");
		System.out.println("You are on " + driver.getTitle());
		driver.quit();
		}
		@AfterTest
		public void cleanUp() {
		
		}
	}
