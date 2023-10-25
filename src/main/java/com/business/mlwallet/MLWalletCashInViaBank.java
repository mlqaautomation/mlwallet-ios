package com.business.mlwallet;

import com.iosmlwalletpages.*;
import com.iosmlwalletpages.MLWalletLoginPage;
import com.iosmlwalletpages.MLWalletSendTransferPage;
import com.iosmlwalletpages.MLWalletTransactionHistoryPage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletSendTransferToMLWalletUser.verifyRecentTransaction3;
import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

public class MLWalletCashInViaBank extends BaseClass {

    public MLWalletCashInViaBank() {
        super();

    }

//========================================= Generalized methods ================================================//
    public void selectBankAndInputAmount(String sAmount) throws Exception {
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"))) {
            click(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
            waitTime(10000);
            click(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"));
            click(MLWalletCashInBank.objTestBankOnline, getTextVal(MLWalletCashInBank.objTestBankOnline, "Bank"));
            waitTime(2000);
            verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"));
            verifyElementPresent(MLWalletCashInBank.objBankCashIn, getTextVal(MLWalletCashInBank.objBankCashIn, "Text"));
            type(MLWalletCashInBank.objAmountEditField, sAmount, "Amount Text Field");
            click(MLWalletCashInBank.objNextBtn1, getTextVal(MLWalletCashInBank.objNextBtn1, "Button"));
            click(MLWalletCashInBank.objNextBtn1, getTextVal(MLWalletCashInBank.objNextBtn1, "Button"));
            click(MLWalletCashInBank.objNextBtn1, getTextVal(MLWalletCashInBank.objNextBtn1, "Button"));
            waitTime(3000);
        }
    }
    public void dragonPayChargesMsgValidation() throws Exception {
        if (verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"))) {
            String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
            String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
            click(MLWalletCashInBank.objContinueBtn, getTextVal(MLWalletCashInBank.objContinueBtn, "Button"));
            waitTime(3000);
        }
    }
    public void verifyRecentTransaction() throws Exception
    {
        mlWalletLogout();
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        enterOTP("111111");
        waitTime(5000);
    }
    public void reviewTransactionValidation() throws Exception {
        waitTime(10000);
        verifyElementPresent(MLWalletCashInBank.objReviewTransaction,getTextVal(MLWalletCashInBank.objReviewTransaction,"Page"));
        if(verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime,getTextVal(MLWalletCashInBank.objBankTransferCutOffTime,"Message"))){
            String sBankTransferTime = getText(MLWalletCashInBank.objBankTransferCutOffTime);
            String sExpectedBankTransferTime ="Bank transfers after 1:00PM are posted on the next banking day.";
            assertionValidation(sBankTransferTime,sExpectedBankTransferTime);
        }
        click(MLWalletCashInBank.objNextBtn1,getTextVal(MLWalletCashInBank.objNextBtn1,"Button"));
        click(MLWalletCashInBank.objNextBtn1,getTextVal(MLWalletCashInBank.objNextBtn1,"Button"));
    }


    public void bankUserLogin(String sLoginId,String sPassword) throws Exception {
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objReferenceNumberMsg,getTextVal(MLWalletCashInBank.objReferenceNumberMsg,"Reference Information"))){
            type(MLWalletCashInBank.objLoginIdTxtField,sLoginId,"Login Id Text Field");
            type(MLWalletCashInBank.objPasswordTxtField,sPassword,"Password Text Field");

        }
    }
    public void backArrowBtn(int nNumber) throws Exception {
        for (int i = 1; i <= nNumber; i++) {
            waitTime(3000);
            click(MLWalletSendTransferPage.objBackArrow, "Back Arrow Button");
            waitTime(2000);
        }
    }

//=====================================================================================//
    public void cashInViaBank_CIBA_TC_01() throws Exception {
        HeaderChildNode("Cash In Via Bank");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(2000);
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objContinueBtn,"Continue Button");
        waitTime(3000);
        click(MLWalletCashInBank.objPayBtn,getTextVal(MLWalletCashInBank.objPayBtn,"Button"));
        waitTime(8000);
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber,getTextVal(MLWalletCashInBank.objBankReferenceNumber,"Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus,getTextVal(MLWalletCashInBank.objStatus,"Status"));
        if(verifyElementPresent(MLWalletCashInBank.objSuccessMsg,getTextVal(MLWalletCashInBank.objSuccessMsg,"Message"))) {
            click(MLWalletCashInBank.objCompleteTransactionBtn, "Complete Transaction Button");
            logger.info("CIBA_TC_01, Cash In Via Bank validated");
            extentLoggerPass("CIBA_TC_01", "CIBA_TC_01, Cash In Via Bank validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankMinimumTransactionLimit_CIBA_TC_03() throws Exception {
        HeaderChildNode("Cash In Via Bank Minimum Transaction Limit");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("20");
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objMinimumTransactionPopupMsg,getTextVal(MLWalletCashInBank.objMinimumTransactionPopupMsg,"Pop Message"))){
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInBank.objMinimumTransactionPopupMsg);
            String sExpectedPopupMsg = "The supplied amount is less than the required minimum transaction limit";
            assertionValidation(sMinimumTransactionPopupMsg,sExpectedPopupMsg);
            click(MLWalletCashInBank.objOkBtn, "OK Button");
            logger.info("CIBA_TC_03, Minimum transaction limit pop up message is validated");
            extentLoggerPass("CIBA_TC_03", "CIBA_TC_03, Minimum transaction limit pop up message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankMaximumTransaction_CIBA_TC_04() throws Exception {
        HeaderChildNode("Cash In Via Bank Maximum Transaction");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objMaxLimitErrorMsg, getTextVal(MLWalletCashInBank.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletCashInBank.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_04, The maximum send money per transaction - Error Message is validated");
            extentLoggerPass("CIBA_TC_04", "CIBA_TC_04, The maximum send money per transaction - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankInvalidAmount_CIBA_TC_05() throws Exception {
        HeaderChildNode("Cash In Via Bank Invalid Amount");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("0");
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objInvalidAmountMsg, getTextVal(MLWalletCashInBank.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInBank.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_05, The amount should not be less than 1 - Error Message is validated");
            extentLoggerPass("CIBA_TC_05", "CIBA_TC_05, The amount should not be less than 1 - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankNavigation_CIBA_TC_06() throws Exception {
        HeaderChildNode("Cash In Via Bank Navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Icon"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objCashInPage,getTextVal(MLWalletCashInBank.objCashInPage,"Page"))){
            logger.info("CIBA_TC_06, Navigated to Cash In Page Validated");
            extentLoggerPass("CIBA_TC_06", "CIBA_TC_06, Navigated to Cash In Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInUIValidation_CIBA_TC_07() throws Exception {
        HeaderChildNode("Cash In Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Icon"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objCashInPage,getTextVal(MLWalletCashInBank.objCashInPage,"Page"))){
            verifyElementPresent(MLWalletCashInBank.objCashInOption,getTextVal(MLWalletCashInBank.objCashInOption,"Header"));
            verifyElementPresent(MLWalletCashInBank.objMyBankAccount,getTextVal(MLWalletCashInBank.objMyBankAccount,"Option"));
            verifyElementPresent(MLWalletCashInBank.objBranchName,getTextVal(MLWalletCashInBank.objBranchName,"Option"));
            logger.info("CIBA_TC_07, Cash In Page UI validated");
            extentLoggerPass("CIBA_TC_07", "CIBA_TC_07, Cash In Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInPageBackArrowBtnValidation_CIBA_TC_08() throws Exception {
        HeaderChildNode("Cash In Page Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Icon"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objCashInPage,getTextVal(MLWalletCashInBank.objCashInPage,"Page"))){
            waitTime(2000);
            verifyElementPresentAndClick(MLWalletSendTransferPage.objBackArrow,"Cash In Back Button");
        }
        explicitWaitVisible(MLWalletLoginPage.objAvailableBalance, 10);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("CIBA_TC_08, Cash In Page Back Button validated");
            extentLoggerPass("CIBA_TC_08", "CIBA_TC_08, Cash In Page Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInSelectBankPageUIValidation_CIBA_TC_09() throws Exception {
        HeaderChildNode("Cash In Select Bank Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Icon"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletCashInBank.objMyBankAccount,getTextVal(MLWalletCashInBank.objMyBankAccount,"Option"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objSelectABank,getTextVal(MLWalletCashInBank.objSelectABank,"Header"))){
            verifyElementPresent(MLWalletCashInBank.objSearchBank,"Search Bank Input Field");
            if (verifyElementDisplayed(MLWalletCashInBank.objBanks,"Banks")) {
                List<WebElement> values = findElements(MLWalletCashInBank.objBanks);
                for (int i = 0; i < values.size(); i++) {
                    String savedRecipientName = values.get(i).getText();
                    logger.info("Bank : " + savedRecipientName + " is displayed");
                    extentLogger(" ", "Bank : " + savedRecipientName + " is displayed");
                }
            }
            logger.info("CIBA_TC_09, Cash In Select Bank Page UI validated");
            extentLoggerPass("CIBA_TC_09", "CIBA_TC_09, Cash In Select Bank Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankSearchInvalidBank_CIBA_TC_10() throws Exception {
        HeaderChildNode("Cash In Via Bank Invalid Bank");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Icon"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletCashInBank.objMyBankAccount,getTextVal(MLWalletCashInBank.objMyBankAccount,"Option"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objSelectABank,getTextVal(MLWalletCashInBank.objSelectABank,"Header"))) {
            type(MLWalletCashInBank.objSearchBank,prop.getproperty("Invalid_BankName"), "Search Bank Input Field");
            if(verifyElementPresent(MLWalletCashInBank.objNoRecentTransactionTxt,getTextVal(MLWalletCashInBank.objNoRecentTransactionTxt,"Text"))){
                logger.info("CIBA_TC_10, Cash In Select Bank Page UI validated");
                extentLoggerPass("CIBA_TC_10", "CIBA_TC_10, Cash In Select Bank Page UI validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashInViaBankSelectBankPageBackBtnValidation_CIBA_TC_11() throws Exception {
        HeaderChildNode("Cash In Via Bank Select Bank Page BackArrow Button Validation");
        cashInViaBankSearchInvalidBank_CIBA_TC_10();
        verifyElementPresentAndClick(MLWalletCashInBank.objSelectBankBackBtn,"Select A Bank Page Back Button");
        backArrowBtn(1);
        if(verifyElementPresent(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Page"))){
            logger.info("CIBA_TC_11, Select Bank Page Back Button validated");
            extentLoggerPass("CIBA_TC_11", "CIBA_TC_11, Select Bank Page Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayPageUIValidation_CIBA_TC_12() throws Exception {
        HeaderChildNode("Cash In Via Bank Dragon Pay Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        click(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        waitTime(10000);
        click(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"));
        click(MLWalletCashInBank.objTestBankOnline, getTextVal(MLWalletCashInBank.objTestBankOnline, "Bank"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"))) {
            verifyElementPresent(MLWalletCashInBank.objBankCashIn, getTextVal(MLWalletCashInBank.objBankCashIn, "Text"));
            verifyElementPresent(MLWalletCashInBank.objAmountEditField, "Amount Text Field");
            verifyElementPresent(MLWalletCashInBank.objNextBtn1, getTextVal(MLWalletCashInBank.objNextBtn1, "Button"));
            logger.info("CIBA_TC_12, Cash In Via Bank Dragon Pay Page UI validated");
            extentLoggerPass("CIBA_TC_12", "CIBA_TC_12, Cash In Via Bank Dragon Pay Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayBackBtnValidation_CIBA_TC_13() throws Exception {
        HeaderChildNode("Cash In Via Bank Dragon Pay Back Button Validation");
        cashInViaBankDragonPayPageUIValidation_CIBA_TC_12();
        verifyElementPresentAndClick(MLWalletCashInBank.objDragonPayBackBtn,"Dragon Pay Back Button");
        waitTime(2000);
        if(verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"))){
            logger.info("CIBA_TC_13, Cash In Via Bank Dragon Pay Back Button validated");
            extentLoggerPass("CIBA_TC_13", "CIBA_TC_13, Cash In Via Bank Dragon Pay Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankReviewTransactionPageUIValidation_CIBA_TC_14() throws Exception {
        HeaderChildNode("Cash In Via Bank Review Transaction Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        if(verifyElementPresent(MLWalletCashInBank.objReviewTransaction, getTextVal(MLWalletCashInBank.objReviewTransaction,"Page"))) {
            verifyElementPresent(MLWalletCashInBank.objReceiverName, getTextVal(MLWalletCashInBank.objReceiverName,"Receiver's Name"));
            verifyElementPresent(MLWalletCashInBank.objBankName, getTextVal(MLWalletCashInBank.objBankName,"Bank Name"));
            verifyElementPresent(MLWalletCashInBank.objPrincipalAmount, getTextVal(MLWalletCashInBank.objPrincipalAmount,"Principal Amount"));
            verifyElementPresent(MLWalletCashInBank.objServiceFee, getTextVal(MLWalletCashInBank.objServiceFee,"Service Fee"));
            verifyElementPresent(MLWalletCashInBank.objEmail, getTextVal(MLWalletCashInBank.objEmail,"Email"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime, getTextVal(MLWalletCashInBank.objBankTransferCutOffTime, "Message"));
            verifyElementPresent(MLWalletCashInBank.objNextBtn1, getTextVal(MLWalletCashInBank.objNextBtn1, "Button"));
            logger.info("CIBA_TC_14, Cash In Via Bank Review Transaction Page UI validated");
            extentLoggerPass("CIBA_TC_14", "CIBA_TC_14, Cash In Via Bank Review Transaction Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankReviewTransactionBackBtnValidation_CIBA_TC_15() throws Exception {
        HeaderChildNode("Cash In Via Bank Review Transaction Back Button Validation");
        waitTime(2000);
        changeNumberPage();
        cashInViaBankReviewTransactionPageUIValidation_CIBA_TC_14();
        verifyElementPresentAndClick(MLWalletCashInBank.objReviewTransactionBackBtn,"Review Transaction Back Button");
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objDragonPay,getTextVal(MLWalletCashInBank.objDragonPay,"Page"))){
            logger.info("CIBA_TC_15, Cash In Via Bank Review Transaction Back Button validated");
            extentLoggerPass("CIBA_TC_15", "CIBA_TC_15, Cash In Via Bank Review Transaction Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankPendingTransaction_CIBA_TC_17() throws Exception {
        HeaderChildNode("Cash In Via Bank Pending Transaction");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("108");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objContinueBtn,"Continue Button");
        waitTime(5000);
        click(MLWalletCashInBank.objPayBtn,getTextVal(MLWalletCashInBank.objPayBtn,"Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber,getTextVal(MLWalletCashInBank.objBankReferenceNumber,"Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus,getTextVal(MLWalletCashInBank.objStatus,"Status"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn,getTextVal(MLWalletCashInBank.objCompleteTransactionBtn,"Button"));
        verifyRecentTransaction();
        waitTime(6000);
        if(verifyElementPresent(MLWalletCashInBank.objCashIn,getTextVal(MLWalletCashInBank.objCashIn,"Transaction"))){
            verifyElementPresent(MLWalletCashInBank.objPendingStatus,getTextVal(MLWalletCashInBank.objPendingStatus,"Status"));
            String sStatus = getText(MLWalletCashInBank.objPendingStatus);
            String pendingStatus=sStatus.substring(2, 9);
            String sExpectedStatus = "Pending";
            assertionValidation(pendingStatus,sExpectedStatus);
            logger.info("CIBA_TC_17, An entry in recent transaction for current Cash In should be present with status pending validated");
            extentLoggerPass("CIBA_TC_17", "CIBA_TC_17, An entry in recent transaction for current Cash In should be present with status pending validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void cancelButtonValidationInDragonPayPopUp_CIBA_TC_21() throws Exception {
        HeaderChildNode("Cancel Button Validation In Dragon Pay PopUp");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"));
        String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
        String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
        click(MLWalletCashInBank.objCancelBtn, getTextVal(MLWalletCashInBank.objCancelBtn, "Button"));
        if(verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"))){
            logger.info("CIBA_TC_21, Cancel Button Validated In Dragon Pay PopUp");
            extentLoggerPass("CIBA_TC_21", "CIBA_TC_21, Cancel Button Validated In Dragon Pay PopUp");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23() throws Exception {
        HeaderChildNode("Cash In Via Bank Invalid Amount Field Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("");
        if (verifyElementPresent(MLWalletCashInBank.objInvalidAmountMsg1, getTextVal(MLWalletCashInBank.objInvalidAmountMsg1, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInBank.objInvalidAmountMsg1);
            String sExpectedErrorMsg = "Amount is required";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_23, Amount is required - Error Message is validated");
            extentLoggerPass("CIBA_TC_23", "CIBA_TC_23, Amount is required - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22() throws Exception {
        HeaderChildNode("Cash In Via Bank Tapping Outside the Dragon Pay Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"));
        String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
        String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
        tapUsingCoordinates(500,1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        if (verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Popup Message"))) {
            logger.info("CIBA_TC_22, Cash In Via Bank, After Tapping Outside the Dragon Pay Popup, Popup doesn't closed");
            extentLoggerPass("CIBA_TC_22", "CIBA_TC_22, Cash In Via Bank, After Tapping Outside the Dragon Pay Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashInViaBankBuyerTierLevel_CIBA_TC_24() throws Exception {
        HeaderChildNode("Cash In Via Bank Buyer Tier Level");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInBank.objMaxLimitTxt, getTextVal(MLWalletCashInBank.objMaxLimitTxt, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashInBank.objMaxLimitTxt);
            String ExpectedTxt = "Bank Cash-in is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            verifyElementPresentAndClick(MLWalletCashInBank.objUpgradeNowBtn,getTextVal(MLWalletCashInBank.objUpgradeNowBtn,"Button"));
            logger.info("CIBA_TC_24, Branch Cash-In is not allowed for customers at this verification level. Error Message is Validated");
            extentLoggerPass("CIBA_TC_24", "CIBA_TC_24, Branch Cash-In is not allowed for customers at this verification level. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27() throws Exception {
        HeaderChildNode("Cash In Via Bank Maximum Limit");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objBankMaxLimitTxt,getTextVal(MLWalletCashInBank.objBankMaxLimitTxt,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInBank.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresentAndClick(MLWalletCashInBank.objUpgradeNowBtn,getTextVal(MLWalletCashInBank.objUpgradeNowBtn,"Button"));
            logger.info("CIBA_TC_27, To validate Maximum Limit of transaction");
            extentLoggerPass("CIBA_TC_27", "CIBA_TC_27, To validate Maximum Limit of transaction");
            waitTime(3000);
        }
    }

    public void cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28() throws Exception {
        HeaderChildNode("Cash In Via Bank Maximum Limit");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if(verifyElementPresent(MLWalletCashInBank.objBankMaxLimitTxt,getTextVal(MLWalletCashInBank.objBankMaxLimitTxt,"Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInBank.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_28, To validate Maximum Limit of transaction");
            extentLoggerPass("CIBA_TC_28", "CIBA_TC_28, To validate Maximum Limit of transaction");
        }
    }

    public void cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction Details Page UI Validation");
        cashInViaBank_CIBA_TC_01();
//						verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn,getTextVal(MLWalletCashInBank.objCompleteTransactionBtn,"Button"));
        verifyRecentTransaction3(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        click(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"));
        explicitWaitVisibility(MLWalletCashOutPage.objTransactionDetails, 10);
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate,getTextVal(MLWalletTransactionHistoryPage.objDate,"Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            //	verifyElementPresent(MLWalletTransactionHistoryPage.objBank,getTextVal(MLWalletTransactionHistoryPage.objBank,"Bank"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashIn, getTextVal(MLWalletTransactionHistoryPage.objTotalCashIn, "Total Cash In"));
            logger.info("CIBA_TC_29, Cash In Via Bank Transaction Details Page UI Validated");
            extentLoggerPass("CIBA_TC_29", "CIBA_TC_29, Cash In Via Bank Transaction Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32() throws Exception {
        HeaderChildNode("Cash In Via Bank Dragon Pay charges popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        selectBankAndInputAmount("100");
        explicitWaitVisibility(MLWalletCashInBank.objDragonPayChargesMsg, 10);
        if(verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"))) {
            String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
            String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
            click(MLWalletCashInBank.objCancelBtn, "Cancel Button");
            logger.info("CIBA_TC_32, Cash In Via Bank Dragon Pay charges popup Validated");
            extentLoggerPass("CIBA_TC_32", "CIBA_TC_32, Cash In Via Bank Dragon Pay charges popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void cashInViaBankAmountFieldValidation_CIBA_TC_49() throws Exception {
        HeaderChildNode("Cash In Via Bank, Amount Field with more than 2 decimals Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("1000.123");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInBank.objInvalidDecimalAmountMsg, getTextVal(MLWalletCashInBank.objInvalidDecimalAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInBank.objInvalidDecimalAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("CIBA_TC_49, Cash In Via Bank, Amount Field with more than 2 decimals Error Msg validated");
            extentLoggerPass("CIBA_TC_49", "CIBA_TC_49, Cash In Via Bank, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTransactionWithValidMLPin_CIBA_TC_50() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction With Valid ML Pin");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        handleMpin("1111", "Entered Valid MPIN");
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletCashInBank.objSuccessMsg, getTextVal(MLWalletCashInBank.objSuccessMsg, "Message"))) {
            logger.info("CIBA_TC_50, Cash In Via Bank Transaction With Valid ML Pin validated");
            extentLoggerPass("CIBA_TC_50", "CIBA_TC_50, Cash In Via Bank Transaction With Valid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction With Invalid ML Pin");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        handleMpin("1234", "Entered Invalid MPIN");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInBank.objInvalidPINMsg, getTextVal(MLWalletCashInBank.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInBank.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("CIBA_TC_51, Cash In Via Bank Transaction With Invalid ML Pin validated");
            extentLoggerPass("CIBA_TC_51", "CIBA_TC_51, Cash In Via Bank Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankOTPPopupValidation_CIBA_TC_57() throws Exception {
        HeaderChildNode("Cash In Via Bank OTP Popup validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(3000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("CIBA_TC_57, Cash In Via Bank, OTP popup validated");
            extentLoggerPass("CIBA_TC_57", "CIBA_TC_57, Cash In Via Bank, OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction InApp OTP Popup UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("CIBA_TC_58, Cash In Via Bank Transaction InApp OTP Popup validated");
            extentLoggerPass("CIBA_TC_58", "CIBA_TC_58, Cash In Via Bank Transaction InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction New OTP got generated After Sixty Seconds validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("CIBA_TC_59, Cash In Via Bank Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("CIBA_TC_59", "CIBA_TC_59, Cash In Via Bank Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction OTP Cancel Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        if(verifyElementPresent(MLWalletCashInBank.objReviewTransaction,getTextVal(MLWalletCashInBank.objReviewTransaction,"Page"))){
            logger.info("CIBA_TC_60, Cash In Via Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to review transaction Page is validated");
            extentLoggerPass("CIBA_TC_60", "CIBA_TC_60, Cash In Via Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to review transaction Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61() throws Exception {
        HeaderChildNode("Cash In Via Bank Transaction OTP Continue Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInBank.objReferenceNumberMsg, "Dragon Pay bank Page")) {
            logger.info("CIBA_TC_61, Cash In Via Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("CIBA_TC_61", "CIBA_TC_61, Cash In Via Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

}
