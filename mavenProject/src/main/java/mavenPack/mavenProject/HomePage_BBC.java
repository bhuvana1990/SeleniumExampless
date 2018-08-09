package mavenPack.mavenProject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_BBC extends RandomClick_BBC{

	@FindBy(xpath="//*[@id='page']/section[5]/div/div/div[2]/div/ul") public WebElement listEle;
	@FindBy(xpath = "//*[@id='page']/section[5]/div/div/div[2]/div/ul/li") public List<WebElement> listItems;

	public HomePage_BBC(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loadPage(WebDriver driver) throws Exception {
		randomList(listItems,listEle, driver);
	}
	
}
