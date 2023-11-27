package com.business.mlwallet;

import com.iosmlwalletpages.*;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;

public class MLWalletTopUpGames extends BaseClass{

    public MLWalletTopUpGames(){
            super();
    }

    public void topUpGamesHomePageNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objTopUpGames,getTextVal(MLWalletTopUpGamesPages.objTopUpGames,"Icon"));
        verifyElementPresent(MLWalletTopUpGamesPages.objTopGamesPage,"TopUp Games Page");
    }
    public void selectGameAndLoadType() throws Exception {
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objValorant,getTextVal(MLWalletTopUpGamesPages.objValorant,"Game"));
        waitTime(4000);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objBuyPHP149,getTextVal(MLWalletTopUpGamesPages.objBuyPHP149,"Load Type"));
    }
    public void inputRequiredDataAndContinue() throws Exception {
        type(MLWalletTopUpGamesPages.objGameUserID,prop.getproperty("GameUserID"),"Game User ID Input Field");
        type(MLWalletTopUpGamesPages.objEmailAddress,prop.getproperty("Email"),"Email ID Input Field");
        type(MLWalletTopUpGamesPages.objMobileNumber,prop.getproperty("GameMobileNumber"),"Mobile Number");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objContinue,getTextVal(MLWalletTopUpGamesPages.objContinue,"Button"));
        click(MLWalletTopUpGamesPages.objContinue,getTextVal(MLWalletTopUpGamesPages.objContinue,"Button"));
    }

    public void topUpGamesHomePageValidation_TUG_TC_01() throws Exception {
        HeaderChildNode("TopUp Games Home Page Validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        for(int i=1;i<4;i++){
            verifyElementPresent(MLWalletTopUpGamesPages.objGames(i),getTextVal(MLWalletTopUpGamesPages.objGames(i),"Games"));
        }
        for(int j=1;j<4;j++){
            verifyElementPresent(MLWalletTopUpGamesPages.objGames1(j),getTextVal(MLWalletTopUpGamesPages.objGames1(j),"Games"));
        }
        logger.info("TUG_TC_01, TopUp Games Home Page validated");
        extentLoggerPass("TUG_TC_01", "TUG_TC_01, TopUp Games Home Page validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUPGamesLoadSelectionScreenNavigation_TUG_TC_05() throws Exception {
        HeaderChildNode("TopUp Games Load Selection Screen Navigation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objValorant, getTextVal(MLWalletTopUpGamesPages.objValorant, "Game"));
        waitTime(4000);
        for (int i = 1; i <= 12; i++) {
            if (i % 2 != 0) {
                verifyElementPresent(MLWalletTopUpGamesPages.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGamesPages.objLoadTypeAndPoints(i), "Load Type and Points"));
            }
        }
        logger.info("TUG_TC_05, TopUp Games Load Selection Screen navigation validated");
        extentLoggerPass("TUG_TC_05", "TUG_TC_05, TopUp Games Load Selection Screen navigation validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
        HeaderChildNode("TopUp Games successful Load Transaction");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        String sAvailableBalance = getText(MLWalletTopUpGamesPages.objAvailableBalance);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objTopUpGames,getTextVal(MLWalletTopUpGamesPages.objTopUpGames,"Icon"));
        verifyElementPresent(MLWalletTopUpGamesPages.objTopGamesPage,"TopUp Games Page");
        waitTime(5000);
        selectGameAndLoadType();
        waitTime(5000);
        inputRequiredDataAndContinue();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"));
        verifyElementPresent(MLWalletTopUpGamesPages.objTransactionCode,getTextVal(MLWalletTopUpGamesPages.objTransactionCode,"Transaction Code"));
        verifyElementPresent(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails,"Game User ID"));
        verifyElementPresent(MLWalletTopUpGamesPages.objRedeemCode,getTextVal(MLWalletTopUpGamesPages.objRedeemCode,"Redeem code"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objBackToHome,getTextVal(MLWalletTopUpGamesPages.objBackToHome,"Button"));
        waitTime(5000);
        String sAvailableBalanceAfterTopUp = getText(MLWalletTopUpGamesPages.objAvailableBalance);
        assertNotEquals(sAvailableBalance,sAvailableBalanceAfterTopUp);
        logger.info("TUG_TC_06, TopUp Games successful Load Transaction validated");
        extentLoggerPass("TUG_TC_06", "TUG_TC_06, TopUp Games successful Load Transaction validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08() throws Exception {
        HeaderChildNode("TopUp Games Load Selection Page Load Types Validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objValorant,getTextVal(MLWalletTopUpGamesPages.objValorant,"Game"));
        waitTime(4000);
        for (int i = 1; i <= 12; i++) {
            if (i % 2 != 0) {
                verifyElementPresent(MLWalletTopUpGamesPages.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGamesPages.objLoadTypeAndPoints(i), "Load Type and Points"));
            }
        }
        logger.info("TUG_TC_08, TopUp Games Load Selection Page Load Types Validation validated");
        extentLoggerPass("TUG_TC_08", "TUG_TC_08, TopUp Games Load Selection Page Load Types validated");
        System.out.println("-----------------------------------------------------------");
    }
    public void topUPGamesTransactionDetailsPageNavigation_TUG_TC_09() throws Exception {
        HeaderChildNode("TopUp Games Transaction Details Page Navigation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"))){
            logger.info("TUG_TC_09, TopUp Games Transaction Details Page navigation validated");
            extentLoggerPass("TUG_TC_09", "TUG_TC_09, TopUp Games Transaction Details Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10() throws Exception {
        HeaderChildNode("TopUp Games Game ID Required Error Message validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        waitTime(3000);
        selectGameAndLoadType();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objContinue,getTextVal(MLWalletTopUpGamesPages.objContinue,"Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objGameIDRequiredMsg,getTextVal(MLWalletTopUpGamesPages.objGameIDRequiredMsg,"Error Message"))){
            String sActualErrorMsg = getText(MLWalletTopUpGamesPages.objGameIDRequiredMsg);
            String sExceptedErrorMsg = "Game ID is required";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("TUG_TC_10, TopUp Games Game ID Required Error Message validated");
            extentLoggerPass("TUG_TC_10", "TUG_TC_10, TopUp Games Game ID Required Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11() throws Exception {
        HeaderChildNode("TopUp Games Email Address Required Error Message validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGamesPages.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        click(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objEmailRequiredMsg,getTextVal(MLWalletTopUpGamesPages.objEmailRequiredMsg,"Error Message"))){
            String sActualErrorMsg = getText(MLWalletTopUpGamesPages.objEmailRequiredMsg);
            String sExceptedErrorMsg = "Email address is required";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("TUG_TC_11, TopUp Games Email Address Required Error Message validated");
            extentLoggerPass("TUG_TC_11", "TUG_TC_11, TopUp Games Email Address Required Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12() throws Exception {
        HeaderChildNode("TopUp Games Email Address invalid Error Message validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGamesPages.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        type(MLWalletTopUpGamesPages.objEmailAddress,prop.getproperty("Invalid_Email_Address"),"Email ID Input Field");
        click(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objEmailAddressInvalidMsg,getTextVal(MLWalletTopUpGamesPages.objEmailAddressInvalidMsg,"Error Message"))){
            String sActualErrorMsg = getText(MLWalletTopUpGamesPages.objEmailAddressInvalidMsg);
            String sExceptedErrorMsg = "Email address is invalid";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            logger.info("TUG_TC_12, TopUp Games Email Address invalid Error Message validated");
            extentLoggerPass("TUG_TC_12", "TUG_TC_12, TopUp Games Email Address invalid Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13() throws Exception {
        HeaderChildNode("TopUp Games Mobile Number invalid Error Message validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGamesPages.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        type(MLWalletTopUpGamesPages.objEmailAddress,prop.getproperty("Email"),"Email ID Input Field");
        type(MLWalletTopUpGamesPages.objMobileNumber,prop.getproperty("Invalid_MobileNumber"),"Mobile Number");
        click(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objContinue, getTextVal(MLWalletTopUpGamesPages.objContinue, "Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objMobileNumberInvalidMsg,getTextVal(MLWalletTopUpGamesPages.objMobileNumberInvalidMsg,"Error Message"))) {
            String sActualErrorMsg = getText(MLWalletTopUpGamesPages.objMobileNumberInvalidMsg);
            String sExceptedErrorMsg = "Mobile number is invalid";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_13, TopUp Games Mobile Number invalid Error Message validated");
            extentLoggerPass("TUG_TC_13", "TUG_TC_13, TopUp Games Mobile Number invalid Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void topUpGamesLandingPageNavigation_TUG_TC_14() throws Exception {
        HeaderChildNode("TopUp Games Landing Page navigation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objTopUpGames,getTextVal(MLWalletTopUpGamesPages.objTopUpGames,"Icon"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTopGamesPage,"TopUp Games Page")){
            logger.info("TUG_TC_14, TopUp Games Landing Page navigation validated");
            extentLoggerPass("TUG_TC_14", "TUG_TC_14, TopUp Games Landing Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15() throws Exception {
        HeaderChildNode("TopUp Games Transaction Details page UI navigation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"))){
            verifyElementPresent(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails,"Game User ID"));
            verifyElementPresent(MLWalletTopUpGamesPages.objMobileNumberInTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objMobileNumberInTransactionDetails,"Mobile Number"));
            verifyElementPresent(MLWalletTopUpGamesPages.objEmailInTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objEmailInTransactionDetails,"Email Address"));
            verifyElementPresent(MLWalletTopUpGamesPages.objAmountInTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objAmountInTransactionDetails,"Amount"));
            verifyElementPresent(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"Button"));
            logger.info("TUG_TC_15, TopUp Games Transaction Details page UI navigation validated");
            extentLoggerPass("TUG_TC_15", "TUG_TC_15, TopUp Games Transaction Details page UI navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesSaveToFavorites_TUG_TC_16() throws Exception {
        HeaderChildNode("TopUp Games Save To Favorites");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objSaveToMyFavorite,getTextVal(MLWalletTopUpGamesPages.objSaveToMyFavorite,"Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objAddToFavoritesMsg,getTextVal(MLWalletTopUpGamesPages.objAddToFavoritesMsg,"PopUp"))){
            verifyElementPresent(MLWalletTopUpGamesPages.objOkButton,getTextVal(MLWalletTopUpGamesPages.objOkButton,"Button"));
            logger.info("TUG_TC_16, TopUp Games Save To Favorites validated");
            extentLoggerPass("TUG_TC_16", "TUG_TC_16, TopUp Games Save To Favorites validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17() throws Exception {
        HeaderChildNode("TopUp Games Recipient Already Saved Message validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objSaveToMyFavorite,getTextVal(MLWalletTopUpGamesPages.objSaveToMyFavorite,"Button"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objDuplicateFavorites,getTextVal(MLWalletTopUpGamesPages.objDuplicateFavorites,"PopUp"))){
            verifyElementPresent(MLWalletTopUpGamesPages.objOkButton,getTextVal(MLWalletTopUpGamesPages.objOkButton,"Button"));
            logger.info("TUG_TC_17, TopUp Games Recipient Already Saved Message validated");
            extentLoggerPass("TUG_TC_17", "TUG_TC_17, TopUp Games Recipient Already Saved Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesRemoveFromFavorites_TUG_TC_18() throws Exception {
        HeaderChildNode("TopUp Games remove from favorites");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        type(MLWalletTopUpGamesPages.objSearchFavField,prop.getproperty("GameMobileNumber"),"Game User ID Input Field");
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objHamburgerMenu,"Hamburger menu");
        click(MLWalletTopUpGamesPages.objHamburgerMenu,"Hamburger menu");
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objRemoveBtn,getTextVal(MLWalletTopUpGamesPages.objRemoveBtn,"Button"));
//        verifyElementNotPresent(MLWalletTopUpGamesPages.objFavoriteRecipient,5);
        logger.info("TUG_TC_18, TopUp Games Recipient successfully removed from favorites validated");
        extentLoggerPass("TUG_TC_18", "TUG_TC_18, TopUp Games Recipient successfully removed from favorites validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19() throws Exception {
        HeaderChildNode("TopUp Games Transaction Validation in Transaction History");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletHomePage.objSeeMore,getTextVal(MLWalletHomePage.objSeeMore,"Button"));
        scroll_To_Text_Horizontal(MLWalletTopUpGamesPages.objTopUpGamesBtn,"name","Top Up Games");
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransaction, "First Transaction");
        if(verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails,getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails,"Page"))){
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails,getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails,"Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo,getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo,"Receiver Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod,getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod,"Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objLoadType,getTextVal(MLWalletTransactionHistoryPage.objLoadType,"Load Type"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objRedeemCode,getTextVal(MLWalletTransactionHistoryPage.objRedeemCode,"Redeem Code"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount,getTextVal(MLWalletTransactionHistoryPage.objAmount,"Amount To Send"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee,getTextVal(MLWalletTransactionHistoryPage.objServiceFee,"Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount,getTextVal(MLWalletTransactionHistoryPage.objTotalAmount,"Total Amount"));
            logger.info("TUG_TC_19, TopUp Games Transaction Validated in Transaction History");
            extentLoggerPass("TUG_TC_19", "TUG_TC_19, TopUp Games Transaction Validated in Transaction History");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27() throws Exception {
        HeaderChildNode("TopUp Games TopUp Again Functionality After First Successful Transaction");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objTopUpAgainBtn,getTextVal(MLWalletTopUpGamesPages.objTopUpAgainBtn,"Button"));
        waitTime(6000);
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"))) {
            verifyElementPresent(MLWalletTopUpGamesPages.objTransactionCode, getTextVal(MLWalletTopUpGamesPages.objTransactionCode, "Transaction Code"));
            verifyElementPresent(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails, "Game User ID"));
            verifyElementPresent(MLWalletTopUpGamesPages.objRedeemCode, getTextVal(MLWalletTopUpGamesPages.objRedeemCode, "Redeem code"));
            logger.info("TUG_TC_27, TopUp Games TopUp Again Functionality After First Successful Transaction validated");
            extentLoggerPass("TUG_TC_27", "TUG_TC_27, TopUp Games TopUp Again Functionality After First Successful Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void topUpGamesRecentTransactionValidation_TUG_TC_28() throws Exception {
        HeaderChildNode("Top Up Games Recent Transaction Validation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objBackToHome,getTextVal(MLWalletTopUpGamesPages.objBackToHome,"Button"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions,getTextVal(MLWalletHomePage.objRecentTransactions,"Header"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTopUpGamesTransaction,getTextVal(MLWalletTopUpGamesPages.objTopUpGamesTransaction,"Transaction"))){
            logger.info("TUG_TC_28, Top Up Games Recent Transaction Validation");
            extentLoggerPass("TUG_TC_28", "TUG_TC_28, Top Up Games Recent Transaction Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29() throws Exception {
        HeaderChildNode("TopUp Games Select recipient with saved favorites");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        click(MLWalletTopUpGamesPages.objMyFavorites,getTextVal(MLWalletTopUpGamesPages.objMyFavorites,"Button"));
        type(MLWalletTopUpGamesPages.objSearchFavField,prop.getproperty("GameMobileNumber"),"Game User ID Input Field");
        click(MLWalletTopUpGamesPages.objFavoriteRecipient,getTextVal(MLWalletTopUpGamesPages.objFavoriteRecipient,"Favorite Recipient"));
        if(verifyElementPresent(MLWalletTopUpGamesPages.objBuyPHP149,"Load Selection Page")){
            logger.info("TUG_TC_29, TopUp Games Select recipient with saved favorites validated");
            extentLoggerPass("TUG_TC_29", "TUG_TC_29, Top Up Games Recent Transaction Validation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void topUpGamesTransactionWithValidMLPin() throws Exception {
        HeaderChildNode("TopUp Games Transaction with Valid MLPin");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        handleMpin("1111", "Entered Mpin");
        if(verifyElementPresent(MLWalletTopUpGamesPages.objTransactionDetails,getTextVal(MLWalletTopUpGamesPages.objTransactionDetails,"Page"))) {
            verifyElementPresent(MLWalletTopUpGamesPages.objTransactionCode, getTextVal(MLWalletTopUpGamesPages.objTransactionCode, "Transaction Code"));
            verifyElementPresent(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGamesPages.objGameUserIDInTransactionDetails, "Game User ID"));
            verifyElementPresent(MLWalletTopUpGamesPages.objRedeemCode, getTextVal(MLWalletTopUpGamesPages.objRedeemCode, "Redeem code"));
        }
        logger.info("TUG_TC_, TopUp Games Transaction with Valid MLPin validated");
        extentLoggerPass("TUG_TC_", "TUG_TC_, TopUp Games Transaction with Valid MLPin validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUpGamesTransactionWithInValidMLPin_TUG_TC_26() throws Exception {
        HeaderChildNode("TopUp Games Transaction with InValid MLPin");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        handleMpin(prop.getproperty("wrongMpin"),"Invalid MLPin");
        if (verifyElementPresent(MLWalletCashInViaBranchPage.objInvalidPINMsg, getTextVal(MLWalletCashInViaBranchPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInViaBranchPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_26, TopUp Games Transaction with InValid MLPin validated");
            extentLoggerPass("TUG_TC_26", "TUG_TC_26, TopUp Games Transaction with Valid MLPin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesMLPinPageNavigation_TUG_TC_23() throws Exception {
        HeaderChildNode("TopUp Games ML Pin Page Navigation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletTopUpGamesPages.objMLPinEditField,"ML Pin Edit Field")){
            logger.info("TUG_TC_23, TopUp Games ML Pin Page navigation validated");
            extentLoggerPass("TUG_TC_23", "TUG_TC_23, TopUp Games ML Pin Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesInAppOTPPopupNavigation_TUG_TC_20() throws Exception {
        HeaderChildNode("TopUp Games InApp popup navigation");
        waitTime(2000);
        changeNumberPage();
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGamesPages.objConfirm,getTextVal(MLWalletTopUpGamesPages.objConfirm,"button"));
        waitTime(5000);
        if(verifyElementPresent(MLWalletLoginPage.objOneTimePin,getTextVal(MLWalletLoginPage.objOneTimePin,"Popup"))){
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"OTP Generated"));
            logger.info("TUG_TC_20, TopUp Games InApp popup navigation validated");
            extentLoggerPass("TUG_TC_20", "TUG_TC_20, TopUp Games InApp popup navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
