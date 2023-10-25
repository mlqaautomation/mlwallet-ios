package com.business.mlwallet;

import com.iosmlwalletpages.*;

import java.time.Duration;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;

public class MLWalletCashOutWithdraw extends BaseClass {

    public MLWalletCashOutWithdraw() {
        super();

    }


    //======================================= Generalized methods =============================================//


    public void cashOutSelectBank(String sBank) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button")) {
            click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
            waitTime(6000);
            if (verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"))) {
                click(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
                type(MLWalletCashOutPage.objSearchBank, sBank, "Search Bank Text Field");
                waitTime(2000);
                click(MLWalletCashOutPage.objBogusBank1, getTextVal(MLWalletCashOutPage.objBogusBank1, "Bank"));
                click(MLWalletCashOutPage.objBogusBank1, getTextVal(MLWalletCashOutPage.objBogusBank1, "Bank"));
            }
        }
    }
    public void enterAmountBank(String sAmount) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field")) {
            type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
            waitTime(3000);
            click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
            waitTime(5000);
            click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
            waitTime(10000);
            String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
            String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPopUpMsg, sExpectedMsg);
            click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
            Swipe("Up",1);
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            Thread.sleep(5000);
        }
    }

    public void enterBankDetails(String sAccountNumber) throws Exception {
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            type(MLWalletCashOutPage.objAccountNumberField, sAccountNumber, "Account Number Field");
            type(MLWalletCashOutPage.objFirstname, prop.getproperty("First_Name"), "Account Holder First Name");
            type(MLWalletCashOutPage.objMiddleName, prop.getproperty("Middle_Name"), "Account Holder Middle Name");
            click(MLWalletCashOutPage.objCheckBox, "Check Box");
            type(MLWalletCashOutPage.objLastName, prop.getproperty("Last_Name"), "Account Holder Last Name");
            Swipe("UP", 1);
            type(MLWalletCashOutPage.objEmailAddress, prop.getproperty("Email"), "Account Holder Email Address");
            waitTime(2000);
            click(MLWalletCashOutPage.objdntHaveMiddleNameText, getTextVal(MLWalletCashOutPage.objdntHaveMiddleNameText, "Text"));
            Swipe("UP", 1);
            waitTime(2000);
            click(MLWalletCashOutPage.objConfirmBtn, "Confirm Button");
        }

    }

    public void enterAmountMLBranch(String nAmount) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch,getTextVal(MLWalletCashOutPage.objCashOutToBranch,"Page"));
            waitTime(2000);
            type(MLWalletCashOutPage.objAmountField, nAmount, "Amount to Send");
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            waitTime(2000);
            if(!verifyElementPresent(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button")))
            {
                click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            }
            waitTime(4000);
            click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
            waitTime(3000);
        }
    }


    public void backArrowBtn(int nNumber) throws Exception {
        for (int i = 1; i <= nNumber; i++) {
            waitTime(3000);
            click(MLWalletSendTransferPage.objBackArrow, "Back Arrow Button");
            waitTime(2000);
        }
    }

    //===================================================================================================================//
    public void cashOutWithdrawBank_WM_TC_01(String Amount) throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(Amount);
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            String sTransactionSuccess = getText(MLWalletCashOutPage.objTransactionSuccessMessage);
            assertionValidation(sTransactionSuccess, "Transaction Successful");
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletCashOutPage.objTransactionNo);
            System.out.println(sTransactionNumber);
            Swipe("UP",2);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("WM_TC_01, Successfully Withdraw Money to Bank");
                extentLoggerPass("WM_TC_01", "WM_TC_01, Successfully Withdraw Money to Bank");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutWithInvalidAccNumber_WM_TC_02() throws Exception {
        HeaderChildNode("cashOut With Invalid Account Number");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("Invalid_AccountNumber"));
        Thread.sleep(3000);
        if (verifyElementPresent(MLWalletCashOutPage.objAccInvalidErrorMsg, getTextVal(MLWalletCashOutPage.objAccInvalidErrorMsg, "Text Message"))) {
            String sInvalidAccTxt = getText(MLWalletCashOutPage.objAccInvalidErrorMsg);
            String ExpectedTxt = "Bank Account provided not valid. Please check the account details and try again.";
            assertionValidation(sInvalidAccTxt, ExpectedTxt);
            logger.info("WM_TC_02, Bank Account provided not valid. Error Message is Validated");
            extentLoggerPass("WM_TC_02", "WM_TC_02, Bank Account provided not valid. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutWithdrawBankMaxAmount_WM_TC_03(String Amount) throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch Max Amount");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(Amount);
        if (verifyElementPresent(MLWalletCashOutPage.objBankMaxLimitTxt, getTextVal(MLWalletCashOutPage.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("WM_TC_03, The Maximum Bank Cash-out per transaction Msg is Validated");
            extentLoggerPass("WM_TC_03", "WM_TC_03, The Maximum Bank Cash-out per transaction Msg is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutWithdrawMinTransactionLimit_WM_TC_04(String Amount) throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch Max Amount");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(5000);
        type(MLWalletCashOutPage.objAmountField, Amount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        Thread.sleep(5000);
        if (verifyElementPresent(MLWalletCashOutPage.objMinimumTransactionErrorMsg, getTextVal(MLWalletCashOutPage.objMinimumTransactionErrorMsg, "Error message"))) {
            String sMinimumTransactionErrorMsg = getText(MLWalletCashOutPage.objMinimumTransactionErrorMsg);
            String sExpectedMsg = "The supplied amount is less than the required minimum transaction limit";
            assertionValidation(sMinimumTransactionErrorMsg, sExpectedMsg);
            logger.info("WM_TC_04, The supplied amount is less than the required minimum transaction limit Error Msg is validated");
            extentLoggerPass("WM_TC_04", "WM_TC_04, The supplied amount is less than the required minimum transaction limit Error Msg is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutWithdrawBranch_WM_TC_05() throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            String nReference = getText(MLWalletCashOutPage.objReferenceNumber);
            System.out.println(nReference);
            String sReferenceNumber = nReference.substring(5, 16);
            System.out.println(sReferenceNumber);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("Reference Number is matching with recent Transaction");
                logger.info("WM_TC_05, Successfully Withdraw Money to ML Branch");
                extentLoggerPass("WM_TC_05", "WM_TC_05, Successfully Withdraw Money to ML Branch");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutMaxLimit_WM_TC_06() throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("100000");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitTxt, getTextVal(MLWalletCashOutPage.objMaxLimitTxt, "Text Message"))) {
            String sMaxLimitTxt = getText(MLWalletCashOutPage.objMaxLimitTxt);
            String ExpectedTxt = "The maximum Branch Cash-out per transaction set for your verification level is P40,000.00. Please try again.";
            assertionValidation(sMaxLimitTxt, ExpectedTxt);
            logger.info("WM_TC_06, The supplied amount us less than the required minimum transaction limit. Error Message is Validated");
            extentLoggerPass("WM_TC_06", "WM_TC_06, The supplied amount us less than the required minimum transaction limit. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutInsufficientBalance_WM_TC_07() throws Exception {
        HeaderChildNode("Cash Out Insufficient Balance");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin("9999999997");
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("35000");
        if (verifyElementPresent(MLWalletCashOutPage.objInsufficientBalance, getTextVal(MLWalletCashOutPage.objInsufficientBalance, "Text Message"))) {
            String sInsufficientBalancePopupTxt = getText(MLWalletCashOutPage.objInsufficientBalance);
            String ExpectedTxt = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalancePopupTxt, ExpectedTxt);
            logger.info("WM_TC_07, Insufficient Balance pop up validated");
            extentLoggerPass("WM_TC_07", "WM_TC_07, Insufficient Balance pop up validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08() throws Exception {
        HeaderChildNode("CashOut Branch Maximum Transaction Branch Verified Tier");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("50001");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitTxt, getTextVal(MLWalletCashOutPage.objMaxLimitTxt, "Text Message"))) {
            String sInsufficientBalancePopupTxt = getText(MLWalletCashOutPage.objMaxLimitTxt);
            String ExpectedTxt = "The maximum Branch Cash-out per transaction set for your verification level is P40,000.00. Please try again.";
            assertionValidation(sInsufficientBalancePopupTxt, ExpectedTxt);
            logger.info("WM_TC_08, The Maximum Branch Cash-out per transaction Msg for Branch-verified tier Account is Validated");
            extentLoggerPass("WM_TC_08", "WM_TC_08, The Maximum Branch Cash-out per transaction Msg for Branch-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBuyerTierLevelAcc_WM_TC_09() throws Exception {
        HeaderChildNode("Cash Out Withdraw Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("100");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String ExpectedTxt = "Branch Cash-out is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            logger.info("WM_TC_09, Branch Cash-out is not allowed for customers at this verification level. Error Message is Validated");
            extentLoggerPass("WM_TC_09", "WM_TC_08, Branch Cash-out is not allowed for customers at this verification level. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutInvalidBank_WM_TC_10() throws Exception { //Pass 10
        HeaderChildNode("Cash Out Invalid Bank Details");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button")) {
            click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
            waitTime(3000);
            if (verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"))) {
                click(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
                type(MLWalletCashOutPage.objSearchBank, prop.getproperty("Invalid_BankName"), "Search Bank Text Field");
                waitTime(2000);
                if (verifyElementPresent(MLWalletCashOutPage.objNoRecentTransactionTxt, getTextVal(MLWalletCashOutPage.objNoRecentTransactionTxt, "Text"))) {
                    logger.info("WM_TC_10, No Recent Transaction message Validated after entering invalid Bank Name");
                    extentLoggerPass("WM_TC_10", "WM_TC_10, No Recent Transaction message Validated after entering invalid Bank Name");
                    System.out.println("-----------------------------------------------------------");
                }
            }
        }
    }

    public void searchAndSelectBank_WM_TC_11() throws Exception {
        HeaderChildNode("Search And Select Bank");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objBogusbank2, getTextVal(MLWalletCashOutPage.objBogusbank2, "Bank Name"));
            logger.info("WM_TC_11, Bank Name auto-displayed after searching and selecting the particular Bank");
            extentLoggerPass("WM_TC_11", "WM_TC_11, Bank Name auto-displayed after searching and selecting the particular Bank");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutInvalidAmount_WM_TC_12() throws Exception {
        HeaderChildNode("Search And Select Bank");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(5000);
        click(MLWalletCashOutPage.objAmountField,  "Amount to Send");
        type(MLWalletCashOutPage.objAmountField, "", "Amount to Send");
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objAmountRequiredErrorMsg, getTextVal(MLWalletCashOutPage.objAmountRequiredErrorMsg, "Error Message"))) {
            String sAmountRequiredErrorMsg = getText(MLWalletCashOutPage.objAmountRequiredErrorMsg);
            String sExceptedErrorMsg = "Amount is required";
            assertionValidation(sAmountRequiredErrorMsg, sExceptedErrorMsg);
            logger.info("WM_TC_12, Amount is required - Error message is Validated");
            extentLoggerPass("WM_TC_12", "WM_TC_12, Amount is required - Error message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutSaveRecipient_WM_TC_13(String sAmount) throws Exception {
        HeaderChildNode("Cash out Save Recipient");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails("5"+RandomIntegerGenerator(9));
        waitTime(3000);
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        waitTime(2000);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        Swipe("UP", 2);
        click(MLWalletCashOutPage.objNextBtn1, getTextVal(MLWalletCashOutPage.objNextBtn1, "Button"));
        click(MLWalletCashOutPage.objNextBtn1, getTextVal(MLWalletCashOutPage.objNextBtn1, "Button"));
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(4000);
        Swipe("UP", 2);
        type(MLWalletCashOutPage.objNickName, RandomStringGenerator(5), "Nick Name Input Text Field");
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
        waitTime(4000);
        click(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank"));
        waitTime(4000);
        verifyElementPresent(MLWalletCashOutPage.objSavedBackAccount, getTextVal(MLWalletCashOutPage.objSavedBackAccount, "Page"));
        if (verifyElementPresent(MLWalletCashOutPage.objNickNameInSavedBankAcc, getTextVal(MLWalletCashOutPage.objNickNameInSavedBankAcc, "Nick Name for Saved Bank Account"))) {
            logger.info("WM_TC_13, Saved Recipient is displayed under Saved Bank Account");
            extentLoggerPass("WM_TC_13", "WM_TC_13, Saved Recipient is displayed under Saved Bank Account");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutRecipientDuplicate_WM_TC_14(String sAmount) throws Exception {
        HeaderChildNode("Cash out Recipient Duplicate");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        explicitWaitVisibility(MLWalletCashOutPage.objNextBtnThree, 10);
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        waitTime(3000);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        Swipe("UP", 2);
        click(MLWalletCashOutPage.objNextBtn1, getTextVal(MLWalletCashOutPage.objNextBtn1, "Button"));
        click(MLWalletCashOutPage.objNextBtn1, getTextVal(MLWalletCashOutPage.objNextBtn1, "Button"));
        waitTime(3000);
        enterOTP(prop.getproperty("Valid_OTP"));
        Swipe("UP", 2);
        type(MLWalletCashOutPage.objNickName, prop.getproperty("Nick_Name"), "Nick Name Input Text Field");
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletCashOutPage.objRecipientExistMsg, getTextVal(MLWalletCashOutPage.objRecipientExistMsg, "Popup Message"))) {
            String sRecipientExistMsg = getText(MLWalletCashOutPage.objRecipientExistMsg);
            String sExpectedMsg = "Recipient already exists.";
            assertionValidation(sRecipientExistMsg, sExpectedMsg);
            logger.info("WM_TC_14, Recipient already exists pop up message Validated");
            extentLoggerPass("WM_TC_14", "WM_TC_14, Recipient already exists pop up message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutUIValidation_WM_TC_16() throws Exception {
        HeaderChildNode("Cash Out Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCashOutOptions, getTextVal(MLWalletCashOutPage.objCashOutOptions, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Option"));
            verifyElementPresent(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Option"));
            verifyElementPresent(MLWalletCashOutPage.objCashOutOngoingTransaction, getTextVal(MLWalletCashOutPage.objCashOutOngoingTransaction, "Header"));
            logger.info("WM_TC_16, Cash Out Page UI Validation");
            extentLoggerPass("WM_TC_16", "WM_TC_16, Cash Out Page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutWithdrawBackBtnValidation_WM_TC_17() throws Exception {
        HeaderChildNode("Cash Out Page back arrow Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        waitTime(2000);
        backArrowBtn(1);
        waitTime(2000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("WM_TC_17, Cash Out Page back arrow Button Validation");
            extentLoggerPass("WM_TC_17", "WM_TC_17, Cash Out Page back arrow Button Validation");
            System.out.println("-----------------------------------------------------------");
        }
        mlWalletLogout();
    }

    public void cashOutToBranchUIValidation_WM_TC_18() throws Exception {
        HeaderChildNode("Cash Out To Branch UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutPage, getTextVal(MLWalletCashOutPage.objCashOutPage, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.ObjCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objUserName, getTextVal(MLWalletCashOutPage.objUserName, "User Name"));
            verifyElementPresent(MLWalletCashOutPage.objUserMobileNumber, getTextVal(MLWalletCashOutPage.objUserMobileNumber, "User Mobile Number"));
            verifyElementPresent(MLWalletCashOutPage.objMLWalletBalance, getTextVal(MLWalletCashOutPage.objMLWalletBalance, "Balance"));
            //verifyElementPresent(MLWalletCashOutPage.objCashOutInstructions, "Instructions Icon");
            logger.info("WM_TC_18, Cash Out to Branch Page Validation");
            extentLoggerPass("WM_TC_18", "WM_TC_18, Cash Out to Branch Page Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutToBranchBackBtnValidation_WM_TC_19() throws Exception {
        HeaderChildNode("Cash Out To Branch Page back arrow Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
        waitTime(2000);
        backArrowBtn(1);
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
            logger.info("WM_TC_19, Cash Out To Branch Page back arrow Button Validation");
            extentLoggerPass("WM_TC_19", "WM_TC_19, Cash Out To Branch Page back arrow Button Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutOTPPageUIValidation_WM_TC_20(String sAmount) throws Exception {
        HeaderChildNode("Cash Out OTP Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(2000);
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        explicitWaitVisibility(MLWalletCashOutPage.objContinueBtn, 20);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        Swipe("UP", 2);
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        click(MLWalletCashOutPage.objNextBtnFour, getTextVal(MLWalletCashOutPage.objNextBtnFour, "Button"));
        waitTime(7000);
        click(MLWalletLoginPage.objOtpContineBtn, "Clicked On OTP Continue Button");
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            waitTime(5000);
            Swipe("Up", 1);
            click(MLWalletCashOutPage.objBackToHomeBtn, "Back To Home Button");
            logger.info("WM_TC_20, One Time Pin page UI Validation");
            extentLoggerPass("WM_TC_20", "WM_TC_20, One Time Pin page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
        mlWalletLogout();
    }

    public void cashOutOTPPageBackBtnValidation_WM_TC_21(String sAmount) throws Exception {
        HeaderChildNode("Cash Out OTP Page Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField1, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, "9999999996", "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
        backArrowBtn(1);
        logger.info("WM_TC_21, OTP page back arrow Button Validation");
        extentLoggerPass("WM_TC_21", "WM_TC_21, OTP page back arrow Button Validation");
        System.out.println("-----------------------------------------------------------");
    }

    public void cashOutMLBankBuyerTier_WM_TC_27(String sAmount) throws Exception {
        HeaderChildNode("CashOut ML Bank Buyer Tier");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String ExpectedTxt = "Bank Cash-out is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            verifyElementPresent(MLWalletCashOutPage.objUpgradeNow, getTextVal(MLWalletCashOutPage.objUpgradeNow, "Button"));
            logger.info("WM_TC_27, CashOut ML Bank Buyer Tier Validated");
            extentLoggerPass("WM_TC_27", "WM_TC_27, CashOut ML Bank Buyer Tier Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutSemiVerifiedTier_WM_TC_28(String sAmount) throws Exception {
        HeaderChildNode("CashOut Withdraw Semi-Verified Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumberInCashOut1, getTextVal(MLWalletCashOutPage.objReferenceNumberInCashOut1, "Reference NUmber"));
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            logger.info("WM_TC_28, CashOut Withdraw Semi-Verified Tier Account Validated");
            extentLoggerPass("WM_TC_28", "WM_TC_28, CashOut Withdraw Semi-Verified Tier Account Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutFullyVerifiedTier_WM_TC_29(String sAmount) throws Exception {
        HeaderChildNode("CashOut Withdraw Semi-Verified Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumberInCashOut1, getTextVal(MLWalletCashOutPage.objReferenceNumberInCashOut1, "Reference NUmber"));
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            logger.info("WM_TC_29, CashOut Withdraw Fully_Verified Tier Account Validated");
            extentLoggerPass("WM_TC_29", "WM_TC_29, CashOut Withdraw Fully_Verified Tier Account Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMaxLimitSemiVerifiedTier_WM_TC_33() throws Exception {
        HeaderChildNode("CashOut Bank Maximum Limit For Semi-verified Tier");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("30000");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P5,000.00. Please try again.";assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objUpgradeNow, getTextVal(MLWalletCashOutPage.objUpgradeNow, "Button"));
            logger.info("WM_TC_33, The Maximum Bank Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            extentLoggerPass("WM_TC_33", "WM_TC_33, The Maximum Bank Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMaxLimitFullyVerifiedTier_WM_TC_36() throws Exception {
        HeaderChildNode("CashOut Bank Maximum Limit For Fully-verified Tier");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("60000");
        if (verifyElementPresent(MLWalletCashOutPage.objBankMaxLimitTxt, getTextVal(MLWalletCashOutPage.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objOkBtn, getTextVal(MLWalletCashOutPage.objOkBtn, "Button"));
            logger.info("WM_TC_36, The Maximum Bank Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            extentLoggerPass("WM_TC_36", "WM_TC_36, The Maximum Bank Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankAppropriatePromptMsgValidationByProvidingSpaces_WM_TC_45() throws Exception {
        HeaderChildNode("CashOut Bank, Appropriate prompt msg validation by providing spaces");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));

    }

    public void cashOutBankPageUIValidation_WM_TC_49() throws Exception {
        HeaderChildNode("CashOut Bank Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objSavedBackAccount, getTextVal(MLWalletCashOutPage.objSavedBackAccount, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objBank, getTextVal(MLWalletCashOutPage.objBank, "Bank"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumberField, "Account Number Input Field");
            verifyElementPresent(MLWalletCashOutPage.objFirstname, "First Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objMiddleName, "Middle Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objCheckBox, "I legally do not have a middle name check Box");
            verifyElementPresent(MLWalletCashOutPage.objLastName, "Last Name Input field");
            verifyElementPresent(MLWalletCashOutPage.objEmailAddress, "Email Address Input field");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
            logger.info("WM_TC_49, CashOut Bank Page UI Validated");
            extentLoggerPass("WM_TC_49", "WM_TC_49, CashOut Bank Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutDragonPayPageUIValidation_WM_TC_50() throws Exception {
        HeaderChildNode("CashOut Dragon Pay Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        if (verifyElementPresent(MLWalletCashOutPage.objDragonPage, getTextVal(MLWalletCashOutPage.objDragonPage, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objBankCashOut, getTextVal(MLWalletCashOutPage.objBankCashOut, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objAmountField, "Amount Input Field");
            verifyElementPresent(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            logger.info("WM_TC_50, CashOut Dragon Pay Page UI Validated");
            extentLoggerPass("WM_TC_50", "WM_TC_50, CashOut Dragon Pay Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankReviewTransactionUIValidation_WM_TC_51(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Review Transaction UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(5000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(10000);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "page"))) {
            verifyElementPresent(MLWalletCashOutPage.objReceiverName, getTextVal(MLWalletCashOutPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletCashOutPage.objBankName, getTextVal(MLWalletCashOutPage.objBankName, "Bank Name"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumber, getTextVal(MLWalletCashOutPage.objAccountNumber, "Account Number"));
            verifyElementPresent(MLWalletCashOutPage.objAmount, getTextVal(MLWalletCashOutPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletCashOutPage.objServiceFee, getTextVal(MLWalletCashOutPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletCashOutPage.objTotalAmountDeduct, getTextVal(MLWalletCashOutPage.objTotalAmountDeduct, "Total Amount Deduct"));
            verifyElementPresent(MLWalletCashOutPage.objEmailAddressUpdated, getTextVal(MLWalletCashOutPage.objEmailAddressUpdated, "Email Address"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime, getTextVal(MLWalletCashInBank.objBankTransferCutOffTime, "Message"));
            String sBankTransferTime = getText(MLWalletCashInBank.objBankTransferCutOffTime);
            String sExpectedBankTransferTime = "Bank transfers after 1:00PM are posted on the next banking day.";
            assertionValidation(sBankTransferTime, sExpectedBankTransferTime);
            verifyElementPresent(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "button"));
            logger.info("WM_TC_51, CashOut Bank Review Transaction UI Validated");
            extentLoggerPass("WM_TC_51", "WM_TC_51, CashOut Bank Review Transaction UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionReceiptUIValidation_WM_TC_52(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction Receipt UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReceiverNameInTransactionReceipt, getTextVal(MLWalletCashOutPage.objReceiverNameInTransactionReceipt, "Receiver's Name"));
            verifyElementPresent(MLWalletCashOutPage.objBankNamInTransactionReceipt, getTextVal(MLWalletCashOutPage.objBankNamInTransactionReceipt, "Bank Name"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumberInTransactionReceipt, getTextVal(MLWalletCashOutPage.objAccountNumberInTransactionReceipt, "Account Number"));
            verifyElementPresent(MLWalletCashOutPage.objPrincipalAmount, getTextVal(MLWalletCashOutPage.objPrincipalAmount, "Principal Amount"));
            verifyElementPresent(MLWalletCashOutPage.objServiceFeeInTransactionReceipt, getTextVal(MLWalletCashOutPage.objServiceFeeInTransactionReceipt, "Service Fee"));
            verifyElementPresent(MLWalletCashOutPage.objNetAmount, getTextVal(MLWalletCashOutPage.objNetAmount, "Net Amount"));
            verifyElementPresent(MLWalletCashOutPage.objEmailInTransactionReceipt, getTextVal(MLWalletCashOutPage.objEmailInTransactionReceipt, "Email"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletCashOutPage.objDate, getTextVal(MLWalletCashOutPage.objDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objType, getTextVal(MLWalletCashOutPage.objType, "Type"));
            verifyElementPresent(MLWalletCashOutPage.objAddToSavedRecipients, getTextVal(MLWalletCashOutPage.objAddToSavedRecipients, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objNickName, "Nick Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
            logger.info("WM_TC_52, CashOut Bank Transaction Receipt UI Validated");
            extentLoggerPass("WM_TC_52", "WM_TC_52, CashOut Bank Transaction Receipt UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutRecentTransactionDetailsUIValidation_WM_TC_53() throws Exception {
        HeaderChildNode("CashOut Recent Transaction Details UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            Swipe("UP",2);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Transaction Type"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objBank, getTextVal(MLWalletTransactionHistoryPage.objBank, "Bank"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashOut, getTextVal(MLWalletTransactionHistoryPage.objTotalCashOut, "Total Cash Out"));
                logger.info("WM_TC_53, CashOut Recent Transaction Details UI Validated");
                extentLoggerPass("WM_TC_53", "WM_TC_53, CashOut Recent Transaction Details UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cahOutBankViewAllPageBackBtnValidation_WM_TC_56() throws Exception {
        HeaderChildNode("CashOut Bank, View All Page Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBackBtn, "Back Button in ViewAll page");
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            logger.info("WM_TC_56, CashOut Bank, View All Page Back Button Validated");
            extentLoggerPass("WM_TC_56", "WM_TC_56, CashOut Bank, View All Page Back Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankSavedRecipientEditBackButton_WM_TC_57() throws Exception {
        HeaderChildNode("CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objEditBtn, getTextVal(MLWalletCashOutPage.objEditBtn, "Button"));
        clearField(MLWalletCashOutPage.objAccountNumberInEditRecipient,"Account Number In Edit Recipient");
        type(MLWalletCashOutPage.objAccountNumberInEditRecipient, prop.getproperty("EditedAccountNumber"), "Account Number In Edit Recipient");
        click(MLWalletCashOutPage.objEditRecipientBackBtn, "Edit Recipient Back Button");
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberAfterNavigatingBack = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        assertionValidation(sAccountNumberInSavedBankAccount, sAccountNumberAfterNavigatingBack);
        if (sAccountNumberInSavedBankAccount.contains(sAccountNumberAfterNavigatingBack)) {
            logger.info("WM_TC_57, CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation validated");
            extentLoggerPass("WM_TC_57", "WM_TC_57, CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankEditRecipient_WM_TC_58() throws Exception {
        HeaderChildNode("CashOut/Withdraw Edit Recipient");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objEditBtn, getTextVal(MLWalletCashOutPage.objEditBtn, "Button"));
        clearField(MLWalletCashOutPage.objAccountNumberInEditRecipient,"Account Number In Edit Recipient");
        type(MLWalletCashOutPage.objAccountNumberInEditRecipient, prop.getproperty("EditedAccountNumber"), "Account Number In Edit Recipient");
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sEditedAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        assertNotEquals(sAccountNumberInSavedBankAccount, sEditedAccountNumberInSavedBankAccount);
        if (sAccountNumberInSavedBankAccount != sEditedAccountNumberInSavedBankAccount) {
            logger.info("WM_TC_58, CashOut/Withdraw Edit Recipient validated");
            extentLoggerPass("WM_TC_58", "WM_TC_58, CashOut/Withdraw Edit Recipient validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankDeleteRecipient_WM_TC_59() throws Exception {
        HeaderChildNode("CashOut/Withdraw Delete Recipient");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objDeleteBtn, getTextVal(MLWalletCashOutPage.objDeleteBtn, "Button"));
        verifyElementNotPresent(MLWalletCashOutPage.objAccountNumber(sAccountNumberInSavedBankAccount),  5);
        logger.info("WM_TC_59, CashOut/Withdraw Delete Recipient validated");
        extentLoggerPass("WM_TC_59", "WM_TC_59, CashOut/Withdraw Delete Recipient validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void cashOutBankBackToHomeBtnValidation_WM_TC_62() throws Exception {
        HeaderChildNode("CashOut/Withdraw Bank, Back to Home button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            Swipe("UP",2);
            verifyElementPresentAndClick(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
                logger.info("WM_TC_62, CashOut/Withdraw Bank, After Clicking on Back To Home Button, Application should navigate to Home Page is Validated");
                extentLoggerPass("WM_TC_62", "WM_TC_62, CashOut/Withdraw Bank, After Clicking on Back To Home Button, Application should navigate to Home Page is Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBankNewTransactionBtnValidation_WM_TC_63() throws Exception {
        HeaderChildNode("CashOut/Withdraw Bank, New Transaction Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            Swipe("UP",2);
            verifyElementPresentAndClick(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
            if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
                logger.info("WM_TC_63, CashOut/Withdraw Bank, After Clicking on New Transaction Button, Application should navigate to CashOut/WithDraw Page is Validated");
                extentLoggerPass("WM_TC_63", "WM_TC_63, CashOut/Withdraw Bank, After Clicking on New Transaction Button, Application should navigate to CashOut/WithDraw Page is Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBankDragonPayMessageValidation_WM_TC_64(String sAmount) throws Exception {
        HeaderChildNode("CashOut/WithDraw Bank Dragon Pay Message Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        waitTime(3000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(5000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletCashOutPage.objDragonPayPopUpMsg, getTextVal(MLWalletCashOutPage.objDragonPayPopUpMsg, "Dragon Pay Message"))) {
            String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
            String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPopUpMsg, sExpectedMsg);
            logger.info("WM_TC_64, CashOut/WithDraw Bank Dragon Pay Message Validated");
            extentLoggerPass("WM_TC_64", "WM_TC_64, CashOut/WithDraw Bank Dragon Pay Message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65(String sAmount, int serviceFee) throws Exception {
        HeaderChildNode("CashOut/Withdraw Bank, Review Transaction Total Amount Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        waitTime(3000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(5000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(10000);
        String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
        String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPopUpMsg, sExpectedMsg);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "page"));
        verifyElementPresent(MLWalletCashOutPage.objTotalAmountDeduct, getTextVal(MLWalletCashOutPage.objTotalAmountDeduct, "Total Amount Deduct"));
        String sTotalAmountDeductWithPHP = getText(MLWalletCashOutPage.objTotalAmountDeduct);
        System.out.println(sTotalAmountDeductWithPHP);
        String sActualTotalAmountDeduct = sTotalAmountDeductWithPHP.substring(4, 7);
        logger.info("Actual Total Amount Deduct displayed : " + sActualTotalAmountDeduct);
        int nAmount = Integer.parseInt(sAmount);
        int nExceptedTotalAmountDeduct = nAmount + serviceFee;
        String sExceptedTotalAmount = Integer.toString(nExceptedTotalAmountDeduct);
        logger.info("Expected Total Amount Deduct : " + sExceptedTotalAmount);
        assertionValidation(sActualTotalAmountDeduct, sExceptedTotalAmount);
        if (sActualTotalAmountDeduct.equals(sExceptedTotalAmount)) {
            logger.info("WM_TC_65, CashOut/Withdraw Bank, Review Transaction Total Amount Validated");
            extentLoggerPass("WM_TC_65", "WM_TC_65, CashOut/Withdraw Bank, Review Transaction Total Amount Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83(String sAmount) throws Exception {
        HeaderChildNode("CashOut/Withdraw Bank Transaction Validation After Minimizing App");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enterOTP(prop.getproperty("Valid_OTP"));
        getDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(3000);
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"))) {
            logger.info("WM_TC_83, CashOut/Withdraw Bank Transaction Validation After Minimizing App Validated");
            extentLoggerPass("WM_TC_83", "WM_TC_83, CashOut/Withdraw Bank Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankAmountFieldValidation_WM_TC_97(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank, Amount Field with more than 2 decimals Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(5000);
        click(MLWalletCashOutPage.objAmountNextBtn, getTextVal(MLWalletCashOutPage.objAmountNextBtn, "Button"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidAmountMsg, getTextVal(MLWalletCashOutPage.objInvalidAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashOutPage.objInvalidAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("WM_TC_97, CashOut Bank, Amount Field with more than 2 decimals Error Msg validated");
            extentLoggerPass("WM_TC_97", "WM_TC_97, CashOut Bank, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionWithValidMLPin_WM_TC_99(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction With Valid ML Pin");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        handleMpin("1111","MPin");
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            String sTransactionSuccess = getText(MLWalletCashOutPage.objTransactionSuccessMessage);
            assertionValidation(sTransactionSuccess, "Transaction Successful");
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletCashOutPage.objTransactionNo);
            System.out.println(sTransactionNumber);
            Swipe("UP",2);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("WM_TC_99, CashOut Bank Transaction With Valid ML Pin validated");
                extentLoggerPass("WM_TC_99", "WM_TC_99, CashOut Bank Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBranchTransactionWithInValidMLPin_WM_TC_100(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction With Invalid ML Pin");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        handleMpin("1234","MPin");
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidPINMsg, getTextVal(MLWalletCashOutPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashOutPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("WM_TC_100, CashOut Bank Transaction With Invalid ML Pin validated");
            extentLoggerPass("WM_TC_100", "WM_TC_100, CashOut Bank Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutBankInAppOTPPopupValidation_WM_TC_119(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank InApp OTP Popup validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("WM_TC_119, CashOut Bank InApp OTP Popup validated");
            extentLoggerPass("WM_TC_119", "WM_TC_119, CashOut Bank InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction InApp OTP Popup UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("WM_TC_120, CashOut Bank Transaction InApp OTP Popup UI validated");
            extentLoggerPass("WM_TC_120", "WM_TC_120, CashOut Bank Transaction InApp OTP Popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction New OTP got generated After Sixty Seconds validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("WM_TC_121, CashOut Bank Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("WM_TC_121", "WM_TC_121, CashOut Bank Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction OTP Cancel Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "Page"))) {
            logger.info("WM_TC_122, CashOut Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to Review Transaction Page is validated");
            extentLoggerPass("WM_TC_122", "WM_TC_122, CashOut Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to Review Transaction is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123(String sAmount) throws Exception {
        HeaderChildNode("CashOut Bank Transaction OTP Continue Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"))) {
            logger.info("WM_TC_123, CashOut Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("WM_TC_123", "WM_TC_123, CashOut Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

}
