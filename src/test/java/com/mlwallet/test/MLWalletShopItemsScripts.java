package com.mlwallet.test;

import com.driverInstance.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletShopItemsScripts extends BaseTest{

//    ========================================================================================//

    @Test(priority = 1)
    public void shopItemsHomePageNavigation_SI_TC_01() throws Exception {
        mlWalletShopItems.shopItemsHomePageNavigation_SI_TC_01();
    }
    @Test(priority = 2)
    public void shopItemsHamburgerMenuAboutLinkFunctionality_SI_TC_02() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuAboutLinkFunctionality_SI_TC_02();
    }
    @Test(priority = 3)
    public void shopItemsHamburgerMenuContactLinkFunctionality_SI_TC_03() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuContactLinkFunctionality_SI_TC_03();
    }

    @Test(priority = 4)
    public void shopItemsHamburgerMenuCartLinkFunctionality_SI_TC_04() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuCartLinkFunctionality_SI_TC_04();
    }
    @Test(priority = 5)
    public void shopItemsHamburgerMenuProfileLinkFunctionality_SI_TC_05() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuProfileLinkFunctionality_SI_TC_05();
    }
    @Test(priority = 6)
    public void shopItemsHamburgerMenuPurchaseHistoryLinkFunctionality_SI_TC_06() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuPurchaseHistoryLinkFunctionality_SI_TC_06();
    }
    @Test(priority = 7)
    public void shopItemsLogout_SI_TC_07() throws Exception {
        mlWalletShopItems.shopItemsLogout_SI_TC_07();
    }
    @Test(priority = 8)
    public void shopItemsSuccessfulLogin_SI_TC_08() throws Exception {
        mlWalletShopItems.shopItemsSuccessfulLogin_SI_TC_08();
    }
    @Test(priority = 9)
    public void shopItemsLogOutAndLoginWithAnotherAccount_SI_TC_11() throws Exception {
        mlWalletShopItems.shopItemsLogOutAndLoginWithAnotherAccount_SI_TC_11();
    }
    @Test(priority = 10)
    public void shopItemsHomeScreenUIValidation_SI_TC_12() throws Exception {
        mlWalletShopItems.shopItemsHomeScreenUIValidation_SI_TC_12();
    }
    @Test(priority = 11)
    public void shopItemsRingItemPageNavigation_SI_TC_14() throws Exception {
        mlWalletShopItems.shopItemsRingItemPageNavigation_SI_TC_14();
    }
    @Test(priority = 12)
    public void shopItemsNecklacesAndPendantsItemPageNavigation_SI_TC_15() throws Exception {
        mlWalletShopItems.shopItemsNecklacesAndPendantsItemPageNavigation_SI_TC_15();
    }
    @Test(priority = 13)
    public void shopItemsBraceletAndBangleItemPageNavigation_SI_TC_16() throws Exception {
        mlWalletShopItems.shopItemsBraceletAndBangleItemPageNavigation_SI_TC_16();
    }
    @Test(priority = 14)
    public void shopItemsEarringsItemPageNavigation_SI_TC_17() throws Exception {
        mlWalletShopItems.shopItemsEarringsItemPageNavigation_SI_TC_17();
    }
    @Test(priority = 15)
    public void shopItemsWatchItemPageNavigation_SI_TC_18() throws Exception {
        mlWalletShopItems.shopItemsWatchItemPageNavigation_SI_TC_18();
    }
    @Test(priority = 16)
    public void shopItemsAutoCheckedProductTypeAfterSelectingProductTpe_SI_TC_19() throws Exception {
        mlWalletShopItems.shopItemsAutoCheckedProductTypeAfterSelectingProductTpe_SI_TC_19();
    }
    @Test(priority = 17)
    public void shopItemsSelectRingProductTypeAndProductsValidation_SI_TC_21() throws Exception {
        mlWalletShopItems.shopItemsSelectRingProductTypeAndProductsValidation_SI_TC_21();
    }
    @Test(priority = 18)
    public void shopItemsSelectNecklaceProductTypeAndProductsValidation_SI_TC_22() throws Exception {
        mlWalletShopItems.shopItemsSelectNecklaceProductTypeAndProductsValidation_SI_TC_22();
    }
    @Test(priority = 19)
    public void shopItemsSelectBraceletAndBangleProductTypeAndProductsValidation_SI_TC_23() throws Exception {
        mlWalletShopItems.shopItemsSelectBraceletAndBangleProductTypeAndProductsValidation_SI_TC_23();
    }
    @Test(priority = 20)
    public void shopItemsSelectEarringsProductTypeAndProductsValidation_SI_TC_24() throws Exception {
        mlWalletShopItems.shopItemsSelectEarringsProductTypeAndProductsValidation_SI_TC_24();
    }
    @Test(priority = 21)
    public void shopItemsSelectPendantProductTypeAndProductsValidation_SI_TC_25() throws Exception {
        mlWalletShopItems.shopItemsSelectPendantProductTypeAndProductsValidation_SI_TC_25();
    }
    @Test(priority = 22)
    public void shopItemsSelectTernoAndSetProductTypeAndProductsValidation_SI_TC_26() throws Exception {
        mlWalletShopItems.shopItemsSelectTernoAndSetProductTypeAndProductsValidation_SI_TC_26();
    }
    @Test(priority = 23)
    public void shopItemsSelectBroochProductTypeAndProductsValidation_SI_TC_27() throws Exception {
        mlWalletShopItems.shopItemsSelectBroochProductTypeAndProductsValidation_SI_TC_27();
    }
    @Test(priority = 24)
    public void shopItemsSelect10KMaterialAndProductsValidation_SI_TC_28() throws Exception {
        mlWalletShopItems.shopItemsSelect10KMaterialAndProductsValidation_SI_TC_28();
    }
    @Test(priority = 25)
    public void shopItemsSelect14KMaterialAndProductsValidation_SI_TC_29() throws Exception {
        mlWalletShopItems.shopItemsSelect14KMaterialAndProductsValidation_SI_TC_29();
    }
    @Test(priority = 26)
    public void shopItemsSelect18KMaterialAndProductsValidation_SI_TC_30() throws Exception {
        mlWalletShopItems.shopItemsSelect18KMaterialAndProductsValidation_SI_TC_30();
    }
    @Test(priority = 27)
    public void shopItemsSelect20KMaterialAndProductsValidation_SI_TC_31() throws Exception {
        mlWalletShopItems.shopItemsSelect20KMaterialAndProductsValidation_SI_TC_31();
    }
    @Test(priority = 28)
    public void shopItemsSelect21KMaterialAndProductsValidation_SI_TC_32() throws Exception {
        mlWalletShopItems.shopItemsSelect21KMaterialAndProductsValidation_SI_TC_32();
    }
    @Test(priority = 29)
    public void shopItemsSelect22KMaterialAndProductsValidation_SI_TC_33() throws Exception {
        mlWalletShopItems.shopItemsSelect22KMaterialAndProductsValidation_SI_TC_33();
    }
    @Test(priority = 30)
    public void shopItemsSelect12KMaterialAndProductsValidation_SI_TC_34() throws Exception {
        mlWalletShopItems.shopItemsSelect12KMaterialAndProductsValidation_SI_TC_34();
    }
    @Test(priority = 31)
    public void shopItemsSelectYellowGoldMaterialColorAndProductsValidation_SI_TC_35() throws Exception {
        mlWalletShopItems.shopItemsSelectYellowGoldMaterialColorAndProductsValidation_SI_TC_35();
    }
    @Test(priority = 32)
    public void shopItemsSelectWhiteGoldMaterialColorAndProductsValidation_SI_TC_36() throws Exception {
        mlWalletShopItems.shopItemsSelectWhiteGoldMaterialColorAndProductsValidation_SI_TC_36();
    }
    @Test(priority = 33)
    public void shopItemsSelectRoseGoldMaterialColorAndProductsValidation_SI_TC_37() throws Exception {
        mlWalletShopItems.shopItemsSelectRoseGoldMaterialColorAndProductsValidation_SI_TC_37();
    }
    @Test(priority = 34)
    public void shopItemsSelectTwoToneMaterialColorAndProductsValidation_SI_TC_38() throws Exception {
        mlWalletShopItems.shopItemsSelectTwoToneMaterialColorAndProductsValidation_SI_TC_38();
    }
    @Test(priority = 35)
    public void shopItemsSelectTriToneMaterialColorAndProductsValidation_SI_TC_39() throws Exception {
        mlWalletShopItems.shopItemsSelectTriToneMaterialColorAndProductsValidation_SI_TC_39();
    }
    @Test(priority = 36)
    public void shopItemsSelectLadiesGenderAndProductsValidation_SI_TC_40() throws Exception {
        mlWalletShopItems.shopItemsSelectLadiesGenderAndProductsValidation_SI_TC_40();
    }
    @Test(priority = 37)
    public void shopItemsSelectMensGenderAndProductsValidation_SI_TC_41() throws Exception {
        mlWalletShopItems.shopItemsSelectMensGenderAndProductsValidation_SI_TC_41();
    }
    @Test(priority = 38)
    public void shopItemsSelectUnisexAndProductsValidation_SI_TC_42() throws Exception {
        mlWalletShopItems.shopItemsSelectUnisexAndProductsValidation_SI_TC_42();
    }
    @Test(priority = 39)
    public void shopItemsPriceRangeFilterValidation_SI_TC_43() throws Exception {
        mlWalletShopItems.shopItemsPriceRangeFilterValidation_SI_TC_43();
    }
    @Test(priority = 40)
    public void shopItemsSortItemsByPriceOptionsValidation_SI_TC_44() throws Exception {
        mlWalletShopItems.shopItemsSortItemsByPriceOptionsValidation_SI_TC_44();
    }
    @Test(priority = 41)
    public void shopItemsItemsSelectionScreenProductDetailsValidation_SI_TC_45() throws Exception {
        mlWalletShopItems.shopItemsItemsSelectionScreenProductDetailsValidation_SI_TC_45();
    }
    @Test(priority = 42)
    public void shopItemsSelectedWatchItemScreenUIValidation_SI_TC_49() throws Exception {
        mlWalletShopItems.shopItemsSelectedWatchItemScreenUIValidation_SI_TC_49();
    }
    @Test(priority = 43)
    public void shopItemsSelectedRingItemScreenUIValidation_SI_TC_50() throws Exception {
        mlWalletShopItems.shopItemsSelectedRingItemScreenUIValidation_SI_TC_50();
    }
    @Test(priority = 44)
    public void shopItemsSelectedNecklaceAndPendantsItemScreenUIValidation_SI_TC_51() throws Exception {
        mlWalletShopItems.shopItemsSelectedNecklaceAndPendantsItemScreenUIValidation_SI_TC_51();
    }
    @Test(priority = 45)
    public void shopItemsSelectedBraceletsAndBanglesItemScreenUIValidation_SI_TC_52() throws Exception {
        mlWalletShopItems.shopItemsSelectedBraceletsAndBanglesItemScreenUIValidation_SI_TC_52();
    }
    @Test(priority = 46)
    public void shopItemsSelectedEarringsItemScreenUIValidation_SI_TC_53() throws Exception {
        mlWalletShopItems.shopItemsSelectedEarringsItemScreenUIValidation_SI_TC_53();
    }
    @Test(priority = 47)
    public void shopItemsItemAddedToCartConfirmationValidation_SI_TC_54() throws Exception {
        mlWalletShopItems.shopItemsItemAddedToCartConfirmationValidation_SI_TC_54();
    }
    @Test(priority = 48)
    public void shopItemsItemAlreadyAddedToCartConfirmationValidation_SI_TC_55() throws Exception {
        mlWalletShopItems.shopItemsItemAlreadyAddedToCartConfirmationValidation_SI_TC_55();
    }
    @Test(priority = 49)
    public void shopItemsCartIconValidationAfterAddingNewItem_SI_TC_56() throws Exception {
        mlWalletShopItems.shopItemsCartIconValidationAfterAddingNewItem_SI_TC_56();
    }
    @Test(priority = 50)
    public void shopItemsAddedItemValidationInCartScreen_SI_TC_58() throws Exception {
        mlWalletShopItems.shopItemsAddedItemValidationInCartScreen_SI_TC_58();
    }
    @Test(priority = 51)
    public void shopItemsAddItemToCartAndDeleteItemFromCartValidation_SI_TC_59() throws Exception {
        mlWalletShopItems.shopItemsAddItemToCartAndDeleteItemFromCartValidation_SI_TC_59();
    }
    @Test(priority = 52)
    public void shopItemsCheckOutButtonValidation_SI_TC_60() throws Exception {
        mlWalletShopItems.shopItemsCheckOutButtonValidation_SI_TC_60();
    }
    @Test(priority = 53)
    public void shopItemsUnselectCheckBoxAndCheckOutValidation_SI_TC_61() throws Exception {
        mlWalletShopItems.shopItemsUnselectCheckBoxAndCheckOutValidation_SI_TC_61();
    }
    @Test(priority = 54)
    public void shopItemsCheckOutButtonValidationAsGuestUser_SI_TC_62() throws Exception {
        mlWalletShopItems.shopItemsCheckOutButtonValidationAsGuestUser_SI_TC_62();
    }
    @Test(priority = 55)
    public void shopItemsAutoCheckedItemCheckBoxValidation_SI_TC_63() throws Exception {
        mlWalletShopItems.shopItemsAutoCheckedItemCheckBoxValidation_SI_TC_63();
    }
    @Test(priority = 56)
    public void shopItemsCartPageUIValidation_SI_TC_64() throws Exception {
        mlWalletShopItems.shopItemsCartPageUIValidation_SI_TC_64();
    }
    @Test(priority = 57)
    public void shopItemsSelectSpecificProductAndCheckOutValidation_SI_TC_65() throws Exception {
        mlWalletShopItems.  shopItemsSelectSpecificProductAndCheckOutValidation_SI_TC_65();
    }
    @Test(priority = 58)
    public void shopItemsPlaceOrderPageNavigation_SI_TC_66() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderPageNavigation_SI_TC_66();
    }
    @Test(priority = 59)
    public void shopItemsEmptyCartMsgValidation_SI_TC_67() throws Exception {
        mlWalletShopItems.shopItemsEmptyCartMsgValidation_SI_TC_67();
    }
    @Test(priority = 60)
    public void shopItemsAddToCartConfirmButtonFunctionality_SI_TC_68() throws Exception {
        mlWalletShopItems.shopItemsAddToCartConfirmButtonFunctionality_SI_TC_68();
    }
    @Test(priority = 61)
    public void shopItemsServiceFeeValidationForSameOriginAndDestinationBranch_SI_TC_70() throws Exception {
        mlWalletShopItems.shopItemsServiceFeeValidationForSameOriginAndDestinationBranch_SI_TC_70("ML WALLET");
    }
    @Test(priority = 62)
    public void shopItemsItemsDisplayedUnderAppropriateLabelsValidation_SI_TC_72() throws Exception {
        mlWalletShopItems.shopItemsItemsDisplayedUnderAppropriateLabelsValidation_SI_TC_72();
    }
    @Test(priority = 63)
    public void shopItemsSubtotalOrderAsPerTotalItemsSelected_SI_TC_73() throws Exception {
        mlWalletShopItems.shopItemsSubtotalOrderAsPerTotalItemsSelected_SI_TC_73("ML WALLET");
    }
    @Test(priority = 64)
    public void shopItemsPlaceOrderBtnEnabledAfterSelectingPickUpBranchValidation_SI_TC_75() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderBtnEnabledAfterSelectingPickUpBranchValidation_SI_TC_75();
    }
    @Test(priority = 65)
    public void shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_76() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_76();
    }
    @Test(priority = 66)
    public void shopItemsNoItemsSelectedPopupConfirmBtnFunctionality_SI_TC_77() throws Exception {
        mlWalletShopItems.shopItemsNoItemsSelectedPopupConfirmBtnFunctionality_SI_TC_77();
    }
    @Test(priority = 67)
    public void shopItemsPlaceOrderBtnFunctionality_SI_TC_78() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderBtnFunctionality_SI_TC_78("ML WALLET");
    }
    @Test(priority = 68)
    public void shopItemsProvinceDisplayedToPickUpBasedOnProvinceDisplayedOnPersonalInformation_SI_TC_81() throws Exception {
        mlWalletShopItems.shopItemsProvinceDisplayedToPickUpBasedOnProvinceDisplayedOnPersonalInformation_SI_TC_81();
    }
    @Test(priority = 69)
    public void shopItemsBranchAddressDisplayedValidation_SI_TC_82() throws Exception {
        mlWalletShopItems.shopItemsBranchAddressDisplayedValidation_SI_TC_82();
    }
    @Test(priority = 70)
    public void shopItemsCityDisplayedToPickUpBasedOnCityDisplayedOnPersonalInformation_SI_TC_83() throws Exception {
        mlWalletShopItems.shopItemsCityDisplayedToPickUpBasedOnCityDisplayedOnPersonalInformation_SI_TC_83();
    }
    @Test(priority = 71)
    public void shopItemsBranchNameValidationBasedOnCitySelected_SI_TC_84() throws Exception {
        mlWalletShopItems.shopItemsBranchNameValidationBasedOnCitySelected_SI_TC_84();
    }
    @Test(priority = 72)
    public void shopItemsPlaceOrderPageRequiredFieldsMsgValidation_SI_TC_85() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderPageRequiredFieldsMsgValidation_SI_TC_85();
    }
    @Test(priority = 73)
    public void shopItemsOrderConfirmationPopupProceedBtnFunctionality_SI_TC_87() throws Exception {
        mlWalletShopItems.shopItemsOrderConfirmationPopupProceedBtnFunctionality_SI_TC_87();
    }
    @Test(priority = 74)
    public void shopItemsOrderConfirmationPopupCloseBtnFunctionality_SI_TC_88() throws Exception {
        mlWalletShopItems.shopItemsOrderConfirmationPopupCloseBtnFunctionality_SI_TC_88();
    }
    @Test(priority = 75)
    public void shopItemsInsufficientBalanceErrorMsgValidation_SI_TC_91() throws Exception {
        mlWalletShopItems.shopItemsInsufficientBalanceErrorMsgValidation_SI_TC_91();
    }
    @Test(priority = 76)
    public void shopItemsSuccessfulOrderPlacement_SI_TC_94() throws Exception {
        mlWalletShopItems.shopItemsSuccessfulOrderPlacement_SI_TC_94();
    }
    @Test(priority = 77)
    public void shopItemsAvailableBalanceValidationAfterSuccessfulOrderPlacement_SI_TC_95() throws Exception {
        mlWalletShopItems.shopItemsAvailableBalanceValidationAfterSuccessfulOrderPlacement_SI_TC_95();
    }
    @Test(priority = 78)
    public void shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingMLWalletPaymentMethod_SI_TC_97() throws Exception {
        mlWalletShopItems.shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingMLWalletPaymentMethod_SI_TC_97();
    }
    @Test(priority = 79)
    public void shopItemsPaymentMethodsUnderPaymongoServicesValidation_SI_TC_98() throws Exception {
        mlWalletShopItems.shopItemsPaymentMethodsUnderPaymongoServicesValidation_SI_TC_98();
    }
    @Test(priority = 80)
    public void shopItemsDirectOnlineBankingPaymentMethodPartnerFeeValidation_SI_TC_103() throws Exception {
        mlWalletShopItems.shopItemsDirectOnlineBankingPaymentMethodPartnerFeeValidation_SI_TC_103();
    }
    @Test(priority = 81)
    public void shopItemsGrabPayPlaceOrderConfirmationPopupValidation_SI_TC_104() throws Exception {
        mlWalletShopItems.shopItemsGrabPayPlaceOrderConfirmationPopupValidation_SI_TC_104();
    }
    @Test(priority = 82)
    public void shopItemsGCashPlaceOrderConfirmationPopupValidation_SI_TC_105() throws Exception {
        mlWalletShopItems.shopItemsGCashPlaceOrderConfirmationPopupValidation_SI_TC_105();
    }
    @Test(priority = 83)
    public void shopItemsPaymayaPlaceOrderConfirmationPopupValidation_SI_TC_106() throws Exception {
        mlWalletShopItems.shopItemsPaymayaPlaceOrderConfirmationPopupValidation_SI_TC_106();
    }
    @Test(priority = 84)
    public void shopItemsVisaMastercardPlaceOrderConfirmationPopupValidation_SI_TC_107() throws Exception {
        mlWalletShopItems.shopItemsVisaMastercardPlaceOrderConfirmationPopupValidation_SI_TC_107();
    }
    @Test(priority = 85)
    public void shopItemsDirectOnlineBankingPlaceOrderConfirmationPopupValidation_SI_TC_108() throws Exception {
        mlWalletShopItems.shopItemsDirectOnlineBankingPlaceOrderConfirmationPopupValidation_SI_TC_108();
    }
    @Test(priority = 86)
    public void shopItemsPayMongoPortalNavigationWithPaymentMethodAsVisaMastercard_SI_TC_109() throws Exception {
        mlWalletShopItems.shopItemsPayMongoPortalNavigationWithPaymentMethodAsVisaMastercard_SI_TC_109();
    }
    @Test(priority = 87)
    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsGrabPay_SI_TC_110() throws Exception {
        mlWalletShopItems.shopItemsPaymongoPortalNavigationWithPaymentMethodAsGrabPay_SI_TC_110();
    }
    @Test(priority = 88)
    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsGCash_SI_TC_111() throws Exception {
        mlWalletShopItems.shopItemsPaymongoPortalNavigationWithPaymentMethodAsGCash_SI_TC_111();
    }
    @Test(priority = 89)
    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsPaymaya_SI_TC_112() throws Exception {
        mlWalletShopItems.shopItemsPaymongoPortalNavigationWithPaymentMethodAsPaymaya_SI_TC_112();
    }
    @Test(priority = 90)
    public void shopItemsPaymongoPortalNavigationWithPaymentMethodAsDirectOnlineBanking_SI_TC_113() throws Exception {
        mlWalletShopItems.shopItemsPaymongoPortalNavigationWithPaymentMethodAsDirectOnlineBanking_SI_TC_113();
    }
    @Test(priority = 91)
    public void shopItemsPlaceOrderConfirmationPopupCloseBtnFunctionality_SI_TC_114() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderConfirmationPopupCloseBtnFunctionality_SI_TC_114();
    }
    @Test(priority = 92)
    public void shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingEWalletPaymentMethod_SI_TC_116() throws Exception {
        mlWalletShopItems.shopItemsCartPageValidationAfterAfterSuccessfulOrderPlacementUsingEWalletPaymentMethod_SI_TC_116();
    }
    @Test(priority = 93)
    public void shopItemsProductsMerchandiseTotalValidation_SI_TC_117() throws Exception {
        mlWalletShopItems.shopItemsProductsMerchandiseTotalValidation_SI_TC_117("ML WALLET");
    }
    @Test(priority = 94)
    public void shopItemsShippingFeeValidationBasedOnLocationSelected_SI_TC_118() throws Exception {
        mlWalletShopItems.shopItemsShippingFeeValidationBasedOnLocationSelected_SI_TC_118();
    }
    @Test(priority = 95)
    public void shopItemsServiceTotalValidationBasedOnPaymentMethodSelected_SI_TC_119() throws Exception {
        mlWalletShopItems.shopItemsServiceTotalValidationBasedOnPaymentMethodSelected_SI_TC_119();
    }
    @Test(priority = 96)
    public void shopItemsTotalPurchasedItemValidation_SI_TC_120() throws Exception {
        mlWalletShopItems.shopItemsTotalPurchasedItemValidation_SI_TC_120();
    }
    @Test(priority = 97)
    public void shopItemsTotalPaymentValidation_SI_TC_121() throws Exception {
        mlWalletShopItems.shopItemsTotalPaymentValidation_SI_TC_121();
    }
    @Test(priority = 98)
    public void shopItemsSelectPaymentMethodErrorPopupValidation_SI_TC_122() throws Exception {
        mlWalletShopItems.shopItemsSelectPaymentMethodErrorPopupValidation_SI_TC_122();
    }
    @Test(priority = 99)
    public void shopItemsSelectPaymentMethodErrorPopupConfirmBtnValidation_SI_TC_123() throws Exception {
        mlWalletShopItems.shopItemsSelectPaymentMethodErrorPopupConfirmBtnValidation_SI_TC_123();
    }
    @Test(priority = 100)
    public void shopItemsServiceTotalValidationForDirectOnlineBankingPaymentMethod_SI_TC_126() throws Exception {
        mlWalletShopItems.shopItemsServiceTotalValidationForDirectOnlineBankingPaymentMethod_SI_TC_126();
    }
    @Test(priority = 101)
    public void shopItemsMaximumNumberOfItemsDisplayedPerPageValidation_SI_TC_127() throws Exception {
        mlWalletShopItems.shopItemsMaximumNumberOfItemsDisplayedPerPageValidation_SI_TC_127();
    }
    @Test(priority = 102)
    public void shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_128() throws Exception {
        mlWalletShopItems.shopItemsPlaceOrderBtnRemainsDisabledValidation_SI_TC_128();
    }
    @Test(priority = 103)
    public void shopItemsSuccessfulOrderPlacementAsSemiVerifiedTier_SI_TC_92() throws Exception {
        mlWalletShopItems.shopItemsSuccessfulOrderPlacementAsSemiVerifiedTier_SI_TC_92();
    }
    @Test(priority = 104)
    public void shopItemsMaxTransactionErrorMsgValidationForSemiVerifiedUser_SI_TC_93() throws Exception {
        mlWalletShopItems.shopItemsMaxTransactionErrorMsgValidationForSemiVerifiedUser_SI_TC_93();
    }
    @Test(priority = 105)
    public void shopItemsDeleteConfirmationPopupUIValidation_SI_TC_143() throws Exception {
        mlWalletShopItems.shopItemsDeleteConfirmationPopupUIValidation_SI_TC_143();
    }
    @Test(priority = 106)
    public void shopItemsDeleteConfirmationPopupCancelBtnFunctionality_SI_TC_144() throws Exception {
        mlWalletShopItems.shopItemsDeleteConfirmationPopupCancelBtnFunctionality_SI_TC_144();
    }
    @Test(priority = 107)
    public void shopItemsHamburgerMenuScreenValidation_SI_TC_145() throws Exception {
        mlWalletShopItems.shopItemsHamburgerMenuScreenValidation_SI_TC_145();
    }
    @Test(priority = 108)
    public void shopItemsProductTypesUnderAmparitoCollectionValidation_SI_TC_146() throws Exception {
        mlWalletShopItems.shopItemsProductTypesUnderAmparitoCollectionValidation_SI_TC_146();
    }
    @Test(priority = 109)
    public void shopItemsGenderTypesUnderAmparitoCollectionValidation_SI_TC_147() throws Exception {
        mlWalletShopItems.shopItemsGenderTypesUnderAmparitoCollectionValidation_SI_TC_147();
    }
    @Test(priority = 110)
    public void shopItemsMaterialColorTypesUnderAmparitoCollectionValidation_SI_TC_148() throws Exception {
        mlWalletShopItems.shopItemsMaterialColorTypesUnderAmparitoCollectionValidation_SI_TC_148();
    }
    @Test(priority = 111)
    public void shopItemsMaterialTypesUnderAmparitoCollectionValidation_SI_TC_149() throws Exception {
        mlWalletShopItems.shopItemsMaterialTypesUnderAmparitoCollectionValidation_SI_TC_149();
    }

    @Test(priority = 112)
    public void shopItemsAmparitoCollectionsPriceRangeValidation_SI_TC_150() throws Exception {
        mlWalletShopItems.shopItemsAmparitoCollectionsPriceRangeValidation_SI_TC_150();
    }

    @Test(priority = 113)
    public void shopItemsInsufficientBalancePopupCloseBtnFunctionality_SI_TC_151() throws Exception {
        mlWalletShopItems.shopItemsInsufficientBalancePopupCloseBtnFunctionality_SI_TC_151();
    }
    @Test(priority = 114)
    public void shopItemsInsufficientBalancePopupTopUpBtnFunctionality_SI_TC_152() throws Exception {
        mlWalletShopItems.shopItemsInsufficientBalancePopupTopUpBtnFunctionality_SI_TC_152();
    }
    @Test(priority = 115)
    public void shopItemsWatchItemsDisplayedValidation_SI_TC_13() throws Exception {
        mlWalletShopItems.shopItemsWatchItemsDisplayedValidation_SI_TC_13();
    }
    @Test(priority = 116)
    public void shopItemsAutoCheckedFiltersValidation_SI_TC_20() throws Exception {
        mlWalletShopItems.shopItemsAutoCheckedFiltersValidation_SI_TC_20();
    }
    @Test(priority = 117)
    public void shopItemsSelectedJewelryItemScreenUIValidation_SI_TC_46() throws Exception {
        mlWalletShopItems.shopItemsSelectedJewelryItemScreenUIValidation_SI_TC_46();
    }
    @Test(priority = 118)
    public void shopItemsWatchItemsValidationDependingOnCheckBoxesSelected_SI_TC_47() throws Exception {
        mlWalletShopItems.shopItemsWatchItemsValidationDependingOnCheckBoxesSelected_SI_TC_47();
    }
    @Test(priority = 119)
    public void shopItemsSpecificWatchProductDetailsValidation_SI_TC_48() throws Exception {
        mlWalletShopItems.shopItemsSpecificWatchProductDetailsValidation_SI_TC_48();
    }
    @Test(priority = 120)
    public void shopItemsSelectedWatchItemScreenUIValidation_SI_TC_57() throws Exception {
        mlWalletShopItems.shopItemsSelectedWatchItemScreenUIValidation_SI_TC_57();
    }
    @Test(priority = 121)
    public void shopItemsServiceFeeValidationForOrdersWithSameOriginAndDestinationBranchUsingPaymongoPaymentMethod_SI_TC_71() throws Exception {
        mlWalletShopItems.shopItemsServiceFeeValidationForOrdersWithSameOriginAndDestinationBranchUsingPaymongoPaymentMethod_SI_TC_71();
    }
    @Test(priority = 122)
    public void shopItemsAccountInformationValidationWithMLWalletAutoLogin_SI_TC_79() throws Exception {
        mlWalletShopItems.shopItemsAccountInformationValidationWithMLWalletAutoLogin_SI_TC_79();
    }
    @Test(priority = 123)
    public void shopItemsOrderConfirmationMessageValidation_SI_TC_86() throws Exception {
        mlWalletShopItems.shopItemsOrderConfirmationMessageValidation_SI_TC_86();
    }
    @Test(priority = 124)
    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForFullyVerifiedUser_SI_TC_161() throws Exception {
        mlWalletShopItems.shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForFullyVerifiedUser_SI_TC_161();
    }
    @Test(priority = 125)
    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBuyerTierUser_SI_TC_167() throws Exception {
        mlWalletShopItems.shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBuyerTierUser_SI_TC_167();
    }
    @Test(priority = 126)
    public void shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBranchVerifiedUser_SI_TC_173() throws Exception {
        mlWalletShopItems.shopItemsTransactionErrorMessageValidationWhenCartValueExceedsTransactionLimitForBranchVerifiedUser_SI_TC_173();
    }
    @Test(priority = 127)
    public void shopItemsRecentTransactionValidation_SI_TC_180() throws Exception {
        mlWalletShopItems.shopItemsRecentTransactionValidation_SI_TC_180();
    }
    @Test(priority = 128)
    public void shopItemsVisaMasterCardPaymentMethodPartnerFeeValidation_SI_TC_99() throws Exception {
        mlWalletShopItems.shopItemsVisaMasterCardPaymentMethodPartnerFeeValidation_SI_TC_99();
    }
    @Test(priority = 129)
    public void shopItemsGCashPaymentMethodPartnerFeeValidation_SI_TC_100() throws Exception {
        mlWalletShopItems.shopItemsGCashPaymentMethodPartnerFeeValidation_SI_TC_100();
    }
    @Test(priority = 130)
    public void shopItemsGrabPayPaymentMethodPartnerFeeValidation_SI_TC_101() throws Exception {
        mlWalletShopItems.shopItemsGrabPayPaymentMethodPartnerFeeValidation_SI_TC_101();
    }
    @Test(priority = 131)
    public void shopItemsMayaPaymentMethodPartnerFeeValidation_SI_TC_102() throws Exception {
        mlWalletShopItems.shopItemsMayaPaymentMethodPartnerFeeValidation_SI_TC_102();
    }
    @Test(priority = 132)
    public void shopItemsReviewingItemDetailsAndFeeBeforePlacingTheOrder_SI_TC_69() throws Exception {
        mlWalletShopItems.shopItemsReviewingItemDetailsAndFeeBeforePlacingTheOrder_SI_TC_69();
    }




//====================================== Shop items end to end flow =============================================//







    @AfterMethod()
    public void afterMethod(){
        System.out.println("Reset");
        DriverManager.getAppiumDriver().resetApp();
        System.out.println("Reset complete");
    }


}
