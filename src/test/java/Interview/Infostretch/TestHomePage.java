package Interview.Infostretch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.HomePage;
import resources.Base;

public class TestHomePage extends Base{
	public WebDriver driver;
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
	}

	@Test
	public void testCase1() {
		HomePage hp = new HomePage(driver);
		
		Actions a = new Actions(driver);
		a.moveToElement(hp.getDigitalJourney()).build().perform();
		hp.getDigitalLifecycleMethod().click();
		
		String currentUrl= driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.infostretch.com/digital-lifecycle-methodology/");
		System.out.println("Digital Life Cycle Method button successfully validated. ");
	}

	@Test
	public void testCase2() {
		HomePage hp = new HomePage(driver);
		String text = hp.getServices().getText();
		Assert.assertEquals(text, "SERVICES");
		System.out.println("SERVICES text successfully validated.");
	}
	
	@Test
	public void testCase3() {
		HomePage hp = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(hp.getSolutions()).build().perform();
		hp.getFinancialServices().click();
		String text = hp.getFinancialServicesText().getText();
		Assert.assertEquals(text, "FINANCIAL SERVICES");
		System.out.println("FINANCIAL SERVICES text successfully validated.");
	}
	
	@Test
	public void testCase4() {
		HomePage hp = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(hp.getInsights()).build().perform();
		
		String string1 = "//div[@class='menu_mobile left-menu-height-5']//a[";
		String string2 = "]/span";
		
		for(int i=1; i<=9; i++) {	
		WebElement element = driver.findElement(By.xpath(string1 + i + string2));
		System.out.print(element.getText() + ",  ");
		}
	}

	@Test
	public void testCase5() {
		HomePage hp = new HomePage(driver);
		hp.getContactUs().click();
		String url = driver.getCurrentUrl();
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(url, "https://www.infostretch.com/about/contact-us/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	
}
