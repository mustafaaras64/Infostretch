package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {		
		this.driver=driver;	
	}

	private By services = By.cssSelector("div[class*='suppa_menu_2']");
	private By digitalJourney = By.xpath("//div[@class='suppa_menu suppa_menu_html suppa_menu_1']");
	private By digitalLifecycleMethod = By.cssSelector("div[class='col-md-12 col-sm-12']>div>div>a>span");
	private By solutions = By.xpath("//a[@title='solutions'][1]");
	private By financialServices = By.xpath("//div[@class='col-sm-12 menu_left-col']/div/a/span");
	private By financialServicesText = By.xpath("//div[@class='container']/ul/li[5]/span");
	private By insights = By.xpath("//div[@class='suppa_menu suppa_menu_html suppa_menu_5']");
	private By contactUs = By.cssSelector("div[class='suppa_menu suppa_menu_dropdown suppa_menu_8']");
	
	
	public WebElement getServices() {
		return driver.findElement(services);
	}
	public WebElement getDigitalJourney() {
		return driver.findElement(digitalJourney);
	}
	public WebElement getDigitalLifecycleMethod() {
		return driver.findElement(digitalLifecycleMethod);
	}
	public WebElement getSolutions() {
		return driver.findElement(solutions);
	}
	public WebElement getFinancialServices() {
		return driver.findElement(financialServices);
	}
	public WebElement getFinancialServicesText() {
		return driver.findElement(financialServicesText);
	}
	public WebElement getInsights() {
		return driver.findElement(insights);
	}
	public WebElement getContactUs() {
		return driver.findElement(contactUs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
