package com.business.mlwallet;

import com.iosmlwalletpages.*;
import com.utility.Utilities;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.ExtentReporter.*;
import static com.utility.ExtentReporter.extentLoggerPass;
import static com.utility.Utilities.*;

public class MLWalletSettings extends BaseClass {

    public MLWalletSettings() {
        super();

    }

    public void navigateToProfile() throws Exception {
        click(MLWalletSettingsPage.objProfileIcon1, "Profile Icon");
        waitTime(2000);
        if (verifyElementPresent(MLWalletSettingsPage.objAccountDetails, "Account Details Page")) {
            logger.info("Navigated to settings");
        }
        waitTime(2000);
    }

    public void navigateToProfile1() throws Exception {
        click(MLWalletSettingsPage.objProfile2, "Profile Icon");
        waitTime(2000);
        if (verifyElementPresent(MLWalletSettingsPage.objAccountDetails, "Account Details Page")) {
            logger.info("Navigated to settings");
        }
        waitTime(2000);
    }
    public void settingsAccountDetailsValidation_SS_TC_01() throws Exception {
        HeaderChildNode("Settings Account Details validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        waitTime(3000);
        click(MLWalletSettingsPage.objAccountDetails, "Account Details");
        if(verifyElementPresent(MLWalletSettingsPage.objAccountDetailsPage, getTextVal(MLWalletSettingsPage.objAccountDetailsPage,"Name"))) {
            verifyElementPresent(MLWalletSettingsPage.objNameOfAccountHolder, getTextVal(MLWalletSettingsPage.objNameOfAccountHolder, "Name"));
            verifyElementPresent(MLWalletSettingsPage.objMailAddressOfAccountHolder, getTextVal(MLWalletSettingsPage.objMailAddressOfAccountHolder, "Mail Address"));
            verifyElementPresent(MLWalletSettingsPage.objMobileNoOfAccountHolder, getTextVal(MLWalletSettingsPage.objMobileNoOfAccountHolder, "Mobile Number"));
            logger.info("SS_TC_01, Account Details validated");
            extentLoggerPass("SS_TC_01", "SS_TC_01, Account Details validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsInvalidMLPinValidation_SS_TC_03() throws Exception {
        HeaderChildNode("Settings Invalid ML Pin Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objChangeMLPinTab, "Change ML Pin");
        explicitWaitVisibility(MLWalletSettingsPage.objChangeMLPinPage, 10);
        verifyElementPresent(MLWalletSettingsPage.objChangeMLPinPage, "Change ML Pin");
        handleMpin(prop.getproperty("wrongMpin"), "Entered Invalid ML PIN");
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objInvalaidMpinPopUp,getTextVal(MLWalletSettingsPage.objInvalaidMpinPopUp,"Error Popup Message"))){
            String sInvalidMPinPopUp = getText(MLWalletSettingsPage.objInvalaidMpinPopUp);
            String sExceptedErrorPOpUp = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sInvalidMPinPopUp,sExceptedErrorPOpUp);
            click(MLWalletCashOutPage.objOkBtn,"OK Button");
            logger.info("SS_TC_03, Invalid ML PIN validated");
            extentLoggerPass("SS_TC_03", "SS_TC_03, Invalid ML PIN validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsValidMLPinValidation_SS_TC_02() throws Exception {
        HeaderChildNode("Settings Valid ML Pin Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objChangeMLPinTab, "Change ML Pin");
        waitTime(2000);
        handleMpin(prop.getproperty("mPin"), "Entered");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSettingsPage.objEnterNewMMLpinText,
                getTextVal(MLWalletSettingsPage.objEnterNewMMLpinText, "Page"))) {
            waitTime(2000);
            handleMpin(prop.getproperty("newMpin"), "New ML PIN");
            waitTime(2000);
            handleMpin(prop.getproperty("newMpin"), "Confirmed New ML ");
            waitTime(2000);
            if(verifyElementPresent(MLWalletSettingsPage.objMLPinChangedPopup,
                    getTextVal(MLWalletSettingsPage.objMLPinChangedPopup,"Success Popup"))){
                String sActualSuccessPopUp = getText(MLWalletSettingsPage.objMLPinChangedPopup);
                String sExpectedSuccessPopUp = "ML Pin Successfully Changed";
                assertionValidation(sActualSuccessPopUp,sExpectedSuccessPopUp);
                click(MLWalletSettingsPage.objGotItBtn, "Got It Button");
                logger.info("SS_TC_02 To validate ML PIN validated");
                extentLoggerPass("SS_TC_02", "'SS_TC_02' To validate ML PIN validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void settingsBiometricsLogin_SS_TC_04() throws Exception {
        HeaderChildNode("Settings Biometrics Login");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Option"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsSwitch,"Biometrics Switch");
        enterOTP(prop.getproperty("Valid_OTP"));
        if(verifyElementPresent(MLWalletSettingsPage.objActivateBiometricsLogin,getTextVal(MLWalletSettingsPage.objActivateBiometricsLogin,"Header"))){
            String sActualActiveMsg = getText(MLWalletSettingsPage.objActivateBiometricsLogin);
            String sExceptedActiveMsg = "Activate Biometrics Login";
            assertionValidation(sActualActiveMsg,sExceptedActiveMsg);
            logger.info("SS_TC_04, Settings Biometrics Login Validated");
            extentLoggerPass("SS_TC_04", "'SS_TC_04' Settings Biometrics Login Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingAccRecovery_SS_TC_05() throws Exception {
        HeaderChildNode("Invalid ML Pin Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objAccountRecovery, "Account Recovery");
        explicitWaitVisibility(MLWalletSettingsPage.objMlWalletSupportPage, 10);
        verifyElementPresent(MLWalletSettingsPage.objMlWalletSupportPage,
                getTextVal(MLWalletSettingsPage.objMlWalletSupportPage, "Page"));
        click(MLWalletSettingsPage.objFullNameField, "First Name Field");
        type(MLWalletSettingsPage.objFullNameField, prop.getproperty("firstName"), "First Name Field");
        Swipe("UP",1);
        click(MLWalletSettingsPage.objRegisteredEmail, "Registered Email Field");
        type(MLWalletSettingsPage.objRegisteredEmail, prop.getproperty("eMailAddress"),
                "Registered Email Field");
        Swipe("UP",1);
        click(MLWalletSettingsPage.objMobileNumber, "Mobile Number Field");
        type(MLWalletSettingsPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Field");

        click(MLWalletSettingsPage.objNatureOfReqRadioBtn,
                getTextVal(MLWalletSettingsPage.objNatureOfReqRadioBtn, "Text"));
        Swipe("UP",1);
        click(MLWalletSettingsPage.objNextBtn, "Next Button");
        click(MLWalletSettingsPage.objNextBtn, "Next Button");
        explicitWaitVisibility(MLWalletSettingsPage.objStolenPage, 10);
        verifyElementPresent(MLWalletSettingsPage.objStolenPage,
                getTextVal(MLWalletSettingsPage.objStolenPage, "Page"));
        click(MLWalletSettingsPage.objYourAnswer, "Lost/Stolen Mobile Number Field");
        type(MLWalletSettingsPage.objYourAnswer, prop.getproperty("Branch_Verified"),
                "Lost/Stolen Mobile Number Field");
        click(MLWalletSettingsPage.objNewMobNo, "New Mobile Number Field");
        type(MLWalletSettingsPage.objNewMobNo, prop.getproperty("newMobileNumber"), "New Mobile Number Field");

        Swipe("UP",1);
        click(MLWalletSettingsPage.objFacebookMessangerName, "Facebook Messenger Name Field");
        type(MLWalletSettingsPage.objFacebookMessangerName, prop.getproperty("messangerName"),
                "Facebook Messenger Name Field");

        click(MLWalletSettingsPage.objSumbitBtn, "Submit Button");
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objReviewPage, "Review Page");
        String actualText = "Please allow us some time to review the details of your request. A customer service representative will contact you for updates and/or to get additional information.";
        String reviewExpectedText = getText(MLWalletSettingsPage.objReviewPage);
        assertionValidation(actualText, reviewExpectedText);
        logger.info("'SS_TC_05', To verify account recovery validated");
        extentLoggerPass("Account Recovery", "'SS_TC_05', To verify account recovery validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void settingsBackBtnValidation_SS_TC_07() throws Exception {
        HeaderChildNode("Settings Back Button Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objSettingsBackBtn,"Settings Back Button");
        explicitWaitVisibility(MLWalletLoginPage.objAvailableBalance, 10);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("SS_TC_07, Settings Back Button Button validated");
            extentLoggerPass("SS_TC_07", "SS_TC_07, Settings Back Button Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountPopUpUIValidation_SS_TC_10() throws Exception {
        HeaderChildNode("Settings Delete Account PopUp UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Confirmation Popup"))){
            String sActualConfirmationPopupMsg = getText(MLWalletSettingsPage.objDeleteConfirmationPopUp);
            String sExpectedConfirmationPopupMsg = "Are you sure you would like to delete your account?";
            assertionValidation(sActualConfirmationPopupMsg,sExpectedConfirmationPopupMsg);
            verifyElementPresent(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
            verifyElementPresent(MLWalletSettingsPage.objCancelBtn,getTextVal(MLWalletSettingsPage.objCancelBtn,"Button"));
            click(MLWalletSettingsPage.objCancelBtn, "Cancel Button");
            logger.info("SS_TC_10, Settings, Settings Delete Account PopUp UI validated");
            extentLoggerPass("SS_TC_10", "SS_TC_10, Settings Delete Account PopUp UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void settingsChangeMLPinNavigation_SS_TC_12() throws Exception {
        HeaderChildNode("Settings Change ML Pin Navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPinTab,getTextVal(MLWalletSettingsPage.objChangeMLPinTab,"option"));
        Thread.sleep(5000);
        if(verifyElementPresent(MLWalletSettingsPage.objChangeMLPinPage,getTextVal(MLWalletSettingsPage.objChangeMLPinPage,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPin,getTextVal(MLWalletSettingsPage.objEnterCurrentMLPin,"Header"));
            verifyElementPresent(MLWalletSettingsPage.objMLPinEditField,"ML Pin Edit Field");
            logger.info("SS_TC_12, Settings Change ML Pin Navigation validated");
            extentLoggerPass("SS_TC_12", "SS_TC_12, Settings Change ML Pin Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsChangeMlPinBackBtnValidation_SS_TC_13() throws Exception {
        HeaderChildNode("Settings Change ML Pin Back Button Validation");
        settingsChangeMLPinNavigation_SS_TC_12();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPinBackBtn,"Back Button");
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_13, Settings, After clicking on  Change ML Pin Back Button App Navigated to Settings Page validated");
            extentLoggerPass("SS_TC_13", "SS_TC_13, Settings, After clicking on  Change ML Pin Back Button App Navigated to Settings Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsPageUIValidation_SS_TC_06() throws Exception {
        HeaderChildNode("Settings Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objAccountDetails,getTextVal(MLWalletSettingsPage.objAccountDetails,"Option"));
            verifyElementPresent(MLWalletSettingsPage.objChangeMLPinTab,getTextVal(MLWalletSettingsPage.objChangeMLPinTab,"Option"));
            //	verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Option"));
            verifyElementPresent(MLWalletSettingsPage.objAccountRecovery,getTextVal(MLWalletSettingsPage.objAccountRecovery,"Option"));
            verifyElementPresent(MLWalletSettingsPage.objNotification,getTextVal(MLWalletSettingsPage.objNotification,"Option"));
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
            logger.info("SS_TC_06, Settings Page UI validated");
            extentLoggerPass("SS_TC_06", "SS_TC_06, Settings Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountDetailsNavigation_SS_TC_14() throws Exception {
        HeaderChildNode("Settings Account Details Navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountDetails,getTextVal(MLWalletSettingsPage.objAccountDetails,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objAccountDetailsPage, getTextVal(MLWalletSettingsPage.objAccountDetailsPage,"Page"))){
            logger.info("SS_TC_14, Settings Account Details Navigation validated");
            extentLoggerPass("SS_TC_14", "SS_TC_14, Settings Account Details Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountDetailsBackBtnValidation_SS_TC_15() throws Exception {
        HeaderChildNode("Settings Account details Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        settingsAccountDetailsNavigation_SS_TC_14();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountDetailsBackBtn,"Back Button");
        if(verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_15, Settings Account Details Back Button Navigation validated");
            extentLoggerPass("SS_TC_15", "SS_TC_15, Settings Account Details Back Button Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingChangeMLPinUIValidation_SS_TC_16() throws Exception {
        HeaderChildNode("Settings Change ML Pin UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPinTab,getTextVal(MLWalletSettingsPage.objChangeMLPinTab,"option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objChangeMLPinPage,getTextVal(MLWalletSettingsPage.objChangeMLPinPage,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPin,getTextVal(MLWalletSettingsPage.objEnterCurrentMLPin,"Header"));
            //verifyElementPresent(MLWalletSettingsPage.objKeyword,"Keyword to Enter MLPin");
            verifyElementPresent(MLWalletSettingsPage.objMLPinEditField,"ML Pin Edit Field");
            logger.info("SS_TC_16, Settings Change ML Pin UI validated");
            extentLoggerPass("SS_TC_16", "SS_TC_16, Settings Change ML Pin UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountRecoveryUIValidation_SS_TC_17() throws Exception {
        HeaderChildNode("Settings Account Recovery UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountRecovery,getTextVal(MLWalletSettingsPage.objAccountRecovery,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objTroubleSigningIn,getTextVal(MLWalletSettingsPage.objTroubleSigningIn,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objMLWalletSupport,getTextVal(MLWalletSettingsPage.objMLWalletSupport,"Header"));
            verifyElementPresent(MLWalletSettingsPage.objFullNameField, "First Name Field");
            verifyElementPresent(MLWalletSettingsPage.objRegisteredEmail, "Registered Email Field");
            Swipe("UP",1);
            verifyElementPresent(MLWalletSettingsPage.objMobileNumber, "Mobile Number Field");
            Swipe("UP",1);
            if (verifyElementDisplayed(MLWalletSettingsPage.objNatureOfRequests,"Nature of Requests")) {
                List<WebElement> values = findElements(MLWalletSettingsPage.objNatureOfRequests);
                for (int i = 0; i < values.size(); i++) {

                    String savedRecipientName = values.get(i).getText();
                    logger.info("Nature of Your Request : " + savedRecipientName + " is displayed");
                    extentLogger(" ", "Nature of Your Request : " + savedRecipientName + " is displayed");

                }
                logger.info("SS_TC_17, Settings Account Recovery UI validated");
                extentLoggerPass("SS_TC_17", "SS_TC_17, Settings Account Recovery UI validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void settingsDeleteAccountCancelBtnValidation_SS_TC_18() throws Exception {
        HeaderChildNode("Settings Delete Account Cancel Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Delete Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objCancelBtn,getTextVal(MLWalletSettingsPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_18, Settings, After clicking on Cancel button on Delete Confirmation Popup App should navigate to Settings Page is validated");
            extentLoggerPass("SS_TC_18", "SS_TC_18, Settings, After clicking on Cancel button on Delete Confirmation Popup App should navigate to Settings Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginUIValidation_SS_TC_20() throws Exception {
        HeaderChildNode("Settings Biometrics Login UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Option"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objBiometrics,getTextVal(MLWalletSettingsPage.objBiometrics,"Header"));
            verifyElementPresent(MLWalletSettingsPage.objBiometricsSwitch,"Biometrics Switch");
            verifyElementPresent(MLWalletSettingsPage.objActivateBiometricsLogin,getTextVal(MLWalletSettingsPage.objActivateBiometricsLogin,"Header"));
            logger.info("SS_TC_20, Settings, Settings Biometrics Login UI validated");
            extentLoggerPass("SS_TC_20", "SS_TC_20, Settings Biometrics Login UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountRecoveryNavigation_SS_TC_21() throws Exception {
        HeaderChildNode("Settings Account Recovery Navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountRecovery,getTextVal(MLWalletSettingsPage.objAccountRecovery,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objTroubleSigningIn,getTextVal(MLWalletSettingsPage.objTroubleSigningIn,"Page"))){
            logger.info("SS_TC_21, Settings, After clicking on Account recovery, application navigated to Trouble Signing in page is validated");
            extentLoggerPass("SS_TC_21", "SS_TC_21, After clicking on Account recovery, application navigated to Trouble Signing in page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsTroubleSigningInBackBtnValidation_SS_TC_22() throws Exception {
        HeaderChildNode("Settings Trouble Signing In Bak Btn Validation");
        waitTime(2000);
        changeNumberPage();
        settingsAccountRecoveryNavigation_SS_TC_21();
        verifyElementPresentAndClick(MLWalletSettingsPage.objTroubleSigningInBackBtn,"Trouble Signing In Page Back Button");
        explicitWaitVisibility(MLWalletSettingsPage.objSettings, 10);
        if(verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_22, Settings Account Details Back Button Navigation validated");
            extentLoggerPass("SS_TC_22", "SS_TC_22, Settings Account Details Back Button Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginNavigation_SS_TC_23() throws Exception {
        HeaderChildNode("Settings Biometrics Login Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Option"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin,getTextVal(MLWalletSettingsPage.objBiometricsLogin,"Page"))){
            logger.info("SS_TC_23, Settings, After clicking on Account recovery, application navigated to Biometrics Login page is validated");
            extentLoggerPass("SS_TC_23", "SS_TC_23, After clicking on Account recovery, application navigated to Biometrics Login page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginBackBtnValidation_SS_TC_24() throws Exception {
        HeaderChildNode("Settings Biometrics Login Back Button validation");
        settingsBiometricsLoginNavigation_SS_TC_23();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLoginBackBtn,"Biometrics Login Page Back Button");
        if(verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_24, Settings Biometrics Login Back Button validated");
            extentLoggerPass("SS_TC_24", "SS_TC_24, Settings Biometrics Login Back Button validated validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountPageUIValidation_SS_TC_25() throws Exception {
        HeaderChildNode("Settings Delete Account Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccountBackBtn,"Back Arrow Button");
            verifyElementPresent(MLWalletSettingsPage.objWarningHeader,getTextVal(MLWalletSettingsPage.objWarningHeader,"Header"));
            List<WebElement> values = findElements(MLWalletSettingsPage.objWarningHeaderOptions);
            for (int i = 0; i < values.size(); i++) {
                if(i%2!=0) {
                    String warningOtions = values.get(i).getText();
                    logger.info(" All Transactions : " + warningOtions);
                    extentLogger("", "All Transactions : " + warningOtions);
                }
            }
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Button"));
            verifyElementPresent(MLWalletSettingsPage.objIWantToStay,getTextVal(MLWalletSettingsPage.objIWantToStay,"Button"));
            logger.info("SS_TC_25, Settings Delete Account Page UI validated");
            extentLoggerPass("SS_TC_25", "SS_TC_25, Settings Delete Account Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26() throws Exception {
        HeaderChildNode("Settings Delete Account I Want To Stay Button Functionality");
        settingsDeleteAccountPageUIValidation_SS_TC_25();
        click(MLWalletSettingsPage.objIWantToStay,getTextVal(MLWalletSettingsPage.objIWantToStay,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_26, Settings Delete Account, After clicking on I Want To Stay Button, App navigates to Settings Page");
            extentLoggerPass("SS_TC_26", "SS_TC_26, Settings Delete Account, After clicking on I Want To Stay Button, App navigates to Settings Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountPageBackButtonValidation_SS_TC_27() throws Exception {
        HeaderChildNode("Settings Delete Account Page Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccountBackBtn, "Back Arrow Button");
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_27, Settings Delete Account, After clicking on Back-Arrow Button, App navigates to Settings Page");
            extentLoggerPass("SS_TC_27", "SS_TC_27, Settings Delete Account, After clicking on Back-Arrow Button, App navigates to Settings Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountButtonFunctionality_SS_TC_28() throws Exception {
        HeaderChildNode("Settings Delete Account Button Functionality");
        settingsDeleteAccountPageUIValidation_SS_TC_25();
        click(MLWalletSettingsPage.objDeleteAccountBtn,getTextVal(MLWalletSettingsPage.objDeleteAccountBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUpTwo,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUpTwo,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
            verifyElementPresent(MLWalletSettingsPage.objCancelBtn,getTextVal(MLWalletSettingsPage.objCancelBtn,"Button"));
            logger.info("SS_TC_28, Settings Delete Account Button Functionality validated");
            extentLoggerPass("SS_TC_28", "SS_TC_28, Settings Delete Account Button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29() throws Exception {
        HeaderChildNode("Settings Delete Account Confirmation Popup Cancel Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objCancelBtn,getTextVal(MLWalletSettingsPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"))){
            logger.info("SS_TC_29, Settings Delete Account Confirmation Popup, After clicking on Cancel button App stays in Delete Account Page");
            extentLoggerPass("SS_TC_29", "SS_TC_29, Settings Delete Account Confirmation Popup, After clicking on Cancel button App stays in Delete Account Page");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30() throws Exception {
        HeaderChildNode("Settings Delete Account Confirmation Popup Proceed Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin,getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin,"Page"))){
            logger.info("SS_TC_30, Settings Delete Account Confirmation Popup, After clicking on Proceed button App navigates to Delete Account ML pin Page");
            extentLoggerPass("SS_TC_30", "SS_TC_30, Settings Delete Account Confirmation Popup, After clicking on Proceed button App navigates to Delete Account ML pin Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountMLPinPageUIValidation_SS_TC_31() throws Exception {
        HeaderChildNode("Settings Delete Account ML Pin Page UI Validation");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin,getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPinHeader,getTextVal(MLWalletSettingsPage.objEnterCurrentMLPinHeader,"Header"));
            logger.info("SS_TC_31, Settings Delete Account ML Pin Page UI Validated");
            extentLoggerPass("SS_TC_31", "SS_TC_31, Settings Delete Account ML Pin Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32() throws Exception {
        HeaderChildNode("Settings Delete Account ML Pin Page Back Arrow Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin,getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin,"Page"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccountBackBtn,getTextVal(MLWalletSettingsPage.objDeleteAccountBackBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"))){
            logger.info("SS_TC_32, Settings Delete Account ML Pin Page Back Arrow Button Validated");
            extentLoggerPass("SS_TC_32", "SS_TC_32, Settings Delete Account ML Pin Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountInvalidMLPin_SS_TC_34() throws Exception {
        HeaderChildNode("Settings Delete Account Invalid ML Pin");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin,getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin,"Page"));
        handleMpin("9999", "Entered ML Pin");
        waitTime(4000);
        if(verifyElementPresent(MLWalletSettingsPage.objInvalidMLPinMsg,getTextVal(MLWalletSettingsPage.objInvalidMLPinMsg,"Popup"))) {
            String sActualInvalidMLPinMsg = getText(MLWalletSettingsPage.objInvalidMLPinMsg);
            String sExceptedMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualInvalidMLPinMsg, sExceptedMsg);
            verifyElementPresent(MLWalletSettingsPage.objOKBtn, getTextVal(MLWalletSettingsPage.objOKBtn, "Button"));
            logger.info("SS_TC_34, Settings Delete Account Invalid ML Pin message Validated");
            extentLoggerPass("SS_TC_34", "SS_TC_34, Settings Delete Account Invalid ML Pin message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35() throws Exception {
        HeaderChildNode("Settings Delete Account invalid ML Pin Popup Ok Button Functionality");
        settingsDeleteAccountInvalidMLPin_SS_TC_34();
        click(MLWalletSettingsPage.objOKBtn,getTextVal(MLWalletSettingsPage.objOKBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin,getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin,"Page"))){
            logger.info("SS_TC_35, Settings Delete Account invalid ML Pin Popup Ok Button Functionality Validated");
            extentLoggerPass("SS_TC_35", "SS_TC_35, Settings Delete Account invalid ML Pin Popup Ok Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void settingsNotificationNavigationValidation_SS_TC_08() throws Exception {
        HeaderChildNode("Settings, Notification navigation validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objNotification,getTextVal(MLWalletSettingsPage.objNotification,"Button"));
        if(verifyElementPresent(MLWalletSettingsPage.objNotifications,getTextVal(MLWalletSettingsPage.objNotifications,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objNotificationMsg,getTextVal(MLWalletSettingsPage.objNotificationMsg,"Message"));
            logger.info("SS_TC_08, Settings, Notification navigation Validated");
            extentLoggerPass("SS_TC_08", "SS_TC_08, Settings, Notification navigation Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void settingsNotificationBackArrowBtnValidation_SS_TC_09() throws Exception {
        HeaderChildNode("Settings, Notification Back Arrow Button validation");
        settingsNotificationNavigationValidation_SS_TC_08();
        verifyElementPresentAndClick(MLWalletSettingsPage.objNotificationBackBtn,"Notification Back Btn");
        if(verifyElementPresent(MLWalletSettingsPage.objSettings,getTextVal(MLWalletSettingsPage.objSettings,"Page"))){
            logger.info("SS_TC_09, Settings, After clicking on Notification back button application navigates to Settings page is validated");
            extentLoggerPass("SS_TC_09", "SS_TC_09, Settings, After clicking on Notification back button application navigates to Settings page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingDeleteAccountProceedBtnFunctionality_SS_TC_11() throws Exception {
        HeaderChildNode("Settings, Delete Account Proceed Button functionality validated");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"))){
            logger.info("SS_TC_09, Settings, After clicking on Proceed button in delete account popup application navigates to Settings Delete page is validated");
            extentLoggerPass("SS_TC_09", "SS_TC_09, Settings, Settings, After clicking on Proceed button in delete account popup application navigates to Settings Delete page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsNotificationPageUIValidation_SS_TC_19() throws Exception {
        HeaderChildNode("Settings, Notification page UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objNotification,getTextVal(MLWalletSettingsPage.objNotification,"Button"));
        if(verifyElementPresent(MLWalletSettingsPage.objNotifications,getTextVal(MLWalletSettingsPage.objNotifications,"Page"))){
            verifyElementPresent(MLWalletSettingsPage.objNotificationMsg,getTextVal(MLWalletSettingsPage.objNotificationMsg,"Message"));
            verifyElementPresent(MLWalletSettingsPage.objNotificationBackBtn,"Notification page back button");
            logger.info("SS_TC_19, Settings, Notification page UI validated");
            extentLoggerPass("SS_TC_19", "SS_TC_19, Settings, Notification page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void settingsDeleteBuyerTierAccountValidation_SS_TC_40() throws Exception {
        HeaderChildNode("Settings, Delete Buyer tier Account validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu,"Hamburger menu");
        String sTierAccount = getText(MLWalletHomePage.objBuyerTierAccount);
        Swipe("LEFT",1);
        waitTime(3000);
        navigateToProfile1();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Option"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp,getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp,"Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccount,getTextVal(MLWalletSettingsPage.objDeleteAccount,"Page"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccountBtn,getTextVal(MLWalletSettingsPage.objDeleteAccountBtn,"Button"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn,getTextVal(MLWalletSettingsPage.objProceedBtn,"Button"));
        handleMpin("1111","MPin");
        waitTime(5000);
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu,"Hamburger menu");
        String sTierAccountAfterDelete = getText(MLWalletHomePage.objBuyerTierAccount);
        assertionValidation(sTierAccount,sTierAccountAfterDelete);
        if(sTierAccount.equals(sTierAccountAfterDelete)){
            logger.info("SS_TC_40, Settings, User is not able to delete the account when logged in with buyer tier account as it is the basic tier is validated");
            extentLoggerPass("SS_TC_40", "SS_TC_40, Settings, User is not able to delete the account when logged in with buyer tier account as it is the basic tier is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
