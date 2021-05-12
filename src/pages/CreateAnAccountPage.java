package pages;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class CreateAnAccountPage extends MypediaHomePage{
	
	
	public void createAnAccountButtonIsDisabledOrNot()
	{			
		try {
			System.out.println("Validate 'Create An Account' button is disabled or not till user enters all field details");
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
			
			/*driver.findElement(By.xpath(xpath_userFname)).sendKeys("Dnyanesh");
			checkButtonVisibility();
			waitUntilElementVisibleXpath(xpath_userLname);
			driver.findElement(By.xpath(xpath_userLname)).sendKeys("Kale");
			checkButtonVisibility();
			waitUntilElementVisibleXpath(xpath_userEmailAddress);
			driver.findElement(By.xpath(xpath_userEmailAddress)).sendKeys("asdjhaskjdh@gmail.com");
			checkButtonVisibility();
			waitUntilElementVisibleXpath(xpath_userUsername);
			driver.findElement(By.xpath(xpath_userUsername)).sendKeys("zxcvbnmq");
			checkButtonVisibility();
			waitUntilElementVisibleXpath(xpath_userConfirmPassword);
			driver.findElement(By.xpath(xpath_userConfirmPassword)).sendKeys("zxcvbnmq");
			checkButtonVisibility();*/
			
			Thread.sleep(5000);
			List<WebElement> inputTextBoxes=driver.findElements(By.xpath(xpath_inputTextBoxes));
			
			Thread.sleep(2000);
			inputTextBoxes.get(0).sendKeys("Dnyanesh");
			checkButtonVisibility();
			Thread.sleep(2000);
			inputTextBoxes.get(1).sendKeys("Kale");
			checkButtonVisibility();
			Thread.sleep(2000);
			inputTextBoxes.get(2).sendKeys("kalednyaneshwar2784@gmail.com");
			checkButtonVisibility();
			Thread.sleep(2000);
			inputTextBoxes.get(3).sendKeys("abcdefgh");
			checkButtonVisibility();
			Thread.sleep(5000);
			
			List<WebElement> inputTestsPwds=driver.findElements(By.xpath(xpath_inputTextBoxesPwd));
			checkButtonVisibility();
			Thread.sleep(2000);
			inputTestsPwds.get(0).sendKeys("Test1234");
			checkButtonVisibility();
			Thread.sleep(2000);
			inputTestsPwds.get(1).sendKeys("Test1234");
			checkButtonVisibility();
			
			//river.findElement(By.xpath(xpath_createAccountButton));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void checkButtonVisibility()
	{
		waitUntilElementVisibleXpath(xpath_createAccountButton);
		
		WebElement adjshk=driver.findElement(By.cssSelector("style:contains(height: 36px; border-radius: 2px; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; top: 0px; padding-top: 8px; background-color: rgba(255, 255, 255, 0.08);"));
		
		boolean check=false;
		check=adjshk.isDisplayed();
		if (check) {
			 softAssert.assertTrue(check);
			System.out.println("Create An Account button is enabled");
		}
		else{
			softAssert.assertTrue(check);
			System.out.println("Create An Account button is disabled");
		}	
		
	}
}
