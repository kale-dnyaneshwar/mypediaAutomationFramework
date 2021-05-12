package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MypediaHomePage;

public class MypediaHomePageTest extends MypediaHomePage {
	//Screen screen = new Screen();
	SoftAssert softassert= new SoftAssert();
	
	@Test
	public void validateMypediaWebsiteLoadsOrNotTest() {
		validateMypediaWebsiteLoadsOrNot();
	}

	@Test
	public void confirmLanguageDropdownHasThreeLanguagesTest() {
		confirmLanguageDropdownHasThreeLanguages();
	}

	@Test
	public void validateContinueButtonChangesToSelectedLanguageTest() {
		validateContinueButtonChangesToSelectedLanguage();
	}

	
	public void validateCreateAnAccountButtonIsDisabledOrNot() throws InterruptedException, FindFailed
	{
		System.out.println("validate Create An Account button is disabled or not");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//Pattern mypediahomepagepopupClose = new Pattern("C:\\Users\\dkale\\Desktop\\Sikuli\\mypediahomepagepopupClose.PNG");
		screen.wait(mypediahomepagepopupClose, 30);		
		screen.click(mypediahomepagepopupClose);
		
		waitUntilElementVisibleXpath(xpath_setUpParentSupportLink);
		driver.findElement(By.xpath(xpath_setUpParentSupportLink)).click();
		
		waitUntilElementVisibleXpath(xpath_createANewAccount);
		driver.findElement(By.xpath(xpath_createANewAccount)).click();
		
		waitUntilElementVisibleXpath(xpath_signIn);
					
		Thread.sleep(5000);
		List<WebElement> inputTests=driver.findElements(By.xpath("//input[@type='text']"));
		
		Thread.sleep(2000);
		inputTests.get(0).sendKeys("fname");

		Thread.sleep(2000);
		inputTests.get(1).sendKeys("lname");

		Thread.sleep(2000);
		inputTests.get(2).sendKeys("fnamelname@gmail.com");

		Thread.sleep(2000);
		inputTests.get(3).sendKeys("zxcvbnmq");

		Thread.sleep(5000);
		List<WebElement> inputTestsPwds=driver.findElements(By.xpath("//input[@type='password']"));
		
		Thread.sleep(2000);
		inputTestsPwds.get(0).sendKeys("Test1234");
		
		Thread.sleep(2000);
		inputTestsPwds.get(1).sendKeys("Test1234");

		waitUntilElementVisibleXpath(xpath_createAccountButton);
		
		softassert.assertTrue(driver.findElement(By.xpath(xpath_createAccountButton)).isDisplayed());
		
		softassert.assertAll();
	}
	
}
