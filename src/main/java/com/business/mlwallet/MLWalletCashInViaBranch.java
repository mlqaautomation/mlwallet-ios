package com.business.mlwallet;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;
import com.iosmlwalletpages.*;

import java.time.Duration;

public class MLWalletCashInViaBranch extends BaseClass {

    public MLWalletCashInViaBranch() {
        super();

    }


    public void cashInViaBranchNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        click(MLWalletCashInViaBranchPage.objCashInMenu, "Cash In");
        waitTime(5000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInOptionPage, getTextVal(MLWalletCashInViaBranchPage.objCashInOptionPage,"Page"));
        click(MLWalletCashInViaBranchPage.objBranchName, "ML Branch");
    }
    public void cashInViaBranchEnterAmount(String sAmount) throws Exception {
        waitTime(5000);
        type(MLWalletCashInViaBranchPage.objAmountTextField, sAmount, "Amount Text Field");
        Swipe("up", 1);
        click(MLWalletCashInViaBranchPage.objNextButton, "Next Button");
        click(MLWalletCashInViaBranchPage.objNextButton, "Next Button");
        waitTime(2000);
    }

    public void maxTransactionLimitValidation(String sTier) throws Exception {
        cashInViaBranchNavigation(sTier);
        cashInViaBranchEnterAmount("50001");
        waitTime(2000);
        click(MLWalletCashInViaBranchPage.objPopUpContinueButton, getTextVal(MLWalletCashInViaBranchPage.objPopUpContinueButton, "Button"));
        waitTime(2000);
    }


    public void cancelPreviousTransactionAndContinue() throws Exception {
        waitTime(2000);
        if (verifyElementDisplayed(MLWalletCashInViaBranchPage.objCancelBtn1, "Cancel Button")) {
            click(MLWalletCashInViaBranchPage.objCancelBtn1, getTextVal(MLWalletCashInViaBranchPage.objCancelBtn1, "Button"));
            waitTime(5000);
            verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup,getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup,"popup"));
            click(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionBtn, "button"));
            waitTime(3000);
            verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranchPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            click(MLWalletCashInViaBranchPage.objCashInMenu, "Cash In");
            waitTime(15000);
            verifyElementPresent(MLWalletCashInViaBranchPage.objCashInOptionPage, getTextVal(MLWalletCashInViaBranchPage.objCashInOptionPage,"Page"));
            click(MLWalletCashInViaBranchPage.objBranchName, "ML Branch");
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
        handleMpin("1111","MPin");
    }

    public void verifyRecentTransaction3(String sTier) throws Exception
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
    }
    public void cashInViaBranch_ValidAmount_Scenario_CIBR_TC_01() throws Exception {
        HeaderChildNode("ML_Wallet_Cash_In_Via_Barnch_ValidAmount_Scenario");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("New_Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))){
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP,getTextVal(MLWalletCashInViaBranchPage.objPHP,"PHP"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate,getTextVal(MLWalletCashInViaBranchPage.objCreatedDate,"Date"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objStatus,getTextVal(MLWalletCashInViaBranchPage.objStatus,"Status"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo,getTextVal(MLWalletCashInViaBranchPage.objTransactionNo,"Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
            waitTime(5000);
            if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
                String sStatus = getText(MLWalletCashInBank.objPendingStatus);
                String pendingStatus=sStatus.substring(2, 9);
                String sExpectedStatus = "Pending";
                assertionValidation(pendingStatus,sExpectedStatus);
//											verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
                logger.info("'CIBR_TC_01', To validate valid Amount in Cash In ML Branch ");
                extentLoggerPass("'CIBR_TC_01", "'CIBR_TC_01', To validate valid Amount in Cash In ML Branch ");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchCancelTransactionScenario_CIBR_TC_02() throws Exception {
        HeaderChildNode("ML Wallet Cash In Via Branch Cancel Transaction Scenario");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        waitTime(2000);
        cashInViaBranchEnterAmount("100");
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionBtn, "Button"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup, "PopUp"));
        waitTime(5000);
        click(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn, getTextVal(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn, "button"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranchPage.objBackToHomeBtn, "Button"));
        waitTime(3000);
        Swipe("DOWN",2);
        if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objCancelStatus,getTextVal(MLWalletCashInBank.objCancelStatus,"Status"));
            String sStatus = getText(MLWalletCashInBank.objCancelStatus);
            String pendingStatus=sStatus.substring(2, 11);
            String sExpectedStatus = "Cancelled";
            System.out.println(sExpectedStatus);
            assertionValidation(pendingStatus,sExpectedStatus);
            logger.info("'CIBR_TC_02', To validate Cancel Transaction in Cash In ML Branch");
            extentLoggerPass("'CIBR_TC_02","'CIBR_TC_02', To validate Cancel Transaction in Cash In ML Branch");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInviaBranch_Invalid_Amount_CIBR_TC_03() throws Exception {
        HeaderChildNode("ML Wallet Cash In via Branch Invalid Amount");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("0");
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objInvalidAmountMsg, getTextVal(MLWalletCashInViaBranchPage.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInViaBranchPage.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("'CIBR_TC_03', 'CIBR_TC_03' To validate Invalid Amount");
            extentLoggerPass("CIBR_TC_03", "'CIBR_TC_03', To validate Invalid Amount");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04() throws Exception {
        HeaderChildNode("ML Wallet Cash In via Branch Maximum Limit Amount");
        waitTime(2000);
        changeNumberPage();
        maxTransactionLimitValidation(prop.getproperty("Branch_Verified"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,getTextVal(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranchPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("'CIBR_TC_04', ML Wallet Cash In via Branch Maximum Limit Amount Validated");
            extentLoggerPass("CIBR_TC_04", "'CIBR_TC_04', ML Wallet Cash In via Branch Maximum Limit Amount Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBRanchInvalidAmount_CIBR_TC_05() throws Exception {
        HeaderChildNode("ML Wallet Cash In via Branch Invalid Amount");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cashInViaBranchEnterAmount("");
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objAmountRErrMsg, getTextVal(MLWalletCashInViaBranchPage.objAmountRErrMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInViaBranchPage.objAmountRErrMsg);
            String sExpectedErrorMsg = "Amount is required";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_05, Amount is required - Error Message is validated");
            extentLoggerPass("CIBR_TC_05", "CIBR_TC_05, Amount is required - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchUIValidation_CIBR_TC_06() throws Exception {
        HeaderChildNode("Cash In Via Branch UI Validation");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInPage,getTextVal(MLWalletCashInViaBranchPage.objCashInPage,"Page"))){
            verifyElementPresent(MLWalletCashInViaBranchPage.objBranchCashIn,getTextVal(MLWalletCashInViaBranchPage.objBranchCashIn,"Header"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objUserName,getTextVal(MLWalletCashInViaBranchPage.objUserName,"User Name"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objUserNumber,getTextVal(MLWalletCashInViaBranchPage.objUserNumber,"User Number"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objAmountTextField,"Amount Input Field");
            verifyElementPresent(MLWalletCashInViaBranchPage.objNextButton, "Next Button");
            logger.info("CIBR_TC_06, Cash In Via Branch UI validated");
            extentLoggerPass("CIBR_TC_06", "CIBR_TC_06, Cash In Via Branch UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchBackBtnValidation_CIBR_TC_07() throws Exception {
        HeaderChildNode("Cash In Via Branch Back Btn Validation");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchUIValidation_CIBR_TC_06();
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCashInBranchBackBtn,"Cash In Branch Back Button");
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInPage,getTextVal(MLWalletCashInViaBranchPage.objCashInPage,"Page"))){
            logger.info("CIBR_TC_07, Cash In Via Branch Back Btn validated");
            extentLoggerPass("CIBR_TC_07", "CIBR_TC_07, Cash In Via Branch Back Btn validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08() throws Exception {
        HeaderChildNode("Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(6000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objAvailableBalance,getTextVal(MLWalletLoginPage.objAvailableBalance,"Header"))){
            logger.info("CIBR_TC_08, Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page validated");
            extentLoggerPass("CIBR_TC_08", "CIBR_TC_08, Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchQRCodePageUIValidation_CIBR_TC_09() throws Exception {
        HeaderChildNode("Cash In Via Branch QR Code UI Validation");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))) {
            verifyElementPresent(MLWalletCashInViaBranchPage.objQRCode,"QR Code");
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP, getTextVal(MLWalletCashInViaBranchPage.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate, getTextVal(MLWalletCashInViaBranchPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objStatus, getTextVal(MLWalletCashInViaBranchPage.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo, getTextVal(MLWalletCashInViaBranchPage.objTransactionNo, "Transaction Number"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCrossBtn, "Cash In Branch Cross Button");
            logger.info("CIBR_TC_09, Cash In Via Branch QR Code UI validated");
            extentLoggerPass("CIBR_TC_09", "CIBR_TC_09, Cash In Via Branch QR Code UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchPendingTransaction_CIBR_TC_11() throws Exception {
        HeaderChildNode("Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
            String sStatus = getText(MLWalletCashInBank.objPendingStatus);
            String pendingStatus=sStatus.substring(2, 9);
            String sExpectedStatus = "Pending";
            click(MLWalletCashInViaBranchPage.objCashInMenu, "Cash In");
            assertionValidation(pendingStatus,sExpectedStatus);
            verifyElementPresent(MLWalletCashInViaBranchPage.objBranchName, "Cash In Options Page");
            click(MLWalletCashInViaBranchPage.objBranchName, "ML Branch");
            waitTime(4000);
            if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))) {
                verifyElementPresent(MLWalletCashInViaBranchPage.objPHP, getTextVal(MLWalletCashInViaBranchPage.objPHP, "PHP"));
                verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate, getTextVal(MLWalletCashInViaBranchPage.objCreatedDate, "Date"));
                verifyElementPresent(MLWalletCashInViaBranchPage.objStatus, getTextVal(MLWalletCashInViaBranchPage.objStatus, "Status"));
                verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo, getTextVal(MLWalletCashInViaBranchPage.objTransactionNo, "Transaction Number"));
                verifyElementPresent(MLWalletCashInViaBranchPage.objCrossBtn, "Cash In Branch Cross Button");
                logger.info("CIBR_TC_11, Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code validated");
                extentLoggerPass("CIBR_TC_11", "CIBR_TC_11, Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12() throws Exception {
        HeaderChildNode("Cash In Via Branch Cancel Button validation on CashIn Confirm Popup");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        waitTime(2000);
        cashInViaBranchEnterAmount("100");
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionBtn, "Button"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup, "PopUp"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn,getTextVal(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch, getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch, "Header"))){
            logger.info("CIBR_TC_12, Cash In Via Branch, On clicking Cancel Button on CashIn Confirm Popup Application Navigates to CashIn Page with Cancelled Status");
            extentLoggerPass("CIBR_TC_12", "CIBR_TC_12, Cash In Via Branch, On clicking Cancel Button on CashIn Confirm Popup Application Navigates to CashIn Page with Cancelled Status");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13(String sAmount) throws Exception {
        HeaderChildNode("Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount(sAmount);
        waitTime(4000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInConfirmationPopup,getTextVal(MLWalletCashInViaBranchPage.objCashInConfirmationPopup,"Popup"));
        tapUsingCoordinates(500,1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInConfirmationPopup,getTextVal(MLWalletCashInViaBranchPage.objCashInConfirmationPopup,"Popup"))){
            logger.info("CIBR_TC_13, Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup, Popup doesn't closed");
            extentLoggerPass("CIBR_TC_13", "CIBR_TC_13, Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14() throws Exception {
        HeaderChildNode("Cash In Via Branch Go Back Button validation on CashIn Confirm Popup");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objPopUpContinueButton,getTextVal(MLWalletCashInViaBranchPage.objPopUpContinueButton,"button"));
        waitTime(4000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(7000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch, getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch, "Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCancelTransactionBtn,getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionBtn,"Button"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objGoBackBtn,getTextVal(MLWalletCashInViaBranchPage.objGoBackBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch, getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch, "Header"))){
            logger.info("CIBR_TC_14, Cash In Via Branch, On clicking Go Back Button on CashIn Confirm Popup Application Navigates to CashIn Page with pending Status");
            extentLoggerPass("CIBR_TC_14", "CIBR_TC_14, Cash In Via Branch, On clicking Go Back Button on CashIn Confirm Popup Application Navigates to CashIn Page with pending Status");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15() throws Exception {
        HeaderChildNode("Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        click(MLWalletCashInViaBranchPage.objCancelTransactionBtn, "Cancel Transaction");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup, "Pop Up"));
        tapUsingCoordinates(500,1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup,getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup,"PopUp"))){
            logger.info("CIBR_TC_15, Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup, Popup doesn't closed");
            extentLoggerPass("CIBR_TC_15", "CIBR_TC_15, Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchBuyerTierUser_CIBR_TC_16() throws Exception {
        HeaderChildNode("Cash In Via Branch Buyer Tier User");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Buyer_Tier"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(4000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(7000);
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch, getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch, "QR Page"))) {
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP, getTextVal(MLWalletCashInViaBranchPage.objPHP, "Amount"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTwentyFourHrsNoteMsg, getTextVal(MLWalletCashInViaBranchPage.objTwentyFourHrsNoteMsg, "Note Message"));

//										String sErrorMessage = getText(MLWalletCashInViaBranch.objMaxLimitTxt);
//										String ExpectedTxt = "Branch Cash-in not allowed. Please upgrade to a higher verification level to add more balance.";
//										assertionValidation(sErrorMessage, ExpectedTxt);
//										verifyElementPresent(MLWalletCashInViaBranch.objUpgradeNowBtn,getTextVal(MLWalletCashInViaBranch.objUpgradeNowBtn,"Button"));
            logger.info("CIBR_TC_16, Cash In Via Branch Buyer Tier User, Branch CashIn Not Allowed-Error message Validated");
            extentLoggerPass("CIBR_TC_16", "CIBR_TC_16, Cash In Via Branch Buyer Tier User, Branch CashIn Not Allowed-Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17() throws Exception {
        HeaderChildNode("Cash In Via Branch Semi verified Tier User");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Semi_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))){
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP,getTextVal(MLWalletCashInViaBranchPage.objPHP,"PHP"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate,getTextVal(MLWalletCashInViaBranchPage.objCreatedDate,"Date"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objStatus,getTextVal(MLWalletCashInViaBranchPage.objStatus,"Status"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo,getTextVal(MLWalletCashInViaBranchPage.objTransactionNo,"Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
            verifyRecentTransaction2(prop.getproperty("Semi_Verified"));
            if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
                String sStatus = getText(MLWalletCashInBank.objPendingStatus);
                String pendingStatus=sStatus.substring(2, 9);
                String sExpectedStatus = "Pending";
                assertionValidation(pendingStatus,sExpectedStatus);
                logger.info("CIBR_TC_17, Cash In Via Branch Semi verified Tier User Validated");
                extentLoggerPass("CIBR_TC_17", "CIBR_TC_17, Cash In Via Branch Semi verified Tier User Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18() throws Exception {
        HeaderChildNode("Cash In Via Branch Fully verified Tier User");
        waitTime(2000);
        changeNumberPage();
        cashInViaBranchNavigation(prop.getproperty("Fully_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))){
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP,getTextVal(MLWalletCashInViaBranchPage.objPHP,"PHP"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate,getTextVal(MLWalletCashInViaBranchPage.objCreatedDate,"Date"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objStatus,getTextVal(MLWalletCashInViaBranchPage.objStatus,"Status"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo,getTextVal(MLWalletCashInViaBranchPage.objTransactionNo,"Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
            verifyRecentTransaction3(prop.getproperty("Fully_Verified"));
            if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
                String sStatus = getText(MLWalletCashInBank.objPendingStatus);
                String pendingStatus=sStatus.substring(2, 9);
                String sExpectedStatus = "Pending";
                assertionValidation(pendingStatus,sExpectedStatus);
                System.out.println("-----------------------------------------------------------");
                logger.info("CIBR_TC_18, Cash In Via Branch Fully verified Tier User Validated");
                extentLoggerPass("CIBR_TC_18", "CIBR_TC_18, Cash In Via Branch Fully verified Tier User Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19() throws Exception {
        HeaderChildNode("Cash In Via Branch Max Transaction Buyer Tier User");
        waitTime(2000);
        changeNumberPage();
        maxTransactionLimitValidation(prop.getproperty("Buyer_Tier"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objBankMaxLimitTxt1,getTextVal(MLWalletCashInViaBranchPage.objBankMaxLimitTxt1,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranchPage.objBankMaxLimitTxt1);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P20,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_19, Cash In Via Branch Max Transaction Buyer Tier User,Branch CashIn Not Allowed-Error message Validated");
            extentLoggerPass("CIBR_TC_19", "CIBR_TC_19, Cash In Via Branch Max Transaction Buyer Tier User,Branch CashIn Not Allowed-Error message Validated");
        }
    }

    public void cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20() throws Exception {
        HeaderChildNode("Cash In Via Branch Max Transaction Limit Semi-verified Tier User");
        waitTime(2000);
        changeNumberPage();
        maxTransactionLimitValidation(prop.getproperty("Semi_Verified"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,getTextVal(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranchPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_20, Cash In Via Branch Max Transaction Limit Semi-verified Tier User Validated");
            extentLoggerPass("CIBR_TC_20", "CIBR_TC_20, Cash In Via Branch Max Transaction Limit Semi-verified Tier User Validated");
        }
    }

    public void cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21() throws Exception {
        HeaderChildNode("Cash In Via Branch Max Transaction Limit Fully-verified Tier User");
        maxTransactionLimitValidation(prop.getproperty("Fully_verified"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,getTextVal(MLWalletCashInViaBranchPage.objBankMaxLimitTxt,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranchPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_21, Cash In Via Branch Max Transaction Limit Fully-verified Tier User Validated");
            extentLoggerPass("CIBR_TC_21", "CIBR_TC_21, Cash In Via Branch Max Transaction Limit Fully-verified Tier User Validated");
        }
    }

    public void cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction Details UI Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objPHP, getTextVal(MLWalletCashInViaBranchPage.objPHP, "PHP"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate, getTextVal(MLWalletCashInViaBranchPage.objCreatedDate, "Date"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objStatus, getTextVal(MLWalletCashInViaBranchPage.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo, getTextVal(MLWalletCashInViaBranchPage.objTransactionNo, "Transaction Number"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn, "Cash In Branch Cross Button");
        verifyRecentTransaction3(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashIn, getTextVal(MLWalletTransactionHistoryPage.objTotalCashIn, "Total Cash In"));
            logger.info("CIBR_TC_22,Cash In Via Branch Transaction Details UI Validated");
            extentLoggerPass("CIBR_TC_22", "'CIBR_TC_22',Cash In Via Branch Transaction Details UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction Pending status Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objPHP,getTextVal(MLWalletCashInViaBranchPage.objPHP,"PHP"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate,getTextVal(MLWalletCashInViaBranchPage.objCreatedDate,"Date"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objStatus,getTextVal(MLWalletCashInViaBranchPage.objStatus,"Status"));
        verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo,getTextVal(MLWalletCashInViaBranchPage.objTransactionNo,"Transaction Number"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
        verifyRecentTransaction3(prop.getproperty("Branch_Verified"));
        if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
            String sStatus = getText(MLWalletCashInBank.objPendingStatus);
            String pendingStatus=sStatus.substring(2, 9);
            String sExpectedStatus = "Pending";
            assertionValidation(pendingStatus,sExpectedStatus);
            logger.info("CIBR_TC_23,Cash In Via Branch Transaction Pending status Validated");
            extentLoggerPass("CIBR_TC_23", "'CIBR_TC_23',Cash In Via Branch Transaction Pending status Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction Cancelled Status Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cashInViaBranchEnterAmount("100");
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCancelTransactionBtn,getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionBtn,"Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objCancelTransactionPopup,getTextVal(MLWalletCashInViaBranchPage.objCancelTransactionPopup,"PopUp"));
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn,getTextVal(MLWalletCashInViaBranchPage.objPopUpCancelTransactionBtn,"Button"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranchPage.objBackToHomeBtn, "Button"));
        waitTime(2000);
        verifyRecentTransaction3(prop.getproperty("Branch_Verified"));
        if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objCancelStatus,getTextVal(MLWalletCashInBank.objCancelStatus,"Status"));
            String sStatus = getText(MLWalletCashInBank.objCancelStatus);
            String pendingStatus=sStatus.substring(2, 10);
            String sExpectedStatus = "Cancelle";
            System.out.println(sExpectedStatus);
            assertionValidation(pendingStatus,sExpectedStatus);
            logger.info("'CIBR_TC_26',Cash In Via Branch Transaction Cancelled Status Validated");
            extentLoggerPass("'CIBR_TC_26","'CIBR_TC_26', Cash In Via Branch Transaction Cancelled Status Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction Validation After Minimizing App");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        getDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Bank Page"))){
            logger.info("CIBR_TC_36, Cash In Via Branch Transaction Validation After Minimizing App Validated");
            extentLoggerPass("CIBR_TC_36", "CIBR_TC_36, Cash In Via Branch Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchAmountFieldValidation_CIBR_TC_42() throws Exception {
        HeaderChildNode("Cash In Via Branch, Amount Field with more than 2 decimals Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100.123");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objDecimalAmountErrMsg, getTextVal(MLWalletCashInViaBranchPage.objDecimalAmountErrMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInViaBranchPage.objDecimalAmountErrMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("CIBR_TC_42, Cash In Via Branch, Amount Field with more than 2 decimals Error Msg validated");
            extentLoggerPass("CIBR_TC_42", "CIBR_TC_42, Cash In Via Branch, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction With Valid ML Pin");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch,getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Header"))){
            verifyElementPresent(MLWalletCashInViaBranchPage.objPHP,getTextVal(MLWalletCashInViaBranchPage.objPHP,"PHP"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objCreatedDate,getTextVal(MLWalletCashInViaBranchPage.objCreatedDate,"Date"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objStatus,getTextVal(MLWalletCashInViaBranchPage.objStatus,"Status"));
            verifyElementPresent(MLWalletCashInViaBranchPage.objTransactionNo,getTextVal(MLWalletCashInViaBranchPage.objTransactionNo,"Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranchPage.objCrossBtn,"Cash In Branch Cross Button");
            verifyRecentTransaction2(prop.getproperty("Branch_Verified"));
            if(verifyElementPresent(MLWalletCashInBank.objCashInTransaction,getTextVal(MLWalletCashInBank.objCashInTransaction,"Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
                String sStatus = getText(MLWalletCashInBank.objPendingStatus);
                String pendingStatus=sStatus.substring(2, 9);
                String sExpectedStatus = "Pending";
                assertionValidation(pendingStatus,sExpectedStatus);
                logger.info("'CIBR_TC_43', Cash In Via Branch Transaction With Valid ML Pin validated");
                extentLoggerPass("'CIBR_TC_43", "'CIBR_TC_43', Cash In Via Branch Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction With InValid ML Pin");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(5000);
        handleMpin("1234", "Entered Invalid Mpin");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objInvalidPINMsg, getTextVal(MLWalletCashInViaBranchPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInViaBranchPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("CIBR_TC_44, Cash In Via Branch Transaction With Invalid ML Pin validated");
            extentLoggerPass("CIBR_TC_44", "CIBR_TC_44, Cash In Via Branch Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchOTPPopupValidation_CIBR_TC_50() throws Exception {
        HeaderChildNode("Cash In Via Branch OTP Popup validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(8000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("CIBR_TC_50, Cash In Via Branch, InApp OTP popup validated");
            extentLoggerPass("CIBR_TC_50", "CIBR_TC_50, Cash In Via Branch, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction InApp OTP Popup validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("CIBR_TC_51, Cash In Via Branch Transaction InApp OTP Popup validated");
            extentLoggerPass("CIBR_TC_51", "CIBR_TC_51, Cash In Via Branch Transaction InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction New OTP got generated After Sixty Seconds validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("CIBR_TC_52, Cash In Via Branch Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("CIBR_TC_52", "CIBR_TC_52, Cash In Via Branch Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction OTP Cancel Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInViaBranchPage.objBranchCashIn,getTextVal(MLWalletCashInViaBranchPage.objBranchCashIn,"Page"))){
            logger.info("CIBR_TC_53, Cash In Via Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Branch cash In Page is validated");
            extentLoggerPass("CIBR_TC_53", "CIBR_TC_53, Cash In Via Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Branch cash In Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54() throws Exception {
        HeaderChildNode("Cash In Via Branch Transaction OTP Continue Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranchPage.objWarningPopup,
                getTextVal(MLWalletCashInViaBranchPage.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranchPage.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objCashInToBranch, getTextVal(MLWalletCashInViaBranchPage.objCashInToBranch,"Page"))) {
            logger.info("CIBR_TC_54, Cash In Via Branch Transaction, After clicking on Continue in One time pin popup App navigates to Cash In To Branch Page is validated");
            extentLoggerPass("CIBR_TC_54", "CIBR_TC_54, Cash In Via Branch Transaction, After clicking on Continue in One time pin popup App navigates to Cash In To Branch page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



}
