package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HappyPathScripts extends BaseTest {


    //--------------ELoad
    @Test(priority = 1)
    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26() throws Exception {
        mlWalletBuyELoad.buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Branch_Verified"),2);
    }
    //--------------CashViaBank
    @Test(priority = 2)
    public void cashInViaBankSemiVerifiedTierStatusTransaction_CIBA_TC_25() throws Exception {
        mlWalletCashInViaBank.cashInViaBankSemiVerifiedTierStatusTransaction_CIBA_TC_25();
    }
    //---------------CashViaBank
    @Test(priority = 3)
    public void cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43();
    }
    //--------------GCash
    @Test(priority = 4)
    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
        mlWalletGCash.GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page();
    }
    //--------------CashOutWithdraw
    @Test(priority = 5)
    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123("100");
    }
    //--------------PayBills
    @Test(priority = 6)
    public void paybillsRecentTransaction_PB_TC_19() throws Exception {
        mlWalletPayBills.paybillsRecentTransaction_PB_TC_19();
    }
    //--------------SendMoneyBranch
    @Test(priority = 7)
    public void sendMoneyToSavedRecipient_STB_TC_02() throws Exception {
        mlWalletSendTransferToMLBranch.sendMoneyToSavedRecipient_STB_TC_02();
    }
    //--------------SendMoneyWalletUser
    @Test(priority = 8)
    public void sendMoneyMLWalletToExistingReceiver_STW_TC_02() throws Exception
    {
        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletToExistingReceiver_STW_TC_02();
    }
    //--------------ShopItems
    @Test(priority = 9)
    public void shopItemsReviewingItemDetailsAndFeeBeforePlacingTheOrder_SI_TC_69() throws Exception {
        mlWalletShopItems.shopItemsReviewingItemDetailsAndFeeBeforePlacingTheOrder_SI_TC_69();
    }
    //---------------TopUpGames
    @Test(priority = 10)
    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
        mlWalletTopUpGames.topUpGamesSuccessfulLoadTransaction_TUG_TC_06();
    }



    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
