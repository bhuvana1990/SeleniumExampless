package ng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class newClass extends BasePage {
  
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String str) throws Exception {
	  BrowserLaunch(str,getData("amazonurl"));
  }

  @Test(groups= {"regression", "smoke"})
  public void login() {
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harrypotter");;
  }
  
  @AfterMethod
  public void endProcess() {
//	  driver.close();
  }

}
