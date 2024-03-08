package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletShopSafePage {
    //--------Home Dashboard
    public static By objShopSafeIconBtn = By.xpath("//XCUIElementTypeOther[@name=\"ShopSafe\"]");
    //-------Shop Safe Page
    public static By objShopSafeLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Shop Safe\"]");
    public static By objStartTransactBtn = By.xpath("//XCUIElementTypeOther[@name=\"Start Transaction  +\"]");
    public static By objInvitesLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Invites\"]");
    public static By objOngoingTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Ongoing Transactions\"]");
    public static By objCompletedTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Completed Transactions\"]");
    public static By objCancelledTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Cancelled Transactions\"]");
    public static By objReturnedTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Returned Transactions\"]");
    public static By objInvitesTransactTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"View All Invites\"])[1]");
    public static By objOngoingTransactTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"View All Invites\"])[2]");
    //------- Create Transaction Page
    public static By objCreateTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Create Transaction\"]");
    public static By objBackBtn = By.xpath("//XCUIElementTypeOther[@name=\"\"]");
    public static By objSellerNoTxtbx = By.xpath("//XCUIElementTypeOther[@name=\"Seller Mobile Number *\"]/XCUIElementTypeTextField");
    public static By objInviteSellerBtn = By.xpath("//XCUIElementTypeOther[@name=\"Invite Seller\"]");
    public static By objSuccessfInviteLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Successfully Invited\"]");
    public static By objOkayBtn = By.xpath("//XCUIElementTypeOther[@name=\"modal-confirm-button\"]");
    //-------Invites Transaction Page

    //--------Buyer Invite Seller Page
    public static By objBuyerDetailsLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Buyer Details\"]");
    public static By objBuyerNameVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Name\"])[2]");
    public static By objBuyerNoVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Mobile No.\"])[2]");
    public static By objSellerDetailsLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Seller Details\"]");
    public static By objSellerNoVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Seller Mobile Number\"])[2]");
    public static By objCancelInviteBtn = By.xpath("//XCUIElementTypeOther[@name=\"Cancel Invitation\"]");
    public static By objBackToHomesBtn = By.xpath("//XCUIElementTypeOther[@name=\"Back To Home\"]");

    //--------Seller Received Invites Page
    public static By objPicOfItemBtn = By.xpath("//XCUIElementTypeOther[@name=\"Pictures of your Item *\"]");
    public static By objItemInformation = By.xpath("//XCUIElementTypeStaticText[@name=\"Item Information\"]");
    public static By objItemNameTxtBx = By.xpath("//XCUIElementTypeOther[@name=\"Item Name *\"]/XCUIElementTypeTextField");
    public static By objItemDescriptTxtBx = By.xpath("//XCUIElementTypeOther[@name=\"Item description/condition *\"]/XCUIElementTypeTextField");
    public static By objBrandTxtBx = By.xpath("//XCUIElementTypeOther[@name=\"Brand (optional)\"]/XCUIElementTypeTextField");
    public static By objModelNoTxtbox = By.xpath("//XCUIElementTypeOther[@name=\"Model No (optional)\"]/XCUIElementTypeTextField");
    public static By objItemQuantityTxtbx = By.xpath("//XCUIElementTypeOther[@name=\"Item Quantity *\"]/XCUIElementTypeTextField");
    public static By objCategoryDropDownlist = By.xpath("(//XCUIElementTypeOther[@name=\"Category * \"])[2]");
    public static By objItemPriceTxtbx = By.xpath("//XCUIElementTypeOther[@name=\"Item Price *\"]/XCUIElementTypeTextField");
    public static By objItemDimensionLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Item Dimensions\"]");
    public static By objWeightRangeDropDownList = By.xpath("(//XCUIElementTypeOther[@name=\"Choose Weight Ranges \"])[2]");
    public static By objNearestDropOffGMap = By.xpath("(//XCUIElementTypeOther[@name=\"Please choose nearest drop off branch * \"])[2]");
    public static By objProceedsBtn = By.xpath("//XCUIElementTypeOther[@name=\"Proceed\"]");
    public static By objDeclineBtn = By.xpath("//XCUIElementTypeOther[@name=\"Decline\"]");

    //-------------Select Category List
    public static By objSelectCategoryLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Select Category\"]");
    public static By objSearchCategoryTxtbx = By.xpath("//XCUIElementTypeOther[@name=\"Search Category\"]/XCUIElementTypeTextField");
    public static By objClothesTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Clothes / Bag / Shoes\"])[2]");
    public static By objElectronicsTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Electronics / Appliance\"])[2]");
    public static By objJewelryTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Jewelry / Watches\"])[2]");
    public static By objSportGoodTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Sporting Goods\"])[2]");
    public static By objToolsTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Tools / Supplies / Paper\"])[2]");
    public static By objOthersTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Others\"])[2]");

    //-----------Select Weight Ranges List
    public static By objWeightRangeLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Weight Range\"]");
    public static By objRateLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Rate\"]");
    public static By obj0kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"0.00 kg - 3.00kg Php 195.00\"])[2]");
    public static By obj3kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"3.01 kg - 5.00kg Php 375.00\"])[2]");
    public static By obj5kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"5.01 kg - 10.00kg Php 875.00\"])[2]");
    public static By obj10kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"10.01 kg - 20.00kg Php 2,000.00\"])[2]");
    public static By obj20kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"20.01 kg - 30.00kg Php 3,000.00\"])[2]");
    public static By obj30kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"30.01 kg - 40.00kg Php 6,500.00\"])[2]");
    public static By obj40kgTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"40.01 kg - 50.00kg Php 8,000.00\"])[2]");

    //-----------Select Drop Off Branch List
    public static By objAllowWhileUsingAppBtn = By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]");

    //-----------Confirmation Page
    public static By objPicture = By.xpath("(//XCUIElementTypeOther[@name=\"Vertical scroll bar, 3 pages Horizontal scroll bar, 3 pages\"])[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    public static By objRFTN = By.xpath("(//XCUIElementTypeOther[@name])[25]");
    public static By objSellersDetailLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Seller Details\"]");
    public static By objSellersNameVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Seller Name\"])[2]");
    public static By objSellersNoVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Seller Mobile Number\"])[2]");
    public static By objBuyersDetailLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Buyer Details\"]");
    public static By objBuyersNameVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Name\"])[2]");
    public static By objBuyersNoVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Mobile Number\"])[2]");
    public static By objItemDetailsLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Item Details\"]");
    public static By objItemNameVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Item Name])[2]");
    public static By objItemDescriptVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Item description/condition\"])[2]");
    public static By objBrandVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Brand\"])[2]");
    public static By objModelNoVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Model No\"])[2]");
    public static By objCategoryVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Category\"])[2]");
    public static By objItemPriceVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Item Price\"])[2]");
    public static By objShipDetailLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Shipping Details\"]");
    public static By objOriginBranchVal = By.xpath("(//XCUIElementTypeStaticText[@name=\"Origin Branch\"])[2]");
    public static By objConfirmInvitationBtn = By.xpath("//XCUIElementTypeOther[@name=\"Confirm Invitation\"]");
    public static By objBacksBtn = By.xpath("//XCUIElementTypeOther[@name=\"Back\"]");
}
