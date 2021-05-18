package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {

	public WebDriver driver;

	public ContactUs(WebDriver driver) {		
		this.driver=driver;	
	}

	
	private By firstName = By.id("cont_first_name");
	private By lastName = By.name("cont_last_name");
	private By email = By.xpath("//input[@type='email']");
	private By phone = By.id("cont_phone_number");
	private By companyName = By.name("cont_company_name");
	private By country = By.id("cont_selectcountry");
	private By radioButton = By.cssSelector("label[for='cont_ifs_updates']");
	private By submit = By.id("submit");
	private By warning = By.cssSelector("label[for='cont_first_name']");
	
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPhone() {
		return driver.findElement(phone);
	}
	public WebElement getCompanyName() {
		return driver.findElement(companyName);
	}
	public WebElement getCountry() {
		return driver.findElement(country);
	}
	public WebElement getRadioButton() {
		return driver.findElement(radioButton);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	public WebElement getWarning() {
		return driver.findElement(warning);
	}
	
	
}
