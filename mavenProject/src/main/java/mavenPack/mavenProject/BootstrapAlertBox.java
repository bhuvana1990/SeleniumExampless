package mavenPack.mavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapAlertBox {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://www.espncricinfo.com");
		driver.get("http://www.hdfcbank.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void closeModal() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("vizury-notification-template"));
		driver.switchTo().frame("vizury-notification-template");
		driver.findElement(By.id("div-close")).click();
	}
	
	@Test(enabled=false)
	public void alertClose() throws Exception {
//		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='sideLogin-left-rail']/button[1]")).click();
		driver.switchTo().frame("disneyid-iframe");
		Thread.sleep(5000);
		driver.findElement(By.id("close")).click();
//		System.out.println(a.getText());
		
//		driver.findElement(By.xpath("//[@id='mySMS']/div/div/div[1]/button")).click();
	}
	
	@AfterMethod
	public void closeSetup() {
		
	}
}
