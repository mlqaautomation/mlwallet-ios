package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletSendTransferToMLWalletUserScripts extends BaseTest{

//    @Test(priority = 1)
//    public void sendToMLWalletUser_STW_TC_01() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendToMLWalletUser_STW_TC_01();
//    }
//
//
//    @Test(priority = 2)
//    public void sendMoneyAddToFavorites_STW_TC_12() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyAddToFavorites_STW_TC_12();
//    }
//
//    @Test(priority = 3)
//    public void sendMoneyMLWalletToExistingReceiver_STW_TC_02() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletToExistingReceiver_STW_TC_02();
//    }
//
//    @Test(priority = 4)
//    public void sendToMLWalletInvalidMobNumber_STW_TC_03() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendToMLWalletInvalidMobNumber_STW_TC_03();
//    }
//
//
//    @Test(priority = 5)
//    public void sendToMLWalletUnRegisteredNumber_STW_TC_04() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendToMLWalletUnRegisteredNumber_STW_TC_04();
//    }

//    @Test(priority = 6)
//    public void sendToMLWalletInvalidAmount_STW_TC_05() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendToMLWalletInvalidAmount_STW_TC_05("0");
//    }

//    @Test(priority = 7)
//    public void sendToMLWalletInsufficientAmount_STW_TC_06() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendToMLWalletInsufficientAmount_STW_TC_06();
//    }

//    @Test(priority = 8)
//    public void sendMoneyMLWalletMaximumAmount_STW_TC_07() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletMaximumAmount_STW_TC_07();
//    }



//================================================================================================//

//    @Test(priority = 9)
//    public void sendMoneyDeleteFromFavorites_STW_TC_09() throws Exception
//    {
//        mlWalletSendTransferToMLWalletUser.sendMoneyDeleteFromFavorites_STW_TC_09();
//    }
//
//    @Test(priority = 10)
//    public void sendMoneyMLWalletUIValidation_STW_TC_10() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletUIValidation_STW_TC_10();
//    }
//
//    @Test(priority = 11)
//    public void sendMoneyFavoritesUIValidation_STW_TC_11() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyFavoritesUIValidation_STW_TC_11();
//    }
//
//    @Test(priority = 12)
//    public void sendMoneyMLWalletCancelTransaction_STW_TC_13() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletCancelTransaction_STW_TC_13("100");
//    }
//
//    @Test(priority = 13)
//    public void sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14();
//    }
//
//    @Test(priority = 14)
//    public void sendMoneyMLWalletSearchFavoriteUser_STW_TC_15() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletSearchFavoriteUser_STW_TC_15();
//    }
//
//    @Test(priority = 15)
//    public void SendMoneyMLWalletSuccessPageUIValidation_STW_TC_16() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletSuccessPageUIValidation_STW_TC_16();
//    }
//
//    @Test(priority = 16)
//    public void sendMoneyMLWalletOTPPageUIValidation_STW_TC_17() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletOTPPageUIValidation_STW_TC_17();
//    }
//
//    @Test(priority = 17)
//    public void sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18("100");
//    }
//
//    @Test(priority = 18)
//    public void sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19();
//    }

//    @Test(priority = 19)
//    public void sendMoneyToMLWalletPageUIValidation_STW_TC_20() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletPageUIValidation_STW_TC_20();
//    }

//    @Test(priority = 20)
//    public void sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21();
//    }

//    @Test(priority = 21)
//    public void sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22();
//    }
//
//    @Test(priority = 22)
//    public void sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23();
//    }
//
//    @Test(priority =  23)
//    public void sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24();
//    }
//
//    @Test(priority = 24)
//    public void sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25();
//    }
//
    @Test(priority = 25)
    public void sendMoneyMlWalletSemiVerifiedAccountMaxLimit_STW_TC_26() throws Exception {
        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletSemiVerifiedAccountMaxLimit_STW_TC_26();
    }

//    @Test(priority = 26)
//    public void sendMoneyMlWalletBranchVerifiedAccountMaxLimit_STW_TC_29() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletBranchVerifiedAccountMaxLimit_STW_TC_29();
//    }
//
//    @Test(priority = 27)
//    public void sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32();
//    }
//
//    @Test(priority = 28)
//    public void sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35();
//    }

//    @Test(priority = 29)
//    public void sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36("50000");
//    }
//
//    @Test(priority = 30)
//    public void sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38("50000");
//    }
//
//    @Test(priority = 31)
//    public void sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40("50000");
//    }


    @Test(priority = 32)
    public void sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_51() throws Exception {
        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_51();
    }

//    @Test(priority = 33)
//    public void sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_57() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_57();
//    }
//
//    @Test(priority = 34)
//    public void sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_58() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_58();
//    }
//
//    @Test(priority = 35)
//    public void sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63();
//    }
//
//    @Test(priority = 36)
//    public void sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64();
//    }

    @Test(priority = 37)
    public void sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65() throws Exception {
        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65();
    }

//    @Test(priority = 38)
//    public void sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66();
//    }
//
//    @Test(priority = 39)
//    public void sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67() throws Exception {
//        mlWalletSendTransferToMLWalletUser.sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67();
//    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
