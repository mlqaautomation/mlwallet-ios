package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletCashOutWithdrawScripts extends BaseTest{

//    @Test(priority = 1)
//    public void cashOutWithdrawBank_WM_TC_01() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutWithdrawBank_WM_TC_01("100");
//    }
//
//    @Test(priority = 2)
//    public void cashOutWithInvalidAccNumber_WM_TC_02() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutWithInvalidAccNumber_WM_TC_02();
//    }
//
//    @Test(priority = 3)
//    public void cashOutWithdrawBankMaxAmount_WM_TC_03() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutWithdrawBankMaxAmount_WM_TC_03("60000");
//    }
//
//    @Test(priority = 4)
//    public void cashOutWithdrawMinTransactionLimit_WM_TC_04() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutWithdrawMinTransactionLimit_WM_TC_04("10");
//    }
//
//    @Test(priority = 5) //blocked
//    public void cashOutWithdrawBranch_WM_TC_05() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutWithdrawBranch_WM_TC_05();
//    }
//
//    @Test(priority = 6) //blocked
//    public void cashOutMaxLimit_WM_TC_06() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutMaxLimit_WM_TC_06();
//    }
//
//    @Test(priority = 7) //blocked
//    public void cashOutInsufficientBalance_WM_TC_07() throws Exception {
//        mlWalletCashOutWithdraw.cashOutInsufficientBalance_WM_TC_07();
//    }
//
//    @Test(priority = 8) //blocked
//    public void cashOutBuyerTierLevelAcc_WM_TC_09() throws Exception
//    {
//        mlWalletCashOutWithdraw.cashOutBuyerTierLevelAcc_WM_TC_09();
//    }
//
//
//  //=========================== Phase 2=================================================================//
//
//
//
//    @Test(priority = 9) //pass
//    public void cashOutInvalidBank_WM_TC_10() throws Exception {
//        mlWalletCashOutWithdraw.cashOutInvalidBank_WM_TC_10();
//    }
//
//    @Test(priority = 10) //pass
//    public void searchAndSelectBank_WM_TC_11() throws Exception {
//        mlWalletCashOutWithdraw.searchAndSelectBank_WM_TC_11();
//    }
//
//    @Test(priority = 11)// pass
//    public void cashOutInvalidAmount_WM_TC_12() throws Exception {
//        mlWalletCashOutWithdraw.cashOutInvalidAmount_WM_TC_12();
//    }
//
//    @Test(priority = 12) //pass
//    public void cashOutSaveRecipient_WM_TC_13() throws Exception {
//        mlWalletCashOutWithdraw.cashOutSaveRecipient_WM_TC_13("100");
//    }
//
//    @Test(priority = 13) //pass
//    public void cashOutRecipientDuplicate_WM_TC_14() throws Exception {
//        mlWalletCashOutWithdraw.cashOutRecipientDuplicate_WM_TC_14("100");
//    }
//
//    @Test(priority = 14)// pass
//    public void cashOutUIValidation_WM_TC_16() throws Exception {
//        mlWalletCashOutWithdraw.cashOutUIValidation_WM_TC_16();
//    }
//
//    @Test(priority = 15)// pass
//    public void cashOutWithdrawBackBtnValidation_WM_TC_17() throws Exception {
//        mlWalletCashOutWithdraw.cashOutWithdrawBackBtnValidation_WM_TC_17();
//    }
//
//    @Test(priority = 16) // blocked
//    public void cashOutToBranchUIValidation_WM_TC_18() throws Exception {
//        mlWalletCashOutWithdraw.cashOutToBranchUIValidation_WM_TC_18();
//    }
//
//    @Test(priority = 17) //pass
//    public void cashOutToBranchBackBtnValidation_WM_TC_19 () throws Exception {
//        mlWalletCashOutWithdraw.cashOutToBranchBackBtnValidation_WM_TC_19();
//    }
//
//    @Test(priority = 18)
//    public void cashOutOTPPageUIValidation_WM_TC_20() throws Exception {
//        mlWalletCashOutWithdraw.cashOutOTPPageUIValidation_WM_TC_20("100");
//    }
//
//    @Test(priority = 19)
//    public void cashOutOTPPageBackBtnValidation_WM_TC_21() throws Exception {
//        mlWalletCashOutWithdraw.cashOutOTPPageBackBtnValidation_WM_TC_21("100");
//    }

    @Test(priority = 20)
    public void cashOutMLBankBuyerTier_WM_TC_27() throws Exception {
        mlWalletCashOutWithdraw.cashOutMLBankBuyerTier_WM_TC_27("100");
    }
	@Test(priority = 21)
	public void cashOutSemiVerifiedTier_WM_TC_28() throws Exception {
        mlWalletCashOutWithdraw.cashOutSemiVerifiedTier_WM_TC_28("100");
	}
	@Test(priority = 22)
	public void cashOutFullyVerifiedTier_WM_TC_29() throws Exception {
        mlWalletCashOutWithdraw.cashOutFullyVerifiedTier_WM_TC_29("100");
	}
	@Test(priority = 23)
	public void cashOutMaxLimitSemiVerifiedTier_WM_TC_33() throws Exception {
        mlWalletCashOutWithdraw.cashOutMaxLimitSemiVerifiedTier_WM_TC_33();
	}
	@Test(priority = 24)
	public void cashOutMaxLimitFullyVerifiedTier_WM_TC_36() throws Exception {
        mlWalletCashOutWithdraw.cashOutMaxLimitFullyVerifiedTier_WM_TC_36();
	}
	@Test(priority = 25)
	public void cashOutBankPageUIValidation_WM_TC_49() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankPageUIValidation_WM_TC_49();
	}
	@Test(priority = 26)
	public void cashOutDragonPayPageUIValidation_WM_TC_50() throws Exception {
        mlWalletCashOutWithdraw.cashOutDragonPayPageUIValidation_WM_TC_50();
	}
	@Test(priority = 27)
	public void cashOutBankReviewTransactionUIValidation_WM_TC_51() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankReviewTransactionUIValidation_WM_TC_51("100");
	}
	@Test(priority = 28)
	public void cashOutBankTransactionReceiptUIValidation_WM_TC_52() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionReceiptUIValidation_WM_TC_52("100");
	}
	@Test(priority = 29)
	public void cashOutRecentTransactionDetailsUIValidation_WM_TC_53() throws Exception {
        mlWalletCashOutWithdraw.cashOutRecentTransactionDetailsUIValidation_WM_TC_53();
	}
	@Test(priority = 30)
	public void cahOutBankViewAllPageBackBtnValidation_WM_TC_56() throws Exception {
        mlWalletCashOutWithdraw.cahOutBankViewAllPageBackBtnValidation_WM_TC_56();
	}
	@Test(priority = 31)
	public void cashOutBankSavedRecipientEditBackButton_WM_TC_57() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankSavedRecipientEditBackButton_WM_TC_57();
	}
	@Test(priority = 32)
	public void cashOutBankEditRecipient_WM_TC_58() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankEditRecipient_WM_TC_58();
	}
	@Test(priority = 33)
	public void cashOutBankDeleteRecipient_WM_TC_59() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankDeleteRecipient_WM_TC_59();
	}
	@Test(priority = 34)
	public void cashOutBankBackToHomeBtnValidation_WM_TC_62() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankBackToHomeBtnValidation_WM_TC_62();
	}
	@Test(priority = 35)
	public void cashOutBankNewTransactionBtnValidation_WM_TC_63() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankNewTransactionBtnValidation_WM_TC_63();
	}
	@Test(priority = 36)
	public void cashOutBankDragonPayMessageValidation_WM_TC_64() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankDragonPayMessageValidation_WM_TC_64("100");
	}
	@Test(priority = 37)
	public void cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65("100",35);
	}
	@Test(priority = 38)
	public void cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83("100");
	}
	@Test(priority = 39)
	public void cashOutBankAmountFieldValidation_WM_TC_97() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankAmountFieldValidation_WM_TC_97("100.123");
	}
	@Test(priority = 40)
	public void cashOutBankTransactionWithValidMLPin_WM_TC_99() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionWithValidMLPin_WM_TC_99("100");
	}
	@Test(priority = 41)
	public void cashOutBranchTransactionWithInValidMLPin_WM_TC_100() throws Exception {
        mlWalletCashOutWithdraw.cashOutBranchTransactionWithInValidMLPin_WM_TC_100("100");
	}
    @Test(priority = 42)
    public void cashOutBankInAppOTPPopupValidation_WM_TC_119() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankInAppOTPPopupValidation_WM_TC_119("100");
    }

    @Test(priority = 43)
    public void cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120("100");
    }

    @Test(priority = 44)
    public void cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121("100");
    }

    @Test(priority = 45)
    public void cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122("100");
    }
    @Test(priority = 46)
    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123() throws Exception {
        mlWalletCashOutWithdraw.cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123("100");
    }


    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}

