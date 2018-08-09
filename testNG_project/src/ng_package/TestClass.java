package ng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestClass {
  @Test (groups= {"regression","smoke"})
  public void f() {
	  System.out.println("I am test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("i am before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("i am after method");
  }

}
