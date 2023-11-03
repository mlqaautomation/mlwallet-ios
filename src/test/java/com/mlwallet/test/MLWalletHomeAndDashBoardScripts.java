package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletHomeAndDashBoardScripts extends BaseTest{

    @Test(priority = 1) //pass
    public void mlWalletHomePageUIValidation() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageUIValidation_HD_TC_01();
    }

    @Test(priority = 2) //pass
    public void mlWalletLogOutFromHomePage_HD_TC_02() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletLogOutFromHomePage_HD_TC_02();
    }

    @Test(priority = 3) //pass
    public void mlWalletSettingsNavigationFromHomePage_HD_TC_03() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletSettingsNavigationFromHomePage_HD_TC_03();
    }

    @Test(priority = 4) //pass
    public void mlWalletHomePageEyeIconValidation_HD_TC_04() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageEyeIconValidation_HD_TC_04();
    }

    @Test(priority = 5) //pass
    public void mlWalletAccountTierLevelVerification_HD_TC_05() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletAccountTierLevelVerification_HD_TC_05();
    }

    @Test(priority = 6) //pass
    public void mlWalletHomePageRecentTransaction_HD_TC_06() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageRecentTransaction_HD_TC_06();
    }

    @Test(priority = 7) //pass
    public void mlWalletHomePageWithdrawCash_HD_TC_07() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageWithdrawCash_HD_TC_07();
    }

    @Test(priority = 8) //pass
    public void mlWalletHomePageTopUpMLWallet_HD_TC_08() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageTopUpMLWallet_HD_TC_08();
    }

    @Test(priority = 9) //pass
    public void mlWalletHomePageShopHD_TC_09() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageShopHD_TC_09();
    }

    @Test(priority = 10) //pass
    public void mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10();
    }

    @Test(priority = 11) // pass
    public void mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11();
    }

    @Test(priority = 12) //pass
    public void mlWalletSupportPageNavigation_HD_TC_12() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletSupportPageNavigation_HD_TC_12();
    }

    @Test(priority = 13) //pass
    public void mlWalletAboutPageNavigation_HD_TC_13() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletAboutPageNavigation_HD_TC_13();
    }

    @Test(priority = 14) //pass
    public void mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14();
    }

    @Test(priority = 15)
    public void mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15();
    }

    @Test(priority = 16)
    public void mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17();
    }

    @Test(priority = 17)
    public void mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18();
    }

    @Test(priority = 18)
    public void mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19();
    }

    @Test(priority = 19)
    public void mlWalletHomePageIIconValidationAsBranchVerifiedUser_HD_TC_20() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageIIconValidationAsBranchVerifiedTierUser_HD_TC_20();
    }

    @Test(priority = 20)
    public void mlWalletHomePageIIconValidationAsBuyerTierVerifiedUser_HD_TC_21() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageIIconValidationAsBuyerTierUser_HD_TC_21();
    }

    @Test(priority = 21)
    public void mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22();
    }

    @Test(priority = 22)
    public void mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23();
    }

//    @Test(priority = 23)
//    public void mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24() throws Exception {
//        mlWalletHomeAndDashBoard.mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24();
//    }

      @Test(priority = 24) //pass
    public void mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16() throws Exception {
        mlWalletHomeAndDashBoard.mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16();
    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }

}
