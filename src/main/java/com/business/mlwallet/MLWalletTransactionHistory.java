package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletTransactionHistoryPage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.business.mlwallet.MLWalletLogin.changeNumberPage;
import static com.business.mlwallet.MLWalletLogin.mlWalletLogin;
import static com.utility.Utilities.*;

public class MLWalletTransactionHistory extends BaseClass{
    public MLWalletTransactionHistory() {
        super();

    }
    public void mlWallet_TransactionHistory_Generic_Steps(String billModule) throws Exception {
        String PayBillsHistory = getText(MLWalletTransactionHistoryPage.objBillHistory(billModule));
        System.out.println(PayBillsHistory);
        if (PayBillsHistory.contains(billModule))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLWalletTransactionHistoryPage.objPayBillsTransctionList1(billModule));
            for (int i = 0; i < values.size(); i++) {
                String billPayTransaction = values.get(i).getText();
                logger.info(billModule + " All Transactions : " + billPayTransaction);
                extentLogger(" ", billModule + " All Transactions : " + billPayTransaction);
            }
        } else// "No Recent Transaction"
        {
            logger.info("No Recent Transactions Are Available for " + billModule + " Module");
            extentLogger("", "No Recent Transactions Are Available for " + billModule + " Module");
        }
    }

    public void mlWallet_TransactionHistory_TH_TC_01() throws Exception {
        HeaderChildNode("MLWallet_TransactionHistory_Scenario");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletTransactionHistoryPage.objRecentTransaction, getText(MLWalletTransactionHistoryPage.objRecentTransaction));
        Swipe("UP", 2);
        click(MLWalletTransactionHistoryPage.objSeeMoreBtn, "See More Button");
        waitTime(10000);
        verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionHistory, getTextVal(MLWalletTransactionHistoryPage.objTransactionHistory, "Page"));
        logger.info("TH_TC_01, All Transactions are displayed");
        extentLoggerPass("TH_TC_01", "'TH_TC_01', All Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void billsPayTransactionHHistory_TH_TC_02() throws Exception {
        HeaderChildNode("Bills Pay Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        click(MLWalletTransactionHistoryPage.objBillsPayTab, "Bills Pay");
        waitTime(5000);
        mlWallet_TransactionHistory_Generic_Steps("Pay Bills");
        logger.info("TH_TC_02, Bills pay Transactions are displayed");
        extentLoggerPass("TH_TC_02", "'TH_TC_02', Bills pay Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void buyLoadTransactionHistory_TH_TC_03() throws Exception {
        HeaderChildNode("Buy Eload Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        click(MLWalletTransactionHistoryPage.objeLoadTab, "eLoad");
        mlWallet_TransactionHistory_Generic_Steps("Buy Eload");
        logger.info("TH_TC_03, eLoad Transactions are displayed");
        extentLoggerPass("TH_TC_03", "'TH_TC_03', eLoad Transactions Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void sendMoneyTransactionHistory_TH_TC_04() throws Exception {
        HeaderChildNode("Send Money Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        click(MLWalletTransactionHistoryPage.objSendMoneyTab, "Send Money");
        mlWallet_TransactionHistory_Generic_Steps("Kwarta Padala"); // Kwarta Padala
        logger.info("TH_TC_04, Send Money Transactions are displayed");
        extentLoggerPass("TH_TC_04", "'TH_TC_04', Send Money Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void cashInTransactionHistory_TH_TC_05() throws Exception {
        HeaderChildNode("Cash In Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        //scrollToFirstHorizontalScrollableElement("Cash In");
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objCashInTab, "name" , "Cash In");
        click(MLWalletTransactionHistoryPage.objCashInTab, "Cash In");
        Thread.sleep(3000);
        mlWallet_TransactionHistory_Generic_Steps("Cash In");
        logger.info("TH_TC_05, Cash In Transactions are displayed");
        extentLoggerPass("TH_TC_05", "'TH_TC_05',  Cash In Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void cashOutTransactionHistory_TH_TC_06() throws Exception {
        HeaderChildNode("Cash Out Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objCashOutTab, "name" , "Cash Out");
        click(MLWalletTransactionHistoryPage.objCashOutTab, "Cash Out");
        waitTime(3000);
        mlWallet_TransactionHistory_Generic_Steps("Cash Out");
        logger.info("TH_TC_06,  Cash Out Transactions are displayed");
        extentLoggerPass("TH_TC_06", "'TH_TC_06', Cash Out Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void receiveMoneyTransactionHistory_TH_TC_07() throws Exception {
        HeaderChildNode("Receive Money Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "name" , "Receive Money");
        click(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Receive Money");
        waitTime(3000);
        mlWallet_TransactionHistory_Generic_Steps("Wallet to Wallet");
        logger.info("TH_TC_07, Receive Money Transactions are displayed");
        extentLoggerPass("TH_TC_07", "'TH_TC_07', Receive Money Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void balanceAdjustmentTransactionHistory_TH_TC_08() throws Exception {
        HeaderChildNode("Balance Adjustment Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objBalanceAdjustmentTab, "name" , "Balance Adjustment");
        click(MLWalletTransactionHistoryPage.objBalanceAdjustmentTab, "Balance Adjustment");
        Thread.sleep(2000);
        mlWallet_TransactionHistory_Generic_Steps("Adjustment");
        logger.info("TH_TC_08, Balance Adjustment Transactions are displayed");
        extentLoggerPass("TH_TC_08", "'TH_TC_08', Balance Adjustment Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }

    public void mlShopTransactionHistory_TH_TC_09() throws Exception {
        HeaderChildNode("ML Shop Transaction History");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objMlShopTab, "name" , "ML Shop");
        click(MLWalletTransactionHistoryPage.objMlShopTab, "ML Shop");
        waitTime(3000);
        mlWallet_TransactionHistory_Generic_Steps("ML Shop");
        logger.info("TH_TC_09, ML Shop Transactions are displayed");
        extentLoggerPass("TH_TC_09", "'TH_TC_09', ML Shop Transactions are displayed");
        System.out.println("-----------------------------------------------------------");
    }


    public void transactionHistoryUIValidation_TH_TC_10() throws Exception {
        HeaderChildNode("Transaction History UI Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        waitTime(10000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objAllTab, getTextVal(MLWalletTransactionHistoryPage.objAllTab, "Tab"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objBillsPayTab, getTextVal(MLWalletTransactionHistoryPage.objBillsPayTab, "Tab"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objeLoadTab, getTextVal(MLWalletTransactionHistoryPage.objeLoadTab, "Tab"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSendMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objSendMoneyTab, "Tab"));
            //scrollToFirstHorizontalScrollableElement("Cash Out");
            scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objCashOutTab, "name" , "Cash Out");
            verifyElementPresent(MLWalletTransactionHistoryPage.objCashInTab, getTextVal(MLWalletTransactionHistoryPage.objCashInTab, "Tab"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objCashOutTab, getTextVal(MLWalletTransactionHistoryPage.objCashOutTab, "Tab"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
            //scrollToFirstHorizontalScrollableElement("ML Shop");
            scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objMlShopTab, "name" , "ML Shop");
            verifyElementPresent(MLWalletTransactionHistoryPage.objBalanceAdjustmentTab, getTextVal(MLWalletTransactionHistoryPage.objBalanceAdjustmentTab, "Tab"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objMlShopTab, getTextVal(MLWalletTransactionHistoryPage.objMlShopTab, "Tab"));
            logger.info("TH_TC_10,Transaction History UI Validated");
            extentLoggerPass("TH_TC_10", "'TH_TC_10',Transaction History UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void transactionHistoryNoRecentTransactionValidation_TH_TC_11() throws Exception {
        HeaderChildNode("Transaction History No Recent transaction validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin("9999999941");
        verifyElementPresent(MLWalletTransactionHistoryPage.objRecentTransaction, getText(MLWalletTransactionHistoryPage.objRecentTransaction));
        if(verifyElementPresent(MLWalletTransactionHistoryPage.objNoRecentTransaction,getTextVal(MLWalletTransactionHistoryPage.objNoRecentTransaction,"Text"))){
            logger.info("TH_TC_11, Transaction History, If No transactions are present No Recent Transaction text is displayed");
            extentLoggerPass("TH_TC_11", "'TH_TC_11', Transaction History, If No transactions are present No Recent Transaction text is displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void transactionHistoryBillsPayTransactionDetailsValidation_TH_TC_13() throws Exception {
        HeaderChildNode("Transaction History BillsPay Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objBillsPayTab, getTextVal(MLWalletTransactionHistoryPage.objBillsPayTab, "Tab"));
        waitTime(2000);
        if (verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"Pay Bills First Transaction"))) {
            waitTime(2000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objBiller, getTextVal(MLWalletTransactionHistoryPage.objBiller, "Biller"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("TH_TC_13,Transaction History BillsPay Transaction Details Validated");
            extentLoggerPass("TH_TC_13", "'TH_TC_13',Transaction History BillsPay Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        } else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistoryELoadTransactionDetailsValidation_TH_TC_14() throws Exception {
        HeaderChildNode("Transaction History ELoad Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objeLoadTab, getTextVal(MLWalletTransactionHistoryPage.objeLoadTab, "Tab"));
        waitTime(5000);
        if (verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"))) {
            waitTime(2000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objLoadType, getTextVal(MLWalletTransactionHistoryPage.objLoadType, "Load Type"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("TH_TC_14,Transaction History ELoad Transaction Details Validated");
            extentLoggerPass("TH_TC_14", "'TH_TC_14',Transaction History ELoad Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistorySendMoneyWalletToWalletTransactionDetailsValidation_TH_TC_15() throws Exception {
        HeaderChildNode("Transaction History Send Money Wallet To Wallet Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objSendMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objSendMoneyTab, "Tab"));
        waitTime(5000);
        if (verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"))) {
            waitTime(2000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("TH_TC_15,Transaction History Send Money Wallet To Wallet Transaction Details Validated");
            extentLoggerPass("TH_TC_15", "'TH_TC_15',Transaction History Send Money Wallet To Wallet Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistorySendMoneyKwartaPadalaTransactionDetailsValidation_TH_TC_16() throws Exception {
        HeaderChildNode("Transaction History Send Money Kwarta Padala Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objSendMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objSendMoneyTab, "Tab"));
        waitTime(5000);
        if (verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionKwartaPadala, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionKwartaPadala,"Kwarta Padala First Transaction"))) {
            waitTime(2000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("TH_TC_16,Transaction History Send Money Kwarta Padala Transaction Details Validated");
            extentLoggerPass("TH_TC_16", "'TH_TC_16',Transaction History Send Money Kwarta Padala Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistoryCashInTransactionDetailsValidation_TH_TC_17() throws Exception {
        HeaderChildNode("Transaction History Cash In Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objCashInTab, "name" , "Cash In");
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objCashInTab, getTextVal(MLWalletTransactionHistoryPage.objCashInTab, "Tab"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashIn, getTextVal(MLWalletTransactionHistoryPage.objTotalCashIn, "Total Cash In"));
            logger.info("TH_TC_17,Transaction History Cash In Transaction Details Validated");
            extentLoggerPass("TH_TC_17", "'TH_TC_17',Transaction History Cash In Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistoryCashOutTransactionDetailsValidation_TH_TC_18() throws Exception {
        HeaderChildNode("Transaction History Cash Out Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objCashOutTab, "name" , "Cash Out");
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objCashOutTab, getTextVal(MLWalletTransactionHistoryPage.objCashOutTab, "Tab"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashOut, getTextVal(MLWalletTransactionHistoryPage.objTotalCashOut, "Total Cash Out"));
            logger.info("TH_TC_18,Transaction History Cash Out Transaction Details Validated");
            extentLoggerPass("TH_TC_18", "'TH_TC_18',Transaction History Cash Out Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistoryReceiveMoneyTransactionDetailsValidation_TH_TC_19() throws Exception {
        HeaderChildNode("Transaction History Receive Money Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "name" , "Receive Money");
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            logger.info("TH_TC_19,Transaction History Receive Money Transaction Details Validated");
            extentLoggerPass("TH_TC_19", "'TH_TC_19',Transaction History Receive Money Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

    public void transactionHistoryMLShopTransactionDetailsValidation_TH_TC_20()throws Exception {
        HeaderChildNode("Transaction History ML Shop Transaction Details Validation");
        mlWallet_TransactionHistory_TH_TC_01();
        scroll_To_Text_Horizontal(MLWalletTransactionHistoryPage.objMlShopTab, "name","ML Shop");
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objMlShopTab,getTextVal(MLWalletTransactionHistoryPage.objMlShopTab, "Tab"));
        waitTime(3000);
        if(verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransactionInTab, getTextVal(MLWalletTransactionHistoryPage.objFirstTransactionInTab,"First Transaction"))){
            waitTime(3000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails,getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails,getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails,"Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate,getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo,getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo,"Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod,getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod,"Payment Method"));
            logger.info("TH_TC_20,Transaction History ML Shop Transaction Details Validated");
            extentLoggerPass("TH_TC_20","'TH_TC_20',Transaction History ML Shop Transaction Details Validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            logger.info("No recent Transaction");
            extentLogger("", "No recent Transaction");
        }
    }

}
