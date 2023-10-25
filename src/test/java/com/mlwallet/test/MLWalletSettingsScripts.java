package com.mlwallet.test;

import com.business.mlwallet.MLWalletSettings;
import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletSettingsScripts extends BaseTest{

    @Test(priority = 1)
    public void settingsAccountDetailsValidation_SS_TC_01() throws Exception {
        mlWalletSettings.settingsAccountDetailsValidation_SS_TC_01();
    }
//    @Test(priority = 2)
//    public void settingsValidMLPinValidation_SS_TC_02() throws Exception {
//        mlWalletSettings.settingsValidMLPinValidation_SS_TC_02();
//    }
    @Test(priority = 3)
    public void settingsInvalidMLPinValidation_SS_TC_03() throws Exception {
        mlWalletSettings.settingsInvalidMLPinValidation_SS_TC_03();
    }
//    @Test(priority = 4)
//    public void settingAccRecovery_SS_TC_05() throws Exception {
//        mlWalletSettings.settingAccRecovery_SS_TC_05();
//    }
//    @Test(priority = 5)
//    public void settingsPageUIValidation_SS_TC_06() throws Exception {
//        mlWalletSettings.settingsPageUIValidation_SS_TC_06();
//    }
//    @Test(priority = 6)
//    public void settingsBackBtnValidation_SS_TC_07() throws Exception {
//        mlWalletSettings.settingsBackBtnValidation_SS_TC_07();
//    }
//    @Test(priority = 7)
//    public void settingsDeleteAccountPopUpUIValidation_SS_TC_10() throws Exception {
//        mlWalletSettings.settingsDeleteAccountPopUpUIValidation_SS_TC_10();
//    }
//    @Test(priority = 8)
//    public void settingsChangeMLPinNavigation_SS_TC_12() throws Exception {
//        mlWalletSettings.settingsChangeMLPinNavigation_SS_TC_12();
//    }
//    @Test(priority = 9)
//    public void settingsChangeMlPinBackBtnValidation_SS_TC_13() throws Exception {
//        mlWalletSettings.settingsChangeMlPinBackBtnValidation_SS_TC_13();
//    }
//    @Test(priority = 10)
//    public void settingsAccountDetailsNavigation_SS_TC_14() throws Exception {
//        mlWalletSettings.settingsAccountDetailsNavigation_SS_TC_14();
//    }
//    @Test(priority = 11)
//    public void settingsAccountDetailsBackBtnValidation_SS_TC_15() throws Exception {
//        mlWalletSettings.settingsAccountDetailsBackBtnValidation_SS_TC_15();
//    }
//    @Test(priority = 12)
//    public void settingChangeMLPinUIValidation_SS_TC_16() throws Exception {
//        mlWalletSettings.settingChangeMLPinUIValidation_SS_TC_16();
//    }
//    @Test(priority = 13)
//    public void settingsAccountRecoveryUIValidation_SS_TC_17() throws Exception {
//        mlWalletSettings.settingsAccountRecoveryUIValidation_SS_TC_17();
//    }
//    @Test(priority = 14)
//    public void settingsDeleteAccountCancelBtnValidation_SS_TC_18() throws Exception {
//        mlWalletSettings.settingsDeleteAccountCancelBtnValidation_SS_TC_18();
//    }
//    @Test(priority = 15)
//    public void settingsAccountRecoveryNavigation_SS_TC_21() throws Exception {
//        mlWalletSettings.settingsAccountRecoveryNavigation_SS_TC_21();
//    }
//    @Test(priority = 16)
//    public void settingsTroubleSigningInBackBtnValidation_SS_TC_22() throws Exception {
//        mlWalletSettings.settingsTroubleSigningInBackBtnValidation_SS_TC_22();
//    }
//    @Test(priority = 17)
//    public void settingsDeleteAccountPageUIValidation_SS_TC_25() throws Exception {
//        mlWalletSettings.settingsDeleteAccountPageUIValidation_SS_TC_25();
//    }
//    @Test(priority = 18)
//    public void settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26() throws Exception {
//        mlWalletSettings.settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26();
//    }
//    @Test(priority = 19)
//    public void settingsDeleteAccountPageBackButtonValidation_SS_TC_27() throws Exception {
//        mlWalletSettings.settingsDeleteAccountPageBackButtonValidation_SS_TC_27();
//    }
//    @Test(priority = 20)
//    public void settingsDeleteAccountButtonFunctionality_SS_TC_28() throws Exception {
//        mlWalletSettings.settingsDeleteAccountButtonFunctionality_SS_TC_28();
//    }
//    @Test(priority = 21)
//    public void settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29() throws Exception {
//        mlWalletSettings.settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29();
//    }
//    @Test(priority = 22)
//    public void settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30() throws Exception {
//        mlWalletSettings.settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30();
//    }
//    @Test(priority = 23)
//    public void settingsDeleteAccountMLPinPageUIValidation_SS_TC_31() throws Exception {
//        mlWalletSettings.settingsDeleteAccountMLPinPageUIValidation_SS_TC_31();
//    }
//    @Test(priority = 24)
//    public void settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32() throws Exception {
//        mlWalletSettings.settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32();
//    }
//    @Test(priority = 25)
//    public void settingsDeleteAccountInvalidMLPin_SS_TC_34() throws Exception {
//        mlWalletSettings.settingsDeleteAccountInvalidMLPin_SS_TC_34();
//    }
//    @Test(priority = 26)
//    public void settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35() throws Exception {
//        mlWalletSettings.settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35();
//    }
//    @Test(priority = 27)
//    public void settingsNotificationNavigationValidation_SS_TC_08() throws Exception {
//        mlWalletSettings.settingsNotificationNavigationValidation_SS_TC_08();
//    }
//    @Test(priority = 28)
//    public void settingsNotificationBackArrowBtnValidation_SS_TC_09() throws Exception {
//        mlWalletSettings.settingsNotificationBackArrowBtnValidation_SS_TC_09();
//    }
//    @Test(priority = 29)
//    public void settingDeleteAccountProceedBtnFunctionality_SS_TC_11() throws Exception {
//        mlWalletSettings.settingDeleteAccountProceedBtnFunctionality_SS_TC_11();
//    }
//    @Test(priority = 30)
//    public void settingsNotificationPageUIValidation_SS_TC_19() throws Exception {
//        mlWalletSettings.settingsNotificationPageUIValidation_SS_TC_19();
//    }
//    @Test(priority = 31)
//    public void settingsDeleteBuyerTierAccountValidation_SS_TC_40() throws Exception {
//        mlWalletSettings.settingsDeleteBuyerTierAccountValidation_SS_TC_40();
//    }






//    public void settingsBiometricsLogin_SS_TC_04() throws Exception {
//        mlWalletSettingsScripts.settingsBiometricsLogin_SS_TC_04();
//    }
//    public void settingsBiometricsLoginNavigation_SS_TC_23() throws Exception {
//        mlWalletSettingsScripts.settingsBiometricsLoginNavigation_SS_TC_23();
//    }
//
//    public void settingsBiometricsLoginBackBtnValidation_SS_TC_24() throws Exception {
//        mlWalletSettingsScripts.settingsBiometricsLoginBackBtnValidation_SS_TC_24();
//    }
//    public void settingsBiometricsLoginUIValidation_SS_TC_20() throws Exception {
//        mlWalletSettingsScripts.settingsBiometricsLoginUIValidation_SS_TC_20();
//    }
    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }

}
