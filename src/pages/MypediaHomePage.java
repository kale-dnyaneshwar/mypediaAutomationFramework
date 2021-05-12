package pages;

import java.util.ArrayList;
import java.util.List;






import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import util.Action;
import util.BaseTest;

public class MypediaHomePage extends Action {

	// //div[@id='divMain']/div/div[@id='contentDiv']/div/div[@class='topText']
	public static final String expectedUrl_OnHomePage="https://www.mypedia.pearson.com/login";
	public static final String expectedWelcomeText="Introducing Parent Accounts";
	public static final String expectedTitle="MyPedia";
	public static final String mypediahomepagepopupCloseImage="C:\\Users\\dkale\\Desktop\\Sikuli\\mypediahomepagepopupClose.PNG";
	
	
	public String homePagePopUp = "//div[@id='divMain']";
	public String homePagePopUpText = "//div[@id='divMain']/div/div[@id='contentDiv']/div/div[@class='topText']";
	

	public String xpath_accountDetailsLang="//div[@class='accountDetailsLangDropDownWrap']";
	public String xpath_accountDetailsLangDropDownListDiv="//div[@role='menu']/div/span[@role='menuitem']/div/div/div";
	public String xpath_accountDetailsLangDropDownLists="//div[@role='menu']/div/span[@role='menuitem']/div/div/div";
	public String xpath_accountDetailsLangDropDownList="//div[@role='menu']/div/span[@role='menuitem']/div/div/div";
	public String xpath_continueButtonText="//button[@id='SI_0005']/div/div";
	public String xpath_setUpParentSupportLink="//a[contains(text(),'Set up parent support')]";	
	public String xpath_createANewAccount="//div/span[contains(text(),'CREATE A NEW ACCOUNT')]";
	public String xpath_signIn="//a[contains(text(),'Sign in')]";
	
	public String xpath_userFname="//input[@id='undefined-undefined-Firstname-44838']";
	public String xpath_userLname="//input[@id='undefined-undefined-Lastname-36187']";
	public String xpath_userEmailAddress="//input[@id='undefined-undefined-Emailaddress-31803']";
	public String xpath_userUsername="//input[@id='undefined-undefined-Createparentusername-18691";
	public String xpath_userPassword="//input[@id='undefined-undefined-Createparentpassword-7102";
	public String xpath_userConfirmPassword="//input[@id='undefined-undefined-Confirmpassword-12262";
	public String xpath_createAccountButton="//*[@id='main']/div/div[5]/div/button";
	
	public String xpath_welcomeText="//*[@id='contentDiv']/div/div[1]";
	
	public String xpath_inputTextBoxes="//input[@type='text']";
	public String xpath_inputTextBoxesPwd="//input[@type='password']";
	
	
	SoftAssert softAssert = new SoftAssert();
	public Screen screen = new Screen();
	String languageType;
	public Pattern mypediahomepagepopupClose = new Pattern(mypediahomepagepopupCloseImage);
	
	
	public void validateMypediaWebsiteLoadsOrNot() 
	{
		try {

			driver = new ChromeDriver();
			driver.get(url);
			Thread.sleep(5000);						
			driver.manage().window().maximize();			
			Thread.sleep(5000);			
			
			//Pattern mypediahomepagepopupDoneLink = new Pattern("C:\\Users\\dkale\\Desktop\\Sikuli\\mypediahomepagepopupDoneLink.PNG");
			
			
						
			softAssert.assertEquals(driver.getCurrentUrl(), expectedUrl_OnHomePage);			
			
	        Thread.sleep(5000);
	        driver.switchTo().frame("contentIframe");
	        Thread.sleep(5000);
	        String welcomePagetext = driver.findElement(By.xpath(xpath_welcomeText)).getText();
	        
	        System.out.println(welcomePagetext);
	        softAssert.assertEquals(welcomePagetext, expectedWelcomeText);
	        
	        System.out.println(driver.getTitle());
	        softAssert.assertEquals(driver.getTitle(), expectedTitle);
	        
			screen.wait(mypediahomepagepopupClose, 30);
			
			screen.click(mypediahomepagepopupClose);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
	}

		
	public void confirmLanguageDropdownHasThreeLanguages()
	{
		try {			
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//Pattern mypediahomepagepopupClose = new Pattern("C:\\Users\\dkale\\Desktop\\Sikuli\\mypediahomepagepopupClose.PNG");
		screen.wait(mypediahomepagepopupClose, 30);		
		screen.click(mypediahomepagepopupClose);
		
		waitUntilElementVisibleXpath(xpath_accountDetailsLang);
		Thread.sleep(5000);
		driver.findElement(By.xpath(xpath_accountDetailsLang)).click();
		
		Thread.sleep(5000);
		waitUntilElementVisibleXpath(xpath_accountDetailsLangDropDownListDiv);
		
	
		List<String> languages= new ArrayList<String>();
		languages.add("English");
		languages.add("हिंदी");
		languages.add("Español");
		
		
		List<WebElement> elements=driver.findElements(By.xpath(xpath_accountDetailsLangDropDownList));
		
		System.out.println("Validating language dropdown has three languages");
		for (int i = 0; i < elements.size(); i++) 
		{
			softAssert.assertEquals(elements.get(i).getText(), languages.get(i));				
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void validateContinueButtonChangesToSelectedLanguage()
	{
		try {			
			
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
			Thread.sleep(5000);
			//Pattern mypediahomepagepopupClose = new Pattern("C:\\Users\\dkale\\Desktop\\Sikuli\\mypediahomepagepopupClose.PNG");
			screen.wait(mypediahomepagepopupClose, 30);		
			screen.click(mypediahomepagepopupClose);
			
			/*waitUntilElementVisibleXpath(xpath_accountDetailsLang);
			Thread.sleep(5000);
			driver.findElement(By.xpath(xpath_accountDetailsLang)).click();
			
			Thread.sleep(5000);
			waitUntilElementVisibleXpath(xpath_accountDetailsLangDropDownListDiv);*/
			
			/*List<String> languages= new ArrayList<String>();
			languages.add("English");
			languages.add("हिंदी");
			languages.add("Español");
		
			*/
			
			List<WebElement> elements=driver.findElements(By.xpath(xpath_accountDetailsLangDropDownList));
			
			System.out.println("Validating continue button text changes to the selected language or not");
			for (int i = 0; i < elements.size(); i++) 
			{
				
				waitUntilElementVisibleXpath(xpath_accountDetailsLang);
				Thread.sleep(5000);
				driver.findElement(By.xpath(xpath_accountDetailsLang)).click();
				
				List<WebElement> languages1=driver.findElements(By.xpath(xpath_accountDetailsLangDropDownLists));
				languages1.get(i).click();
				
				
				List<String> languages= new ArrayList<String>();
				languages.add("CONTINUE");
				languages.add("अग्रसर रहें");
				languages.add("Continuar");
				
				Thread.sleep(5000);
				elements.get(i).click();
				
				
				Thread.sleep(5000);
				languageType=driver.findElement(By.xpath(xpath_continueButtonText)).getText();
				
				
				softAssert.assertEquals(languages.get(i), languageType);
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		
	}
	

}
