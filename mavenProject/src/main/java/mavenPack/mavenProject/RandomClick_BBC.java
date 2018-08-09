package mavenPack.mavenProject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomClick_BBC 
{
	
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    }
    
    public void randomList(List<WebElement> element, WebElement ele, WebDriver driver) throws Exception {
    	int length = element.size();
		for(int i=0; i < length; i++) {
			Random list = new Random();
			element.get(list.nextInt(length)).click();
			Thread.sleep(15000);
			
			//re-declaring the elements as it looses the memory after navigation
			driver.get("http://www.bbc.com");
			Thread.sleep(5000);
			ele = driver.findElement(By.xpath("//*[@id=\"page\"]/section[5]/div/div/div[2]/div/ul")); 
			element = driver.findElements(By.xpath("//ul[@class='top-list__list']/li"));
			
		}
	}
}
