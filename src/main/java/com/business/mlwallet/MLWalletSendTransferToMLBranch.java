package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;

public class MLWalletSendTransferToMLBranch extends BaseClass{

    public MLWalletSendTransferToMLBranch(){
        super();
    }

    //=============================== General methods For send transfer ============================================//

    public void sendMoneyToAnyMLBranch() throws Exception {
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        waitTime(10000);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
        }
    }

    public void sendMoneyToAnyMLBranch(String sTier) throws Exception {
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        waitTime(2000);
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
        }
    }

    public void enterMLBranchDetails() throws Exception {
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
        if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            type(MLWalletSendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            type(MLWalletSendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
            click(MLWalletSendTransferPage.objCheckBox, "Check Box");
            waitTime(3000);
            type(MLWalletSendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
            type(MLWalletSendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
            Swipe("UP",1);
            waitTime(3000);
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            waitTime(5000);
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
        }
    }

    public void enterAmountToKwartaPadala(String nAmount) throws Exception {
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
        verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
        type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        Swipe("UP", 1);
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletSendTransferPage.objSelectPaymentMethod, getTextVal(MLWalletSendTransferPage.objSelectPaymentMethod, "Page"));
        waitTime(2000);
        click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
        waitTime(6000);
        verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"));
        click(MLWalletSendTransferPage.objConfirmBtn, getTextVal(MLWalletSendTransferPage.objConfirmBtn, "Button"));
        waitTime(2000);
    }

    public void selectSavedRecipient() throws Exception {
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"))) {
            click(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objSavedRecipients, 10);
            click(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Page"));
            waitTime(2000);
            type(MLWalletSendTransferPage.objSearchRecipient, prop.getproperty("Last_Name"), "Search Recipient Text Field");
            verifyElementPresent(MLWalletSendTransferPage.objSelectLastName, getTextVal(MLWalletSendTransferPage.objSelectLastName, "Recipient"));
            click(MLWalletSendTransferPage.objSelectLastName, getTextVal(MLWalletSendTransferPage.objSelectLastName, "Recipient"));
            click(MLWalletSendTransferPage.objSelectLastName, getTextVal(MLWalletSendTransferPage.objSelectLastName, "Recipient"));
            waitTime(3000);
        }
    }

    public void addRecipient() throws Exception {
        if (verifyElementPresent(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"))) {
            waitTime(2000);
            click(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"));
            waitTime(2000);
            click(MLWalletSendTransferPage.objAddRecipient, getTextVal(MLWalletSendTransferPage.objAddRecipient, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objAddRecipient, 20);
            type(MLWalletSendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            type(MLWalletSendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
            click(MLWalletSendTransferPage.objCheckBox, "Check Box");
            type(MLWalletSendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
            type(MLWalletSendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Last Name Text Field");
            type(MLWalletSendTransferPage.objNickName, prop.getproperty("Nick_Name"), "Nick Name Text Field");
            click(MLWalletSendTransferPage.ObjSaveRecipient, getTextVal(MLWalletSendTransferPage.ObjSaveRecipient, "Button"));
            click(MLWalletSendTransferPage.ObjSaveRecipient, getTextVal(MLWalletSendTransferPage.ObjSaveRecipient, "Button"));
        }
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
        handleMpin("1111","MPin");
    }
    public void sendMoneyToMLBranchRatesValidation(String sAmount) throws Exception {
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
        type(MLWalletSendTransferPage.objAmountTxtField, sAmount, "Amount text Field");
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        waitTime(2000);
        verifyElementPresent(MLWalletSendTransferPage.objSelectPaymentMethod, getTextVal(MLWalletSendTransferPage.objSelectPaymentMethod, "Page"));
        waitTime(2000);
        click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"));
    }


    //===============================================================================================================//
    public void sendMoneyToMLBranch_STB_TC_01() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch();
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(7000);
        if(verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objPHPAmount, getTextVal(MLWalletSendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objDate, getTextVal(MLWalletSendTransferPage.objDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
            String sReference = getText(MLWalletSendTransferPage.objReferenceNumber);
            System.out.println(sReference);
            String sReferenceNumber = sReference.substring(9, 20);
            System.out.println(sReferenceNumber);
            scroll_To_Text(MLWalletSendTransferPage.objBackToHomeBtn, "name", "Back To Home");
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(5000);
            Swipe("DOWN",2);
            waitTime(5000);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
            waitTime(5000);
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("STB_TC_01, Successfully sent Amount to ML Branch and Transaction Details is validated");
                extentLoggerPass("STB_TC_01", "STB_TC_01, Successfully sent Amount to ML Branch and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyToSavedRecipient_STB_TC_02() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            selectSavedRecipient();
            waitTime(3000);;
            click(MLWalletSendTransferPage.objSelectRecipient, getTextVal(MLWalletSendTransferPage.objSelectRecipient, "Button"));
            Swipe("UP", 1);
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            waitTime(5000);
            enterAmountToKwartaPadala("100");
            enterOTP(prop.getproperty("Valid_OTP"));
            waitTime(4000);
            if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
                verifyElementPresent(MLWalletSendTransferPage.objPHPAmount, getTextVal(MLWalletSendTransferPage.objPHPAmount, "Amount"));
                verifyElementPresent(MLWalletSendTransferPage.objDate, getTextVal(MLWalletSendTransferPage.objDate, "Date"));
                verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
                String sReference = getText(MLWalletSendTransferPage.objReferenceNumber);
                System.out.println(sReference);
                String sReferenceNumber = sReference.substring(9, 20);
                Swipe("UP", 2);
                click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
                waitTime(5000);
                Swipe("DOWN",2);
                verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
                click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
                waitTime(2000);
                if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                    String sReferenceNumberInCashOut = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                    System.out.println(sReferenceNumberInCashOut);
                    assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                    logger.info("STB_TC_02, Successfully sent Amount to saved Recipient and Transaction Details is validated");
                    extentLoggerPass("STB_TC_02", "STB_TC_02, Successfully sent Amount to saved Recipient and Transaction Details is validated");
                    System.out.println("-----------------------------------------------------------");
                }
            }
        }
    }

    public void sendMoneyAddRecipient_STB_TC_03() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            addRecipient();
            type(MLWalletSendTransferPage.objSearchRecipient, prop.getproperty("Last_Name"), "Search Recipient Text Field");
            if (verifyElementPresent(MLWalletSendTransferPage.objSelectLastName,  getTextVal(MLWalletSendTransferPage.objSelectLastName, "Recipient"))) {
                logger.info("STB_TC_03, The Added Recipient is displayed in Saved Recipient Page");
                extentLoggerPass("STB_TC_03", "STB_TC_03, The Added Recipient is displayed in Saved Recipient Page");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }



    public void sendMoneyContactDuplicate_STB_TC_04() throws Exception {
        HeaderChildNode("Send Money Contact Duplicate");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        explicitWaitVisibility(MLWalletSendTransferPage.objToAnyMLBranch, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            addRecipient();
            waitTime(2000);
            if (verifyElementPresent(MLWalletSendTransferPage.objContactAlreadyExistMsg, getTextVal(MLWalletSendTransferPage.objContactAlreadyExistMsg, "Error Message"))) {
                String sContactDuplicatePopupMsg = getText(MLWalletSendTransferPage.objContactAlreadyExistMsg);
                String sExpectedPopupMsg = "Contact already exists.";
                assertionValidation(sContactDuplicatePopupMsg, sExpectedPopupMsg);
                logger.info("STB_TC_04, Contact already exists popup message Validated");
                extentLoggerPass("STB_TC_04", "STB_TC_04, Contact already exists popup message Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }



    public void sendMoneyDeleteRecipient_STB_TC_05() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        verifyElementNotPresent(MLWalletLoginPage.objLoginBtn,"Login b utton",5);

        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            selectSavedRecipient();
            click(MLWalletSendTransferPage.objDeleteRecipient, getTextVal(MLWalletSendTransferPage.objDeleteRecipient, "Button"));
            waitTime(10000);
            verifyElementPresent(MLWalletSendTransferPage.objPopupMsg, getTextVal(MLWalletSendTransferPage.objPopupMsg, "Pop Up message"));
            String sDeleteConfirmationPopup = getText(MLWalletSendTransferPage.objPopupMsg);
            String sExceptedMsg = "Are you sure you want to remove this saved recipient?";
            assertionValidation(sDeleteConfirmationPopup, sExceptedMsg);
            click(MLWalletSendTransferPage.objRemoveBtn, getTextVal(MLWalletSendTransferPage.objRemoveBtn, "Button"));
            waitTime(10000);
            verifyElementNotPresent(MLWalletSendTransferPage.objSelectLastName, "Saved Recipient",3);
            logger.info("STB_TC_05, Saved Recipient from Saved Recipients page deleted Successfully");
            extentLoggerPass("STB_TC_05", "STB_TC_05, Saved Recipient from Saved Recipients page deleted Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyEditRecipient_STB_TC_06() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            selectSavedRecipient();
            click(MLWalletSendTransferPage.objEditRecipient, getTextVal(MLWalletSendTransferPage.objEditRecipient, "Button"));
            clearTextField(MLWalletSendTransferPage.objEditRecipientLastName,"Search Recipient");
            type(MLWalletSendTransferPage.objEditRecipientLastName, prop.getproperty("Edited_Last_name"), "Last Name Text Field");
            click(MLWalletSendTransferPage.ObjSaveRecipient, getTextVal(MLWalletSendTransferPage.ObjSaveRecipient, "Button"));
            click(MLWalletSendTransferPage.ObjSaveRecipient, getTextVal(MLWalletSendTransferPage.ObjSaveRecipient, "Button"));
            waitTime(2000);
            clearField(MLWalletSendTransferPage.objSearchRecipient,"Search field");
            type(MLWalletSendTransferPage.objSearchRecipient, prop.getproperty("Edited_Last_name"), "Search Recipient Text Field");
            if (verifyElementPresent(MLWalletSendTransferPage.objSelectLastName, getTextVal(MLWalletSendTransferPage.objSelectLastName, "Recipient"))) {
                logger.info("STB_TC_06, Successfully edited the Saved Recipient");
                extentLoggerPass("STB_TC_06", "STB_TC_06, Successfully edited the Saved Recipient");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }



    public void sendMoneyInvalidDetails_STB_TC_07() throws Exception {
        HeaderChildNode("Send Money Invalid Bank Details");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            type(MLWalletSendTransferPage.objFirstname, prop.getproperty("Invalid_First_Name"), "First Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objFirstNameErrorMsg, getTextVal(MLWalletSendTransferPage.objFirstNameErrorMsg, "Error Message"))) {
                String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objFirstNameErrorMsg);
                String sExpectedMsg = "First name must only contain letters and spaces";
                assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            }


            click(MLWalletSendTransferPage.objFirstname1, "First Name Text Field");
            clearField(MLWalletSendTransferPage.objFirstname1, "First Name Text Field");
            type(MLWalletSendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");


            type(MLWalletSendTransferPage.objMiddleName, prop.getproperty("Invalid_Middle_Name"), "Middle Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objMiddleNameErrorMsg, getTextVal(MLWalletSendTransferPage.objMiddleNameErrorMsg, "Error Message"))) {
                String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objMiddleNameErrorMsg);
                String sExpectedMsg = "Middle name must only contain letters and spaces";
                assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            }
            click(MLWalletSendTransferPage.objCheckBox, "Check Box");
            Swipe("UP", 1);

            type(MLWalletSendTransferPage.objLastName, prop.getproperty("Invalid_Last_Name"), "Last Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objLastNameErrorMsg, getTextVal(MLWalletSendTransferPage.objLastNameErrorMsg, "Error Message"))) {
                String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objLastNameErrorMsg);
                String sExpectedMsg = "Last name must only contain letters and spaces";
                assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            }


            click(MLWalletSendTransferPage.objLastName1, "Last Name Text Field");
            clearField(MLWalletSendTransferPage.objLastName1, "Last Name Text Field");
            type(MLWalletSendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");


            type(MLWalletSendTransferPage.objMobileNumber, prop.getproperty("Invalid_MobileNumber"), "Mobile Number Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objMobileNumberErrorMsg, getTextVal(MLWalletSendTransferPage.objMobileNumberErrorMsg, "Error Message"))) {
                String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objMobileNumberErrorMsg);
                String sExpectedMsg = "Mobile number is invalid";
                assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            }

            click(MLWalletSendTransferPage.objMobileNumber1, "Last Name Text Field");
            clearField(MLWalletSendTransferPage.objMobileNumber1, "Mobile Number Text Field");
            type(MLWalletSendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));

            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
            if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "page"))) {
                logger.info("STB_TC_07, Prompt msg for Receiver's Details Invalid is validated");
                extentLoggerPass("STB_TC_07", "STB_TC_07, Prompt msg for Receiver's Details Invalid is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }





    public void sendMoneyRequiredDetails_STB_TC_08() throws Exception {
        HeaderChildNode("Send Money Invalid Bank Details");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objFirstNameRequiredMsg, 10);
            if (verifyElementPresent(MLWalletSendTransferPage.objFirstNameRequiredMsg, getTextVal(MLWalletSendTransferPage.objFirstNameRequiredMsg, "Error Message"))) {
                String sFirstNameErrorMsg = getText(MLWalletSendTransferPage.objFirstNameRequiredMsg);
                String sExpectedMsg = "First name is required";
                assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            }
            hideKeyboard();
            type(MLWalletSendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            //type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objMiddleNameRequiredMsg, getTextVal(MLWalletSendTransferPage.objMiddleNameRequiredMsg, "Error Message"))) {
                String sMiddleNameRequiredMsg = getText(MLWalletSendTransferPage.objMiddleNameRequiredMsg);
                String sExpectedMsg = "Middle name is required";
                assertionValidation(sMiddleNameRequiredMsg, sExpectedMsg);
            }
            waitTime(3000);
            type(MLWalletSendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objLastNameRequiredMsg, getTextVal(MLWalletSendTransferPage.objLastNameRequiredMsg, "Error Message"))) {
                String sLastNameRequiredMsg = getText(MLWalletSendTransferPage.objLastNameRequiredMsg);
                String sExpectedMsg = "Last name is required";
                assertionValidation(sLastNameRequiredMsg, sExpectedMsg);
            }
            waitTime(3000);
            type(MLWalletSendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            if (verifyElementPresent(MLWalletSendTransferPage.objMobileNumberRequiredMsg, getTextVal(MLWalletSendTransferPage.objMobileNumberRequiredMsg, "Error Message"))) {
                String sMobileNumberRequiredMsg = getText(MLWalletSendTransferPage.objMobileNumberRequiredMsg);
                String sExpectedMsg = "Mobile number is required";
                assertionValidation(sMobileNumberRequiredMsg, sExpectedMsg);
            }
            type(MLWalletSendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Last Name Text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
            if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "page"))) {
                logger.info("STB_TC_08, Prompt msg for Receiver's Details required is validated");
                extentLoggerPass("STB_TC_08", "STB_TC_08, Prompt msg for Receiver's Details required is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyInvalidAmount_STB_TC_09(String Amount) throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            enterMLBranchDetails();
            explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
            type(MLWalletSendTransferPage.objAmountTxtField, Amount, "Amount text Field");
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            explicitWaitVisibility(MLWalletSendTransferPage.objInvalidAmountMsg, 10);
            if (verifyElementPresent(MLWalletSendTransferPage.objInvalidAmountMsg, getTextVal(MLWalletSendTransferPage.objInvalidAmountMsg, "Error Message"))) {
                String sInvalidAmountErrorMsg = getText(MLWalletSendTransferPage.objInvalidAmountMsg);
                String sExpectedErrorMsg = "The amount should not be less than 1";
                assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
                logger.info("STB_TC_09, The amount should not be less than 1 - Error Message is validated");
                extentLoggerPass("STB_TC_09", "STB_TC_09, The amount should not be less than 1 - Error Message is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyInsufficientAmount_STB_TC_10() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin("9999999998");
        click(MLWalletSendTransferPage.objSendTransferBtn,
                getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney,
                getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch,
                getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch,
                    getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            enterMLBranchDetails();
            enterAmountToKwartaPadala("35000");
            waitTime(4000);
            if (verifyElementPresent(MLWalletSendTransferPage.objInsufficientAmountMsg,
                    getTextVal(MLWalletSendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
                String sInsufficientBalanceErrorMsg = getText(MLWalletSendTransferPage.objInsufficientAmountMsg);
                String sExpectedErrorMsg = "There is insufficient balance on your account to proceed with this transaction. Please try again.";
                assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
                logger.info("STB_TC_10, Insufficient Balance - Error Message is validated");
                extentLoggerPass("STB_TC_10",
                        "STB_TC_10, Insufficient Balance - Error Message is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyMaximumAmount_STB_TC_12() throws Exception {
        HeaderChildNode("Send Money to any ML Branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            enterMLBranchDetails();
            enterAmountToKwartaPadala("100000");
            waitTime(2000);
            if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitErrorMsg, getTextVal(MLWalletSendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
                String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitErrorMsg);
                String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
                assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
                logger.info("STB_TC_12, The maximum send money per transaction - Error Message is validated");
                extentLoggerPass("STB_TC_12", "STB_TC_12, The maximum send money per transaction - Error Message is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    //================================= Phase 2 ==================================================================//


    public void sendTransferUIValidation_STB_TC_13() throws Exception {
        HeaderChildNode("Send/Transfer page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 20);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSendWalletOptions, getTextVal(MLWalletSendTransferPage.objSendWalletOptions, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "option"));
            verifyElementPresent(MLWalletSendTransferPage.objToAMLWalletUser, getTextVal(MLWalletSendTransferPage.objToAMLWalletUser, "option"));
            logger.info("STB_TC_13, Send/Transfer page UI Validated");
            extentLoggerPass("STB_TC_13", "STB_TC_13, Send/Transfer page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchUIValidation_STB_TC_14() throws Exception {
        HeaderChildNode("Send Money to ML Branch page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objToAnyMLBranch, 10);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Option"));
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"));
            verifyElementPresent(MLWalletSendTransferPage.objFirstname, "First Name Input Field");
            verifyElementPresent(MLWalletSendTransferPage.objMiddleName, "Middle Name Input Field");
            verifyElementPresent(MLWalletSendTransferPage.objCheckBox, "Check box to Receiver legally does not have middle Name");
            verifyElementPresent(MLWalletSendTransferPage.objLastName, "Last Name Input Field");
            verifyElementPresent(MLWalletSendTransferPage.objMobileNumber, "Mobile Number Input Field");
            verifyElementPresent(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            logger.info("STB_TC_14, Send Money to ML Branch page UI Validation");
            extentLoggerPass("STB_TC_14", "STB_TC_14, Send Money to ML Branch page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15() throws Exception {
        HeaderChildNode("Send Money To Branch Save Recipient Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objToAnyMLBranch, 10);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Option"));
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 10);
        verifyElementPresentAndClick(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"));
        if (verifyElementPresent(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objAddRecipient, getTextVal(MLWalletSendTransferPage.objAddRecipient, "Button"));
            verifyElementPresent(MLWalletSendTransferPage.objSelectRecipient, getTextVal(MLWalletSendTransferPage.objSelectRecipient, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objSearchRecipient, "Search Recipient Input Field");
            waitTime(2000);
            if (verifyElementDisplayed(MLWalletSendTransferPage.objSavedRecipientsList,"Saved Recipient list")) {
                List<WebElement> values = findElements(MLWalletSendTransferPage.objSavedRecipientsList);
                for (int i = 0; i < values.size(); i++) {
                    String savedRecipientName = values.get(i).getText();
                    logger.info("Saved Recipient : " + savedRecipientName + " is displayed");
                    extentLogger(" ", "Saved Recipient : " + savedRecipientName + " is displayed");
                }
            } else if (verifyElementPresent(MLWalletSendTransferPage.objNoRecentTransactionTxt, getTextVal(MLWalletSendTransferPage.objNoRecentTransactionTxt, "Text"))) {
                logger.info("No Saved Recipients are present");
            }
            logger.info("STB_TC_15, Send Money To Branch Save Recipient Page UI Validated");
            extentLoggerPass("STB_TC_15", "STB_TC_15, Send Money To Branch Save Recipient Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToBranchSuccessUIValidation_STB_TC_16() throws Exception {
        HeaderChildNode("Send Money To Branch Success UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletSendTransferPage.objSendTransferBtn, getTextVal(MLWalletSendTransferPage.objSendTransferBtn, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSendMoney, 10);
        verifyElementPresent(MLWalletSendTransferPage.objSendMoney, getTextVal(MLWalletSendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletSendTransferPage.objToAnyMLBranch, getTextVal(MLWalletSendTransferPage.objToAnyMLBranch, "Button"));
            enterMLBranchDetails();
            enterAmountToKwartaPadala("100");
            enterOTP(prop.getproperty("Valid_OTP"));
            explicitWaitVisibility(MLWalletSendTransferPage.objSendMoneySuccessful, 10);
            if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
                verifyElementPresent(MLWalletSendTransferPage.objPHPAmount, getTextVal(MLWalletSendTransferPage.objPHPAmount, "Amount"));
                verifyElementPresent(MLWalletSendTransferPage.objDate, getTextVal(MLWalletSendTransferPage.objDate, "Date"));
                verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
                verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"));
                verifyElementPresent(MLWalletSendTransferPage.objReceiverName, getTextVal(MLWalletSendTransferPage.objReceiverName, "Receiver's Name"));
                verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
                verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
                verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
                Swipe("UP", 1);
                verifyElementPresent(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
                verifyElementPresent(MLWalletSendTransferPage.objNewTransaction, getTextVal(MLWalletSendTransferPage.objNewTransaction, "Button"));
                click(MLWalletSendTransferPage.objBackToHomeBtn, "Back To Home Button");
                logger.info("STB_TC_16, Send Money To Branch Success page UI Validated");
                extentLoggerPass("STB_TC_16", "STB_TC_16, Send Money To Branch Success page UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17(String nAmount) throws Exception {
        HeaderChildNode("Send Money To Branch Confirm Details Page UI Validation");
        sendMoneyToAnyMLBranch();
        enterMLBranchDetails();
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
        verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
        type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        click(MLWalletSendTransferPage.objNextBtn, getTextVal(MLWalletSendTransferPage.objNextBtn, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletSendTransferPage.objSelectPaymentMethod, getTextVal(MLWalletSendTransferPage.objSelectPaymentMethod, "Page"));
        waitTime(3000);
        click(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails, getTextVal(MLWalletSendTransferPage.objConfirmDetails, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverName, getTextVal(MLWalletSendTransferPage.objReceiverName, "Receiver's Name"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objConfirmBtn, getTextVal(MLWalletSendTransferPage.objConfirmBtn, "Button"));
            logger.info("STB_TC_17, Send Money To Branch Confirm Details Page UI Validated");
            extentLoggerPass("STB_TC_17", "STB_TC_17, Send Money To Branch Confirm Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18(String nAmount) throws Exception {
        HeaderChildNode("Send Money To Branch Select Payment Method Page UI Validation");
        sendMoneyToAnyMLBranch();
        enterMLBranchDetails();
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
        verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"));
        type(MLWalletSendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
        click(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
        explicitWaitVisibility(MLWalletSendTransferPage.objSelectPaymentMethod, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objSelectPaymentMethod, getTextVal(MLWalletSendTransferPage.objSelectPaymentMethod, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objMLWalletBalance, getTextVal(MLWalletSendTransferPage.objMLWalletBalance, "Button"));
            logger.info("STB_TC_18, Send Money To Branch Select Payment Method Page UI Validated");
            extentLoggerPass("STB_TC_18", "STB_TC_18, Send Money To Branch Select Payment Method Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19() throws Exception {
        HeaderChildNode("Send Money To Branch Enter Amount Page UI Validation");
        sendMoneyToAnyMLBranch();
        enterMLBranchDetails();
        explicitWaitVisible(MLWalletSendTransferPage.objKwartaPadala, 5);
        if (verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(MLWalletSendTransferPage.objAmountToSend, getTextVal(MLWalletSendTransferPage.objAmountToSend, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objAmountTxtField, "Amount Input Field");
            verifyElementPresent(MLWalletSendTransferPage.objNextBtn2, getTextVal(MLWalletSendTransferPage.objNextBtn2, "Button"));
            logger.info("STB_TC_19, Send Money To Branch Enter Amount Page UI Validated");
            extentLoggerPass("STB_TC_19", "STB_TC_19, Send Money To Branch Enter Amount Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void kwartaPadalaTransactionDetailsUIValidation_STB_TC_20() throws Exception {
        HeaderChildNode("Kwarta Padala Transaction Details UI Validation");
        sendMoneyToMLBranch_STB_TC_01();
        explicitWaitVisibility(MLWalletSendTransferPage.objTransactionDetails, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"))) {
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadala, getTextVal(MLWalletSendTransferPage.objKwartaPadala, "Text"));
            verifyElementPresent(MLWalletSendTransferPage.objKwartaPadalaDate, getTextVal(MLWalletSendTransferPage.objKwartaPadalaDate, "Kwarta Padala Date"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverName, getTextVal(MLWalletSendTransferPage.objReceiverName, "Receiver's Name"));
            verifyElementPresent(MLWalletSendTransferPage.objReceiverMobileNo, getTextVal(MLWalletSendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletSendTransferPage.objPaymentMethod, getTextVal(MLWalletSendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletSendTransferPage.objAmount, getTextVal(MLWalletSendTransferPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletSendTransferPage.objTotalAmount, getTextVal(MLWalletSendTransferPage.objTotalAmount, "Total Amount"));
            logger.info("STB_TC_20, Kwarta Padala Transaction Details page UI Validated");
            extentLoggerPass("STB_TC_20", "STB_TC_20, Kwarta Padala Transaction Details page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21() throws Exception {
        HeaderChildNode("Send Money To Branch Add Recipient Page UI Validation");
        sendMoneyToAnyMLBranch();
        explicitWaitVisibility(MLWalletSendTransferPage.objSavedRecipients, 10);
        if (verifyElementPresent(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"))) {
            explicitWaitVisibility(MLWalletSendTransferPage.objSavedRecipients, 10);
            click(MLWalletSendTransferPage.objSavedRecipients, getTextVal(MLWalletSendTransferPage.objSavedRecipients, "Button"));
            waitTime(3000);
            click(MLWalletSendTransferPage.objAddRecipient, getTextVal(MLWalletSendTransferPage.objAddRecipient, "Button"));
            explicitWaitVisible(MLWalletSendTransferPage.objAddRecipient, 10);
            if (verifyElementPresent(MLWalletSendTransferPage.objAddRecipient, getTextVal(MLWalletSendTransferPage.objAddRecipient, "Page"))) {
                verifyElementPresent(MLWalletSendTransferPage.objFirstname, "First Name Text Field");
                verifyElementPresent(MLWalletSendTransferPage.objMiddleName, "Middle Name Text Field");
                verifyElementPresent(MLWalletSendTransferPage.objCheckBox, "Check Box");
                verifyElementPresent(MLWalletSendTransferPage.objLastName, "Last Name Text Field");
                verifyElementPresent(MLWalletSendTransferPage.objMobileNumber, "Last Name Text Field");
                verifyElementPresent(MLWalletSendTransferPage.objNickName, "Nick Name Text Field");
                verifyElementPresent(MLWalletSendTransferPage.ObjSaveRecipient, getTextVal(MLWalletSendTransferPage.ObjSaveRecipient, "Button"));
                logger.info("STB_TC_21, Send Money To Branch Add Recipient Page UI Validated");
                extentLoggerPass("STB_TC_21", "STB_TC_21, Send Money To Branch Add Recipient Page UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyToMLBranchBuyerTierAccount_STB_TC_22() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Buyer Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("New_BuyerTier"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objErrorMsg, getTextVal(MLWalletSendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "Send Money is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("STB_TC_22, Send Money is not allowed for customers at this Buyer tier - Error Message is validated");
            extentLoggerPass("STB_TC_22", "STB_TC_22, Send Money is not allowed for customers at this Buyer tier  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Semi verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Semi_Verified_One"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_23, Send Money To ML Branch, Semi verified Tier Account transaction validated");
            extentLoggerPass("STB_TC_23", "STB_TC_23, Send Money To ML Branch, Semi verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_24, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            extentLoggerPass("STB_TC_24", "STB_TC_24, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Fully_verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objTransactionDetails, getTextVal(MLWalletSendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_25, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            extentLoggerPass("STB_TC_25", "STB_TC_25, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Semi verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Semi_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("20000");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSemiMaxLimit, getTextVal(MLWalletSendTransferPage.objSemiMaxLimit, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objSemiMaxLimit);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P10,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("STB_TC_26, Send Money To ML Branch, Semi verified Tier Account Maximum Transaction - Error Message is validated");
            extentLoggerPass("STB_TC_26", "STB_TC_26, Send Money To ML Branch, Semi verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("60000");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitErrorMsg, getTextVal(MLWalletSendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
            logger.info("STB_TC_29, Send Money To ML Branch, Branch verified Tier Account Maximum Transaction - Error Message is validated");
            extentLoggerPass("STB_TC_29", "STB_TC_29, Send Money To ML Branch, Branch verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32() throws Exception {
        HeaderChildNode("Send Money To ML Branch, Fully verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Fully_verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("60000");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objMaxLimitErrorMsg, getTextVal(MLWalletSendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletSendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletSendTransferPage.objOkBtn, getTextVal(MLWalletSendTransferPage.objOkBtn, "Button"));
            logger.info("STB_TC_32, Send Money To ML Branch, Fully verified Tier Account Maximum Transaction - Error Message is validated");
            extentLoggerPass("STB_TC_32", "STB_TC_32, Send Money To ML Branch, Fully verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void kwartaPadalaRates_STB_TC_35() throws Exception {
        HeaderChildNode("Kwarta Padala Rates");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objKwartaPadalaRatesBtn, "Kwarta Padala Rates");
        waitTime(3000);
        if (verifyElementPresent(MLWalletHomePage.objKwartaPadalaRates, "Kwarta Padala Rates")) {
            List<WebElement> values = findElements(MLWalletHomePage.objKwartaPadalaRates);
            for (int i = 0; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String sRates = values.get(i).getText();
                    logger.info("Rates : " + sRates + " is displayed");
                    extentLogger(" ", "Rates : " + sRates + " is displayed");
                }
                if (i % 2 == 0) {
                    String sAmountRange = values.get(i).getText();
                    logger.info("Amount Range : " + sAmountRange + " is displayed");
                    extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
                }
            }
            logger.info("STB_TC_35, Kwarta Padala Rates validated");
            extentLoggerPass("STB_TC_35", "STB_TC_35, Kwarta Padala Rates validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP0.50 for PHP0.01 to PHP50.00");
        waitTime(2000);
        changeNumberPage();
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 0.50";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_36, Send Money To ML Branch charged PHP0.50 for 0.01 to PHP50.00 validated");
            extentLoggerPass("STB_TC_36", "STB_TC_36, Send Money To ML Branch charged PHP0.50 for PHP0.01 to PHP50.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 1.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_36, Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00 validated");
            extentLoggerPass("STB_TC_36", "STB_TC_36, Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 2.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_38, Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00 validated");
            extentLoggerPass("STB_TC_38", "STB_TC_38, Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 3.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_39, Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00 validated");
            extentLoggerPass("STB_TC_39", "STB_TC_39, Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 5.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_40, Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00 validated");
            extentLoggerPass("STB_TC_40", "STB_TC_40, Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP8.00 for PHP500.01 to PHP600.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 8.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_41, Send Money To ML Branch charged PHP5.00 for PHP8.00 to PHP600.00 validated");
            extentLoggerPass("STB_TC_41", "STB_TC_41, Send Money To ML Branch charged PHP8.00 for PHP500.01 to PHP600.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 10.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_42, Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00 validated");
            extentLoggerPass("STB_TC_42", "STB_TC_42, Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 12.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_43, Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00 validated");
            extentLoggerPass("STB_TC_43", "STB_TC_43 , Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 15.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_44, Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00 validated");
            extentLoggerPass("STB_TC_44", "STB_TC_44 , Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 20.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_45, Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00 validated");
            extentLoggerPass("STB_TC_45", "STB_TC_45 , Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 30.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_46, Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00 validated");
            extentLoggerPass("STB_TC_46", "STB_TC_46 , Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 40.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_47, Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00 validated");
            extentLoggerPass("STB_TC_47", "STB_TC_47 , Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48(String sAmount) throws Exception {
        HeaderChildNode("Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(MLWalletSendTransferPage.objServiceFee, getTextVal(MLWalletSendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(MLWalletSendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 500.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_48, Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00 validated");
            extentLoggerPass("STB_TC_48", "STB_TC_48 , Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_59() throws Exception {
        HeaderChildNode("Send Money To ML Branch Transaction Validation After Minimizing App");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        waitTime(5000);
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            logger.info("STB_TC_58, Send Money To ML Branch Transaction Validation After Minimizing App Validated");
            extentLoggerPass("STB_TC_58", "STB_TC_58, Send Money To ML Branch Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_65() throws Exception {
        HeaderChildNode("Send Money to any ML Branch Transaction With Valid ML Pin");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));//ios_BranchVerifiedTier 9999999999
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        handleMpin("1111", "Entered Mpin");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(MLWalletSendTransferPage.objPHPAmount, getTextVal(MLWalletSendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(MLWalletSendTransferPage.objDate, getTextVal(MLWalletSendTransferPage.objDate, "Date"));
            verifyElementPresent(MLWalletSendTransferPage.objReferenceNumber, getTextVal(MLWalletSendTransferPage.objReferenceNumber, "Reference Number"));
            String sReference = getText(MLWalletSendTransferPage.objReferenceNumber);
            System.out.println(sReference);
            String sReferenceNumber = sReference.substring(9, 20);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(MLWalletSendTransferPage.objBackToHomeBtn, getTextVal(MLWalletSendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
            if (verifyElementPresent(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletSendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("STB_TC_64, Send Money to any ML Branch Transaction With Valid ML Pin validated");
                extentLoggerPass("STB_TC_64", "STB_TC_64, Send Money to any ML Branch Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_66() throws Exception {
        HeaderChildNode("Send Money to any ML Branch Transaction With Invalid ML Pin");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));//ios_BranchVerifiedTier 9999999999
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(3000);
        handleMpin("1111", "Entered Mpin");
        waitTime(3000);
        if (verifyElementPresent(MLWalletSendTransferPage.objInvalidPINMsg, getTextVal(MLWalletSendTransferPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletSendTransferPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("STB_TC_65, Send Money to any ML Branch Transaction With Invalid ML Pin validated");
            extentLoggerPass("STB_TC_65", "STB_TC_65, Send Money to any ML Branch Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchInOTPPopupValidation_STB_TC_72() throws Exception {
        HeaderChildNode("Send Money To ML Branch InApp OTP popup Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "popup"))) {
            logger.info("STB_TC_71, Send Money To ML Branch, InApp OTP popup validated");
            extentLoggerPass("STB_TC_71", "STB_TC_71, Send Money To ML Branch, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_73() throws Exception {
        HeaderChildNode("Send Money To ML Branch Transaction InApp OTP popup UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "popup"))) {
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("STB_TC_72, Send Money To ML Branch Transaction InApp OTP popup UI validated");
            extentLoggerPass("STB_TC_72", "STB_TC_72, Send Money To ML Branch Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_74() throws Exception {
        HeaderChildNode("Send Money To ML Branch New OTP got generated After Sixty Seconds validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Popup"));
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup,getTextVal(MLWalletLoginPage.objOneTimePinPopup,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            for(int i=1;i<=80;i++){
                click1(MLWalletLoginPage.objOneTimePinPopup,"One time pin popup");
            }
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("STB_TC_73, Send Money To ML Branch Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("STB_TC_73", "STB_TC_73, Send Money To ML Branch Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_75() throws Exception {
        HeaderChildNode("Send Money To ML Branch Transaction OTP Cancel Button Functionality");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        if(verifyElementPresent(MLWalletSendTransferPage.objConfirmDetails,getTextVal(MLWalletSendTransferPage.objConfirmDetails,"Page"))){
            logger.info("STB_TC_74, Send Money To ML Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            extentLoggerPass("STB_TC_74", "STB_TC_74, Send Money To ML Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchTransactionOTPContinueBtnFunctionality_STB_TC_76() throws Exception {
        HeaderChildNode("Send Money To ML Branch Transaction OTP Continue Button Functionality");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePinPopup, getTextVal(MLWalletLoginPage.objOneTimePinPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletSendTransferPage.objSendMoneySuccessful, getTextVal(MLWalletSendTransferPage.objSendMoneySuccessful, "Message"))) {
            logger.info("STB_TC_75, Send Money To ML Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("STB_TC_75", "STB_TC_75, Send Money To ML Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
