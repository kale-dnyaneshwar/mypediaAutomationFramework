package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends Constants{
	public static WebDriver driver = null;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in beforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in beforeClass");
	}

	/*
	 * @BeforeMethod public void beforeMethod() {
	 * System.out.println("in beforeMethod");
	 * 
	 * }
	 */
	/*
	 * public static WebDriver get(){ System.out.println("in before Method");
	 * 
	 * WebDriver driver = new FirefoxDriver(); DesiredCapabilities capabilities
	 * = DesiredCapabilities.firefox();
	 * capabilities.setCapability("marionette",true);
	 * System.setProperty("webdriver.gecko.driver","Data\\geckodriver.exe" );
	 * 
	 * return driver; }
	 */

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUpDriver(@Optional("browser") String browser) {
		System.out.println("in beforeMethod");

		if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			System.setProperty("webdriver.gecko.driver",
					"Data\\geckodriver.exe");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"Data\\chromedriver.exe");
		}

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("in afterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in afterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in afterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite");
	}

	public String[][] getExcelData(String fileName, String sheetName) {

		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow row = sh.getRow(0);
			int noOfRows = sh.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			System.out.println("Number of rows: " + noOfRows);
			System.out.println("Number of rows: " + noOfCols);
			Cell cell;
			data = new String[noOfRows - 1][noOfCols];

			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					row = sh.getRow(i);
					cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue();
				}
			}
		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}

}
