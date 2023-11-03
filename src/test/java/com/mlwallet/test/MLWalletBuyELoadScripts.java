package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletBuyELoadScripts extends BaseTest{


    @Test(priority = 1)
    public void buyELoadTransactionDetails_BE_TC_01() throws Exception
    {
        mlWalletBuyELoad.buyELoadTransactionDetails_BE_TC_01(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 2)
    public void buyELoadInvalidMobileNumber_BE_TC_02() throws Exception
    {
        mlWalletBuyELoad.buyELoadInvalidMobileNumber_BE_TC_02();
    }

    @Test(priority = 3)
    public void buyELoadWithoutInputMobNumber_BE_TC_03() throws Exception
    {
        mlWalletBuyELoad.buyELoadWithoutInputMobNumber_BE_TC_03();
    }

    @Test(priority = 4)
    public void buyELoadWithoutTelecommunicationSelected_BE_TC_04() throws Exception
    {
        mlWalletBuyELoad.buyELoadWithoutTelecommunicationSelected_BE_TC_04();
    }

    @Test(priority = 5)
    public void buyELoadInsufficientBalance_BE_TC_05() throws Exception
    {
        mlWalletBuyELoad.buyELoadInsufficientBalance_BE_TC_05(prop.getproperty("ios_BranchVerifiedTier"),4);
    }

    @Test(priority = 6)
    public void buyELoadMaxLimitPerTransaction_BE_TC_09() throws Exception {
        mlWalletBuyELoad.buyELoadMaxLimitPerTransaction_BE_TC_09(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 7)
    public void buyELoadTransactionPageUIValidation_BE_TC_10() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionPageUIValidation_BE_TC_10(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 8)
    public void buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11() throws Exception {
        mlWalletBuyELoad.buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(prop.getproperty("Branch_Verified"),prop.getproperty("sunMobileNumber"),4);
    }

    @Test(priority = 9)
    public void buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12();
    }

    @Test(priority = 10)
    public void buyELoadLoadSelectionPageUIValidation_BE_TC_13() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionPageUIValidation_BE_TC_13(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 11)
    public void buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 12)
    public void buyELoadTransactionDetailsPageUIValidation__BE_TC_15() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionDetailsPageUIValidation_BE_TC_15(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 13)
    public void buyELoadSelectFromContactsBtnFunctionality_BE_TC_16() throws Exception {
        mlWalletBuyELoad.buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 14)
    public void buyELoadContactsPageUIValidation_BE_TC_17() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPageUIValidation_BE_TC_17(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 15)
    public void buyELoadContactsPageBackBtnValidation_BE_TC_18() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPageBackBtnValidation_BE_TC_18(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 16)
    public void buyELoadSearchFieldValidation_BE_TC_19() throws Exception {
        mlWalletBuyELoad.buyELoadSearchFieldValidation_BE_TC_19(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 17)
    public void buyELoadAddContactToFavorites_BE_TC_20() throws Exception {
        mlWalletBuyELoad.buyELoadAddContactToFavorites_BE_TC_20(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 18)
    public void buyELoadAddedContactToFavoritesValidation_BE_TC_21() throws Exception {
        mlWalletBuyELoad.buyELoadAddedContactToFavoritesValidation_BE_TC_21(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 19)
    public void buyELoadSearchAddedFavoriteContact_BE_TC_22() throws Exception {
        mlWalletBuyELoad.buyELoadSearchAddedFavoriteContact_BE_TC_22(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 20)
    public void buyELoadSearchUnFavoriteContact_BE_TC_23() throws Exception {
        mlWalletBuyELoad.buyELoadSearchUnFavoriteContact_BE_TC_23(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 21)
    public void buyELoadPromoConfirmationPopupValidation_BE_TC_24() throws Exception {
        mlWalletBuyELoad.buyELoadPromoConfirmationPopupValidation_BE_TC_24(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 22)
    public void buyELoadOTPPageUIValidation_BE_TC_25() throws Exception {
        mlWalletBuyELoad.buyELoadOTPPageUIValidation_BE_TC_25(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 23)
    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26() throws Exception {
        mlWalletBuyELoad.buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Branch_Verified"),4);
    }

    @Test(priority = 24)
    public void buyELoadRecentTransactionUIValidation_BE_TC_27() throws Exception {
        mlWalletBuyELoad.buyELoadRecentTransactionUIValidation_BE_TC_27();
    }

    @Test(priority = 25)
    public void buyELoadTransactionDetailsUIValidation_BE_TC_28() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionDetailsUIValidation_BE_TC_28();
    }


    @Test(priority = 26)
    public void buyELoadContactsPermissionPopup_BE_TC_57() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPermissionPopup_BE_TC_57(prop.getproperty("Branch_Verified"));
    }

    @Test(priority = 27)
    public void buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_58() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_58();
    }

    @Test(priority = 28)
    public void buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_59() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_59();
    }


    @Test(priority = 29)
    public void buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_61() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_61();
    }

    @Test(priority = 30)
    public void buyELoadTransactionWithValidMLPin_BE_TC_73() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionWithValidMLPin_BE_TC_73(prop.getproperty("Fully_Verified"), 3);
    }

    @Test(priority = 31)
    public void buyELoadTransactionWithInValidMLPin_BE_TC_74() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionWithInValidMLPin_BE_TC_74(prop.getproperty("Fully_Verified"), 3);
    }

    @Test(priority = 32)
    public void buyELoadInOTPPopupValidation_BE_TC_084() throws Exception {
        mlWalletBuyELoad.buyELoadInOTPPopupValidation_BE_TC_084(prop.getproperty("Fully_Verified"), 4);
    }

    @Test(priority = 33)
    public void buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_085() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_085(prop.getproperty("Fully_Verified"), 4);
    }

    @Test(priority = 34)
    public void buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_086() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_086(prop.getproperty("Fully_Verified"), 4);
    }

    @Test(priority = 35)
    public void buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_087() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_087(prop.getproperty("Fully_Verified"), 4);
    }

    @Test(priority = 36)
    public void buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_088() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_088(prop.getproperty("Fully_Verified"), 4);
    }

    @Test(priority = 37)
    public void buyELoadTransactionValidationAfterMinimizingApp_BE_TC_064() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionValidationAfterMinimizingApp_BE_TC_064(prop.getproperty("Branch_Verified"), 4);
    }

    @Test(priority = 38)
    public void buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30(prop.getproperty("Semi_Verified"),2);
    }

    @Test(priority = 39)
    public void buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33(prop.getproperty("Semi_Verified"),2);
    }

    @Test(priority = 40)
    public void buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 41)
    public void buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 42)
    public void buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42(prop.getproperty("Branch_Verified"),2);
    }

    @Test(priority = 43)
    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48() throws Exception
    {
        mlWalletBuyELoad.buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48(prop.getproperty("Buyer_Tier"),2);
    }

    @Test(priority = 45)
    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29() throws Exception {
        mlWalletBuyELoad.buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(prop.getproperty("Fully_Verified"),3);
    }
    @Test(priority = 46)
    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45(prop.getproperty("Fully_Verified"),3);
    }


    @Test(priority = 47)
    public void buyELoadFailedTransactionPopupValidation_BE_TC_70() throws Exception {
        mlWalletBuyELoad.buyELoadFailedTransactionPopupValidation_BE_TC_70(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 48)
    public void buyELoadFailedTransactionPopupOkBtnFunctionality_BE_TC_71() throws Exception {
        mlWalletBuyELoad.buyELoadFailedTransactionPopupOkBtnFunctionality_BE_TC_71(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 49)
    public void buyELoadRequestRefundBtnFunctionality_BE_TC_72() throws Exception {
        mlWalletBuyELoad.buyELoadRequestRefundBtnFunctionality_BE_TC_72(prop.getproperty("Fully_Verified"),2);
    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
