package com.business.mlwallet;

import com.iosmlwalletpages.MLWalletHomePage;
import com.iosmlwalletpages.MLWalletShopItemsPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.business.mlwallet.MLWalletLogin.*;
import static com.google.common.primitives.Chars.contains;
import static com.utility.ExtentReporter.extentLogger;
import static com.utility.ExtentReporter.extentLoggerPass;
import static com.utility.Utilities.*;
import static org.yaml.snakeyaml.tokens.Token.ID.Value;
import static org.yaml.snakeyaml.tokens.Token.ID.values;

public class MLWalletShopItems extends BaseClass{

    public MLWalletShopItems(){
        super();
    }

    public void shopItemsNavigation() throws Exception {
        click(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        Thread.sleep(15000);
        verifyElementDisplayed(MLWalletShopItemsPage.objSuccessfullyLogin,"Successfully Login popup");
        click(MLWalletShopItemsPage.objOkayBtn,getTextVal(MLWalletShopItemsPage.objOkayBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objMLShopPage, getTextVal(MLWalletShopItemsPage.objMLShopPage,"Page"));
        Thread.sleep(10000);
    }
    public void selectItemAndAddToCart(String sItem) throws Exception {
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu(sItem), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        if(verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"))){
            click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        }
    }
    public void navigationToCart() throws Exception {
        Swipe("down", 2);
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
    }

    public void checkOutAndEditBranch(String sPaymentMethod) throws Exception {
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),"Payment method"));
    }

    public void itemConfirmationPopup() throws Exception {
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,"Popup"))){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        }
    }

    public void hamburgerMenuNavigation() throws Exception {
        Swipe("DOWN",2);
        tapUsingCoordinates(34,194);
        logger.info("Clicked on Hamburger menu");
        extentLoggerPass("","Clicked on Hamburger menu");
    }

    public void unselectAllMaterialCheckBoxes(String sItem) throws Exception {
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu(sItem), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        if(verifyElementPresent(MLWalletShopItemsPage.objMaterialHeader,getTextVal(MLWalletShopItemsPage.objMaterialHeader,"Header"))){
            for(int i=1;i<8;i++) {
                waitTime(2000);
                click(MLWalletShopItemsPage.objMaterialCheckBoxes(i), "Material check box");
            }
        }
        logger.info("Unselected all material check boxes");
        extentLogger("","Unselected all material check boxes");
    }

    public void deleteItemsInCart() throws Exception {
        if(verifyElementDisplayed(MLWalletShopItemsPage.objDeleteBtn,"Delete button")){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objDeleteButtons);
            int size = value.size();
            System.out.println("SIZE : "+size);
            for(int i=value.size()-1;i>=1;i--){
                waitTime(3000);
                click(MLWalletShopItemsPage.objDeleteButtons(i),"Delete Button");
                verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
                waitTime(5000);
                verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
            }
        }
    }


    public void unselectAllMaterialColorCheckBoxes(String sItem) throws Exception {
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu(sItem), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objMaterialColorHeader,getTextVal(MLWalletShopItemsPage.objMaterialColorHeader,"Header"))){
            for(int i=1;i<6;i++) {
                waitTime(2000);
                click(MLWalletShopItemsPage.objMaterialColorCheckBoxes(i), "Material Color check box");
            }
        }
        logger.info("Unselected all material color check boxes");
        extentLogger("","Unselected all material color check boxes");
    }

    public String getExceptedPopupMessage() throws Exception {
        List<WebElement> value = findElements(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup);
        String sPopupMessage = "";
        for(int nMessage=1;nMessage<=value.size();nMessage++){
            String sMessage = getText(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup(nMessage));
            sPopupMessage = sPopupMessage+" "+sMessage;
        }
        return sPopupMessage;
    }

    public void unselectAllGenderCheckBoxes(String sItem) throws Exception {
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu(sItem), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objGenderHeader,getTextVal(MLWalletShopItemsPage.objGenderHeader,"Header"))){
            for(int i=1;i<4;i++) {
                waitTime(2000);
                click(MLWalletShopItemsPage.objGenderCheckBoxes(i), "Gender check box");
            }
        }
        logger.info("Unselected all Gender check boxes");
        extentLogger("","Unselected all Gender check boxes");
    }

    public void paymongoNavigation(String sTier,String sPaymentMethod) throws Exception {
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(sTier);
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch(sPaymentMethod);
    }

//========================================================================================================//

    public void shopItemsHomePageNavigation_SI_TC_01() throws Exception {
        HeaderChildNode("Shop Items, Homepage navigation validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        Thread.sleep(10000);
        verifyElementDisplayed(MLWalletShopItemsPage.objSuccessfullyLogin,"Successfully login popup");
        click(MLWalletShopItemsPage.objOkayBtn,getTextVal(MLWalletShopItemsPage.objOkayBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objMLShopPage, getTextVal(MLWalletShopItemsPage.objMLShopPage,"Page"))){
            logger.info("SI_TC_01, Shop Items, Homepage navigation validated");
            extentLoggerPass("SI_TC_01", "SI_TC_01, Shop Items, Homepage navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsHamburgerMenuAboutLinkFunctionality_SI_TC_02() throws Exception {
        HeaderChildNode("Shop Items, Hamburger menu About link functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAboutLink,getTextVal(MLWalletShopItemsPage.objAboutLink,"Link"));
        if(verifyElementPresent(MLWalletShopItemsPage.objJewelryPage,getTextVal(MLWalletShopItemsPage.objJewelryPage,"Page"))){
            logger.info("SI_TC_02, Shop Items, After clicking on Hamburger menu About link, App navigates to Jewelry page post is validated");
            extentLoggerPass("SI_TC_02", "SI_TC_02, After clicking on Hamburger menu About link, App navigates to Jewelry page post is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsHamburgerMenuContactLinkFunctionality_SI_TC_03() throws Exception {
        HeaderChildNode("Shop Items, Hamburger menu Contact link functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objContact,getTextVal(MLWalletShopItemsPage.objContact,"Link"));
        if(verifyElementPresent(MLWalletShopItemsPage.objContactUs,getTextVal(MLWalletShopItemsPage.objContactUs,"Page"))){
            verifyElementPresent(MLWalletShopItemsPage.objCustomer,getTextVal(MLWalletShopItemsPage.objCustomer,"Header"));
            verifyElementPresent(MLWalletShopItemsPage.objCustomerNumber,getTextVal(MLWalletShopItemsPage.objCustomerNumber,"Customer number"));
            verifyElementPresent(MLWalletShopItemsPage.objCallViaWeb,getTextVal(MLWalletShopItemsPage.objCallViaWeb,"Header"));
            verifyElementPresent(MLWalletShopItemsPage.objCallCustomerService,getTextVal(MLWalletShopItemsPage.objCallCustomerService,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objUSA,getTextVal(MLWalletShopItemsPage.objUSA,"Header"));
            verifyElementPresent(MLWalletShopItemsPage.objUSA,getTextVal(MLWalletShopItemsPage.objUSANumber,"USA Number"));
            verifyElementPresent(MLWalletShopItemsPage.objEmailHeader,getTextVal(MLWalletShopItemsPage.objEmailHeader,"Header"));
            verifyElementPresent(MLWalletShopItemsPage.objEmail,getTextVal(MLWalletShopItemsPage.objEmail,"Email"));
            logger.info("SI_TC_03, Shop Items, After clicking on Hamburger menu Contact link, App navigates to Contact us page is validated");
            extentLoggerPass("SI_TC_03", "SI_TC_03, After clicking on Hamburger menu Contact link, App navigates to Contact us page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsHamburgerMenuCartLinkFunctionality_SI_TC_04() throws Exception {
        HeaderChildNode("Shop Items, Hamburger menu Cart link functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCartLink,getTextVal(MLWalletShopItemsPage.objCartLink,"Link"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objShoppingCart,"Shopping cart Page")){
            logger.info("SI_TC_04, Shop Items, After clicking on Hamburger menu Cart link, App navigates to Shopping cart page is validated");
            extentLoggerPass("SI_TC_04", "SI_TC_04, After clicking on Hamburger menu Cart link, App navigates to Shopping cart page is validated");
            System.out.println("-----------------------------------------------------------");
        }else if(verifyElementPresent(MLWalletShopItemsPage.objEmptyCartMsg,getTextVal(MLWalletShopItemsPage.objEmptyCartMsg,"Message"))){
            logger.info("SI_TC_04, Shop Items, After clicking on Hamburger menu Cart link, App navigates to Shopping cart page is validated");
            extentLoggerPass("SI_TC_04", "SI_TC_04, After clicking on Hamburger menu Cart link, App navigates to Shopping cart page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsHamburgerMenuProfileLinkFunctionality_SI_TC_05() throws Exception {
        HeaderChildNode("Shop Items, Hamburger menu Profile link functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfileLink, getTextVal(MLWalletShopItemsPage.objProfileLink, "Link"));
        if(verifyElementPresent(MLWalletShopItemsPage.objProfileName,getTextVal(MLWalletShopItemsPage.objProfileName,"Profile Name"))){
            verifyElementPresent(MLWalletShopItemsPage.objFullNameInProfilePage,getTextVal(MLWalletShopItemsPage.objFullNameInProfilePage,"Full name in profile page"));
            verifyElementPresent(MLWalletShopItemsPage.objEmailAddressInProfilePage,getTextVal(MLWalletShopItemsPage.objEmailAddressInProfilePage,"Email Address in profile page"));
            verifyElementPresent(MLWalletShopItemsPage.objMobileNumberInProfilePage,getTextVal(MLWalletShopItemsPage.objMobileNumberInProfilePage,"Mobile Number in profile page"));
            logger.info("SI_TC_05, Shop Items, After clicking on Hamburger menu Profile link, App navigates to Profile page post is validated");
            extentLoggerPass("SI_TC_05", "SI_TC_05, After clicking on Hamburger menu Profile link, App navigates to Profile page post is validated");
            System.out.println("-----------------------------------------------------------");

        }
    }


    public void shopItemsHamburgerMenuPurchaseHistoryLinkFunctionality_SI_TC_06() throws Exception {
        HeaderChildNode("Shop Items, Hamburger menu Purchase History link functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPurchaseHistory, getTextVal(MLWalletShopItemsPage.objPurchaseHistory, "Link"));
        if(verifyElementPresent(MLWalletShopItemsPage.objOrderDetails,getTextVal(MLWalletShopItemsPage.objOrderDetails,"Page"))){
            logger.info("SI_TC_05, Shop Items, After clicking on Hamburger menu Purchase History link, App navigates to Purchase History page is validated");
            extentLoggerPass("SI_TC_05", "SI_TC_05, After clicking on Hamburger menu Purchase History link, App navigates to Purchase History page is validated");
            System.out.println("-----------------------------------------------------------");

        }
    }
    public void shopItemsLogout_SI_TC_07() throws Exception {
        HeaderChildNode("Shop Items Logout validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLogoutBtn,getTextVal(MLWalletShopItemsPage.objLogoutBtn,"Button"));
        waitTime(8000);
        hamburgerMenuNavigation();
        if(verifyElementPresent(MLWalletShopItemsPage.objLoginBtn,getTextVal(MLWalletShopItemsPage.objLoginBtn,"Link"))) {
            logger.info("SI_TC_07, Shop Items Logout validated");
            extentLoggerPass("SI_TC_07", "SI_TC_07, Shop Items Logout validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSuccessfulLogin_SI_TC_08() throws Exception {
        HeaderChildNode("Shop Items Successful login validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        waitTime(10000);
        verifyElementPresent(MLWalletShopItemsPage.objSuccessfullyLogin,"Successfully login popup");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objOkayBtn,getTextVal(MLWalletShopItemsPage.objOkayBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objMLShopPage, getTextVal(MLWalletShopItemsPage.objMLShopPage,"Page"))){
            logger.info("SI_TC_08, Shop Items Successful login validated");
            extentLoggerPass("SI_TC_08", "SI_TC_08, Shop Items Successful login validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsLogOutAndLoginWithAnotherAccount_SI_TC_11() throws Exception {
        HeaderChildNode("Shop Items, Logout And Login with another account validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfileLink, getTextVal(MLWalletShopItemsPage.objProfileLink, "Link"));
        String sProfileName = getText(MLWalletShopItemsPage.objProfileName);
        waitTime(5000);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLogoutBtn, getTextVal(MLWalletShopItemsPage.objLogoutBtn, "Button"));
        waitTime(5000);
        hamburgerMenuNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLoginLink, getTextVal(MLWalletShopItemsPage.objLoginLink, "Link"));
        waitTime(5000);
        type(MLWalletShopItemsPage.objMobileNumberInputField, prop.getproperty("NewMLShopAccount"), "Mobile number input field");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLoginBtn, getTextVal(MLWalletShopItemsPage.objLoginBtn, "Button"));
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objSuccessfullyLogin,getTextVal(MLWalletShopItemsPage.objSuccessfullyLogin,"popup"))){
            click(MLWalletShopItemsPage.objOkayBtn,getTextVal(MLWalletShopItemsPage.objOkayBtn,"Button"));
        }
        waitTime(5000);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfileLink, getTextVal(MLWalletShopItemsPage.objProfileLink, "Link"));
        String sProfileNameNewAccount = getText(MLWalletShopItemsPage.objProfileName);
        assertNotEquals(sProfileName,sProfileNameNewAccount);
        if(!Objects.equals(sProfileNameNewAccount, sProfileName)){
            logger.info("SI_TC_11, Shop Items, Logout And Login with another account successfully validated");
            extentLoggerPass("SI_TC_11", "SI_TC_11, Shop Items, Logout And Login with another account successfully validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsHomeScreenUIValidation_SI_TC_12() throws Exception {
        HeaderChildNode("Shop Items home screen validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        if(verifyElementPresent(MLWalletShopItemsPage.objMLShopPage,getTextVal(MLWalletShopItemsPage.objMLShopPage,"Page"))){
            verifyElementPresent(MLWalletShopItemsPage.objDiscountBanner,getTextVal(MLWalletShopItemsPage.objDiscountBanner,"Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objItemsHeader,getTextVal(MLWalletShopItemsPage.objItemsHeader,"Header"));
            verifyElementPresent(MLWalletShopItemsPage.objRingItem,getTextVal(MLWalletShopItemsPage.objRingItem,"Item"));
            verifyElementPresent(MLWalletShopItemsPage.objNecklacesAndPendants,getTextVal(MLWalletShopItemsPage.objNecklacesAndPendants,"Item"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objBraceletsAndBangles,getTextVal(MLWalletShopItemsPage.objBraceletsAndBangles,"Item"));
            verifyElementPresent(MLWalletShopItemsPage.objEarrings,getTextVal(MLWalletShopItemsPage.objEarrings,"Item"));
//            verifyElementPresent(MLWalletShopItemsPage.objWatchItemsHeader,getTextVal(MLWalletShopItemsPage.objWatchItemsHeader,"Header"));
//            Swipe("UP",1);
//            verifyElementPresent(MLWalletShopItemsPage.objShopHeader,getTextVal(MLWalletShopItemsPage.objShopHeader,"options Header"));
//            verifyElementPresent(MLWalletShopItemsPage.objCustomerCareHeader,getTextVal(MLWalletShopItemsPage.objCustomerCareHeader,"options Header"));
//            verifyElementPresent(MLWalletShopItemsPage.objContactUs,getTextVal(MLWalletShopItemsPage.objContactUs,"options Header"));
            logger.info("SI_TC_12, Shop Items home screen validated");
            extentLoggerPass("SI_TC_12", "SI_TC_12, Shop Items home screen validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsRingItemPageNavigation_SI_TC_14() throws Exception {
        HeaderChildNode("Shop Items, Ring item page validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRingItem,getTextVal(MLWalletShopItemsPage.objRingItem,"Item"));
        waitTime(10000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objRingItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objRingItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_14, Shop Items Ring item page validated");
            extentLoggerPass("SI_TC_14", "SI_TC_14, Shop Items Ring item page validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_14, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_14", "SI_TC_14, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsNecklacesAndPendantsItemPageNavigation_SI_TC_15() throws Exception {
        HeaderChildNode("Shop Items, Necklaces & Pendants item page validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objNecklacesAndPendants,getTextVal(MLWalletShopItemsPage.objNecklacesAndPendants,"Item"));
        waitTime(10000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objNecklacesAndPendantsItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objNecklacesAndPendantsItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_15, Shop Items Necklaces & Pendants item page validated");
            extentLoggerPass("SI_TC_15", "SI_TC_15, Shop Items Necklaces & Pendants item page validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_15, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_15", "SI_TC_15, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsBraceletAndBangleItemPageNavigation_SI_TC_16() throws Exception {
        HeaderChildNode("Shop Items, Bracelet & Bangle item page validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBraceletsAndBangles,getTextVal(MLWalletShopItemsPage.objBraceletsAndBangles,"Item"));
        waitTime(10000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objBraceletAndBangleItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objBraceletAndBangleItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_16, Shop Items Bracelet & Bangle item page validated");
            extentLoggerPass("SI_TC_16", "SI_TC_16, Shop Items Bracelet & Bangle item page validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_16, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_16", "SI_TC_16, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsEarringsItemPageNavigation_SI_TC_17() throws Exception {
        HeaderChildNode("Shop Items, Earrings item page validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEarrings,getTextVal(MLWalletShopItemsPage.objEarrings,"Item"));
        waitTime(10000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objEarringsItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objEarringsItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_17, Shop Items Earrings item page validated");
            extentLoggerPass("SI_TC_17", "SI_TC_17, Shop Items Earrings item page validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_17, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_17", "SI_TC_17, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsWatchItemPageNavigation_SI_TC_18() throws Exception {
        HeaderChildNode("Shop Items, Watch item page validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP",2);
        verifyElementPresent(MLWalletShopItemsPage.objWatchItemsHeader,getTextVal(MLWalletShopItemsPage.objWatchItemsHeader,"Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objWatchItem, "First watch Image");
        waitTime(5000);
        if(verifyElementDisplayed(MLWalletShopItemsPage.objWatchItemsDisplayed,"Watch Item displayed")){
            List<WebElement> values = findElements(MLWalletShopItemsPage.objWatchItemsDisplayed);
            int nWatchItemsDisplayed = values.size();
            logger.info("Watch items displayed = " +nWatchItemsDisplayed);
            extentLoggerPass("", "Watch items displayed = " +nWatchItemsDisplayed);
            logger.info("SI_TC_18, Shop Items Watch item page validated");
            extentLoggerPass("SI_TC_18", "SI_TC_18, Shop Items Watch item page validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_18, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_18", "SI_TC_18, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAutoCheckedProductTypeAfterSelectingProductTpe_SI_TC_19() throws Exception {
        HeaderChildNode("Shop Items, Auto checked product type after selecting product type");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"))){
            verifyElementPresent(MLWalletShopItemsPage.objProductTypeSelectedCheckBox,getTextVal(MLWalletShopItemsPage.objProductTypeSelectedCheckBox,"Selected product type"));
            logger.info("SI_TC_19, Shop Items Watch item page validated");
            extentLoggerPass("SI_TC_19", "SI_TC_19, Shop Items Watch item page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectRingProductTypeAndProductsValidation_SI_TC_21() throws Exception {
        HeaderChildNode("Shop items, Select Ring product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRingsCheckBox,"Rings check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objRingItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objRingItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_21, Shop items, Selected Ring product type and displayed products validated");
            extentLoggerPass("SI_TC_21", "SI_TC_21, Shop items, Selected Ring product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_21, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_21", "SI_TC_21, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void shopItemsSelectNecklaceProductTypeAndProductsValidation_SI_TC_22() throws Exception {
        HeaderChildNode("Shop items, Select Necklace product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objNecklaceCheckBox,"Necklace check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objNecklacesAndPendantsItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objNecklacesAndPendantsItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_22, Shop items, Selected Necklace product type and displayed products validated");
            extentLoggerPass("SI_TC_22", "SI_TC_22, Shop items, Selected Necklace product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }
        else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_22, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_22", "SI_TC_22, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectBraceletAndBangleProductTypeAndProductsValidation_SI_TC_23() throws Exception {
        HeaderChildNode("Shop items, Select Bracelet & Bangle product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.ObjBraceletsAndBanglesCheckBox,"Bracelet & Bangles check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objBraceletAndBangleItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objBraceletAndBangleItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_23, Shop items, Selected Bracelet & Bangle product type and displayed products validated");
            extentLoggerPass("SI_TC_23", "SI_TC_23, Shop items, Selected Bracelet & Bangle product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_23, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_23", "SI_TC_23, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectEarringsProductTypeAndProductsValidation_SI_TC_24() throws Exception {
        HeaderChildNode("Shop items, Select Earrings product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.ObjEarringsCheckBox,"Earrings check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objEarringsItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objEarringsItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_24, Shop items, Selected Earrings type and displayed products validated");
            extentLoggerPass("SI_TC_24", "SI_TC_24, Shop items, Selected Earrings product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_24, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_24", "SI_TC_24, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectPendantProductTypeAndProductsValidation_SI_TC_25() throws Exception {
        HeaderChildNode("Shop items, Select Pendant product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.ObjPendantCheckBox,"Pendant check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objPendantItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objPendantItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_25, Shop items, Selected Pendant type and displayed products validated");
            extentLoggerPass("SI_TC_25", "SI_TC_25, Shop items, Selected Pendant product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_25, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_25", "SI_TC_25, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectTernoAndSetProductTypeAndProductsValidation_SI_TC_26() throws Exception {
        HeaderChildNode("Shop items, Select Terno & Set product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objTernoAndSetCheckBox,"Terno & Set CheckBox check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objTernoAndSetItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objTernoAndSetItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_26, Shop items, Selected Terno & Set type and displayed products validated");
            extentLoggerPass("SI_TC_26", "SI_TC_26, Shop items, Selected Terno & Set product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_26, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_26", "SI_TC_26, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectBroochProductTypeAndProductsValidation_SI_TC_27() throws Exception {
        HeaderChildNode("Shop items, Select Brooch product type and displayed products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBroochCheckBox,"Brooch CheckBox check box");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objBroochItemsDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objBroochItemsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_27, Shop items, Selected Brooch type and displayed products validated");
            extentLoggerPass("SI_TC_27", "SI_TC_27, Shop items, Selected Brooch product type and displayed products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_27, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_27", "SI_TC_27, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void shopItemsSelect10KMaterialAndProductsValidation_SI_TC_28() throws Exception {
        HeaderChildNode("Shop items, Select 10K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj10KCheckBox,"10K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj10KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj10KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj10KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 10K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 10K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("","Product with 10K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_28, Shop items, Select 10K Material and products validated");
            extentLoggerPass("SI_TC_28", "SI_TC_28, Shop items, Select 10K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_28, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_28", "SI_TC_28, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelect14KMaterialAndProductsValidation_SI_TC_29() throws Exception {
        HeaderChildNode("Shop items, Select 14K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj14KCheckBox,"14K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj14KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj14KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj14KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 14K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 14K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("","Product with 14K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_29, Shop items, Select 14K Material and products validated");
            extentLoggerPass("SI_TC_29", "SI_TC_29, Shop items, Select 14K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_29, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_29", "SI_TC_29, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelect18KMaterialAndProductsValidation_SI_TC_30() throws Exception {
        HeaderChildNode("Shop items, Select 18K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj18KCheckBox,"18K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj18KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj18KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj18KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 18K Products = " + sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 18K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("", "Product with 18K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_30, Shop items, Select 18K Material and products validated");
            extentLoggerPass("SI_TC_30", "SI_TC_30, Shop items, Select 18K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            waitTime(5000);
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_30, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_30", "SI_TC_30, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelect20KMaterialAndProductsValidation_SI_TC_31() throws Exception {
        HeaderChildNode("Shop items, Select 20K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj20KCheckBox,"20K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj20KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj20KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj20KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 20K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 20K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("","Product with 20K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_31, Shop items, Select 20K Material and products validated");
            extentLoggerPass("SI_TC_31", "SI_TC_31, Shop items, Select 20K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_31, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_31", "SI_TC_31, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsSelect21KMaterialAndProductsValidation_SI_TC_32() throws Exception {
        HeaderChildNode("Shop items, Select 21K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj21KCheckBox,"21K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj21KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj21KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj21KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 21K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 21K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("","Product with 21K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_32, Shop items, Select 21K Material and products validated");
            extentLoggerPass("SI_TC_32", "SI_TC_32, Shop items, Select 21K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_32, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_32", "SI_TC_32, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsSelect22KMaterialAndProductsValidation_SI_TC_33() throws Exception {
        HeaderChildNode("Shop items, Select 22K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj22KCheckBox,"22K CheckBox");
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj22KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj22KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj22KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 22K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material: " + displayedItem + " is displayed");
                logger.info("Product with 22K : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material: " + displayedItem + " is displayed");
                extentLogger("","Product with 22K : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_33, Shop items, Select 22K Material and products validated");
            extentLoggerPass("SI_TC_33", "SI_TC_33, Shop items, Select 22K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_33, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_33", "SI_TC_33, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelect12KMaterialAndProductsValidation_SI_TC_34() throws Exception {
        HeaderChildNode("Shop items, Select 12K Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj12KCheckBox,"12K CheckBox");
        tapUsingCoordinates(207,127);
        waitTime(5000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.obj12KMaterialDisplayed,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.obj12KMaterialDisplayed);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.obj12KProductsDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed 12K Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                for(int j =0; j<values1.size();j++){
                    String displayedItem = values.get(i).getText();
                    String displayedProduct = values1.get(j).getText();
                    logger.info("Material: " + displayedItem + " is displayed");
                    logger.info("Product with 12K : " + displayedProduct + " is displayed");
                    extentLogger(" ", "Item Material: " + displayedItem + " is displayed");
                    extentLogger("","12K Material Product : " + displayedProduct + " is displayed");
                }

            }
            logger.info("SI_TC_34, Shop items, Select 12K Material and products validated");
            extentLoggerPass("SI_TC_34", "SI_TC_34, Shop items, Select 12K Material and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_34, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_34", "SI_TC_34, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectYellowGoldMaterialColorAndProductsValidation_SI_TC_35() throws Exception {
        HeaderChildNode("Shop items, Select Yellow Gold Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialColorCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objYellowGoldCheckBox,"Yellow Gold CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objYellowGoldMaterialColor,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objYellowGoldMaterialColor);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objYellowProductDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Yellow Gold Color Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material color : " + displayedItem + " is displayed");
                logger.info("Product with Yellow Gold color : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material color : " + displayedItem + " is displayed");
                extentLogger("","Product with Yellow Gold color : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_35, Shop items, Select Yellow Gold Material color and products validated");
            extentLoggerPass("SI_TC_35", "SI_TC_35, Select Yellow Gold Material color and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_35, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_35", "SI_TC_35, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectWhiteGoldMaterialColorAndProductsValidation_SI_TC_36() throws Exception {
        HeaderChildNode("Shop items, Select White Gold Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialColorCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objWhiteGoldCheckBox, "White Gold CheckBox");
        Swipe("DOWN", 2);
        tapUsingCoordinates(207, 127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objWhiteGoldMaterialColor, "Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objWhiteGoldMaterialColor);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objWhiteProductDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed White Gold Color Products = " + sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material color : " + displayedItem + " is displayed");
                logger.info("Product with White Gold color : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material color : " + displayedItem + " is displayed");
                extentLogger("", "Product with White Gold color : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_36, Shop items, Select White Gold Material color and products validated");
            extentLoggerPass("SI_TC_36", "SI_TC_36, Select White Gold Material color and products validated");
            System.out.println("-----------------------------------------------------------");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg, getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg, "Message"));
            logger.info("SI_TC_36, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_36", "SI_TC_36, Shop items, No matching products message displayed and validated");
        }
    }

    public void shopItemsSelectRoseGoldMaterialColorAndProductsValidation_SI_TC_37() throws Exception {
        HeaderChildNode("Shop items, Select Rose Gold Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialColorCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRoseGoldCheckBox,"Rose Gold CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objRoseGoldMaterialColor,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objRoseGoldMaterialColor);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objRoseProductDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed White Rose Color Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material color : " + displayedItem + " is displayed");
                logger.info("Product with Rose Gold color : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material color : " + displayedItem + " is displayed");
                extentLogger("","Product with Rose Gold color : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_37, Shop items, Select Rose Gold Material color and products validated");
            extentLoggerPass("SI_TC_37", "SI_TC_37, Select Rose Gold Material color and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_37, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_37", "SI_TC_37, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void shopItemsSelectTwoToneMaterialColorAndProductsValidation_SI_TC_38() throws Exception {
        HeaderChildNode("Shop items, Select Two - Tone Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialColorCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objTwoToneCheckBox,"Two-Tone CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objTwoToneMaterialColor,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objTwoToneMaterialColor);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objTwoToneProductDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Two-Tone Color Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material color : " + displayedItem + " is displayed");
                logger.info("Product with Two-Tone color : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material color : " + displayedItem + " is displayed");
                extentLogger("","Product with Two-Tone color : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_38, Shop items, Select Two-Tone Material color and products validated");
            extentLoggerPass("SI_TC_38", "SI_TC_38, Select Two-Tone Material color and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_38, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_38", "SI_TC_38, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectTriToneMaterialColorAndProductsValidation_SI_TC_39() throws Exception {
        HeaderChildNode("Shop items, Select Tri Tone Material and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllMaterialColorCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objTriToneCheckBox,"Tri-Tone CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objTriToneMaterialColor,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objTriToneMaterialColor);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objTriToneProductDisplayed);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Tri-Tone Color Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                String displayedProduct = values1.get(i).getText();
                logger.info("Material color : " + displayedItem + " is displayed");
                logger.info("Product with Tri-Tone color : " + displayedProduct + " is displayed");
                extentLogger(" ", "Material color : " + displayedItem + " is displayed");
                extentLogger("","Product with Tri-Tone color : " + displayedProduct + " is displayed");
            }
            logger.info("SI_TC_39, Shop items, Select Tri-Tone Material color and products validated");
            extentLoggerPass("SI_TC_39", "SI_TC_39, Select Tri-Tone Material color and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_39, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_39", "SI_TC_39, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectLadiesGenderAndProductsValidation_SI_TC_40() throws Exception {
        HeaderChildNode("Shop items, Select Ladies Gender and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllGenderCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLadiesCheckBox,"Ladies CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objLadiesGender,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objLadiesGender);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Ladies Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Ladies product : " + displayedItem + " is displayed");
                extentLogger(" ", "Ladies product : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_40, Shop items, Select Ladies Gender and products validated");
            extentLoggerPass("SI_TC_40", "SI_TC_40, Shop items, Select Ladies Gender and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_40, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_40", "SI_TC_40, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectMensGenderAndProductsValidation_SI_TC_41() throws Exception {
        HeaderChildNode("Shop items, Select Mens Gender and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllGenderCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMensCheckBox,"Mens CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objMensGender,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objMensGender);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Mens Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Mens product : " + displayedItem + " is displayed");
                extentLogger(" ", "Mens product : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_41, Shop items, Shop items, Select Mens Gender and products validated");
            extentLoggerPass("SI_TC_41", "SI_TC_41, Shop items, Shop items, Select Mens Gender and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_41, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_41", "SI_TC_41, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectUnisexAndProductsValidation_SI_TC_42() throws Exception {
        HeaderChildNode("Shop items, Select Unisex and products validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        unselectAllGenderCheckBoxes("Rings");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objUniSexCheckBox,"Unisex CheckBox");
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objUnisex,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objUnisex);
            int sDisplayedProducts = values.size();
            logger.info("Displayed Unisex Products = "+sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Unisex product : " + displayedItem + " is displayed");
                extentLogger(" ", "Unisex product : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_42, Shop items, Select Unisex and products validated");
            extentLoggerPass("SI_TC_42", "SI_TC_42, Shop items, Shop items, Select Unisex and products validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_42, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_42", "SI_TC_42, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPriceRangeFilterValidation_SI_TC_43() throws Exception {
        HeaderChildNode("Shop items, Price range filter validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        Swipe("UP",2);
        verifyElementPresent(MLWalletShopItemsPage.objPriceRangeHeader,getTextVal(MLWalletShopItemsPage.objPriceRangeHeader,"Header"));
        clearTextField(MLWalletShopItemsPage.objMinInputField,"Minimum input field");
        type(MLWalletShopItemsPage.objMinInputField,"500","Filter minimum input field");
        clearTextField(MLWalletShopItemsPage.objMaxInputField,"Maximum input field");
        type(MLWalletShopItemsPage.objMaxInputField,"2000","Filter maximum input field");
        click(MLWalletShopItemsPage.objPopupFilterBtn,getTextVal(MLWalletShopItemsPage.objPopupFilterBtn,"Button"));
        Swipe("DOWN",2);
        tapUsingCoordinates(207,127);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objProductDisplayedAfterFilter,"Product displayed after filter")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductDisplayedAfterFilter);
            List<WebElement> values1 = findElements(MLWalletShopItemsPage.objAmountDisplayed);
            int sDisplayedProducts = (values.size()/2);
            logger.info("Displayed Products = " + sDisplayedProducts);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemAmount = values1.get(i).getText();
                String displayedItem = values.get(i).getText();
                if(i%2==0) {
                    logger.info("Item : " + displayedItem + " is displayed");
                    logger.info("Item Amount : " + displayedItemAmount + " is displayed");
                    extentLogger(" ", "Item : " + displayedItem + " is displayed");
                    extentLogger("", "Item Amount : " + displayedItemAmount + " is displayed");
                }
            }
            logger.info("SI_TC_43, Shop items, Price range filter validated");
            extentLoggerPass("SI_TC_43", "SI_TC_43, Shop items, Price range filter validated");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_43, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_43", "SI_TC_43, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }


        logger.info("SI_TC_43, Shop items, Price range filter validated");
        extentLoggerPass("SI_TC_43", "SI_TC_43, Shop items, Shop items, Price range filter validated");
        System.out.println("-----------------------------------------------------------");

    }

    public void shopItemsSortItemsByPriceOptionsValidation_SI_TC_44() throws Exception {
        HeaderChildNode("Shop Items, Sort Items By price options validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        if(verifyElementPresent(MLWalletShopItemsPage.objSortByPriceHeader,getTextVal(MLWalletShopItemsPage.objSortByPriceHeader,"Header"))){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objSortByPriceDropdown,"Sort By Price Dropdown");
            waitTime(5000);
            if (verifyElementDisplayed(MLWalletShopItemsPage.objSortByPriceTypes,"Sort By Price types")) {
                List<WebElement> values = findElements(MLWalletShopItemsPage.objSortByPriceTypes);
                for (int i = 0; i < values.size(); i++) {
                    String displayedTypes = values.get(i).getText();
                    logger.info("Dropdown : " + displayedTypes + " is displayed");
                    extentLogger(" ", "Dropdown : " + displayedTypes + " is displayed");
                }
            }
            logger.info("SI_TC_44, Shop Items, Sort Items By price options validated");
            extentLoggerPass("SI_TC_44", "SI_TC_44, Shop Items, Sort Items By price options validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsItemsSelectionScreenProductDetailsValidation_SI_TC_45() throws Exception {
        HeaderChildNode("Shop Items, Item selection screen product details validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectItemPageProductName,getTextVal(MLWalletShopItemsPage.objSelectItemPageProductName,"Gender,Style Name and Type"))){
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemProductDescription,getTextVal(MLWalletShopItemsPage.objSelectItemProductDescription,"Stone, Material and Material Color"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemProductDiscount,getTextVal(MLWalletShopItemsPage.objSelectItemProductDiscount,"Discount Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemDiscountProductPrice,getTextVal(MLWalletShopItemsPage.objSelectItemDiscountProductPrice,"Discount product price"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemActualProductPrice,getTextVal(MLWalletShopItemsPage.objSelectItemActualProductPrice,"Actual product price"));
            logger.info("SI_TC_45, Shop Items, Item selection screen product details validated");
            extentLoggerPass("SI_TC_45", "SI_TC_45, Shop Items, Item selection screen product details validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedWatchItemScreenUIValidation_SI_TC_49() throws Exception {
        HeaderChildNode("Shop Items, Selected Watch item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objWatchItem, "Watch Item");
        click(MLWalletShopItemsPage.objFirstWatchItem, getTextVal(MLWalletShopItemsPage.objFirstWatchItem, "Item"));
        Swipe("up", 1);
        if(verifyElementPresent(MLWalletShopItemsPage.objProductNameInSelectedPage,getTextVal(MLWalletShopItemsPage.objWatchProductAfterSelection,"Watch Name"))) {
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Model Name"), getTextVal(MLWalletShopItemsPage.objProductInfo("Model Name"), "Model Name"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"), getTextVal(MLWalletShopItemsPage.objProductInfo("Material"), "Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Color"), getTextVal(MLWalletShopItemsPage.objProductInfo("Color"), "Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"), getTextVal(MLWalletShopItemsPage.objProductInfo("Size"), "Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Brand"), getTextVal(MLWalletShopItemsPage.objProductInfo("Brand"), "Brand"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Movement"), getTextVal(MLWalletShopItemsPage.objProductInfo("Movement"), "Movement Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"), getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"), "Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock no."), getTextVal(MLWalletShopItemsPage.objProductInfo("Stock no."), "Stock No. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"), getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"), "Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            logger.info("SI_TC_49, Shop Items, Selected Watch item screen UI validated");
            extentLoggerPass("SI_TC_49", "SI_TC_49, Shop Items, Selected Watch item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedRingItemScreenUIValidation_SI_TC_50() throws Exception {
        HeaderChildNode("Shop Items, Selected Ring item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objNecklace, "Necklace Item");
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        if (verifyElementPresent(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material Color"),"Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"),getTextVal(MLWalletShopItemsPage.objProductInfo("Size"),"Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Item Weight"),getTextVal(MLWalletShopItemsPage.objProductInfo("Item Weight"),"Item Weight Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock No."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock No."),"Stock No. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"),getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"),"Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_50, Shop Items, Selected Ring item screen UI validated");
            extentLoggerPass("SI_TC_50", "SI_TC_50, Shop Items, Selected Ring item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedNecklaceAndPendantsItemScreenUIValidation_SI_TC_51() throws Exception {
        HeaderChildNode("Shop Items, Selected Necklace & Pendants item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objNecklacesAndPendants,getTextVal(MLWalletShopItemsPage.objNecklacesAndPendants,"Icon"));
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material Color"),"Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"),getTextVal(MLWalletShopItemsPage.objProductInfo("Size"),"Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Item Weight"),getTextVal(MLWalletShopItemsPage.objProductInfo("Item Weight"),"Item Weight Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock No."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock No."),"Stock No. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"),getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"),"Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objActualAmount,getTextVal(MLWalletShopItemsPage.objActualAmount,"Actual Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_51, Shop Items, Selected Necklace & Pendants item screen UI validated");
            extentLoggerPass("SI_TC_51", "SI_TC_51, Shop Items, Selected Necklace & Pendants item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedBraceletsAndBanglesItemScreenUIValidation_SI_TC_52() throws Exception {
        HeaderChildNode("Shop Items, Selected Bracelets & Bangles item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objBraceletsAndBangles,getTextVal(MLWalletShopItemsPage.objBraceletsAndBangles,"Icon"));
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        waitTime(5000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material Color"),"Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"),getTextVal(MLWalletShopItemsPage.objProductInfo("Size"),"Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Item Weight"),getTextVal(MLWalletShopItemsPage.objProductInfo("Item Weight"),"Item Weight Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock No."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock No."),"Stock No. Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objActualAmount,getTextVal(MLWalletShopItemsPage.objActualAmount,"Actual Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_52, Shop Items, Selected Bracelets & Bangles item screen UI validated");
            extentLoggerPass("SI_TC_52", "SI_TC_52, Shop Items, Selected Bracelets & Bangles item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedEarringsItemScreenUIValidation_SI_TC_53() throws Exception {
        HeaderChildNode("Shop Items, Selected Earrings item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objEarrings,getTextVal(MLWalletShopItemsPage.objEarrings,"Icon"));
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        waitTime(5000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material Color"),"Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stone"),getTextVal(MLWalletShopItemsPage.objProductInfo("Stone"),"Stone Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Item Weight"),getTextVal(MLWalletShopItemsPage.objProductInfo("Item Weight"),"Item Weight Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock No."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock No."),"Stock No. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"),getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"),"Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objActualAmount,getTextVal(MLWalletShopItemsPage.objActualAmount,"Actual Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_53, Shop Items, Selected Earrings item screen UI validated");
            extentLoggerPass("SI_TC_53", "SI_TC_53, Shop Items, Selected Earrings item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsItemAddedToCartConfirmationValidation_SI_TC_54() throws Exception {
        HeaderChildNode("Shop items, Item added to cart confirmation validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"))){
            verifyElementPresent(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
            String sActualConfirmationPopup = getText(MLWalletShopItemsPage.objItemConfirmationPopup);
            String sExceptedConfirmationPopup = "Item has been successfully added to your cart.";
            assertionValidation(sActualConfirmationPopup,sExceptedConfirmationPopup);
            logger.info("SI_TC_54, Shop Items, Item added to cart confirmation validated");
            extentLoggerPass("SI_TC_54", "SI_TC_54, Shop Items, Item added to cart confirmation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsItemAlreadyAddedToCartConfirmationValidation_SI_TC_55() throws Exception {
        HeaderChildNode("Shop items, Item already added to cart confirmation validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"))){
            verifyElementPresent(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
            String sActualConfirmationPopup = getText(MLWalletShopItemsPage.objItemConfirmationPopup);
            String sExceptedConfirmationPopup = "This item is already in your cart.";
            assertionValidation(sActualConfirmationPopup,sExceptedConfirmationPopup);
            logger.info("SI_TC_55, Shop Items, Item already added to cart confirmation validated");
            extentLoggerPass("SI_TC_55", "SI_TC_55, Shop Items, Item already added to cart confirmation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCartIconValidationAfterAddingNewItem_SI_TC_56() throws Exception {
        HeaderChildNode("Shop Items, Cart icon validation after adding new item");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        String sCartItems = getText(MLWalletShopItemsPage.objCartItems);
        logger.info("Items in cart : " +sCartItems);
        extentLogger("","Items in cart : " +sCartItems);
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objBraceletsAndBangles, "Bracelets and Bangles Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        if(verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"))){
            click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        }
        Swipe("DOWN",2);
        String sCartItemsAfterAddingNewItem = getText(MLWalletShopItemsPage.objCartItems);
        logger.info("Items in cart after adding new item : " +sCartItemsAfterAddingNewItem);
        extentLogger("","IItems in cart after adding new item : " +sCartItemsAfterAddingNewItem);
        if(!Objects.equals(sCartItemsAfterAddingNewItem, sCartItems)){
            logger.info("SI_TC_56, Shop Items, Cart icon validated after adding new item");
            extentLoggerPass("SI_TC_56", "SI_TC_56, Shop Items, Cart icon validated after adding new item");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAddedItemValidationInCartScreen_SI_TC_58() throws Exception {
        HeaderChildNode("Shop items, Added item validation in cart screen");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        String sProductName = getText(MLWalletShopItemsPage.objSelectItemPageProductName);
        logger.info("Product name displayed : "+sProductName);
        extentLogger("","Product name displayed : "+sProductName);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameDisplayedInCart = getText(MLWalletShopItemsPage.objMatchingItem(sProductName));
        logger.info("Product name displayed in cart screen: "+sProductNameDisplayedInCart);
        extentLogger("","Product name displayed in cart screen : "+sProductNameDisplayedInCart);
        if(sProductNameDisplayedInCart.contains(sProductName)){
            logger.info("SI_TC_58, Shop Items, Added item validated in cart screen");
            extentLoggerPass("SI_TC_58", "SI_TC_58, Shop Items, Added item validated in cart screen");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAddItemToCartAndDeleteItemFromCartValidation_SI_TC_59() throws Exception {
        HeaderChildNode("Shop Items, Add item to cart and Delete item from cart validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        String sProductName = getText(MLWalletShopItemsPage.objSelectItemPageProductName);
        logger.info("Product name displayed : "+sProductName);
        extentLogger("","Product name displayed : "+sProductName);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameDisplayedInCart = getText(MLWalletShopItemsPage.objMatchingItem(sProductName));
        logger.info("Product name displayed in cart screen: "+sProductNameDisplayedInCart);
        extentLogger("","Product name displayed in cart screen : "+sProductNameDisplayedInCart);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteItemAdded(sProductNameDisplayedInCart),"Delete Button");
        verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
        verifyElementNotPresent(MLWalletShopItemsPage.objMatchingItem(sProductName),"Matching items",5);
        logger.info("Previously added item is deleted");
        extentLogger("","Previously added item is deleted");
        logger.info("SI_TC_59, Shop Items, Add item to cart and Delete item from cart validated");
        extentLoggerPass("SI_TC_59", "SI_TC_59, Shop Items, Add item to cart and Delete item from cart validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsCheckOutButtonValidation_SI_TC_60() throws Exception {
        HeaderChildNode("Shop Items, Check out button validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objAccountInformation,getTextVal(MLWalletShopItemsPage.objAccountInformation,"Page"))){
            logger.info("SI_TC_60, Shop Items, Check out button clicked and navigated to Account information validated");
            extentLoggerPass("SI_TC_60", "SI_TC_60, Shop Items, Check out button clicked and navigated to Account information validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsUnselectCheckBoxAndCheckOutValidation_SI_TC_61() throws Exception {
        HeaderChildNode("Shop items, Unselect CheckBox and CheckOut validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin("9999999997");
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objDeleteBtn,"Delete button")){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objDeleteButtons);
            int size = value.size();
            System.out.println("SIZE : "+size);
            for(int i=value.size()-1;i>=1;i--){
                waitTime(3000);
                click(MLWalletShopItemsPage.objDeleteButtons(i),"Delete Button");
                verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
                waitTime(3000);
                verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
            }
        }
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        String sProductName = getText(MLWalletShopItemsPage.objSelectItemPageProductName);
        logger.info("Product name displayed : "+sProductName);
        extentLogger("","Product name displayed : "+sProductName);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameDisplayedInCart = getText(MLWalletShopItemsPage.objMatchingItem(sProductName));
        logger.info("Product name displayed in cart screen: "+sProductNameDisplayedInCart);
        extentLogger("","Product name displayed in cart screen : "+sProductNameDisplayedInCart);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedItemCheckBox(sProductNameDisplayedInCart),"Check Box");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn,getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objItemNotSelectedMsg,getTextVal(MLWalletShopItemsPage.objItemNotSelectedMsg,"error message"))){
            String sActualMsg = getText(MLWalletShopItemsPage.objItemNotSelectedMsg);
            String sExceptedMsg = "You have not selected any items for checkout.";
            assertionValidation(sActualMsg,sExceptedMsg);
            logger.info("SI_TC_61, Shop Items, You have not selected any items for checkout - error msg validated");
            extentLoggerPass("SI_TC_61", "SI_TC_61, Shop Items, You have not selected any items for checkout - error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCheckOutButtonValidationAsGuestUser_SI_TC_62() throws Exception {
        HeaderChildNode("Shop Items, Check out button validation as Guest user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLogoutBtn,getTextVal(MLWalletShopItemsPage.objLogoutBtn,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objAccountInformation,getTextVal(MLWalletShopItemsPage.objAccountInformation,"Page"))){
            logger.info("SI_TC_62, Shop Items, Check out button clicked and navigated to Account information validated as Guest user");
            extentLoggerPass("SI_TC_62", "SI_TC_62, Shop Items, Check out button clicked and navigated to Account information validated as Guest user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAutoCheckedItemCheckBoxValidation_SI_TC_63() throws Exception {
        HeaderChildNode("Shop items, Auto checked item check box validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        List<WebElement> values = findElements(MLWalletShopItemsPage.objCheckBox);
        int nCheckBoxDisplayed = values.size();
        List<WebElement> values1 = findElements(MLWalletShopItemsPage.objAutoCheckedCheckBoxes);
        int nAutoCheckedCheckBox = values1.size();
        logger.info("Check boxes displayed : "+nCheckBoxDisplayed);
        extentLogger("","Check boxes displayed : "+nCheckBoxDisplayed);
        logger.info("AutoChecked check boxes displayed : "+nAutoCheckedCheckBox);
        extentLogger("","AutoChecked Check boxes displayed : "+nAutoCheckedCheckBox);
        if(nAutoCheckedCheckBox==nCheckBoxDisplayed){
            logger.info("SI_TC_63, Shop Items, All check boxes are auto checked validated");
            extentLoggerPass("SI_TC_63", "SI_TC_63, Shop Items, All check boxes are auto checked validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCartPageUIValidation_SI_TC_64() throws Exception {
        HeaderChildNode("Shop Items, Cart page UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        if(verifyElementPresent(MLWalletShopItemsPage.objShoppingCart,getTextVal(MLWalletShopItemsPage.objShoppingCart,"page"))){
            verifyElementPresent(MLWalletShopItemsPage.objProductCheckBox,"Product Check box");
            verifyElementPresent(MLWalletShopItemsPage.objShoppingTypeHeader,getTextVal(MLWalletShopItemsPage.objShoppingTypeHeader,"Shopping type Header"));
            verifyElementPresent(MLWalletShopItemsPage.objCartProductName,getTextVal(MLWalletShopItemsPage.objCartProductName,"Product Name"));
            verifyElementPresent(MLWalletShopItemsPage.objProductNumber,getTextVal(MLWalletShopItemsPage.objProductNumber,"Product Number"));
            verifyElementPresent(MLWalletShopItemsPage.objCartProductDescription,getTextVal(MLWalletShopItemsPage.objCartProductDescription,"Product Description"));
            verifyElementPresent(MLWalletShopItemsPage.objCartProductPrice,getTextVal(MLWalletShopItemsPage.objCartProductPrice,"Product Name"));
            verifyElementPresent(MLWalletShopItemsPage.objCheckOutBtn,getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
            logger.info("SI_TC_64, Shop Items, Cart page UI validated");
            extentLoggerPass("SI_TC_64", "SI_TC_64, Shop Items, Cart page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectSpecificProductAndCheckOutValidation_SI_TC_65() throws Exception {
        HeaderChildNode("Shop items, Select specific product and checkout validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        String sProductName = getText(MLWalletShopItemsPage.objSelectItemPageProductName);
        logger.info("Product name displayed : "+sProductName);
        extentLogger("","Product name displayed : "+sProductName);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameDisplayedInCart = getText(MLWalletShopItemsPage.objMatchingItem(sProductName));
        logger.info("Product name displayed in cart screen: "+sProductNameDisplayedInCart);
        extentLogger("","Product name displayed in cart screen : "+sProductNameDisplayedInCart);
        if(verifyElementPresent(MLWalletShopItemsPage.objCheckBox,"Check boxes")){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objCheckBox);
            for(int i=1;i<=value.size();i++){
                click(MLWalletShopItemsPage.objCheckBox(i),"Check Box");
            }
        }
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedItemCheckBox(sProductNameDisplayedInCart),"Added product check box");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn,getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objMatchingItem(sProductName),getTextVal(MLWalletShopItemsPage.objMatchingItem(sProductName),"Product name"))){
            logger.info("SI_TC_65, Select specific product and checkout validated");
            extentLoggerPass("SI_TC_65", "SI_TC_65, Shop Items, Select specific product and checkout validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlaceOrderPageNavigation_SI_TC_66() throws Exception {
        HeaderChildNode("Shop items, Place order page navigation validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",5);
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"))){
            logger.info("SI_TC_66, Shop Items, After clicking on Checkout button, App navigates to place order page is validated");
            extentLoggerPass("SI_TC_66", "SI_TC_66, Shop Items, After clicking on Checkout button, App navigates to place order page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsEmptyCartMsgValidation_SI_TC_67() throws Exception {
        HeaderChildNode("Shop items, Empty cart message validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objDeleteBtn,"Delete button")){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objDeleteButtons);
            int size = value.size();
            System.out.println("SIZE : "+size);
            for(int i=value.size()-1;i>=1;i--){
                waitTime(3000);
                click(MLWalletShopItemsPage.objDeleteButtons(i),"Delete Button");
                verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
                waitTime(3000);
                verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
            }
        }
        if(verifyElementPresent(MLWalletShopItemsPage.objEmptyCartMsg,getTextVal(MLWalletShopItemsPage.objEmptyCartMsg,"Message"))){
            logger.info("SI_TC_67, Shop Items, Your cart is empty message is validated");
            extentLoggerPass("SI_TC_67", "SI_TC_67, Shop Items, Your cart is empty message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAddToCartConfirmButtonFunctionality_SI_TC_68() throws Exception {
        HeaderChildNode("Shop items, Add to cart confirm button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        verifyElementNotPresent(MLWalletShopItemsPage.objConfirmBtn,"Confirm button",5);
        logger.info("SI_TC_68, Shop Items, After clicking on Confirm button on add to cart popup, Popup disappears validated");
        extentLoggerPass("SI_TC_68", "SI_TC_68, Shop Items, After clicking on Confirm button on add to cart popup, Popup disappears validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsServiceFeeValidationForSameOriginAndDestinationBranch_SI_TC_70(String sPaymentMethod) throws Exception {
        HeaderChildNode("Shop items, Service fee validation for same origin and destination branch");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin("9999999996");
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        Swipe("UP",9);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMLNRABranch,getTextVal(MLWalletShopItemsPage.objMLNRABranch,"Branch Name"));
        Swipe("UP",1);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),"Payment method"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objServiceTotal,getTextVal(MLWalletShopItemsPage.objServiceTotal,"Service total"))){
            String sActualServiceTotal = getText(MLWalletShopItemsPage.objServiceTotal);
            String sExceptedServiceTotal = "₱30.00";
            assertionValidation(sActualServiceTotal,sExceptedServiceTotal);
            logger.info("SI_TC_70, Shop items, Service fee validated for same origin and destination branch");
            extentLoggerPass("SI_TC_70", "SI_TC_70, Shop items, Service fee validated for same origin and destination branch");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsItemsDisplayedUnderAppropriateLabelsValidation_SI_TC_72() throws Exception {
        HeaderChildNode("Shop items, Items displayed under appropriate labels validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        Swipe("down", 2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP",3);
        click(MLWalletShopItemsPage.objWatchItem, "Watch Item");
        click(MLWalletShopItemsPage.objFirstWatchItem, getTextVal(MLWalletShopItemsPage.objFirstWatchItem, "Item"));
        Swipe("UP",3);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objMLShopJewelryStore,getTextVal(MLWalletShopItemsPage.objMLShopJewelryStore,"Label"))){
            verifyElementPresent(MLWalletShopItemsPage.objItemDisplayedUnderAppropriateLabels("ML Shop Jewelry Store"),getTextVal(MLWalletShopItemsPage.objItemDisplayedUnderAppropriateLabels("ML Shop Jewelry Store")," : Item displayed under ML Shop Jewelry Store Label"));
        }
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objMLWatches,getTextVal(MLWalletShopItemsPage.objMLWatches,"Label"))){
            verifyElementPresent(MLWalletShopItemsPage.objItemDisplayedUnderAppropriateLabels("ML Watches"),getTextVal(MLWalletShopItemsPage.objItemDisplayedUnderAppropriateLabels("ML Watches")," : Item displayed under ML Watches Label"));
        }
        logger.info("SI_TC_72, Shop items, Items displayed under appropriate labels validated");
        extentLoggerPass("SI_TC_72", "SI_TC_72, Shop items, Items displayed under appropriate labels validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsSubtotalOrderAsPerTotalItemsSelected_SI_TC_73(String sPaymentMethod) throws Exception {
        HeaderChildNode("Shop items, Subtotal order as per total items selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        Swipe("down", 2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Necklaces & Pendants");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));

        float sSubtotalAmountCalculated = 0;
        if(verifyElementDisplayed(MLWalletShopItemsPage.objProductPriceInPlaceOrder,"Product amount displayed in place order")) {
            List<WebElement> value = findElements(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
            int size = value.size();
            System.out.println(size);
            for (int i = 1; i <= value.size(); i++) {
                String sElement = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder(i));
                String sAmount = sElement.substring(1,sElement.length());
                if(sAmount.contains(",")){
                    sAmount = sAmount.replace(",","");
                }
                float nAmount = Float.parseFloat(sAmount);
                sSubtotalAmountCalculated = sSubtotalAmountCalculated+nAmount;
            }
        }
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),"Payment method"));
        Swipe("DOWN",3);
        String sSubTotalOrder = getText(MLWalletShopItemsPage.objSubTotalOrder);
        String sSubTotalOrderAmount = sSubTotalOrder.substring(1,sSubTotalOrder.length());
        if(sSubTotalOrderAmount.contains(",")){
            sSubTotalOrderAmount = sSubTotalOrderAmount.replace(",","");
        }
        float nSubTotalOrderAmountDisplayed = Float.parseFloat(sSubTotalOrderAmount);
        logger.info("Subtotal order amount displayed  : "+sSubTotalOrderAmount);
        extentLogger("","Subtotal order amount displayed  : "+sSubTotalOrderAmount);
        logger.info("Subtotal amount calculated  : "+sSubtotalAmountCalculated);
        extentLogger("","Subtotal amount calculated  : "+sSubtotalAmountCalculated);
        if(nSubTotalOrderAmountDisplayed==sSubtotalAmountCalculated){
            logger.info("SI_TC_73, Shop items, Subtotal order displayed is equals to total amount of items per seller is validated");
            extentLoggerPass("SI_TC_73", "SI_TC_73, Shop items, Subtotal order displayed is equals to total amount of items per seller is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlaceOrderBtnEnabledAfterSelectingPickUpBranchValidation_SI_TC_75() throws Exception {
        HeaderChildNode("Shop items, Place order button got enabled after selecting Pickup Branch validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",2);
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"))){
            assertionValidation(getAttributValue("enabled", MLWalletShopItemsPage.objPlaceOrderBtn), "true");
            logger.info("SI_TC_75, Shop items, Place order button got enabled after selecting Pickup Branch is validated");
            extentLoggerPass("SI_TC_75", "SI_TC_75, Shop items, Place order button got enabled after selecting Pickup Branch is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_76() throws Exception {
        HeaderChildNode("Shop items, Place order button remains disabled state if Pickup Branch is not selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",4);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"))){
            assertionValidation(getAttributValue("enabled", MLWalletShopItemsPage.objPlaceOrderBtn), "false");
            logger.info("SI_TC_76, Shop items, Place order button remains disabled state if Pickup Branch is not selected is validated");
            extentLoggerPass("SI_TC_76", "SI_TC_76, Shop items, Place order button remains disabled state if Pickup Branch is not selected is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsNoItemsSelectedPopupConfirmBtnFunctionality_SI_TC_77() throws Exception {
        HeaderChildNode("Shop items, No items selected popup confirm button functionality validated");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objDeleteBtn,"Delete button")){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objDeleteButtons);
            int size = value.size();
            System.out.println("SIZE : "+size);
            for(int i=value.size()-1;i>=1;i--){
                waitTime(3000);
                click(MLWalletShopItemsPage.objDeleteButtons(i),"Delete Button");
                verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
                waitTime(3000);
                verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
            }
        }
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        String sProductName = getText(MLWalletShopItemsPage.objSelectItemPageProductName);
        logger.info("Product name displayed : "+sProductName);
        extentLogger("","Product name displayed : "+sProductName);
        click(MLWalletShopItemsPage.objSelectItem, "first Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameDisplayedInCart = getText(MLWalletShopItemsPage.objMatchingItem(sProductName));
        logger.info("Product name displayed in cart screen: "+sProductNameDisplayedInCart);
        extentLogger("","Product name displayed in cart screen : "+sProductNameDisplayedInCart);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedItemCheckBox(sProductNameDisplayedInCart),"Check Box");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn,getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
//        verifyElementPresent(MLWalletShopItemsPage.objItemNotSelectedMsg,getTextVal(MLWalletShopItemsPage.objItemNotSelectedMsg,"error message"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        verifyElementNotPresent(MLWalletShopItemsPage.objConfirmBtn,"Confirm button",5);
        logger.info("SI_TC_77, Shop items, After clicking on confirm button on No items selected popup, popup got dismissed is validated");
        extentLoggerPass("SI_TC_77", "SI_TC_77, Shop items, After clicking on confirm button on No items selected popup, popup got dismissed is validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsPlaceOrderBtnFunctionality_SI_TC_78(String sPaymentMethod) throws Exception {
        HeaderChildNode("Shop items, Place order button functionality validated");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch(sPaymentMethod);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"));
        waitTime(5000);
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,"Popup"))){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            logger.info("SI_TC_78, Shop items, After clicking on Place order button, App displays an item confirmation popup is validated");
            extentLoggerPass("SI_TC_78", "SI_TC_78, Shop items, After clicking on Place order button, App displays an item confirmation popup is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsProvinceDisplayedToPickUpBasedOnProvinceDisplayedOnPersonalInformation_SI_TC_81() throws Exception {
        HeaderChildNode("Shop items, Province/State displayed for pick up should be base on the Province/State in the Personal Information validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",1);
        String sProvinceUnderAccountInformation = getText(MLWalletShopItemsPage.objAccInfoStateDisplayed);
        Swipe("UP",1);
        String sProvinceUnderPickupBranch = getText(MLWalletShopItemsPage.objPickupBranchState);
        assertionValidation(sProvinceUnderAccountInformation,sProvinceUnderPickupBranch);
        if(sProvinceUnderAccountInformation.equals(sProvinceUnderPickupBranch)){
            logger.info("SI_TC_81, Shop items, Province/State displayed for pick up should be based on the Province/State in the Account Information validated");
            extentLoggerPass("SI_TC_81", "SI_TC_81, Shop items, Province/State displayed for pick up should be based on the Province/State in the Account Information validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsBranchAddressDisplayedValidation_SI_TC_82() throws Exception {
        HeaderChildNode("Shop items, Branch address displayed validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupProvince,"Province DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","Cebu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProvince("Cebu"),getTextVal(MLWalletShopItemsPage.objProvince("Cebu"),"Province"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","CEBU CITY");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("CEBU CITY"),getTextVal(MLWalletShopItemsPage.objCity("CEBU CITY"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        Swipe("UP",6);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch("ML NRA"),getTextVal(MLWalletShopItemsPage.objBranch("ML NRA"),"Branch"));
        if(verifyElementPresent(MLWalletShopItemsPage.objBranchAddress,getTextVal(MLWalletShopItemsPage.objBranchAddress,"Branch address"))){
            String sBranchAddress = getAttributValue("label",MLWalletShopItemsPage.objBranchAddress);
            String sExceptedBranchAddress = "ML BLDG. BENEDICTO ST., NORTH RECLAMATION AREA CEBU";
            assertionValidation(sBranchAddress,sExceptedBranchAddress);
            logger.info("SI_TC_82, Shop items, Branch address displayed is dependent on Branch name is validated");
            extentLoggerPass("SI_TC_82", "SI_TC_82, Shop items, Branch address displayed is dependent on Branch name is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCityDisplayedToPickUpBasedOnCityDisplayedOnPersonalInformation_SI_TC_83() throws Exception {
        HeaderChildNode("Shop items, City/Town displayed for pick up should be based on the City/Town in the Personal Information validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",1);
        String sCityUnderAccountInformation = getText(MLWalletShopItemsPage.objAccInfoCityDisplayed);
        Swipe("UP",2);
        waitTime(5000);
        String sCityUnderPickupBranch = getAttributValue("value",MLWalletShopItemsPage.objSelectPickupCity);
        assertionValidation(sCityUnderAccountInformation,sCityUnderPickupBranch);
        if(sCityUnderAccountInformation.equals(sCityUnderPickupBranch)){
            logger.info("SI_TC_83, Shop items, City/Town displayed for pick up should be based on the City/Town in the Account Information validated");
            extentLoggerPass("SI_TC_83", "SI_TC_83, Shop items, City/Town displayed for pick up should be based on the City/Town in the Account Information validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsBranchNameValidationBasedOnCitySelected_SI_TC_84() throws Exception {
        HeaderChildNode("Shop items, Branch name validation based on city selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupProvince,"Province DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","Cebu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProvince("Cebu"),getTextVal(MLWalletShopItemsPage.objProvince("Cebu"),"Province"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("ARGAO"),getTextVal(MLWalletShopItemsPage.objCity("ARGAO"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        ArrayList<WebElement> value = (ArrayList<WebElement>) findElements(MLWalletShopItemsPage.objCollections);
        ArrayList<String> sBranch = null;
        for(int nBranch=2;nBranch<=value.size();nBranch++){
            sBranch = new ArrayList<>();
            sBranch.add(getText(MLWalletShopItemsPage.objCollections(nBranch)));
            logger.info("Branches displayed under ARGAO city : "+sBranch);
            extentLogger("Branches","Branches displayed under ARGAO city : "+sBranch);
        }
        click(MLWalletShopItemsPage.objBranch,"Branch");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("ALCOY"),getTextVal(MLWalletShopItemsPage.objCity("ALCOY"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        ArrayList<WebElement> value1 = (ArrayList<WebElement>) findElements(MLWalletShopItemsPage.objCollections);
        ArrayList<String> sBranch1 = null;
        for(int nBranch=2;nBranch<=value1.size();nBranch++){
            sBranch1 = new ArrayList<>();
            sBranch1.add(getText(MLWalletShopItemsPage.objCollections(nBranch)));
            logger.info("Branches displayed under ALCOY city : "+sBranch1);
            extentLogger("Branches","Branches displayed under ALCOY city : "+sBranch1);
        }

        if(!sBranch.contains(sBranch1)){
            logger.info("SI_TC_84, Shop items, Branch name displayed is based on the selected City/Town selected is validated");
            extentLoggerPass("SI_TC_84", "SI_TC_84, Shop items, Branch name displayed is based on the selected City/Town selected is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlaceOrderPageRequiredFieldsMsgValidation_SI_TC_85() throws Exception {
        HeaderChildNode("Shop items, Place order page required fields message validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLogoutBtn,getTextVal(MLWalletShopItemsPage.objLogoutBtn,"Link"));
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",7);
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"))) {
            assertionValidation(getAttributValue("enabled", MLWalletShopItemsPage.objPlaceOrderBtn), "false");
            Swipe("DOWN",5);
            if(verifyElementPresent(MLWalletShopItemsPage.objFirstNameRequiredMsg,getTextVal(MLWalletShopItemsPage.objFirstNameRequiredMsg,"error message"))){
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objFirstNameRequiredMsg);
                String sExceptedErrorMsg = "Firstname is required";
                assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            }
            if(verifyElementPresent(MLWalletShopItemsPage.objLastNameRequiredMsg,getTextVal(MLWalletShopItemsPage.objLastNameRequiredMsg,"error message"))){
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objLastNameRequiredMsg);
                String sExceptedErrorMsg = "Lastname is Required";
                assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            }
            if(verifyElementPresent(MLWalletShopItemsPage.objEmailRequiredMsg,getTextVal(MLWalletShopItemsPage.objEmailRequiredMsg,"error message"))) {
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objEmailRequiredMsg);
                String sExceptedErrorMsg = "Email is Required";
                assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            }
            if(verifyElementPresent(MLWalletShopItemsPage.objStreetRequiredMsg,getTextVal(MLWalletShopItemsPage.objStreetRequiredMsg,"error message"))) {
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objStreetRequiredMsg);
                String sExceptedErrorMsg = "Street is Required";
                assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            }
            if(verifyElementPresent(MLWalletShopItemsPage.objProvinceRequiredMsg,getTextVal(MLWalletShopItemsPage.objProvinceRequiredMsg,"error message"))) {
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objProvinceRequiredMsg);
                String sExceptedErrorMsg = "Province is Required";
                assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            }
            if(verifyElementPresent(MLWalletShopItemsPage.objCityRequiredMsg,getTextVal(MLWalletShopItemsPage.objCityRequiredMsg,"error message"))) {
                String sActualErrorMsg = getText(MLWalletShopItemsPage.objCityRequiredMsg);
                String sExceptedErrorMsg = "City is Required";
                assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            }
            logger.info("SI_TC_85, Shop items, Place order button is disabled and Mandatory fields error messages validated");
            extentLoggerPass("SI_TC_85", "SI_TC_85, Shop items, Place order button is disabled and Mandatory fields error messages validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsOrderConfirmationPopupProceedBtnFunctionality_SI_TC_87() throws Exception {
        HeaderChildNode("Shop items, Order confirmation Proceed button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
//        verifyElementDisplayed(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
       if(verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"))){
           logger.info("SI_TC_87, Shop items, After clicking on Proceed button on order confirmation popup, One time pin input window/popup appears is validated");
           extentLoggerPass("SI_TC_87", "SI_TC_87, Shop items, After clicking on Proceed button on order confirmation popup, One time pin input window/popup appears is validated");
           System.out.println("-----------------------------------------------------------");
       }
    }

    public void shopItemsOrderConfirmationPopupCloseBtnFunctionality_SI_TC_88() throws Exception {
        HeaderChildNode("Shop items, Order confirmation Close button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
//        verifyElementDisplayed(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup, getTextVal(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objClose, getTextVal(MLWalletShopItemsPage.objClose, "Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn, "Button"))){
            logger.info("SI_TC_88, Shop items, After clicking on Close button on order confirmation popup, App navigates back to Place order page is validated");
            extentLoggerPass("SI_TC_88", "SI_TC_88, Shop items, After clicking on Close button on order confirmation popup, App navigates back to Place order page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsInsufficientBalanceErrorMsgValidation_SI_TC_91() throws Exception {
        HeaderChildNode("Shop Items, Insufficient balance error msg validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        if (verifyElementPresent(MLWalletShopItemsPage.objInsufficientBalanceMsg, getTextVal(MLWalletShopItemsPage.objInsufficientBalanceMsg, "Error msg"))) {
            String sActualErrorMsg = getText(MLWalletShopItemsPage.objInsufficientBalanceMsg);
            String sExceptedErrorMsg = "You have an insufficient balance to process the order. Please top up your account now.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("SI_TC_91, Shop Items, Insufficient balance error msg validated");
            extentLoggerPass("SI_TC_91", "SI_TC_91, Shop Items, Insufficient balance error msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsSuccessfulOrderPlacement_SI_TC_94() throws Exception {
        HeaderChildNode("Shop Items, Successful order placement validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objOrderSuccessfully,getTextVal(MLWalletShopItemsPage.objOrderSuccessfully,"popup"))) {
            verifyElementPresent(MLWalletShopItemsPage.objOkayBtn, getTextVal(MLWalletShopItemsPage.objOkayBtn, "Btn"));
            logger.info("SI_TC_94, Shop Items, Successful order placement validated");
            extentLoggerPass("SI_TC_94", "SI_TC_94, Shop Items, Successful order placement validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAvailableBalanceValidationAfterSuccessfulOrderPlacement_SI_TC_95() throws Exception {
        HeaderChildNode("Shop items, Available balance validation after successful order placement");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        String sAvailableBalance = getText(MLWalletHomePage.objAvailableBalance);
        System.out.println(sAvailableBalance);
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        waitTime(30000);
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        verifyElementPresent(MLWalletShopItemsPage.objOkayBtn, getTextVal(MLWalletShopItemsPage.objOkayBtn, "Btn"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBackArrowBtn,"ML Shop page back arrow button");
        waitTime(10000);
        Swipe("DOWN",2);
        String sAvailableBalanceAfterOrderPlacement = getText(MLWalletHomePage.objAvailableBalance);
        logger.info("Available Balance Before order placement : "+sAvailableBalance);
        logger.info("Available Balance After order placement : "+sAvailableBalanceAfterOrderPlacement);
        extentLogger("","Available Balance Before order placement : "+sAvailableBalance);
        extentLogger("","Available Balance After order placement : "+sAvailableBalanceAfterOrderPlacement);
        assertNotEquals(sAvailableBalance,sAvailableBalanceAfterOrderPlacement);
        if(!sAvailableBalance.equals(sAvailableBalanceAfterOrderPlacement)){
            logger.info("SI_TC_95, Shop Items, After Successful order placement amount deducted from Available balance is validated");
            extentLoggerPass("SI_TC_95", "SI_TC_95, Shop Items, After Successful order placement amount deducted from Available balance is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingMLWalletPaymentMethod_SI_TC_97() throws Exception {
        HeaderChildNode("Shop items, cart page validation after successful order placement using ML Wallet payment method");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        String sAvailableBalance = getText(MLWalletHomePage.objAvailableBalance);
        System.out.println(sAvailableBalance);
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameInCartPage = getText(MLWalletShopItemsPage.objProductNameInCartPage);
        logger.info("Product added to cart : " +sProductNameInCartPage);
        extentLogger("","Product added to cart : " +sProductNameInCartPage);
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        waitTime(30000);
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objOkayBtn, getTextVal(MLWalletShopItemsPage.objOkayBtn, "Btn"));
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCartLink,getTextVal(MLWalletShopItemsPage.objCartLink,"Link"));
        verifyElementNotPresent(MLWalletShopItemsPage.objProductNameInCartPage,"Added item",5);
        logger.info("Added item is not displayed");
        extentLogger("","Added item is not displayed");
        if(verifyElementPresent(MLWalletShopItemsPage.objEmptyCartMsg,getTextVal(MLWalletShopItemsPage.objEmptyCartMsg,"Message"))) {
            logger.info("SI_TC_97, Shop Items, After Successful order placement using ML Wallet payment method selected item is not displaying in cart validated");
            extentLoggerPass("SI_TC_97", "SI_TC_97, Shop Items, Shop Items, After Successful order placement using ML Wallet payment method selected item is not displaying in cart validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymentMethodsUnderPaymongoServicesValidation_SI_TC_98() throws Exception {
        HeaderChildNode("Shop items, Payment method under Paymongo services validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"))) {
            verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), "Payment method"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), "Payment method"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), "Payment method"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment method"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod("VISA/MASTERCARD"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("VISA/MASTERCARD"), "Payment method"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), "Payment method"));
            logger.info("SI_TC_98, Shop Items, Payment method under Paymongo services validated");
            extentLoggerPass("SI_TC_98", "SI_TC_98, Shop Items, Payment method under Paymongo services validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsVisaMasterCardPaymentMethodPartnerFeeValidation_SI_TC_99() throws Exception {
        HeaderChildNode("Shop items, VISA/MASTERCARD payment method Partner fee validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 1);
        String sProductPrice = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
        sProductPrice = sProductPrice.substring(1,sProductPrice.length());
        if(sProductPrice.contains(",")){
            sProductPrice = sProductPrice.replace(",","");
        }
        double fProductPrice = Float.parseFloat(sProductPrice);
        System.out.println(fProductPrice);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("VISA/MASTERCARD"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("VISA/MASTERCARD"), "Payment method"));
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        double fShippingTotal = Float.parseFloat(sShippingTotal);
        double fPartnerFee = (fProductPrice+fShippingTotal)*(0.03);
        double fExceptedServiceTotal = fPartnerFee+10;
        int nExceptedServiceTotal = (int)fExceptedServiceTotal;
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        double fServiceTotal = Float.parseFloat(sServiceTotal);
        int nServiceTotal = (int)fServiceTotal;
        logger.info("Service Fee : "+fShippingTotal);
        extentLogger("","Service Fee : "+fShippingTotal);
        logger.info("Partner fee calculated 3% for Direct online Banking : "+fPartnerFee);
        extentLogger("","Partner fee calculated 3% for Direct online Banking : "+fPartnerFee);
        logger.info("Service Fee calculated : "+nExceptedServiceTotal);
        extentLogger("","Service Fee calculated : "+nExceptedServiceTotal);
        logger.info("Service Total displayed : "+nServiceTotal);
        extentLogger("","Service Total displayed : "+nServiceTotal);
        assertionValidation(nServiceTotal,nExceptedServiceTotal);
        if(nServiceTotal==nExceptedServiceTotal){
            logger.info("SI_TC_99, Shop Items, Service total is the sum of Service fee, partner's fee of 3% of item price and ₱10 for Visa/MasterCard is validated");
            extentLoggerPass("SI_TC_99", "SI_TC_99, Shop Items, Service total is the sum of Service fee, partner's fee of 3% of item price and ₱10 for Visa/MasterCard is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsGCashPaymentMethodPartnerFeeValidation_SI_TC_100() throws Exception {
        HeaderChildNode("Shop items, GCash payment method Partner fee validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 1);
        String sProductPrice = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
        sProductPrice = sProductPrice.substring(1,sProductPrice.length());
        if(sProductPrice.contains(",")){
            sProductPrice = sProductPrice.replace(",","");
        }
        double fProductPrice = Float.parseFloat(sProductPrice);
        System.out.println(fProductPrice);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), "Payment option"));
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        double fShippingTotal = Float.parseFloat(sShippingTotal);
        double fPartnerFee = (fProductPrice+fShippingTotal)*(0.022);
        double fExceptedServiceTotal = fPartnerFee;
        int nExceptedServiceTotal = (int)fExceptedServiceTotal;
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        double fServiceTotal = Float.parseFloat(sServiceTotal);
        int nServiceTotal = (int)fServiceTotal;
        logger.info("Service Fee : "+fShippingTotal);
        extentLogger("","Service Fee : "+fShippingTotal);
        logger.info("Partner fee calculated 2.2% for GCash payment method : "+fPartnerFee);
        extentLogger("","Partner fee calculated 2.2% for GCash payment method : "+fPartnerFee);
        logger.info("Service Fee calculated : "+nExceptedServiceTotal);
        extentLogger("","Service Fee calculated : "+nExceptedServiceTotal);
        logger.info("Service Total displayed : "+nServiceTotal);
        extentLogger("","Service Total displayed : "+nServiceTotal);
        assertionValidation(nServiceTotal,nExceptedServiceTotal);
        if(nServiceTotal==nExceptedServiceTotal){
            logger.info("SI_TC_100, Shop Items, Service total is the sum of Service fee and partner's fee of 2.2% of item price for GCash is validated");
            extentLoggerPass("SI_TC_100", "SI_TC_100, Shop Items, Service total is the sum of Service fee and partner's fee of 2.2% of item price for GCash is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsGrabPayPaymentMethodPartnerFeeValidation_SI_TC_101() throws Exception {
        HeaderChildNode("Shop items, GrabPay payment method Partner fee validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 1);
        String sProductPrice = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
        sProductPrice = sProductPrice.substring(1,sProductPrice.length());
        if(sProductPrice.contains(",")){
            sProductPrice = sProductPrice.replace(",","");
        }
        double fProductPrice = Float.parseFloat(sProductPrice);
        System.out.println(fProductPrice);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), "Payment option"));
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        double fShippingTotal = Float.parseFloat(sShippingTotal);
        double fPartnerFee = (fProductPrice+fShippingTotal)*(0.018);
        double fExceptedServiceTotal = fPartnerFee;
        int nExceptedServiceTotal = (int)fExceptedServiceTotal;
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        double fServiceTotal = Float.parseFloat(sServiceTotal);
        int nServiceTotal = (int)fServiceTotal;
        logger.info("Service Fee : "+fShippingTotal);
        extentLogger("","Service Fee : "+fShippingTotal);
        logger.info("Partner fee calculated 1.8% for GrabPay payment method : "+fPartnerFee);
        extentLogger("","Partner fee calculated 1.8%  for GrabPay payment method : "+fPartnerFee);
        logger.info("Service Fee calculated : "+nExceptedServiceTotal);
        extentLogger("","Service Fee calculated : "+nExceptedServiceTotal);
        logger.info("Service Total displayed : "+nServiceTotal);
        extentLogger("","Service Total displayed : "+nServiceTotal);
        assertionValidation(nServiceTotal,nExceptedServiceTotal);
        if(nServiceTotal==nExceptedServiceTotal){
            logger.info("SI_TC_101, Shop Items, Service total is the sum of Service fee and partner's fee of 1.8% of item price for GrabPay is validated");
            extentLoggerPass("SI_TC_101", "SI_TC_101, Shop Items, Service total is the sum of Service fee and partner's fee of 1.8%  of item price for GrabPay is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsMayaPaymentMethodPartnerFeeValidation_SI_TC_102() throws Exception {
        HeaderChildNode("Shop items, Maya payment method Partner fee validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 1);
        String sProductPrice = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
        sProductPrice = sProductPrice.substring(1,sProductPrice.length());
        if(sProductPrice.contains(",")){
            sProductPrice = sProductPrice.replace(",","");
        }
        double fProductPrice = Float.parseFloat(sProductPrice);
        System.out.println(fProductPrice);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment option"));
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        double fShippingTotal = Float.parseFloat(sShippingTotal);
        double fPartnerFee = (fProductPrice+fShippingTotal)*(0.018);
        double fExceptedServiceTotal = fPartnerFee;
        int nExceptedServiceTotal = (int)fExceptedServiceTotal;
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        double fServiceTotal = Float.parseFloat(sServiceTotal);
        int nServiceTotal = (int)fServiceTotal;
        logger.info("Service Fee : "+fShippingTotal);
        extentLogger("","Service Fee : "+fShippingTotal);
        logger.info("Partner fee calculated 1.8% for Maya payment method : "+fPartnerFee);
        extentLogger("","Partner fee calculated 1.8%  for Maya payment method : "+fPartnerFee);
        logger.info("Service Fee calculated : "+nExceptedServiceTotal);
        extentLogger("","Service Fee calculated : "+nExceptedServiceTotal);
        logger.info("Service Total displayed : "+nServiceTotal);
        extentLogger("","Service Total displayed : "+nServiceTotal);
        assertionValidation(nServiceTotal,nExceptedServiceTotal);
        if(nServiceTotal==nExceptedServiceTotal){
            logger.info("SI_TC_102, Shop Items, Service total is the sum of Service fee and partner's fee of 1.8% of item price for Maya payment method is validated");
            extentLoggerPass("SI_TC_102", "SI_TC_102, Shop Items, Service total is the sum of Service fee and partner's fee of 1.8%  of item price for Maya payment method is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsDirectOnlineBankingPaymentMethodPartnerFeeValidation_SI_TC_103() throws Exception {
        HeaderChildNode("Shop items, Direct online banking payment method Partner fee validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), "Payment method"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Service Total"),getTextVal(MLWalletShopItemsPage.getAmountValue("Service Total"),"Service Total"))){
            String nActualServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
            String sExceptedServiceTotal = "₱15.00";
            assertionValidation(nActualServiceTotal,sExceptedServiceTotal);
            logger.info("SI_TC_103, Shop Items, For Direct online banking payment method Partner fee will be ₱15.00 validated");
            extentLoggerPass("SI_TC_103", "SI_TC_103, Shop Items, For Direct online banking payment method Partner fee will be ₱15.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsGrabPayPlaceOrderConfirmationPopupValidation_SI_TC_104() throws Exception {
        HeaderChildNode("Shop items, Grab pay Place order confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,"Popup"))) {
            String sPopupMessage = getExceptedPopupMessage();
            String sExceptedPopupMsg = " Complete your purchase. Ensure to complete the payment process within 15 minutes to prevent payment interruption.";
            assertionValidation(sPopupMessage,sExceptedPopupMsg);
            verifyElementPresent(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
            logger.info("SI_TC_104, Shop Items, Grab pay Place order confirmation Popup validated");
            extentLoggerPass("SI_TC_104", "SI_TC_104, Shop items, Grab pay Place order confirmation Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsGCashPlaceOrderConfirmationPopupValidation_SI_TC_105() throws Exception {
        HeaderChildNode("Shop items, GCash Place order confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,"Popup"))) {
            String sPopupMessage = getExceptedPopupMessage();
            String sExceptedPopupMsg = " Complete your purchase. Ensure to complete the payment process within 15 minutes to prevent payment interruption.";
            assertionValidation(sPopupMessage,sExceptedPopupMsg);
            verifyElementPresent(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
            logger.info("SI_TC_105, Shop Items, GCash Place order confirmation Popup validated");
            extentLoggerPass("SI_TC_105", "SI_TC_105, Shop items, GCash Place order confirmation Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymayaPlaceOrderConfirmationPopupValidation_SI_TC_106() throws Exception {
        HeaderChildNode("Shop items, Paymaya Place order confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,"Popup"))) {
            String sPopupMessage = getExceptedPopupMessage();
            String sExceptedPopupMsg = " Complete your purchase. Ensure to complete the payment process within 15 minutes to prevent payment interruption.";
            assertionValidation(sPopupMessage,sExceptedPopupMsg);
            verifyElementPresent(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
            logger.info("SI_TC_106, Shop Items, Paymaya Place order confirmation Popup validated");
            extentLoggerPass("SI_TC_106", "SI_TC_106, Shop items, Paymaya Place order confirmation Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsVisaMastercardPlaceOrderConfirmationPopupValidation_SI_TC_107() throws Exception {
        HeaderChildNode("Shop items, Visa/Mastercard Place order confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("VISA/MASTERCARD");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,"Popup"))) {
            String sPopupMessage = getExceptedPopupMessage();
            String sExceptedPopupMsg = " Complete your purchase. Ensure to complete the payment process within 15 minutes to prevent payment interruption.";
            assertionValidation(sPopupMessage,sExceptedPopupMsg);
            verifyElementPresent(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
            logger.info("SI_TC_107, Shop Items, Visa/Mastercard Place order confirmation Popup validated");
            extentLoggerPass("SI_TC_107", "SI_TC_107, Shop items, Visa/Mastercard Place order confirmation Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsDirectOnlineBankingPlaceOrderConfirmationPopupValidation_SI_TC_108() throws Exception {
        HeaderChildNode("Shop items, Direct Online Banking Place order confirmation Popup Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("DIRECT ONLINE BANKING");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementDisplayed(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPaymongoPlaceOrderConfirmationPopup,"Popup"))) {
            String sPopupMessage = getExceptedPopupMessage();
            String sExceptedPopupMsg = " Complete your purchase. Ensure to complete the payment process within 15 minutes to prevent payment interruption.";
            assertionValidation(sPopupMessage,sExceptedPopupMsg);
            verifyElementPresent(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
            logger.info("SI_TC_108, Shop Items, Direct Online Banking Place order confirmation Popup validated");
            extentLoggerPass("SI_TC_108", "SI_TC_108, Shop items, Direct Online Banking Place order confirmation Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPayMongoPortalNavigationWithPaymentMethodAsVisaMastercard_SI_TC_109() throws Exception {
        HeaderChildNode("Shop items, Paymongo portal navigation validation with payment method as Visa Mastercard");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"VISA/MASTERCARD");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,getTextVal(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,"Payment method selected in Paymono page"))){
            String sActualPaymentMethod = getText(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage);
            String sExceptedPaymentMethod = "Visa or Mastercard";
            assertionValidation(sActualPaymentMethod,sExceptedPaymentMethod);
            verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment Amount in Paymongo page"));
            verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
            logger.info("SI_TC_109, Shop Items, Paymongo portal navigation validated with payment method as Visa Mastercard");
            extentLoggerPass("SI_TC_109", "SI_TC_109, Shop items, Paymongo portal navigation validated with payment method as Visa Mastercard");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsGrabPay_SI_TC_110() throws Exception {
        HeaderChildNode("Shop items, Paymongo portal navigation validation with payment method as Grab pay");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,getTextVal(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,"Payment method selected in Paymono page"))){
            String sActualPaymentMethod = getText(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage);
            String sExceptedPaymentMethod = "GrabPay";
            assertionValidation(sActualPaymentMethod,sExceptedPaymentMethod);
            verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment Amount in Paymongo page"));
            verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
            logger.info("SI_TC_110, Shop Items, Paymongo portal navigation validated with payment method as Grab pay");
            extentLoggerPass("SI_TC_110", "SI_TC_110, Shop items, Paymongo portal navigation validated with payment method as Grab pay");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsGCash_SI_TC_111() throws Exception {
        HeaderChildNode("Shop items, Paymongo portal navigation validation with payment method as GCash");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GCASH"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,getTextVal(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,"Payment method selected in Paymono page"))){
            String sActualPaymentMethod = getText(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage);
            String sExceptedPaymentMethod = "GCash";
            assertionValidation(sActualPaymentMethod,sExceptedPaymentMethod);
            verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment Amount in Paymongo page"));
            verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
            logger.info("SI_TC_111, Shop Items, Paymongo portal navigation validated with payment method as GCash");
            extentLoggerPass("SI_TC_111", "SI_TC_111, Shop items, Paymongo portal navigation validated with payment method as GCash");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsPaymaya_SI_TC_112() throws Exception {
        HeaderChildNode("Shop items, Paymongo portal navigation validation with payment method as Paymaya");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,getTextVal(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage,"Payment method selected in Paymono page"))){
            String sActualPaymentMethod = getText(MLWalletShopItemsPage.objSelectedPaymentMethodInPaymongoPage);
            String sExceptedPaymentMethod = "Maya";
            assertionValidation(sActualPaymentMethod,sExceptedPaymentMethod);
            verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment Amount in Paymongo page"));
            verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
            logger.info("SI_TC_112, Shop Items, Paymongo portal navigation validated with payment method as Paymaya");
            extentLoggerPass("SI_TC_112", "SI_TC_112, Shop items, Paymongo portal navigation validated with payment method as Pyamaya");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsDirectOnlineBanking_SI_TC_113() throws Exception {
        HeaderChildNode("Shop items, Paymongo portal navigation validation with payment method as Direct online banking");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"DIRECT ONLINE BANKING");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objBPIPaymentMethod,getTextVal(MLWalletShopItemsPage.objBPIPaymentMethod,"Payment method selected in Paymono page"))){
            String sActualPaymentMethod = getText(MLWalletShopItemsPage.objBPIPaymentMethod);
            String sExceptedPaymentMethod = "BPI Online";
            assertionValidation(sActualPaymentMethod,sExceptedPaymentMethod);
            verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment Amount in Paymongo page"));
            verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
            logger.info("SI_TC_113, Shop Items, Paymongo portal navigation validated with payment method as Direct online banking");
            extentLoggerPass("SI_TC_113", "SI_TC_113, Shop items, Paymongo portal navigation validated with payment method as Direct online banking");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsPlaceOrderConfirmationPopupCloseBtnFunctionality_SI_TC_114() throws Exception {
        HeaderChildNode("Shop items, Place order confirmation popup close button functionality validation");
        paymongoNavigation(prop.getproperty("Branch_Verified"),"DIRECT ONLINE BANKING");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"page"))){
            logger.info("SI_TC_114, Shop Items, After clicking on Close button on order confirmation popup, App navigates back to Place order page is validated");
            extentLoggerPass("SI_TC_114", "SI_TC_114, Shop items, After clicking on Close button on order confirmation popup, App navigates back to Place order page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

//    public void shopItemsSuccessfulOrderPlacementWithPaymayaPaymentMethod() throws Exception {
//        HeaderChildNode("Shop items, Successful order placement with Paymaya Payment method validation");
//        paymongoNavigation(prop.getproperty("Branch_Verified"),"E-WALLET");
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment method"));
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objContinue,getTextVal(MLWalletShopItemsPage.objContinue,"Button"));
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objPaymongoCheckBox,"Paymongo checkbox");
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objCompletePayment,getTextVal(MLWalletShopItemsPage.objCompletePayment,"Button"));
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objAuthorizeTestPayment,getTextVal(MLWalletShopItemsPage.objAuthorizeTestPayment,"Button"));
//        verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment amount in Paymongo page"));
//        verifyElementPresent(MLWalletShopItemsPage.objMayaPaymentReceived,getTextVal(MLWalletShopItemsPage.objMayaPaymentReceived,"Status message"));
//        verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
//        click(MLWalletShopItemsPage.objBackArrowBtn,"ML Shop Back arrow");
//        shopItemsNavigation();
//        hamburgerMenuNavigation();
//        verifyElementPresentAndClick(MLWalletShopItemsPage.objPurchaseHistory,getTextVal(MLWalletShopItemsPage.objPurchaseHistory,"Link"));
//    }

    public void shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingEWalletPaymentMethod_SI_TC_116() throws Exception {
        HeaderChildNode("Shop items, cart page validation after successful order placement using E-Wallet payment method");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        String sProductNameInCartPage = getText(MLWalletShopItemsPage.objProductNameInCartPage);
        logger.info("Product added to cart : " +sProductNameInCartPage);
        extentLogger("","Product added to cart : " +sProductNameInCartPage);
        navigationToCart();
        checkOutAndEditBranch("E-WALLET");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("PAYMAYA"), "Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objContinue,getTextVal(MLWalletShopItemsPage.objContinue,"Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPaymongoCheckBox,"Paymongo checkbox");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCompletePayment,getTextVal(MLWalletShopItemsPage.objCompletePayment,"Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAuthorizeTestPayment,getTextVal(MLWalletShopItemsPage.objAuthorizeTestPayment,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,getTextVal(MLWalletShopItemsPage.objPaymentAmountInPaymongoPage,"Payment amount in Paymongo page"));
//        verifyElementPresent(MLWalletShopItemsPage.objMayaPaymentReceived,getTextVal(MLWalletShopItemsPage.objMayaPaymentReceived,"Status message"));
//        verifyElementPresent(MLWalletShopItemsPage.objRefNumberInPaymongoPage,getTextVal(MLWalletShopItemsPage.objRefNumberInPaymongoPage,"Ref number in Paymongo page"));
        click(MLWalletShopItemsPage.objBackArrowBtn,"ML Shop Back arrow");
        shopItemsNavigation();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCartLink,getTextVal(MLWalletShopItemsPage.objCartLink,"Link"));
        verifyElementNotPresent(MLWalletShopItemsPage.objProductNameInCartPage,"Added item",5);
        logger.info("Added item is not displayed");
        extentLogger("","Added item is not displayed");
        if(verifyElementPresent(MLWalletShopItemsPage.objEmptyCartMsg,getTextVal(MLWalletShopItemsPage.objEmptyCartMsg,"Message"))) {
            logger.info("SI_TC_116, Shop Items, After Successful order placement using E-Wallet payment method selected item is not displaying in cart validated");
            extentLoggerPass("SI_TC_116", "SI_TC_116, Shop Items, Shop Items, After Successful order placement using E-Wallet payment method selected item is not displaying in cart validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsProductsMerchandiseTotalValidation_SI_TC_117(String sPaymentMethod) throws Exception {
        HeaderChildNode("Shop items, Products Merchandise total validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        Swipe("down", 2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Necklaces & Pendants");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));

        float ssMerchandiseTotalAmountCalculated = 0;
        if(verifyElementDisplayed(MLWalletShopItemsPage.objProductPriceInPlaceOrder,"Product amount displayed in place order")) {
            List<WebElement> value = findElements(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
            int size = value.size();
            System.out.println(size);
            for (int i = 1; i <= value.size(); i++) {
                String sElement = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder(i));
                String sAmount = sElement.substring(1,sElement.length());
                if(sAmount.contains(",")){
                    sAmount = sAmount.replace(",","");
                }
                float nAmount = Float.parseFloat(sAmount);
                ssMerchandiseTotalAmountCalculated = ssMerchandiseTotalAmountCalculated+nAmount;
            }
        }
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod(sPaymentMethod),"Payment method"));
        Swipe("UP",1);
        String sMerchandiseTotalOrder = getText(MLWalletShopItemsPage.getAmountValue("Merchandise Total"));
        String sMerchandiseTotalOrderAmount = sMerchandiseTotalOrder.substring(1,sMerchandiseTotalOrder.length());
        if(sMerchandiseTotalOrderAmount.contains(",")){
            sMerchandiseTotalOrderAmount = sMerchandiseTotalOrderAmount.replace(",","");
        }
        float nSubTotalOrderAmountDisplayed = Float.parseFloat(sMerchandiseTotalOrderAmount);
        logger.info("Merchandise amount displayed  : "+sMerchandiseTotalOrderAmount);
        extentLogger("","Merchandise amount displayed  : "+sMerchandiseTotalOrderAmount);
        logger.info("Merchandise total amount calculated  : "+ssMerchandiseTotalAmountCalculated);
        extentLogger("","Merchandise total amount calculated  : "+ssMerchandiseTotalAmountCalculated);
        if(nSubTotalOrderAmountDisplayed==ssMerchandiseTotalAmountCalculated){
            logger.info("SI_TC_117, Shop items, Merchandise Total displayed is equals to total amount of items per seller is validated");
            extentLoggerPass("SI_TC_117", "SI_TC_117, Shop items, Merchandise Total displayed is equals to total amount of items per seller is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsShippingFeeValidationBasedOnLocationSelected_SI_TC_118() throws Exception {
        HeaderChildNode("Shop items, Shipping fee validation based on Location selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupProvince,"Province DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","Cebu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProvince("Cebu"),getTextVal(MLWalletShopItemsPage.objProvince("Cebu"),"Province"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","CEBU CITY");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("CEBU CITY"),getTextVal(MLWalletShopItemsPage.objCity("CEBU CITY"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        Swipe("UP",6);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch("ML NRA"),getTextVal(MLWalletShopItemsPage.objBranch("ML NRA"),"Branch"));
        String sShippingTotalForCebuCity = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        Swipe("DOWN",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","ALCOY");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("ALCOY"),getTextVal(MLWalletShopItemsPage.objCity("ALCOY"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch("ML ALCOY"),getTextVal(MLWalletShopItemsPage.objBranch("ML ALCOY"),"Branch"));
        Swipe("UP",1);
        String sShippingTotalForAlcoy = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        logger.info("Shipping total displayed for Cebu city : "+sShippingTotalForCebuCity);
        extentLogger("","Shipping total displayed for Cebu city  : "+sShippingTotalForCebuCity);
        logger.info("Shipping total displayed for Alcoy city  : "+sShippingTotalForAlcoy);
        extentLogger("","Shipping total displayed for Alcoy city  : "+sShippingTotalForAlcoy);
        assertNotEquals(sShippingTotalForCebuCity,sShippingTotalForAlcoy);
        if(!sShippingTotalForCebuCity.equals(sShippingTotalForAlcoy)){
            logger.info("SI_TC_118, Shop items, Shipping fee validated based on different Location selected");
            extentLoggerPass("SI_TC_118", "SI_TC_118, Shop items, Shop items, Shipping fee validated based on different Location selected");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsServiceTotalValidationBasedOnPaymentMethodSelected_SI_TC_119() throws Exception {
        HeaderChildNode("Shop items, Shipping Total validation based on different Payment method selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),"Payment method"));
        Swipe("UP",1);
        String sServiceFeeForMLWalletPaymentMethod = getText(MLWalletShopItemsPage.getAmountValue("Service Fee"));
        Swipe("DOWN",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"), "Payment method"));
        Swipe("UP",1);
        String sServiceFeeForDirectOnlineBankingPaymentMethod = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        logger.info("Service Total displayed for ML Wallet Payment method : "+sServiceFeeForMLWalletPaymentMethod);
        extentLogger("","Service Total displayed for ML Wallet Payment method : "+sServiceFeeForMLWalletPaymentMethod);
        logger.info("Service Total displayed for Direct online Banking Payment method : "+sServiceFeeForDirectOnlineBankingPaymentMethod);
        extentLogger("","Service Total displayed for Direct online Banking Payment method : "+sServiceFeeForDirectOnlineBankingPaymentMethod);
        assertNotEquals(sServiceFeeForMLWalletPaymentMethod,sServiceFeeForDirectOnlineBankingPaymentMethod);
        if(!sServiceFeeForMLWalletPaymentMethod.equals(sServiceFeeForDirectOnlineBankingPaymentMethod)){
            logger.info("SI_TC_119, Shop items, Shipping Total validated based on different Payment method selected");
            extentLoggerPass("SI_TC_119", "SI_TC_119, Shop items, Shipping Total validated based on different Payment method selected");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsTotalPurchasedItemValidation_SI_TC_120() throws Exception {
        HeaderChildNode("Shop items, Total purchased item validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        Swipe("down", 2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Necklaces & Pendants");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",5);
        if(verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Total Purchased Item"),getTextVal(MLWalletShopItemsPage.getAmountValue("Total Purchased Item"),"Total purchased item"))){
            String sActualPurchasedItem = getText(MLWalletShopItemsPage.getAmountValue("Total Purchased Item"));
            String sExceptedPurchasedItem = "2";
            assertionValidation(sActualPurchasedItem,sExceptedPurchasedItem);
            logger.info("SI_TC_120, Shop items, Total purchased item validated");
            extentLoggerPass("SI_TC_120", "SI_TC_120, Total purchased item validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsTotalPaymentValidation_SI_TC_121() throws Exception {
        HeaderChildNode("shop items, Total payment validation with respect to Merchandise Total, Service total and shipping total");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP", 3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),"Payment method"));
        Swipe("UP",1);
        String sMerchandiseTotal = getText(MLWalletShopItemsPage.getAmountValue("Merchandise Total"));
        sMerchandiseTotal = sMerchandiseTotal.substring(1,sMerchandiseTotal.length());
        if(sMerchandiseTotal.contains(",")){
            sMerchandiseTotal = sMerchandiseTotal.replace(",","");
        }
        float fMerchandiseTotal = Float.parseFloat(sMerchandiseTotal);
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        float fServiceTotal = Float.parseFloat(sServiceTotal);
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        float fShippingTotal = Float.parseFloat(sShippingTotal);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        sTotalPayment = sTotalPayment.substring(1,sTotalPayment.length());
        if(sTotalPayment.contains(",")){
            sTotalPayment = sTotalPayment.replace(",","");
        }
        float fTotalPayment = Float.parseFloat(sTotalPayment);
        logger.info("Merchandise Total : "+fMerchandiseTotal);
        extentLogger("","Merchandise Total : "+fMerchandiseTotal);
        logger.info("Service Total : "+fServiceTotal);
        extentLogger("","Service Total : "+fServiceTotal);
        logger.info("Shipping Total : "+sShippingTotal);
        extentLogger("","Shipping Total : "+sShippingTotal);
        logger.info("Total Payment : "+sTotalPayment);
        extentLogger("","Total Payment : "+sTotalPayment);

        float fTotalExceptedPayment = fMerchandiseTotal+fServiceTotal+fShippingTotal;
        logger.info("Total Payment By calculating Merchandise Total, Service Total and Shipping Total : "+fTotalExceptedPayment);
        extentLogger("","Total Payment By calculating Merchandise Total, Service Total and Shipping Total : "+fTotalExceptedPayment);
        assertionValidation(fTotalPayment,fTotalExceptedPayment);
        if(fTotalPayment==fTotalExceptedPayment){
            logger.info("SI_TC_121, Shop items, Total payment validated with respect to Merchandise Total, Service total and shipping total");
            extentLoggerPass("SI_TC_121", "SI_TC_121, Total payment validated with respect to Merchandise Total, Service total and shipping total");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectPaymentMethodErrorPopupValidation_SI_TC_122() throws Exception {
        HeaderChildNode("Shop Items, Select payment method error popup validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymentMethodErrorMsg,getTextVal(MLWalletShopItemsPage.objPaymentMethodErrorMsg,"Error Msg"))){
            String sActualErrorMsg = getText(MLWalletShopItemsPage.objPaymentMethodErrorMsg);
            String sExceptedErrorMsg = "Please Select Payment Method";
            assertionValidation(sActualErrorMsg,sExceptedErrorMsg);
            verifyElementPresent(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
            logger.info("SI_TC_122, Shop Items, Select payment method error popup validated");
            extentLoggerPass("SI_TC_122", "SI_TC_122, Shop Items, Select payment method error popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectPaymentMethodErrorPopupConfirmBtnValidation_SI_TC_123() throws Exception {
        HeaderChildNode("Shop Items, Select payment method error popup confirm btn validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresent(MLWalletShopItemsPage.objPaymentMethodErrorMsg,getTextVal(MLWalletShopItemsPage.objPaymentMethodErrorMsg,"Error Msg"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        verifyElementNotPresent(MLWalletShopItemsPage.objPaymentMethodErrorMsg,"Payment error msg",5);
        logger.info("Please Select Method Payment popup is not displayed");
        extentLoggerPass("Popup","Please Select Method Payment popup is not displayed");
        logger.info("SI_TC_123, Shop Items, After clicking on Select payment method popup confirm button, popup disappears is validated");
        extentLoggerPass("SI_TC_123", "SI_TC_123, Shop Items, After clicking on Select payment method popup confirm button, popup disappears is validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsServiceTotalValidationForDirectOnlineBankingPaymentMethod_SI_TC_126() throws Exception {
        HeaderChildNode("Shop items, Service total validation for Direct online banking payment method");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
        Swipe("UP", 1);
        String sProductPrice = getText(MLWalletShopItemsPage.objProductPriceInPlaceOrder);
        sProductPrice = sProductPrice.substring(1,sProductPrice.length());
        if(sProductPrice.contains(",")){
            sProductPrice = sProductPrice.replace(",","");
        }
        double fProductPrice = Float.parseFloat(sProductPrice);
        System.out.println(fProductPrice);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupProvince,"Province DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","Cebu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProvince("Cebu"),getTextVal(MLWalletShopItemsPage.objProvince("Cebu"),"Province"));
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","CEBU CITY");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("CEBU CITY"),getTextVal(MLWalletShopItemsPage.objCity("CEBU CITY"),"City"));
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        Swipe("UP",6);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch("ML NRA"),getTextVal(MLWalletShopItemsPage.objBranch("ML NRA"),"Branch"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("DIRECT ONLINE BANKING"),"Payment method"));
        Swipe("DOWN",4);
        String sServiceFee = getText(MLWalletShopItemsPage.getAmountValue("Service Fee"));
        sServiceFee = sServiceFee.substring(1,sServiceFee.length());
        if(sServiceFee.contains(",")){
            sServiceFee = sServiceFee.replace(",","");
        }
        double fServiceFee = Float.parseFloat(sServiceFee);
        Swipe("UP",5);
        double fPartnerFee = fProductPrice*(0.008);
        double fExceptedServiceTotal = fServiceFee+fPartnerFee;
        int nExceptedServiceTotal = (int)fExceptedServiceTotal;
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        double fServiceTotal = Float.parseFloat(sServiceTotal);
        int nServiceTotal = (int)fServiceTotal;
        logger.info("Service Fee : "+fServiceFee);
        extentLogger("","Service Fee : "+fServiceFee);
        logger.info("Partner fee calculated 0.8% for Direct online Banking : "+fPartnerFee);
        extentLogger("","Partner fee calculated 0.8% for Direct online Banking : "+fPartnerFee);
        logger.info("Service Fee calculated : "+nExceptedServiceTotal);
        extentLogger("","Service Fee calculated : "+nExceptedServiceTotal);
        logger.info("Service Total displayed : "+nServiceTotal);
        extentLogger("","Service Total displayed : "+nServiceTotal);
        assertionValidation(nServiceTotal,nExceptedServiceTotal);
        if(nServiceTotal==nExceptedServiceTotal){
            logger.info("SI_TC_126, Shop Items, Service total is the sum of Service fee and partner's fee of 0.8% of item price for Direct online banking is validated");
            extentLoggerPass("SI_TC_126", "SI_TC_126, Shop Items, Service total is the sum of Service fee and partner's fee of 0.8% of item price for Direct online banking is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsMaximumNumberOfItemsDisplayedPerPageValidation_SI_TC_127() throws Exception {
        HeaderChildNode("Shop items, Maximum number of items displayed per page validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objItemsDisplayedPerPage,"Items")){
        List<WebElement> values = findElements(MLWalletShopItemsPage.objItemsDisplayedPerPage);
        int nItemsDisplayedPerPage = values.size();
        for (int i = 0; i < values.size(); i++) {
            String displayedItem = values.get(i).getText();
            logger.info("Item "+(i+1)+" : " + displayedItem + " is displayed");
            extentLogger(" ", "Item "+(i+1)+" : " + displayedItem + " is displayed");
        }
        assertionValidation(nItemsDisplayedPerPage, 12);
        logger.info("SI_TC_127, Shop items, Maximum number of items displayed per page is 12 validated");
        extentLoggerPass("SI_TC_127", "SI_TC_127, Shop Items, Maximum number of items displayed per page is 12 validated");
        System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_128() throws Exception {
        HeaderChildNode("Shop items, Place order button remains disabled state if Pickup Branch is not selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",4);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"))){
            assertionValidation(getAttributValue("enabled", MLWalletShopItemsPage.objPlaceOrderBtn), "false");
            logger.info("SI_TC_128, Shop items, Place order button remains disabled state if Pickup Branch is not selected is validated");
            extentLoggerPass("SI_TC_128", "SI_TC_128, Shop items, Place order button remains disabled state if Pickup Branch is not selected is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSuccessfulOrderPlacementAsSemiVerifiedTier_SI_TC_92() throws Exception {
        HeaderChildNode("Shop Items, Successful order placement as Semi verified user validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified_One"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj10KRing, "10K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objOrderSuccessfully,getTextVal(MLWalletShopItemsPage.objOrderSuccessfully,"popup"))) {
            verifyElementPresent(MLWalletShopItemsPage.objOkayBtn, getTextVal(MLWalletShopItemsPage.objOkayBtn, "Btn"));
            logger.info("SI_TC_92, Shop Items, Successful order placement as Semi verified tier user validated");
            extentLoggerPass("SI_TC_92", "SI_TC_92, Shop Items, Successful order placement as Semi verified tier user validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsMaxTransactionErrorMsgValidationForSemiVerifiedUser_SI_TC_93() throws Exception {
        HeaderChildNode("Shop Items, Maximum transaction error msg validation for Semi verified user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Semi_Verified_One"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj20KRing, "20K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objMaxTransactionMsg,getTextVal(MLWalletShopItemsPage.objMaxTransactionMsg,"Error Msg"))){
            String sActualErrorMSg = getText(MLWalletShopItemsPage.objMaxTransactionMsg);
            String sExceptedErrorMsg = "You're transaction amount is greater than the transaction limit.";
            assertionValidation(sActualErrorMSg,sExceptedErrorMsg);
            logger.info("SI_TC_93, Shop Items, Maximum transaction error msg validated for Semi verified user");
            extentLoggerPass("SI_TC_93", "SI_TC_93, Shop Items, Maximum transaction error msg validated for Semi verified user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsDeleteConfirmationPopupUIValidation_SI_TC_143() throws Exception {
        HeaderChildNode("Shop items, Delete confirmation popup UI Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteButtons,"Delete button");
        if(verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"))){
            verifyElementPresent(MLWalletShopItemsPage.objYesBtn,getTextVal(MLWalletShopItemsPage.objYesBtn,"Button"));
            verifyElementPresent(MLWalletShopItemsPage.objCancelBtn,getTextVal(MLWalletShopItemsPage.objCancelBtn,"Button"));
            logger.info("SI_TC_143, Shop Items, Delete confirmation popup UI validated");
            extentLoggerPass("SI_TC_143", "SI_TC_143, Shop Items, Delete confirmation popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void shopItemsDeleteConfirmationPopupCancelBtnFunctionality_SI_TC_144() throws Exception {
        HeaderChildNode("Shop items, Delete confirmation popup cancel button functionality Validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteButtons,"Delete button");
        verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmationPopup,getTextVal(MLWalletShopItemsPage.objDeleteConfirmationPopup,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCancelBtn,getTextVal(MLWalletShopItemsPage.objCancelBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objCheckOutBtn,getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Page"))){
            logger.info("SI_TC_144, Shop Items, After clicking on Delete confirmation popup cancel button, popup disappears and App remains in cart page is validated");
            extentLoggerPass("SI_TC_144", "SI_TC_144, Shop Items, After clicking on Delete confirmation popup cancel button, popup disappears and App remains in cart page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsHamburgerMenuScreenValidation_SI_TC_145() throws Exception {
        HeaderChildNode("Shop Items Hamburger menu screen validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        hamburgerMenuNavigation();
        for(int nHamburgerMenuItem=1;nHamburgerMenuItem<7;nHamburgerMenuItem++){
            verifyElementPresent(MLWalletShopItemsPage.objHamburgerMenuItems(nHamburgerMenuItem),getTextVal(MLWalletShopItemsPage.objHamburgerMenuItems(nHamburgerMenuItem),"Hamburger menu item"));
        }
        verifyElementPresent(MLWalletShopItemsPage.objLogoutBtn,getTextVal(MLWalletShopItemsPage.objLogoutBtn,"Hamburger menu item"));
        logger.info("SI_TC_145, Shop Items Hamburger menu screen validated");
        extentLoggerPass("SI_TC_145", "SI_TC_145, Shop Items Hamburger menu screen validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsProductTypesUnderAmparitoCollectionValidation_SI_TC_146() throws Exception {
        HeaderChildNode("Shop Items, Product type under Amparito collection validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        if(verifyElementPresent(MLWalletShopItemsPage.objTypeHeader,getTextVal(MLWalletShopItemsPage.objTypeHeader,"Header"))){
            for(int sProductType=1;sProductType<8;sProductType++){
                verifyElementPresent(MLWalletShopItemsPage.objItemTypes(sProductType),getTextVal(MLWalletShopItemsPage.objItemTypes(sProductType),"Product type"));
            }
            logger.info("SI_TC_146, Shop Items, Product type under Amparito collection validated");
            extentLoggerPass("SI_TC_146", "SI_TC_146, Shop Items, Product type under Amparito collection validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsGenderTypesUnderAmparitoCollectionValidation_SI_TC_147() throws Exception {
        HeaderChildNode("Shop Items, Gender type under Amparito collection validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn, getTextVal(MLWalletShopItemsPage.objFilterBtn, "Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Popup"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objGenderHeader,getTextVal(MLWalletShopItemsPage.objGenderHeader,"Header"))){
            for(int sGenderType=1;sGenderType<4;sGenderType++){
                verifyElementPresent(MLWalletShopItemsPage.objGenderTypes(sGenderType),getTextVal(MLWalletShopItemsPage.objGenderTypes(sGenderType),"Gender type"));
            }
            logger.info("SI_TC_147, Shop Items, Gender type under Amparito collection validated");
            extentLoggerPass("SI_TC_147", "SI_TC_147, Shop Items, Gender type under Amparito collection validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsMaterialColorTypesUnderAmparitoCollectionValidation_SI_TC_148() throws Exception {
        HeaderChildNode("Shop Items, Material color type under Amparito collection validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn, getTextVal(MLWalletShopItemsPage.objFilterBtn, "Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Popup"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objMaterialColor,getTextVal(MLWalletShopItemsPage.objMaterialColor,"Header"))){
            for(int sMaterialColor=1;sMaterialColor<6;sMaterialColor++){
                verifyElementPresent(MLWalletShopItemsPage.objMaterialColorTypes(sMaterialColor),getTextVal(MLWalletShopItemsPage.objMaterialColorTypes(sMaterialColor),"Material color type"));
            }
            logger.info("SI_TC_148, Shop Items, Material color type under Amparito collection validated");
            extentLoggerPass("SI_TC_148", "SI_TC_148, Shop Items, Material color type under Amparito collection validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsMaterialTypesUnderAmparitoCollectionValidation_SI_TC_149() throws Exception {
        HeaderChildNode("Shop Items, Material types under Amparito collection validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn, getTextVal(MLWalletShopItemsPage.objFilterBtn, "Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Popup"));
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletShopItemsPage.objMaterialHeader,getTextVal(MLWalletShopItemsPage.objMaterialHeader,"Header"))){
            for(int sMaterial=1;sMaterial<8;sMaterial++){
                verifyElementPresent(MLWalletShopItemsPage.objMaterialTypes(sMaterial),getTextVal(MLWalletShopItemsPage.objMaterialTypes(sMaterial),"Material type"));
            }
            logger.info("SI_TC_149, Shop Items, Material types under Amparito collection validated");
            extentLoggerPass("SI_TC_149", "SI_TC_149, Shop Items, Material types under Amparito collection validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsAmparitoCollectionsPriceRangeValidation_SI_TC_150() throws Exception {
        HeaderChildNode("Shop items, Amparito collection price range validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Popup"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectedProductType,"Selected product type");
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objPriceRangeHeader,getTextVal(MLWalletShopItemsPage.objPriceRangeHeader,"Header"))){
            verifyElementPresent(MLWalletShopItemsPage.objMinInputField,getTextVal(MLWalletShopItemsPage.objMinInputField,"Minimum price range"));
            verifyElementPresent(MLWalletShopItemsPage.objMaxInputField,getTextVal(MLWalletShopItemsPage.objMaxInputField,"Maximum price range"));
            logger.info("SI_TC_150, Shop Items, Amparito collection price range validated");
            extentLoggerPass("SI_TC_150", "SI_TC_150, Shop Items, Amparito collection price range validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void shopItemsInsufficientBalancePopupCloseBtnFunctionality_SI_TC_151() throws Exception {
        HeaderChildNode("Shop Items, Insufficient balance popup close button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        verifyElementPresent(MLWalletShopItemsPage.objInsufficientBalanceMsg, getTextVal(MLWalletShopItemsPage.objInsufficientBalanceMsg, "Error msg"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objClose,getTextVal(MLWalletShopItemsPage.objClose,"Button"));
        verifyElementNotPresent(MLWalletShopItemsPage.objInsufficientBalanceMsg,"Insufficient popup",5);
        logger.info("Insufficient popup dismissed");
        extentLoggerPass("", "Insufficient popup dismissed");
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn,getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Button"))){
            logger.info("SI_TC_151, Shop Items, Insufficient balance popup dismissed, App stays in place order page is validated");
            extentLoggerPass("SI_TC_151", "SI_TC_151, Shop Items, Insufficient balance popup dismissed, App stays in place order page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsInsufficientBalancePopupTopUpBtnFunctionality_SI_TC_152() throws Exception {
        HeaderChildNode("Shop Items, Insufficient balance popup TopUp button functionality validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        verifyElementPresent(MLWalletShopItemsPage.objInsufficientBalanceMsg, getTextVal(MLWalletShopItemsPage.objInsufficientBalanceMsg, "Error msg"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objTopUpNow,getTextVal(MLWalletShopItemsPage.objTopUpNow,"Button"));
        if(verifyElementPresentAndClick(MLWalletShopItemsPage.objQRPageHeader,getTextVal(MLWalletShopItemsPage.objQRPageHeader,"Header"))){
            for(int sStep=1;sStep<=3;sStep++){
                verifyElementPresent(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),getTextVal(MLWalletShopItemsPage.objStepsToUseMLWallet(sStep),"Step "+sStep));
            }
            Swipe("UP",2);
            verifyElementPresent(MLWalletShopItemsPage.objTermsAndPolicies,getTextVal(MLWalletShopItemsPage.objTermsAndPolicies,"Link"));
            verifyElementPresent(MLWalletShopItemsPage.objPrivacyPolicy,getTextVal(MLWalletShopItemsPage.objPrivacyPolicy,"Link"));
            logger.info("SI_TC_152, Shop Items, After clicking on TopUp button on popup, App navigates to To use ML Wallet on your computer page is validated");
            extentLoggerPass("SI_TC_152", "SI_TC_152, Shop Items, After clicking on TopUp button on popup, App navigates to To use ML Wallet on your computer page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsWatchItemsDisplayedValidation_SI_TC_13() throws Exception {
        HeaderChildNode("Shop items, Watch items displayed validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        if(verifyElementPresent(MLWalletShopItemsPage.objWatchItemsHeader,getTextVal(MLWalletShopItemsPage.objWatchItemsHeader,"Header"))){
            verifyElementPresent(MLWalletShopItemsPage.objWatchOne,"Watch image 1");
            verifyElementPresent(MLWalletShopItemsPage.objWatchTwo,"Watch image 2");
            verifyElementPresent(MLWalletShopItemsPage.objWatchThree,"Watch image 3");
            verifyElementPresent(MLWalletShopItemsPage.objWatchFour,"Watch image 4");
            logger.info("SI_TC_13, Shop items, Watch items displayed validated");
            extentLoggerPass("SI_TC_13", "SI_TC_13, Shop items, Watch items displayed validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAutoCheckedFiltersValidation_SI_TC_20() throws Exception {
        HeaderChildNode("Shop items, Auto checked filters validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objCategory,getTextVal(MLWalletShopItemsPage.objCategory,"Filter popup"))){
            List<WebElement> value = findElements(MLWalletShopItemsPage.objAutoCheckedFilter);
            for(int nFilter=1;nFilter<=value.size();nFilter++){
                String sAutoCheckedFilter = getText(MLWalletShopItemsPage.objAutoCheckedFilters(nFilter));
                logger.info("Auto Checked filter : "+sAutoCheckedFilter);
                extentLogger("","Auto Checked filter : "+sAutoCheckedFilter);
            }
            logger.info("SI_TC_20, Shop items, Auto checked filters validated");
            extentLoggerPass("SI_TC_20", "SI_TC_20, Shop items, Auto checked filters validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedJewelryItemScreenUIValidation_SI_TC_46() throws Exception {
        HeaderChildNode("Shop Items, Selected Jewelry item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        if (verifyElementPresent(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material Color"),"Material Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"),getTextVal(MLWalletShopItemsPage.objProductInfo("Size"),"Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Item Weight"),getTextVal(MLWalletShopItemsPage.objProductInfo("Item Weight"),"Item Weight Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock No."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock No."),"Stock No. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"),getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"),"Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_46, Shop Items, Selected Jewelry item screen UI validated");
            extentLoggerPass("SI_TC_46", "SI_TC_46, Shop Items, Selected Jewelry item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsWatchItemsValidationDependingOnCheckBoxesSelected_SI_TC_47() throws Exception {
        HeaderChildNode("Shop items, Watch product items validation depending on check boxes selected");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objWatchOne,"Watch Image");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilterBtn,getTextVal(MLWalletShopItemsPage.objFilterBtn,"Button"));
        List<WebElement> value = findElements(MLWalletShopItemsPage.objAutoCheckedFilter);
        for(int nFilter=1;nFilter<=value.size();nFilter++){
            String sAutoCheckedFilter = getText(MLWalletShopItemsPage.objAutoCheckedFilters(nFilter));
            logger.info("Auto Checked filter : "+sAutoCheckedFilter);
            extentLogger("","Auto Checked filter : "+sAutoCheckedFilter);
        }
        Swipe("DOWN",2);
        tapUsingCoordinates(280,154);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objWatchImage,"Matching Elements")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objWatchImage);
            for (int sWatchName = 1; sWatchName <= values.size(); sWatchName++) {
                String displayedItem = getText(MLWalletShopItemsPage.objWatchItemName(sWatchName));
                logger.info("Watch product : " + displayedItem + " is displayed");
                extentLogger(" ", "Watch product : " + displayedItem + " is displayed");
            }
            logger.info("SI_TC_47, Shop items, Watch product items validated depending on check boxes selected");
            extentLoggerPass("SI_TC_47", "SI_TC_47, Shop items, Watch product items validated depending on check boxes selected");
            System.out.println("-----------------------------------------------------------");
        }else{
            verifyElementPresent(MLWalletShopItemsPage.objNoProductsFoundMsg,getTextVal(MLWalletShopItemsPage.objNoProductsFoundMsg,"Message"));
            logger.info("SI_TC_47, Shop items, No matching products message displayed and validated");
            extentLoggerPass("SI_TC_47", "SI_TC_47, Shop items, No matching products message displayed and validated");
            System.out.println("-----------------------------------------------------------");
        }

    }




    public void shopItemsSpecificWatchProductDetailsValidation_SI_TC_48() throws Exception {
        HeaderChildNode("Shop items, Specific watch product details validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        if(verifyElementPresent(MLWalletShopItemsPage.objSelectItemPageProductName,getTextVal(MLWalletShopItemsPage.objSelectItemPageProductName,"Gender,Style Name and Type"))) {
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemProductDescription, (getAttributValue("name",MLWalletShopItemsPage.objSelectItemProductDescription)+"Stone, Material and Material Color"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemProductDiscount, getTextVal(MLWalletShopItemsPage.objSelectItemProductDiscount, "Discount Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemDiscountProductPrice, getTextVal(MLWalletShopItemsPage.objSelectItemDiscountProductPrice, "Discount product price"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectItemActualProductPrice, getTextVal(MLWalletShopItemsPage.objSelectItemActualProductPrice, "Actual product price"));
            logger.info("SI_TC_48, Shop items, Specific watch product details validated");
            extentLoggerPass("SI_TC_48", "SI_TC_48, Shop items, Specific watch product details validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSelectedWatchItemScreenUIValidation_SI_TC_57() throws Exception {
        HeaderChildNode("Shop Items, Selected Watch item screen UI validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objWatchOne,"Watch Image");
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("up", 1);
        waitTime(5000);
        if (verifyElementDisplayed(MLWalletShopItemsPage.objProductNameInSelectedPage,"Element Name")) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objProductNameInSelectedPage);
            for (int i = 0; i < values.size(); i++) {
                String displayedItemName = values.get(i).getText();
                logger.info("Item : " + displayedItemName + " is displayed");
                extentLogger(" ", "Item : " + displayedItemName + " is displayed");
            }
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Model Name"),getTextVal(MLWalletShopItemsPage.objProductInfo("Model Name"),"Model Name Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Material"),getTextVal(MLWalletShopItemsPage.objProductInfo("Material"),"Material Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Color"),getTextVal(MLWalletShopItemsPage.objProductInfo("Color"),"Color Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Size"),getTextVal(MLWalletShopItemsPage.objProductInfo("Size"),"Size Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Brand"),getTextVal(MLWalletShopItemsPage.objProductInfo("Brand"),"Brand Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Movement"),getTextVal(MLWalletShopItemsPage.objProductInfo("Movement"),"Movement Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Gender"),getTextVal(MLWalletShopItemsPage.objProductInfo("Gender"),"Gender Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Stock no."),getTextVal(MLWalletShopItemsPage.objProductInfo("Stock no."),"Stock no. Info"));
            verifyElementPresent(MLWalletShopItemsPage.objProductInfo("Notes"),getTextVal(MLWalletShopItemsPage.objProductInfo("Notes"),"Notes Info"));
            Swipe("UP",1);
            verifyElementPresent(MLWalletShopItemsPage.objSavePercentage,getTextVal(MLWalletShopItemsPage.objSavePercentage,"% Save Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountAmount,getTextVal(MLWalletShopItemsPage.objDiscountAmount,"Discount Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objActualAmount,getTextVal(MLWalletShopItemsPage.objActualAmount,"Actual Amount"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            logger.info("SI_TC_57, Shop Items, Selected Watch item screen UI validated");
            extentLoggerPass("SI_TC_57", "SI_TC_57, Shop Items, Watch Earrings item screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsServiceFeeValidationForOrdersWithSameOriginAndDestinationBranchUsingPaymongoPaymentMethod_SI_TC_71() throws Exception {
        HeaderChildNode("Shop[ items, service fee validation for order with orders with same origin and same destination branch using Paymongo payment method");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupProvince,"Province DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","Cebu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProvince("Cebu"),getTextVal(MLWalletShopItemsPage.objProvince("Cebu"),"Province"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPickupCity,"City DropDown");
        scroll_To_Text(MLWalletShopItemsPage.objCollections,"name","CEBU CITY");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCity("CEBU CITY"),getTextVal(MLWalletShopItemsPage.objCity("CEBU CITY"),"City"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,"Branch DropDown");
        Swipe("UP",9);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch("ML NRA"),getTextVal(MLWalletShopItemsPage.objBranch("ML NRA"),"Branch"));
        Swipe("UP",2);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethodTxt,getTextVal(MLWalletShopItemsPage.objSelectPaymentMethodTxt,"Header"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("E-WALLET"),"Payment method"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("GRAB PAY"), "Payment method"));
        Swipe("DOWN",4);
        if(verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Service Fee"),getTextVal(MLWalletShopItemsPage.getAmountValue("Service Fee"),"Service Fee"))) {
            String sServiceFeeForPaymongoPaymentMethod = getText(MLWalletShopItemsPage.getAmountValue("Service Fee"));
            String sExpectedServiceFee = "₱30.00";
            assertionValidation(sServiceFeeForPaymongoPaymentMethod,sExpectedServiceFee);
            logger.info("SI_TC_71, Shop Items, service fee of ₱30.00 for order with orders with same origin and same destination branch using Paymongo payment method validated");
            extentLoggerPass("SI_TC_71", "SI_TC_71, Shop Items, service fee of ₱30.00 for order with orders with same origin and same destination branch using Paymongo payment method validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAccountInformationValidationWithMLWalletAutoLogin_SI_TC_79() throws Exception {
        HeaderChildNode("Shop items, Account information validation with ML Wallet Auto Login");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletShopItemsPage.objAccountInformation,getTextVal(MLWalletShopItemsPage.objAccountInformation,"Header"))){
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("Mobile Number"),getTextVal(MLWalletShopItemsPage.objAccountInformation("Mobile Number"),"Mobile Number"));
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("First Name"),getTextVal(MLWalletShopItemsPage.objAccountInformation("First Name"),"First Name"));
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("Last Name"),getTextVal(MLWalletShopItemsPage.objAccountInformation("Last Name"),"Last Name"));
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("Email"),getTextVal(MLWalletShopItemsPage.objAccountInformation("Email"),"Email"));
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("Zipcode"),getTextVal(MLWalletShopItemsPage.objAccountInformation("Zipcode"),"Zipcode"));
            verifyElementPresent(MLWalletShopItemsPage.objAccountInformation("Street"),getTextVal(MLWalletShopItemsPage.objAccountInformation("Street"),"Zipcode"));
            verifyElementPresent(MLWalletShopItemsPage.objCountry,getTextVal(MLWalletShopItemsPage.objCountry,"Country"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPickupProvince,getTextVal(MLWalletShopItemsPage.objSelectPickupProvince,"State"));
            verifyElementPresent(MLWalletShopItemsPage.objAccInfoCityDisplayed,getTextVal(MLWalletShopItemsPage.objAccInfoCityDisplayed,"city"));
            logger.info("SI_TC_79, Shop Items, Account information validated with ML Wallet Auto Login");
            extentLoggerPass("SI_TC_79", "SI_TC_79, Shop Items, Account information validated with ML Wallet Auto Login");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsOrderConfirmationMessageValidation_SI_TC_86() throws Exception {
        HeaderChildNode("Shop items, Order confirmation message validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart("Rings");
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,getTextVal(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup,"Popup"))) {
            String sActualPopup = getText(MLWalletShopItemsPage.objPlaceOrderConfirmationPopup);
            String sExceptedPopupMsg = "You are about to be charged on the amount of "+sTotalPayment+" on your ML Wallet account balance.";
            assertionValidation(sActualPopup,sExceptedPopupMsg);
            logger.info("SI_TC_86, Shop Items, Order confirmation message validated");
            extentLoggerPass("SI_TC_86", "SI_TC_86, Shop Items, Order confirmation message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForFullyVerifiedUser_SI_TC_161() throws Exception {
        HeaderChildNode("Shop items, Transaction Error message validation When cart value exceeds Transaction limit for Fully verified user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        waitTime(3000);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("100,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("100,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        Swipe("DOWN",2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("80,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("80,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("60,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("60,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Total Payment"),getTextVal(MLWalletShopItemsPage.getAmountValue("Total Payment"),"Total Amount"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,getTextVal(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,"Message"))){
            String sActualPopupMsg = getText(MLWalletShopItemsPage.objExceedsTransactionLimitMsg);
            String sExceptedPopupMsg = "You're transaction amount is greater than the transaction limit.";
            assertionValidation(sActualPopupMsg,sExceptedPopupMsg);
            logger.info("SI_TC_161, Shop Items, Transaction Error message validated When cart value exceeds Transaction limit for Fully verified user");
            extentLoggerPass("SI_TC_161", "SI_TC_161, Transaction Error message validated When cart value exceeds Transaction limit for Fully verified user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBuyerTierUser_SI_TC_167() throws Exception {
        HeaderChildNode("Shop items, Transaction Error message validation When cart value exceeds Transaction limit for Buyer Tier user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        shopItemsNavigation();
        navigationToCart();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop, getTextVal(MLWalletShopItemsPage.objShop, "Link"));
        waitTime(3000);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("100,000.00"), getTextVal(MLWalletShopItemsPage.objAmount("100,000.00"), "item"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup, getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup, "popup"));
        click(MLWalletShopItemsPage.objConfirmBtn, getTextVal(MLWalletShopItemsPage.objConfirmBtn, "Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Total Payment"),getTextVal(MLWalletShopItemsPage.getAmountValue("Total Payment"),"Total Amount"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,getTextVal(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,"Message"))){
            String sActualPopupMsg = getText(MLWalletShopItemsPage.objExceedsTransactionLimitMsg);
            String sExceptedPopupMsg = "You're transaction amount is greater than the transaction limit.";
            assertionValidation(sActualPopupMsg,sExceptedPopupMsg);
            logger.info("SI_TC_167, Shop Items, Transaction Error message validated When cart value exceeds Transaction limit for Buyer Tier user");
            extentLoggerPass("SI_TC_167", "SI_TC_167, Transaction Error message validated When cart value exceeds Transaction limit for Buyer Tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBranchVerifiedUser_SI_TC_173() throws Exception {
        HeaderChildNode("Shop items, Transaction Error message validation When cart value exceeds Transaction limit for Branch verified user");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        waitTime(3000);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("100,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("100,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        Swipe("DOWN",2);
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("80,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("80,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objAmount("60,000.00"),getTextVal(MLWalletShopItemsPage.objAmount("60,000.00"),"item"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAddToCartBtn,getTextVal(MLWalletShopItemsPage.objAddToCartBtn,"Button"));
        verifyElementDisplayed(MLWalletShopItemsPage.objItemConfirmationPopup,getTextVal(MLWalletShopItemsPage.objItemConfirmationPopup,"popup"));
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        verifyElementPresent(MLWalletShopItemsPage.getAmountValue("Total Payment"),getTextVal(MLWalletShopItemsPage.getAmountValue("Total Payment"),"Total Amount"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        itemConfirmationPopup();
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField, "OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField, prop.getproperty("Valid_OTP"), "OTP Input field");
        if(verifyElementPresent(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,getTextVal(MLWalletShopItemsPage.objExceedsTransactionLimitMsg,"Message"))){
            String sActualPopupMsg = getText(MLWalletShopItemsPage.objExceedsTransactionLimitMsg);
            String sExceptedPopupMsg = "You're transaction amount is greater than the transaction limit.";
            assertionValidation(sActualPopupMsg,sExceptedPopupMsg);
            logger.info("SI_TC_173, Shop Items, Transaction Error message validated When cart value exceeds Transaction limit for Branch verified user");
            extentLoggerPass("SI_TC_173", "SI_TC_173, Transaction Error message validated When cart value exceeds Transaction limit for Branch verified user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsRecentTransactionValidation_SI_TC_180() throws Exception {
        HeaderChildNode("Shop Items, ML Shop Recent transaction validation");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
        String sAvailableBalance = getText(MLWalletHomePage.objAvailableBalance);
        System.out.println(sAvailableBalance);
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objCartIcon, "Cart Icon");
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu("Rings"), "Rings Item");
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.obj500Ring, "5K Ring Item");
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(3000);
        click(MLWalletShopItemsPage.objConfirmBtn,getTextVal(MLWalletShopItemsPage.objConfirmBtn,"Button"));
        navigationToCart();
        checkOutAndEditBranch("ML WALLET");
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn,"Place Order Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProceed,getTextVal(MLWalletShopItemsPage.objProceed,"Button"));
        waitTime(30000);
        verifyElementPresent(MLWalletShopItemsPage.objOneTimePin, getTextVal(MLWalletShopItemsPage.objOneTimePin, "Pop up"));
        click(MLWalletShopItemsPage.objOTPInputField,"OTP Input field");
        type(MLWalletShopItemsPage.objOTPInputField,prop.getproperty("Valid_OTP"),"OTP Input field");
        verifyElementPresent(MLWalletShopItemsPage.objOkayBtn, getTextVal(MLWalletShopItemsPage.objOkayBtn, "Btn"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBackArrowBtn,"ML Shop page back arrow button");
        waitTime(10000);
        Swipe("DOWN",2);
        Swipe("UP",1);
        if(verifyElementPresent(MLWalletHomePage.objRecentTransactions,getTextVal(MLWalletHomePage.objRecentTransactions,"Header"))){
            verifyElementPresent(MLWalletShopItemsPage.objMLShopTransaction,(getAttributValue("name",MLWalletShopItemsPage.objMLShopTransaction)+" Transaction"));
            logger.info("SI_TC_180, Shop Items, ML Shop Recent transaction validated");
            extentLoggerPass("SI_TC_180", "SI_TC_180, Shop Items, ML Shop Recent transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsReviewingItemDetailsAndFeeBeforePlacingTheOrder_SI_TC_69() throws Exception {
        HeaderChildNode("Shop items, Reviewing item details and fee Before Placing the order");
        waitTime(2000);
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        deleteItemsInCart();
        hamburgerMenuNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop,getTextVal(MLWalletShopItemsPage.objShop,"Link"));
        selectItemAndAddToCart("Rings");
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn,"Button"));
        Swipe("UP", 3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectBranch,getTextVal(MLWalletShopItemsPage.objSelectBranch,"DropDown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBranch,getTextVal(MLWalletShopItemsPage.objBranch,"Option"));
        Swipe("UP",1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod("ML WALLET"),"Payment method"));
        Swipe("UP",1);
        String sMerchandiseTotal = getText(MLWalletShopItemsPage.getAmountValue("Merchandise Total"));
        sMerchandiseTotal = sMerchandiseTotal.substring(1,sMerchandiseTotal.length());
        if(sMerchandiseTotal.contains(",")){
            sMerchandiseTotal = sMerchandiseTotal.replace(",","");
        }
        float fMerchandiseTotal = Float.parseFloat(sMerchandiseTotal);
        String sServiceTotal = getText(MLWalletShopItemsPage.getAmountValue("Service Total"));
        sServiceTotal = sServiceTotal.substring(1,sServiceTotal.length());
        if(sServiceTotal.contains(",")){
            sServiceTotal = sServiceTotal.replace(",","");
        }
        float fServiceTotal = Float.parseFloat(sServiceTotal);
        String sShippingTotal = getText(MLWalletShopItemsPage.getAmountValue("Shipping Total"));
        sShippingTotal = sShippingTotal.substring(1,sShippingTotal.length());
        if(sShippingTotal.contains(",")){
            sShippingTotal = sShippingTotal.replace(",","");
        }
        float fShippingTotal = Float.parseFloat(sShippingTotal);
        String sTotalPayment = getText(MLWalletShopItemsPage.getAmountValue("Total Payment"));
        sTotalPayment = sTotalPayment.substring(1,sTotalPayment.length());
        if(sTotalPayment.contains(",")){
            sTotalPayment = sTotalPayment.replace(",","");
        }
        float fTotalPayment = Float.parseFloat(sTotalPayment);
        logger.info("Merchandise Total : "+fMerchandiseTotal);
        extentLogger("","Merchandise Total : "+fMerchandiseTotal);
        logger.info("Service Total : "+fServiceTotal);
        extentLogger("","Service Total : "+fServiceTotal);
        logger.info("Shipping Total : "+sShippingTotal);
        extentLogger("","Shipping Total : "+sShippingTotal);
        logger.info("Total Payment : "+sTotalPayment);
        extentLogger("","Total Payment : "+sTotalPayment);

        float fTotalExceptedPayment = fMerchandiseTotal+fServiceTotal+fShippingTotal;
        logger.info("Total Payment By calculating Merchandise Total, Service Total and Shipping Total : "+fTotalExceptedPayment);
        extentLogger("","Total Payment By calculating Merchandise Total, Service Total and Shipping Total : "+fTotalExceptedPayment);
        assertionValidation(fTotalPayment,fTotalExceptedPayment);
        if(fTotalPayment==fTotalExceptedPayment){
            logger.info("SI_TC_69, Shop items, Reviewed item details and fee Before Placing the order");
            extentLoggerPass("SI_TC_69", "SI_TC_69,Shop items, Reviewed item details and fee Before Placing the order");
            System.out.println("-----------------------------------------------------------");
        }
    }


















}
