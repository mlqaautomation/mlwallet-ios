package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletShopItemsPage {

//	Shop Items Tab
	public static By objShopItemsTab=By.xpath("//*[@name='R80OMI']");
//	Successfully Login Popup
	public static By objSuccessfullyLogin = By.xpath("//XCUIElementTypeStaticText[@name='Successfully Login']");
//	Okay Button
	public static By objOkayBtn = By.xpath("//*[@name='Okay']");
//	Shop Items Complete Page
	public static By objMLShopPage=By.xpath("//*[@name='ML Shop']");
//	Rings Icon
	public static By objItemMenu(String sItem){
		return By.xpath("(//*[@name='"+sItem+"'])[1]");
	}
//	Necklace Icon
	public static By objNecklace = By.xpath("(//*[@name='Necklace'])[1]");
//	Ring Item displayed
	public static By objSelectItem=By.xpath("(//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]");
//	20k Ring
	public static By obj10KRing = By.xpath("//XCUIElementTypeStaticText[@name=\"₱10,000.00\"]");
	public static By obj500Ring = By.xpath("//XCUIElementTypeStaticText[@name=\"₱524.25\"]");

	public static By obj20KRing = By.xpath("//XCUIElementTypeStaticText[@name=\"₱20,000.00\"]");
	public static By objAmount(String sAmount){
		return By.xpath("//XCUIElementTypeStaticText[@name='₱"+sAmount+"']");
	}

//Select item watch
	public static By objFirstWatchItem = By.xpath("(//XCUIElementTypeImage[@name='image'])[1]");
//	Add to Cart button
	public static By objAddToCartBtn=By.xpath("//*[@name='Add To Cart']");
//	Item confirmation popup
	public static By objItemConfirmationPopup = By.xpath("//XCUIElementTypeStaticText[contains(@label,'item') or contains(@label,'Item')]");
//	Confirm Button
	public static By objConfirmBtn = By.xpath("//*[@name='Confirm']");
// 	Cart icon
	public static By objCartIcon = By.xpath("(//*[@name='Enjoy up to 50% Discount on Selected Items']/following-sibling::XCUIElementTypeLink)[1]");
//	CheckOut Btn
	public static By objCheckOutBtn=By.xpath("//*[@name='Checkout']");
//	Items not selected msg
	public static By objItemNotSelectedMsg = By.xpath("//XCUIElementTypeStaticText[@name='You have not selected any items for checkout.']");
//	Select Branch Field
	public static By objSelectBranch =By.xpath("(//*[@name='Branch Name']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]");
//	ML NRA
	public static By objMLNRABranch = By.xpath("//XCUIElementTypeButton[@name=\"ML NRA\"]");
//	CEBU head Office
	public static By objBranch = By.xpath("//*[@name='Select Branch']/parent::XCUIElementTypeCell/following-sibling::XCUIElementTypeCell");
//	Select Payment Method
	public static By objSelectPaymentMethodTxt = By.xpath("//*[@name='Select Payment Method']");
//	ML Wallet Option
	public static By objMLWallet = By.xpath("//*[@name='ML WALLET']");
//	Place order btn
	public static By objPlaceOrderBtn = By.xpath("//*[@name='Place Order']");
//	Place order confirmation popup
	public static By objPlaceOrderConfirmationPopup = By.xpath("(//*[@name='Proceed']/preceding-sibling::XCUIElementTypeOther)[1]/child::XCUIElementTypeStaticText");
	public static By objPaymongoPlaceOrderConfirmationPopup = By.xpath("//*[@name='Proceed']/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");

	public static By objPaymongoPlaceOrderConfirmationPopup(int i){
		return By.xpath("(//*[@name='Proceed']/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+i+"]");
	}
	//	Proceed Btn
	public static By objProceed = By.xpath("//*[@name='Proceed']");
//	One Time pin popup
	public static By objOneTimePin = By.xpath("//*[@name='One Time Pin']");
//	OTP input field
	public static By objOTPInputField = By.xpath("(//*[@type='XCUIElementTypeTextField'])[1]");
//	Successfully Login Popup
	public static By objOrderSuccessfully = By.xpath("//XCUIElementTypeStaticText[@name=\"Successfully checkout items. Thank you!\"]");
//	Insufficient Balance Error msg
	public static By objInsufficientBalanceMsg = By.xpath("//*[@name='Top up now']/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	Top up now button
	public static By objTopUpNow = By.xpath("//*[@name='Top up now']");
//	Close button
	public static By objClose = By.xpath("//*[@name='Close']");
//	Discount banner
	public static By objDiscountBanner = By.xpath("//XCUIElementTypeStaticText[@name='Enjoy up to 50% Discount on Selected Items']");
//	Items header
	public static By objItemsHeader = By.xpath("//XCUIElementTypeStaticText[@name='GREAT SUMMER SALE']");
//	Ring Item
	public static By objRingItem = By.xpath("//XCUIElementTypeStaticText[@name='Rings']");
//	Necklaces and Pendants
	public static By objNecklacesAndPendants = By.xpath("//XCUIElementTypeStaticText[@name='Necklaces & Pendants']");
//	Bracelets & Bangles
	public static By objBraceletsAndBangles = By.xpath("//XCUIElementTypeStaticText[@name='Bracelets & Bangles']");
//	Earrings
	public static By objEarrings = By.xpath("//XCUIElementTypeStaticText[@name='Earrings']");
//	Watch Items Header
	public static By objWatchItemsHeader = By.xpath("//XCUIElementTypeStaticText[@name='Great Deals for Fine Watches']");
//	Shop Header
	public static By objShopHeader = By.xpath("(//XCUIElementTypeStaticText[@name='Shop'])[2]");
//	Customer care header
	public static By objCustomerCareHeader = By.xpath("//XCUIElementTypeStaticText[@name='Customer Care']");
//	Contact us
	public static By objContactUs = By.xpath("//XCUIElementTypeStaticText[@name='Contact Us']");
//	Item displayed
	public static By objRingItemsDisplayed= By.xpath("//XCUIElementTypeStaticText[contains(@name,' Ring')]");
//	Necklaces And Pendants
	public static By objNecklacesAndPendantsItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Necklace')]");
//	Bracelet & Bangle
	public static By objBraceletAndBangleItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Bracelet & Bangle')]");
//	Earrings
	public static By objEarringsItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Earrings')]");
//
	public static By objPendantItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Pendant')]");
//
	public static By objTernoAndSetItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Terno & Set')]");
//
	public static By objBroochItemsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Brooch')]");
//	10K displayed items
	public static By obj10KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 10k')]");
	//	14K displayed items
	public static By obj14KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 14k')]");
	//	18K displayed items
	public static By obj18KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 18k')]");
//	20K displayed items
	public static By obj20KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 20k')]");
//	21k displayed items
	public static By obj21KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 21k')]");
//	22k displayed items
	public static By obj22KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 22k')]");
//	12k displayed items
	public static By obj12KMaterialDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 12k') or contains(@label,'12k ')]");
//	Yellow Gold Material color
	public static By objYellowGoldMaterialColor = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Yellow Gold')]");
//	White Gold Material color
	public static By objWhiteGoldMaterialColor = By.xpath("//XCUIElementTypeStaticText[contains(@label,' White Gold')]");
//	Rose Gold Material color
	public static By objRoseGoldMaterialColor = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Rose Gold')]");
//	Two Tone Material color
	public static By objTwoToneMaterialColor = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Two - Tone')]");
//	Tri Tone material color
	public static By objTriToneMaterialColor = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Tri - Tone')]");
//	Ladies Gender
	public static By objLadiesGender = By.xpath("//XCUIElementTypeStaticText[contains(@label,'Ladies ')]");
//	Mens Gender
	public static By objMensGender = By.xpath("//XCUIElementTypeStaticText[contains(@label,'Mens ')]");
//	Unisex
	public static By objUnisex = By.xpath("//XCUIElementTypeStaticText[contains(@label,'Unisex ')]");
	public static By objWatchImage = By.xpath("//XCUIElementTypeImage[@name='image']");
//	Watch names
	public static By objWatchItemName(int i){
		return By.xpath("((//XCUIElementTypeImage[@name='image'])["+i+"]/following-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText)[1]");
	}

	//	10K product displayed
	public static By obj10KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 10k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
	//	14K product displayed
	public static By obj14KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 14k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
	//	18K product displayed
	public static By obj18KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 18k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	20K product displayed
	public static By obj20KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 20k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	21K product displayed
	public static By obj21KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 21k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	22K product displayed
	public static By obj22KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 22k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	21K product displayed
	public static By obj12KProductsDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' 12k')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Yellow Gold Product displayed
	public static By objYellowProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Yellow Gold')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	White Gold Product displayed
	public static By objWhiteProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' White Gold')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Rose Gold Product displayed
	public static By objRoseProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Rose Gold')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Two-tone product displayed
	public static By objTwoToneProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Two - Tone')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Tri-tone product displayed
	public static By objTriToneProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,' Tri - Tone')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Ladies product displayed
	public static By objLadiesProductDisplayed = By.xpath("//XCUIElementTypeStaticText[contains(@label,'Ladies ')]/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");



//		Watch items displayed
	public static By objWatchItemsDisplayed = By.xpath("//XCUIElementTypeImage[@name='image']");
//	first watch item
	public static By objWatchItem = By.xpath("(//XCUIElementTypeOther[@name='Great Deals for Fine Watches']/following-sibling::XCUIElementTypeLink)[1]");
//	LogOut Btn
	public static By objLogoutBtn = By.xpath("//XCUIElementTypeStaticText[@name='Logout']");
//
	public static By objHamburgerMenuItems(int sHamburgerMenuItems){
		return By.xpath("((//XCUIElementTypeLink[@name='1'])[1]/following-sibling::XCUIElementTypeLink/child::XCUIElementTypeLink/child::XCUIElementTypeStaticText)["+sHamburgerMenuItems+"]");
	}
//
	public static By objProductNameInSelectedPage = By.xpath("(//*[@name='Material']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther)[3]/child::XCUIElementTypeStaticText");
//	Watch product name
	public static By objWatchProductAfterSelection = By.xpath("(//*[@name='Material']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther)[3]");
//
	public static By objProductInfo(String sInfoText){
		return By.xpath("(//*[@name='"+sInfoText+"']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[2]/child::XCUIElementTypeStaticText");
	}
//	Discount percentage
	public static By objSavePercentage = By.xpath("(//XCUIElementTypeStaticText[@name='Save']/following-sibling::XCUIElementTypeStaticText)[1]");
//	Discount Amount
	public static By objDiscountAmount = By.xpath("(//XCUIElementTypeStaticText[@name='Save']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]/child::XCUIElementTypeStaticText");
//	Actual Amount
	public static By objActualAmount = By.xpath("((//XCUIElementTypeStaticText[@name='Save']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[2]/child::XCUIElementTypeStaticText)[2]");


//	Select payment method
	public static By objSelectPaymentMethod(String sText){
		return By.xpath("//*[@name='"+sText+"']");
	}
	public static By getAmountValue(String sProductCharges){
		return By.xpath("(//XCUIElementTypeStaticText[@name='"+sProductCharges+"']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[2]/child::XCUIElementTypeStaticText");
	}
//	Product check box
	public static By objProductCheckBox = By.xpath("//*[@type='XCUIElementTypeSwitch']");
//	Please select payment method
	public static By objPaymentMethodErrorMsg = By.xpath("//*[@name='Please Select Payment Method']");
//	ML SHOP Shopping Type
	public static By objShoppingTypeHeader = By.xpath("(//XCUIElementTypeOther[@name='Shopping Cart']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Product Name in Cart
	public static By objCartProductName = By.xpath("(//*[@type='XCUIElementTypeSwitch']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Product Number in Cart
	public static By objProductNumber = By.xpath("(//*[@type='XCUIElementTypeSwitch']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[2]");
//	Product Description in cart
	public static By objCartProductDescription = By.xpath("(//*[@type='XCUIElementTypeSwitch']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[3]");
//	Product price in cart
	public static By objCartProductPrice = By.xpath("(//*[@type='XCUIElementTypeSwitch']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[4]");
//	Shopping cart header
	public static By objShoppingCart = By.xpath("(//XCUIElementTypeStaticText[@name='Shopping Cart'])[1]");
//	delete btn
	public static By objDeleteBtn = By.xpath("(//*[@type='XCUIElementTypeButton'])[2]");
//	Delete Buttons
	public static By objDeleteButtons = By.xpath("//*[@type='XCUIElementTypeButton']");
//	Delete buttons
	public static By objDeleteButtons(int i){
		return By.xpath("(//*[@type='XCUIElementTypeButton'])["+i+"]");
	}
//	Delete confirmation popup
	public static By objDeleteConfirmationPopup = By.xpath("//XCUIElementTypeStaticText[@name='Are you sure to remove this item?']");
//	Yes button
	public static By objYesBtn = By.xpath("//XCUIElementTypeButton[@name='Yes']");
//	First Item in cart
	public static By objDeleteItemAdded(String sProductName){
		return By.xpath("(//XCUIElementTypeStaticText[@name='"+sProductName+"']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton)[1]");
	}
//	Selected item checkBox
	public static By objSelectedItemCheckBox(String sProductName){
		return By.xpath("//XCUIElementTypeStaticText[@name='"+sProductName+"']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch");
	}
//	Check box
	public static By objCheckBox(int i){
		return By.xpath("(//*[@type='XCUIElementTypeSwitch'])["+i+"]");
	}
	public static By objCheckBox = By.xpath("//*[@type='XCUIElementTypeSwitch']");
//	Auto checked check box
	public static By objAutoCheckedCheckBoxes = By.xpath("//*[@type='XCUIElementTypeSwitch' and @value='1']");

	//	Empty cart msg
	public static By objEmptyCartMsg = By.xpath("//XCUIElementTypeStaticText[@name='Your Cart is Empty!']");
//	About Link
	public static By objAboutLink = By.xpath("//XCUIElementTypeStaticText[@name='About']");
//	Cart Link
	public static By objCartLink = By.xpath("//XCUIElementTypeStaticText[@name='Cart']");
//	Profile Link
	public static By objProfileLink = By.xpath("//XCUIElementTypeStaticText[@name='Profile']");
//
	public static By objPurchaseHistory = By.xpath("//XCUIElementTypeStaticText[@name='Purchase History']");
//	Jewelry page
	public static By objJewelryPage = By.xpath("//XCUIElementTypeStaticText[@name='Jewelry']");
//	Contact
	public static By objContact = By.xpath("//XCUIElementTypeStaticText[@name='Contact']");
//	Customer
	public static By objCustomer = By.xpath("//XCUIElementTypeStaticText[@name='Customer']");
//	Customer numbers
	public static By objCustomerNumber = By.xpath("(//XCUIElementTypeOther[@name='Customer']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Call via web
	public static By objCallViaWeb = By.xpath("//XCUIElementTypeStaticText[@name='Call via Web']");
//	Call Customer service
	public static By objCallCustomerService = By.xpath("//XCUIElementTypeButton[@name='Call Customer Service']");
//	USA
	public static By objUSA = By.xpath("//XCUIElementTypeStaticText[@name='USA']");
//	USA Mobile number
	public static By objUSANumber = By.xpath("(//XCUIElementTypeOther[@name='USA']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeLink/child::XCUIElementTypeStaticText)[1]");
//	Email header
	public static By objEmailHeader = By.xpath("//XCUIElementTypeStaticText[@name='Email']");
//	Email
	public static By objEmail = By.xpath("(//XCUIElementTypeOther[@name='Email']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeLink/child::XCUIElementTypeStaticText)[1]");
//	Select item Product name
	public static By objSelectItemPageProductName = By.xpath("((//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]/child::XCUIElementTypeLink/child::XCUIElementTypeStaticText)[1]");
//	Select item Product description
	public static By objSelectItemProductDescription = By.xpath("((//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]/child::XCUIElementTypeLink)[2]");
//	Select item product discount
	public static By objSelectItemProductDiscount = By.xpath("((//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]/child::XCUIElementTypeLink)[3]");
//	Select item Product price
	public static By objSelectItemDiscountProductPrice = By.xpath("((//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]/child::XCUIElementTypeLink)[4]");
//	Select item actual product price
	public static By objSelectItemActualProductPrice = By.xpath("((//*[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeLink)[1]/child::XCUIElementTypeLink)[5]");
// 	Item types
	public static By objItemTypes(int sItemType) {
		return By.xpath("(//XCUIElementTypeStaticText[@name='Type']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+sItemType+"]");
	}
//	Filter Button
	public static By objFilterBtn = By.xpath("//XCUIElementTypeStaticText[@name='Filter']");
//	Category
	public static By objCategory = By.xpath("//XCUIElementTypeStaticText[@name='C A T E G O R Y']");
//	Type header
	public static By objTypeHeader = By.xpath("//XCUIElementTypeStaticText[@name='Type']");
//  Gender Header
	public static By objGenderHeader = By.xpath("//XCUIElementTypeStaticText[@name='Gender']");
//	Gender types
	public static By objGenderTypes(int sGenderType){
		return By.xpath("(//XCUIElementTypeStaticText[@name='Gender']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+sGenderType+"]");
	}
//	Material color header
	public static By objMaterialColor = By.xpath("//XCUIElementTypeStaticText[@name='Material Color']");
//	Material color types
	public static By objMaterialColorTypes(int sMaterialColorTypes){
		return By.xpath("(//XCUIElementTypeStaticText[@name='Material Color']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+sMaterialColorTypes+"]");
	}
//	Material Header
	public static By objMaterialHeader = By.xpath("//XCUIElementTypeStaticText[@name='Material']");
//	Material Color Header
	public static By objMaterialColorHeader = By.xpath("//XCUIElementTypeStaticText[@name='Material Color']");
//	Gender Header
//	Material types
	public static By objMaterialTypes(int sMaterialTypes){
		return By.xpath("(//XCUIElementTypeStaticText[@name='Material']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+sMaterialTypes+"]");
	}
//	Sort by price dropdown
	public static By objSortByPriceDropdown = By.xpath("(//XCUIElementTypeStaticText[@name='Sort by: Price']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]");
//	Sort By price header
	public static By objSortByPriceHeader = By.xpath("//XCUIElementTypeStaticText[@name='Sort by: Price']");
//	Sort By price dropdown elements
	public static By objSortByPriceTypes = By.xpath("//*[@type='XCUIElementTypeCell']/child::XCUIElementTypeButton");
//	Full name in profile page
	public static By objFullNameInProfilePage = By.xpath("(//XCUIElementTypeOther[@name='Full Name']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Email Address in Profile
	public static By objEmailAddressInProfilePage = By.xpath("(//XCUIElementTypeOther[@name='Email Address']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Mobile Number in Profile page
	public static By objMobileNumberInProfilePage = By.xpath("(//XCUIElementTypeOther[@name='Mobile No.']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Profile Name
	public static By objProfileName = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[3]");
//	Order Details
	public static By objOrderDetails = By.xpath("(//XCUIElementTypeButton[@name='Order Details'])[1]");
//  Login Link
	public static By objLoginLink = By.xpath("//XCUIElementTypeStaticText[@name='Login']");
//	Mobile number input field
	public static By objMobileNumberInputField = By.xpath("//XCUIElementTypeButton[@name='Login']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//	Login Button
	public static By objLoginBtn = By.xpath("//XCUIElementTypeButton[@name='Login']");
//	Filter check
	public static By objFilterCheckBox = By.xpath("//XCUIElementTypeStaticText[@name=\"Type\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch");
//	Checked Product tye
	public static By objCheckBoxProductType = By.xpath("//XCUIElementTypeStaticText[@name='Type']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch");
//
	public static By objProductTypeSelectedCheckBox = By.xpath("((//*[@type='XCUIElementTypeSwitch' and @value='1'])[1]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
//	Selected Product type
	public static By objSelectedProductType = By.xpath("(//*[@type='XCUIElementTypeSwitch' and @value='1'])[1]");
//	Rings check box
	public static By objRingsCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Ring']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[2]");
//	Necklace Check box
	public static By objNecklaceCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Necklace']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[3]");
//
	public static By ObjBraceletsAndBanglesCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Bracelet & Bangle']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[4]");
//
	public static By ObjEarringsCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Earrings']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[5]");
//
	public static By ObjPendantCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Pendant']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[6]");
//
	public static By objTernoAndSetCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Terno & Set']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[7]");
//
	public static By objBroochCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Brooch']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[8]");
//	 Material check boxes
	public static By objMaterialCheckBoxes(int nNumber) {
		return By.xpath("(//XCUIElementTypeStaticText[@name='Material']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch)["+nNumber+"]");
	}
//	Material color check boxes
	public static By objMaterialColorCheckBoxes(int nNumber) {
		return By.xpath("(//XCUIElementTypeStaticText[@name='Material Color']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch)["+nNumber+"]");
	}
//	Gender check boxes
	public static By objGenderCheckBoxes(int nNumber) {
		return By.xpath("(//XCUIElementTypeStaticText[@name='Gender']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch)["+nNumber+"]");
	}
//	10K check box
	public static By obj10KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='10k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[9]");
//	14K check box
	public static By obj14KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='14k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[10]");
//	14K check box
	public static By obj18KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='18k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[11]");
//	20K Check Box
	public static By obj20KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='20k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[12]");
//	21K Check box
	public static By obj21KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='21k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[13]");
//	22k Check box
	public static By obj22KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='22k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[14]");
//	12k check box
	public static By obj12KCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='12k']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[15]");
//	Yellow Gold check Box
	public static By objYellowGoldCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Yellow Gold']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[16]");
//	White Gold check Box
	public static By objWhiteGoldCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='White Gold']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[17]");
//	Rose Gold Check Box
	public static By objRoseGoldCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Rose Gold']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[18]");
//	No products found Msg
	public static By objNoProductsFoundMsg = By.xpath("//XCUIElementTypeStaticText[@name='No Products Found!']");
//	Two - Tone Check Box
	public static By objTwoToneCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Two - Tone']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[19]");
//	Tri - Tone Check Box
	public static By objTriToneCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Tri - Tone']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[20]");
//	Ladies gender check box
	public static By objLadiesCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Ladies']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[21]");
//	Mens gender check box
	public static By objMensCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Mens']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[22]");
//	Unisex check box
	public static By  objUniSexCheckBox = By.xpath("(//XCUIElementTypeStaticText[@name='Unisex']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeSwitch)[23]");
//	PPrice range
	public static By objPriceRangeHeader = By.xpath("//XCUIElementTypeStaticText[@name='Price Range']");
//	Min value input field
	public static By objMinInputField = By.xpath("(//*[@type='XCUIElementTypeTextField'])[1]");
//	Max value input field
	public static By objMaxInputField = By.xpath("//XCUIElementTypeStaticText[@name='Max']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField");
//	Filer btn
	public static By objPopupFilterBtn = By.xpath("//XCUIElementTypeButton[@name='Filter']");
//	Amount displayed
	public static By objAmountDisplayed = By.xpath("//XCUIElementTypeStaticText[@name='Save']/parent::XCUIElementTypeLink/following-sibling::XCUIElementTypeLink");
//	Product displayed
	public static By objProductDisplayedAfterFilter = By.xpath("//XCUIElementTypeStaticText[@name='Save']/parent::XCUIElementTypeLink/preceding-sibling::XCUIElementTypeLink/child::XCUIElementTypeStaticText");
//	Cart items
	public static By objCartItems = By.xpath("(//XCUIElementTypeOther[@name='Enjoy up to 50% Discount on Selected Items']/following-sibling::XCUIElementTypeLink/child::XCUIElementTypeLink/child::XCUIElementTypeStaticText)[1]");
//	item description
	public static By objItemDescription = By.xpath("//XCUIElementTypeOther[@name='ML Shop Jewelry Store']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	MatchingItem
	public static By objMatchingItem(String itemSelected) {
		return By.xpath("//*[contains(@name,'"+itemSelected+"')]");
	}
//	Account Information
	public static By objAccountInformation = By.xpath("//XCUIElementTypeStaticText[@name='Account Information']");
//	Service fee
	public static By objServiceTotal = By.xpath("(//XCUIElementTypeStaticText[@name='Service Total']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[2]");
// 	Shop link
	public static By objShop = By.xpath("//XCUIElementTypeStaticText[@name='Shop']");
// 	Items displayed under appropriate labels
	public static By objItemDisplayedUnderAppropriateLabels(String sLabels){
		return By.xpath("((//XCUIElementTypeStaticText[@name='"+sLabels+"']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther)[2]/child::XCUIElementTypeOther)[1]/child::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
	}
//	ML Shop Jewelry Store
	public static By objMLShopJewelryStore = By.xpath("//XCUIElementTypeStaticText[@name='ML Shop Jewelry Store']");
//	ML Watches
	public static By objMLWatches = By.xpath("//XCUIElementTypeStaticText[@name='ML Watches']");
//	Product price displayed
	public static By objProductPriceInPlaceOrder = By.xpath("//XCUIElementTypeStaticText[@name='1']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	Product price displayed
	public static By objProductPriceInPlaceOrder(int i){
		return By.xpath("(//XCUIElementTypeStaticText[@name='1']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+i+"]");
	}
//	Subtotal order
	public static By objSubTotalOrder = By.xpath("(//XCUIElementTypeStaticText[@name='SubTotal Order']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[2]");
//	Pick up branch state
	public static By objPickupBranchState = By.xpath("((//XCUIElementTypeStaticText[@name='Province/State'])[2]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]/child::XCUIElementTypeOther");
//	Account information state displayed
	public static By objAccInfoStateDisplayed = By.xpath("((//XCUIElementTypeStaticText[@name='Province/State'])[1]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]/child::XCUIElementTypeOther");
//	Account information city displayed
	public static By objAccInfoCityDisplayed = By.xpath("((//XCUIElementTypeStaticText[@name='City/Town'])[1]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther)[1]");
//
	public static By objCountry = By.xpath("(//XCUIElementTypeStaticText[@name=\"Country\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther)[1]");
//	Pick up Province
	public static By objSelectPickupProvince = By.xpath("((//*[@name='Province/State'])[2]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther)[1]");
//	pick up city
	public static By objSelectPickupCity = By.xpath("((//*[@name='City/Town'])[2]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther)[1]");

	//	Province
	public static By objProvince(String sProvince) {
		return By.xpath("//XCUIElementTypeButton[@name='"+sProvince+"']");
	}
//	City
	public static By objCity(String sCity) {
		return By.xpath("//XCUIElementTypeButton[@name='"+sCity+"']");
	}
//	Branch
	public static By objBranch(String sBranch){
		return By.xpath("//XCUIElementTypeButton[@name='"+sBranch+"']");
	}
//	Collections
	public static By objCollections = By.xpath("//*[@type='XCUIElementTypeCollectionView']/child::XCUIElementTypeCell/child::XCUIElementTypeButton");
	public static By objCollections(int i) {
		return By.xpath("(//*[@type='XCUIElementTypeCollectionView']/child::XCUIElementTypeCell/child::XCUIElementTypeButton)["+i+"]");
	}

	//	Branch Address
	public static By objBranchAddress = By.xpath("//XCUIElementTypeStaticText[@name='Branch Address:']/following-sibling::XCUIElementTypeStaticText");

//	Firstname is required
	public static By objFirstNameRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='Firstname is required']");
//	Lastname is Required
	public static By objLastNameRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='Lastname is Required']");
//	Email is Required
	public static By objEmailRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='Email is Required']");
//	Street is Required
	public static By objStreetRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='Street is Required']");
//	Province is Required
	public static By objProvinceRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='Province is Required']");
//	City is Required
	public static By objCityRequiredMsg = By.xpath("//XCUIElementTypeStaticText[@name='City is Required']");
//	ML Shop back arrow btn
	public static By objBackArrowBtn=By.xpath("//XCUIElementTypeOther[@name=\"\uE5CB\"]");
//	Product name in  cart
	public static By objProductNameInCartPage = By.xpath("(//*[@type='XCUIElementTypeSwitch']/following-sibling::XCUIElementTypeOther)[2]/child::XCUIElementTypeStaticText");
// 	payment amount displayed in paymongo page
	public static By objPaymentAmountInPaymongoPage = By.xpath("//XCUIElementTypeOther[@name='Payment amount']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
// 	payment amount displayed in paymongo page
	public static By objSelectedPaymentMethodInPaymongoPage = By.xpath("(//*[@type='XCUIElementTypeImage'])[2]/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	ref number displayed in paymongo page
	public static By objRefNumberInPaymongoPage = By.xpath("//XCUIElementTypeStaticText[@name='Ref #']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	BPI Payment method in paymongo page
	public static By objBPIPaymentMethod = By.xpath("(//XCUIElementTypeStaticText[@name='BPI Online'])[2]");
//	PAYMANGO CHECK BOX
	public static By objPaymongoCheckBox = By.xpath("//*[@type='XCUIElementTypeSwitch']");
//	Complete payment
	public static By objCompletePayment = By.xpath("//XCUIElementTypeButton[@name='Complete payment']");
//	Authorize Test Payment
	public static By objAuthorizeTestPayment = By.xpath("//XCUIElementTypeButton[@name='Authorize Test Payment']");
//	Maya payment received
	public static By objMayaPaymentReceived = By.xpath("//XCUIElementTypeStaticText[@name='payment received!']");
//	Continue btn
	public static By objContinue = By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]");
//	Elements displayed per page
	public static By objItemsDisplayedPerPage = By.xpath("//XCUIElementTypeStaticText[contains(@name,' Ring') or contains(@name,' Necklace') or contains(@name,' Bracelet & Bangle') or contains(@name,' Earrings') or contains(@name,' Pendant') or contains(@name,' Terno & Set') or contains(@name,' Brooch')]");
//	Name displayed in order details
	public static By objOrderDetailsName = By.xpath("(//XCUIElementTypeOther[@name=\"Name:\"]/following-sibling::XCUIElementTypeStaticText)[1]");
//	Mobile number displayed in order details
	public static By objOrderDetailsMobileNumber = By.xpath("(//XCUIElementTypeOther[@name=\"Mobile Number:\"]/following-sibling::XCUIElementTypeStaticText)[1]");
//	Max transaction msg
	public static By objMaxTransactionMsg = By.xpath("//XCUIElementTypeButton[@name='Confirm']/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
	public static By objCancelBtn = By.xpath("//XCUIElementTypeButton[@name='Cancel']");
//	Watch one
	public static By objWatchOne = By.xpath("(//XCUIElementTypeOther[@name='Great Deals for Fine Watches']/following-sibling::XCUIElementTypeLink)[1]");
//	Watch two
	public static By objWatchTwo = By.xpath("(//XCUIElementTypeOther[@name='Great Deals for Fine Watches']/following-sibling::XCUIElementTypeLink)[2]");
//	Watch three
	public static By objWatchThree = By.xpath("(//XCUIElementTypeOther[@name='Great Deals for Fine Watches']/following-sibling::XCUIElementTypeLink)[3]");
//	Watch four
	public static By objWatchFour = By.xpath("(//XCUIElementTypeOther[@name='Great Deals for Fine Watches']/following-sibling::XCUIElementTypeLink)[4]");
//	QR page header
	public static By objQRPageHeader = By.xpath("//XCUIElementTypeStaticText[@name='To use ML Wallet on your computer:']");
//	Steps to use ML Wallet on your computer
	public static By objStepsToUseMLWallet(int i){
		return By.xpath("(//XCUIElementTypeStaticText[@name=\"To use ML Wallet on your computer:\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)["+i+"]");
	}
//	Terms & Policies
	public static By objTermsAndPolicies = By.xpath("//XCUIElementTypeStaticText[@name='Terms & Policies']");
//	Privacy policy
	public static By objPrivacyPolicy = By.xpath("//XCUIElementTypeStaticText[@name=\"Privacy Policy\"]");
//	Auto checked filters
	public static By objAutoCheckedFilter = By.xpath("//*[@type='XCUIElementTypeSwitch' and @value='1']");
//	auto checked filters
	public static By objAutoCheckedFilters(int i){
		return By.xpath("((//*[@type='XCUIElementTypeSwitch' and @value='1'])["+i+"]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText)[1]");
	}
//	account information
	public static By objAccountInformation(String sInfo){
		return By.xpath("//XCUIElementTypeStaticText[@name='"+sInfo+"']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
	}
//	Greater transaction limit
	public static By objExceedsTransactionLimitMsg = By.xpath("//XCUIElementTypeButton[@name=\"Confirm\"]/preceding-sibling::XCUIElementTypeOther/child::XCUIElementTypeStaticText");
//	ML Shop transaction
	public static By objMLShopTransaction = By.xpath("((//XCUIElementTypeOther[@name=\"OSJVNX\"])[1]/child::XCUIElementTypeScrollView/child::XCUIElementTypeOther/child::XCUIElementTypeOther)[1]");




	public static By objInputFieldOne=By.xpath("//*[@resource-id='dropEditProvince']");
	public static By objBranchName=By.xpath("//*[@text='AURORA']");
	public static By objInputFieldTwo=By.xpath("//*[@resource-id='btnChangeAddress']");
	public static By objSubBranchName=By.xpath("//*[@text='BALER']");
	public static By objInputFieldThree=By.xpath("//*[@resource-id='dropEditBranchname']");
	public static By objSubBranchNameTwo=By.xpath("//*[@text='ML BALER 2, AURORA']");
	public static By objSaveBtn=By.xpath("//*[@resource-id='submitEditDeliveryAddresButton']");
	public static By objAddressSuccessfulMsg=By.xpath("//*[@text='Successfully Update Delivery Address.']");
	public static By objOkBtn=By.xpath("//*[@text='Ok' or @text='OK']");
	public static By objOtpPage=By.xpath("//*[@text='One Time Pin']");
	public static By objOtpTextField=By.xpath("//*[@class='android.widget.EditText']");
	public static By objValidateBtn=By.xpath("//*[@text='Validate']");
	
	public static By objInvalidOtpPopUp=By.xpath("//*[@resource-id='swal2-title']");
	public static By objInvalidOtpPopUpMsg=By.xpath("//*[@resource-id='swal2-html-container']");
	

	public static By objAvailableBalance=By.xpath("//*[@text='Available Balance']");



	public static By objSearch=By.xpath("//*[@text=' Search']");
	public static By objProfile=By.xpath("//*[@text=' Profile']");

	public static By objAbout = By.xpath("//*[@text='About']");
	public static By objItems = By.xpath("//*[@id='imahehome']/child::android.view.View/child::android.view.View/child::android.view.View/following-sibling::android.view.View");
	public static By objGenderDropdown = By.xpath("//*[@resource-id='drpGender']");
	public static By objColorDropdown = By.xpath("//*[@resource-id='drpColor']");
	public static By objKaratDropdown = By.xpath("//*[@resource-id='drpKarat']");
	public static By objPriceDropdown = By.xpath("//*[@resource-id='drpKarat']");

	public static By objProductImage = By.xpath("//*[@resource-id='crewimage']");
	public static By objProductPrice = By.xpath("//*[@resource-id='productPriceDisplay']");
	public static By objShippingTo = By.xpath("//*[@resource-id='ship']");
	public static By objShippingFee = By.xpath("//*[@resource-id='shippingfee']");
	public static By objViewShop = By.xpath("//*[@text='\uF54E  View Shop']");

	public static By objCartPageHeader = By.xpath("(//*[@class='android.widget.Image'])[1]/following-sibling::android.view.View");
	public static By objPriceInCartPage = By.xpath("(//*[@class='android.widget.CheckBox']/following-sibling::android.widget.TextView)[2]");
	
	public static By objShippingDetails = By.xpath("//*[@resource-id='font-sd']");
	public static By objAddAddress = By.xpath("//*[@resource-id='btnChangeAddress']");
	public static By objProductNameInShippingDetails = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[1]");
	public static By objProductQuantity = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[2]");
	public static By objItemSubTotal = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[3]");
	public static By objHeader = By.xpath("//*[@resource-id='captionproductorder']");
	public static By objTotalOrder = By.xpath("//*[@resource-id='product-totalorder2_0']");
	public static By objShippingFeeInShippingDetails = By.xpath("//*[@resource-id='product-shippingfee2_0']");

	public static By objOnlineBanking = By.xpath("//*[@text='Online Banking']");
	public static By objMerchandiseSubTotal = By.xpath("//*[@text='Merchandise Subtotal :']/following-sibling::android.view.View");
	public static By objShippingTotal = By.xpath("//*[@text='Shipping Total :']/following-sibling::android.view.View");
	public static By objPaymentTotal = By.xpath("//*[@resource-id='product-final-total']");

	public static By objAddressUpdateMsg = By.xpath("//*[@resource-id='swal2-html-container']");

	public static By objOTPMsg = By.xpath("//*[@text='Enter the 6-digit OTP sent to your mobile number']");
	public static By objErrorPopup = By.xpath("//*[@resource-id='swal2-html-container']");
	public static By objMyAccount = By.xpath("//*[@text='MY ACCOUNT']");
	public static By objMyAccountDropdown = By.xpath("//*[@text='My Account']");
	public static By objMyAccountPageCrossBtn = By.xpath("//*[@resource-id='close-sidebar']/child::android.widget.TextView");
	public static By objMyProfileHeader = By.xpath("(//*[@text='My Profile'])[2]");
	public static By objMyPurchase = By.xpath("//*[@text='My Purchases']");
	public static By objSubtotalAmount = By.xpath("//*[@resource-id='cart-subtotal']");
}