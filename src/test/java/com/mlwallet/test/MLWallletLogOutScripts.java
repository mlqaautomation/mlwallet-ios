package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWallletLogOutScripts extends BaseTest{

    @Test(priority = 1)
    public void logOutMinimizeAndRelaunch_Lout_TC_03() throws Exception {
        mlWalletLogOut.logOutMinimizeAndRelaunch_Lout_TC_03();
    }

    @Test(priority = 2)
    public void logOutAppKillAndRelaunchLout_TC_04() throws Exception {
        mlWalletLogOut.logOutAppKillAndRelaunch_Lout_TC_04();
    }

    @Test(priority = 3)
    public void logOUtPopUpValidation_Lout_TC_05() throws Exception {
        mlWalletLogOut.logOUtPopUpValidation_Lout_TC_05("true");
    }

    @Test(priority = 4)
    public void logOutPopUpCancelBtnValidation_Lout_TC_06() throws Exception {
        mlWalletLogOut.logOutPopUpCancelBtnValidation_Lout_TC_06();
    }

    @Test(priority = 5)
    public void logOutPopUpLogOutBtnValidation_Lout_TC_07() throws Exception {
        mlWalletLogOut.logOutPopUpLogOutBtnValidation_Lout_TC_07();
    }

    @Test(priority = 6)
    public void logoutChangeNumberUIValidation_Lout_TC_08() throws Exception {
        mlWalletLogOut.logoutChangeNumberUIValidation_Lout_TC_08();
    }

    @Test(priority = 7)
    public void logInWithChangeNumber_Lout_TC_09() throws Exception {
        mlWalletLogOut.logInWithChangeNumber_Lout_TC_09();
    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
