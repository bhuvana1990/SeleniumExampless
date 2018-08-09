package ng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class newTest_1 {
  @Test
  public void orange() {
	  System.out.println("orange");
  }
  
  @Test(dependsOnMethods= {"orange"})
  public void white() {
	  System.out.println("white");
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods= {"white"})
  public void blue() {
	  System.out.println("blue");
  }
  
  @Test(dependsOnMethods = {"blue"})
  public void green() {
	  System.out.println("green");
  }
  
}
