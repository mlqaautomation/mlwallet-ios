package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletBranchLocatorPage;
import com.iosmlwalletpages.MLWalletLoginPage;
import com.iosmlwalletpages.MLWalletShopItemsPage;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

public class MLWalletBranchLocator extends BaseClass{

    public MLWalletBranchLocator(){
        super();
    }

//===========================================================================================================//
public void branchLocatorNavigation() throws Exception {
    if(verifyElementPresentAndClick(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Button"))){
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"));
        logger.info("Navigated to Branch Locator page");
    }else{
        logger.info("Not Navigated to Branch Locator Page");
    }
}
    public void homePageNavigation() throws Exception {
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objHome, getTextVal(MLWalletBranchLocatorPage.objHome, "Option"));
        waitTime(8000);
    }

    public void branchLocatorPageValidation() throws Exception {
        explicitWaitVisibility(MLWalletBranchLocatorPage.objSearchBranch, 10);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objSearchBranch,getTextVal(MLWalletBranchLocatorPage.objSearchBranch,"Header"))) {
            verifyElementPresent(MLWalletBranchLocatorPage.obj24HoursOnly, getTextVal(MLWalletBranchLocatorPage.obj24HoursOnly, "Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objSearchBranchField, "Search Branch Input Field");
            verifyElementPresent(MLWalletBranchLocatorPage.objLuzon, getTextVal(MLWalletBranchLocatorPage.objLuzon, "Button"));
            click(MLWalletBranchLocatorPage.objLuzon, getTextVal(MLWalletBranchLocatorPage.objLuzon, "Button"));
            verifyElementPresent(MLWalletBranchLocatorPage.objVisayas, getTextVal(MLWalletBranchLocatorPage.objVisayas, "Button"));
            verifyElementPresent(MLWalletBranchLocatorPage.objMindanao, getTextVal(MLWalletBranchLocatorPage.objMindanao, "Button"));
            verifyElementPresent(MLWalletBranchLocatorPage.objMLUS, getTextVal(MLWalletBranchLocatorPage.objMLUS, "Button"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletBranchLocatorPage.objBranchesNearYou, getTextVal(MLWalletBranchLocatorPage.objBranchesNearYou, "Map Header"));
        }
    }
//======================================================================================================//

    public void branchLocatorNavigationFromMPinPage_BL_TC_01() throws Exception {
        HeaderChildNode("Branch Locator Page Navigation from MPin Page and UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        if(verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"))){
            branchLocatorPageValidation();
            logger.info("BL_TC_01, Branch Locator Page Navigation from MPin Page and UI Validated");
            extentLoggerPass("BL_TC_01","BL_TC_01, Branch Locator Page Navigation from MPin Page and UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorNavigationFromLogInPage_BL_TC_02() throws Exception {
        HeaderChildNode("Branch Locator page Navigation From Login Page and UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        if(verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"))){
            branchLocatorPageValidation();
            logger.info("BL_TC_02, Branch Locator Page Navigation from Login Page and UI Validated");
            extentLoggerPass("BL_TC_02","BL_TC_02, Branch Locator Page Navigation from Login Page and UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorHamburgerFunctionality_BL_TC_05() throws Exception {
        HeaderChildNode("Branch Locator Hamburger Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objHome,getTextVal(MLWalletBranchLocatorPage.objHome,"Option"))){
            verifyElementPresent(MLWalletBranchLocatorPage.objBranches,getTextVal(MLWalletBranchLocatorPage.objBranches,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objProductAndServices,getTextVal(MLWalletBranchLocatorPage.objProductAndServices,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objPromos,getTextVal(MLWalletBranchLocatorPage.objPromos,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objBlog,getTextVal(MLWalletBranchLocatorPage.objBlog,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objNewsLetters,getTextVal(MLWalletBranchLocatorPage.objNewsLetters,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objMLUSBtn,getTextVal(MLWalletBranchLocatorPage.objMLUSBtn,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objFAQ,getTextVal(MLWalletBranchLocatorPage.objFAQ,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objCareers,getTextVal(MLWalletBranchLocatorPage.objCareers,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objLogin,getTextVal(MLWalletBranchLocatorPage.objLogin,"Option"));
            verifyElementPresent(MLWalletBranchLocatorPage.objDownloadApp,getTextVal(MLWalletBranchLocatorPage.objDownloadApp,"Option"));
            logger.info("BL_TC_05, Branch Locator Hamburger Button Functionality Validated");
            extentLoggerPass("BL_TC_05","BL_TC_05, Branch Locator Hamburger Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBranchesButtonFunctionality_BL_TC_07() throws Exception {
        HeaderChildNode("Branch Locator Branches Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranches,getTextVal(MLWalletBranchLocatorPage.objBranches,"Option"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"))){
            branchLocatorPageValidation();
            logger.info("BL_TC_07, Branch Locator Branches Button Functionality validated");
            extentLoggerPass("BL_TC_07","BL_TC_07, Branch Locator Branches Button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorPromosFunctionality_BL_TC_08() throws Exception {
        HeaderChildNode("Branch Locator Promos Button Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objPromos,getTextVal(MLWalletBranchLocatorPage.objPromos,"Option"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objPromos,getTextVal(MLWalletBranchLocatorPage.objPromos,"Page"))){
            logger.info("BL_TC_08, Branch Locator Promos Button Functionality validated and App Navigated to Promos Page");
            extentLoggerPass("BL_TC_08","BL_TC_08, Branch Locator Promos Button Functionality validated and App Navigated to Promos Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBlogFunctionality_BL_TC_09() throws Exception {
        HeaderChildNode("Branch Locator Blog Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBlog,getTextVal(MLWalletBranchLocatorPage.objBlog,"Option"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objBlog,getTextVal(MLWalletBranchLocatorPage.objBlog,"Page"))){
            logger.info("BL_TC_09, Branch Locator Blog Button Functionality validated and App Navigated to Blog Page");
            extentLoggerPass("BL_TC_09","BL_TC_09, Branch Locator Blog Button Functionality validated and App Navigated to Blog Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorNewsLettersFunctionality_BL_TC_10() throws Exception {
        HeaderChildNode("Branch Locator NewsLetter Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objNewsLetters,getTextVal(MLWalletBranchLocatorPage.objNewsLetters,"Option"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objNewsLetters,getTextVal(MLWalletBranchLocatorPage.objNewsLetters,"Page"))) {
            logger.info("BL_TC_10, Branch Locator NewsLetter Button Functionality validated and App Navigated to NewsLetter Page");
            extentLoggerPass("BL_TC_10", "BL_TC_10, Branch Locator NewsLetter Button Functionality validated and App Navigated to NewsLetter Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorFAQFunctionality_BL_TC_11() throws Exception {
        HeaderChildNode("Branch Locator FAQ Functionality");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objFAQ,getTextVal(MLWalletBranchLocatorPage.objFAQ,"Option"));
        waitTime(10000);
        if(verifyElementPresent(MLWalletBranchLocatorPage.objFrequentlyAskedQuestions,getTextVal(MLWalletBranchLocatorPage.objFrequentlyAskedQuestions,"Page"))) {
            logger.info("BL_TC_11, Branch Locator FAQ Button Functionality validated and App Navigated to Frequently Asked Questions Page");
            extentLoggerPass("BL_TC_11", "BL_TC_11, Branch Locator FAQ Button Functionality validated and App Navigated to Frequently Asked Questions Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorContactUsBtnFunctionality_BL_TC_12() throws Exception {
        HeaderChildNode("Branch Locator, ContactUs button Functionality validation");
        waitTime(2000);
        changeNumberPage();
        branchLocatorNavigation();
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu,"Hamburger Menu Button");
        waitTime(2000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objContactUs,getTextVal(MLWalletBranchLocatorPage.objContactUs,"Button"));
        if(verifyElementPresent(MLWalletBranchLocatorPage.objContactUs,getTextVal(MLWalletBranchLocatorPage.objContactUs,"page"))){
            verifyElementPresent(MLWalletBranchLocatorPage.objCustomer,getTextVal(MLWalletBranchLocatorPage.objCustomer,"Header"));
            verifyElementPresent(MLWalletBranchLocatorPage.objCustomerNumbers,getTextVal(MLWalletBranchLocatorPage.objCustomerNumbers,"Customer Number"));
            verifyElementPresent(MLWalletBranchLocatorPage.objCallViaWeb,getTextVal(MLWalletBranchLocatorPage.objCallViaWeb,"Call via web"));
            verifyElementPresent(MLWalletBranchLocatorPage.objCallCustomerService,getTextVal(MLWalletBranchLocatorPage.objCallCustomerService,"Button"));
            verifyElementPresent(MLWalletBranchLocatorPage.objUSACustomerCareNumber,getTextVal(MLWalletBranchLocatorPage.objUSACustomerCareNumber,"USA Customer care number"));
            Swipe("UP",2);
            verifyElementPresent(MLWalletBranchLocatorPage.objEmail,getTextVal(MLWalletBranchLocatorPage.objEmail,"Email"));
            verifyElementPresent(MLWalletBranchLocatorPage.objMessageUsHeader,getTextVal(MLWalletBranchLocatorPage.objMessageUsHeader,"Header"));
            verifyElementPresent(MLWalletBranchLocatorPage.objSubmitBtn,getTextVal(MLWalletBranchLocatorPage.objSubmitBtn,"Button"));
            logger.info("BL_TC_12, Branch Locator, ContactUs button Functionality validated");
            extentLoggerPass("BL_TC_12", "BL_TC_12, Branch Locator, ContactUs button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCareersBtnFunctionality_BL_TC_13() throws Exception {
        HeaderChildNode("Branch Locator, Careers button Functionality validation");
        waitTime(2000);
        changeNumberPage();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objContactUs,getTextVal(MLWalletBranchLocatorPage.objContactUs,"Button"));
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objCareers,getTextVal(MLWalletBranchLocatorPage.objCareers,"Button"));
        if(verifyElementPresent(MLWalletBranchLocatorPage.objCareerPage,"Careers page")){
            logger.info("BL_TC_13, Branch Locator, Careers button Functionality validated");
            extentLoggerPass("BL_TC_13", "BL_TC_13, Branch Locator, Careers button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorHamburgerMenuLoginBtnFunctionality_BL_TC_14() throws Exception {
        HeaderChildNode("Branch Locator, Hamburger Menu Login button Functionality validation");
        waitTime(2000);
        changeNumberPage();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objContactUs,getTextVal(MLWalletBranchLocatorPage.objContactUs,"Button"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objLogin,getTextVal(MLWalletBranchLocatorPage.objLogin,"Button"));
        if(verifyElementPresentAndClick(MLWalletShopItemsPage.objQRPageHeader,getTextVal(MLWalletShopItemsPage.objQRPageHeader,"Header"))){
            for(int sStep=1;sStep<=3;sStep++){
                verifyElementPresent(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),getTextVal(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),"Step "+sStep));
            }
            Swipe("UP",2);
            verifyElementPresent(MLWalletShopItemsPage.objTermsAndPolicies,getTextVal(MLWalletShopItemsPage.objTermsAndPolicies,"Link"));
            verifyElementPresent(MLWalletShopItemsPage.objPrivacyPolicy,getTextVal(MLWalletShopItemsPage.objPrivacyPolicy,"Link"));
            logger.info("BL_TC_14, Branch Locator, Hamburger Menu Login button Functionality validated");
            extentLoggerPass("BL_TC_14", "BL_TC_14, Branch Locator, Hamburger Menu Login button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

//    public void branchLocatorShopItemsPageNavigation_BL_TC_16() throws Exception {
//        HeaderChildNode("Branch Locator Shop Items Page Navigation");
//        waitTime(2000);
//        changeNumberPage();
//        branchLocatorNavigation();
//        homePageNavigation();
//        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objShop, getTextVal(MLWalletShopItemsPage.objShop, "Option"));
//        waitTime(5000);
//        if (verifyElementPresent(MLWalletBranchLocatorPage.objMLShopPage, "Shop Items Page")) {
//            logger.info("BL_TC_16, Branch Locator Shop Button Functionality validated and App Navigated to Shop Items Web Page Page");
//            extentLoggerPass("BL_TC_16", "BL_TC_16, Branch Locator Shop Button Functionality validated and App Navigated to Shop Items Web Page");
//            System.out.println("-----------------------------------------------------------");
//        }
//    }

    public void branchLocatorPayBillsPageNavigation_BL_TC_17() throws Exception {
        HeaderChildNode("Branch Locator Pay Bills Page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objPayBillsLearnMore, getTextVal(MLWalletBranchLocatorPage.objPayBillsLearnMore, "Option"));
        if (verifyElementPresent(MLWalletBranchLocatorPage.objPayBillsPage, getTextVal(MLWalletBranchLocatorPage.objPayBillsPage, "Page"))) {
            logger.info("BL_TC_17, Branch Locator Pay Bills Functionality validated and App Navigated to Pay Bills Web Page Page");
            extentLoggerPass("BL_TC_17", "BL_TC_17, Branch Locator Pay Bills Button Functionality validated and App Navigated to Pay Bills Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorSendTransferPageNavigation_BL_TC_18() throws Exception {
        HeaderChildNode("Branch Locator Send transfer page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objSendNowBtn, getTextVal(MLWalletBranchLocatorPage.objSendNowBtn, "Button"));
        waitTime(15000);
        if(verifyElementPresentAndClick(MLWalletShopItemsPage.objQRPageHeader,getTextVal(MLWalletShopItemsPage.objQRPageHeader,"Header"))){
            for(int sStep=1;sStep<=3;sStep++){
                verifyElementPresent(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),getTextVal(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),"Step "+sStep));
            }
            Swipe("UP",2);
            verifyElementPresent(MLWalletShopItemsPage.objTermsAndPolicies,getTextVal(MLWalletShopItemsPage.objTermsAndPolicies,"Link"));
            verifyElementPresent(MLWalletShopItemsPage.objPrivacyPolicy,getTextVal(MLWalletShopItemsPage.objPrivacyPolicy,"Link"));
            logger.info("BL_TC_18, Branch Locator Send transfer page navigation validated");
            extentLoggerPass("BL_TC_18", "BL_TC_18, Branch Locator Send transfer page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBuyELoadPageNavigation_BL_TC_19() throws Exception {
        HeaderChildNode("Branch Locator Buy eLoad Page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objBuyELoadLearnMore, getTextVal(MLWalletBranchLocatorPage.objBuyELoadLearnMore, "Option"));
        if (verifyElementPresent(MLWalletBranchLocatorPage.objBuyELoadPage, getTextVal(MLWalletBranchLocatorPage.objBuyELoadPage, "Page"))) {
            logger.info("BL_TC_19, Branch Locator Buy eLoad Functionality validated and App Navigated to Buy eLoad Web Page Page");
            extentLoggerPass("BL_TC_19", "BL_TC_19, Branch Locator Buy eLoad Button Functionality validated and App Navigated to Buy eLoad Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCashInPageNavigation_BL_TC_20() throws Exception {
        HeaderChildNode("Branch Locator Cash In page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objCashInLearnMore, getTextVal(MLWalletBranchLocatorPage.objCashInLearnMore, "Cash In Button"));
        waitTime(15000);
        if(verifyElementPresentAndClick(MLWalletShopItemsPage.objQRPageHeader,getTextVal(MLWalletShopItemsPage.objQRPageHeader,"Header"))){
            for(int sStep=1;sStep<=3;sStep++){
                verifyElementPresent(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),getTextVal(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),"Step "+sStep));
            }
            Swipe("UP",2);
            verifyElementPresent(MLWalletShopItemsPage.objTermsAndPolicies,getTextVal(MLWalletShopItemsPage.objTermsAndPolicies,"Link"));
            verifyElementPresent(MLWalletShopItemsPage.objPrivacyPolicy,getTextVal(MLWalletShopItemsPage.objPrivacyPolicy,"Link"));
            logger.info("BL_TC_20, Branch Locator Cash In page navigation validated");
            extentLoggerPass("BL_TC_20", "BL_TC_20, Branch Locator Cash In page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCashOutPageNavigation_BL_TC_21() throws Exception {
        HeaderChildNode("Branch Locator Cash out page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objCashOutLearnMore, getTextVal(MLWalletBranchLocatorPage.objCashOutLearnMore, "Cash Out Button"));
        waitTime(15000);
        if(verifyElementPresentAndClick(MLWalletShopItemsPage.objQRPageHeader,getTextVal(MLWalletShopItemsPage.objQRPageHeader,"Header"))){
            for(int sStep=1;sStep<=3;sStep++){
                verifyElementPresent(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),getTextVal(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),"Step "+sStep));
            }
            Swipe("UP",2);
            verifyElementPresent(MLWalletShopItemsPage.objTermsAndPolicies,getTextVal(MLWalletShopItemsPage.objTermsAndPolicies,"Link"));
            verifyElementPresent(MLWalletShopItemsPage.objPrivacyPolicy,getTextVal(MLWalletShopItemsPage.objPrivacyPolicy,"Link"));
            logger.info("BL_TC_21, Branch Locator Cash out page navigation validated");
            extentLoggerPass("BL_TC_21", "BL_TC_21, Branch Locator Cash out page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorLoansPageNavigation_BL_TC_22() throws Exception {
        HeaderChildNode("Branch Locator Loans Page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objLoans, getTextVal(MLWalletBranchLocatorPage.objLoans, "Loans Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletBranchLocatorPage.objLoansPage, "Loans Page")) {
            logger.info("BL_TC_22, Branch Locator Loans Functionality validated and App Navigated to Loans Web Page Page");
            extentLoggerPass("BL_TC_22", "BL_TC_22, Branch Locator Loans Button Functionality validated and App Navigated to Loans Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorInsurancePageNavigation_BL_TC_23() throws Exception {
        HeaderChildNode("Branch Locator Insurance Page Navigation");
        branchLocatorNavigation();
        homePageNavigation();
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletBranchLocatorPage.objInsurance, getTextVal(MLWalletBranchLocatorPage.objInsurance, "Insurance Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletBranchLocatorPage.objInsurancePage, "Insurance Page")) {
            logger.info("BL_TC_23, Branch Locator Insurance Functionality validated and App Navigated to Insurance Web Page Page");
            extentLoggerPass("BL_TC_23", "BL_TC_23, Branch Locator Insurance Button Functionality validated and App Navigated to Insurance Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

}
