package com.business.mlwallet;
import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import com.iosmlwalletpages.MLWalletGCashPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;


public class MLWalletGCash extends BaseClass {
    public MLWalletGCash() {
        super();

    }

    public void verifyTransactionDetails() throws Exception {
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objSendMoneytoGcashLabel, "Transaction Details");
        verifyElementPresent(MLWalletGCashPage.objReceiverGcashNoValue, getTextVal(MLWalletGCashPage.objReceiverGcashNoValue, "Receiver Number"));
        verifyElementPresent(MLWalletGCashPage.objSenderNameValue, getTextVal(MLWalletGCashPage.objSenderNameValue, "Sender Name"));
        verifyElementPresent(MLWalletGCashPage.objSenderMobileNoValue, getTextVal(MLWalletGCashPage.objSenderMobileNoValue, "Sender Number"));
        verifyElementPresent(MLWalletGCashPage.objAmountValue, getTextVal(MLWalletGCashPage.objAmountValue, "Gcash Amount"));
        verifyElementPresent(MLWalletGCashPage.objSerciceFeeValue, getTextVal(MLWalletGCashPage.objSerciceFeeValue, "Gcash Service Fee"));
        verifyElementPresent(MLWalletGCashPage.objTotalValue, getTextVal(MLWalletGCashPage.objTotalValue, "Total Amount"));
    }

    public void GC_Land_TC_01_Verify_user_able_see_Gcash_icon_Dashborad() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is able to see Gcash icon in Dashborad on sucessfull login to the application");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objGcash, "Gcash Services Page Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_01", "To verify user is able to see Gcash icon in Dashborad on sucessfull login to the application");
    }

    public void GC_Land_TC_02_Verify_user_able_navigate_Gcash_services_page_tapping_Gcash_icon() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is able to navigate to Gcash services page on tapping Gcash icon from the Dashboard");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToGcash();
        verifyElementPresent(MLWalletGCashPage.objSendMoneyBtn, "Gcash Send Money Button");
        verifyElementPresent(MLWalletGCashPage.objGcashServicesLabel, "GCash Services Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_02", "To verify user is able to navigate to Gcash services page on tapping Gcash icon from the Dashboard");
    }

    public void goToGcash() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Text");
        if (verifyElementPresent(MLWalletGCashPage.objGcashServicesLabel, "Gcash Options Text")) {
            logger.info("Navigated to Gcash Services Page");
        } else {
            logger.info("Not Navigated to Gcash Services Page");
        }
    }

    public void GC_Land_TC_03_Verify_UI_Gcash_Services_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify the UI of Gcash Services page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Text");
        verifyElementPresent(MLWalletGCashPage.objSendMoneyBtn, "Gcash Services Page Text");
        verifyElementPresent(MLWalletGCashPage.objGcashServicesLabel, "Send Money to Gcash Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_03", "To verify the UI of Gcash Services page");
    }

    public void GC_Land_TC_04_Verify_user_redirected_back_Dashboard_tapping_back_arrow_btn()throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is redirected  back to Dashboard on tapping <(back arrow) from the Gcash Services page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Text");
        verifyElementPresentAndClick(MLWalletGCashPage.objBackBtn, "Gcash Icon Text");
        logger.info("Back Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_04", "To verify user is redirected  back to Dashboard on tapping <(back arrow) from the Gcash Services page");
    }

    public void GC_Land_TC_43_Verify_UI_Send_Money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify UI of  Send Money to Gcash page ");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToSendMoneyToGcash();
        verifyElementPresent(MLWalletGCashPage.objSendMoneyGCashLabel, "Send Money to GCash Page");
        verifyElementPresent(MLWalletGCashPage.objGCashNolabel, "GCash No Text");
        logger.info("Send Money to Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_43", "To verify user is redirected to Receive Money from Gcash page on tapping Recive Money from Gcash Services page");
    }

    public void goToSendMoneyToGcash() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        if (verifyElementPresent(MLWalletGCashPage.objSendMoneyGCashLabel, "Send Money to GCash Page")) {
            logger.info("Navigated to Send Money to GCash Page");
        } else {
            logger.info("Not Navigated to Send Money to GCash Page");
        }
    }

    public void GC_Land_TC_49_Verify_user_error_input_empty_Receiver_MobileNo_Send_Money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user gets an appropriate error on entering empty spaces in  Receiver Mobile number field in Send Money to Gcash page ");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objGcashNextBtn, "GCash Next Button");
        verifyElementPresent(MLWalletGCashPage.objMobileNoIsRequiredText, "Prompt Mobile No is Required");
        logger.info("Prompt mobile no is required empty fields");
        ExtentReporter.extentLoggerPass("GC_Land_TC_49", "To verify user gets an appropriate error on entering empty spaces in  Receiver Mobile number field in Send Money to Gcash page");
    }

    public void GC_Land_TC_50_Verify_user_error_input_SymbolorSpecialChar_Receiver_MobileNo_Send_Money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user gets an appropriate error on entering Symbols and special characters in  Receiver Mobile number field in Send Money to Gcash page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("SpecialChar"), "Type Characters");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        verifyElementPresentAndClick(MLWalletGCashPage.objGcashNextBtn, "GCash Next Button");
        String val = gcashprop.getproperty("InvalidMobileNum");
        if (verifyElementPresent(MLWalletGCashPage.objIsRequired(val), getText(MLWalletGCashPage.objIsRequired(val)))) {
            verifyElementPresent(MLWalletGCashPage.objMobileNoIsInvalidText, "Prompt Mobile No is Invalid");
            logger.info("Prompt mobile no is Invalid Special Characters");
            ExtentReporter.extentLoggerPass("GC_Land_TC_50", "To verify user gets an appropriate error on entering Symbols and special characters in  Receiver Mobile number field in Send Money to Gcash page");
        }
    }

    public void GC_Land_TC_54_Verify_user_error_input_2Decimal_amount_Send_Money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user gets appropriate error on inputting an amount with  more than two decimal places in Send money to Gcash- amount to send page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("3DecimalPlaces"), "3 Decimal");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        verifyElementPresentAndClick(MLWalletGCashPage.objGcashNextBtn, "GCash Next Button");
        String val = gcashprop.getproperty("InvalidMobileNum");
        if (verifyElementPresent(MLWalletGCashPage.objIsRequired(val), getText(MLWalletGCashPage.objIsRequired(val)))) {
            verifyElementPresent(MLWalletGCashPage.objMobileNoIsInvalidText, "Prompt Mobile No is Invalid");
            logger.info("Prompt mobile no is Invalid Special Characters");
            ExtentReporter.extentLoggerPass("GC_Land_TC_54", "To verify user gets appropriate error on inputting an amount with  more than two decimal places in Send money to Gcash- amount to send page");
        }
    }

    public void GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Send Money to Gcash Less Than One Validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Option");
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        verifyElementPresentAndClick(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("InvalidLessAmount"), "InvalidLessAmount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        String val = gcashprop.getproperty("LessThanOne");
        if (verifyElementPresent(MLWalletGCashPage.objIsRequired(val), getText(MLWalletGCashPage.objIsRequired(val)))) {
            verifyElementPresent(MLWalletGCashPage.objAmountIsInvalidText, "Prompt Mobile No is Invalid");
            logger.info("Prompt Invalid less than 1");
            ExtentReporter.extentLoggerPass("GC_Land_TC_54", "To verify user gets appropriate error on inputting an amount with  more than two decimal places in Send money to Gcash- amount to send page");
        }
        waitTime(1000);
        logger.info("GC_RM_TC_57, To Send Money to Gcash Less Than One Validation, Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_57", "To Send Money to Gcash Less Than One Validation, Validated");
    }

    public void confirmGcashAmountTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Valid Number");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "GCash Next Button");
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Amount");
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
    }

    public void GC_Land_TC_58_Validate_user_able_see_NextBtn_Send_money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To validate user is able to see Next button Send money to Gcash page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money Button");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Valid Number");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "GCash Next Button");
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        if (verifyElementPresent(MLWalletGCashPage.objGcashNextBtn, "Next Amount")) {
            logger.info("Observe the Next Button");
        }
        logger.info("GC_RM_TC_58, To validate user is able to see Next button Send money to Gcash page, Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_58", "To validate user is able to see Next button Send money to Gcash page, Validated");
    }

    public void GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objBackBtn, "Back Button");
        if (verifyElementPresent(MLWalletGCashPage.objSendMoneytoGcashLabel, getText(MLWalletGCashPage.objSendMoneytoGcashLabel))) {
            verifyElementPresent(MLWalletGCashPage.objGCashNolabel, getText(MLWalletGCashPage.objGCashNolabel));
            logger.info("Redirect to Send Money to Gcash Page from Confirm Details Page using Back Button, Validated");
            ExtentReporter.extentLoggerPass("GC_RM_TC_59", "To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        }
    }

    public void confirmGcashTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        click(MLWalletLoginPage.objOtpContineBtn, "Continue Button");
        waitTime(1000);
    }

    //GC_RM_TC_60
    public void GC_SM_TC_60_InAppOtp_Page_Redirection_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, "One Time Pin")
                || verifyElementPresent(MLWalletLoginPage.objContinueBtn, "Continue")
                || verifyElementPresent(MLWalletLoginPage.objCancelBtn, "MLPin")
        ) {
            logger.info("OTP Page is Displayed");
            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }

    //GC_RM_TC_64
    public void GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, "OTP Cancel Button")) {
            logger.info("Successfully Cancel InappOTP");
            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }

    //GC_RM_TC_72
    public void GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate to SMS OTP screen Mpin GCash Send Money");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getText(MLWalletLoginPage.objOneTimePin))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getText(MLWalletLoginPage.objOTP));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, "Obeserve Cancel Button");
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn, "Obeserve Continue Button");
            logger.info("GC_SM_TC_72, GCash In App OTP Navigation validated");
            ExtentReporter.extentLoggerPass("GC_SM_TC_70", "To Validate to SMS OTP Mpin GCash Send Money");
            System.out.println("-----------------------------------------------------------");
        }
    }

    //GC_RM_TC_73
    public void GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Back Button In GCash Transaction Details Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashTransaction();
        if (verifyElementPresent(MLWalletGCashPage.objTransactionDetailsHeader, "Transaction Detail")) {
            verifyElementPresent(MLWalletGCashPage.objSendMoneytoGCashTransactLabel, "Send Money GCash");
            verifyElementPresent(MLWalletGCashPage.objAmountSendTransactText, getTextVal(MLWalletGCashPage.objAmountSendTransactText, "Amount Send"));
            verifyElementPresent(MLWalletGCashPage.objReceiverGcashNoTransactValue, getTextVal(MLWalletGCashPage.objReceiverGcashNoTransactValue, "Receiver GCash No."));
            verifyElementPresent(MLWalletGCashPage.objSenderNameTransactValue, getTextVal(MLWalletGCashPage.objSenderNameTransactValue, "Sender Name"));
            verifyElementPresent(MLWalletGCashPage.objSenderMobileNoTransactValue, getTextVal(MLWalletGCashPage.objSenderMobileNoTransactValue, "Sender No."));
            verifyElementPresent(MLWalletGCashPage.objAmountTransactValue, getTextVal(MLWalletGCashPage.objAmountTransactValue, "Amount"));
            verifyElementPresent(MLWalletGCashPage.objServiceFeeTransactValue, getTextVal(MLWalletGCashPage.objServiceFeeTransactValue, "Service Fee"));
            verifyElementPresent(MLWalletGCashPage.objTotalTransactValue, getTextVal(MLWalletGCashPage.objTotalTransactValue, "Total"));
            verifyElementPresent(MLWalletGCashPage.objBackToHomePage, "Back Home Button");
            verifyElementPresent(MLWalletGCashPage.objNewTransactionBtn, "New Transaction Button");
        }
        logger.info("GC_SM_TC_73, Back Button In GCash Transaction Details Page Validated");
        ExtentReporter.extentLoggerPass("GC_SM_TC_73", "To Validate Back Button In GCash Transaction Details Page");
        System.out.println("-----------------------------------------------------------");
    }

    //GC_RM_TC_76
    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Back Home Button In GCash View Recent Transaction Dashboard Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        String currentBalance = getText(MLWalletHomePage.objAvailableBalance);
        confirmGcashTransaction();
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objTransactionDetailsHeader, "Transaction Details");
        String amount = getText(MLWalletGCashPage.objAmountTransactValue);
        verifyElementPresentAndClick(MLWalletGCashPage.objBackToHomePage, "Back to Home Page");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
            String NewBalance = getText(MLWalletHomePage.objAvailableBalance);
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Header"));
            Swipe("UP", 1);
            //-----------Formula----------------------
            int cBalance = Integer.parseInt(currentBalance);
            int cAmount = Integer.parseInt(amount);
            int deduction = cBalance- cAmount;
            String Sdeduction = String.valueOf(deduction);
            //----------------------------------------
            click(MLWalletTransactionHistoryPage.objSeeMoreBtn, "See More Button");
            waitTime(10000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionHistory, getTextVal(MLWalletTransactionHistoryPage.objTransactionHistory, "Page"));
            verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objSendMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objSendMoneyTab, "Tab"));
            verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"));
            String amountHistory = getText(MLWalletTransactionHistoryPage.objTotalAmount);
            if(amount == amountHistory && currentBalance != NewBalance && Sdeduction == NewBalance){
                logger.info("GC_SM_TC_76, Same amount in transaction history Validated");
            }
            else
            {
                logger.info("GC_SM_TC_76, Not same amount in transaction history Failed");
            }
        }
        logger.info("GC_SM_TC_76, Back Home Button In GCash View Recent Transaction Dashboard Page Validated");
        ExtentReporter.extentLoggerPass("GC_SM_TC_76", "To Validate Back Home Button In GCash View Recent Transaction Dashboard Page");
        System.out.println("-----------------------------------------------------------");
    }


    //GC_RM_TC_83
    public void GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate transaction details are matching with user entered details");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        if (verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page")) {
            waitTime(1000);
            verifyElementPresent(MLWalletGCashPage.objSendMoneytoGcashLabel, "Send Money to GCash");
            verifyElementPresent(MLWalletGCashPage.objReceiverGcashNoValue, getTextVal(MLWalletGCashPage.objReceiverGcashNoValue, "Receiver Number"));
            verifyElementPresent(MLWalletGCashPage.objSenderNameValue, getTextVal(MLWalletGCashPage.objSenderNameValue, "Sender Name"));
            verifyElementPresent(MLWalletGCashPage.objSenderMobileNoValue, getTextVal(MLWalletGCashPage.objSenderMobileNoValue, "Sender Number"));
            verifyElementPresent(MLWalletGCashPage.objAmountValue, getTextVal(MLWalletGCashPage.objAmountValue, "Gcash Amount"));
            verifyElementPresent(MLWalletGCashPage.objSerciceFeeValue, getTextVal(MLWalletGCashPage.objSerciceFeeValue, "Gcash Service Fee"));
            verifyElementPresent(MLWalletGCashPage.objTotalValue, getTextVal(MLWalletGCashPage.objTotalValue, "Total Amount"));
            logger.info("GC_SM_TC_83, Validate transaction details are matching with user entered details");
        }
        ExtentReporter.extentLoggerPass("GC_SM_TC_83", "To Validate transaction details are matching with user entered details");
        System.out.println("-----------------------------------------------------------");
    }

    //GC_RM_TC_102
    public void GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier() throws Exception {
        ExtentReporter.HeaderChildNode("To validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        String val = gcashprop.getproperty("InvalidTierBuyerVer");
        if (verifyElementPresent(MLWalletGCashPage.objIsRequired(val), getText(MLWalletGCashPage.objIsRequired(val)))) {
            verifyElementPresent(MLWalletGCashPage.objInvalidTierBuyerVer, "Prompt Mobile No is Invalid");
            verifyElementPresentAndClick(MLWalletGCashPage.objUpgradeNow, "Upgrade Now Visible");
            waitTime(1000);
            verifyElementPresent(MLWalletTierUpgradePages.objVerificationTierPerksLabel, "Tier Upgrade Page");
            logger.info("Prompt Invalid BuyerTier, Validated");
        }
        logger.info("GC_SM_TC_83, validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_83", "To validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        System.out.println("-----------------------------------------------------------");
    }

    public void confirmGcash50kTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("Invalid50kAbove"), "Invalid 50k Above");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        waitTime(1000);
    }

    //GC_RM_TC_103
    public void GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGCashPage.objInvalid50kAboveTiersVer, "Prompt Mobile No is Invalid");
        verifyElementPresent(MLWalletGCashPage.objUpgradeNow, "Upgrade Now Visible");
        logger.info("Prompt Invalid 50k SemiTier, Validated");
        logger.info("GC_SM_TC_103, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_103","To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }
    //GC_RM_TC_104
    public void GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGCashPage.objInvalid50kAboveTiersVer, "Prompt Mobile No is Invalid");
        verifyElementPresent(MLWalletGCashPage.objUpgradeNow, "Upgrade Now Visible");
        logger.info("Prompt Invalid 50k BranchTier, Validated");
        logger.info("GC_SM_TC_104, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_104", "To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }
    //GC_RM_TC_105
    public void GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGCashPage.objInvalid50kAboveTiersVer, "Prompt Mobile No is Invalid");
        verifyElementPresent(MLWalletGCashPage.objUpgradeNow, "Upgrade Now Visible");
        logger.info("Prompt Invalid 50k FullyTier, Validated");
        logger.info("GC_SM_TC_105, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_105", "To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }

    public void sendMoneyToGcash()throws Exception {
        logger.info("Sending Money To Gcash Scenario");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        click(MLWalletLoginPage.objOtpContineBtn, "Continue Button");
        waitTime(1000);
        click(MLWalletGCashPage.objBackToHomePage, "Back to Home Page Button");
        logger.info("Send Money To Gcash, Success");
    }

    //GC_RM_TC_132 To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier
    public void GC_SM_TC_132_SendMoney_as_SemiVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier ");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        sendMoneyToGcash();
        logger.info("Send Money to Gcash as Semi Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_132", "To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier");
    }

    //GC_RM_TC_135 To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier
    public void GC_RM_TC_135_SendMoney_as_BranchVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier ");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        sendMoneyToGcash();
        logger.info("Send Money to Gcash as Branch Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_135", "To Validate Successful Send Money to Gcash as Branch Verified Tier ");
    }

    public void confirmNoGcashgotoKwartaPadalaTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("NoGcashKwartaPadalaNo"), "No GCash Kwarta Padala No");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        click(MLWalletLoginPage.objOtpContineBtn, "Continue Button");
        waitTime(1000);
    }

    public void confirmNoGcashggotoMLWalletTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGCashPage.objGCashNoTextbox, gcashprop.getproperty("NoGcashMlwalletNo"), "No Gcash Ml Wallet No");
        click(MLWalletGCashPage.objTapHideKeyboard, "Hide Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGCashPage.objAmountSendTextbox, gcashprop.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGCashPage.objTapHideNoKeyboard, "Hide Number Keyboard");
        click(MLWalletGCashPage.objGcashNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGCashPage.objProceedBtn,"ProceedBtn")){
            click(MLWalletGCashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGCashPage.objComfirmDetailsLabel, "Confirm Details Page");
        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGCashPage.objAllowOnceBtn, "Observe BTn")) {
            click(MLWalletGCashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        click(MLWalletLoginPage.objOtpContineBtn, "Continue Button");
        waitTime(1000);
    }
    public void GC_RM_TC_180_SendMoney_NoGCash_thru_MLWallet()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmNoGcashggotoMLWalletTransaction();
        if(verifyElementPresent(MLWalletGCashPage.objNoGCashOtherOptionLabel, "Prompt Mobile No is Invalid")){
            verifyElementPresent(MLWalletGCashPage.objSendViaMLWalletlabel, "Send Via ML Wallet");
            verifyElementPresent(MLWalletGCashPage.objSendViaMLWalletBtn, "Send Via ML Wallet Button");
            verifyElementPresent(MLWalletGCashPage.objCloseBtn, "Close Button");
            if(verifyElementDisplayed(MLWalletGCashPage.objSendViaMLWalletBtn, "Send Via ML Wallet Button Viewed")){
                click(MLWalletGCashPage.objSendViaMLWalletBtn, "Send Via ML Wallet Button");
                verifyElementPresent(MLWalletSendTransferPage.objSendMoney,"Send Wallet Label");
            }
        }
    }
    public void GC_RM_TC_181_SendMoney_NoGCash_thru_KwartaPadala()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmNoGcashgotoKwartaPadalaTransaction();
        if(verifyElementPresent(MLWalletGCashPage.objNoGCashOtherOptionLabel, "Prompt Mobile No is Invalid")){
            verifyElementPresent(MLWalletGCashPage.objSendViaMLKwartaWallelabel, "Send Via Kwarta Padala");
            verifyElementPresent(MLWalletGCashPage.objSendViaMLKwartaPadalaBtn, "Send Via Kwarta Padala Button");
            verifyElementPresent(MLWalletGCashPage.objCloseBtn, "Close Button");
            if(verifyElementDisplayed(MLWalletGCashPage.objSendViaMLKwartaPadalaBtn, "Send Via Kwarta Padala Button Viewed")){
                click(MLWalletGCashPage.objSendViaMLKwartaPadalaBtn, "Send Via Kwarta Padala Button");
                verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala,"Kwarta Padala Label");
            }
        }
    }

    public void GC_RM_TC_182_Contacts()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objGcash, "Gcash Icon Button");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objSendMoneyBtn, "Send Money To Gcash");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGCashPage.objContactsBtn, "Contact Buttons");
        if(verifyElementDisplayed(MLWalletGCashPage.objOkAllowContacts,"Allow Notif")){
            verifyElementPresentAndClick(MLWalletGCashPage.objOkAllowContacts,"Allow Notif Button");
            verifyElementPresent(MLWalletGCashPage.objContactsLabel,"Contacts");
            verifyElementPresent(MLWalletGCashPage.objFavoritesBtn, "Favorites Buttons");
            verifyElementPresent(MLWalletGCashPage.objSearchBox, "Select Box");
            verifyElementPresent(MLWalletGCashPage.objSelectContactsBtn, "Select Contacts");
        }
    }
}
