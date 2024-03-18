package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletHomePage;
import com.utility.yamlReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.driverInstance.DriverManager;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import com.utility.LoggingUtils;
import org.testng.annotations.BeforeTest;

import static com.utility.ExtentReporter.platform;
import static com.utility.Utilities.*;

public class BaseClass {

	static String oSPlatformName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName();
	public static LoggingUtils logger = new LoggingUtils();
	public static PropertyFileReader prop;
	public static PropertyFileReader shopsafeprop;
	public static PropertyFileReader gcashprop;
	public static yamlReader yamlReader;
	public static String os = System.getProperty("os.name").toLowerCase();
	public static String osName=System.getProperty("os.name").toLowerCase();
	
	//To Load Properties file as per running platform
	public void propertyFileReader() {
		if(osName.contains("mac") || osName.contains("linux")){
			prop = new PropertyFileReader(".//properties//testdata.properties");
			gcashprop = new PropertyFileReader(".//properties//gcash.properties");
			shopsafeprop = new PropertyFileReader(".//properties//shopsafe.properties");
		}else {
			prop = new PropertyFileReader(".\\properties\\testdata.properties");
			gcashprop = new PropertyFileReader(".\\properties\\gcash.properties");
			shopsafeprop = new PropertyFileReader(".\\properties\\shopsafe.properties");
		}
	}

	public void yamlReader(){
		if(osName.contains("mac") || osName.contains("linux")){
			yamlReader = new yamlReader(".//properties//backupCode.yaml");
		}else {
			yamlReader = new yamlReader(".\\properties\\backupCode.yaml");
		}
	}
	//0-Param Constructor
	public BaseClass() {
		
	}
	
	//3-Param Constructor
	public BaseClass(String Application, String deviceName, String portno) throws InterruptedException {
		new CommandBase(Application, deviceName, portno);
		propertyFileReader();
		yamlReader();
	}

	public double getWalletBalance() throws Exception {
		String balanceText = "";
		if (verifyElementPresent(MLWalletHomePage.objHiddenAvailableBalance, "Hidden Balance")) {
			click(MLWalletHomePage.objEyeIcon, "Eye Icon");
			waitTime(1000);
			balanceText = getTextVal(MLWalletHomePage.objAvailableBalance,"");
			logger.info("Balance is = " + balanceText);
		} else {
			balanceText = getTextVal(MLWalletHomePage.objAvailableBalance,"");
			logger.info("Balance is = " + balanceText);
		}
		// Remove commas from the balance text and parse it as a double
		double balance = Double.parseDouble(balanceText.replace(",", ""));
		return balance;
	}
	public double parseDouble(String value)throws Exception {
		String cleanValue = value.replace(",", "").trim();
		return Double.parseDouble(cleanValue);
	}

	//Tear Down Application
	public void tearDown() {
		if (platform.equalsIgnoreCase("Web")) {
			closeWebBrowser();
		} else {
			logger.info("Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
			ExtentReporter.extentLogger("", "Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
			logger.info("Session is quit");
			ExtentReporter.extentLogger("", "Session is quit");
			setScreenshotSource();
			DriverManager.getAppiumDriver().quit();
		}
	}
	@BeforeTest
	public void beforeTest(){
		getDriver().manage().deleteAllCookies();
	}
}
