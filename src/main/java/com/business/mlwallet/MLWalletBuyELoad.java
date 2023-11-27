package com.business.mlwallet;

import com.iosmlwalletpages.*;
import com.utility.Utilities;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletLogin.mlWalletLogin;
import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

public class MLWalletBuyELoad extends BaseClass {

    public MLWalletBuyELoad() {
        super();
    }

    public void eLoad_generic(String sTier, String mobileNo, String status, int telcoOption) throws Exception {
        waitTime(3000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(5000);
        if (status.equals("true")) {
            verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, "eLoad Transaction Page");
            click(MLWalletEloadPage.telcoOptions(telcoOption), "Telco");
        }
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        explicitWaitVisible(MLWalletEloadPage.objNextBtn, 10);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
        waitTime(5000);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
    }

    public void verifyRecentTransaction() throws Exception
    {
        mlWalletLogout();
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        enterOTP("111111");
        waitTime(5000);
    }

    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Second time Load selection popup validation");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresentAndClick(MLWalletEloadPage.objBuyLoadBackArrowBtn, "Buy Load Back Arrow Button");
        waitTime(3000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletEloadPage.objSecondTimeConfirmationPopup, getTextVal(MLWalletEloadPage.objSecondTimeConfirmationPopup, "Popup"))) {
            logger.info("BE_TC_29, Buy ELoad Second time Load selection popup validated");
            extentLoggerPass("BE_TC_29", "BE_TC_29, Buy ELoad Second time Load selection popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        enterOTP("111111");
        waitTime(10000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_45, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            extentLoggerPass("BE_TC_45", "BE_TC_45, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_48(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 2);
        click(MLWalletEloadPage.objLDLoad3000, getTextVal(MLWalletEloadPage.objLDLoad3000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            extentLoggerPass("BE_TC_45", "BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadFailedTransactionPopupValidation_BE_TC_70(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy eLoad, Failed transaction popup validation");
        eLoad_generic(sTier, prop.getproperty("Fully_Verified"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objData10, getTextVal(MLWalletEloadPage.objData10, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        enterOTP("111111");
        waitTime(10000);
        if (verifyElementPresent(MLWalletEloadPage.objFailedPaymentMsg, getTextVal(MLWalletEloadPage.objFailedPaymentMsg, "popup message"))) {
            String sActualMsg = getText(MLWalletEloadPage.objFailedPaymentMsg);
            String sExceptedMsg = "Payment pushed through but the transaction was not fulfilled or posted, request a refund proceed transaction";
            assertionValidation(sActualMsg, sExceptedMsg);
            verifyElementPresent(MLWalletEloadPage.objOkBtn, getTextVal(MLWalletEloadPage.objOkBtn, "Button"));
            logger.info("BE_TC_70, Buy eLoad, Failed transaction popup validated");
            extentLoggerPass("BE_TC_70", "BE_TC_70, Failed transaction popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadFailedTransactionPopupOkBtnFunctionality_BE_TC_71(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy eLOad, Failed transaction popup Ok button functionality validated");
        eLoad_generic(sTier, prop.getproperty("Fully_Verified"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objData10, getTextVal(MLWalletEloadPage.objData10, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        enterOTP("111111");
        waitTime(10000);
        verifyElementPresent(MLWalletEloadPage.objFailedPaymentMsg, getTextVal(MLWalletEloadPage.objFailedPaymentMsg, "popup message"));
        verifyElementPresentAndClick(MLWalletEloadPage.objOkBtn, getTextVal(MLWalletEloadPage.objOkBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objRequestRefund, getTextVal(MLWalletEloadPage.objRequestRefund, "page"))) {
            logger.info("BE_TC_71, Buy eLoad, After clicking on Ok button on Failed transaction popup, App navigates to Request refund page is validated");
            extentLoggerPass("BE_TC_71", "BE_TC_71, Buy eLoad, After clicking on Ok button on Failed transaction popup, App navigates to Request refund page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadRequestRefundBtnFunctionality_BE_TC_72(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy eLOad, Request refund functionality validated");
        eLoad_generic(sTier, prop.getproperty("Fully_Verified"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objData10, getTextVal(MLWalletEloadPage.objData10, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        enterOTP("111111");
        waitTime(10000);
        verifyElementPresent(MLWalletEloadPage.objFailedPaymentMsg, getTextVal(MLWalletEloadPage.objFailedPaymentMsg, "popup message"));
        verifyElementPresentAndClick(MLWalletEloadPage.objOkBtn, getTextVal(MLWalletEloadPage.objOkBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objRequestRefund, getTextVal(MLWalletEloadPage.objRequestRefund, "page"));
        verifyElementPresentAndClick(MLWalletEloadPage.objRequestRefundBtn, getTextVal(MLWalletEloadPage.objRequestRefundBtn, "button"));
        if (verifyElementPresent(MLWalletEloadPage.objSelfServiceSupportForm, getTextVal(MLWalletEloadPage.objSelfServiceSupportForm, "Google page"))) {
            logger.info("BE_TC_72, Buy eLoad, After clicking on Ok button Request refund, App navigates to Self service support google page is validated");
            extentLoggerPass("BE_TC_71", "BE_TC_71, Buy eLoad, After clicking on Ok button Request refund, App navigates to Self service support google page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
//    ===================================================================================   //
    //===================================================================================================//



    public void buyELoadTransactionDetails_BE_TC_01(String sTier,int promotab) throws Exception
    {
        HeaderChildNode("Transaction Details Validation after Buying eLoad");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("GLOBE"), "true", promotab);
        waitTime(5000);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        waitTime(5000);
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(3000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(40000);
        if(verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Page"))){
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails,getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails,"Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objBuyELoadTime,getTextVal(MLWalletEloadPage.objBuyELoadTime,"Date and Time"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            click(MLWalletCashOutPage.objBackToHomeBtn, "Back To Home Buttton");
            logger.info("BE_TC_01, Transaction Details Validated after Buying eLoad");
            extentLoggerPass("BE_TC_01", "BE_TC_01, Transaction Details Validated after Buying eLoad");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadInvalidMobileNumber_BE_TC_02() throws Exception
    {
        HeaderChildNode("Buying eLoad using invalid mobile number");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(prop.getproperty("Branch_Verified"),prop.getproperty("inValidMobNumber"),"true", 3);
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objErrorMsg, getTextVal(MLWalletEloadPage.objErrorMsg, "Pop Up Message"))){
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsg);
            String sExceptedErrorMsg = "Network and Mobile number does not match";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("BE_TC_02, Buy ELoad Using Invalid Mobile Number, Network and Mobile number does not match Error Message Validated");
            extentLoggerPass("BE_TC_02", "BE_TC_02, Buy ELoad Using Invalid Mobile Number, Network and Mobile number does not match Error Message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadWithoutInputMobNumber_BE_TC_03() throws Exception
    {
        HeaderChildNode("Buying eLoad without mobile number input");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(prop.getproperty("Branch_Verified"),"", "true", 3);
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objErrorMsgOne, getTextVal(MLWalletEloadPage.objErrorMsgOne, "Pop Up Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsgOne);
            String sExceptedErrorMsg = "Mobile number is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_03, Buy ELoad without mobile number input, Mobile number is required Error Message is validated");
            extentLoggerPass("BE_TC_03", "BE_TC_03, Buy ELoad without mobile number input, Mobile number is required Error Message is validated");
        }
    }

    public void buyELoadWithoutTelecommunicationSelected_BE_TC_04() throws Exception
    {
        HeaderChildNode("Buying eLoad without telecommunication selected");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(prop.getproperty("Branch_Verified"),prop.getproperty("sunMobileNumber"),"false", 3);
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objErrorMsg, getTextVal(MLWalletEloadPage.objErrorMsg, "Pop Up Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsg);
            String sExceptedErrorMsg = "Network and Mobile number does not match";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_04, Buying eLoad without selecting telecommunication, Network and Mobile number does not match Error Msg Validated");
            extentLoggerPass("BE_TC_04", "BE_TC_04, Buying eLoad without selecting telecommunication, Network and Mobile number does not match Error Msg Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadInsufficientBalance_BE_TC_05(String sTier,int promotab) throws Exception
    {
        HeaderChildNode("Buying eLoad with insufficient balance");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletEloadPage.objPromoLoads,getTextVal(MLWalletEloadPage.objPromoLoads,"Load"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.obJconfirmBtnTwo, "Confirm Button");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objInsufficientBalPopup, getTextVal(MLWalletEloadPage.objInsufficientBalPopup, "Pop up"));
        logger.info("BE_TC_05, Insufficient Balance Error Message Validated");
        extentLoggerPass("BE_TC_05", "BE_TC_05, Insufficient Balance Error Message Validated");
    }


    public void buyELoadMaxLimitPerTransaction_BE_TC_09(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Maximum Limit per Transaction");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        //	swipeDownUntilElementVisible("Smart Regular Load 3000");
        verifyElementPresentAndClick(MLWalletEloadPage.obj3000RegularLoad,getTextVal(MLWalletEloadPage.obj3000RegularLoad,"Load"));
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(2000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if(verifyElementPresent(MLWalletEloadPage.objMaxLimitPopupMsg,getTextVal(MLWalletEloadPage.objMaxLimitPopupMsg,"Error Popup Msg"))){
            String sActualPopupMsg = getText(MLWalletEloadPage.objMaxLimitPopupMsg);
            String sExceptedPopupMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sActualPopupMsg,sExceptedPopupMsg);
            logger.info("BE_TC_09, Buy ELoad Maximum Limit per Transaction Validated");
            extentLoggerPass("BE_TC_09", "BE_TC_09, Buy ELoad Maximum Limit per Transaction Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionPageUIValidation_BE_TC_10(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Transaction Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage,getTextVal(MLWalletEloadPage.objEloadtransactionPage,"Page"))){
            verifyElementPresent(MLWalletEloadPage.objSelectTelco,getTextVal(MLWalletEloadPage.objSelectTelco,"Header"));
            verifyElementPresent(MLWalletEloadPage.objPhoneToLoad,getTextVal(MLWalletEloadPage.objPhoneToLoad,"Header"));
            verifyElementPresent(MLWalletEloadPage.objMobileNoField,"Mobile Number Input Field");
            verifyElementPresent(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
            verifyElementPresent(MLWalletEloadPage.objNextBtn,getTextVal(MLWalletEloadPage.objNextBtn,"Button"));
            logger.info("BE_TC_10, Buy ELoad Transaction Page UI Validated");
            extentLoggerPass("BE_TC_10", "BE_TC_10, Buy ELoad Transaction Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(String sTier,String mobileNo,int telcoOption) throws Exception {
        HeaderChildNode("Buy ELoad Next Button Functionality On ELoad Transaction Page");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(3000);
        verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, "eLoad Transaction Page");
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        click(MLWalletEloadPage.telcoOptions(telcoOption),"Telco");
        click(MLWalletEloadPage.telcoOptions(telcoOption),"Telco");
        click(MLWalletEloadPage.objNextBtn, "Next Button");
        click(MLWalletEloadPage.objNextBtn, "Next Button");
        explicitWaitVisibility(MLWalletEloadPage.objLoadSelectionPage, 10);
        if(verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page")){
            logger.info("BE_TC_11, Buy ELoad Next Button Functionality On ELoad Transaction Page Validated");
            extentLoggerPass("BE_TC_11", "BE_TC_11, Buy ELoad Next Button Functionality On ELoad Transaction Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12() throws Exception {
        HeaderChildNode("Buy ELoad Load Selection Back Arrow Button Validation");
        waitTime(2000);
        changeNumberPage();
        buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(prop.getproperty("Branch_Verified"),prop.getproperty("sunMobileNumber"),4);
        verifyElementPresentAndClick(MLWalletEloadPage.objLoadSelectionBackArrowBtn,"Load Selection Back Arrow Button");
        explicitWaitVisibility(MLWalletEloadPage.objEloadtransactionPage, 10);
        if(verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage,getTextVal(MLWalletEloadPage.objEloadtransactionPage,"Page"))){
            logger.info("BE_TC_12, After clicking on Back Arrow Btn on Load Selection Page, Application Navigates to eLoad Transaction Page is Validated");
            extentLoggerPass("BE_TC_12", "BE_TC_12,  After clicking on Back Arrow Btn on Load Selection Page, Application Navigates to eLoad Transaction Page is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLoadSelectionPageUIValidation_BE_TC_13(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Load Selection Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        waitTime(3000);
        if(verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage,getTextVal(MLWalletEloadPage.objLoadSelectionPage,"Page"))){
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInLoadSelection,getTextVal(MLWalletEloadPage.objMobileNumberInLoadSelection,"Number"));
            verifyElementPresent(MLWalletEloadPage.objChange,getTextVal(MLWalletEloadPage.objChange,"button"));
            verifyElementPresent(MLWalletEloadPage.objWalletBalanceInLoadSeletion,getTextVal(MLWalletEloadPage.objWalletBalanceInLoadSeletion,"Balance"));
            verifyElementPresent(MLWalletEloadPage.objPromoLoadTab,getTextVal(MLWalletEloadPage.objPromoLoadTab,"Tab"));
            verifyElementPresent(MLWalletEloadPage.objRegularLoadTab,getTextVal(MLWalletEloadPage.objRegularLoadTab,"Tab"));
            verifyElementPresent(MLWalletEloadPage.objPromoLoads,getTextVal(MLWalletEloadPage.objPromoLoads,"Promo Load"));
//									List<WebElement> values = findElements(MLWalletEloadPage.objPromoLoads);
//									for (int i = 0; i < values.size(); i++) {
//										String sPromoLoads = values.get(i).getText();
//										logger.info("Promo Load : " + sPromoLoads + " is displayed");
//										extentLogger(" ", "Promo Load : " + sPromoLoads + " is displayed");
//									}
            logger.info("BE_TC_13, Buy ELoad Load Selection Page UI Validated");
            extentLoggerPass("BE_TC_13", "BE_TC_13,  Buy ELoad Load Selection Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Load Selection Change Button Functionality Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        explicitWaitVisibility(MLWalletEloadPage.objChange, 10);
        verifyElementPresentAndClick(MLWalletEloadPage.objChange,getTextVal(MLWalletEloadPage.objChange,"Button"));
        explicitWaitVisibility(MLWalletEloadPage.objEloadtransactionPage, 10);
        if(verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage,getTextVal(MLWalletEloadPage.objEloadtransactionPage,"Page"))){
            logger.info("BE_TC_14, After clicking on Change Btn in Load Selection Page, Application navigates to eLoad Transaction page is Validated");
            extentLoggerPass("BE_TC_14", "BE_TC_14, After clicking on Change Btn in Load Selection Page, Application navigates to eLoad Transaction page is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionDetailsPageUIValidation_BE_TC_15(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction Details Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        explicitWaitVisibility(MLWalletEloadPage.objLoadSelectionPage, 10);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        explicitWaitVisible(MLWalletEloadPage.objContinuePromoPopUp, 10);
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        explicitWaitVisibility(MLWalletEloadPage.objBuyLoad, 15);
        if(verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"))){
            verifyElementPresent(MLWalletEloadPage.objLoadWithAmount,getTextVal(MLWalletEloadPage.objLoadWithAmount,"Load With Amount"));
            verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Header"));
            verifyElementPresent(MLWalletEloadPage.objMobileNumber,getTextVal(MLWalletEloadPage.objMobileNumber,"Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletEloadPage.objConfirmBtn,getTextVal(MLWalletEloadPage.objConfirmBtn,"Button"));
            logger.info("BE_TC_15, Buy ELoad Transaction Details Page UI Validated");
            extentLoggerPass("BE_TC_15", "BE_TC_15, Buy ELoad Transaction Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Select From Contacts Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"))){
            logger.info("BE_TC_16, Buy ELoad, After clicking on Select From Contacts Application Navigates to Contacts Page");
            extentLoggerPass("BE_TC_16", "BE_TC_16, Buy ELoad, After clicking on Select From Contacts Application Navigates to Contacts Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactsPageUIValidation_BE_TC_17(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Contacts Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objFavorites,getTextVal(MLWalletEloadPage.objFavorites, "Page"));
            List<WebElement> listOfContacts = findElements(MLWalletEloadPage.objListOfContacts);
            for (int i = 0; i < listOfContacts.size(); i++) {
                if (i % 2 == 0) {
                    String namesOfContacts = listOfContacts.get(i).getText();
                    logger.info("Contact Names : " + namesOfContacts + " is displayed");
                    extentLogger(" ", "Contact Name : " + namesOfContacts + " is displayed");
                }
            }
        }
        logger.info("BE_TC_17, Buy ELoad Contacts Page UI Validated");
        extentLoggerPass("BE_TC_17", "BE_TC_17, Buy ELoad Contacts Page UI Validated");
        System.out.println("-----------------------------------------------------------");
    }




    public void buyELoadContactsPageBackBtnValidation_BE_TC_18(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Contacts Page Back Arrow Button Validation");
        waitTime(2000);
        changeNumberPage();
        buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(sTier);
        explicitWaitVisibility(MLWalletEloadPage.objContactsPageBackBtn, 10);
        verifyElementPresentAndClick(MLWalletEloadPage.objContactsPageBackBtn,"Contacts Page back arrow Button");
        explicitWaitVisibility(MLWalletEloadPage.objEloadtransactionPage, 10);
        if(verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage,getTextVal(MLWalletEloadPage.objEloadtransactionPage,"Page"))){
            logger.info("BE_TC_18, Buy ELoad Contacts Page Back Arrow Button Validated");
            extentLoggerPass("BE_TC_18", "BE_TC_18, Buy ELoad Contacts Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchFieldValidation_BE_TC_19(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Search Field Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"));
        waitTime(3000);
        verifyElementPresent(MLWalletEloadPage.objSearch,"Contact Search");
        click(MLWalletEloadPage.objSearch, "Contact Search Tab");
        type(MLWalletEloadPage.objSearch, "Globe", "Contact Search");
        List<WebElement> listOfContacts = findElements(MLWalletEloadPage.objListOfContacts);
        for (int i = 0; i < listOfContacts.size(); i++) {
            if (i % 2 == 0) {
                String namesOfContacts = listOfContacts.get(i).getText();
                logger.info("Contact Names : " + namesOfContacts + " is displayed");
                extentLogger(" ", "Contact Name : " + namesOfContacts + " is displayed");
            }
        }
        logger.info("BE_TC_19, Buy ELoad Search Field Validated");
        extentLoggerPass("BE_TC_19", "BE_TC_19, Buy ELoad Search Field Validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void buyELoadAddContactToFavorites_BE_TC_20(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Add Contact To Favorites");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(4000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objAllowBtn,"Allow Button"))
        {
            click(MLWalletEloadPage.objAllowBtn, "Allow Button");
        }
        verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"));
        type(MLWalletEloadPage.objSearch, "Globe", "Contact Search");
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName,getTextVal(MLWalletEloadPage.objSearchedContactName,"Contact name"));
        String sContactName = getText(MLWalletEloadPage.objSearchedContactName);
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        click(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        waitTime(2000);
        pullToRefresh1();
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites,getTextVal(MLWalletEloadPage.objFavorites,"Button"));
        waitTime(2000);
        pullToRefresh1();
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objSearchedContactName,getTextVal(MLWalletEloadPage.objSearchedContactName,"Contact name"))){
            String sContactNameInFavorites = getText(MLWalletEloadPage.objSearchedContactName);
            String trimmed =sContactName.replaceAll("\\s{2,}", " ").trim();
            String sConcatNameConverted=trimmed.toUpperCase();
            assertionValidation(sConcatNameConverted, sContactNameInFavorites);
            logger.info("BE_TC_20, Buy ELoad Add Contact To Favorites Validated");
            extentLoggerPass("BE_TC_20", "BE_TC_20, Buy ELoad Add Contact To Favorites Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadAddedContactToFavoritesValidation_BE_TC_21(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Added Contacts To Favorites validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objAllowBtn,"Allow Button"))
        {
            click(MLWalletEloadPage.objAllowBtn, "Allow Button");
        }
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"));
        type(MLWalletEloadPage.objSearch, prop.getproperty("contactNumberone"), "Contact Search");
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName,getTextVal(MLWalletEloadPage.objSearchedContactName,"Contact name"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        click(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        waitTime(2000);
        pullToRefresh1();
        if(verifyElementPresentAndClick(MLWalletEloadPage.objFavorites,getTextVal(MLWalletEloadPage.objFavorites,"Button"))){
            waitTime(2000);
            List<WebElement> listOfContacts = findElements(MLWalletEloadPage.objListOfContacts);
            for (int i = 0; i < listOfContacts.size(); i++) {
                if (i % 2 == 0) {
                    String namesOfContacts = listOfContacts.get(i).getText();
                    logger.info("Contact Names : " + namesOfContacts + " is displayed");
                    extentLogger(" ", "Contact Name : " + namesOfContacts + " is displayed");
                }
            }
            logger.info("BE_TC_21, Buy ELoad Added Contacts To Favorites Validated");
            extentLoggerPass("BE_TC_21", "BE_TC_21, Buy ELoad Added Contacts To Favorites Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchAddedFavoriteContact_BE_TC_22(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Search Added Favorite Contact");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objAllowBtn,"Allow Button"))
        {
            click(MLWalletEloadPage.objAllowBtn, "Allow Button");
        }
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"));
        type(MLWalletEloadPage.objSearch, "Globe", "Contact Search");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName,getTextVal(MLWalletEloadPage.objSearchedContactName,"Contact name"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        click(MLWalletEloadPage.objAddToFavoriteIcon,"Add To Favorite Icon");
        waitTime(2000);
        pullToRefresh1();
        waitTime(2000);
        click(MLWalletEloadPage.objSearchOne,"Search field");
        clearField(MLWalletEloadPage.objSearchOne,"Search field");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites,getTextVal(MLWalletEloadPage.objFavorites,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objSearch,"Contact Search")) {
            type(MLWalletEloadPage.objSearch, "Globe", "Contact Search");
            verifyElementPresent(MLWalletEloadPage.objSearchedContactName,getTextVal(MLWalletEloadPage.objSearchedContactName,"Contact name"));
            logger.info("BE_TC_22, Buy ELoad Search Added Favorite Contact Validated");
            extentLoggerPass("BE_TC_22", "BE_TC_22, Buy ELoad Search Added Favorite Contact Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchUnFavoriteContact_BE_TC_23(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Search UnFavorite Contact");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objAllowBtn,"Allow Button"))
        {
            click(MLWalletEloadPage.objAllowBtn, "Allow Button");
        }
        verifyElementPresent(MLWalletEloadPage.objContacts,getTextVal(MLWalletEloadPage.objContacts,"Page"));
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites,getTextVal(MLWalletEloadPage.objFavorites,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objSearch,"Contact Search")) {
            type(MLWalletEloadPage.objSearch, "9999999999", "Contact Search");
            verifyElementPresent(MLWalletEloadPage.objNoFavoritesFoundMsg,getTextVal(MLWalletEloadPage.objNoFavoritesFoundMsg,"Message"));
            logger.info("BE_TC_23, Buy ELoad Search UnFavorite Contact Validated");
            extentLoggerPass("BE_TC_23", "BE_TC_23, Buy ELoad Search UnFavorite Contact Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadPromoConfirmationPopupValidation_BE_TC_24(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Promo Confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, "Promo");
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp,getTextVal(MLWalletEloadPage.objContinuePromoPopUp,"Popup Msg"))){
            verifyElementPresent(MLWalletEloadPage.objConfirmBtn,getTextVal(MLWalletEloadPage.objConfirmBtn,"Button"));
            verifyElementPresentAndClick(MLWalletEloadPage.objCancelBtn,getTextVal(MLWalletEloadPage.objCancelBtn,"Button"));
            logger.info("BE_TC_24, Buy ELoad Promo Confirmation Popup Validated");
            extentLoggerPass("BE_TC_24", "BE_TC_24, Buy ELoad Promo Confirmation Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadOTPPageUIValidation_BE_TC_25(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad OTP page UI Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        waitTime(5000);
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction,  "Promo");
        explicitWaitVisibility(MLWalletEloadPage.objContinuePromoPopUp, 10);
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            //click(SendTransferPage.objBackArrow, "Back Arrow Button");
            click(MLWalletEloadPage.objOTPCancelBtn, "OTP Cancel Button");
            logger.info("BE_TC_25, Buy ELoad One Time Pin page UI Validated");
            extentLoggerPass("BE_TC_25", "BE_TC_25, Buy ELoad One Time Pin page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Successful Transaction UI Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        waitTime(5000);
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction,  "Promo");
        explicitWaitVisibility(MLWalletEloadPage.objContinuePromoPopUp, 10);
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(2000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(20000);
        verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Page"));
        verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails, getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails, "Mobile Number"));
        verifyElementPresent(MLWalletEloadPage.objBuyELoadTime, getTextVal(MLWalletEloadPage.objBuyELoadTime, "Date and Time"));
        verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
        verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
        verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
        click(MLWalletCashOutPage.objBackToHomeBtn, "Back To Home Button");
        logger.info("BE_TC_26, Buy ELoad Successful Transaction UI validated");
        extentLoggerPass("BE_TC_26", "BE_TC_26, Buy ELoad Successful Transaction UI validated");
        System.out.println("-----------------------------------------------------------");
    }




    public void buyELoadRecentTransactionUIValidation_BE_TC_27() throws Exception {
        HeaderChildNode("Buy ELoad Recent Transaction UI Validation");
        waitTime(2000);
        changeNumberPage();
        buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Branch_Verified"),4);
        verifyRecentTransaction();
        if(verifyElementPresent(MLWalletHomePage.objRecentTransactions,getTextVal(MLWalletHomePage.objRecentTransactions,"Header"))){
            verifyElementPresent(MLWalletHomePage.objBuyELoadTransaction,getTextVal(MLWalletHomePage.objBuyELoadTransaction,"Transaction"));
            String sStatus = getText(MLWalletHomePage.objBuyELoadTransaction);
            String postedStatus=sStatus.substring(2, 8);
            System.out.println(postedStatus);
            String sExpectedStatus = "Posted";
            assertionValidation(postedStatus,sExpectedStatus);
            logger.info("BE_TC_27, Buy ELoad Recent Transaction UI validated");
            extentLoggerPass("BE_TC_27", "BE_TC_27, Buy ELoad Recent Transaction UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void buyELoadTransactionDetailsUIValidation_BE_TC_28() throws Exception {
        HeaderChildNode("Buy ELoad Transaction Details UI Validation");
        waitTime(2000);
        changeNumberPage();
        buyELoadRecentTransactionUIValidation_BE_TC_27();
        click(MLWalletHomePage.objBuyELoadTransaction,getTextVal(MLWalletHomePage.objBuyELoadTransaction,"Transaction"));
        waitTime(15000);
        if(verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objLoadType, getTextVal(MLWalletTransactionHistoryPage.objLoadType, "Load Type"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
            logger.info("BE_TC_28, Buy ELoad Transaction Details UI validated");
            extentLoggerPass("BE_TC_28", "BE_TC_28, Buy ELoad Transaction Details UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Semi verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_30, Buy ELoad maximum transaction for Semi verified Tier validated");
            extentLoggerPass("BE_TC_30", "BE_TC_42, Buy ELoad maximum transaction for Semi verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Semi verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 1);
        click(MLWalletEloadPage.objLDLoad3000, getTextVal(MLWalletEloadPage.objLDLoad3000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_33, Buy ELoad maximum Limit reached Error msg validated for Semi verified Tier");
            extentLoggerPass("BE_TC_33", "BE_TC_33, Buy ELoad maximum Limit reached Error msg validated for Semi verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Fully verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_36, Buy ELoad maximum transaction for Fully verified Tier validated");
            extentLoggerPass("BE_TC_36", "BE_TC_36, Buy ELoad maximum transaction for Fully verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Fully verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 1);
        click(MLWalletEloadPage.objLDLoad3000, getTextVal(MLWalletEloadPage.objLDLoad3000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_39, Buy ELoad maximum Limit reached Error msg validated for Fully verified Tier");
            extentLoggerPass("BE_TC_39", "BE_TC_39, Buy ELoad maximum Limit reached Error msg validated for Fully verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Branch verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_42, Buy ELoad maximum transaction for Branch verified Tier validated");
            extentLoggerPass("BE_TC_42", "BE_TC_42, Buy ELoad maximum transaction for Branch verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Buyer Tier verified Tier");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_48, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            extentLoggerPass("BE_TC_48", "BE_TC_48, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }





    public void buyELoadContactsPermissionPopup_BE_TC_57(String sTier) throws Exception {
        HeaderChildNode("Buy ELoad Contacts Permission Popup");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(4000);
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, "Contacts Popup Message")) {
            verifyElementPresent(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
        }else
        {
            logger.info("Contacts already Exists");
            extentLoggerPass("Contact","Contacts already Exists");
        }
        logger.info("BE_TC_57, Buy ELoad Contacts Permission Popup Validated");
        extentLoggerPass("BE_TC_57", "BE_TC_57, Buy ELoad Location popup Allow Button Functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }



    public void buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_58()throws Exception {
        HeaderChildNode("Buy ELoad Contacts Permission Popup Allow Button Functionality");
        buyELoadContactsPermissionPopup_BE_TC_57(prop.getproperty("Fully_Verified"));
        if (verifyElementPresent(MLWalletHomePage.objContactPopUpAllowBtn,"Contacts Pop Up Allow Button")) {
            click(MLWalletHomePage.objContactPopUpAllowBtn,getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
            List<WebElement> listOfContacts = findElements(MLWalletEloadPage.objListOfContacts);
            for (int i = 0; i < listOfContacts.size(); i++) {
                if (i % 2 == 0) {
                    String namesOfContacts = listOfContacts.get(i).getText();
                    logger.info("Contact Names : " + namesOfContacts + " is displayed");
                    extentLogger(" ", "Contact Name : " + namesOfContacts + " is displayed");
                }
            }
        }
        logger.info("BE_TC_58, Buy ELoad Contacts Permission Popup Allow Button Functionality Validated");
        extentLoggerPass("BE_TC_58","BE_TC_58, Buy ELoad Contacts Permission Popup Allow Button Functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_59() throws Exception {
        HeaderChildNode("Buy ELoad Contacts Permission Popup Deny Button Functionality");
        buyELoadContactsPermissionPopup_BE_TC_57(prop.getproperty("Fully_Verified"));
        if(verifyElementPresent(MLWalletHomePage.objPopUpDenyBtn, "Contacts Pop up Deny Button")) {
            click(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
            verifyElementPresentAndClick(MLWalletEloadPage.objContactsPageBackBtn,"Contact Page Back Arrow Button");
            verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts,getTextVal(MLWalletEloadPage.objSelectFromContacts,"Button"));
            verifyElementPresent(MLWalletEloadPage.objContactPopupMsg,getTextVal(MLWalletEloadPage.objContactPopupMsg,"Popup"));
            verifyElementPresent(MLWalletEloadPage.objAllowAccess,getTextVal(MLWalletEloadPage.objAllowAccess,"Button"));
        }
        logger.info("BE_TC_59, Buy ELoad Contacts Permission Popup Deny Button Functionality Validated");
        extentLoggerPass("BE_TC_59", "BE_TC_59, Buy ELoad Contacts Permission Popup Deny Button Functionality Validated");
        System.out.println("-----------------------------------------------------------");

    }

    public void buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_61() throws Exception {
        HeaderChildNode("Buy ELoad Contact PermissionTwo Allow Button Functionality");
        buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_59();
        if(verifyElementPresent(MLWalletEloadPage.objAllowAccess,"Contact Permission Allow Button")) {
            click(MLWalletEloadPage.objAllowAccess, getTextVal(MLWalletEloadPage.objAllowAccess, "Button"));
            verifyElementPresentAndClick(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
            List<WebElement> listOfContacts = findElements(MLWalletEloadPage.objListOfContacts);
            for (int i = 0; i < listOfContacts.size(); i++) {
                if (i % 2 == 0) {
                    String namesOfContacts = listOfContacts.get(i).getText();
                    logger.info("Contact Names : " + namesOfContacts + " is displayed");
                    extentLogger(" ", "Contact Name : " + namesOfContacts + " is displayed");
                }
            }
        }
        logger.info("BE_TC_60, Buy ELoad Contact PermissionTwo Allow Button Functionality Validated");
        extentLoggerPass("BE_TC_60", "BE_TC_60, Buy ELoad Contact PermissionTwo Allow Button Functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void buyELoadInOTPPopupValidation_BE_TC_084(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction IN App OTP Popup Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("BE_TC_084, Buy ELoad, InApp OTP popup validated");
            extentLoggerPass("BE_TC_084", "BE_TC_084, Buy ELoad, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_085(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction InApp OTP popup UI Validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(3000);
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(8000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds,getTextVal(MLWalletLoginPage.objSeconds,"Seconds"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("BE_TC_090, Buy ELoad Transaction InApp OTP popup UI validated");
            extentLoggerPass("BE_TC_090", "BE_TC_090, Buy ELoad Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_086(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad New OTP got generated After Sixty Seconds validation");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            click(MLWalletLoginPage.objOTP, "OTP");
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("BE_TC_091, Buy ELoad Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("BE_TC_091", "BE_TC_091, Buy ELoad Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_087(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction OTP Cancel Button Functionality");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"))){
            logger.info("BE_TC_092, Buy ELoad Transaction, After clicking on Cancel in One time pin popup App navigates back to Buy ELoad Page is validated");
            extentLoggerPass("BE_TC_092", "BE_TC_092, Buy ELoad Transaction, After clicking on Cancel in One time pin popup App navigates back to Buy ELoad Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_088(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction OTP Continue Button Functionality");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(40000);
        if(verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Page"))){
            logger.info("BE_TC_093, Buy ELoad Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("BE_TC_093", "BE_TC_093, Buy ELoad Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }




    public void buyELoadTransactionValidationAfterMinimizingApp_BE_TC_064(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction Validation After Minimizing App");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        getDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(3000);
        if(verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Page"))){
            logger.info("BE_TC_069, Buy ELoad Transaction Validation After Minimizing App Validated");
            extentLoggerPass("BE_TC_069", "BE_TC_069, Buy ELoad Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionWithValidMLPin_BE_TC_73(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction With Valid MLPin");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier,prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad,getTextVal(MLWalletEloadPage.objBuyLoad,"Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        handleMpin("1111", "Entered Mpin");
        waitTime(30000);
        if(verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage,getTextVal(MLWalletEloadPage.objTransactionDetailsPage,"Page"))){
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails,getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails,"Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objBuyELoadTime,getTextVal(MLWalletEloadPage.objBuyELoadTime,"Date and Time"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            logger.info("BE_TC_78, Buy ELoad Transaction With Valid MLPin is Validated");
            extentLoggerPass("BE_TC_78", "BE_TC_78, Buy ELoad Transaction With Valid MLPin is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionWithInValidMLPin_BE_TC_74(String sTier,int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Transaction With InValid MLPin");
        waitTime(2000);
        changeNumberPage();
        eLoad_generic(sTier, prop.getproperty("sunMobileNumber"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        handleMpin("1234", "Entered Mpin");
        waitTime(3000);
        if (verifyElementPresent(MLWalletEloadPage.objInvalidPINMsg, getTextVal(MLWalletEloadPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("BE_TC_79, Buy ELoad Transaction With Invalid ML Pin validated");
            extentLoggerPass("BE_TC_79", "BE_TC_79, Buy ELoad Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

}


