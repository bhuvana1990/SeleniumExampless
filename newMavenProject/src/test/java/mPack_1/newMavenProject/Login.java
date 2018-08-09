package mPack_1.newMavenProject;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Login extends BasePage {
	
  LoginPageUI page;
  @BeforeMethod
  public void startProcess() throws Exception {
	  
	  BrowserLaunch(getData("browser"), getData("url"));
  }

  @Test(enabled=false)
  public void login() {
	  page = new LoginPageUI(driver);
	  page.loginVerification();
	  Assert.assertEquals(page.loginErrorVerification(), "Invalid password.");
  }
  
  @Test
  public void registration() throws Exception {
	  page = new LoginPageUI(driver);
	  page.customerRegistration();
  }
  
  @AfterMethod
  public void endProcess() {
//	  driver.close();
  }

}
