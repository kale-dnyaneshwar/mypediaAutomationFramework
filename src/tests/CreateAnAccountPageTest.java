package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;

public class CreateAnAccountPageTest extends CreateAnAccountPage{
	
	@Test
	public void createAnAccountButtonIsDisabledOrNotTest(){
		createAnAccountButtonIsDisabledOrNot();
	}
	
	@DataProvider(name ="Authentication")
  	public Object[][] excelDP() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData(excelSheetFilePath,sheetName);
        	return arrObj;
  	}
	
	@Test(dataProvider="Authentication")
	public void createAnAccountOnMypediaWithDiffTypeOfDataTest(String userFname, String userLname, String userEmail, String userUserName, String userPassword, String userConfirmPassword)	
	{
		System.out.println("Validating create an account with different types of data");
		
		try {
			
			System.out.println("Create an account on mypedia.com");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
			Thread.sleep(5000);
			
			screen.wait(mypediahomepagepopupClose, 30);		
			screen.click(mypediahomepagepopupClose);
			
			waitUntilElementVisibleXpath(xpath_setUpParentSupportLink);
			driver.findElement(By.xpath(xpath_setUpParentSupportLink)).click();
			
			waitUntilElementVisibleXpath(xpath_createANewAccount);
			driver.findElement(By.xpath(xpath_createANewAccount)).click();
			
			waitUntilElementVisibleXpath(xpath_signIn);
						
			Thread.sleep(5000);
			List<WebElement> inputTextBoxes=driver.findElements(By.xpath(xpath_inputTextBoxes));
			
			Thread.sleep(2000);
			inputTextBoxes.get(0).sendKeys(userFname);

			Thread.sleep(2000);
			inputTextBoxes.get(1).sendKeys(userLname);

			Thread.sleep(2000);
			inputTextBoxes.get(2).sendKeys(userEmail);

			Thread.sleep(2000);
			inputTextBoxes.get(3).sendKeys(userUserName);

			Thread.sleep(5000);
			List<WebElement> inputTestsPwds=driver.findElements(By.xpath(xpath_inputTextBoxesPwd));
			
			Thread.sleep(2000);
			inputTestsPwds.get(0).sendKeys(userPassword);
			
			Thread.sleep(2000);
			inputTestsPwds.get(1).sendKeys(userConfirmPassword);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
