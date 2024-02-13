package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletLoginPage {
	
	public static By objMobileNumberTextField=By.xpath("//*[@name='9XX XXX XXXX']/XCUIElementTypeTextField");
	public static By objExittestingPage=By.xpath("//XCUIElementTypeOther[@name=\"×\"]");
	public static By objAllowNoftifBtn=By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]");
	public static By objConfirmWentWrongBtn=By.xpath("//XCUIElementTypeOther[@name=\"modal-confirm-button\"]");

	public static By objAllowNotifLabel=By.xpath("//XCUIElementTypeStaticText[@name=\"“ML Wallet” Would Like to Send You Notifications\"]");

	public static By objMobileNumberTextField1=By.xpath( "//*[@name='+63']/XCUIElementTypeOther/XCUIElementTypeTextField");

	public static By objLoginBtn=By.xpath("//*[@name='208465' or @label='Login']");
	
//	public static By objOtpTextField=By.xpath("//*[@name='94NMBE-0 94NMBE-1 94NMBE-2 94NMBE-3 94NMBE-4 94NMBE-5']");
	public static By objOtpTextField=By.xpath("//*[@name='94NMBE-0']");
	public static By objResendCode = By.xpath("(//*[@name='Did not receive OTP?']/following::XCUIElementTypeStaticText)[2]");

	public static By objAvailableBalance = By.xpath("//*[@name='UTJ9TN']");

	public static By objInvalidMobNumberTxt = By.xpath("//*[@name='Mobile number is invalid']");

	public static By objOneTimePin = By.xpath("//*[@name='One Time Pin']");

	public static By objOneTimePinPopup = By.xpath("(//XCUIElementTypeStaticText[@name='One Time Pin'])[3]");
	
	public static By objOTP = By.xpath("(//XCUIElementTypeStaticText[@name='One Time Pin'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
	
	public static By objOneTimePin1 = By.xpath("(//*[@name='textInput'])[1]");
	
	public static By objMobileNoReqErrorMsg = By.xpath("//*[@name='Mobile number is required']");

	public static By objMLPin = By.xpath("//*[@name='ML Pin']");

	public static By objMLPinEditField(int i) {
		return  By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]])[1]/*[@class='android.view.ViewGroup'])["+i+"]");
	}

	public static By objOneBtn = By.xpath("//*[@name='1']");
   
	public static By objLocationPopup=By.xpath("//XCUIElementTypeAlert[@name=\"Allow “ML Wallet” to use your location?\"]");
	
	public static By objChangeNumber=By.xpath("//XCUIElementTypeStaticText[@name='724506']");
	
	public static By objTroubleSigningIn=By.xpath("//XCUIElementTypeOther[@name=\"Trouble signing in?\"]");
	
	public static By objHaveAnAccountMsg=By.xpath("//XCUIElementTypeStaticText[@name=\"Don’t have an account?\"]");
	
	public static By objCreateOneBtn=By.xpath("//XCUIElementTypeOther[@name=\" Create one\"]");
	
	public static By objBranchLocator=By.xpath("//*[@label='Branch Locator']");
	
	public static By objAppVersion=By.xpath("//XCUIElementTypeStaticText[@name=\"346187\"]");
	
	public static By objTroubleSigningPage=By.xpath("//XCUIElementTypeStaticText[@name=\"Trouble Signing In\"]");
	
	public static By objMLWalletSupport=By.xpath("//XCUIElementTypeStaticText[@name=\"ML Wallet Support\"]");
	
	public static By objRegistrationNumber=By.xpath("//XCUIElementTypeStaticText[@name=\"Registration Number\"]");
	
	public static By objOk=By.xpath("//*[@name='OK']");
	public static By objOkBtn=By.xpath("//*[@name='Ok']");
	
	public static By objgmail=By.xpath("(//XCUIElementTypeStaticText[@name=\"Search or type URL\"])[1]");
	
	public static By objaddress=By.xpath("//XCUIElementTypeTextField[@name=\"Address\"]\n"
			+ "");
	
	public static By objGoogle=By.xpath("//XCUIElementTypeStaticText[@name=\"Google\"]");
	
	public static By objGoogleClear=By.xpath("//XCUIElementTypeStaticText[@name=\"google.com\"]");
	
	public static By objCollaberaBuild=By.xpath("//XCUIElementTypeStaticText[@name=\"collabera build\"]\n"
			+ "");
	
	public static By objInstallBtn=By.xpath("//XCUIElementTypeButton[@name=\"INSTALL\"]");
	
	public static By objInstallPopUp=By.xpath("//XCUIElementTypeButton[@name=\"Install\"]");
	
	public static By objGoogleBackBtn=By.xpath("//XCUIElementTypeButton[@name=\"kTabGridEditButtonIdentifier\"]");
	
	public static By objAppVersionChangeNumber = By.xpath("//*[@name='346187' or @name='216094']");
	
	//New OTP Handle
	
	public static By objOtpContineBtn = By.xpath("//*[@name='modal-confirm-button']");
	
	public static By objCancelBtn = By.xpath("(//XCUIElementTypeOther[@name='CANCEL'])[3]");

	public static By objCameraPopup = By.xpath("//XCUIElementTypeStaticText[@name='“ML Wallet” Would Like to Access the Camera']");

	public static By objCamPopUpOKBtn = By.xpath("//*[@name='modal-confirm-button']");
	public static By objInvalidMPinMsg = By.xpath("//XCUIElementTypeOther[@name='Ok']/preceding-sibling::XCUIElementTypeStaticText");
	public static By objSeconds = By.xpath("((//XCUIElementTypeStaticText[@name='One Time Pin'])[3]/ancestor::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[3]");
	public static By objContinueBtn = By.xpath("//*[@label='Continue']");
	public static By obj24HoursBlockedMsg = By.xpath("//XCUIElementTypeStaticText[@name='You are blocked from using ML PIN. Please try again later after 24 hrs.']");

	public static By objUnregisteredNumberMsg = By.xpath("//XCUIElementTypeOther[@name=\"Register\"]/preceding-sibling::XCUIElementTypeStaticText");
	public static By objRegisterBtn = By.xpath("//XCUIElementTypeOther[@name=\"Register\"]");



//	=================================================//

	public static By objSendBtn = By.xpath("//XCUIElementTypeOther[@name='AY6EU5']");

	public static By objSendMoneyPage = By.xpath("//XCUIElementTypeStaticText[@name='Send Money']");
	public static By objToAnyMLBranchOption = By.xpath("(//XCUIElementTypeOther[@name=\"Kwarta Padala To any ML Branch \uE5CC\"])[2]");
	public static By objFirstNameInputField = By.xpath("//XCUIElementTypeOther[@name=\"First Name\"]/child::XCUIElementTypeTextField");

	public static By objMiddleNameInputField = By.xpath("//XCUIElementTypeOther[@name=\"Middle Name\"]/child::XCUIElementTypeTextField");

	public static By objLastNameInputField = By.xpath("//XCUIElementTypeOther[@name=\"Last Name\"]/child::XCUIElementTypeTextField");

	public static By objMobileNumberInputField = By.xpath("//XCUIElementTypeOther[@name=\"Mobile Number\"]/child::XCUIElementTypeTextField");

	public static By objKwartaPadalaNextBtn = By.xpath("//XCUIElementTypeOther[@name=\"V65U0U\"]");

	public static By objKwartaPadala = By.xpath("//XCUIElementTypeStaticText[@name=\"Kwarta Padala\"]");

	public static By objAmountInputField = By.xpath("//*[@type='XCUIElementTypeTextField']");

	public static By objAmountNextButton = By.xpath("//XCUIElementTypeOther[@name=\"62HFFQ\"]");

	public static By objMLWalletBalanceBtn = By.xpath("//XCUIElementTypeOther[@name=\"391CJJ\"]");

	public static By objConfirmDetailsPage = By.xpath("//XCUIElementTypeStaticText[@name=\"Confirm Details\"]");

	public static By objConfirmBtn = By.xpath("//XCUIElementTypeOther[@name=\"8LQQF7\"]");

	public static By objSendMoneySuccessfulPage = By.xpath("//XCUIElementTypeStaticText[@name=\"Send Money Successful\"]");

	public static By objRefNoInTransactionSuccessPage  = By.xpath("//XCUIElementTypeStaticText[@name=\"56FWEC\"]");

	public static By objBackToHomeBtn = By.xpath("//XCUIElementTypeOther[@name=\"T77C1L\"]");

	public static By objRecentTransaction = By.xpath("(//XCUIElementTypeOther[@name=\"OSJVNX\"])[2]");

	public static By objTransactionDetailsPage = By.xpath("(//XCUIElementTypeStaticText[@name=\"Transaction Details\"])[1]");

	public static By objRefNoInTransactionDetails = By.xpath("(//XCUIElementTypeStaticText[@name=\"Reference Number\"])[2]");

}
