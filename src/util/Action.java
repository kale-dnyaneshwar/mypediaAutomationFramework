package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action extends BaseTest
{
	public void waitUntilElementVisibleXpath(String locatorname){

		try{
			Boolean value= (new WebDriverWait(driver, 120)).until(ExpectedConditions.elementToBeClickable((By.xpath(locatorname)))).isDisplayed();

			if (value.FALSE){
				System.out.println("Element not found: "+locatorname);
			}
			else {
			System.out.println("Element Present: "+ locatorname);
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void waitUntilElementVisibleXpath1(String locatorname) throws TimeoutException, NoSuchElementException{

		try{
			Boolean value= (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((By.xpath(locatorname)))).isDisplayed();

			if (value.FALSE){
				System.out.println("Element not found: "+locatorname);
			}
			else {
			System.out.println("Element Present: "+ locatorname);
			}

		}
		catch(Exception e){
			e.getMessage();
		}

	}

}