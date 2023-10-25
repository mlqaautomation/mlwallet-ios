package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletBuyELoadScripts extends BaseTest{

    @Test(priority = 1)
    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29() throws Exception {
        mlWalletBuyELoad.buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(prop.getproperty("Fully_Verified"),3);
    }
//    @Test(priority = 2)
//    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45() throws Exception {
//        mlWalletBuyELoad.buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_45(prop.getproperty("Fully_Verified"),3);
//    }

    @Test(priority = 3)
    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_48() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_48(prop.getproperty("Fully_Verified"),3);
    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
