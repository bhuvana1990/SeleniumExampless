package mavenPack.mavenProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.goair.in");
		WebElement link = driver.findElement(By.linkText("Web Check-In"));
		link.click();
		File linkFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(linkFile, new File("C:\\Users\\Quennie\\Desktop\\screenshots.png"));
	}
}
