package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletTopUpGames {


    public static By objTopUpGames = By.xpath("//*[@label='Top up\n" +
            " Games']");
    public static By objTopGamesPage = By.xpath("(//XCUIElementTypeOther[@name=\"\uE5CB\"])[3]/XCUIElementTypeOther[1]");
    public static By objGames(int i){
        return By.xpath("(//*[@name='Steam Wa ... Mobile L ... Valorant ']/child::XCUIElementTypeOther/child::XCUIElementTypeOther)["+i+"]");
    }

    public static By objGames1(int j){
        return By.xpath("(//*[@name='Diablo I ... Razer Go ... More Gam ...']/child::XCUIElementTypeOther/child::XCUIElementTypeOther)["+j+"]");
    }
    public static By objValorant = By.xpath("(//*[@name='Valorant '])[2]");
    public static By objBuyPHP149 = By.xpath("(//*[@name='Buy PHP 149 ValorantPoints375 (PHP149)'])[2]");
    public static By objGameUserID = By.xpath("//*[@name='Game User ID']/XCUIElementTypeTextField");
    public static By objEmailAddress = By.xpath("//*[@name='example@gmail.com']/XCUIElementTypeTextField");
    public static By objMobileNumber = By.xpath("//*[@name='09xx xxxx xxx']/XCUIElementTypeTextField");
    public static By objContinue = By.xpath("(//*[@name='Continue'])[2]");
    public static By objConfirm = By.xpath("(//*[@name='Confirm'])[2]");
    public static By objTransactionDetails = By.xpath("//*[@name='Transaction Details']");
    public static By objTransactionCode = By.xpath("(//*[@name='Transaction Code'])[3]");
    public static By objGameUserIDInTransactionDetails = By.xpath("(//*[@name='Game User ID'])[3]");
    public static By objMobileNumberInTransactionDetails = By.xpath("(//*[@name='Mobile Number'])[3]");
    public static By objEmailInTransactionDetails = By.xpath("(//*[@name='Email'])[3]");
    public static By objAmountInTransactionDetails = By.xpath("(//*[@name='Amount'])[4]");
    public static By objRedeemCode = By.xpath("(//*[@name='Redeem Code'])[3]");



    public static By objAvailableBalance = By.xpath("//*[@name='UTJ9TN']");
    public static By objBackToHome = By.xpath("//*[@name='Back To Home']");



    public static By objGameIDRequiredMsg = By.xpath("(//*[@name='Game User ID']/following-sibling::XCUIElementTypeStaticText)[1]");
    public static By objEmailRequiredMsg = By.xpath("(//*[@name='*Email Addresses']/following-sibling::XCUIElementTypeStaticText)[1]");
    public static By objEmailAddressInvalidMsg = By.xpath("(//*[@name='*Email Addresses']/following-sibling::XCUIElementTypeStaticText)[1]");
    public static By objMobileNumberInvalidMsg = By.xpath("(//*[@name='*Mobile Number']/following-sibling::XCUIElementTypeStaticText)[1]");
    public static By objMobileNumberRequiredMsg = By.xpath("(//*[@name='*Mobile Number']/following-sibling::XCUIElementTypeStaticText)[1]");
    public static By objSaveToMyFavorite = By.xpath("//*[@name='Save to my favorite']");
    public static By objAddToFavoritesMsg = By.xpath("//*[@name='Successfully Added to Favorites']");
    public static By objDuplicateFavorites = By.xpath("//*[@name='Recipient already exists.']");
    public static By objOkButton = By.xpath("(//*[@name='Ok'])[2]");
    public static By objMyFavorites = By.xpath("//*[@name='\uE838 My Favorites']");
    public static By objFavoriteRecipient = By.xpath("(//*[@name='VALORANT 09999999996 email@gmail.com \uF182'])[4]");
    public static By objSearchFavField = By.xpath("(//*[@name='Search Favorites'])[3]/XCUIElementTypeTextField");



//    public static By objLoadType(int i){
//        return By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.view.ViewGroup' and ./*[@text] and ./*[@class='android.view.ViewGroup']])["+i+"]");
//    }

    public static By objLoadTypeAndPoints(int i){
        return By.xpath("(//*[@type='XCUIElementTypeScrollView']/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther)["+i+"]");
    }

    public static By objHamburgerMenu = By.xpath("//*[@name='Vertical scroll bar, 1 page']");
    public static By objRemoveBtn = By.xpath("//*[@name='Remove']");
    public static By objTopUpAgainBtn = By.xpath("//*[@name='Top Up Again']");
    public static By objTopUpGamesBtn = By.xpath("//*[@name='Top Up Games']");


    public static By objTopUpGamesTransaction = By.xpath("//*[@name='OSJVNX']/XCUIElementTypeScrollView/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther");

    public static By objMLPinEditField = By.xpath("(//*[@name='Horizontal scroll bar, 1 page'])[1]");


}
