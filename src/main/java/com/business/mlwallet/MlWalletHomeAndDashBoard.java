package com.business.mlwallet;

import com.iosmlwalletpages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.business.mlwallet.MLWalletLogin.changeNumberPage;
import static com.business.mlwallet.MLWalletLogin.mlWalletLogin;
import static com.utility.ExtentReporter.*;
import static com.utility.Utilities.*;

public class MlWalletHomeAndDashBoard extends BaseClass{

    public MlWalletHomeAndDashBoard(){
        super();
    }
    public void verificationTierPerksPageValidation() throws Exception {
        verifyElementPresent(MLWalletHomePage.objMaxBalanceText,getTextVal(MLWalletHomePage.objMaxBalanceText,"Header"));
        verifyElementPresent(MLWalletHomePage.objMaxBalanceAmount,getTextVal(MLWalletHomePage.objMaxBalanceAmount,"Max Balance"));
        verifyElementPresent(MLWalletHomePage.objSendingLimitsCashOut,getTextVal(MLWalletHomePage.objSendingLimitsCashOut,"Header"));
        List<WebElement> values = findElements(MLWalletHomePage.objSendingLimitTransactionTypeAndAmount);
        for (int i = 0; i < values.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
        Swipe("UP",1);
        verifyElementPresent(MLWalletHomePage.objReceivingLimitsCashIn,getTextVal(MLWalletHomePage.objReceivingLimitsCashIn,"Header"));
        List<WebElement> values1 = findElements(MLWalletHomePage.objReceivingLimitsTransactionTypeAndAmount);
        for (int i = 0; i < values1.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values1.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values1.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
        Swipe("UP",1);
        verifyElementPresent(MLWalletHomePage.objPurchaseLimits,getTextVal(MLWalletHomePage.objPurchaseLimits,"Header"));
        List<WebElement> values2 = findElements(MLWalletHomePage.objPurchaseLimitsTransactionTypeAndAmount);
        for (int i = 0; i < values2.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values2.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values2.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
    }
    public void backArrowBtn(int nNumber) throws Exception {
        for (int i = 1; i <= nNumber; i++) {
            waitTime(3000);
            click(MLWalletSendTransferPage.objBackArrow, "Back Arrow Button");
            waitTime(2000);
        }
    }
    public void mlWalletHomePageUIValidation_HD_TC_01() throws Exception {
        HeaderChildNode("ML Wallet Home Page UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletHomePage.objAvailableBalanceHeader, getTextVal(MLWalletHomePage.objAvailableBalanceHeader, "Header"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
            verifyElementPresent(MLWalletHomePage.objAvailableBalance,getTextVal(MLWalletHomePage.objAvailableBalance,"Available Balance"));
            verifyElementPresent(MLWalletHomePage.objCashInIcon,getTextVal(MLWalletHomePage.objCashInIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objSendTransferIcon,getTextVal(MLWalletHomePage.objSendTransferIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objCashOutIcon,getTextVal(MLWalletHomePage.objCashOutIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objPayBillsIcon,getTextVal(MLWalletHomePage.objPayBillsIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objBuyELoadIcon,getTextVal(MLWalletHomePage.objBuyELoadIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objShopItemsIcon,getTextVal(MLWalletHomePage.objShopItemsIcon,"Options"));
            verifyElementPresent(MLWalletHomePage.objMLLoans,getTextVal(MLWalletHomePage.objMLLoans,"Options"));
            verifyElementPresent(MLWalletHomePage.objUseQR,getTextVal(MLWalletHomePage.objUseQR,"Options"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions,getTextVal(MLWalletHomePage.objRecentTransactions,"Header"));
            Swipe("UP",1);
            List<WebElement> values = findElements(MLWalletHomePage.objTransactions);

            for(int i=4 ; i<values.size(); i+=4){
                String sTransactionType = values.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            for(int i=2 ; i<values.size(); i+=4){
                String sAmount = values.get(i).getText();
                logger.info("Amount : " + sAmount + " is displayed");
                extentLogger(" ", "Amount : " + sAmount + " is displayed");
            }
            Swipe("UP",1);
            verifyElementPresent(MLWalletHomePage.objSeeMore,getTextVal(MLWalletHomePage.objSeeMore,"Button"));
            logger.info("HD_TC_01, ML Wallet Home Page UI Validated");
            extentLoggerPass("HD_TC_01", "HD_TC_01, ML Wallet Home Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletLogOutFromHomePage_HD_TC_02() throws Exception {
        HeaderChildNode("ML Wallet Logout from Home Page Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objHamburgerMenu,"Hamburger Menu");
        verifyElementPresentAndClick(MLWalletLogOutPage.objLogoutBtn,getTextVal(MLWalletLogOutPage.objLogoutBtn,"Button"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletLogOutPage.objPopUpLogoutBtn,getTextVal(MLWalletLogOutPage.objPopUpLogoutBtn,"Button on Popup"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletLogOutPage.objChangeNumber,getTextVal(MLWalletLogOutPage.objChangeNumber,"Page"))){
            logger.info("HD_TC_02, ML Wallet Application Logged out from Home Page Validated");
            extentLoggerPass("HD_TC_02", "HD_TC_02, ML Wallet Application Logged out from Home Page Validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void mlWalletSettingsNavigationFromHomePage_HD_TC_03() throws Exception {
        HeaderChildNode("ML Wallet Settings Navigation from Hom Page");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objProfileIcon1,"Profile Icon");
        explicitWaitVisibility(MLWalletHomePage.objSettings, 10);
        if(verifyElementPresent(MLWalletHomePage.objSettings,getTextVal(MLWalletHomePage.objSettings,"Page"))){
            verifyElementPresent(MLWalletHomePage.objAccountDetails,getTextVal(MLWalletHomePage.objAccountDetails,"Option"));
            verifyElementPresent(MLWalletHomePage.objChangeMLPin,getTextVal(MLWalletHomePage.objChangeMLPin,"Option"));
//							verifyElementPresent(MLWalletHomePage.objBiometricsLogin,getTextVal(MLWalletHomePage.objBiometricsLogin,"Option"));
            verifyElementPresent(MLWalletHomePage.objAccountRecovery,getTextVal(MLWalletHomePage.objAccountRecovery,"Option"));
            verifyElementPresent(MLWalletHomePage.objNotification,getTextVal(MLWalletHomePage.objNotification,"Option"));
            verifyElementPresent(MLWalletHomePage.objDeleteAccount,getTextVal(MLWalletHomePage.objDeleteAccount,"Option"));
            logger.info("HD_TC_03, ML Wallet Settings Navigation from Hom Page Validated");
            extentLoggerPass("HD_TC_03", "HD_TC_03, ML Wallet Settings Navigation from Hom Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHomePageEyeIconValidation_HD_TC_04() throws Exception {
        HeaderChildNode("ML Wallet Home Page Eye Icon Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        verifyElementPresent(MLWalletHomePage.objAvailableBalance,getTextVal(MLWalletHomePage.objAvailableBalance,"Available Balance"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        verifyElementPresent(MLWalletHomePage.objHiddenAvailableBalance,getTextVal(MLWalletHomePage.objHiddenAvailableBalance,"Available Balance"));
        logger.info("HD_TC_04, ML Wallet Home Page Eye Icon Validated");
        extentLoggerPass("HD_TC_04", "HD_TC_04, ML Wallet Home Page Eye Icon Validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void mlWalletAccountTierLevelVerification_HD_TC_05() throws Exception {
        HeaderChildNode("ML Wallet Account Tier Level Verification");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("New_BuyerTier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon,"i Icon");
        waitTime(4000);
        if(verifyElementPresent(MLWalletHomePage.objVerificationTierPerks,getTextVal(MLWalletHomePage.objVerificationTierPerks,"Page"))){
            verificationTierPerksPageValidation();
            logger.info("HD_TC_05, ML Wallet Account Tier Level Verification");
            extentLoggerPass("HD_TC_05", "HD_TC_05, ML Wallet Account Tier Level Verification");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHomePageRecentTransaction_HD_TC_06() throws Exception {
        HeaderChildNode("ML Wallet Home Page Recent Transaction validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions,getTextVal(MLWalletHomePage.objRecentTransactions,"Header"));
        Swipe("UP",1);
        List<WebElement> values = findElements(MLWalletHomePage.objTransactions);

        for(int i=4 ; i<values.size(); i+=4){
            String sTransactionType = values.get(i).getText();
            logger.info("Transaction Type : " + sTransactionType + " is displayed");
            extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
        }
        for(int i=2 ; i<values.size(); i+=4){
            String sAmount = values.get(i).getText();
            logger.info("Amount : " + sAmount + " is displayed");
            extentLogger(" ", "Amount : " + sAmount + " is displayed");
        }
        Swipe("UP",1);
        verifyElementPresent(MLWalletHomePage.objSeeMore,getTextVal(MLWalletHomePage.objSeeMore,"Button"));
        logger.info("HD_TC_06, ML Wallet Home Page Recent Transaction validated");
        extentLoggerPass("HD_TC_06", "HD_TC_06, ML Wallet Home Page Recent Transaction validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void mlWalletHomePageWithdrawCash_HD_TC_07() throws Exception {
        HeaderChildNode("ML Wallet Home Page WithDraw Cash");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objHamburgerMenu,"Hamburger Menu");
        explicitWaitVisibility(MLWalletHomePage.objTransaction, 10);
        verifyElementPresentAndClick(MLWalletHomePage.objTransaction,getTextVal(MLWalletHomePage.objTransaction,"Option"));
        verifyElementPresentAndClick(MLWalletHomePage.objWithdrawCash,getTextVal(MLWalletHomePage.objWithdrawCash,"Option"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletCashOutPage.objCashOutPage,getTextVal(MLWalletCashOutPage.objCashOutPage,"Page"))){
            logger.info("HD_TC_07, After clicking on Withdraw cash from Hamburger menu of Home Page, Application Navigated directly to CashOut Page is validated");
            extentLoggerPass("HD_TC_07", "HD_TC_07, After clicking on Withdraw cash from Hamburger menu of Home Page, Application Navigated directly to CashOut Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void mlWalletHomePageTopUpMLWallet_HD_TC_08() throws Exception {
        HeaderChildNode("ML Wallet Home Page Top Up ML Wallet");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objHamburgerMenu,"Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objTransaction,getTextVal(MLWalletHomePage.objTransaction,"Option"));
        verifyElementPresentAndClick(MLWalletHomePage.objTopUpMLWallet,getTextVal(MLWalletHomePage.objTopUpMLWallet,"Option"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletHomePage.objBranchCashIn,getTextVal(MLWalletHomePage.objBranchCashIn,"Page"))){
            logger.info("HD_TC_08, After clicking on Top Up ML Wallet from Hamburger menu of Home Page, Application Navigated directly to CashIn ML Branch Page is validated");
            extentLoggerPass("HD_TC_08", "HD_TC_08, After clicking on Top Up ML Wallet from Hamburger menu of Home Page, Application Navigated directly to CashIn ML Branch Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHomePageShopHD_TC_09() throws Exception {
        HeaderChildNode("ML Wallet Home Page Shop");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objHamburgerMenu,"Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objShop,getTextVal(MLWalletHomePage.objShop,"Option"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletHomePage.objMLShopPage,getTextVal(MLWalletHomePage.objMLShopPage,"Page"))){
            logger.info("HD_TC_09, After clicking on Shop from Hamburger menu of Home Page, Application Navigated directly ML Shop Page is validated");
            extentLoggerPass("HD_TC_09", "HD_TC_09, After clicking on Shop from Hamburger menu of Home Page, Application Navigated directly to ML Shop Page is validated");
            System.out.println("-----------------------------------------------------------");
            backArrowBtn(1);
        }
    }

    public void mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10() throws Exception {
        HeaderChildNode("ML Wallet Home Page Kwarta Padala Rates Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1,"Hamburger Menu");
        explicitWaitVisibility(MLWalletHomePage.objKwartaPadalaRatesBtn, 10);
        verifyElementPresentAndClick(MLWalletHomePage.objKwartaPadalaRatesBtn,"Kwarta Padala Rates");
        waitTime(2000);
        if (verifyElementPresent(MLWalletHomePage.objKwartaPadalaRates,"Kwarta Padala Rates")) {
            List<WebElement> values = findElements(MLWalletHomePage.objKwartaPadalaRates);
            for (int i = 0; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String sRates = values.get(i).getText();
                    logger.info("Rates : " + sRates + " is displayed");
                    extentLogger(" ", "Rates : " + sRates + " is displayed");
                }
                if (i % 2 == 0) {
                    String sAmountRange = values.get(i).getText();
                    logger.info("Amount Range : " + sAmountRange + " is displayed");
                    extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
                }
            }
            logger.info("HD_TC_10, ML Wallet Home Page Kwarta Padala Rates validated");
            extentLoggerPass("HD_TC_10", "HD_TC_10, ML Wallet Home Page Kwarta Padala Rates validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11() throws Exception {
        HeaderChildNode("ML Wallet Verification Tier Perks Navigation From Home Page Hamburger Menu");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1,"Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTier,getTextVal(MLWalletHomePage.objViewTier,"Option"));
        explicitWaitVisible(MLWalletHomePage.objVerificationTierPerks,10);
        if(verifyElementPresent(MLWalletHomePage.objVerificationTierPerks,getTextVal(MLWalletHomePage.objVerificationTierPerks,"Page"))){
            verificationTierPerksPageValidation();
            logger.info("HD_TC_11, ML Wallet Verification Tier Perks Navigation From Home Page Hamburger Menu Validated");
            extentLoggerPass("HD_TC_11", "HD_TC_11, ML Wallet Verification Tier Perks Navigation From Home Page Hamburger Menu Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletSupportPageNavigation_HD_TC_12() throws Exception {
        HeaderChildNode("ML Wallet Support page Navigation From Home Page Hamburger Menu");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1,"Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objSupport,getTextVal(MLWalletHomePage.objSupport,"Option"));
        explicitWaitVisible(MLWalletHomePage.objTroubleSingingInPAge,20);
        if(verifyElementPresent(MLWalletHomePage.objTroubleSingingInPAge,getTextVal(MLWalletHomePage.objTroubleSingingInPAge,"Page"))){
            logger.info("HD_TC_12, After clicking on support Button on Hamburger menu, Application Navigated to Trouble Signing In Page");
            extentLoggerPass("HD_TC_12", "HD_TC_12, After clicking on support Button on Hamburger menu, Application Navigated to Trouble Signing In Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletAboutPageNavigation_HD_TC_13() throws Exception {
        HeaderChildNode("ML Wallet About page Navigation From Home Page Hamburger Menu");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1,"Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objAbout,getTextVal(MLWalletHomePage.objAbout,"Option"));
        explicitWaitVisible(MLWalletHomePage.objAbout,20);
        if(verifyElementPresent(MLWalletHomePage.objAbout,getTextVal(MLWalletHomePage.objAbout,"Page"))){
            logger.info("HD_TC_13, After clicking on About Button on Hamburger menu, Application Navigated to About Page");
            extentLoggerPass("HD_TC_13", "HD_TC_13, After clicking on About Button on Hamburger menu, Application Navigated to About Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14() throws Exception {
        HeaderChildNode("ML Wallet Verification Tier Perks Validation By logging as Semi-verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTierSemiVerified, getTextVal(MLWalletHomePage.objViewTierSemiVerified, "Option"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objSemiVerified,getTextVal(MLWalletHomePage.objSemiVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            verifyElementPresentAndClick(MLWalletHomePage.objBranchVerified,getTextVal(MLWalletHomePage.objBranchVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            verifyElementPresentAndClick(MLWalletHomePage.objFullyVerified,getTextVal(MLWalletHomePage.objFullyVerified,"Tier Button"));
            explicitWaitVisibility(MLWalletHomePage.objTier, 10);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_14, ML Wallet Verification Tier Perks Validation By logging as Semi-verified User Validated");
            extentLoggerPass("HD_TC_14", "HD_TC_14, ML Wallet Verification Tier Perks Validation By logging as Semi-verified User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15() throws Exception {
        HeaderChildNode("ML Wallet Verification Tier Perks Validation By logging as Fully-verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTierFullyVerified, getTextVal(MLWalletHomePage.objViewTierFullyVerified, "Option"));
        explicitWaitVisible(MLWalletHomePage.objVerificationTierPerks,10);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            Swipe("Left",1);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            Swipe("Left",1);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_15, ML Wallet Verification Tier Perks Validation By logging as Fully-verified User Validated");
            extentLoggerPass("HD_TC_15", "HD_TC_15, ML Wallet Verification Tier Perks Validation By logging as Fully-verified User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16() throws Exception {
        HeaderChildNode("ML Wallet Verification All Tier Perks Validation By logging as Semi-verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTier, getTextVal(MLWalletHomePage.objViewTier, "Option"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objSemiVerified,getTextVal(MLWalletHomePage.objSemiVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            verifyElementPresentAndClick(MLWalletHomePage.objBranchVerified,getTextVal(MLWalletHomePage.objBranchVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            verifyElementPresentAndClick(MLWalletHomePage.objFullyVerified,getTextVal(MLWalletHomePage.objFullyVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_16, ML Wallet Verification All Tier Perks Validation By logging as Semi-verified User Validated");
            extentLoggerPass("HD_TC_16", "HD_TC_16, ML Wallet Verification All Tier Perks Validation By logging as Semi-verified User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17() throws Exception {
        HeaderChildNode("ML Wallet Verification Tier Perks Validation By logging as Branch-verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTierBranchVerified, getTextVal(MLWalletHomePage.objViewTierBranchVerified, "Option"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_17, ML Wallet Verification Tier Perks Validation By logging as Branch-verified User Validated");
            extentLoggerPass("HD_TC_17", "HD_TC_17, ML Wallet Verification Tier Perks Validation By logging as Branch-verified User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18() throws Exception {
        HeaderChildNode("ML Wallet Verification Tier Perks Validation By logging as Buyer Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("New_BuyerTier"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objViewTierBuyierTierVerified, getTextVal(MLWalletHomePage.objViewTierBuyierTierVerified, "Option"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objSemiVerified,getTextVal(MLWalletHomePage.objSemiVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            verifyElementPresentAndClick(MLWalletHomePage.objBranchVerified,getTextVal(MLWalletHomePage.objBranchVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            verifyElementPresentAndClick(MLWalletHomePage.objFullyVerified,getTextVal(MLWalletHomePage.objFullyVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_18, ML Wallet Verification Tier Perks Validation By logging as Buyer Tier User Validated");
            extentLoggerPass("HD_TC_18", "HD_TC_18, ML Wallet Verification Tier Perks Validation By logging as Buyer Tier  User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19() throws Exception {
        HeaderChildNode("ML Wallet Hamburger Menu Transaction button validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletHomePage.objTransaction,getTextVal(MLWalletHomePage.objTransaction,"Option"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletHomePage.objWithdrawCash,getTextVal(MLWalletHomePage.objWithdrawCash,"Option"))){
            verifyElementPresent(MLWalletHomePage.objTopUpMLWallet,getTextVal(MLWalletHomePage.objTopUpMLWallet,"Option"));
            logger.info("HD_TC_19, After clicking on Transactions option, Withdraw Cash and TopUp Ml Wallet options are displayed");
            extentLoggerPass("HD_TC_19", "HD_TC_19, After clicking on Transactions option, Withdraw Cash and TopUp Ml Wallet options are displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHomePageIIconValidationAsBranchVerifiedTierUser_HD_TC_20() throws Exception {
        HeaderChildNode("ML Wallet Home Page I Icon Validation as Branch verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(2000);
        verifyElementNotPresent(MLWalletHomePage.objVerificationTierPerks,"Verification tier perk",5);
        logger.info("HD_TC_20, ML Wallet Home Page I Icon not displayed For Branch-verified Tier user");
        extentLoggerPass("HD_TC_20", "HD_TC_20, ML Wallet Home Page I Icon not displayed For Fully-verified Tier user");
        System.out.println("-----------------------------------------------------------");
    }


    public void mlWalletHomePageIIconValidationAsBuyerTierUser_HD_TC_21() throws Exception {
        HeaderChildNode("ML Wallet Home Page I Icon Validation as BuyerTier verified User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("New_BuyerTier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(3000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objSemiVerified,getTextVal(MLWalletHomePage.objSemiVerified,"Tier Button"));
            waitTime(2000);
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            verifyElementPresentAndClick(MLWalletHomePage.objBranchVerified,getTextVal(MLWalletHomePage.objBranchVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            verifyElementPresentAndClick(MLWalletHomePage.objFullyVerified,getTextVal(MLWalletHomePage.objFullyVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();
            logger.info("HD_TC_21,ML Wallet Home Page I Icon Validated as BuyerTier verified User");
            extentLoggerPass("HD_TC_21", "HD_TC_21, ML Wallet Home Page I Icon Validated as BuyerTier verified User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22() throws Exception {
        HeaderChildNode("ML Wallet Home Page I Icon Validation as Semi verified Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(3000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresentAndClick(MLWalletHomePage.objSemiVerified,getTextVal(MLWalletHomePage.objSemiVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            verifyElementPresentAndClick(MLWalletHomePage.objBranchVerified,getTextVal(MLWalletHomePage.objBranchVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            verifyElementPresentAndClick(MLWalletHomePage.objFullyVerified,getTextVal(MLWalletHomePage.objFullyVerified,"Tier Button"));
            verifyElementPresent(MLWalletHomePage.objTier,getTextVal(MLWalletHomePage.objTier,"Header"));
            verificationTierPerksPageValidation();

            logger.info("HD_TC_22, ML Wallet Home Page I Icon Validated as Semi verified Tier User");
            extentLoggerPass("HD_TC_22", "HD_TC_22, ML Wallet Home Page I Icon Validated as Semi verified Tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23() throws Exception {
        HeaderChildNode("ML Wallet Home Page I Icon Validation as Fully verified Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        if(verifyElementNotPresent(MLWalletHomePage.objIIcon,"i icon",5)){
            logger.info("HD_TC_23, ML Wallet Home Page I Icon not displayed For Fully-verified Tier user");
            extentLoggerPass("HD_TC_23", "HD_TC_23, ML Wallet Home Page I Icon not displayed For Fully-verified Tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24() throws Exception {
        HeaderChildNode("ML Wallet Home Page Do you have another Account Button functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objDoYouHaveAnotherAccBtn,getTextVal(MLWalletHomePage.objDoYouHaveAnotherAccBtn,"button"));
        if(verifyElementPresent(MLWalletHomePage.objAddAccFacility,getTextVal(MLWalletHomePage.objAddAccFacility,"Page"))){
            logger.info("HD_TC_24, ML Wallet Home Page Do you have another Account Button functionality validated");
            extentLoggerPass("HD_TC_24", "HD_TC_24, ML Wallet Home Page Do you have another Account Button functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
