package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.iosmlwalletpages.MLWalletLogOutPage;
import com.iosmlwalletpages.MLWalletLoginPage;

import java.time.Duration;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.ExtentReporter.*;
import static com.utility.Utilities.*;

public class MLWalletLogOut extends BaseClass {

    public MLWalletLogOut() {
        super();
    }

    public void logOutMinimizeAndRelaunch_Lout_TC_03() throws Exception {
        HeaderChildNode("Log Out Minimize and relaunch the application");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        logger.info("Application Minimized for 5 Seconds");
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Applicaton relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("User should not be able to logout from the app");
            logger.info("Lout_TC_03, Log Out Minimize and relaunch the application validated");
            extentLoggerPass("Lout_TC_03", "Lout_TC_03, Log Out Minimize and relaunch the application validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutAppKillAndRelaunch_Lout_TC_04() throws Exception {
        HeaderChildNode("Kill Application and Relaunch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        DriverManager.getAppiumDriver().closeApp();
        logger.info("Killed the Application");
        waitTime(3000);
       DriverManager.getAppiumDriver().launchApp();
        logger.info("Relaunch the Application");
        changeNumberPage();
        explicitWaitVisibility(MLWalletLoginPage.objLoginBtn, 10);
        if(verifyElementPresent(MLWalletLoginPage.objLoginBtn,getTextVal(MLWalletLoginPage.objLoginBtn,"page"))){
            logger.info("Lout_TC_04, After Killing and relaunch the Application, Application got logged off");
            extentLoggerPass("Lout_TC_04", "Lout_TC_04, After Killing and relaunch the Application, Application got logged off");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOUtPopUpValidation_Lout_TC_05(String status) throws Exception {
        HeaderChildNode("LogOut Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletLogOutPage.objLogoOutPopupMsg,getTextVal(MLWalletLogOutPage.objLogoOutPopupMsg,"Pop up Message"))){
            String sLogOutPopupMsg = getText(MLWalletLogOutPage.objLogoOutPopupMsg);
            String sExpectedErrorMsg = "Are you sure you would like to logout?";
            assertionValidation(sLogOutPopupMsg,sExpectedErrorMsg);
            verifyElementPresent(MLWalletLogOutPage.objPopUpLogoutBtn,getTextVal(MLWalletLogOutPage.objPopUpLogoutBtn,"Button"));
            verifyElementPresent(MLWalletLogOutPage.objCancelBtn,getTextVal(MLWalletLogOutPage.objCancelBtn,"Button"));
            logger.info("Lout_TC_05, LogOut Popup validated");
            extentLoggerPass("Lout_TC_05", "Lout_TC_05, LogOut Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutPopUpCancelBtnValidation_Lout_TC_06() throws Exception {
        HeaderChildNode("LogOut PopUp Cancel Button Validation");
        waitTime(2000);
        changeNumberPage();
        logOUtPopUpValidation_Lout_TC_05("false");
        click(MLWalletLogOutPage.objCancelBtn,getTextVal(MLWalletLogOutPage.objCancelBtn,"Button"));
        if(verifyElementPresent(MLWalletLogOutPage.objHome,getTextVal(MLWalletLogOutPage.objHome,"Button"))){
            DriverManager.getAppiumDriver().launchApp();
            logger.info("Lout_TC_06, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            extentLoggerPass("Lout_TC_06", "Lout_TC_06, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutPopUpLogOutBtnValidation_Lout_TC_07() throws Exception {
        HeaderChildNode("LogOut PopUp LogOut Btn Validation");
        waitTime(2000);
        changeNumberPage();
        logOUtPopUpValidation_Lout_TC_05("false");
        click(MLWalletLogOutPage.objPopUpLogoutBtn,getTextVal(MLWalletLogOutPage.objPopUpLogoutBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLogOutPage.objChangeNumber,getTextVal(MLWalletLogOutPage.objChangeNumber,"Page"))){
            logger.info("Lout_TC_07, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            extentLoggerPass("Lout_TC_07", "Lout_TC_07, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logoutChangeNumberUIValidation_Lout_TC_08() throws Exception {
        HeaderChildNode("Log Out Change Number UI page Validation");
        waitTime(2000);
        changeNumberPage();
        logOUtPopUpValidation_Lout_TC_05("false");
        click(MLWalletLogOutPage.objPopUpLogoutBtn,getTextVal(MLWalletLogOutPage.objPopUpLogoutBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLogOutPage.objChangeNumber,getTextVal(MLWalletLogOutPage.objChangeNumber,"Page"))){
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn,getTextVal(MLWalletLoginPage.objTroubleSigningIn,"Link"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Link"));
            explicitWaitVisibility(MLWalletLoginPage.objAppVersionChangeNumber, 10);
            verifyElementPresent(MLWalletLoginPage.objAppVersionChangeNumber,getTextVal(MLWalletLoginPage.objAppVersionChangeNumber,"App Version"));
            logger.info("Lout_TC_08, Log Out Change Number UI page validated");
            extentLoggerPass("Lout_TC_08", "Lout_TC_08, Log Out Change Number UI page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logInWithChangeNumber_Lout_TC_09() throws Exception {
        HeaderChildNode("Log In With Change Number");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout1();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lout_TC_09,Application Logged In Successfully with Change Number");
            extentLoggerPass("Lout_TC_09","Lout_TC_09, Application Logged In Successfully with Change Number");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
