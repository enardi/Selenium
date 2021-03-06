package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickFirstEntry {
	
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
		public void search() {
			driver.get("http://google.com");
			System.out.println("You are on " + driver.getTitle());
			driver.findElement(By.xpath("/html/body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[@class='tsf-p']/div[@class='sfibbbc']/div[@id='sbtc']/div[@class='sbibtd']/div[@id='sfdiv']/div[@class='lst-c']/div[@class='gstl_0 sbib_a']/div[@id='sb_ifc0']/div[@id='gs_lc0']/input[@id='lst-ib']")).sendKeys("Solstice Chicago");
			driver.findElement(By.xpath("/html/body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[@class='tsf-p']/div[@class='sfibbbc']/div[@id='sbtc']/div[@class='sbibtd']/div[@id='sfdiv']/div[@class='lst-c']/div[@class='gstl_0 sbib_a']/div[@id='sb_ifc0']/div[@id='gs_lc0']/input[@id='lst-ib']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("/html/body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw'][2]/div[@id='rcnt']/div[@class='col'][1]/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='ires']/div[@id='rso']/div[@class='bkWMgd'][1]/div[@class='srg']/div[@class='g'][1]/div/div[@class='rc']/h3[@class='r']/a")).click();
			System.out.println("You are at " + driver.getTitle());
			driver.quit();
		}
		@AfterTest
		public void cleanUp() {
		
		}
	}
