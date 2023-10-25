package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletBranchLocatorPage;
import com.iosmlwalletpages.MLWalletLoginPage;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

public class MLWalletBranchLocator extends BaseClass{

    public MLWalletBranchLocator(){
        super();
    }

//===========================================================================================================//
public void branchLocatorNavigation() throws Exception {
    Swipe("DOWN",2);
    if(verifyElementPresentAndClick(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Button"))){
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"));
        logger.info("Navigated to Branch Locator page");
    }else{
        logger.info("Not Navigated to Branch Locator Page");
    }
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



}
