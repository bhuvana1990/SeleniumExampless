package mPack_1.newMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCart {
	
	@FindBy(id="homefeatured") public WebElement itemsList;
	@FindBy(xpath=".//*[@id='homefeatured']/li") public WebElement list;
	@FindBy(xpath="//a[@title='Printed Dress']") public WebElement listEle;
	@FindBy(xpath= "//*[@id='add_to_cart']/button") public WebElement addToCartBtn;
	@FindBy(xpath="//a[@title ='Proceed to checkout']") public WebElement proceedBtn;
	@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a") public WebElement proceedButton;
	@FindBy(xpath="//a[@title ='View my shopping cart']") public WebElement shoppingCart;
	@FindBy(xpath="//span[@title='Continue shopping']") public WebElement continueBtn;
//	@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span") public WebElement popUpContinue;
	
	@FindBy(id="email") public WebElement email;
	@FindBy(id="passwd") public WebElement password;
	@FindBy(id="SubmitLogin") public WebElement submitBtn;
	
//	public Shopcart(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}

	public void addToCart(WebDriver driver) throws Exception {
		
		//selecting an item from the list
		list.click();
		addToCartBtn.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//continue shopping
		continueBtn.click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		//selecting another item from the list
		listEle.click();
		addToCartBtn.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//proceed to checkout
		proceedBtn.click();
		
//		shoppingCart.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		proceedButton.click();
//		Thread.sleep(2000);
//		email.sendKeys("bhu123@gmail.com");
//		password.sendKeys("123");
//		submitBtn.click();
//		Thread.sleep(2000);
		
	}
}
