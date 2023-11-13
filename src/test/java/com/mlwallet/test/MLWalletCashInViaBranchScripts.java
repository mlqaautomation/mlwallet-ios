package com.mlwallet.test;



import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MLWalletCashInViaBranchScripts extends BaseTest{
	
	


//======================================================================================================//


    //******************* Cash In Via Branch ====================================/

    @Test(priority = 1)// pass
    public void cashInviaBranch_ValidAmount_Scenario_CIBR_TC_01() throws Exception
    {
        mlWalletCashInViaBranch.cashInViaBranch_ValidAmount_Scenario_CIBR_TC_01();
    }

//   @Test(priority = 2) //pass
//    public void cashInViaBranchCancelTransactionScenario_CIBR_TC_02() throws Exception
//    {
//        mlWalletCashInViaBranch.cashInViaBranchCancelTransactionScenario_CIBR_TC_02();
//    }

//    @Test(priority = 3) //pass
//    public void cashInviaBranch_Invalid_Amount_CIBR_TC_03() throws Exception
//    {
//        mlWalletCashInViaBranch.cashInviaBranch_Invalid_Amount_CIBR_TC_03();
//    }

//    @Test(priority = 4) //pass
//    public void cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04() throws Exception
//    {
//        mlWalletCashInViaBranch.cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04();
//    }
//
//
////============================================================================================================//
//
//
//    @Test(priority = 5) //pass
//    public void cashInViaBRanchInvalidAmount_CIBR_TC_05() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBRanchInvalidAmount_CIBR_TC_05();
//    }
//
//    @Test(priority = 6) //pass
//    public void cashInViaBranchUIValidation_CIBR_TC_06() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchUIValidation_CIBR_TC_06();
//    }
//
//    @Test(priority = 7)// pass
//    public void cashInViaBranchBackBtnValidation_CIBR_TC_07() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchBackBtnValidation_CIBR_TC_07();
//    }
//
//    @Test(priority = 8) //pass
//    public void cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08();
//    }
//
//    @Test(priority = 9) //pass
//    public void cashInViaBranchQRCodePageUIValidation_CIBR_TC_09() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchQRCodePageUIValidation_CIBR_TC_09();
//    }
//
//    @Test(priority = 10) //pass
//    public void cashInViaBranchPendingTransaction_CIBR_TC_11() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchPendingTransaction_CIBR_TC_11();
//    }
//
//    @Test(priority = 11) //pass
//    public void cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12();
//    }
//
//    @Test(priority = 12) //pass
//    public void cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13("100");
//    }
//
//    @Test(priority = 13)// pass
//    public void cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14();
//    }
//
//    @Test(priority = 14) //pass
//    public void cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15();
//    }
//
//
//    @Test(priority = 15) // pass
//    public void cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19();
//    }
//
//    @Test(priority = 16) //pass
//    public void cashInViaBranchBuyerTierUser_CIBR_TC_16() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchBuyerTierUser_CIBR_TC_16();
//    }
//
//
//    @Test(priority = 17) // pass
//    public void cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20();
//    }
//
//    @Test(priority = 18) //pass
//    public void cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17();
//    }
//
//    @Test(priority = 19) //pass
//    public void cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21();
//    }
//
//    @Test(priority = 20) //pass
//    public void cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18();
//    }
//
//    @Test(priority = 21)
//    public void cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22();
//    }
//
//
//    @Test(priority = 22) //pass
//    public void cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26();
//    }
//
//    @Test(priority = 23)// pass
//    public void cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23();
//    }
//
//    @Test(priority = 24) //pass
//    public void cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36();
//    }
//
//    @Test(priority = 25)// pass
//    public void cashInViaBranchAmountFieldValidation_CIBR_TC_42() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchAmountFieldValidation_CIBR_TC_42();
//    }
//
//    @Test(priority = 26) //pass
//    public void cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43();
//    }
//
//    @Test(priority = 27)// pass
//    public void cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44();
//    }
//
//    @Test(priority = 28)// pass
//    public void cashInViaBranchOTPPopupValidation_CIBR_TC_50() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchOTPPopupValidation_CIBR_TC_50();
//    }
//
//    @Test(priority = 29) //pass
//    public void cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51();
//    }
//
//    @Test(priority = 30)// pass
//    public void cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52();
//    }
//
//    @Test(priority = 31) //pass
//    public void cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53();
//    }
//
//    @Test(priority = 32) //pass
//    public void cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54();
//    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }

   

}