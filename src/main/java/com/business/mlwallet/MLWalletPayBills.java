package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import com.iosmlwalletpages.MLWalletHomePage;
import com.iosmlwalletpages.MLWalletPayBillsPage;
import com.iosmlwalletpages.MLWalletSendTransferPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletSendTransferToMLWalletUser.verifyRecentTransaction3;
import static com.utility.Utilities.*;


public class MLWalletPayBills extends BaseClass{
    public MLWalletPayBills(){
        super();
    }

    //=============================Generalized Methods=====================================================//

    public void getBillers(By sWebElement){
        List<WebElement> list = findElements(sWebElement);

        for(int i=0 ;i<list.size(); i++){
            if(i%2==1)
            {
                String billers= list.get(i).getText();
                logger.info(billers+ " Biller is displayed");
            }
        }
    }

    public void payBillsNavigation() throws Exception {
        verifyElementPresent(MLWalletPayBillsPage.objPayBills,getTextVal(MLWalletPayBillsPage.objPayBills,"Icon"));
        click(MLWalletPayBillsPage.objPayBills,getTextVal(MLWalletPayBillsPage.objPayBills,"Icon"));
        waitTime(2000);
    }


    public void searchBiller() throws Exception {
        click(MLWalletPayBillsPage.objSearchBiller, "Search Biller");
        type(MLWalletPayBillsPage.objSearchBiller,prop.getproperty("Biller_Name"),"Search Biller");
        verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"));
        click(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"));
        click(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"));
        waitTime(2000);
    }

    public void billerDetails(String sFirstName,String sLastName,String sMiddleName, String sAmount) throws Exception {
        explicitWaitVisibility(MLWalletPayBillsPage.objBillsPayInformation, 10);
        if(verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"))){
            type(MLWalletPayBillsPage.objAccountNumberField, prop.getproperty("AccountNumber"),"Account Number Text Field");
            type(MLWalletPayBillsPage.objFirstNameField,sFirstName ,"First Name Text Field");
            type(MLWalletPayBillsPage.objMiddleNameField,sMiddleName ,"Middle Name Text Field");
            type(MLWalletPayBillsPage.objLastnameField,sLastName ,"Last Name Text Field");
            Swipe("UP",1);
            type(MLWalletPayBillsPage.objAmountField, sAmount,"Amount to Send Text Field");
            click(MLWalletPayBillsPage.objConfirmBtn,getTextVal(MLWalletPayBillsPage.objConfirmBtn,"Button"));
            waitTime(8000);
        }
    }

    public void addSelectedBiller() throws Exception {
        if (verifyElementPresent(MLWalletPayBillsPage.objAddSeectedBiller, "Edit Biller")) {
            click(MLWalletPayBillsPage.objAddSeectedBiller, "Edit Biller");
            click(MLWalletPayBillsPage.objBillerListSearchBiller,"Biller List Search Biller");
            type(MLWalletPayBillsPage.objBillerListSearchBiller, prop.getproperty("Biller_Name"), "Biller List Search Biller");
            explicitWaitVisible(MLWalletPayBillsPage.objMisBillsPayBiller,10);
            click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
            click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
        }
    }

    public void addBiller() throws Exception {
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"))) {
            explicitWaitVisibility(MLWalletPayBillsPage.objSavedBiller, 10);
            click(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
            explicitWaitVisible(MLWalletPayBillsPage.objAddBiller,10);
            click(MLWalletPayBillsPage.objAddBiller, getTextVal(MLWalletPayBillsPage.objAddBiller, "Button"));
            addSelectedBiller();
            waitTime(2000);
            if (verifyElementPresent(MLWalletPayBillsPage.objAddBillers, getTextVal(MLWalletPayBillsPage.objAddBillers, "Page"))) {
                type(MLWalletPayBillsPage.objAddAccountNumber, prop.getproperty("AccountNumber"), "Account Number in Add Biller");
                type(MLWalletPayBillsPage.objAddFirstName, prop.getproperty("First_Name"), "First Name in Add Biller");
                type(MLWalletPayBillsPage.objAddMiddleName, prop.getproperty("Middle_Name"), "Middle Name in Add Biller");
                type(MLWalletPayBillsPage.objAddLastName, prop.getproperty("Last_Name"), "Last Name in Add Biller");
                type(MLWalletPayBillsPage.objAddNickName, prop.getproperty("Nick_Name"), "Nick Name in Add Biller");
                click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "button"));
                click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "button"));
            }
        }
    }

    public void selectAddedBiler() throws Exception {
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objSavedBiller,getTextVal(MLWalletPayBillsPage.objSavedBiller,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSavedBillers,getTextVal(MLWalletPayBillsPage.objSavedBillers,"Page"))) {
            type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Last_Name"), "Search Recipient Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, getTextVal(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, "Recipient"));
            click(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, getTextVal(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, "Recipient"));
            click(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, getTextVal(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, "Recipient"));
            waitTime(2000);
        }
    }

    public void confirmDetailsAndPay() throws Exception {
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            Swipe("UP",1);
            click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
            waitTime(4000);
        }
    }

    //================================================================================================================//


    public void payBillsPageValidation_PB_TC_01() throws Exception {
        HeaderChildNode("Pay Bills Page Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(3000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSelectBiller,getTextVal(MLWalletPayBillsPage.objSelectBiller,"Page"))){
            verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions,getTextVal(MLWalletPayBillsPage.objRecentTransactions,"Button"));
            verifyElementExist(MLWalletPayBillsPage.objBillers,getTextVal(MLWalletPayBillsPage.objBillers,"Text"));
            logger.info("PB_TC_01, Pay Bills Page validated");
            extentLoggerPass("PB_TC_01", "PB_TC_01, Pay Bills Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void billerCategories_PB_TC_02() throws Exception {
        HeaderChildNode("Biller Categories");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(2000);
        click(MLWalletPayBillsPage.objCategories,getTextVal(MLWalletPayBillsPage.objCategories,"Button"));
        if(verifyElementPresent(MLWalletPayBillsPage.objBankingAndFinance,getTextVal(MLWalletPayBillsPage.objBankingAndFinance,"Button"))){
            click(MLWalletPayBillsPage.objBankingAndFinance,getTextVal(MLWalletPayBillsPage.objBankingAndFinance,"Biller Category"));
        }

        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objCharityAndReligious,getTextVal(MLWalletPayBillsPage.objCharityAndReligious,"Biller Category"))){
            click(MLWalletPayBillsPage.objCharityAndReligious,getTextVal(MLWalletPayBillsPage.objCharityAndReligious,"Biller Category"));
            getBillers(MLWalletPayBillsPage.objCharityAndReligiousBillers);
            waitTime(2000);
            //click(MLWalletPayBillsPage.objSearchBiller,getTextVal(MLWalletPayBillsPage.objSearchBiller,"Search Biller Field"));
            Swipe("Down",1);
            click(MLWalletPayBillsPage.objCharityAndReligious1,getTextVal(MLWalletPayBillsPage.objCharityAndReligious1,"Biller Category"));
        }
        waitTime(2000);
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletPayBillsPage.objUtilities,getTextVal(MLWalletPayBillsPage.objUtilities,"Biller Category"))) {
            click(MLWalletPayBillsPage.objUtilities, getTextVal(MLWalletPayBillsPage.objUtilities, "Biller Category"));
            Swipe("UP", 1);
            getBillers(MLWalletPayBillsPage.objUtilitiesBillers);
            waitTime(2000);
            click(MLWalletPayBillsPage.objUtilities1, getTextVal(MLWalletPayBillsPage.objUtilities1, "Biller Category"));
        }
        if(verifyElementPresent(MLWalletPayBillsPage.objOthers,getTextVal(MLWalletPayBillsPage.objOthers,"Biller Category"))){
            click(MLWalletPayBillsPage.objOthers,getTextVal(MLWalletPayBillsPage.objOthers,"Biller Category"));
            Swipe("UP",1);
            getBillers(MLWalletPayBillsPage.objOthersBillers);
            click(MLWalletPayBillsPage.objOthers1,getTextVal(MLWalletPayBillsPage.objOthers1,"Biller Category"));
        }
        logger.info("PB_TC_02, Biller Categories validated");
        extentLoggerPass("PB_TC_02", "PB_TC_02, Biller Categories validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void billersInAlphabeticalOrder_PB_TC_03() throws Exception {
        HeaderChildNode("Billers In Alphabetical Order");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        explicitWaitVisibility(MLWalletPayBillsPage.objAlphabetical, 10);
        click(MLWalletPayBillsPage.objAlphabetical,getTextVal(MLWalletPayBillsPage.objAlphabetical,"Button"));
//							swipeDownUntilElementVisible("SAGIP KAPAMILYA");
//							swipeDownUntilElementVisible("ZYBITECH");


//							 List<WebElement>lists=getDriver().findElements(MLWalletPayBillsPage.objZelement);
//							 for(WebElement e : lists)
//							 {
//								 System.out.println(e.getAttribute("name"));
//								 if(e.getAttribute("name").equalsIgnoreCase("ZOE BROADCASTING"))
//								 {
//									 System.out.println("Found the value == : ");
//								 }
//
//							 }
        scroll_To_Text(MLWalletPayBillsPage.objZelement, "name", "FDSAFAWSEF");
        scroll_To_Text(MLWalletPayBillsPage.objZelement, "name", "ZOE BROADCASTING");
        logger.info("PB_TC_03, Billers swiped until Z Alphabet, and all the Billers are displayed in alphabetical order");
        extentLoggerPass("PB_TC_03", "PB_TC_03, Billers swiped until Z Alphabet, and all the Billers are displayed in alphabetical order");
        System.out.println("-----------------------------------------------------------");
    }

    public void selectBiller_PB_TC_04() throws Exception {
        HeaderChildNode("Select Biller");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        click(MLWalletPayBillsPage.objAlphabetical,getTextVal(MLWalletPayBillsPage.objAlphabetical,"Button"));
//							swipeDownUntilElementVisible("AIR ASIA BILLSPAYMENT");
        scroll_To_Text(MLWalletPayBillsPage.objAirAsia, "name", "AIR ASIA BILLSPAYMENT");
        if(verifyElementPresent(MLWalletPayBillsPage.objAirAsia,getTextVal(MLWalletPayBillsPage.objAirAsia,"Biller"))){
            String sAirAsiaBillsPayment = getText(MLWalletPayBillsPage.objAirAsia);
            click(MLWalletPayBillsPage.objAirAsia,getTextVal(MLWalletPayBillsPage.objAirAsia,"Biller"));
            verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"));
            if(verifyElementPresent(MLWalletPayBillsPage.objBillerNameInBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillerNameInBillsPayInformation,"Biller Name"))){
                String sBillerInBillsPayInformation = getText(MLWalletPayBillsPage.objBillerNameInBillsPayInformation);
                assertionValidation(sAirAsiaBillsPayment,sBillerInBillsPayInformation);
                logger.info("PB_TC_04, Bills Pay Information page is displayed and Biller name is matched");
                extentLoggerPass("PB_TC_04", "PB_TC_04, Bills Pay Information page is displayed and Biller name is matched");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void searchBiller_PB_TC_05() throws Exception {
        HeaderChildNode("Search Biller");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        waitTime(5000);
        type(MLWalletPayBillsPage.objSearchBiller,prop.getproperty("Biller_Name"),"Search Biller");
        if(verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"))){
            String sMisBillsPayBiller = getText(MLWalletPayBillsPage.objMisBillsPayBiller);
            click(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"));
            click(MLWalletPayBillsPage.objMisBillsPayBiller,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller,"Biller"));
            explicitWaitVisibility(MLWalletPayBillsPage.objBillsPayInformation, 10);
            verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"));
            if(verifyElementPresent(MLWalletPayBillsPage.objBillerNameInBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillerNameInBillsPayInformation,"Biller Name"))){
                String sBillerInBillsPayInformation = getText(MLWalletPayBillsPage.objBillerNameInBillsPayInformation);
                assertionValidation(sMisBillsPayBiller,sBillerInBillsPayInformation);
                logger.info("PB_TC_05, Bills Pay Information page is displayed and Biller name is MIS BILLSPAY123456");
                extentLoggerPass("PB_TC_05", "PB_TC_05, Bills Pay Information page is displayed and Biller name is MIS BILLSPAY123456");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void billingInformationInput_PB_TC_06() throws Exception {
        HeaderChildNode("Biller Information Input");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"),prop.getproperty("Middle_Name"),prop.getproperty("Last_Name"),"10");
        waitTime(5000);
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails,getTextVal(MLWalletPayBillsPage.objConfirmDetails,"Page"))){
            verifyElementPresent(MLWalletPayBillsPage.objBillerName,getTextVal(MLWalletPayBillsPage.objBillerName,"Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName,getTextVal(MLWalletPayBillsPage.objAccountName,"Account holder Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountNumber,getTextVal(MLWalletPayBillsPage.objAccountNumber,"Account Number"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod,getTextVal(MLWalletPayBillsPage.objPaymentMethod,"Payment Method"));
            logger.info("PB_TC_06, Confirm Details page displayed with transaction details is validated");
            extentLoggerPass("PB_TC_06", "PB_TC_06, Confirm Details page displayed with transaction details is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsWithValidInputs_PB_TC_07() throws Exception {
        HeaderChildNode("Pay Bills With Valid Inputs");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(7000);
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            Swipe("UP",1);
            click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        }
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(20000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg,getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg,"Message"))) {
            verifyElementPresent(MLWalletPayBillsPage.objAmountPaid, getTextVal(MLWalletPayBillsPage.objAmountPaid, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objPaidDate, getTextVal(MLWalletPayBillsPage.objPaidDate, "Date"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionNumber, getTextVal(MLWalletPayBillsPage.objTransactionNumber, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletPayBillsPage.objTransactionNumber);
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName, getTextVal(MLWalletPayBillsPage.objAccountName, "Account Name"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToPay, getTextVal(MLWalletPayBillsPage.objAmountToPay, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            verifyElementPresentAndClick(MLWalletPayBillsPage.objBackToHomeBtn, getTextVal(MLWalletPayBillsPage.objBackToHomeBtn, "Button"));
            verifyRecentTransaction3(prop.getproperty("Fully_verified"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
            explicitWaitVisibility(MLWalletCashOutPage.objTransactionDetails, 20);
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("PB_TC_07, Bills Payment Successful and validated with Recent Transaction");
                extentLoggerPass("PB_TC_07", "PB_TC_07, Bills Payment Successful and validated with Recent Transaction");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void payBillsInRecentTransactions_PB_TC_08() throws Exception {
        HeaderChildNode("Pay Bills In Recent Transactions");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails,getTextVal(MLWalletPayBillsPage.objTransactionDetails,"Page"))){
            verifyElementPresent(MLWalletPayBillsPage.objReferenceNumber,getTextVal(MLWalletPayBillsPage.objReferenceNumber,"Reference Number"));
            verifyElementPresent(MLWalletPayBillsPage.objReceiverName,getTextVal(MLWalletPayBillsPage.objReceiverName,"Receiver Name"));
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objReceiverMobNo, getTextVal(MLWalletPayBillsPage.objReceiverMobNo, "Receiver Mobile Number"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToSend, getTextVal(MLWalletPayBillsPage.objAmountToSend, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            logger.info("PB_TC_08, Pay Bills In Recent Transactions Validated");
            extentLoggerPass("PB_TC_08", "PB_TC_08, Pay Bills In Recent Transactions Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsInsufficientBalance_PB_TC_09() throws Exception {
        HeaderChildNode("Pay Bills Insufficient Balance");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "39000");
        waitTime(5000);
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            Swipe("UP",1);
            click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
            explicitWaitVisibility(MLWalletSendTransferPage.objInsufficientAmountMsg,20);
            if (verifyElementPresent(MLWalletSendTransferPage.objInsufficientAmountMsg, getTextVal(MLWalletSendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
                String sInsufficientBalanceErrorMsg = getText(MLWalletSendTransferPage.objInsufficientAmountMsg);
                String sExpectedErrorMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
                assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
                click(MLWalletCashOutPage.objOKBtnOne,"OK Button");
                logger.info("PB_TC_09, Insufficient Balance - Error Message is validated");
                extentLoggerPass("PB_TC_09", "PB_TC_09, Insufficient Balance - Error Message is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void billingInformationInvalidInput_PB_TC_10() throws Exception {
        HeaderChildNode("Biller Information Invalid Input");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        searchBiller();
        explicitWaitVisibility(MLWalletPayBillsPage.objConfirmBtn, 10);
        click(MLWalletPayBillsPage.objConfirmBtn,getTextVal(MLWalletPayBillsPage.objConfirmBtn,"Button"));
        explicitWaitVisibility(MLWalletPayBillsPage.objAccountNumberRequiredMsg, 10);
        if(verifyElementPresent(MLWalletPayBillsPage.objAccountNumberRequiredMsg,getTextVal(MLWalletPayBillsPage.objAccountNumberRequiredMsg,"Error Message"))){
            String sAccountNumberRequiredErrorMsg = getText(MLWalletPayBillsPage.objAccountNumberRequiredMsg);
            String sExceptedAccountNumberRequiredErrorMsg = "Account Number is required";
            assertionValidation(sAccountNumberRequiredErrorMsg,sExceptedAccountNumberRequiredErrorMsg);
        }
        if(verifyElementPresent(MLWalletPayBillsPage.objFirstNameRequiredMsg,getTextVal(MLWalletPayBillsPage.objFirstNameRequiredMsg,"Error Message"))){
            String sFirstNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objFirstNameRequiredMsg);
            String sExceptedFirstNameRequiredErrorMsg = "First name is required";
            assertionValidation(sFirstNameRequiredErrorMsg,sExceptedFirstNameRequiredErrorMsg);
        }

        if(verifyElementPresent(MLWalletPayBillsPage.objLastNameRequiredMsg,getTextVal(MLWalletPayBillsPage.objLastNameRequiredMsg,"Error Message"))){
            String sLastNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objLastNameRequiredMsg);
            String sExceptedLastNameRequiredErrorMsg = "Last name is required";
            assertionValidation(sLastNameRequiredErrorMsg,sExceptedLastNameRequiredErrorMsg);
        }

        billerDetails(prop.getproperty("Invalid_First_Name"),prop.getproperty("Invalid_Middle_Name"),prop.getproperty("Invalid_Last_Name"),"0.99");
        if(verifyElementPresent(MLWalletPayBillsPage.objInvalidFirstNameMsg,getTextVal(MLWalletPayBillsPage.objInvalidFirstNameMsg,"Error Message"))){
            String sInvalidFirstNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidFirstNameMsg);
            String sExceptedFirstNameErrorMsg = "First name must only contain letters and spaces";
            assertionValidation(sInvalidFirstNameErrorMsg,sExceptedFirstNameErrorMsg);
        }
        if(verifyElementPresent(MLWalletPayBillsPage.objInvalidSecondNameMsg,getTextVal(MLWalletPayBillsPage.objInvalidSecondNameMsg,"Error Message"))){
            String sInvalidSecondNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidSecondNameMsg);
            String sExceptedSecondNameErrorMsg = "Middle name must only contain letters and spaces";
            assertionValidation(sInvalidSecondNameErrorMsg,sExceptedSecondNameErrorMsg);
        }
        if(verifyElementPresent(MLWalletPayBillsPage.objInvalidLastName,getTextVal(MLWalletPayBillsPage.objInvalidLastName,"Error Message"))){
            String sInvalidThirdNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidLastName);
            String sExceptedThirdNameErrorMsg = "Last name must only contain letters and spaces";
            assertionValidation(sInvalidThirdNameErrorMsg,sExceptedThirdNameErrorMsg);
        }
        Swipe("Down",1);

        click(MLWalletPayBillsPage.objFirstNameField1, "First Name Text Field");
        clearField(MLWalletPayBillsPage.objFirstNameField1, "First Name Text Field");
        type(MLWalletPayBillsPage.objFirstNameField,prop.getproperty("First_Name") ,"First Name Text Field");

        click(MLWalletPayBillsPage.objMiddleNameField1, "Middle Name Text Field");
        clearField(MLWalletPayBillsPage.objMiddleNameField1, "Middle Name Text Field");
        type(MLWalletPayBillsPage.objMiddleNameField,prop.getproperty("Middle_Name") ,"Middle Name Text Field");

        click(MLWalletPayBillsPage.objLastnameField1, "Last Name Text Field");
        clearField(MLWalletPayBillsPage.objLastnameField1, "Last Name Text Field");
        type(MLWalletPayBillsPage.objLastnameField,prop.getproperty("Last_Name") ,"Last Name Text Field");
        Swipe("UP",1);
//							type(MLWalletPayBillsPage.objAmountField, "0.99","Amount to Send Text Field");
        click(MLWalletPayBillsPage.objConfirmBtn,getTextVal(MLWalletPayBillsPage.objConfirmBtn,"Button"));
        click(MLWalletPayBillsPage.objConfirmBtn,getTextVal(MLWalletPayBillsPage.objConfirmBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objInvalidAmount,getTextVal(MLWalletPayBillsPage.objInvalidAmount,"Error Message"))){
            String sInvalidAmountErrorMsg = getText(MLWalletPayBillsPage.objInvalidAmount);
            String sExceptedAmountErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg,sExceptedAmountErrorMsg);
        }

        logger.info("PB_TC_10, Invalid biller Information Error messages validated");
        extentLoggerPass("PB_TC_10", "PB_TC_10, Invalid biller Information Error messages validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void addBillerToPayBills_PB_TC_12() throws Exception {
        HeaderChildNode("Add Biller To Pay Bills");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        addBiller();
        explicitWaitVisibility(MLWalletPayBillsPage.objOKBtn, 10);
        click(MLWalletPayBillsPage.objOKBtn,getTextVal(MLWalletPayBillsPage.objOKBtn,"Button"));
        waitTime(2000);
        type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Last_Name"), "Search Biller Text Field");
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, getTextVal(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, "Recipient"))) {
            logger.info("PB_TC_12, The Added Biller is displayed in Saved Biller Page");
            extentLoggerPass("PB_TC_12", "PB_TC_12, The Added Biller is displayed in Saved Biller Page");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void payBillsAddBillerWithInvalidInputsValidation_PB_TC_13() throws Exception {
        HeaderChildNode("Pay bills, Add biller with invalid inputs validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
        waitTime(10000);
        click(MLWalletPayBillsPage.objAddBiller, getTextVal(MLWalletPayBillsPage.objAddBiller, "Button"));

        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objBillerRequiredMsg, getTextVal(MLWalletPayBillsPage.objBillerRequiredMsg, "Error Message"))) {
            String sAccountNumberRequiredErrorMsg = getText(MLWalletPayBillsPage.objBillerRequiredMsg);
            String sExceptedAccountNumberRequiredErrorMsg = "Biller is required";
            assertionValidation(sAccountNumberRequiredErrorMsg, sExceptedAccountNumberRequiredErrorMsg);
        }
        addSelectedBiller();
        type(MLWalletPayBillsPage.objAddAccountNumber, prop.getproperty("AccountNumber"), "Account Number Input Field");
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objFirstNameRequiredMsg, getTextVal(MLWalletPayBillsPage.objFirstNameRequiredMsg, "Error Message"))) {
            String sFirstNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objFirstNameRequiredMsg);
            String sExceptedFirstNameRequiredErrorMsg = "First name is required";
            assertionValidation(sFirstNameRequiredErrorMsg, sExceptedFirstNameRequiredErrorMsg);
        }

       type(MLWalletPayBillsPage.objAddFirstName, prop.getproperty("Invalid_First_Name"), "First Name Input Field");
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objFirstNameInvalidMsg, getTextVal(MLWalletPayBillsPage.objFirstNameInvalidMsg, "Error Message"))) {
            String sInvalidFirstNameErrorMsg = getText(MLWalletPayBillsPage.objFirstNameInvalidMsg);
            String sExceptedFirstNameErrorMsg = "First name is invalid";
            assertionValidation(sInvalidFirstNameErrorMsg, sExceptedFirstNameErrorMsg);
        }

        clearField(MLWalletPayBillsPage.objAddFirstName,"First name input field");
        type(MLWalletPayBillsPage.objAddFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletPayBillsPage.objAddMiddleName, prop.getproperty("Middle_Name"), "Middle Name Input Field");
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objLastNameRequiredMsg, getTextVal(MLWalletPayBillsPage.objLastNameRequiredMsg, "Error Message"))) {
            String sLastNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objLastNameRequiredMsg);
            String sExceptedLastNameRequiredErrorMsg = "Last name is required";
            assertionValidation(sLastNameRequiredErrorMsg, sExceptedLastNameRequiredErrorMsg);
        }
        type(MLWalletPayBillsPage.objAddLastName, prop.getproperty("Invalid_Last_Name"), "Last Name Input Field");
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
        click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));

        if (verifyElementPresent(MLWalletPayBillsPage.objLastNameInvalidMsg, getTextVal(MLWalletPayBillsPage.objLastNameInvalidMsg, "Error Message"))) {
            String sInvalidLastNameErrorMsg = getText(MLWalletPayBillsPage.objLastNameInvalidMsg);
            String sExceptedLastNameErrorMsg = "Last name is invalid";
            assertionValidation(sInvalidLastNameErrorMsg, sExceptedLastNameErrorMsg);
        }

        logger.info("PB_TC_13, Pay bills, Add biller with invalid inputs validated");
        extentLoggerPass("PB_TC_13", "PB_TC_13, Pay bills, Add biller with invalid inputs validated");
        System.out.println("-----------------------------------------------------------");

    }

    public void editAddedBillerToPayBills_PB_TC_14() throws Exception {
        HeaderChildNode("Edit Added Biller to Pay bIlls");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        selectAddedBiler();
        waitTime(2000);
        click(MLWalletPayBillsPage.objEditBtn,getTextVal(MLWalletPayBillsPage.objEditBtn,"Button"));
        waitTime(2000);
        click(MLWalletPayBillsPage.objEditRecipientLastName,"Last Name Input Field");
        waitTime(2000);
        clearField(MLWalletPayBillsPage.objEditRecipientLastName,"Last Name Input Field");
        click(MLWalletPayBillsPage.objLastNameClr,"Last Name Input Field");
        clearWebField(MLWalletPayBillsPage.objEditRecipientLastName);
        type(MLWalletPayBillsPage.objLastNameClr, prop.getproperty("Edited_Last_name"), "Last Name Text Field");
        click(MLWalletPayBillsPage.ObjSaveBtn, getTextVal(MLWalletPayBillsPage.ObjSaveBtn, "Button"));
        click(MLWalletPayBillsPage.ObjSaveBtn, getTextVal(MLWalletPayBillsPage.ObjSaveBtn, "Button"));
        waitTime(2000);
        click(MLWalletPayBillsPage.objOKBtn,getTextVal(MLWalletPayBillsPage.objOKBtn,"Button"));
        click(MLWalletPayBillsPage.objClearSearchBar, "Search Bar");
        clearField(MLWalletPayBillsPage.objClearSearchBar, "Search Bar");
        type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Edited_Last_name"), "Search Recipient Text Field");
        waitTime(2000);
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectBillerInnSavedBiller, "Recipient")) {
            logger.info("PB_TC_14, Successfully edited the Added Biller");
            extentLoggerPass("PB_TC_14", "PB_TC_14, Successfully edited the Added Biller");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void deleteAddedBillerPayBills_PB_TC_15() throws Exception {
        HeaderChildNode("Delete Added Biller Pay Bills");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        selectAddedBiler();
        click(MLWalletPayBillsPage.objRemoveBtn,getTextVal(MLWalletPayBillsPage.objRemoveBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmPopup,getTextVal(MLWalletPayBillsPage.objConfirmPopup,"Pop up"))){
            verifyElementPresentAndClick(MLWalletPayBillsPage.objModalConfirmBtn,getTextVal(MLWalletPayBillsPage.objModalConfirmBtn,"Button"));
        }
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSavedBillers,getTextVal(MLWalletPayBillsPage.objSavedBillers,"Page"))){
            click(MLWalletPayBillsPage.objClearSearchBar, "Search Bar");
            clearField(MLWalletPayBillsPage.objClearSearchBar, "Search Bar");
            type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Edited_Last_name"), "Search Recipient Text Field");
            waitTime(2000);;
            logger.info("PB_TC_15, Successfully deleted the Added Biller");
            extentLoggerPass("PB_TC_15", "PB_TC_15, Successfully deleted the Added Biller");
            System.out.println("-----------------------------------------------------------");

        }
    }

    //================================ Phase 2=============================================================//

    public void payBillsUIValidation_PB_TC_16() throws Exception {
        HeaderChildNode("Pay Bills UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(4000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSelectBiller,getTextVal(MLWalletPayBillsPage.objSelectBiller,"Page"))){
            verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions,getTextVal(MLWalletPayBillsPage.objRecentTransactions,"Header"));
            verifyElementPresent(MLWalletPayBillsPage.objSavedBiller,getTextVal(MLWalletPayBillsPage.objSavedBiller,"Button"));
            verifyElementPresent(MLWalletPayBillsPage.objBillers,getTextVal(MLWalletPayBillsPage.objBillers,"Header"));
            verifyElementPresent(MLWalletPayBillsPage.objCategories,getTextVal(MLWalletPayBillsPage.objCategories,"Button"));
            verifyElementPresent(MLWalletPayBillsPage.objAlphabetical,getTextVal(MLWalletPayBillsPage.objAlphabetical,"Button"));
            verifyElementPresent(MLWalletPayBillsPage.objSearchBiller,"Search Biller Input Field");
            logger.info("PB_TC_16, Pay Bills UI Page Validated");
            extentLoggerPass("PB_TC_16", "PB_TC_16, Pay Bills UI Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsBillerPayInformationPageUIValidation_PB_TC_17() throws Exception {
        HeaderChildNode("Pay bills, Biller pay information page UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        searchBiller();
        if(verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"))){
            verifyElementPresent(MLWalletPayBillsPage.objAccountNumberField, "Account Number Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objFirstNameField,"First Name Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objMiddleNameField,"Middle Name Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objLastnameField,"Last Name Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objSuffixField,"Suffix dropdown");
            verifyElementPresent(MLWalletPayBillsPage.objAmountField,"Amount to Send Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objConfirmBtn,getTextVal(MLWalletPayBillsPage.objConfirmBtn,"Button"));
            logger.info("PB_TC_17, Pay bills, Biller pay information page UI Validated");
            extentLoggerPass("PB_TC_17", "PB_TC_17, Pay bills, Biller pay information page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsAddBillerPageUIValidation_PB_TC_18() throws Exception {
        HeaderChildNode("PayBills Add Biller Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objSavedBiller,getTextVal(MLWalletPayBillsPage.objSavedBiller,"Button"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objAddBiller,getTextVal(MLWalletPayBillsPage.objAddBiller,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objAddBillers,getTextVal(MLWalletPayBillsPage.objAddBillers,"Page"))){
            waitTime(2000);
            verifyElementPresent(MLWalletPayBillsPage.objBillerInformation,getTextVal(MLWalletPayBillsPage.objBillerInformation,"Header"));
            verifyElementPresent(MLWalletPayBillsPage.objBiller,getTextVal(MLWalletPayBillsPage.objBiller,"Edit Field"));
            verifyElementPresent(MLWalletPayBillsPage.objAddAccountNumber,"Account Number Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddFirstName,"Account Holder First Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddMiddleName,"Account Holder Middle Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddLastName,"Account Holder Last Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddNickName,"Nick Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objProceedBtn,getTextVal(MLWalletPayBillsPage.objProceedBtn,"Button"));
            logger.info("PB_TC_18, PayBills Add Biller Page UI Validated");
            extentLoggerPass("PB_TC_18", "PB_TC_16, PayBills Add Biller Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void paybillsRecentTransaction_PB_TC_19() throws Exception {
        HeaderChildNode("Pay Bills Recent Transaction validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(15000);
        verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails,getTextVal(MLWalletPayBillsPage.objTransactionDetails,"Page"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objNewTransactionBtn,getTextVal(MLWalletPayBillsPage.objNewTransactionBtn,"Button"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objRecentTransactionOne,"Recent Transaction");
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"))){
            waitTime(2000);
            verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller1,getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller1,"Biller"));
            logger.info("PB_TC_19, Pay Bills Recent Transaction Validated");
            extentLoggerPass("PB_TC_19", "PB_TC_19, Pay Bills Recent Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsSavedBilerUIValidation_PB_TC_20() throws Exception {
        HeaderChildNode("Pay Bills Saved Biler UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        selectAddedBiler();
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objAccountInfo,getTextVal(MLWalletPayBillsPage.objAccountInfo,"Page"))){
//								verifyElementPresent(MLWalletPayBillsPage.objAddAccountNumber,getTextVal(MLWalletPayBillsPage.objAddAccountNumber,"Account Number"));
//								verifyElementPresent(MLWalletPayBillsPage.objAddFirstName,getTextVal(MLWalletPayBillsPage.objAddFirstName,"First Name"));
//								verifyElementPresent(MLWalletPayBillsPage.objAddMiddleName,getTextVal(MLWalletPayBillsPage.objAddMiddleName,"Middle Name"));
//								verifyElementPresent(MLWalletPayBillsPage.objAddLastName,getTextVal(MLWalletPayBillsPage.objAddLastName,"Last Name"));
//								verifyElementPresent(MLWalletPayBillsPage.objAddNickName,getTextVal(MLWalletPayBillsPage.objAddNickName,"Nick Name"));
            verifyElementPresent(MLWalletPayBillsPage.objEditBtn,getTextVal(MLWalletPayBillsPage.objEditBtn,"Button"));
            verifyElementPresent(MLWalletPayBillsPage.objRemoveBtn,getTextVal(MLWalletPayBillsPage.objRemoveBtn,"Button"));
            verifyElementPresent(MLWalletPayBillsPage.objSelectBiller,getTextVal(MLWalletPayBillsPage.objSelectBiller,"Button"));
            logger.info("PB_TC_20, Pay Bills Saved Biler UI Validated");
            extentLoggerPass("PB_TC_20", "PB_TC_20, Pay Bills Saved Biler UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsMaxBillsPaymentPerTransactionBuyTierUser_PB_TC_22() throws Exception {
        HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        payBillsNavigation();
        click(MLWalletPayBillsPage.objSearchBiller,"Search Biller");
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "20000");
        waitTime(5000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage,getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage,"Error Message"))){
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P10,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage,sExpectedErrorMessage);
            verifyElementPresentAndClick(MLWalletPayBillsPage.objUpgradeNowBtn,getTextVal(MLWalletPayBillsPage.objUpgradeNowBtn,"Button"));
            logger.info("PB_TC_22, Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account Validated");
            extentLoggerPass("PB_TC_22", "PB_TC_22, Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsMaxBillsPaymentPerTransactionSemiVerifiedTier_PB_TC_25() throws Exception {
        HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        waitTime(7000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage1,getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage1,"Error Message"))){
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage1);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage,sExpectedErrorMessage);
            verifyElementPresentAndClick(MLWalletPayBillsPage.objUpgradeNowBtn,getTextVal(MLWalletPayBillsPage.objUpgradeNowBtn,"Button"));
            logger.info("PB_TC_25, Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account Validated");
            extentLoggerPass("PB_TC_25", "PB_TC_25, Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsMaxBillsPaymentPerTransactionBranchVerifiedTier_PB_TC_28() throws Exception {
        HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        waitTime(7000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage2,getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage2,"Error Message"))){
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage2);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P25,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage,sExpectedErrorMessage);
            verifyElementPresentAndClick(MLWalletPayBillsPage.objOKBtn,getTextVal(MLWalletPayBillsPage.objOKBtn,"Button"));
            logger.info("PB_TC_26, Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account Validated");
            extentLoggerPass("PB_TC_26", "PB_TC_26, Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsMaxBillsPaymentPerTransactionFullyVerifiedTier_PB_TC_31() throws Exception {
        HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        waitTime(7000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage1,getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage1,"Error Message"))){
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage1);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage,sExpectedErrorMessage);
            verifyElementPresentAndClick(MLWalletPayBillsPage.objOKBtn,getTextVal(MLWalletPayBillsPage.objOKBtn,"Button"));
            logger.info("PB_TC_31, Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account Validated");
            extentLoggerPass("PB_TC_31", "PB_TC_31, Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsRecentTransaction_PB_TC_21() throws Exception {
        HeaderChildNode("PayBills Recent Transactions");
        waitTime(2000);
        changeNumberPage();
        //	mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogin("9999999996");
        payBillsNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions,getTextVal(MLWalletPayBillsPage.objRecentTransactions,"Header"));
        List<WebElement>allTransactions=findElements(MLWalletPayBillsPage.objAllRecentTransactions);
        int transSize=allTransactions.size();
        for(int i=0; i<transSize ; i++)
        {
            String texts=allTransactions.get(i).getText();
            logger.info("Recent Transactions == "+texts);
            extentLogger("", "Recent Transactions == "+texts);
            if(transSize!=0)
            {
                newScrollMethodHorizontal(0.8,0.2,0.25,0.2); //0.8,0.2,0.25,0.2
            }
        }
        logger.info("PB_TC_21, PayBills Recent Transactions Swiped until Last Transaction");
        extentLoggerPass("PB_TC_21", "PB_TC_21, PayBills Recent Transactions Swiped until Last Transaction");
        System.out.println("-----------------------------------------------------------");
    }

    public void locationPopUpValidation() throws Exception {
        try {
            if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "PopUp Msg"))) {
                verifyElementPresent(MLWalletHomePage.obPopupAllowBtn, getTextVal(MLWalletHomePage.obPopupAllowBtn, "Button"));
                verifyElementPresent(MLWalletHomePage.objLocationPopUpAllowOnceBtn, getTextVal(MLWalletHomePage.objLocationPopUpAllowOnceBtn, "Button"));
                verifyElementPresent(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
            }
        }catch(Exception e)
        {
            logger.info("Location Pop Up not Displayed");
            extentLogger("loc", "Location Pop Up not Displayed");
        }
    }

    public void payBillsLocationPopupValidation_PB_TC_34() throws Exception {
        HeaderChildNode("Pay Bills Location popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(2000);
        locationPopUpValidation();
        waitTime(10000);
        click(MLWalletLoginPage.objOtpContineBtn, "Clicked On OTP Continue Button");
        logger.info("PB_TC_34, Pay Bills Location popup Validated");
        extentLoggerPass("PB_TC_34", "PB_TC_34, Pay Bills Location popup Validated");
        System.out.println("------------------------------------------------");
    }


    public void permissionDenyPopUp() throws Exception {
        locationPopUpValidation();
        click(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
        if (verifyElementPresent(MLWalletHomePage.objPermissionDeniedPopUp, getTextVal(MLWalletHomePage.objPermissionDeniedPopUp, "PopUp"))) {
            verifyElementPresent(MLWalletHomePage.objOpenSettingBtn, getTextVal(MLWalletHomePage.objOpenSettingBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objCloseBtn, getTextVal(MLWalletHomePage.objCloseBtn, "Button"));
        }
    }

    public void payBillsLocationDenyFunctionality_PB_TC_35() throws Exception {
        HeaderChildNode("Pay Bills Location Deny Functionality Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(2000);
//							if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//								permissionDenyPopUp();
//								logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
//								extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
//								System.out.println("-----------------------------------------------------------");
//							}
        locationPopUpValidation();
        waitTime(10000);
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,"Otp Page"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "Otp Continue Button");
            logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
            extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsLocationPermissionDenyCloseBtnFunctionality_PB_TC_36() throws Exception {
        HeaderChildNode("Pay Bills Location Permission Deny Close Button Functionality Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        waitTime(2000);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
//							if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//								permissionDenyCloseBtnFunctionality();
//								if(verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation,getTextVal(MLWalletPayBillsPage.objBillsPayInformation,"Page"))){
//									logger.info("PB_TC_36, Pay Bills Location Permission Deny Close Button Functionality Validated");
//									extentLoggerPass("PB_TC_36", "PB_TC_36, Pay Bills Location Permission Deny Close Button Functionality Validated");
//									System.out.println("-----------------------------------------------------------");
//								}
//							}
        locationPopUpValidation();
        waitTime(10000);
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,"Otp Page"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "Otp Continue Button");
            logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
            extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsLocationPermissionDenyOpenSettingsBtnFunctionality_PB_TC_37() throws Exception {
        HeaderChildNode("Pay Bills Location Permission Deny open Settings Button Functionality Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
//							if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//								permissionDenyOpenSettingsBtnFunctionality();
//								if (verifyElementPresent(SendTransferPage.objAppInfo, getTextVal(SendTransferPage.objAppInfo, "Page"))) {
//									logger.info("PB_TC_37, Pay Bills Location Permission Deny Open Settings Button Functionality Validated");
//									extentLoggerPass("PB_TC_37", "PB_TC_37, Pay Bills Location Permission Deny Open Settings Button Functionality Validated");
//									System.out.println("-----------------------------------------------------------");
//								}
//							}
        waitTime(10000);
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,"Otp Page"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "Otp Continue Button");
            logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
            extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsLocationPopUpAllowFunctionality_PB_TC_38() throws Exception {
        HeaderChildNode("Pay Bills Location popup Allow Button Functionality Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(10000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
//							if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
//								locationPopUpAllowFunctionality();
//								if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,getTextVal(MLWalletLoginPage.objOneTimePin,"Page"))){
//									logger.info("PB_TC_38, Pay Bills Location popup Allow Button Functionality Validated");
//									extentLoggerPass("PB_TC_38", "PB_TC_38, Pay Bills Location popup Allow Button Functionality Validated");
//									System.out.println("-----------------------------------------------------------");
//								}
//							}
        waitTime(10000);
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,"Otp Page"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "Otp Continue Button");
            logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
            extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }





    public void payBillsTransactionValidationAfterMinimizingApp_PB_TC_43() throws Exception {
        HeaderChildNode("Pay Bills Transaction Validation After Minimizing App");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        waitTime(5000);
        verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"));
        Swipe("UP",1);
        click(MLWalletPayBillsPage.objPayBtn,getTextVal(MLWalletPayBillsPage.objPayBtn,"Button"));
        waitTime(2000);
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(5000);
        if(verifyElementPresent(MLWalletPayBillsPage.objSomethingWentWrongPopUp,getTextVal(MLWalletPayBillsPage.objSomethingWentWrongPopUp,"Message"))) {
            click(MLWalletPayBillsPage.objOKBtn, "OK Button");
            logger.info("PB_TC_40, Pay Bills Transaction Validation After Minimizing App Validated");
            extentLoggerPass("PB_TC_40", "PB_TC_40, Pay Bills Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionWithValidMLPin_PB_TC_49() throws Exception {
        HeaderChildNode("Pay Bills Transaction With Valid ML Pin");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        handleMpin("1111","Entered Valid Mpin");
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            verifyElementPresent(MLWalletPayBillsPage.objAmountPaid, getTextVal(MLWalletPayBillsPage.objAmountPaid, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objPaidDate, getTextVal(MLWalletPayBillsPage.objPaidDate, "Date"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionNumber, getTextVal(MLWalletPayBillsPage.objTransactionNumber, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletPayBillsPage.objTransactionNumber);
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName, getTextVal(MLWalletPayBillsPage.objAccountName, "Account Name"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToPay, getTextVal(MLWalletPayBillsPage.objAmountToPay, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            verifyElementPresentAndClick(MLWalletPayBillsPage.objBackToHomeBtn, getTextVal(MLWalletPayBillsPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            verifyRecentTransaction3(prop.getproperty("Fully_verified"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("PB_TC_48, Pay Bills Transaction With Valid ML Pin is validated");
                extentLoggerPass("PB_TC_48", "PB_TC_48, Pay Bills Transaction With Valid ML Pin is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void payBillsTransactionWithInValidMLPin_PB_TC_50() throws Exception {
        HeaderChildNode("Pay Bills Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        handleMpin("1234","Entered Invalid Mpin");
        waitTime(2000);
        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidPINMsg, getTextVal(MLWalletPayBillsPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletPayBillsPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("PB_TC_49, Buy ELoad Transaction With Invalid ML Pin validated");
            extentLoggerPass("PB_TC_49", "PB_TC_49, Buy ELoad Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsInOTPPopupValidation_PB_TC_56() throws Exception {
        HeaderChildNode("PayBills InApp OTP popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("PB_TC_55, PayBills, InApp OTP popup validated");
            extentLoggerPass("PB_TC_55", "PB_TC_55, PayBills, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionInAppOTPPopupUIValidation_PB_TC_57() throws Exception {
        HeaderChildNode("PayBills Transaction InApp OTP popup UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds,getTextVal(MLWalletLoginPage.objSeconds,"Seconds"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("PB_TC_56, PayBills Transaction InApp OTP popup UI validated");
            extentLoggerPass("PB_TC_56", "PB_TC_56, PayBills Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionNewOTPAfterSixtySecondsValidation_PB_TC_58() throws Exception {
        HeaderChildNode("PayBills New OTP got generated After Sixty Seconds validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("PB_TC_57, PayBills Transaction New OTP got generated After Sixty Seconds is validated");
            extentLoggerPass("PB_TC_57", "PB_TC_57, PayBills Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionOTPCancelBtnFunctionality_PB_TC_59() throws Exception {
        HeaderChildNode("PayBills Transaction OTP Cancel Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))){
            logger.info("PB_TC_58, PayBills Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            extentLoggerPass("PB_TC_58", "PB_TC_58, PayBills Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionOTPContinueBtnFunctionality_PB_TC_60() throws Exception {
        HeaderChildNode("PayBills Transaction OTP Continue Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn, getTextVal(MLWalletLoginPage.objOtpContineBtn, "Button"));
        waitTime(15000);
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            logger.info("PB_TC_59, PayBills Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            extentLoggerPass("PB_TC_59", "PB_TC_59, PayBills Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
