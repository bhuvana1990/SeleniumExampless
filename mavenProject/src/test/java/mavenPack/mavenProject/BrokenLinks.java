package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLinks {
  
WebDriver driver;  
  
  @BeforeMethod
  public void setup() 
  {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
  }
  
  
  @Test
  public void brokenLinks() 
  {
	
	 driver.get("http://newtours.demoaut.com");
	 
	 List<WebElement> links = driver.findElements(By.tagName("a"));
	 System.out.println("Total Links :" + links.size());
	 
	 for(int i=0;i<links.size();i++)
	 {
		 
		 String url=links.get(i).getAttribute("href");
		 
		 verifyLinkActive(url);
	 }
  }
  
  public static void verifyLinkActive(String linkUrl)
	{
      try 
      {
    	  
    	  
         URL url = new URL(linkUrl);
         
         HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
         
         httpURLConnect.setConnectTimeout(3000);
         
         httpURLConnect.connect();
         
         if(httpURLConnect.getResponseCode()==200)
         {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
         }
        if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) 
         {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
          }
      } catch (Exception e) {
         
      }
  }   
  
  

  @AfterMethod
  public void teardown() 
  {
	  driver.quit();
  }

}
