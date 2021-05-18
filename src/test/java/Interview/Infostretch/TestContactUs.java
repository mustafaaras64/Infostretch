package Interview.Infostretch;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.ContactUs;
import pageObject.HomePage;
import resources.Base;

public class TestContactUs extends Base{

public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
	}
	
	@Test
	public void testCase6() {
		HomePage hp = new HomePage(driver);
		hp.getContactUs().click();
		
		ContactUs cu = new ContactUs(driver);
		cu.getFirstName().sendKeys("Mustafa");
		cu.getLastName().sendKeys("Aras");
		cu.getEmail().sendKeys("Infostretch@gmail.com");
		cu.getPhone().sendKeys("+1111111111");
		cu.getCompanyName().sendKeys("Infostretch");
		
		cu.getCountry().click();
		String string1 = "//ul/li/div/input[@value='";
		String string2 = "']";
		
		//You can change selectCountry string as what you want!
		String selectCountry = "Albania";
		WebElement element = driver.findElement(By.xpath(string1 + selectCountry + string2));
		element.click();
		
		//cu.getRadioButton().click();
		//cu.getSubmit().click();
		}
	
	@Test
	public void testCase7() {
		driver.navigate().refresh();
		ContactUs cu = new ContactUs(driver);
		cu.getFirstName().sendKeys(Keys.chord(Keys.TAB));
		String warning = cu.getWarning().getText();
		System.out.println(warning);
		}
	
	@Test
	public void testCase8() {
		driver.navigate().refresh();
		ContactUs cu = new ContactUs(driver);
		String placeholder=cu.getFirstName().getAttribute("placeholder");
		
		Assert.assertEquals(placeholder, "FIRST NAME *");
		System.out.println("Placeholder successfully validated");
		driver.navigate().refresh();
		}
	
	
	@Test(dataProvider="getData")	
	public void testCase9 (String firstname, String lastname)  throws IOException {
		ContactUs cu = new ContactUs(driver);
		cu.getFirstName().sendKeys(firstname);
		cu.getLastName().sendKeys(lastname);
		driver.navigate().refresh();
		}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][0]="Mustafa";
		data[0][1]="Aras";
		return data;	
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	}
	
	