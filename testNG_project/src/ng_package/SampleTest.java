package ng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class SampleTest extends BasePage {
  
  @BeforeMethod
  public void startProcess() throws Exception {
	  BrowserLaunch(getData("browser"), getData("amazonurl"));
  }

  @Test(groups= {"regression"})
  public void login() {
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harrypotter");;
  }
  
  @AfterMethod
  public void endProcess() {
//	  driver.close();
  }

}
