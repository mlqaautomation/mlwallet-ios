package com.business.mlwallet;
import com.driverInstance.DriverManager;
import com.iosmlwalletpages.*;
import com.iosmlwalletpages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.utility.Utilities.*;

public class MLWalletShopSafe extends BaseClass{

    public MLWalletShopSafe() {
        super();

    }

    public void SSM_TC_01_Verify_if_the_Shop_Safe_button_Icon_Visible() throws Exception {
        ExtentReporter.HeaderChildNode("To verify if the Shop Safe button Icon Visible");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresent(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        logger.info("Shop Safe Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_01", "To verify if the Shop Safe button Icon Visible");
    }
    public void SSM_TC_02_Verify_click_Shop_Safe_button_Redirect_to_Shop_Safe_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify click Shop Safe button Redirect to Shop Safe Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        if(verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel,"Shop Safe Page")){
            verifyElementPresent(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
            verifyElementPresent(MLWalletShopSafePage.objInvitesLabel,"Invites Label");
            verifyElementPresent(MLWalletShopSafePage.objOngoingTransactLabel,"Ongoing Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objCompletedTransactLabel,"Completed Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objCancelledTransactLabel,"Cancelled Transact Label");
            verifyElementPresent(MLWalletShopSafePage.objReturnedTransactLabel,"Returned Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objInvitesTransactTxtBtn,"Invites Transaction Text Button");
            verifyElementPresent(MLWalletShopSafePage.objOngoingTransactTxtBtn,"Ongoing Transaction Text Button");
        }
        logger.info("Redirect to Shop Safe Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_02", "To verify click Shop Safe button Redirect to Shop Safe Page");
    }

    public void SSM_TC_03_Verify_click_Start_Transaction_button_Redirect_to_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify click Start Transaction button Redirect to Create Transaction Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
        if(verifyElementPresent(MLWalletShopSafePage.objCreateTransactLabel,"Start Transaction Button")){
            verifyElementPresent(MLWalletShopSafePage.objBackBtn,"Back Button");
            verifyElementPresent(MLWalletShopSafePage.objSellerNoTxtbx,"Seller Number Textbox");
            verifyElementPresent(MLWalletShopSafePage.objInviteSellerBtn,"Invite Seller Button");
        }
        logger.info("Redirect to Create Transaction Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "To verify click Start Transaction button Redirect to Create Transaction Page");
    }

    public void SSM_TC_04_Verify_enter_valid_seller_number_in_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify enter valid seller number in Create Transaction Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
        verifyElementPresent(MLWalletShopSafePage.objCreateTransactLabel,"Start Transaction Button");
        verifyElementPresent(MLWalletShopSafePage.objBackBtn,"Back Button");
        verifyElementPresent(MLWalletShopSafePage.objSellerNoTxtbx,"Seller Number Textbox");
        type(MLWalletShopSafePage.objSellerNoTxtbx, shopsafeprop.getproperty("VaildShopSafeNumber"), "Type Valid Number");
        click(MLWalletShopSafePage.objInviteSellerBtn,"Invite Seller Button");
        if(verifyElementPresent(MLWalletShopSafePage.objSuccessfInviteLabel,"Successful Invite")){
            verifyElementPresent(MLWalletShopSafePage.objOkayBtn,"Okay Button");
        }
        logger.info("Enter valid seller number in Create Transaction Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_04", "To verify enter valid seller number in Create Transaction Page");
    }

    public void SSM_TC_05_Verify_buyer_request_invites_click_View_Invitations_Button_in_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify buyer request invites click View Invitations Button in Invites Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        if(verifyElementPresentAndClick(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            verifyElementPresent(MLWalletShopSafePage.objBuyerDetailsLabel,"Buyer Details Label");
            verifyElementPresent(MLWalletShopSafePage.objBuyerNameVal,"Buyer Name Value");
            verifyElementPresent(MLWalletShopSafePage.objBuyerNoVal,"Buyer Number Value");
            verifyElementPresent(MLWalletShopSafePage.objSellerDetailsLabel,"Seller Details Label");
            verifyElementPresent(MLWalletShopSafePage.objSellerNoVal,"Seller Number Value");
            verifyElementPresent(MLWalletShopSafePage.objCancelInviteBtn,"Cancel Invite Button");
            verifyElementPresent(MLWalletShopSafePage.objBackToHomesBtn,"Back To Homes Button");
        }
        logger.info("View buyer request new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify buyer request invites click View Invitations Button in Invites Page");
    }
    public void SSM_TC_06_Verify_seller_received_invites_click_View_Invitations_Button_in_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        if(verifyElementPresentAndClick(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            verifyElementPresent(MLWalletShopSafePage.objPicOfItemBtn,"Picture Of Item Button");
            verifyElementPresent(MLWalletShopSafePage.objItemInformation,"Item Information label");
            verifyElementPresent(MLWalletShopSafePage.objItemNameTxtBx,"Item Name textbox");
            verifyElementPresent(MLWalletShopSafePage.objItemDescriptTxtBx,"Item Description TextBox");
            verifyElementPresent(MLWalletShopSafePage.objBrandTxtBx,"Brand TextBox");
            verifyElementPresent(MLWalletShopSafePage.objModelNoTxtbox,"Model No TextBox");
            verifyElementPresent(MLWalletShopSafePage.objItemQuantityTxtbx,"Item Quantity Textbx");
            verifyElementPresent(MLWalletShopSafePage.objCategoryDropDownlist,"Category DropDownlist");
            verifyElementPresent(MLWalletShopSafePage.objItemPriceTxtbx,"Item Price Textbox");
            verifyElementPresent(MLWalletShopSafePage.objItemDimensionLabel,"Item Dimension Label");
            verifyElementPresent(MLWalletShopSafePage.objWeightRangeDropDownList,"Weight Range DropDownList");
            verifyElementPresent(MLWalletShopSafePage.objNearestDropOffGMap,"Nearest Drop Off GMap");
            verifyElementPresent(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
            verifyElementPresent(MLWalletShopSafePage.objDeclineBtn,"Decline Button");
        }
        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }


}
