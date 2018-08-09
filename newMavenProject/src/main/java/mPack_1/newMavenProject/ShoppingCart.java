package mPack_1.newMavenProject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends BasePage{
	
	@FindBy(id="homefeatured") public WebElement itemsList;
	@FindBy(xpath="//*[@id='homefeatured']/li") public List<WebElement> list;
	@FindBy(xpath="//a[@title='Women']") public WebElement menuTab;
	@FindBy(xpath=".//*[@id='center_column']/ul/li") public List<WebElement> womenCategory;
	@FindBy(css= "a[href*='id_product=2']") public WebElement listEle;
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a") public WebElement ajaxAddToCartBtn;
	@FindBy(id="add_to_cart") public WebElement addToCartBtn;
	@FindBy(xpath="//a[@title ='Proceed to checkout']") public WebElement proceedBtn;
	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]") public WebElement proceed;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/span") public WebElement continueBtn;
	@FindBy(id="email") public WebElement email;
	@FindBy(id="passwd") public WebElement password;
	@FindBy(id="SubmitLogin") public WebElement submitBtn;
	
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addToCart(WebDriver driver) throws Exception {
		
		randomListLoad(list);
//		list.click();
		addToCartBtn.click();
//		waitForElement(continueBtn, 30);
		Thread.sleep(5000);
		continueBtn.click();
		Thread.sleep(5000);
//		driver.navigate().back();
//		randomListLoad(womenCategory);
		menuTab.click();
		randomListLoad(womenCategory);
		ajaxAddToCartBtn.click();
//		addToCartBtn.click();
		Thread.sleep(5000);
		proceedBtn.click();
		Thread.sleep(10000);
//		waitForElement(proceed, 30);
		proceed.click();
		Thread.sleep(2000);
		email.sendKeys("bhu123@gmail.com");
		password.sendKeys("123");
		submitBtn.click();
//		Thread.sleep(2000);
		
	}
}
