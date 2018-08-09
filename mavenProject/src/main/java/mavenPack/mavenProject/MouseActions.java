package mavenPack.mavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActions {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//mouseover action
	@Test(enabled=false)
	public void mouseOver() {
		driver.get("http://www.flipkart.com");
		driver.findElement(By.xpath("html/body/div[2]/div/div/button")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='container']/div/header/div[3]/div/ul/li[2]/a"))).perform();
		driver.findElement(By.linkText("Microwave Ovens")).click();
	}
	
	//dragdrop and dragandhold actions
	@Test(enabled=false)
	public void dragAndrop() throws Exception {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform(); //drag and drop
		
		action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform(); //drag and hold
		Thread.sleep(3000);
	}
	
	//sliding browser
	@Test(enabled=false)
	public void scrollBrowserWindow() {
		driver.get("https://jqueryui.com/droppable/");
		for(int i=0; i<10; i++) {
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,50)");
		}
	}
	
	//right click on element
	@Test(enabled=false)
	public void rightClick() {
		driver.get("https://jqueryui.com");
		WebElement ele = driver.findElement(By.linkText("Resizable"));
		Actions action= new Actions(driver);
		action.contextClick(ele).perform();
	}
	
	//moving the horizontal slider
	@Test(enabled = false)
	public void slider() {
		driver.get("https://jqueryui.com");
		driver.findElement(By.linkText("Slider")).click();
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(ele, 400, 0).perform();
	}
	
	//resizing an element
	@Test
	public void resizable() {
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='content']/iframe")));
		WebElement resize = driver.findElement(By.xpath(".//*[@id='resizable']/div[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(resize, 200, 20).perform();
	}
}
