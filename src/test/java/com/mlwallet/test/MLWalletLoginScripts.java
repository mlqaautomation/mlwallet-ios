package com.mlwallet.test;
import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.utility.Utilities.getDriver;

public class MLWalletLoginScripts  extends BaseTest{

	
//	@Test(priority = 1)
//	public void LogInScenarioWithValidMobNumber() throws Exception { // MLWalletBusinessLogic.gmail();
//		mlWalletLogin.LogInScenarioWithValidMobNumber_Lgn_TC_01();
//	}
//
//	@Test(priority = 2)
//	public void LogInScenarioWithInvalidMobNumber_Lgn_TC_02() throws Exception {
//		mlWalletLogin.LogInScenarioWithInvalidMobNumber_Lgn_TC_02();
//	}
//
//	@Test(priority = 3)
//	public void LogInScenarioWithValidOTP_Lgn_TC_03() throws Exception {
//		mlWalletLogin.LogInScenarioWithValidOTP_Lgn_TC_03();
//	}
//
//	@Test(priority = 4)
//	public void appLaunch_Lgn_TC_05() throws Exception {
//		mlWalletLogin.appLaunch_Lgn_TC_05();
//	}
//
//	@Test(priority = 5)
//	public void loginPageUIValidation_Lgn_TC_06() throws Exception {
//		mlWalletLogin.loginPageUIValidation_Lgn_TC_06();
//	}
//
//	@Test(priority = 6)
//	public void loginTroubleSigningIn_Lgn_TC_07() throws Exception {
//		mlWalletLogin.loginTroubleSigningIn_Lgn_TC_07();
//	}
//
//	@Test(priority = 7)
//	public void loginCreateOne_Lgn_TC_08() throws Exception {
//		mlWalletLogin.loginCreateOne_Lgn_TC_08();
//	}
//
//	@Test(priority = 8)
//	public void loginBranchLocator_Lgn_TC_09() throws Exception {
//		mlWalletLogin.loginBranchLocator_Lgn_TC_09();
//	}
//
//	@Test(priority = 9)
//	public void loginOTPPageUIValidation_Lgn_TC_10() throws Exception {
//		mlWalletLogin.loginOTPPageUIValidation_Lgn_TC_10();
//	}
//
//
////====================================================================================================//
//
//	@Test(priority = 10)
//	public void loginWithExistingMobileNumber_Lgn_TC_17() throws Exception {
//		mlWalletLogin.loginWithExistingMobileNumber_Lgn_TC_17();
//	}
//
//	@Test(priority = 11)
//	public void loginMPinPageUIValidation_Lgn_TC_18() throws Exception {
//		mlWalletLogin.loginMPinPageUIValidation_Lgn_TC_18();
//	}
//
//	@Test(priority = 12)
//	public void loginInAppOTPNavigation_Lgn_TC_22() throws Exception {
//		mlWalletLogin.loginInAppOTPNavigation_Lgn_TC_22();
//	}
//
//	@Test(priority = 13)
//	public void loginInAppOTPPageUIValidation_Lgn_TC_23() throws Exception {
//		mlWalletLogin.loginInAppOTPPageUIValidation_Lgn_TC_23();
//	}
//
//	@Test(priority = 14)
//	public void loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24() throws Exception {
//		mlWalletLogin.loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24();
//	}
//
//	@Test(priority = 15)
//	public void loginOTPCancelBtnFunctionality_Lgn_TC_25() throws Exception {
//		mlWalletLogin.loginOTPCancelBtnFunctionality_Lgn_TC_25();
//	}
//
//	@Test(priority = 16)
//	public void loginOTPContinueBtnFunctionality_Lgn_TC_26() throws Exception {
//		mlWalletLogin.loginOTPContinueBtnFunctionality_Lgn_TC_26();
//	}
	@Test(priority = 17)
	public void LogInScenarioWithInvalidMobNumber_Lgn_TC_15() throws Exception {
		mlWalletLogin.LogInScenarioWithInvalidMobNumber_Lgn_TC_15();
	}
	@Test(priority = 18)
	public void loginInvalidMPinValidation_Lgn_TC_27() throws Exception {
		mlWalletLogin.loginInvalidMPinValidation_Lgn_TC_27("9999999995","111111","1234");
	}
//	@Test(priority = 19)
//	public void loginEnterInvalidMPinAndBlock_Lgn_TC_28() throws Exception {
//		mlWalletLogin.loginEnterInvalidMPinAndBlock_Lgn_TC_28();
//	}
//	@Test(priority = 20)
//	public void loginMPinNavigation_LG_New_TC_01() throws Exception {
//		mlWalletLogin.loginMPinNavigation_LG_New_TC_01("9999999996","111111");
//	}
//	@Test(priority = 21)
//	public void loginToAppWithChangeNumberUsingNewNumber_LG_New_TC_02() throws Exception {
//		mlWalletLogin.loginToAppWithChangeNumberUsingNewNumber_LG_New_TC_02();
//	}
//	@Test(priority = 22)
//	public void loginToApplicationWithMPin_LG_New_TC_03() throws Exception {
//		mlWalletLogin.loginToApplicationWithMPin_LG_New_TC_03();
//	}

	@AfterMethod()
	public void afterMethod(){
		System.out.println("Reset");
		DriverManager.getAppiumDriver().resetApp();
		System.out.println("Reset complete");
	}
}
