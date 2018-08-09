package mavenPack.mavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webTable {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selctTable() {
		driver.get("http://www.aponline.gov.in/frptool/districtwisefranchisee_conslidated.aspx");
		WebElement selectState = driver.findElement(By.id("ddlState"));
		Select ss = new Select(selectState);
		ss.selectByIndex(1);
		
		WebElement selectDistrict = driver.findElement(By.id("ddlDistrict"));
		Select sd = new Select(selectDistrict);
		sd.selectByIndex(2);
		
		driver.findElement(By.id("Search")).click();
		driver.findElement(By.id("dgDistrictWiseFranchiseeDetails"));
		List<WebElement> table_tr = driver.findElements(By.xpath(".//*[@id='dgDistrictWiseFranchiseeDetails']/tbody/tr"));
		
		int row_num, col_num;
		 row_num =1;
		
		for(WebElement tr: table_tr) {
			List<WebElement> table_td = tr.findElements(By.xpath("td"));
			col_num =1;
			for(WebElement td: table_td) {
				System.out.println("Row"+row_num+" Column"+ col_num+" text"+td.getText());
				col_num++;
			}
			row_num++;
		}
		
		
	}
}
