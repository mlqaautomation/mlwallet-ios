package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletTransactionHistoryScripts extends BaseTest{

//    @Test(priority = 1)
//    public void mlWalletTransactionHistoryScenario__TH_TC_01() throws Exception
//    {
//        mlWalletTransactionHistory.mlWallet_TransactionHistory_TH_TC_01();
//    }
//
//    @Test(priority = 2)
//    public void billsPayTransactionHHistory_TH_TC_02() throws Exception {
//        mlWalletTransactionHistory.billsPayTransactionHHistory_TH_TC_02();
//    }
//
//    @Test(priority = 3)
//    public void buyLoadTransactionHistory_TH_TC_03() throws Exception {
//        mlWalletTransactionHistory.buyLoadTransactionHistory_TH_TC_03();
//    }
//
//    @Test(priority = 4)
//    public void sendMoneyTransactionHistory_TH_TC_04() throws Exception {
//        mlWalletTransactionHistory.sendMoneyTransactionHistory_TH_TC_04();
//    }
//
//    @Test(priority = 5)
//    public void cashInTransactionHistory_TH_TC_05() throws Exception {
//        mlWalletTransactionHistory.cashInTransactionHistory_TH_TC_05();
//    }
//
//    @Test(priority = 6)
//    public void cashOutTransactionHistory_TH_TC_06() throws Exception {
//        mlWalletTransactionHistory.cashOutTransactionHistory_TH_TC_06();
//    }
//
//    @Test(priority = 7)
//    public void receiveMoneyTransactionHistory_TH_TC_07() throws Exception {
//        mlWalletTransactionHistory.receiveMoneyTransactionHistory_TH_TC_07();
//    }
//
//    @Test(priority = 8)
//    public void balanceAdjustmentTransactionHistory_TH_TC_08() throws Exception {
//        mlWalletTransactionHistory.balanceAdjustmentTransactionHistory_TH_TC_08();
//    }
//
//    @Test(priority = 9)
//    public void mlShopTransactionHistory_TH_TC_09() throws Exception {
//        mlWalletTransactionHistory.mlShopTransactionHistory_TH_TC_09();
//    }
//

//======================================================================================================//

//    @Test(priority = 10)
//    public void transactionHistoryUIValidation_TH_TC_10() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryUIValidation_TH_TC_10();
//    }
//
//    @Test(priority = 11)
//    public void transactionHistoryBillsPayTransactionDetailsValidation_TH_TC_13() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryBillsPayTransactionDetailsValidation_TH_TC_13();
//    }
//
//    @Test(priority = 12)
//    public void transactionHistoryELoadTransactionDetailsValidation_TH_TC_14() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryELoadTransactionDetailsValidation_TH_TC_14();
//    }
//
//    @Test(priority = 13)
//    public void transactionHistorySendMoneyWalletToWalletTransactionDetailsValidation_TH_TC_15() throws Exception {
//        mlWalletTransactionHistory.transactionHistorySendMoneyWalletToWalletTransactionDetailsValidation_TH_TC_15();
//    }
//
//    @Test(priority = 14)
//    public void transactionHistorySendMoneyKwartaPadalaTransactionDetailsValidation_TH_TC_16() throws Exception {
//        mlWalletTransactionHistory.transactionHistorySendMoneyKwartaPadalaTransactionDetailsValidation_TH_TC_16();
//    }
//
//    @Test(priority = 15)
//    public void transactionHistoryCashInTransactionDetailsValidation_TH_TC_17() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryCashInTransactionDetailsValidation_TH_TC_17();
//    }
//
//    @Test(priority = 16)
//    public void transactionHistoryCashOutTransactionDetailsValidation_TH_TC_18() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryCashOutTransactionDetailsValidation_TH_TC_18();
//    }
//
//    @Test(priority = 17)
//    public void transactionHistoryReceiveMoneyTransactionDetailsValidation_TH_TC_19() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryReceiveMoneyTransactionDetailsValidation_TH_TC_19();
//    }
//
//    @Test(priority = 18)
//    public void transactionHistoryMLShopTransactionDetailsValidation_TH_TC_20() throws Exception {
//        mlWalletTransactionHistory.transactionHistoryMLShopTransactionDetailsValidation_TH_TC_20();
//    }

    @Test(priority = 19)
    public void transactionHistoryNoRecentTransactionValidation_TH_TC_11() throws Exception {
        mlWalletTransactionHistory.transactionHistoryNoRecentTransactionValidation_TH_TC_11();
    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }

}
