package mavenPack.mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

	WebDriver driver;
	boolean flag=true;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("C:\\Users\\Quennie\\Desktop\\input.html");
	}

	@Test
	public void autoit() throws Exception {
		driver.findElement(By.id("1")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Quennie\\Documents\\FileUpload.exe");
	}
	
	@AfterMethod
	public void endApp() {
		
	}
}
