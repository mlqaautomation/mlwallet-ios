package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;

import java.time.Duration;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletSendTransferToMLBranch.*;
import static com.utility.Utilities.*;

public class MLWalletSendTransferToMLWalletUser extends BaseClass{
    public MLWalletSendTransferToMLWalletUser(){
        super();
    }

    //========================== Generalized methods for Send/Transfer To a ML Wallet User========================//

    public void sendMoneyMLWallet(String sTier) throws Exception {
        mlWalletLogin(sTier);
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        verifyElementPresentAndClick(MLWalletSendTransferPage.objToAMLWalletUser, getTextVal(MLWalletSendTransferPage.objToAMLWalletUser, "Button"));
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
    public static void verifyRecentTransaction3(String sTier) throws Exception
    {
        mlWalletLogout1();
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if(verifyElementPresent(MLWalletLoginPage.objMobileNoReqErrorMsg, "Mobile Number is Required Error Message"))
        {
            click(MLWalletLoginPage.objLoginBtn, "Login Button");
            type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
            click(MLWalletLoginPage.objLoginBtn, "Login Button");
        }
        enterOTP("111111");
        waitTime(5000);
        handleMpin("1111","MPin");
    }





    //======================================================================================================================//
    public void sendToMLWalletUser_STW_TC_01() throws Exception {
        HeaderChildNode("Send Money to any ML Wallet");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_Verified_ios"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 1);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            verifyRecentTransaction3(prop.getproperty("Fully_Verified_ios"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            waitTime(3000);
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            explicitWaitVisibility(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, 10);
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_01, Successfully Amount sent from Wallet to Wallet and Transaction Details is validated");
                extentLoggerPass("STW_TC_01", "STW_TC_01, Successfully Amount sent from Wallet to Wallet and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyAddToFavorites_STW_TC_12() throws Exception {
        HeaderChildNode("Send Money Add To Favorites");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(8000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber =getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objSaveToMyFavorite, getTextVal(MLWalletSendTransferPage.objSaveToMyFavorite, "Button"));
            waitTime(2000);
            if(verifyElementPresent(MLWalletSendTransferPage.objAddedToFavoritesMsg,"Successfully Added to Favorites")) {
                click(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
                waitTime(2000);
                verifyElementPresent(MLWalletSendTransferPage.objSendMoney, "Send Money Page") ;
                verifyElementPresent(MLWalletSendTransferPage.objFavoriteReceiver,"Added Favorites");
                logger.info("STW_TC_12, Added to favorites and displayed in Recent Favorites");
                extentLoggerPass("STW_TC_12", "STW_TC_12, Added to favorites and displayed in Recent Favorites");
                System.out.println("-----------------------------------------------------------");
            }
            else
            {
                logger.info("Recipient already exists");
                click(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
                click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
            }

        }
    }


    public void sendMoneyMLWalletToExistingReceiver_STW_TC_02() throws Exception {
        HeaderChildNode("Send Money ML Wallet To Existing Receiver");
//						sendMoneyAddToFavorites();
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objSelectFavorite, getTextVal(MLWalletSendTransferPage.objSelectFavorite, "Text"));
        click(MLWalletSendTransferPage.objSelectFavorite, getTextVal(MLWalletSendTransferPage.objSelectFavorite, "Text"));
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            verifyRecentTransaction3(prop.getproperty("Fully_verified"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            waitTime(3000);
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            explicitWaitVisibility(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, 20);
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_02, Successfully Amount sent from Wallet to Wallet to Recently added favorite and Transaction Details is validated");
                extentLoggerPass("STW_TC_02", "STW_TC_02, Successfully Amount sent from Wallet to Wallet to Recently added favorite and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
        getDriver().resetApp();

    }


    public void sendToMLWalletInvalidMobNumber_STW_TC_03() throws Exception {
        HeaderChildNode("Send To ML Wallet to Invalid Mobile Number");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Invalid_MobileNumber"));
        explicitWaitVisible(MLWalletSendTransferPage.objMobileNumberErrorMsg,20);
        if (verifyElementPresent(MLWalletSendTransferPage.objMobileNumberErrorMsg, getTextVal(MLWalletSendTransferPage.objMobileNumberErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objMobileNumberErrorMsg);
            String sExpectedMsg = "Mobile number is invalid";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            logger.info("STW_TC_03, Mobile number is invalid - Error Message is validated");
            extentLoggerPass("STW_TC_03", "STW_TC_03, Mobile number is invalid - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
        getDriver().resetApp();
    }


    public void sendToMLWalletUnRegisteredNumber_STW_TC_04() throws Exception {
        HeaderChildNode("Send To ML Wallet to Invalid Mobile Number");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Unregistered_MobileNumber"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objUnRegisteredMobNumber, getTextVal(MLWalletSendTransferPage.objUnRegisteredMobNumber, "Error Message"))) {
            String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objUnRegisteredMobNumber);
            String sExpectedMsg = "Receiver not Found!";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            click(MLWalletSendTransferPage.objOkBtn, "Ok Button");
            logger.info("STW_TC_04, Receiver not Found - Error Message is validated");
            extentLoggerPass("STW_TC_04", "STW_TC_04, Receiver not Found - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendToMLWalletInvalidAmount_STW_TC_05(String Amount) throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objAmountTxtField, 10);
        type(MLWalletSendTransferPage.objAmountTxtField, Amount, "Amount Text Field");
        Swipe("DOWN",1);
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objInvalidAmountMsg, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objInvalidAmountMsg, getTextVal(MLWalletSendTransferPage.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletSendTransferPage.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            extentLoggerPass("STW_TC_05", "STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendToMLWalletInsufficientAmount_STW_TC_06() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet("9999999999");
        enterMobileNumberMLWallet(prop.getproperty("ios_BranchVerifiedTier"));
        enterAmountAndSendToMLWallet("35000");
        waitTime(4000);
        if (verifyElementPresent(MLWalletSendTransferPage.objInsufficientAmountMsg, getTextVal(MLWalletSendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
            String sInsufficientBalanceErrorMsg = getText(MLWalletSendTransferPage.objInsufficientAmountMsg);
            String sExpectedErrorMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
            click(MLWalletSendTransferPage.objOkBtn, "OK Button");
            logger.info("STW_TC_06, Insufficient Balance - Error Message is validated");
            extentLoggerPass("STW_TC_06", "STW_TC_06, Insufficient Balance - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletMaximumAmount_STW_TC_07() throws Exception {
        HeaderChildNode("Send Money ML Wallet Maximum Amount");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("100000");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitErrorMsg, getTextVal(MLWalletSendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_07, The maximum send money per transaction - Error Message is validated");
            extentLoggerPass("STW_TC_07", "STW_TC_07, The maximum send money per transaction - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyDeleteFromFavorites_STW_TC_09() throws Exception {
        HeaderChildNode("Send Money Delete From Favorites");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        click(MLWalletSendTransferPage.objViewAllBtn, getTextVal(MLWalletSendTransferPage.objViewAllBtn, "Text"));
        waitTime(5000);
        click(MLWalletSendTransferPage.objEllipsisBtn, "Ellipsis Button");
        waitTime(2000);
        click(MLWalletSendTransferPage.objDeleteBtn, getTextVal(MLWalletSendTransferPage.objDeleteBtn, "Button"));
        waitTime(2000);
        click(MLWalletSendTransferPage.objConfirmBtn1, getTextVal(MLWalletSendTransferPage.objConfirmBtn1, "Button"));
        explicitWaitVisible(MLWalletSendTransferPage.objFavRemovedMsg, 10);
        if(verifyElementPresent(MLWalletSendTransferPage.objFavRemovedMsg, getTextVal(MLWalletSendTransferPage.objFavRemovedMsg, "Pop up Message"))) {
            String sRemovedSuccessfulMsg = getText(MLWalletSendTransferPage.objFavRemovedMsg);
            String sExpectedMsg = "Successfully Removed";
            assertionValidation(sRemovedSuccessfulMsg, sExpectedMsg);
            logger.info("STW_TC_09, Successfully removed Favorite Contact from favorites list is validated");
            extentLoggerPass("STW_TC_09", "STW_TC_09, Successfully removed Favorite Contact from favorites list is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletUIValidation_STW_TC_10() throws Exception {
        HeaderChildNode("Send Money ML Wallet Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        if(verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"))){
            verifyElementPresent(MLWalletSendTransferPage.objViewAllBtn,getTextVal(MLWalletSendTransferPage.objViewAllBtn,"Button"));
            verifyElementPresent(MLWalletSendTransferPage.objRecentFavorites,getTextVal(MLWalletSendTransferPage.objRecentFavorites,"Header"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiver,getTextVal(MLWalletSendTransferPage.objReceiver,"Header"));
            verifyElementPresent(MLWalletSendTransferPage.objMobileNumberField,"Mobile number input text field");
            verifyElementPresent(MLWalletSendTransferPage.objNextBtn1,getTextVal(MLWalletSendTransferPage.objNextBtn1,"Button"));
            logger.info("STW_TC_10, Send Money ML Wallet Page UI validated");
            extentLoggerPass("STW_TC_10", "STW_TC_10, Send Money ML Wallet Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyFavoritesUIValidation_STW_TC_11() throws Exception {
        HeaderChildNode("Send Money Saved Favorites UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objViewAllBtn,getTextVal(MLWalletSendTransferPage.objViewAllBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletSendTransferPage.ObjFavorites,getTextVal(MLWalletSendTransferPage.ObjFavorites,"Page"))){
            verifyElementPresent(MLWalletSendTransferPage.objSearchFavoriteField,"Search Favorites Field");
            logger.info("STW_TC_11, Send Money ML Wallet Page UI validated");
            extentLoggerPass("STW_TC_11", "STW_TC_11, Send Money ML Wallet Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletCancelTransaction_STW_TC_13(String nAmount) throws Exception {
        HeaderChildNode("Send Money ML Wallet Cancel Transaction");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objAmountTxtField, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"))) {
            type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
            Swipe("DOWN",1);
            click(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
            //	click(SendTransferPage.objNextBtn1, getTextVal(SendTransferPage.objNextBtn1, "Button"));
            waitTime(2000);
            click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
            explicitWaitVisibility(MLWalletSendTransferPage.objConfirmDetails, 10);
            verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"));
            Swipe("UP", 1);
            explicitWaitVisibility(MLWalletSendTransferPage.objCancelTransacttion1, 10);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objCancelTransacttion1,getTextVal(MLWalletSendTransferPage.objCancelTransacttion1,"Button"));
            waitTime(2000);
            if(verifyElementPresent(MLWalletSendTransferPage.objSendMoney,getTextVal(MLWalletSendTransferPage.objSendMoney,"Page"))){
                logger.info("STW_TC_13, Cancelled the current Transaction");
                extentLoggerPass("STW_TC_13", "STW_TC_13, Cancelled the current Transaction");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14() throws Exception {
        HeaderChildNode("Send Money ML Wallet Search UnFavorite User");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 5);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objViewAllBtn,getTextVal(MLWalletSendTransferPage.objViewAllBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSendTransferPage.ObjFavorites,getTextVal(MLWalletSendTransferPage.ObjFavorites,"Page"));
        type(MLWalletSendTransferPage.objSearchFavoriteField,"ABCD","Search Favorite Field");
        explicitWaitVisibility(MLWalletSendTransferPage.objNoRecentTransactionTxt, 10);
        if(verifyElementPresent(MLWalletSendTransferPage.objNoRecentTransactionTxt,getTextVal(MLWalletSendTransferPage.objNoRecentTransactionTxt,"Added Favorite"))){
            logger.info("STW_TC_14, Send Money ML Wallet Search UnFavorite User Validated");
            extentLoggerPass("STW_TC_14", "STW_TC_14, Send Money ML Wallet Search UnFavorite User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSearchFavoriteUser_STW_TC_15() throws Exception {
        HeaderChildNode("Send Money ML Wallet Search Favorite User");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objViewAllBtn,getTextVal(MLWalletSendTransferPage.objViewAllBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSendTransferPage.ObjFavorites,getTextVal(MLWalletSendTransferPage.ObjFavorites,"Page"));
        type(MLWalletSendTransferPage.objSearchFavoriteField,prop.getproperty("Last_Name"),"Search Favorite Field");
        if(verifyElementPresent(MLWalletSendTransferPage.objAddedFavorite,getTextVal(MLWalletSendTransferPage.objAddedFavorite,"Added Favorite"))){
            logger.info("STW_TC_15, Send Money ML Wallet Search Favorite User Validated");
            extentLoggerPass("STW_TC_15", "STW_TC_15, Send Money ML Wallet Search Favorite User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSuccessPageUIValidation_STW_TC_16() throws Exception {
        HeaderChildNode("Send Money ML Wallet Success Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(8000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverName,getTextVal(MLWalletSendTransferPage.objReceiverName,"Receiver Name"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
            Swipe("UP",2);
            verifyElementPresent(MLWalletSendTransferPage.objSaveToMyFavorite,getTextVal(MLWalletSendTransferPage.objSaveToMyFavorite,"Button"));
            verifyElementPresent(MLWalletSendTransferPage.objBackToHomeBtn,getTextVal(MLWalletSendTransferPage.objBackToHomeBtn,"Button"));
            verifyElementPresent(MLWalletSendTransferPage.objNewTransaction,getTextVal(MLWalletSendTransferPage.objNewTransaction,"Button"));
            click(MLWalletSendTransferPage.objBackToHomeBtn,getTextVal(MLWalletSendTransferPage.objBackToHomeBtn,"Button"));
            logger.info("STW_TC_16,Send Money ML Wallet Success Page UI Validated");
            extentLoggerPass("STW_TC_16", "STW_TC_16, Send Money ML Wallet Success Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletOTPPageUIValidation_STW_TC_17() throws Exception {
        HeaderChildNode("Send Money ML Wallet OTP PageUI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin1, "OTP Page")) {
            verifyElementPresent(MLWalletLoginPage.objOneTimePin1, "OTP text Field");
            verifyElementPresent(MLWalletLoginPage.objResendCode, getTextVal(MLWalletLoginPage.objResendCode, "Seconds"));
            logger.info("STW_TC_17, One Time Pin page UI Validated");
            extentLoggerPass("STW_TC_17", "STW_TC_16, One Time Pin page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18(String nAmount) throws Exception {
        HeaderChildNode("Send Money ML Wallet Confirm Details Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objAmountTxtField, 10);
        verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"));
        type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
        Swipe("DOWN", 1);
        click(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
        //click(SendTransferPage.objNextBtn1, getTextVal(SendTransferPage.objNextBtn1, "Button"));
        waitTime(3000);
        click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"))){
            verifyElementPresent(MLWalletSendTransferPage.objReceiverName,getTextVal(MLWalletSendTransferPage.objReceiverName,"Receiver Name"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objCancelTransacttion1,getTextVal(MLWalletSendTransferPage.objCancelTransacttion1,"Button"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletSendTransferPage.objSendPHPBtn,getTextVal(MLWalletSendTransferPage.objSendPHPBtn,"Button"));
            logger.info("STW_TC_18, Send Money ML Wallet Confirm Details Page UI Validated");
            extentLoggerPass("STW_TC_18", "STW_TC_18, Send Money ML Wallet Confirm Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19() throws Exception {
        HeaderChildNode("Send Money To Ml Wallet Enter Amount Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objAmountTxtField, 10);
        if(verifyElementPresent(MLWalletSendTransferPage.objToMLWalletUser, getTextVal(MLWalletSendTransferPage.objToMLWalletUser, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objAmountToSend, getTextVal(MLWalletSendTransferPage.objAmountToSend, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objAmountTxtField, "Amount Text Field");
            verifyElementPresent(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
            logger.info("STW_TC_19, Send Money To Ml Wallet Enter Amount Page UI Validated");
            extentLoggerPass("STW_TC_19", "STW_TC_19, Send Money To Ml Wallet Enter Amount Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletPageUIValidation_STW_TC_20() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        explicitWaitVisible(MLWalletSendTransferPage.objSendMoney, 10);
        if(verifyElementPresent(MLWalletSendTransferPage.objSendMoney,getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objRecentFavorites,getTextVal(MLWalletSendTransferPage.objRecentFavorites,"Header"));
            verifyElementPresent(MLWalletSendTransferPage.objViewAllBtn,getTextVal(MLWalletSendTransferPage.objViewAllBtn,"Button"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiver,getTextVal(MLWalletSendTransferPage.objReceiver,"Header"));
            verifyElementPresent(MLWalletSendTransferPage.objMobileNumberField, "Mobile Number Text Field");
            verifyElementPresent(MLWalletSendTransferPage.objNextBtn1, getTextVal(MLWalletSendTransferPage.objNextBtn1, "Button"));
            logger.info("STW_TC_20, Send Money To ML Wallet Page UI Validated");
            extentLoggerPass("STW_TC_20", "STW_TC_20, Send Money To ML Wallet Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21() throws Exception {
        HeaderChildNode("Transaction Details of Wallet To Wallet Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(8000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            explicitWaitVisibility(MLWalletTransactionHistoryPage.objTransactionDetails, 10);
            if(verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
                verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
                logger.info("STW_TC_21, Transaction Details of Wallet To Wallet Page UI Validation Validated");
                extentLoggerPass("STW_TC_21", "STW_TC_21, Transaction Details of Wallet To Wallet Page UI Validation Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22() throws Exception {
        HeaderChildNode("Send Money ML Wallet Buyer Tier Account User Transaction");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Buyer_Tier"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objErrorMsg, getTextVal(MLWalletSendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "Send Money is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objUpgradeNowBtn, getTextVal(MLWalletSendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STW_TC_22, Send Money is not allowed for customers at this Buyer tier - Error Message is validated");
            extentLoggerPass("STW_TC_22", "STW_TC_22, Send Money is not allowed for customers at this Buyer tier  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23() throws Exception {
        HeaderChildNode("Send Money ML Wallet Semi-Verified Account User Transaction");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Semi_Verified_One"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(8000);
        if (verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
            logger.info("STW_TC_23, Send Money ML Wallet Semi-Verified Account User Transaction validated");
            extentLoggerPass("STW_TC_23", "STW_TC_23, Send Money ML Wallet Semi-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24() throws Exception {
        HeaderChildNode("Send Money ML Wallet Branch-Verified Account User Transaction");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Branch_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Fully_verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
            logger.info("STW_TC_24, Send Money ML Wallet Branch-Verified Account User Transaction validated");
            extentLoggerPass("STW_TC_24", "STW_TC_24, Send Money ML Wallet Branch-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25() throws Exception {
        HeaderChildNode("Send Money ML Wallet Fully-Verified Account User Transaction");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            Swipe("UP", 1);
            click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
            logger.info("STW_TC_25, Send Money ML Wallet Fully-Verified Account User Transaction validated");
            extentLoggerPass("STW_TC_25", "STW_TC_25, Send Money ML Wallet Fully-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSemiVerifiedAccountMaxLimit_STW_TC_26() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Semi-Verified Account Maximum Limit Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Semi_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("60000");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitPopUp, getTextVal(MLWalletSendTransferPage.objMaxLimitPopUp, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitPopUp);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objUpgradeNowBtn, getTextVal(MLWalletSendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STB_TC_26, Send Money To ML Wallet Semi-Verified Account Maximum Limit - Error Message is validated");
            extentLoggerPass("STB_TC_26", "STB_TC_26, Send Money To ML Wallet Semi-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletBranchVerifiedAccountMaxLimit_STW_TC_29() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Branch-Verified Account Maximum Limit Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Branch_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Fully_verified"));
        enterAmountAndSendToMLWallet("60000");
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitPopUp, getTextVal(MLWalletSendTransferPage.objMaxLimitPopUp, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitPopUp);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
            logger.info("STW_TC_29, Send Money To ML Wallet Branch-Verified Account Maximum Limit - Error Message is validated");
            extentLoggerPass("STW_TC_29", "STW_TC_29, Send Money To ML Wallet Branch-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Fully-Verified Account Maximum Limit Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("60000");
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitPopUp, getTextVal(MLWalletSendTransferPage.objMaxLimitPopUp, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitPopUp);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
            logger.info("STW_TC_32, Send Money To ML Wallet Fully-Verified Account Maximum Limit - Error Message is validated");
            extentLoggerPass("STW_TC_32", "STW_TC_32, Send Money To ML Wallet Fully-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Success Message Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        Swipe("UP", 2);
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        waitTime(3000);
        verifyRecentTransaction3(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
//						if (verifyElementPresent(SendTransferPage.objWalletToWalletStatus, getTextVal(SendTransferPage.objWalletToWalletStatus, "Status"))) {
//							String sSuccessStatus = getText(SendTransferPage.objWalletToWalletStatus);
//							String sExpectedStatus = "Success";
//							assertionValidation(sSuccessStatus, sExpectedStatus);
//							logger.info("STW_TC_35, Send Money To ML Wallet Success Message validated");
//							extentLoggerPass("STW_TC_35", "STW_TC_35, Send Money To ML Wallet Success Message validated");
//							System.out.println("-----------------------------------------------------------");
//						}
        logger.info("STW_TC_35, Send Money To ML Wallet Success Message validated");
        extentLoggerPass("STW_TC_35", "STW_TC_35, Send Money To ML Wallet Success Message validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("SemiVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("SemiVerified_MaxTransactionReceiver"));
        enterAmountAndSendToMLWallet(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        waitTime(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("SemiVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_36, Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User Validated");
            extentLoggerPass("STW_TC_36", "STW_TC_36, Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User");
        sendMoneyMLWallet(prop.getproperty("BranchVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("BranchVerified_MaxTransactionReceiver"));
        enterAmountAndSendToMLWallet(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("BranchVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_38, Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User Validated");
            extentLoggerPass("STW_TC_38", "STW_TC_38, Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User");
        sendMoneyMLWallet(prop.getproperty("FullyVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("FullyVerified_MaxTransactionReceiver"));
        enterAmountAndSendToMLWallet(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("FullyVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_40, Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User Validated");
            extentLoggerPass("STW_TC_40", "STW_TC_40, Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_51() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Transaction Validation After Minimizing App");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        waitTime(5000);
        logger.info("Application relaunched after 5 Seconds");
        click(MLWalletSendTransferPage.objOkBtn, "OK Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            Swipe("UP",1);
            click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Buttton");
            logger.info("STW_TC_50, Send Money To ML Wallet Transaction Validation After Minimizing App Validated");
            extentLoggerPass("STW_TC_50", "STW_TC_50, Send Money To ML Wallet Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_57() throws Exception {
        HeaderChildNode("Send Money to any ML Wallet Transaction With Valid ML Pin");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        handleMpin("1111", "Entered Valid Mpin");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWalletDate, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletReferenceNumber, getTextVal(MLWalletSendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(MLWalletSendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_56, Send Money to any ML Wallet Transaction With Valid ML Pin validated");
                extentLoggerPass("STW_TC_56", "STW_TC_56, Send Money to any ML Wallet Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_58() throws Exception {
        HeaderChildNode("Send Money to any ML Wallet Transaction With Invalid ML Pin");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(3000);
        handleMpin("1234", "Entered Invalid Mpin");
        if (verifyElementPresent(MLWalletSendTransferPage.objInvalidPINMsg, getTextVal(MLWalletSendTransferPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletSendTransferPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("STW_TC_57, Send Money to any ML Wallet Transaction With Invalid ML Pin validated");
            extentLoggerPass("STW_TC_57", "STW_TC_57, Send Money to any ML Wallet Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63() throws Exception {
        HeaderChildNode("Send Money To ML Wallet InApp OTP popup Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("STW_TC_63, Send Money To ML Wallet, InApp OTP popup validated");
            extentLoggerPass("STW_TC_63", "STW_TC_63, Send Money To ML Wallet, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Transaction InApp OTP popup UI Validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds,getTextVal(MLWalletLoginPage.objSeconds,"Seconds"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("STW_TC_64, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            extentLoggerPass("STW_TC_64", "STW_TC_64, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65() throws Exception {
        HeaderChildNode("Send Money To ML Wallet New OTP got generated After Sixty Seconds validation");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"));
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("STW_TC_65, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("STW_TC_65", "STW_TC_65, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Transaction OTP Cancel Button Functionality");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails,getTextVal(MLWalletSendTransferPage.objConfirmDetails,"Page"))){
            logger.info("STW_TC_66, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            extentLoggerPass("STW_TC_66", "STW_TC_66, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67() throws Exception {
        HeaderChildNode("Send Money To ML Wallet Transaction OTP Continue Button Functionality");
        waitTime(2000);
        changeNumberPage();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        Swipe("Down",1);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneyMLWallet, getTextVal(MLWalletSendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("STW_TC_67, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("STW_TC_67", "STW_TC_67, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
