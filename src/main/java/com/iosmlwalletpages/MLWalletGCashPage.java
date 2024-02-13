package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletGCashPage {

    //---------------------Dashboard-------------------v
    public static By objGcash =By.xpath("//XCUIElementTypeOther[@name=\"GCash\"]");
    //-----------------GCash Services Page--------------v
    public static By objSendMoneyBtn =By.xpath("(//XCUIElementTypeOther[@name=\"Send Money Send money from ML Wallet to a registered GCash mobile number. Fees may apply. \uE5CC\"])[3]");
    public static By objGcashServicesLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"GCash Services\"]");
    public static By objBackBtn =By.xpath("//XCUIElementTypeOther[@name=\"\uE5CB\"]");
    //-----------------Send Money to GCash Page-----------v
    public static By objGCashNoTextbox =By.xpath("//XCUIElementTypeOther[@name=\"9** *** ****\"]/XCUIElementTypeTextField\n");
    public static By objSendMoneyGCashLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"Send Money to GCash\"]\n");
    public static By objGCashNolabel =By.xpath("//XCUIElementTypeStaticText[@label=\"GCash Mobile Number\"]");
    public static By objTapHideKeyboard =By.xpath("//XCUIElementTypeOther[@name=\"NCYAQZ\"]\n");
    public static By objSelectfromContactsBtn =By.xpath("//XCUIElementTypeOther[@label=\"Select from Contacts\"]");
    public static By objGcashNextBtn =By.xpath("//XCUIElementTypeOther[@label=\"Next\"]\n");
    public static By objGetErrMsg (String msg){
        return By.xpath("//*[@text='"+msg+"']");
    }
    public static By objMobileNoIsRequiredText =By.xpath("//XCUIElementTypeStaticText[@name=\"Mobile number is required\"]");
    public static By objMobileNoIsInvalidText =By.xpath("//XCUIElementTypeStaticText[@name=\"Mobile number is invalid\"]");
    public static By objAmountIsInvalidText =By.xpath("//XCUIElementTypeStaticText[@name=\"The amount should not be less than 1\"]");
    public static By objAmountSendLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"Amount to Send\"]");
    public static By objAmountSendTextbox =By.xpath("//XCUIElementTypeOther[@name=\"MS6O4X\"]");
    public static By objTapHideNoKeyboard =By.xpath("//XCUIElementTypeOther[@name=\"RMOP8W\"]");

    //----------------If Press Select Contact Button-----------v
    public static By objContactsBtn =By.xpath("//XCUIElementTypeOther[@name=\"4UB1RX\"]");
    public static By objFavoritesBtn =By.xpath("//XCUIElementTypeOther[@name=\"Favorites\"]");
    public static By objOkAllowContacts =By.xpath("//XCUIElementTypeButton[@name=\"OK\"]");
    public static By objSearchBox =By.xpath("//XCUIElementTypeTextField[@name=\"OO7ML4\"]\n");
    public static By objContactsLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"Contacts\"]\n");
    public static By objSelectContactsBtn =By.xpath("(//XCUIElementTypeOther[@name=\"Contacts\"])[2]\n");

    //----------------Confirm Details-----------v
    public static By objComfirmDetailsLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"Confirm Details\"]\n");
    public static By objSendMoneytoGcashLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"Send Money to GCash\"]\n");
    public static By objReceiverGcashNoValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Receiver GCash Mobile #\"])[2]");
    public static By objSenderNameValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Sender Name\"])[2]");
    public static By objSenderMobileNoValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Sender Mobile No.\"])[2]");
    public static By objAmountValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Amount\"])[2]");
    public static By objSerciceFeeValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Service Fee\"])[2]");
    public static By objTotalValue =By.xpath("(//XCUIElementTypeStaticText[@name=\"Total\"])[2]");
    public static By objGcashConfirmBtn =By.xpath("//XCUIElementTypeOther[@label=\"Confirm\"]\n");
    public static By objAllowOnceBtn =By.xpath("//XCUIElementTypeButton[@name=\"Allow Once\"]");
    public static By objInvalidTierBuyerVer = By.xpath("//XCUIElementTypeStaticText[@name=\"Send to GCash is not allowed for customers at this verification level. Please upgrade your account to use this service.\"]");
    public static By objInvalid50kAboveTiersVer = By.xpath("//XCUIElementTypeStaticText[@name=\"The maximum Send to GCash per transaction set for your verification level is P50,000.00. Please try again.\"]");
    public static By objUpgradeNow =By.xpath("//XCUIElementTypeOther[@name=\"modal-confirm-button\"]");

    //----------------No Gcash other Payment Method-----------v
    public static By objNoGCashOtherOptionLabel =By.xpath("//XCUIElementTypeStaticText[@name=\"This number does not have a GCash-registered account. Please check the number and try again.\"]");
    public static By objSendViaMLKwartaWallelabel =By.xpath("//XCUIElementTypeStaticText[@name=\"You may also use ML Kwarta Padala to send cash to anyone in the Philippines.\"]");
    public static By objSendViaMLWalletlabel =By.xpath("//XCUIElementTypeStaticText[@name=\"You may also Send Money to any ML Wallet User.\"]");
    public static By objSendViaMLKwartaPadalaBtn =By.xpath("//XCUIElementTypeOther[@label=\"Send Money via ML Kwarta Padala\"]");
    public static By objSendViaMLWalletBtn =By.xpath("//XCUIElementTypeOther[@label=\"Send Money to ML Wallet User\"]");
    public static By objCloseBtn =By.xpath("//XCUIElementTypeOther[@name=\"Close\"]");
    public static By objProceedBtn =By.xpath("//XCUIElementTypeOther[@name=\"Yes, Proceed Transaction\"]");

    //------------------TransactionDetails-------------v
    public static By objTransactionDetailsHeader =By.xpath("//XCUIElementTypeStaticText[@name=\"Transaction Details\"]");
    public static By objSendMoneytoGCashTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Send Money to GCash\"]");
    public static By objAmountSendTransactText = By.xpath("//XCUIElementTypeStaticText[@name=\"Send Money to GCash\"]/following-sibling::*[1]");
    public static By objReceiverGcashNoTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Receiver GCash Mobile #\"])[2]\n");
    public static By objSenderNameTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Sender Name\"])[2]\n");
    public static By objSenderMobileNoTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Sender Mobile No.\"])[2]\n");
    public static By objAmountTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Amount\"])[2]");
    public static By objServiceFeeTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Service Fee\"])[2]\n");
    public static By objTotalTransactValue = By.xpath("(//XCUIElementTypeStaticText[@name=\"Total\"])[2]");
    //--------Back to Dashboard----------v
    public static By objBackToHomePage = By.xpath("//XCUIElementTypeOther[@label=\"Back To Home Page\"]");
    //--------Back to Send Money to GCash----------v
    public static By objNewTransactionBtn = By.xpath("//XCUIElementTypeOther[@label=\"New Transaction\"]\n");

    public static By objIsRequired(String val){
        return By.xpath("//XCUIElementTypeStaticText[@name=\"" + val + "\"]");
    }
}
