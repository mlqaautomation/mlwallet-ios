package com.business.mlwallet;
import chromeTest.ChromeTest;
import com.driverInstance.CommandBase;
import com.driverInstance.DriverInstance;
import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import com.utility.ExtentReporter;
import com.utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;
import java.util.Map;

import static com.business.mlwallet.MLWalletLogin.changeNumberPage;
import static com.business.mlwallet.MLWalletLogin.mlWalletLogin;
import static com.business.mlwallet.MlWalletHomeAndDashBoard.*;
import static com.driverInstance.Drivertools.setPlatform;
import static com.utility.Utilities.*;

public class MLWalletTierUpgrade extends BaseClass{

    public MLWalletTierUpgrade(){
        super();
    }
    public void accountDetailsPageNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(3000);
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"));
    }



    public void selectSourceOfIncome(String sSourceOfIncome,String sOption) throws Exception {
        verifyElementPresent(MLWalletTierUpgradePages.objSourceOfIncomeHeader,getTextVal(MLWalletTierUpgradePages.objSourceOfIncomeHeader,"Field Header"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objChooseSourceOfIncome,getTextVal(MLWalletTierUpgradePages.objChooseSourceOfIncome,"Button"));
        type(MLWalletTierUpgradePages.objSearchFieldInput,sSourceOfIncome,"Source of Income Option");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSourceOfIncomeOption(sOption),getTextVal(MLWalletTierUpgradePages.objSourceOfIncomeOption(sOption),"Option"));
        click(MLWalletTierUpgradePages.objSourceOfIncomeOption(sOption),getTextVal(MLWalletTierUpgradePages.objSourceOfIncomeOption(sOption),"Option"));
    }

    public void selectProductServicesOffered() throws Exception {
        verifyElementPresent(MLWalletTierUpgradePages.objProductServicesOfferedHeader,getTextVal(MLWalletTierUpgradePages.objProductServicesOfferedHeader,"Field Header"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objChooseProductServicesOffered,getTextVal(MLWalletTierUpgradePages.objChooseProductServicesOffered,"Button"));
        click(MLWalletTierUpgradePages.objChooseProductServicesOffered,getTextVal(MLWalletTierUpgradePages.objChooseProductServicesOffered,"Button"));
        type(MLWalletTierUpgradePages.objSearchFieldInput,prop.getproperty("Product/ServicesOffered"),"Product/Services offered Option");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objProductServicesOfferedOption,getTextVal(MLWalletTierUpgradePages.objProductServicesOfferedOption,"Option"));
        click(MLWalletTierUpgradePages.objProductServicesOfferedOption,getTextVal(MLWalletTierUpgradePages.objProductServicesOfferedOption,"Option"));
    }



    public void selectPositionAtWork() throws Exception {
        verifyElementPresent(MLWalletTierUpgradePages.objPositionAtWorkHeader,getTextVal(MLWalletTierUpgradePages.objPositionAtWorkHeader,"Field Header"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objChoosePositionAtWork,getTextVal(MLWalletTierUpgradePages.objChoosePositionAtWork,"Button"));
        click(MLWalletTierUpgradePages.objChoosePositionAtWork,getTextVal(MLWalletTierUpgradePages.objChoosePositionAtWork,"Button"));
        type(MLWalletTierUpgradePages.objSearchFieldInput,prop.getproperty("PositionAtWork"),"Position at work Option");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPositionAtWorkOption,getTextVal(MLWalletTierUpgradePages.objPositionAtWorkOption,"Option"));
        click(MLWalletTierUpgradePages.objPositionAtWorkOption,getTextVal(MLWalletTierUpgradePages.objPositionAtWorkOption,"Option"));
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


    public void kpxLogin(String url) throws Exception {
        Map<String, Object> roleData = yamlReader.getRoleData("admin");
        if(!roleData.isEmpty()){
            HeaderChildNode("KPX, Login via Gmail");
//            setPlatform("Web");
//            String s = Utilities.getPlatform();
//            System.out.println(s);
//            logger.info("Platform switched to Web Browser for QR Code");
//            extentLogger("","Platform switched to Web Browser for QR Code");
////            ChromeTest.LaunchBrowser("Chrome",url);
//            new BaseClass();
//            waitTime(5000);
//            verifyElementPresent(KPXLogin.googleSign, "google sign in");

            String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserType");
            ChromeTest.LaunchBrowser(browser,url);
            waitTime(5000);
            new Utilities().setPlatform("Web");
            System.out.println(getPlatform());
            waitTime(10000);

            clickWeb(KPXLogin.googleSign, "google sign in btn");
            waitTime(2000);
            WebDriver driver = getWebDriver();
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
            verifyElementPresent(KPXLogin.email_google, "email input");
            waitTime(2000);
            type(KPXLogin.email_google, yamlReader.getEmailForRole("admin"), "email inputted");
            click(KPXLogin.nextBtn_google, "next btn");
            verifyElementPresent(KPXLogin.password_google, "password input");
            waitTime(2000);
            type(KPXLogin.password_google, yamlReader.getPasswordForRole("admin"), "password inputted");
            click(KPXLogin.nextBtn_google, "next btn");
            waitTime(5000);
            scrollToBottomOfPageWEB();
            verifyElementPresentAndClick(KPXLogin.try_another_way_google, "another way option");
            waitTime(5000);
            scrollToBottomOfPageWEB();
            waitTime(3000);
            verifyElementPresentAndClick(KPXLogin.enter_back_up_codes_google, "8-digit backup codes");
            verifyElementPresent(KPXLogin.input_back_up_codes_google, "backup code input text");
            waitTime(2000);
            type(KPXLogin.input_back_up_codes_google, yamlReader.getFirstBackupCode("admin"), "8-digit backup code");
            click(KPXLogin.nextBtn_google, "next btn");
            waitTime(10000);
//            WebDriver driver1 = getWebDriver();
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[0]);
            verifyElementPresent(KPXLogin.LoginText, "Login Page Header");
            logger.info("Navigated to Login Page");
            extentLoggerPass("Login Page Redirection", "OK, ");
        }
    }


    public void switchPlatformToWeb1(String url) throws InterruptedException {
//        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserType");
//        new DriverInstance().LaunchBrowser(browser);
//        waitTime(5000);
//        getWebDriver().get(url);
//        new Utilities().setPlatform("Web");
//        System.out.println(getPlatform());
        ChromeTest.LaunchBrowser("Chrome",url);
        setPlatform("Web");
        String s = Utilities.getPlatform();
        System.out.println(s);
        logger.info("Platform switched to Web Browser for QR Code");
        extentLogger("","Platform switched to Web Browser for QR Code");
    }
    public void tierUpgradeHomePageIIconValidationAsBuyerTierUser_TU_TC_01() throws Exception {
        HeaderChildNode("Tier Upgrade Home Page I Icon Validation as BuyerTier User");
        waitTime(2000);
        changeNumberPage();
        waitTime(2000);
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
//        kpxLogin("https://ml-kpx-qa.df.r.appspot.com/");
//        closeWebBrowser();
//        switchPlatformToAndroid();
        if (verifyElementPresent(MLWalletHomePage.objIIconLearnMoreTxt, getTextVal(MLWalletHomePage.objIIconLearnMoreTxt, "text"))) {
            logger.info("TU_TC_01, Tier Upgrade Home Page I Icon validated as BuyerTier User");
            extentLoggerPass("TU_TC_01", "TU_TC_01, Tier Upgrade Home Page I Icon validated as BuyerTier User");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void tierUpgradeHomePageIIconValidationAsSemiVerifiedTierUser_TU_TC_02() throws Exception {
        HeaderChildNode("Tier Upgrade Home Page I Icon Validation as as Semi verified Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        if (verifyElementPresent(MLWalletHomePage.objIIconLearnMoreTxt, getTextVal(MLWalletHomePage.objIIconLearnMoreTxt, "text"))) {
            logger.info("TU_TC_02, Tier Upgrade Home Page I Icon validated as Semi verified User");
            extentLoggerPass("TU_TC_02", "TU_TC_02, Tier Upgrade Home Page I Icon validated as Semi verified User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeHomePageIIconValidationAsFullyVerifiedTierUser_TU_TC_03() throws Exception {
        HeaderChildNode("Tier Upgrade Home Page I Icon Validation as Fully verified Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementNotPresent(MLWalletHomePage.objIIcon,"i icon", 5);
        logger.info("I Icon is not displayed");
        logger.info("TU_TC_03, Tier Upgrade Home Page I Icon not displayed For Fully-verified Tier user");
        extentLoggerPass("TU_TC_03", "TU_TC_03, Tier Upgrade Home Page I Icon not displayed For Fully-verified Tier user");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeVerificationTierPerksPageNavigationAsBuyerTierUser_TU_TC_04() throws Exception {
        HeaderChildNode("Tier Upgrade Verification tier perks page navigation as BuyerTier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_04, Tier Upgrade Verification tier perks page navigation validated as BuyerTier User");
            extentLoggerPass("TU_TC_04", "TU_TC_04, Tier Upgrade Verification tier perks page navigation validated as BuyerTier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeVerificationTierPerksPageNavigationAsSemiVerifiedTierUser_TU_TC_05() throws Exception {
        HeaderChildNode("Tier Upgrade Verification tier perks page navigation as Semi Verified Tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_05, Tier Upgrade Verification tier perks page navigation validated as Semi Verified Tier User");
            extentLoggerPass("TU_TC_05", "TU_TC_05, Tier Upgrade Verification tier perks page navigation validated as Semi Verified Tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeVerificationTierPerksBackBtnValidation_TU_TC_06() throws Exception {
        HeaderChildNode("Tier Upgrade Verification tier perks Back button validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(2000);
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objVerificationTierPerksBackBtn, "Back Button");
        if (verifyElementPresent(MLWalletHomePage.objAvailableBalanceHeader, getTextVal(MLWalletHomePage.objAvailableBalanceHeader, "Header"))) {
            logger.info("TU_TC_06, Tier Upgrade, After clicking back btn in verification tier perks app navigates to Home Page is validated");
            extentLoggerPass("TU_TC_06", "TU_TC_06, Tier Upgrade, After clicking back btn in verification tier perks app navigates to Home Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUpgradeTierLevelBtnValidationForSemiVerifiedTabAsBuyTierUser_TU_TC_07() throws Exception {
        HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Semi verified tab As Buyer tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSemiVerifiedTab, getTextVal(MLWalletTierUpgradePages.objSemiVerifiedTab, "Tab"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"))) {
            logger.info("TU_TC_07, Tier Upgrade Upgrade tier level Button validated, For Semi verified tab As Buyer tier User");
            extentLoggerPass("TU_TC_07", "TU_TC_07, Tier Upgrade Upgrade tier level Button validated, For Semi verified tab As Buyer tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsBuyTierUser_TU_TC_08() throws Exception {
        HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Fully verified tab As Buyer tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"))) {
            logger.info("TU_TC_08, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Buyer tier User");
            extentLoggerPass("TU_TC_08", "TU_TC_08, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Buyer tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsBuyTierUser_TU_TC_09() throws Exception {
        HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Fully verified tab As Buyer tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objBranchVerifiedTab, getTextVal(MLWalletTierUpgradePages.objBranchVerifiedTab, "Tab"));
        verifyElementNotPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, "Upgrade Tier level button",5);
        logger.info("Upgrade Tier Level Button is not displayed");
        logger.info("TU_TC_09, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Buyer tier User");
        extentLoggerPass("TU_TC_09", "TU_TC_09, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Buyer tier User");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsSemiVerifiedTierUser_TU_TC_10() throws Exception {
        HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Fully verified tab As Semi verified tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"))) {
            logger.info("TU_TC_10, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Semi verified tier User");
            extentLoggerPass("TU_TC_10", "TU_TC_10, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Semi verified tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsSemiVerifiedTierUser_TU_TC_11() throws Exception {
        HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Branch verified tab As Semi verified tier User");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(2000);
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objBranchVerifiedTab, getTextVal(MLWalletTierUpgradePages.objBranchVerifiedTab, "Tab"));
        verifyElementNotPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, "Upgrade tier level button",5);
        logger.info("Upgrade Tier Level Button is not displayed");
        logger.info("TU_TC_11, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Semi verified tier User");
        extentLoggerPass("TU_TC_11", "TU_TC_11, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Semi verified tier User");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToSemiVerifiedTier_TU_TC_12() throws Exception {
        HeaderChildNode("Tier Upgrade Account details page navigation as Buyer tier user to upgrade to Semi verified tier user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSemiVerifiedTab, getTextVal(MLWalletTierUpgradePages.objSemiVerifiedTab, "Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            logger.info("TU_TC_12, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Semi verified tier user");
            extentLoggerPass("TU_TC_12", "TU_TC_12, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Semi verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToFullyVerifiedTier_TU_TC_13() throws Exception {
        HeaderChildNode("Tier Upgrade Account details page navigation as Buyer tier user to upgrade to Fully verified tier user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            logger.info("TU_TC_13, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Fully verified tier user");
            extentLoggerPass("TU_TC_13", "TU_TC_13, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Fully verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageNavigationAsSemiVerifiedTierUserToUpgradeToFullyVerifiedTier_TU_TC_14() throws Exception {
        HeaderChildNode("Tier Upgrade Account details page navigation as Semi verified tier user to upgrade to Fully verified tier user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            logger.info("TU_TC_14, Tier Upgrade Account details page navigation validated as Semi verified tier user to upgrade to Fully verified tier user");
            extentLoggerPass("TU_TC_14", "TU_TC_14, Tier Upgrade Account details page navigation validated as Semi verified tier user to upgrade to Fully verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageBackBtnValidation_TU_TC_15() throws Exception {
        HeaderChildNode("Tier upgrade Account details page Back button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objAccountDetailsBackBtn, "Account details page Back button");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_15, Tier Upgrade, After clicking back btn in Account details page app navigates to Verification tier perks Page is validated");
            extentLoggerPass("TU_TC_15", "TU_TC_15, Tier Upgrade, After clicking back btn in Account details page app navigates to Verification tier perks Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAutoSuggestionsValidationForProductServicesOffered_TU_TC_16() throws Exception {
        HeaderChildNode("Tier Upgrade Auto Suggestions validation for Product/Services Offered");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objProductServiceSelectionBtn, "Product/Services offered selection Button");
        type(MLWalletTierUpgradePages.objSearchFieldInput, "C", "Product/Services offered search field");
        if (verifyElementDisplayed(MLWalletTierUpgradePages.objMatchingElements, "Matching Elements")) {
            List<WebElement> values = findElements(MLWalletTierUpgradePages.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String matchingElements = getText(MLWalletTierUpgradePages.objMatchingElementsProductServices(i));
                    logger.info("Matching Elements : " + matchingElements + " is displayed");
                    extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
                }
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_16, Tier Upgrade, Auto Suggestions validated for Product/Services Offered");
        extentLoggerPass("TU_TC_16", "TU_TC_16, Tier Upgrade, Auto Suggestions validated for Product/Services Offered");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeAutoSuggestionsValidationForPositionAtWork_TU_TC_17() throws Exception {
        HeaderChildNode("Tier Upgrade Auto Suggestions validation for Position at Work");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPositionAtWokSelectionBtn, "Position at Work selection Button");
        type(MLWalletTierUpgradePages.objSearchFieldInput, "A", "Position at Work search field");
        if (verifyElementDisplayed(MLWalletTierUpgradePages.objMatchingElements, "Matching Elements")) {
            List<WebElement> values = findElements(MLWalletTierUpgradePages.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String matchingElements = getText(MLWalletTierUpgradePages.objMatchingElementsProductServices(i));
                    logger.info("Matching Elements : " + matchingElements + " is displayed");
                    extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
                }
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_17, Tier Upgrade, Auto Suggestions validated for Position at Work");
        extentLoggerPass("TU_TC_17", "TU_TC_17, Tier Upgrade, Auto Suggestions validated for Position at Work");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeAutoSuggestionsValidationForNatureOfWork_TU_TC_18() throws Exception {
        HeaderChildNode("Tier Upgrade Auto Suggestions validation for Nature of Work");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objNatureOfWorkSelectionBtn, "Nature of Work selection Button");
        type(MLWalletTierUpgradePages.objSearchFieldInput, "U", "Nature of Work search field");
        if (verifyElementDisplayed(MLWalletTierUpgradePages.objMatchingElements, "Matching Elements")) {
            List<WebElement> values = findElements(MLWalletTierUpgradePages.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String matchingElements = getText(MLWalletTierUpgradePages.objMatchingElementsProductServices(i));
                    logger.info("Matching Elements : " + matchingElements + " is displayed");
                    extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
                }
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_18, Tier Upgrade, Auto Suggestions validated for Nature of Work");
        extentLoggerPass("TU_TC_18", "TU_TC_18, Tier Upgrade, Auto Suggestions validated for Nature of Work");
        System.out.println("-----------------------------------------------------------");
    }


    public void tierUpgradeConfirmDetailsBtnValidationInAccountDetailsPage_TU_TC_19() throws Exception {
        HeaderChildNode("Tier Upgrade, Confirm details button validation in Account details page");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        if (verifyElementPresent(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"))) {
            logger.info("TU_TC_19, Tier Upgrade, Confirm details button validated in Account details page");
            extentLoggerPass("TU_TC_19", "TU_TC_19, Tier Upgrade, Confirm details button validated in Account details page");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradePageNavigation_TU_TC_20() throws Exception {
        HeaderChildNode("Tier upgrade page navigation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation("");
        Swipe("UP", 2);
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            logger.info("TU_TC_20, Tier Upgrade page navigation validated");
            extentLoggerPass("TU_TC_20", "TU_TC_20, Tier Upgrade page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeFullyVerifiedTierTabUIValidation_TU_TC_21() throws Exception {
        HeaderChildNode("Tier Upgrade Fully verified ter Tab UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objFullyVerifiedTab, getTextVal(MLWalletTierUpgradePages.objFullyVerifiedTab, "Tab"));
        if (verifyElementPresent(MLWalletHomePage.objTier, getTextVal(MLWalletHomePage.objTier, "Header"))) {
            verificationTierPerksPageValidation();
            verifyElementPresent(MLWalletTierUpgradePages.objUpgradeTierLevel, getTextVal(MLWalletTierUpgradePages.objUpgradeTierLevel, "Button"));
            logger.info("TU_TC_21, Tier Upgrade Fully verified ter Tab UI validated");
            extentLoggerPass("TU_TC_21", "TU_TC_21, Tier Upgrade Fully verified ter Tab UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageUIValidation_TU_TC_23() throws Exception {
        HeaderChildNode("Tier upgrade Account details page UI validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objPersonalInformation, getTextVal(MLWalletTierUpgradePages.objPersonalInformation, "Header"));
            verifyElementPresent(MLWalletTierUpgradePages.objPlaceOfBirth, getTextVal(MLWalletTierUpgradePages.objPlaceOfBirth, "Place of Birth"));
            verifyElementPresent(MLWalletTierUpgradePages.objNationality, getTextVal(MLWalletTierUpgradePages.objNationality, "Nationality"));
            verifyElementPresent(MLWalletTierUpgradePages.objCivilStatus, getTextVal(MLWalletTierUpgradePages.objCivilStatus, "Civil Status"));
            verifyElementPresent(MLWalletTierUpgradePages.objGenderAtBirth, getTextVal(MLWalletTierUpgradePages.objGenderAtBirth, "Gender at Birth"));
            verifyElementPresent(MLWalletTierUpgradePages.objSourceOfIncome, getTextVal(MLWalletTierUpgradePages.objSourceOfIncome, "Source of Income"));
            verifyElementPresent(MLWalletTierUpgradePages.objCompanyOrEmployerName, getTextVal(MLWalletTierUpgradePages.objCompanyOrEmployerName, "Company/Employer Name"));
            verifyElementPresent(MLWalletTierUpgradePages.objProductServiceSelectionBtn, getTextVal(MLWalletTierUpgradePages.objProductServiceSelectionBtn, "Product/Service offered"));
            verifyElementPresent(MLWalletTierUpgradePages.objWorkAddress, getTextVal(MLWalletTierUpgradePages.objWorkAddress, "Work Address"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletTierUpgradePages.objPositionAtWokSelectionBtn, getTextVal(MLWalletTierUpgradePages.objPositionAtWokSelectionBtn, "Position at Work"));
            verifyElementPresent(MLWalletTierUpgradePages.objNatureOfWorkSelectionBtn, getTextVal(MLWalletTierUpgradePages.objNatureOfWorkSelectionBtn, "Nature of Work"));
            logger.info("TU_TC_23, Tier upgrade Account details page UI validated");
            extentLoggerPass("TU_TC_23", "TU_TC_23, Tier upgrade Account details page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradePageUIValidation_TU_TC_24() throws Exception {
        HeaderChildNode("Tier upgrade page UI validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objSelectAnyValidID, getTextVal(MLWalletTierUpgradePages.objSelectAnyValidID, "Header"));
            verifyElementPresent(MLWalletTierUpgradePages.objSelectID, getTextVal(MLWalletTierUpgradePages.objSelectID, "Input field Header"));
            verifyElementPresent(MLWalletTierUpgradePages.objSelectIDSelectionBtn, getTextVal(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Button"));
            logger.info("TU_TC_24, Tier upgrade page UI validated");
            extentLoggerPass("TU_TC_24", "TU_TC_24, Tier upgrade page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeBackArrowBtnValidation_TU_TC_25() throws Exception {
        HeaderChildNode("Tier upgrade page UI validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTierUpgradeBackBtn, "Tier upgrade Back Arrow Btn");
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            logger.info("TU_TC_25, After clicking on Back Arrow Btn on Tier upgrade Page, Application Navigates to Account Details Page is validated");
            extentLoggerPass("TU_TC_25", "TU_TC_25, After clicking on Back Arrow Btn on Tier upgrade Page, Application Navigates to Account Details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUploadIDPhotosUIValidationAfterSelectingPHILHEALTH_TU_TC_26() throws Exception {
        HeaderChildNode("Tier Upgrade, Upload ID photos UI validation After Selecting PHIL HEALTH");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objUploadIDPhotos, getTextVal(MLWalletTierUpgradePages.objUploadIDPhotos, "Header"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objSelectIDSelectionBtn, getTextVal(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Selected ID Field"));
            verifyElementPresent(MLWalletTierUpgradePages.objCardInputField, "Card Input Field");
            verifyElementPresent(MLWalletTierUpgradePages.objScanFrontOfID, getTextVal(MLWalletTierUpgradePages.objScanFrontOfID, "Button"));
            verifyElementPresent(MLWalletTierUpgradePages.objScanBackOfID, getTextVal(MLWalletTierUpgradePages.objScanBackOfID, "Button"));
            verifyElementPresent(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, getTextVal(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, "Button"));
            logger.info("TU_TC_26, Tier Upgrade, Upload ID photos UI validated After Selecting PHIL HEALTH");
            extentLoggerPass("TU_TC_26", "TU_TC_26, Tier Upgrade, Upload ID photos UI validated After Selecting PHIL HEALTH");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeUploadIDPhotosBackArrowBtnValidation_TU_TC_27() throws Exception {
        HeaderChildNode("Tier upgrade page UI validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTierUpgradeBackBtn, "Tier upgrade Back Arrow Btn");
        if (verifyElementPresent(MLWalletTierUpgradePages.objAccountDetails, getTextVal(MLWalletTierUpgradePages.objAccountDetails, "Page"))) {
            logger.info("TU_TC_27, After clicking on Back Arrow Btn on Tier upgrade Upload ID Photos Page, Application Navigates to Account Details Page is validated");
            extentLoggerPass("TU_TC_27", "TU_TC_27, After clicking on Back Arrow Btn on Tier upgrade Upload ID Photos Page, Application Navigates to Account Details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeScanFrontOfIDPageUIValidation_TU_TC_28() throws Exception {
        HeaderChildNode("Tier Upgrade Scan front of ID page UI Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objScanFrontOfID, getTextVal(MLWalletTierUpgradePages.objScanFrontOfID, "Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objScanFrontOfID, getTextVal(MLWalletTierUpgradePages.objScanFrontOfID, "Button"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objScanFrontOfIDInfo, getTextVal(MLWalletTierUpgradePages.objScanFrontOfIDInfo, "info"));
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureScreen, "Capture Screen");
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureButton, "Capture Button");
            logger.info("TU_TC_28, Tier Upgrade Scan front of ID page UI validated");
            extentLoggerPass("TU_TC_28", "TU_TC_28, Tier Upgrade Scan front of ID page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void enableCameraPopup() throws Exception {
        String loc = getText(MLWalletLoginPage.objCameraPopup);
        if (loc.contains("Allow")) {
            logger.info(loc + " Pop Up is Displayed");
            extentLoggerPass("pop up", loc + " Pop Up is Displayed");
            click(MLWalletLoginPage.objCamPopUpOKBtn, "Allow Button");
        } else {
            logger.info(" Camera Pop Up is not Displayed");
            extentLoggerPass("pop up", "Camera Pop Up is not Displayed");
        }
    }


    public void tierUpgradeScanFrontOfIDPageBackArrowBtnValidation_TU_TC_29() throws Exception {
        HeaderChildNode("Tier Upgrade Scan front of ID page BAck Arrow button Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objScanFrontOfID, getTextVal(MLWalletTierUpgradePages.objScanFrontOfID, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objScanFrontOfID, getTextVal(MLWalletTierUpgradePages.objScanFrontOfID, "Button"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTierUpgradeBackBtn, "Tier Upgrade Scan Front of ID Back Arrow Button");
        waitTime(3000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            logger.info("TU_TC_29, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Front of ID app navigates to Tier Upgrade page is validated");
            extentLoggerPass("TU_TC_29", "TU_TC_29, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Front of ID app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeScanBackOfIDPageUIValidation_TU_TC_30() throws Exception {
        HeaderChildNode("Tier Upgrade Scan Back of ID page UI Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objScanBackOfID, getTextVal(MLWalletTierUpgradePages.objScanBackOfID, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objScanBackOfID, getTextVal(MLWalletTierUpgradePages.objScanBackOfID, "Page"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objScanBackOfIDInfo, getTextVal(MLWalletTierUpgradePages.objScanBackOfIDInfo, "info"));
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureScreenBackID, "Capture Screen");
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureButtonBackID, "Capture Button");
            logger.info("TU_TC_30, Tier Upgrade Scan Back of ID page UI validated");
            extentLoggerPass("TU_TC_30", "TU_TC_30, Tier Upgrade Scan Back of ID page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeScanBackOfIDPageBackArrowBtnValidation_TU_TC_31() throws Exception {
        HeaderChildNode("Tier Upgrade Scan Back of ID page BAck Arrow button Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objScanBackOfID, getTextVal(MLWalletTierUpgradePages.objScanBackOfID, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objScanBackOfID, getTextVal(MLWalletTierUpgradePages.objScanBackOfID, "Button"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTierUpgradeBackBtn, "Tier Upgrade Scan Back of ID Back Arrow Button");
        waitTime(3000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            logger.info("TU_TC_31, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Back of ID app navigates to Tier Upgrade page is validated");
            extentLoggerPass("TU_TC_31", "TU_TC_31, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Back of ID app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeTakeAFaceIdentityPhotoPageUIValidation_TU_TC_32() throws Exception {
        HeaderChildNode("Tier Upgrade Take a face identity photo page UI Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, getTextVal(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            verifyElementPresent(MLWalletTierUpgradePages.objTakeAFaceIdentityPhotoInfo, getTextVal(MLWalletTierUpgradePages.objTakeAFaceIdentityPhotoInfo, "info"));
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureScreen, "Capture Screen");
            verifyElementPresent(MLWalletTierUpgradePages.objCaptureButton, "Capture Button");
            logger.info("TU_TC_32, Tier Upgrade Take a face identity photo page UI validated");
            extentLoggerPass("TU_TC_32", "TU_TC_32, Tier Upgrade Take a face identity photo page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeTakeAFaceIdentityPhotoPageBackArrowBtnValidation_TU_TC_33() throws Exception {
        HeaderChildNode("Tier Upgrade Take a face identity photo Back arrow button Validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgradePages.objSearchIDInputField, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        click(MLWalletTierUpgradePages.objPhilHealth, getTextVal(MLWalletTierUpgradePages.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, getTextVal(MLWalletTierUpgradePages.objTakeAFaceIdentityPhoto, "Button"));
        verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objTierUpgradeBackBtn, "Tier Upgrade, Take a face identity photo Back Arrow Btn");
        if (verifyElementPresent(MLWalletTierUpgradePages.objTierUpgrade, getTextVal(MLWalletTierUpgradePages.objTierUpgrade, "Page"))) {
            logger.info("TU_TC_33, Tier Upgrade, After clicking back btn in Tier Upgrade Take a face identity photo app navigates to Tier Upgrade page is validated");
            extentLoggerPass("TU_TC_33", "TU_TC_33, Tier Upgrade, After clicking back btn in Tier Upgrade Take a face identity photo app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSourceOfIncomeErrorMsgValidation_TU_TC_85() throws Exception {
        HeaderChildNode("Tier Upgrade, Source of Income required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objFieldRequiredErrorMSg, getTextVal(MLWalletTierUpgradePages.objFieldRequiredErrorMSg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objFieldRequiredErrorMSg);
            String sExceptedErrorMsg = "Field is is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_85, Tier Upgrade, Source of Income required error msg validated");
            extentLoggerPass("TU_TC_85", "TU_TC_85, Tier Upgrade, Source of Income required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeCompanyEmployerNameErrorMsgValidation_TU_TC_86() throws Exception {
        HeaderChildNode("Tier Upgrade, Company Employer name error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objCompanyEmployerNameErrorMsg, getTextVal(MLWalletTierUpgradePages.objCompanyEmployerNameErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objCompanyEmployerNameErrorMsg);
            String sExceptedErrorMsg = "Company/Employer Name is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_86, Tier Upgrade, Company Employer name error msg validated");
            extentLoggerPass("TU_TC_86", "TU_TC_86, Tier Upgrade, Company Employer name error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeCompanyEmployerNameInvalidInputErrorMsgValidation_TU_TC_87() throws Exception {
        HeaderChildNode("Tier Upgrade, Company Employer name Invalid Input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyOrEmployerName, prop.getproperty("Invalid_CompanyEmployerName"), "Company/Employer Name");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objInvalidInputErrorMsg, getTextVal(MLWalletTierUpgradePages.objInvalidInputErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objInvalidInputErrorMsg);
            String sExceptedErrorMsg = "Organization Name must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_87, Tier Upgrade, Company Employer name Invalid Input error msg validated");
            extentLoggerPass("TU_TC_87", "TU_TC_87, Tier Upgrade, Company Employer name Invalid Input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeProductServicesOfferedErrorMsgValidation_TU_TC_88() throws Exception {
        HeaderChildNode("Tier Upgrade, Product/Services offered  error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objProductServicesOfferedErrorMsg, getTextVal(MLWalletTierUpgradePages.objProductServicesOfferedErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objProductServicesOfferedErrorMsg);
            String sExceptedErrorMsg = "Product/Services Offered is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_88, Tier Upgrade, Product/Services offered error msg validated");
            extentLoggerPass("TU_TC_88", "TU_TC_88, Tier Upgrade, Product/Services offered error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeWorkAddressErrorMsgValidation_TU_TC_89() throws Exception {
        HeaderChildNode("Tier Upgrade, Work Address error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        selectProductServicesOffered();
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objWorkAddressErrorMsg, getTextVal(MLWalletTierUpgradePages.objWorkAddressErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objWorkAddressErrorMsg);
            String sExceptedErrorMsg = "Work Address is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_89, Tier Upgrade, Work Address error msg validated");
            extentLoggerPass("TU_TC_89", "TU_TC_89, Tier Upgrade, Work Address error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeWorkAddressInvalidInputErrorMsgValidation_TU_TC_90() throws Exception {
        HeaderChildNode("Tier Upgrade, Work Address Invalid Input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        selectProductServicesOffered();
        type(MLWalletTierUpgradePages.objWorkAddressInputField, prop.getproperty("Invalid_WorkAddress"), "Work Address Field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objWorkAddressInvalidErrorMsg, getTextVal(MLWalletTierUpgradePages.objWorkAddressInvalidErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objWorkAddressInvalidErrorMsg);
            String sExceptedErrorMsg = "Address must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_90, Tier Upgrade, Work Address Invalid Input error msg validated");
            extentLoggerPass("TU_TC_90", "TU_TC_90, Tier Upgrade, Work Address Invalid Input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradePositionAtWorkRequiredErrorMsgValidation_TU_TC_91() throws Exception {
        HeaderChildNode("Tier Upgrade, Position at Work required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        selectProductServicesOffered();
        type(MLWalletTierUpgradePages.objWorkAddressInputField, prop.getproperty("WorkAddress"), "Work Address Field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objPositionAtWorkRequiredErrorMsg, getTextVal(MLWalletTierUpgradePages.objPositionAtWorkRequiredErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objPositionAtWorkRequiredErrorMsg);
            String sExceptedErrorMsg = "Position at Work is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_91, Tier Upgrade, Position at Work required error msg validated");
            extentLoggerPass("TU_TC_91", "TU_TC_91, Tier Upgrade, Position at Work required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeNatureOfWorkRequiredErrorMsgValidation_TU_TC_92() throws Exception {
        HeaderChildNode("Tier Upgrade, Nature of Work required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        selectProductServicesOffered();
        type(MLWalletTierUpgradePages.objWorkAddressInputField, prop.getproperty("WorkAddress"), "Work Address Field");
        selectPositionAtWork();
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objNatureOfWorkRequiredErrorMsg, getTextVal(MLWalletTierUpgradePages.objNatureOfWorkRequiredErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objNatureOfWorkRequiredErrorMsg);
            String sExceptedErrorMsg = "Nature of Work is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_92, Tier Upgrade, Nature of work required error msg validated");
            extentLoggerPass("TU_TC_92", "TU_TC_92, Tier Upgrade, Nature of work required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeReceivingPensionFromRequiredErrorMsgValidation_TU_TC_93() throws Exception {
        HeaderChildNode("Tier Upgrade, Receiving Pension from required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomePension"), "PENSION FOR RETIREE");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objReceivingPensionFromErrorMsg, getTextVal(MLWalletTierUpgradePages.objReceivingPensionFromErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objReceivingPensionFromErrorMsg);
            String sExceptedErrorMsg = "Receiving Pension From is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_93, Tier Upgrade, Receiving Pension from required error msg validated");
            extentLoggerPass("TU_TC_93", "TU_TC_93, Tier Upgrade, Receiving Pension from required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeYearRetiredRequiredErrorMsgValidation_TU_TC_94() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Year retired required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomePension"), "PENSION FOR RETIREE");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objYearRetiredErrorMsg, getTextVal(MLWalletTierUpgradePages.objYearRetiredErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objYearRetiredErrorMsg);
            String sExceptedErrorMsg = "Year Retired is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_94, Tier Upgrade, Year retired required error msg validated");
            extentLoggerPass("TU_TC_94", "TU_TC_94, Tier Upgrade, Year retired required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradePositionUponRetirementRequiredErrorMsgValidation_TU_TC_95() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Position Upon Retirement required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomePension"), "PENSION FOR RETIREE");
        type(MLWalletTierUpgradePages.objYearRetiredInputField, prop.getproperty("YearRetired"), "Year retired field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objPositionUponRetirementErrorMsg, getTextVal(MLWalletTierUpgradePages.objPositionUponRetirementErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objPositionUponRetirementErrorMsg);
            String sExceptedErrorMsg = "Position Upon Retirement is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_95, Tier Upgrade, Position Upon Retirement required error msg validated");
            extentLoggerPass("TU_TC_95", "TU_TC_95, Tier Upgrade, Position Upon Retirement required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeFinancialAssistanceRemarksRequiredErrorMsgValidation_TU_TC_96() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Financial Assistance Remarks required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeFinancialAssistance"), "FINANCIAL ASSISTANCE FROM RELATIVES");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objRemarksErrorMsg, getTextVal(MLWalletTierUpgradePages.objRemarksErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objRemarksErrorMsg);
            String sExceptedErrorMsg = "Remarks is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_96, Tier Upgrade, Financial Assistance Remarks required error msg validated");
            extentLoggerPass("TU_TC_96", "TU_TC_96, Tier Upgrade, Financial Assistance Remarks required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeSchoolUniversityRequiredErrorMsgValidation_TU_TC_97() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School/University required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSchoolUniversityErrorMsg, getTextVal(MLWalletTierUpgradePages.objSchoolUniversityErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objSchoolUniversityErrorMsg);
            String sExceptedErrorMsg = "School/University is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_97, Tier Upgrade, School/University required error msg validated");
            extentLoggerPass("TU_TC_97", "TU_TC_97, Tier Upgrade, School/University required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSchoolUniversityInvalidInputErrorMsgValidation_TU_TC_98() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School/University Invalid Input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        type(MLWalletTierUpgradePages.objSchoolUniversityInputField, prop.getproperty("Invalid_School/University"), "School/University Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objInvalidInputErrorMsg, getTextVal(MLWalletTierUpgradePages.objInvalidInputErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objInvalidInputErrorMsg);
            String sExceptedErrorMsg = "Organization Name must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_98, Tier Upgrade, School/University Invalid Input error msg validated");
            extentLoggerPass("TU_TC_98", "TU_TC_98, Tier Upgrade, School/University Invalid Input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeSchoolAddressErrorMsgValidation_TU_TC_99() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School Address required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        type(MLWalletTierUpgradePages.objSchoolUniversityInputField, prop.getproperty("School/University"), "School/University Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSchoolAddressErrorMsg, getTextVal(MLWalletTierUpgradePages.objSchoolAddressErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objSchoolAddressErrorMsg);
            String sExceptedErrorMsg = "School Address is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_99, Tier Upgrade, School Address required error msg validated");
            extentLoggerPass("TU_TC_99", "TU_TC_99, Tier Upgrade, School Address required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeSchoolAddressInvalidInputErrorMsgValidation_TU_TC_100() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School Address invalid Input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        type(MLWalletTierUpgradePages.objSchoolUniversityInputField, prop.getproperty("School/University"), "School/University Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        type(MLWalletTierUpgradePages.objSchoolAddressInputField, prop.getproperty("Invalid_SchoolAddress"), "School Address");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSchoolAddressInvalidErrorMsg, getTextVal(MLWalletTierUpgradePages.objSchoolAddressInvalidErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objSchoolAddressInvalidErrorMsg);
            String sExceptedErrorMsg = "Address must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_100, Tier Upgrade, School Address invalid Input error msg validated");
            extentLoggerPass("TU_TC_100", "TU_TC_100, Tier Upgrade, School Address invalid Input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeGrantProgramTypeRequiredErrorMsgValidation_TU_TC_101() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Grant/Program Type required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeGovernmentAid"), "GOVERNMENT AID/ASSISTANCE/GRANT");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objGrantProgramType, getTextVal(MLWalletTierUpgradePages.objGrantProgramType, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objGrantProgramType);
            String sExceptedErrorMsg = "Grant/Program Type is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_101, Tier Upgrade, Grant/Program Type required error msg validated");
            extentLoggerPass("TU_TC_101", "TU_TC_101, Tier Upgrade, Grant/Program Type required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeGrantProgramTypeInvalidInputErrorMsgValidation_TU_TC_102() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Grant/Program Type invalid input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeGovernmentAid"), "GOVERNMENT AID/ASSISTANCE/GRANT");
        type(MLWalletTierUpgradePages.objGrantProgramTypeInputField, prop.getproperty("Invalid_Grant/ProgramType"), "Grant/Program Input Field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objInvalidInputErrorMsg, getTextVal(MLWalletTierUpgradePages.objInvalidInputErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objInvalidInputErrorMsg);
            String sExceptedErrorMsg = "Organization Name must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_102, Tier Upgrade, Grant/Program Type invalid input error msg validated");
            extentLoggerPass("TU_TC_102", "TU_TC_102, Tier Upgrade, Grant/Program Type invalid input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeOccupationRequiredErrorMsgValidation_TU_TC_103() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Occupation required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("OtherSourceOfIncome"), "OTHER SOURCE OF INCOME");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objOccupationRequiredErrorMsg, getTextVal(MLWalletTierUpgradePages.objOccupationRequiredErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objOccupationRequiredErrorMsg);
            String sExceptedErrorMsg = "Occupation is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_103, Tier Upgrade, Occupation required error msg validated");
            extentLoggerPass("TU_TC_103", "TU_TC_103, Tier Upgrade, Occupation required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeOccupationInvalidInputErrorMsgValidation_TU_TC_104() throws Exception {
        HeaderChildNode("Tier Upgrade, Occupation invalid input error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("OtherSourceOfIncome"), "OTHER SOURCE OF INCOME");
        type(MLWalletTierUpgradePages.objOccupationInputField, prop.getproperty("Invalid_Occupation"), "Occupation Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objInvalidInputErrorMsg, getTextVal(MLWalletTierUpgradePages.objInvalidInputErrorMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objInvalidInputErrorMsg);
            String sExceptedErrorMsg = "Organization Name must contain letters and numbers only";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_104, Tier Upgrade, Occupation invalid input error msg validated");
            extentLoggerPass("TU_TC_104", "TU_TC_104, Tier Upgrade, Occupation invalid input error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSourceOfFoundsRequiredErrorMsgValidation_TU_TC_105() throws Exception {
        HeaderChildNode("Tier Upgrade, Source of Funds required error msg validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("OtherSourceOfIncome"), "OTHER SOURCE OF INCOME");
        type(MLWalletTierUpgradePages.objOccupationInputField, prop.getproperty("Occupation"), "Occupation Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSourceOfFundsRequiredErrorMSg, getTextVal(MLWalletTierUpgradePages.objSourceOfFundsRequiredErrorMSg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objSourceOfFundsRequiredErrorMSg);
            String sExceptedErrorMsg = "Source of Funds is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_105, Tier Upgrade, Source of Funds required error msg validated");
            extentLoggerPass("TU_TC_105", "TU_TC_105, Tier Upgrade, Source of Funds required error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeCompanyEmployerNameInputsValidation_TU_TC_106() throws Exception {
        HeaderChildNode("Tier Upgrade, Company Employer Name Inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objCompanyEmployerNameInputField, prop.getproperty("CompanyEmployerName"), "Company/Employer Name");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletTierUpgradePages.objCompanyEmployerNameInputValue, getTextVal(MLWalletTierUpgradePages.objCompanyEmployerNameInputValue, "Company/Employer Name input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objCompanyEmployerNameInputValue);
            String sExceptedInputValue = prop.getproperty("CompanyEmployerName");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_106, Tier Upgrade, Company Employer Name Inputs validated");
            extentLoggerPass("TU_TC_106", "TU_TC_106, Tier Upgrade, Company Employer Name Inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeWorkAddressInputsValidation_TU_TC_107() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Work Address Inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeSalary"), "SALARY/PAY/WAGE/COMMISSION");
        type(MLWalletTierUpgradePages.objWorkAddressInputField, prop.getproperty("WorkAddress"), "Work Address Field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objWorkAddressInputValue, getTextVal(MLWalletTierUpgradePages.objWorkAddressInputValue, "Work Address Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objWorkAddressInputValue);
            String sExceptedInputValue = prop.getproperty("WorkAddress");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_107, Tier Upgrade, Work Address Inputs validated");
            extentLoggerPass("TU_TC_107", "TU_TC_107, Tier Upgrade, Work Address Inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeYearRetiredInputsValidation_TU_TC_108() throws Exception {
        HeaderChildNode("Tier Upgrade, Year Retired Inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomePension"), "PENSION FOR RETIREE");
        type(MLWalletTierUpgradePages.objYearRetiredInputField, prop.getproperty("YearRetired"), "Year retired field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objYearRetiredInputValue, getTextVal(MLWalletTierUpgradePages.objYearRetiredInputValue, "Year Retired Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objYearRetiredInputValue);
            String sExceptedInputValue = prop.getproperty("YearRetired");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_108, Tier Upgrade, Year Retired Inputs validated");
            extentLoggerPass("TU_TC_108", "TU_TC_108, Tier Upgrade, Year Retired Inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeVerificationTierPerkPageNavigationAsBranchVerifiedUser_TU_TC_109() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Verification tier perk page navigation as Branch verified tier");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objViewTierBranchVerified, getTextVal(MLWalletHomePage.objViewTierBranchVerified, "Option"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            verifyElementPresent(MLWalletHomePage.objTier, getTextVal(MLWalletHomePage.objTier, "Header"));
            verificationTierPerksPageValidation();
            logger.info("TU_TC_109, Tier Upgrade, Verification tier perk page navigation validated as Branch verified tier");
            extentLoggerPass("TU_TC_109", "TU_TC_109, Tier Upgrade, Verification tier perk page navigation validated as Branch verified tier");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSchoolUniversityInputsValidation_TU_TC_110() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School/University Inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        type(MLWalletTierUpgradePages.objSchoolUniversityInputField, prop.getproperty("School/University"), "School/University Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSchoolUniversityInputValue, getTextVal(MLWalletTierUpgradePages.objSchoolUniversityInputValue, "School/University Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objSchoolUniversityInputValue);
            String sExceptedInputValue = prop.getproperty("School/University");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_110, Tier Upgrade, Tier Upgrade, School/University Inputs validated");
            extentLoggerPass("TU_TC_110", "TU_TC_110, Tier Upgrade, Tier Upgrade, School/University Inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSchoolAddressInputsValidation_TU_TC_111() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, School address inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeStudentScholarship"), "STUDENT SCHOLARSHIP ALLOWANCE");
        type(MLWalletTierUpgradePages.objSchoolAddressInputField, prop.getproperty("SchoolAddress"), "School Address");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSchoolAddressInputValue, getTextVal(MLWalletTierUpgradePages.objSchoolAddressInputValue, "School/University Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objSchoolAddressInputValue);
            String sExceptedInputValue = prop.getproperty("SchoolAddress");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_111, Tier Upgrade, Tier Upgrade, School address inputs validated");
            extentLoggerPass("TU_TC_111", "TU_TC_111, Tier Upgrade, Tier Upgrade, School address inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeGrantProgramInputsValidation_TU_TC_112() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Grant program type inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("SourceOfIncomeGovernmentAid"), "GOVERNMENT AID/ASSISTANCE/GRANT");
        type(MLWalletTierUpgradePages.objGrantProgramTypeInputField, prop.getproperty("Grant/ProgramType"), "Grant/Program Input Field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objGrantProgramTypeInputValue, getTextVal(MLWalletTierUpgradePages.objGrantProgramTypeInputValue, "Grant/ProgramType Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objGrantProgramTypeInputValue);
            String sExceptedInputValue = prop.getproperty("Grant/ProgramType");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_112, Tier Upgrade, Tier Upgrade, Grant program type inputs validated");
            extentLoggerPass("TU_TC_112", "TU_TC_112, Tier Upgrade, Tier Upgrade, Grant program type inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeOccupationInputsValidation_TU_TC_113() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Occupation Inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("OtherSourceOfIncome"), "OTHER SOURCE OF INCOME");
        type(MLWalletTierUpgradePages.objOccupationInputField, prop.getproperty("Occupation"), "Occupation Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objOccupationInputValue, getTextVal(MLWalletTierUpgradePages.objOccupationInputValue, "Occupation Input value"))) {
            String sActualInputValue = getText(MLWalletTierUpgradePages.objOccupationInputValue);
            String sExceptedInputValue = prop.getproperty("Occupation");
            assertionValidation(sActualInputValue, sExceptedInputValue);
            logger.info("TU_TC_113, Tier Upgrade, Tier Upgrade, Occupation inputs validated");
            extentLoggerPass("TU_TC_113", "TU_TC_113, Tier Upgrade, Tier Upgrade, Occupation inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void tierUpgradeSourceOfFoundsInputValidation_TU_TC_114() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Source of Funds inputs validation");
        waitTime(2000);
        changeNumberPage();
        accountDetailsPageNavigation(prop.getproperty("New_BuyerTier"));
        selectSourceOfIncome(prop.getproperty("OtherSourceOfIncome"), "OTHER SOURCE OF INCOME");
        type(MLWalletTierUpgradePages.objSourceOfFundsInputField, prop.getproperty("SourceOfFunds"), "Occupation Input field");
        verifyElementPresentAndClick(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        click(MLWalletTierUpgradePages.objConfirmDetails, getTextVal(MLWalletTierUpgradePages.objConfirmDetails, "Button"));
        if (verifyElementPresent(MLWalletTierUpgradePages.objSourceOfFundsInputValue, getTextVal(MLWalletTierUpgradePages.objSourceOfFundsInputValue, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletTierUpgradePages.objSourceOfFundsInputValue);
            String sExceptedErrorMsg = prop.getproperty("SourceOfFunds");
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TU_TC_114, Tier Upgrade, Source of Funds inputs validated");
            extentLoggerPass("TU_TC_114", "TU_TC_114, Tier Upgrade, Source of Funds inputs validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
