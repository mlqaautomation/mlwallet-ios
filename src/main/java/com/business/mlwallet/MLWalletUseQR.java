package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import com.utility.Utilities;

import java.time.Duration;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletSendTransferToMLWalletUser.*;
import static com.utility.ExtentReporter.*;
import static com.utility.Utilities.*;

public class MLWalletUseQR extends BaseClass{
    public MLWalletUseQR() {
        super();
    }
    public void useQRCodeNavigation(String sTier) throws Exception {
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletUseQRPage.objUseQR,getTextVal(MLWalletUseQRPage.objUseQR,"Icon"));
        waitTime(3000);
        verifyElementPresent(MLWalletUseQRPage.objUseQR,getTextVal(MLWalletUseQRPage.objUseQR,"Page"));
    }

    public void scanQR(String url) throws InterruptedException{
        Utilities.switchPlatformToWeb(url);
        waitTime(5000);
        closeWebBrowser();
        switchPlatformToAndroid();
    }
    public void enterMobileNumberMLWallet(String nMobileNumber) throws Exception {
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney,getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        waitTime(2000);
        type(MLWalletSendTransferPage.objMobileNumberField, nMobileNumber, "Mobile Number Text Field");
        Swipe("DOWN", 1);
        click(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
    }

    public void enterAmountAndSendToMLWallet(String nAmount) throws Exception {
        explicitWaitVisible(MLWalletSendTransferPage.objAmountTxtField, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"))) {
            explicitWaitVisibility(MLWalletSendTransferPage.objAmountTxtField, 10);
            type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
            Swipe("DOWN", 1);
            waitTime(2000);
            click(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
            click(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
            waitTime(2000);
            click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"));
            Swipe("UP", 1);
            waitTime(2000);
            click(MLWalletSendTransferPage.objSendPHPBtn, getTextVal(MLWalletSendTransferPage.objSendPHPBtn, "Button"));
            waitTime(2000);
        }
    }
    public void verifyRecentTransaction2(String sTier) throws Exception
    {
        mlWalletLogout();
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if(verifyElementPresent(MLWalletLoginPage.objMobileNoReqErrorMsg, "Mobile Number is Required Error Message"))
        {
            click(MLWalletLoginPage.objLoginBtn, "Login Button");
            type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
            click(MLWalletLoginPage.objLoginBtn, "Login Button");
        }
        enterOTP("111111");
        waitTime(5000);
        handleMpin("1111","");
    }
    public void enableCameraPopup() throws Exception {
        String loc = getText(MLWalletLoginPage.objCameraPopup);
        if (loc.contains("Allow")) {
            logger.info(loc + " Pop Up is Displayed");
            extentLoggerPass("pop up", loc + " Pop Up is Displayed");
            click(MLWalletLoginPage.objCamPopUpOKBtn, "Allow Button");
        } else {
            logger.info(" Location Pop Up is not Displayed");
            extentLoggerPass("pop up", "Location Pop Up is not Displayed");
        }
    }



    public void useQRGenerateQRCode_QR_TC_01() throws Exception {
        HeaderChildNode("Use QR, Generate QR Code");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,getTextVal(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,"Option"));
        if(verifyElementPresent(MLWalletUseQRPage.objGenerateQR,getTextVal(MLWalletUseQRPage.objGenerateQR,"Page"))){
            verifyElementPresent(MLWalletUseQRPage.objQR,"Generated QR");
            verifyElementPresent(MLWalletUseQRPage.objReceiverName,getTextVal(MLWalletUseQRPage.objReceiverName,"Receiver Name"));
            verifyElementPresent(MLWalletUseQRPage.objReceiverMobileNumber,getTextVal(MLWalletUseQRPage.objReceiverMobileNumber,"Receiver Mobile Number"));
            logger.info("QR_TC_01, Use QR, Generate QR Code Validated");
            extentLoggerPass("QR_TC_01", "QR_TC_01, Use QR, Generate QR Code Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRSendMoneyToAnyMLWalletUser_QR_TC_02() throws Exception {
        HeaderChildNode("Use QR, Send Money To Any ML Wallet User");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            Swipe("DOWN",2);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            waitTime(3000);
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("QR_TC_02, Successfully Amount sent from Wallet to Wallet using QR code and Transaction Details is validated");
                extentLoggerPass("QR_TC_02", "QR_TC_02, Successfully Amount sent from Wallet to Wallet using QR code and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void useQRInvalidQRCodeValidation_QR_TC_03() throws Exception {
        HeaderChildNode("Use QR, Invalid QR Code Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Invalid_QR"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletUseQRPage.objInvalidQRCodeMsg, getTextVal(MLWalletUseQRPage.objInvalidQRCodeMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletUseQRPage.objInvalidQRCodeMsg);
            String sExpectedErrorMsg = "Invalid QR code";
            assertionValidation(sActualErrorMsg,sExpectedErrorMsg);
            verifyElementPresent(MLWalletUseQRPage.objOKBtn,getTextVal(MLWalletUseQRPage.objOKBtn,"Button"));
            logger.info("QR_TC_03, Use QR, Invalid QR Code validated");
            extentLoggerPass("QR_TC_03", "QR_TC_03, Use QR, Invalid QR Code validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_WalletToWalletReceivedMoneyValidation_QR_TC_04(String Amount) throws Exception {
        HeaderChildNode("Use QR, Wallet to Wallet Receive Money Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet(Amount);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
        String sReferenceNumberInSender = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
        String sAmountToSend = getText(MLWalletSendTransferPage.objAmount);
        scroll_To_Text(MLWalletSendTransferPage.objBackToHomeBtn, "label", "Back To Home Button");
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        waitTime(3000);
        verifyRecentTransaction2(prop.getproperty("Branch_Verified"));
        Swipe("DOWN",2);
        verifyElementPresent(MLWalletTransactionHistoryPage.objRecentTransaction,getTextVal(MLWalletTransactionHistoryPage.objRecentTransaction,"Header"));
        verifyElementPresent(MLWalletHomePage.objWalletToWallet,getTextVal(MLWalletHomePage.objWalletToWallet,"Transaction"));
        click(MLWalletHomePage.objWalletToWallet,getTextVal(MLWalletHomePage.objWalletToWallet,"Transaction"));
        waitTime(2000);
        String sReferenceNumberInReceiver = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
        assertionValidation(sReferenceNumberInReceiver, sReferenceNumberInSender);
        String sAmountReceived = getText(MLWalletTransactionHistoryPage.objAmountReceived);
        assertionValidation(sAmountReceived,sAmountToSend);
        logger.info("QR_TC_04, Use QR, Wallet to Wallet Receive Money validated");
        extentLoggerPass("QR_TC_04", "QR_TC_04, Use QR, Wallet to Wallet Receive Money validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void useQRScanningReceiverQRCOde_QR_TC_05() throws Exception {
        HeaderChildNode("Use QR, Scanning Receiver QR Code");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"))) {
            logger.info("QR_TC_05, Use QR, Scanning Receiver QR Code validated");
            extentLoggerPass("QR_TC_05", "QR_TC_05, Use QR, Scanning Receiver QR Code validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRPageUIValidation_QR_TC_06() throws Exception {
        HeaderChildNode("Use QR Page UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        if(verifyElementPresent(MLWalletUseQRPage.objUseQR,getTextVal(MLWalletUseQRPage.objUseQR,"Page"))){
            verifyElementPresent(MLWalletUseQRPage.objUseQROptions,getTextVal(MLWalletUseQRPage.objUseQROptions,"Header"));
            verifyElementPresent(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,getTextVal(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,"Option"));
            verifyElementPresent(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
            verifyElementPresent(MLWalletUseQRPage.objReadQRCodeToSignInToWeb,getTextVal(MLWalletUseQRPage.objReadQRCodeToSignInToWeb,"Option"));
            logger.info("QR_TC_06, Use QR Page UI validated");
            extentLoggerPass("QR_TC_06", "QR_TC_06, Use QR Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRPageBackBtnValidation_QR_TC_07() throws Exception {
        HeaderChildNode("Use QR Page Back Btn Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objUseQRBackBtn,"Use QR page Back Arrow Button");
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objAvailableBalance,getTextVal(MLWalletLoginPage.objAvailableBalance,"Header"))){
            logger.info("QR_TC_07, Use QR, After clicking On  Use QR Page Back Btn, App navigates to Home page is validated");
            extentLoggerPass("QR_TC_07", "QR_TC_07, Use QR, After clicking On  Use QR Page Back Btn, App navigates to Home page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_GenerateQRPageBackBtnValidation_QR_TC_08() throws Exception {
        HeaderChildNode("Use QR, Generate QR page Back Arrow Btn Validation");
        useQRGenerateQRCode_QR_TC_01();
        verifyElementPresentAndClick(MLWalletUseQRPage.objGenerateQRBackBtn, "Generate QR Page Back Arrow button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletUseQRPage.objUseQR, getTextVal(MLWalletUseQRPage.objUseQR, "Page"))) {
            logger.info("QR_TC_08, Use QR, After clicking On  Generate QR Page Back Btn, App navigates to Use QR page is validated");
            extentLoggerPass("QR_TC_08", "QR_TC_08, Use QR, After clicking On  Generate QR Page Back Btn, App navigates to Use QR page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_GenerateQRPageUIValidation_QR_TC_11() throws Exception {
        HeaderChildNode("Use QR, Generate QR Page UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,getTextVal(MLWalletUseQRPage.objGenerateQRCodeToReceiveMoney,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletUseQRPage.objGenerateQR,getTextVal(MLWalletUseQRPage.objGenerateQR,"Page"))){
            verifyElementPresent(MLWalletUseQRPage.objQR,"Generated QR");
            verifyElementPresent(MLWalletUseQRPage.objReceiverName,getTextVal(MLWalletUseQRPage.objReceiverName,"Receiver Name"));
            verifyElementPresent(MLWalletUseQRPage.objReceiverMobileNumber,getTextVal(MLWalletUseQRPage.objReceiverMobileNumber,"Receiver Mobile Number"));
            verifyElementPresent(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
            logger.info("QR_TC_11, Use QR, Generate QR Page UI Validated");
            extentLoggerPass("QR_TC_11", "QR_TC_11, Use QR, Generate QR Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_ToMLWalletScreenUIValidation_QR_TC_12() throws Exception {
        HeaderChildNode("Use QR, To ML Wallet Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"))) {
            verifyElementPresent(MLWalletUseQRPage.objReceiverNameInEnterAmount,getTextVal(MLWalletUseQRPage.objReceiverNameInEnterAmount,"Receiver Name"));
            verifyElementPresent(MLWalletUseQRPage.objReceiverMobileNumberInEnterAmount,getTextVal(MLWalletUseQRPage.objReceiverMobileNumberInEnterAmount,"Receiver Mobile Number"));
            verifyElementPresent(MLWalletUseQRPage.objAmountInputField,"Amount Entering Field");
            verifyElementPresent(MLWalletUseQRPage.objNextBtn,getTextVal(MLWalletUseQRPage.objNextBtn,"Button"));
            logger.info("QR_TC_12, Use QR, To ML Wallet Screen UI Validated");
            extentLoggerPass("QR_TC_12", "QR_TC_12, Use QR, To ML Wallet Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_EmptyAmountFieldValidation_QR_TC_13() throws Exception {
        HeaderChildNode("Use QR, Empty Amount Input Field Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"));
        click(MLWalletUseQRPage.objNextBtn,getTextVal(MLWalletUseQRPage.objNextBtn,"Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletUseQRPage.objAmountRequiredErrorMsg, getTextVal(MLWalletUseQRPage.objAmountRequiredErrorMsg, "Error Message"))) {
            String sAmountRequiredErrorMsg = getText(MLWalletUseQRPage.objAmountRequiredErrorMsg);
            String sExceptedErrorMsg = "Amount is required";
            assertionValidation(sAmountRequiredErrorMsg, sExceptedErrorMsg);
            logger.info("QR_TC_13, Amount is required - Error message is Validated");
            extentLoggerPass("QR_TC_13", "QR_TC_13, Amount is required - Error message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_ConfirmDetailsScreenUIValidation_QR_TC_14(String sAmount) throws Exception {
        HeaderChildNode("Use QR, Confirm Details Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        waitTime(3000);
        type(MLWalletUseQRPage.objAmountInputField,sAmount,"Amount Input Field");
        Swipe("Down",1);
        click(MLWalletUseQRPage.objNextBtn, getTextVal(MLWalletUseQRPage.objNextBtn, "Button"));
        waitTime(2000);
        click(MLWalletUseQRPage.objMLWalletBalance, getTextVal(MLWalletUseQRPage.objMLWalletBalance, "Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletUseQRPage.objConfirmDetails, getTextVal(MLWalletUseQRPage.objConfirmDetails, "Page"))) {
            verifyElementPresent(MLWalletUseQRPage.objReceiverNameInConfirmDetails, getTextVal(MLWalletUseQRPage.objReceiverNameInConfirmDetails, "Receiver Name"));
            verifyElementPresent(MLWalletUseQRPage.objReceiverMobileNo, getTextVal(MLWalletUseQRPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletUseQRPage.objPaymentMethod, getTextVal(MLWalletUseQRPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletUseQRPage.objAmount, getTextVal(MLWalletUseQRPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletUseQRPage.objServiceFee, getTextVal(MLWalletUseQRPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletUseQRPage.objTotalAmount, getTextVal(MLWalletUseQRPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletUseQRPage.objCancelTransaction, getTextVal(MLWalletUseQRPage.objCancelTransaction, "Button"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletUseQRPage.objSendPHPBtn, getTextVal(MLWalletUseQRPage.objSendPHPBtn, "Button"));
            logger.info("QR_TC_14, Use QR, Confirm Details Screen UI Validated");
            extentLoggerPass("QR_TC_14", "QR_TC_14, Use QR, Confirm Details Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_OneTimePinScreenUIValidation_QR_TC_15() throws Exception {
        HeaderChildNode("Use QR, one Time Pin Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOneTimePin, "OTP text Field");
//										verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("QR_TC_15,Use QR, One Time Pin screen UI Validated");
            extentLoggerPass("QR_TC_15", "QR_TC_15,Use QR, One Time Pin screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMlWalletSuccessScreenUIValidation_QR_TC_16() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet Success Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney, "Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverName, getTextVal(MLWalletSendTransferPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletSendTransferPage.objSaveToMyFavorite, getTextVal(MLWalletSendTransferPage.objSaveToMyFavorite, "Button"));
            verifyElementPresent(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(MLWalletSendTransferPage.objNewTransaction, getTextVal(MLWalletSendTransferPage.objNewTransaction, "Button"));
            logger.info("QR_TC_16,Use QR, Send Money To ML Wallet Success Screen UI Validated");
            extentLoggerPass("QR_TC_16", "QR_TC_16, Use QR, Send Money To ML Wallet Success Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_RecentTransactionInHomeScreenUIValidation_QR_TC_17() throws Exception {
        HeaderChildNode("Use QR, Recent Transaction In Home Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        scroll_To_Text(MLWalletSendTransferPage.objBackToHomeBtn, "label", "Back To Home Button");
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"))) {
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            logger.info("QR_TC_17, Use QR, Recent Transaction In Home Screen UI Validated");
            extentLoggerPass("QR_TC_17", "QR_TC_17, Use QR, Recent Transaction In Home Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void useQR_TransactionDetailsScreenUIValidation_QR_TC_18() throws Exception {
        HeaderChildNode("Use QR, Transaction Details Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        scroll_To_Text(MLWalletSendTransferPage.objBackToHomeBtn, "label", "Back To Home Button");
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        waitTime(2000);
        verifyRecentTransaction2(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("QR_TC_18, Use QR, Transaction Details Screen UI Validated");
            extentLoggerPass("QR_TC_18", "QR_TC_18, Use QR, Transaction Details Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_CameraPermissionPopupValidation_QR_TC_19() throws Exception {
        HeaderChildNode("Use QR, Camera Permission Popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletUseQRPage.objCameraPopup,"Camera Permission Popup")){
            verifyElementPresent(MLWalletUseQRPage.objWhileUsingApp,getTextVal(MLWalletUseQRPage.objWhileUsingApp,"Button"));
            verifyElementPresent(MLWalletUseQRPage.objOnlyThisTime,getTextVal(MLWalletUseQRPage.objOnlyThisTime,"Button"));
            verifyElementPresent(MLWalletUseQRPage.objDenyButton,getTextVal(MLWalletUseQRPage.objDenyButton,"Button"));
        }else
        {
            logger.info("Camera Permission Pop Up Enabled Already");
            extentLogger("Pop Up", "Camera Permission Pop Up Enabled Already");
        }
        logger.info("QR_TC_19, Use QR, Camera Permission Popup Validated");
        extentLoggerPass("QR_TC_19", "QR_TC_19, Use QR, Camera Permission Popup Validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void useQR_CameraPermissionPopupDenyButtonFunctionality_QR_TC_20() throws Exception {
        HeaderChildNode("Use QR, Camera Permission Popup Deny Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        if(verifyElementPresent(MLWalletUseQRPage.objCameraPopup,"Camera Permission Popup"))
        {
            verifyElementPresentAndClick(MLWalletUseQRPage.objDenyButton,getTextVal(MLWalletUseQRPage.objDenyButton,"Button"));
            verifyElementPresent(MLWalletUseQRPage.objCameraNotAuthorized, getTextVal(MLWalletUseQRPage.objCameraNotAuthorized, "Message"));
            String sActualMsg = getText(MLWalletUseQRPage.objCameraNotAuthorized);
            String sExceptedMsg = "Camera not authorized";
            assertionValidation(sActualMsg,sExceptedMsg);
        }else
        {
            logger.info("Camera Permission Pop Up Enabled Already");
            extentLogger("Pop Up", "Camera Permission Pop Up Enabled Already");
        }
        logger.info("QR_TC_20, Use QR, Camera Permission Popup Deny Button Functionality Validated");
        extentLoggerPass("QR_TC_20", "QR_TC_20, Use QR, Camera Permission Popup Deny Button Functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void useQR_CameraPermissionPopupOnlyThisTimeButtonFunctionality_QR_TC_21() throws Exception {
        HeaderChildNode("Use QR, Camera Permission Popup Only This Time Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        //	verifyElementPresent(MLWalletUseQRPage.objCameraPopup,"Camera Permission Popup");
        //	verifyElementPresentAndClick(MLWalletUseQRPage.objOnlyThisTime,getTextVal(MLWalletUseQRPage.objOnlyThisTime,"Button"));
        if(verifyElementPresent(MLWalletUseQRPage.objScanQR,getTextVal(MLWalletUseQRPage.objScanQR,"Page"))){
            verifyElementPresent(MLWalletUseQRPage.objScanQRSuggestion,getTextVal(MLWalletUseQRPage.objScanQRSuggestion,"Message"));
            String sActualMsg = getText(MLWalletUseQRPage.objScanQRSuggestion);
            String sExpectedMsg = "Make sure that the QR code is within the frame";
            assertionValidation(sActualMsg,sExpectedMsg);
            logger.info("QR_TC_21, Use QR, Camera Permission Popup Only This Time Button Functionality Validated");
            extentLoggerPass("QR_TC_21", "QR_TC_21, Use QR, Camera Permission Popup Only This Time Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_CameraPermissionPopupWhileUsingTheAppButtonFunctionality_QR_TC_22() throws Exception {
        HeaderChildNode("Use QR, Camera Permission Popup While Using The App Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        verifyElementPresent(MLWalletUseQRPage.objCameraPopup,"Camera Permission Popup");
        //verifyElementPresentAndClick(MLWalletUseQRPage.objWhileUsingApp,getTextVal(MLWalletUseQRPage.objWhileUsingApp,"Button"));
        if(verifyElementPresent(MLWalletUseQRPage.objScanQR,getTextVal(MLWalletUseQRPage.objScanQR,"Page"))){
            verifyElementPresent(MLWalletUseQRPage.objScanQRSuggestion,getTextVal(MLWalletUseQRPage.objScanQRSuggestion,"Message"));
            String sActualMsg = getText(MLWalletUseQRPage.objScanQRSuggestion);
            String sExpectedMsg = "Make sure that the QR code is within the frame";
            assertionValidation(sActualMsg,sExpectedMsg);
            logger.info("QR_TC_22, Use QR, Camera Permission Popup While Using The App Button Functionality Validated");
            extentLoggerPass("QR_TC_22", "QR_TC_22, Use QR, Camera Permission Popup While Using The App Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


//								public void useQR_SendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_QR_TC_23() throws Exception {
//									HeaderChildNode("Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validation");
//									useQRCodeNavigation(prop.getproperty("Branch_Verified"));
//									verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
//
//									scanQR(prop.getproperty("Valid_QR"));
//									enterAmountAndSendToMLWallet("10");
//									enableLocation_PopUp();
//									waitTime(15000);
//									setWifiConnectionToONOFF("OFF");
//									enterOTP(prop.getproperty("Valid_OTP"));
//									if(verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))){
//										internetConnectionError();
//										logger.info("QR_TC_23, Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
//										extentLoggerPass("QR_TC_23", "QR_TC_23, Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
//										System.out.println("-----------------------------------------------------------");
//									}
//								}

    public void useQR_ScanQRCodeAfterClickingOnDenyButton_QR_TC_24() throws Exception {
        HeaderChildNode("Use QR, Scan QR Code After Clicking On Deny Button");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        verifyElementPresent(MLWalletUseQRPage.objCameraPopup,getTextVal(MLWalletUseQRPage.objCameraPopup,"Popup"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objDenyButton,getTextVal(MLWalletUseQRPage.objDenyButton,"Button"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objScanQRBackBtn,"Scan QR Page Back Arrow Button");
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        if(verifyElementPresent(MLWalletUseQRPage.objCameraPermissionRequiredPopup,getTextVal(MLWalletUseQRPage.objCameraPermissionRequiredPopup,"Popup"))){
            verifyElementPresent(MLWalletUseQRPage.objCameraPermissionRequiredMsg,getTextVal(MLWalletUseQRPage.objCameraPermissionRequiredMsg,"Message"));
            verifyElementPresent(MLWalletUseQRPage.objOKBtn,getTextVal(MLWalletUseQRPage.objOKBtn,"Button"));
            logger.info("QR_TC_24, Use QR, Scan QR Code After Clicking On Deny Button Validated");
            extentLoggerPass("QR_TC_24", "QR_TC_24, Use QR, Scan QR Code After Clicking On Deny Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


//    public void UseQR_SendMoneyToMLWalletLocationPopupValidation_QR_TC_026() throws Exception {
//        HeaderChildNode("Use QR, Send Money To ML Wallet Location popup Validation");
//        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
//        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
//        enableCameraPopup();
//        scanQR(prop.getproperty("Valid_QR"));
//        enterAmountAndSendToMLWallet("10");
//        waitTime(30000);
//        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//            locationPopUpValidation();
//            logger.info("QR_TC_026, Use QR, Send Money To ML Wallet Location popup Validated");
//            extentLoggerPass("QR_TC_026", "QR_TC_026, Use QR, Send Money To ML Wallet Location popup Validated");
//            System.out.println("-----------------------------------------------------------");
//        }
//    }
//
//
//    public void useQR_SendMoneyToMLWalletLocationDenyFunctionality_QR_TC_027() throws Exception {
//        HeaderChildNode("Use QR, Send Money To ML Wallet Location Deny Functionality Validation");
//        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
//        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
//        enableCameraPopup();
//        scanQR(prop.getproperty("Valid_QR"));
//        enterAmountAndSendToMLWallet("10");
//        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//            permissionDenyPopUp();
//            logger.info("QR_TC_027, Use QR, Send Money To ML Wallet Location Deny Functionality Validated");
//            extentLoggerPass("QR_TC_027", "QR_TC_027, Use QR, Send Money To ML Wallet Location Deny Functionality Validated");
//            System.out.println("-----------------------------------------------------------");
//        }
//    }


    public void useQR_CameraPermissionRequiredPopupValidation_QR_TC_31() throws Exception {
        HeaderChildNode("Use QR, Camera Permission Required Popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        verifyElementPresent(MLWalletUseQRPage.objCameraPopup,getTextVal(MLWalletUseQRPage.objCameraPopup,"Popup"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objDenyButton,getTextVal(MLWalletUseQRPage.objDenyButton,"Button"));
        verifyElementPresent(MLWalletUseQRPage.objCameraNotAuthorized, getTextVal(MLWalletUseQRPage.objCameraNotAuthorized, "Message"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objScanQRBackBtn,"Scan QR Page Back Arrow Button");
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        verifyElementPresent(MLWalletUseQRPage.objCameraPermissionRequiredPopup,getTextVal(MLWalletUseQRPage.objCameraPermissionRequiredPopup,"Popup"));
        verifyElementPresent(MLWalletUseQRPage.objCameraPermissionRequiredMsg,getTextVal(MLWalletUseQRPage.objCameraPermissionRequiredMsg,"Message"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objOKBtn,getTextVal(MLWalletUseQRPage.objOKBtn,"Button"));
        if(verifyElementPresent(MLWalletUseQRPage.objCameraPopup,getTextVal(MLWalletUseQRPage.objCameraPopup,"Popup"))) {
            verifyElementPresent(MLWalletUseQRPage.objWhileUsingApp, getTextVal(MLWalletUseQRPage.objWhileUsingApp, "Button"));
            verifyElementPresent(MLWalletUseQRPage.objOnlyThisTime, getTextVal(MLWalletUseQRPage.objOnlyThisTime, "Button"));
            verifyElementPresent(MLWalletUseQRPage.objDenyButton, getTextVal(MLWalletUseQRPage.objDenyButton, "Button"));
            logger.info("QR_TC_31, Use QR, Camera Permission Required Popup Validated");
            extentLoggerPass("QR_TC_31", "QR_TC_31, Use QR, Camera Permission Required Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_TransactionValidationAfterMinimizingTheApp_QR_TC_33() throws Exception {
        HeaderChildNode("Use QR, Transaction Validation After Minimizing The app");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("QR_TC_33, Use QR, Transaction Validation After Minimizing App Validated");
            extentLoggerPass("QR_TC_33", "QR_TC_33, Use QR, Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_SendMoneyToMLWalletWhenReceiverQRCodeCapturedByCamera_QR_TC_39() throws Exception {
        HeaderChildNode("Use QR, Send Money To Any ML Wallet When Receiver QR Code Captured By Camera");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            verifyRecentTransaction2(prop.getproperty("Branch_Verified"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            waitTime(2000);
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("QR_TC_39, Successfully Amount sent from Wallet to Wallet using QR Code Captured By Camera and Transaction Details is validated");
                extentLoggerPass("QR_TC_39", "QR_TC_39, Successfully Amount sent from Wallet to Wallet using QR Code Captured By Camera and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void useQR_SendMoneyToMLWalletInOTPPopupValidation_QR_TC_40() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet InApp OTP popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("QR_TC_40, Use QR, Send Money To ML Wallet InApp OTP popup validated");
            extentLoggerPass("QR_TC_40", "QR_TC_40, Use QR, Send Money To ML Wallet InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_QR_TC_41() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds,getTextVal(MLWalletLoginPage.objSeconds,"Seconds"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("QR_TC_41, Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            extentLoggerPass("QR_TC_41", "QR_TC_41, Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_QR_TC_42() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet New OTP got generated After Sixty Seconds validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            for(int i=1;i<=60;i++){
                click1(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            }
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("QR_TC_42, Use QR, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("QR_TC_42", "QR_TC_42, Use QR, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_QR_TC_43() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet Transaction OTP Cancel Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletUseQRPage.objConfirmDetails,getTextVal(MLWalletUseQRPage.objConfirmDetails,"Page"))){
            logger.info("QR_TC_43, Use QR, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            extentLoggerPass("QR_TC_43", "QR_TC_43, Use QR, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletOTPContinueBtnFunctionality_QR_TC_44() throws Exception {
        HeaderChildNode("Use QR, Send Money To ML Wallet Transaction OTP Continue Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQRPage.objReadQRCodeToSendMoney,getTextVal(MLWalletUseQRPage.objReadQRCodeToSendMoney,"Option"));
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("QR_TC_44, Use QR, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("QR_TC_44", "QR_TC_44, Use QR, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



}
