package com.mlwallet.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.utility.Utilities.getDriver;

public class MLWalletTopUpGamesScripts extends BaseTest {

    @Test(priority = 1)
    public void topUpGamesHomePageValidation_TUG_TC_01() throws Exception {
        mlWalletTopUpGames.topUpGamesHomePageValidation_TUG_TC_01();
    }

    @Test(priority = 2)
    public void topUPGamesLoadSelectionScreenNavigation_TUG_TC_05() throws Exception {
        mlWalletTopUpGames.topUPGamesLoadSelectionScreenNavigation_TUG_TC_05();
    }

    @Test(priority = 3)
    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
        mlWalletTopUpGames.topUpGamesSuccessfulLoadTransaction_TUG_TC_06();
    }

    @Test(priority = 4)
    public void topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08() throws Exception {
        mlWalletTopUpGames.topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08();
    }



    @Test(priority = 5)
    public void topUPGamesTransactionDetailsPageNavigation_TUG_TC_09() throws Exception {
        mlWalletTopUpGames.topUPGamesTransactionDetailsPageNavigation_TUG_TC_09();
    }

    @Test(priority = 6)
    public void topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10() throws Exception {
        mlWalletTopUpGames.topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10();
    }

    @Test(priority = 7)
    public void topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11() throws Exception {
        mlWalletTopUpGames.topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11();
    }

    @Test(priority = 8)
    public void topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12() throws Exception {
        mlWalletTopUpGames.topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12();
    }

    @Test(priority = 9)
    public void topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13() throws Exception {
        mlWalletTopUpGames.topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13();
    }

    @Test(priority = 10)
    public void topUpGamesLandingPageNavigation_TUG_TC_14() throws Exception {
        mlWalletTopUpGames.topUpGamesLandingPageNavigation_TUG_TC_14();
    }
    @Test(priority = 11)
    public void topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15() throws Exception {
        mlWalletTopUpGames.topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15();
    }

    @Test(priority = 12)
    public void topUpGamesSaveToFavorites_TUG_TC_16() throws Exception {
        mlWalletTopUpGames.topUpGamesSaveToFavorites_TUG_TC_16();
    }

    @Test(priority = 13)
    public void topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17() throws Exception {
        mlWalletTopUpGames.topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17();
    }

    @Test(priority = 14)
    public void topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29() throws Exception {
        mlWalletTopUpGames.topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29();
    }

    @Test(priority = 15)
    public void topUpGamesRemoveFromFavorites_TUG_TC_18() throws Exception {
        mlWalletTopUpGames.topUpGamesRemoveFromFavorites_TUG_TC_18();
    }

    @Test(priority = 16)
    public void topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19() throws Exception {
        mlWalletTopUpGames.topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19();
    }


    @Test(priority = 17)
    public void topUpGamesTransactionWithInValidMLPin_TUG_TC_26() throws Exception {
        mlWalletTopUpGames.topUpGamesTransactionWithInValidMLPin_TUG_TC_26();
    }

    @Test(priority = 18)
    public void topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27() throws Exception {
        mlWalletTopUpGames.topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27();
    }

    @Test(priority = 19)
    public void topUpGamesRecentTransactionValidation_TUG_TC_28() throws Exception {
        mlWalletTopUpGames.topUpGamesRecentTransactionValidation_TUG_TC_28();
    }

    @Test(priority = 20)
    public void topUpGamesTransactionWithValidMLPin() throws Exception {
        mlWalletTopUpGames.topUpGamesTransactionWithValidMLPin();
    }

    @Test(priority = 21)
    public void topUpGamesMLPinPageNavigation_TUG_TC_23() throws Exception {
        mlWalletTopUpGames.topUpGamesMLPinPageNavigation_TUG_TC_23();
    }

    @Test(priority = 22)
    public void topUpGamesInAppOTPPopupNavigation_TUG_TC_20() throws Exception {
        mlWalletTopUpGames.topUpGamesInAppOTPPopupNavigation_TUG_TC_20();
    }


    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        getDriver().resetApp();
        System.out.println("Reset complete");
    }

}
