package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletUseQRScripts extends BaseTest{


    @Test(priority = 1)
    public void useQRGenerateQRCode_QR_TC_01() throws Exception {
        mlWalletUseQR.useQRGenerateQRCode_QR_TC_01();
    }

    @Test(priority = 2)
    public void useQRSendMoneyToAnyMLWalletUser_QR_TC_02() throws Exception {
        mlWalletUseQR.useQRSendMoneyToAnyMLWalletUser_QR_TC_02();
    }

    @Test(priority = 3)
    public void useQRInvalidQRCodeValidation_QR_TC_03() throws Exception {
        mlWalletUseQR.useQRInvalidQRCodeValidation_QR_TC_03();
    }

    @Test(priority = 4)
    public void useQR_WalletToWalletReceivedMoneyValidation_QR_TC_04() throws Exception {
        mlWalletUseQR.useQR_WalletToWalletReceivedMoneyValidation_QR_TC_04("10");
    }

    @Test(priority = 5)
    public void useQRScanningReceiverQRCOde_QR_TC_05() throws Exception {
        mlWalletUseQR.useQRScanningReceiverQRCOde_QR_TC_05();
    }

    @Test(priority = 6)
    public void useQRPageUIValidation_QR_TC_06() throws Exception {
        mlWalletUseQR.useQRPageUIValidation_QR_TC_06();
    }

    @Test(priority = 7)
    public void useQRPageBackBtnValidation_QR_TC_07() throws Exception {
        mlWalletUseQR.useQRPageBackBtnValidation_QR_TC_07();
    }

    @Test(priority = 8)
    public void useQR_GenerateQRPageBackBtnValidation_QR_TC_08() throws Exception {
        mlWalletUseQR.useQR_GenerateQRPageBackBtnValidation_QR_TC_08();
    }

    @Test(priority = 9)
    public void useQR_GenerateQRPageUIValidation_QR_TC_11() throws Exception {
        mlWalletUseQR.useQR_GenerateQRPageUIValidation_QR_TC_11();
    }

    @Test(priority = 10)
    public void useQR_ToMLWalletScreenUIValidation_QR_TC_12() throws Exception {
        mlWalletUseQR.useQR_ToMLWalletScreenUIValidation_QR_TC_12();
    }

    @Test(priority = 11)
    public void useQR_EmptyAmountFieldValidation_QR_TC_13() throws Exception {
        mlWalletUseQR.useQR_EmptyAmountFieldValidation_QR_TC_13();
    }

    @Test(priority = 12)
    public void useQR_ConfirmDetailsScreenUIValidation_QR_TC_14() throws Exception {
        mlWalletUseQR.useQR_ConfirmDetailsScreenUIValidation_QR_TC_14("10");
    }

    @Test(priority = 13)
    public void useQR_OneTimePinScreenUIValidation_QR_TC_15() throws Exception {
        mlWalletUseQR.useQR_OneTimePinScreenUIValidation_QR_TC_15();
    }

    @Test(priority = 14)
    public void useQR_SendMoneyToMlWalletSuccessScreenUIValidation_QR_TC_16() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMlWalletSuccessScreenUIValidation_QR_TC_16();
    }

    @Test(priority = 15)
    public void useQR_RecentTransactionInHomeScreenUIValidation_QR_TC_17() throws Exception {
        mlWalletUseQR.useQR_RecentTransactionInHomeScreenUIValidation_QR_TC_17();
    }

    @Test(priority = 16)
    public void useQR_TransactionDetailsScreenUIValidation_QR_TC_18() throws Exception {
        mlWalletUseQR.useQR_TransactionDetailsScreenUIValidation_QR_TC_18();
    }

//    @Test(priority = 17)
//    public void useQR_CameraPermissionPopupValidation_QR_TC_19() throws Exception {
//        mlWalletUseQR.useQR_CameraPermissionPopupValidation_QR_TC_19();
//    }
//
//    @Test(priority = 18)
//    public void useQR_CameraPermissionPopupDenyButtonFunctionality_QR_TC_20() throws Exception {
//        mlWalletUseQR.useQR_CameraPermissionPopupDenyButtonFunctionality_QR_TC_20();
//    }
//
//    @Test(priority = 19)
//    public void useQR_CameraPermissionPopupOnlyThisTimeButtonFunctionality_QR_TC_21() throws Exception {
//        mlWalletUseQR.useQR_CameraPermissionPopupOnlyThisTimeButtonFunctionality_QR_TC_21();
//    }

//    @Test(priority = 20)
//    public void useQR_CameraPermissionPopupWhileUsingTheAppButtonFunctionality_QR_TC_22() throws Exception {
//        mlWalletUseQR.useQR_CameraPermissionPopupWhileUsingTheAppButtonFunctionality_QR_TC_22();
//    }
//     @Test(priority = 22)
//    public void useQR_ScanQRCodeAfterClickingOnDenyButton_QR_TC_24() throws Exception {
//        mlWalletUseQR.useQR_ScanQRCodeAfterClickingOnDenyButton_QR_TC_24();
//    }
//
//    //  @Test(priority = 23) Non Feasible
//    public void UseQR_SendMoneyToMLWalletLocationPopupValidation_QR_TC_026() throws Exception {
//        MLWalletBusinessLogic.UseQR_SendMoneyToMLWalletLocationPopupValidation_QR_TC_026();
//    }
//
//    // @Test(priority = 24)  Non Feasible
//    public void useQR_SendMoneyToMLWalletLocationDenyFunctionality_QR_TC_027() throws Exception {
//        MLWalletBusinessLogic.useQR_SendMoneyToMLWalletLocationDenyFunctionality_QR_TC_027();
//    }
//
//
//
//    // @Test(priority = 28)  Non Feasible
//    public void useQR_CameraPermissionRequiredPopupValidation_QR_TC_31() throws Exception {
//        MLWalletBusinessLogic.useQR_CameraPermissionRequiredPopupValidation_QR_TC_31();
//    }

    @Test(priority = 29)
    public void useQR_TransactionValidationAfterMinimizingTheApp_QR_TC_33() throws Exception {
        mlWalletUseQR.useQR_TransactionValidationAfterMinimizingTheApp_QR_TC_33();
    }

    @Test(priority = 30)
    public void useQR_SendMoneyToMLWalletWhenReceiverQRCodeCapturedByCamera_QR_TC_39() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletWhenReceiverQRCodeCapturedByCamera_QR_TC_39();
    }
    @Test(priority = 31)
    public void useQR_SendMoneyToMLWalletInOTPPopupValidation_QR_TC_40() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletInOTPPopupValidation_QR_TC_40();
    }

    @Test(priority = 32)
    public void useQR_SendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_QR_TC_41() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_QR_TC_41();
    }

    @Test(priority = 33)
    public void useQR_SendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_QR_TC_42() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_QR_TC_42();
    }

    @Test(priority = 34)
    public void useQR_SendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_QR_TC_43() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_QR_TC_43();
    }

    @Test(priority = 35)
    public void useQR_SendMoneyToMLWalletOTPContinueBtnFunctionality_QR_TC_44() throws Exception {
        mlWalletUseQR.useQR_SendMoneyToMLWalletOTPContinueBtnFunctionality_QR_TC_44();
    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
