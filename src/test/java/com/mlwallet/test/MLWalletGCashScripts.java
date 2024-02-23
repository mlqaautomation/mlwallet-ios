package com.mlwallet.test;
import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletGCashScripts extends BaseTest{

//    @Test(priority = 1)
//    public void GC_Land_TC_01_Verify_user_able_see_Gcash_icon_Dashborad() throws Exception {
//        mlWalletGCash.GC_Land_TC_01_Verify_user_able_see_Gcash_icon_Dashborad();
//    }
//
//    @Test(priority = 2)
//    public void GC_Land_TC_02_Verify_user_able_navigate_Gcash_services_page_tapping_Gcash_icon() throws Exception {
//        mlWalletGCash.GC_Land_TC_02_Verify_user_able_navigate_Gcash_services_page_tapping_Gcash_icon();
//    }
//
//    @Test(priority = 3)
//    public void GC_Land_TC_03_Verify_UI_Gcash_Services_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_03_Verify_UI_Gcash_Services_page();
//    }
//
//    @Test(priority = 4)
//    public void GC_Land_TC_04_Verify_user_redirected_back_Dashboard_tapping_back_arrow_btn() throws Exception {
//        mlWalletGCash.GC_Land_TC_04_Verify_user_redirected_back_Dashboard_tapping_back_arrow_btn();
//    }
//
//    @Test(priority = 5)
//    public void GC_Land_TC_43_Verify_UI_Send_Money_Gcash_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_43_Verify_UI_Send_Money_Gcash_page();
//    }
//
//    @Test(priority = 6)
//    public void GC_Land_TC_49_Verify_user_error_input_empty_Receiver_MobileNo_Send_Money_Gcash_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_49_Verify_user_error_input_empty_Receiver_MobileNo_Send_Money_Gcash_page();
//    }
//
//    @Test(priority = 7)
//    public void GC_Land_TC_50_Verify_user_error_input_SymbolorSpecialChar_Receiver_MobileNo_Send_Money_Gcash_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_50_Verify_user_error_input_SymbolorSpecialChar_Receiver_MobileNo_Send_Money_Gcash_page();
//    }
//
//    @Test(priority = 7)
//    public void GC_Land_TC_54_Verify_user_error_input_2Decimal_amount_Send_Money_Gcash_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_54_Verify_user_error_input_2Decimal_amount_Send_Money_Gcash_page();
//    }
//
//    @Test(priority = 8)
//    public void GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation() throws Exception {
//        mlWalletGCash.GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation();
//    }
//
//    @Test(priority = 9)
//    public void GC_Land_TC_58_Validate_user_able_see_NextBtn_Send_money_Gcash_page() throws Exception {
//        mlWalletGCash.GC_Land_TC_58_Validate_user_able_see_NextBtn_Send_money_Gcash_page();
//    }
//
//    @Test(priority = 10)
//    public void GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation() throws Exception {
//        mlWalletGCash.GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation();
//    }
//
//    @Test(priority = 11)
//    public void GC_SM_TC_60_InAppOtp_Page_Redirection_Validation() throws Exception {
//        mlWalletGCash.GC_SM_TC_60_InAppOtp_Page_Redirection_Validation();
//    }
//
//    --------61 cannot automate
//    @Test(priority = 13)
//    public void GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry() throws Exception {
//        mlWalletGCash.GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry();
//    }
//
//    --------69 cannot automate
//    -------70 cannot automate
//    @Test(priority = 16)
//    public void GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money() throws Exception {
//        mlWalletGCash.GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money();
//    }
//
//    @Test(priority = 17)
//    public void GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page() throws Exception {
//        mlWalletGCash.GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page();
//    }
//
//    ------------Failed TC_76
//    @Test(priority = 18)
//    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
//        mlWalletGCash.GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page();
//    }

//    @Test(priority = 19)
//    public void GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details() throws Exception {
//        mlWalletGCash.GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details();
//    }
//
//    @Test(priority = 20)
//    public void GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier() throws Exception {
//        mlWalletGCash.GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier();
//    }
//
//    @Test(priority = 21)
//    public void GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified() throws Exception {
//        mlWalletGCash.GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified();
//    }
//
//    ---------------------------- Block by Back to Home
//    @Test(priority = 22)
//    public void GC_SM_TC_132_SendMoney_as_SemiVerified() throws Exception {
//        mlWalletGCash.GC_SM_TC_132_SendMoney_as_SemiVerified();
//    }

//    @Test(priority = 23)
//    public void GC_RM_TC_135_SendMoney_as_BranchVerified() throws Exception {
//        mlWalletGCash.GC_RM_TC_135_SendMoney_as_BranchVerified();
//    }
//
//    @Test(priority = 24)
//    public void GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified() throws Exception {
//        mlWalletGCash.GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified();
//    }
//
//    @Test(priority = 25)
//    public void GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified() throws Exception {
//        mlWalletGCash.GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified();
//    }
//
    @Test(priority = 26)
    public void GC_RM_TC_180_SendMoney_NoGCash_thru_MLWallet() throws Exception {
        mlWalletGCash.GC_RM_TC_180_SendMoney_NoGCash_thru_MLWallet();
    }
//
//    @Test(priority = 27)
//    public void GC_RM_TC_181_SendMoney_NoGCash_thru_KwartaPadala() throws Exception {
//        mlWalletGCash.GC_RM_TC_181_SendMoney_NoGCash_thru_KwartaPadala();
//    }
//
//    @Test(priority = 28)
//    public void GC_RM_TC_182_Contacts() throws Exception {
//        mlWalletGCash.GC_RM_TC_182_Contacts();
//    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }
}
