package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletTroubleSigningInScripts extends BaseTest{
    @Test(priority = 1)
    public void troubleSigningInPageNavigationFromMpinScreen_TS_TC_01() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInPageNavigationFromMpinScreen_TS_TC_01();
    }
    @Test(priority = 2)
    public void troubleSigningInPageNavigationFromLoginScreen_TS_TC_10() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInPageNavigationFromLoginScreen_TS_TC_10();
    }
    @Test(priority = 3)
    public void troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11();
    }
    @Test(priority = 4)
    public void troubleSigningInClearFormFunctionality_TS_TC_12() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInClearFormFunctionality_TS_TC_12();
    }
    @Test(priority = 5)
    public void troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13();
    }
    @Test(priority = 6)
    public void troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14();
    }
    @Test(priority = 7)
    public void troubleSigningInEmptyFullNameFunctionality_TS_TC_15() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInEmptyFullNameFunctionality_TS_TC_15();
    }
    @Test(priority = 8)
    public void troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16();
    }
    @Test(priority = 9)
    public void troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17() throws Exception {
        mlWalletTroubleSigningIn.troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17();
    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
