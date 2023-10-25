package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletEloadPage;
import com.iosmlwalletpages.MLWalletLoginPage;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.business.mlwallet.MLWalletLogin.mlWalletLogin;
import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

public class MLWalletBuyELoad extends BaseClass{

    public MLWalletBuyELoad(){
        super();
    }

    public void eLoad_generic(String sTier,String mobileNo, String status, int telcoOption) throws Exception
    {
        waitTime(3000);
        changeNumberPage();
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(5000);
        if(status.equals("true")) {
            verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, "eLoad Transaction Page");
            click(MLWalletEloadPage.telcoOptions(telcoOption),"Telco");
        }
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        explicitWaitVisible(MLWalletEloadPage.objNextBtn,10);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
        waitTime(5000);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
    }
    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad Second time Load selection popup validation");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresentAndClick(MLWalletEloadPage.objBuyLoadBackArrowBtn, "Buy Load Back Arrow Button");
        waitTime(3000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletEloadPage.objSecondTimeConfirmationPopup, getTextVal(MLWalletEloadPage.objSecondTimeConfirmationPopup, "Popup"))) {
            logger.info("BE_TC_29, Buy ELoad Second time Load selection popup validated");
            extentLoggerPass("BE_TC_29", "BE_TC_29, Buy ELoad Second time Load selection popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum transaction for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objLDLoad2000, getTextVal(MLWalletEloadPage.objLDLoad2000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        enterOTP("111111");
        waitTime(10000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_45, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            extentLoggerPass("BE_TC_45", "BE_TC_45, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_48(String sTier, int promotab) throws Exception {
        HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("GLOBE"), "true", promotab);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 2);
        click(MLWalletEloadPage.objLDLoad3000, getTextVal(MLWalletEloadPage.objLDLoad3000, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            extentLoggerPass("BE_TC_45", "BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
