package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletTierUpgradePages {


    //  Verification Tier perk page back button
    public static By objVerificationTierPerksBackBtn = By.xpath("//*[@name='Verification Tier Perks']/following-sibling::XCUIElementTypeOther");
    //  Semi verified Tab
    public static By objSemiVerifiedTab = By.xpath("//*[@name='Semi Verified']");
    //  Upgrade Tier Level Button
    public static By objUpgradeTierLevel = By.xpath("//*[@name='Upgrade Tier Level']");
    //  Fully verified Tab
    public static By objFullyVerifiedTab = By.xpath("//*[@name='Fully Verified']");
    //  Branch verified Tab
    public static By objBranchVerifiedTab = By.xpath("//*[@name='Branch Verified']");
    //  Account Details
    public static By objAccountDetails = By.xpath("//*[@name='Account Details']");
    //  Account Details page back button
    public static By objAccountDetailsBackBtn = By.xpath("//*[@name='Account Details']/following-sibling::XCUIElementTypeOther");

    public static By objSearchFieldInput = By.xpath("//*[@name='Search']");
//  Matching elements for Product/Services
    public static By objMatchingElementsProductServices(int i){
        return By.xpath("(((//*[@type='XCUIElementTypeScrollView'])[2]/child::XCUIElementTypeOther)[1]/child::XCUIElementTypeOther/child::XCUIElementTypeOther)["+i+"]");
    }
    public static By objMatchingElements = By.xpath("((//*[@type='XCUIElementTypeScrollView'])[2]/child::XCUIElementTypeOther)[1]/child::XCUIElementTypeOther");
//  Source of income selection button
    public static By objProductServiceSelectionBtn = By.xpath("//*[@name='Product/Services Offered']/following-sibling::XCUIElementTypeOther");
//  Position at Work selection button
    public static By objPositionAtWokSelectionBtn = By.xpath("//*[@name='Position at Work']/following-sibling::XCUIElementTypeOther");
//  Nature of Work selection button
    public static By objNatureOfWorkSelectionBtn = By.xpath("(//*[@name='Nature of Work'])[2]/following-sibling::XCUIElementTypeOther");
//  Confirm details btn
    public static By objConfirmDetails = By.xpath("//*[@name='Confirm Details']");
//  Tier Upgrade btn
    public static By objTierUpgrade = By.xpath("//*[@name='Tier Upgrade']");
//  Place of Birth
    public static By objPlaceOfBirth = By.xpath("//*[@name='Place of Birth']/child::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Nationality
    public static By objNationality = By.xpath("//*[@name='Nationality']/following-sibling::XCUIElementTypeOther");
//  Civil Status
    public static By objCivilStatus = By.xpath("//*[@name='Civil Status']/following-sibling::XCUIElementTypeOther");
//  Gender at Birth
    public static By objGenderAtBirth = By.xpath("//*[@name='Gender at Birth']/following-sibling::XCUIElementTypeOther");
//  Source of Income
    public static By objSourceOfIncome = By.xpath("//*[@name='Source of Income']/following-sibling::XCUIElementTypeOther");
//  Source of Income Header
    public static By objSourceOfIncomeHeader = By.xpath("//*[@name='Source of Income']");
//  Choose Source of Income
    public static By objChooseSourceOfIncome = By.xpath("//*[@name='Source of Income']/following-sibling::XCUIElementTypeOther");
//  Source of income option
//    public static By objSourceOfIncomeOption = By.xpath("(//*[@name='SALARY/PAY/WAGE/COMMISSION'])[2]");
    public static By objSourceOfIncomeOption (String sOptionText) {
        return By.xpath("(//*[@name='" + sOptionText + "'])[2]");
    }
    //  Company/Employer Name
    public static By objCompanyOrEmployerName = By.xpath("//*[@name='Company/Employer Name']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Work Address
    public static By objWorkAddress = By.xpath("//*[@name='Work Address']/child::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Account Details
    public static By objPersonalInformation = By.xpath("//*[@name='Personal Information']");
//  Select any valid ID
    public static By objSelectAnyValidID = By.xpath("//*[@name='Select Any Valid ID']");
//  Select ID
    public static By objSelectID = By.xpath("//*[@name='Select ID']");
//  Select ID Selection Btn
    public static By objSelectIDSelectionBtn = By.xpath("//*[@name='Select ID']/following-sibling::XCUIElementTypeOther");
//  Tier upgrade Back btn
    public static By objTierUpgradeBackBtn = By.xpath("//*[@name='Tier Upgrade']/following-sibling::XCUIElementTypeOther");
//  Upload ID Photos
    public static By objUploadIDPhotos = By.xpath("//*[@name='Upload ID Photos']");
//  Search ID Input Field
    public static By objSearchIDInputField = By.xpath("//*[@name='Search ID']/XCUIElementTypeTextField");
//  Card Number Input Field
    public static By objCardInputField = By.xpath("//*[@name='Card Number']/XCUIElementTypeTextField");
//  Scan Front of ID
    public static By objScanFrontOfID = By.xpath("//*[@name='Scan Front of ID']");
//  Scan Back of ID
    public static By objScanBackOfID = By.xpath("//*[@name='Scan Back of ID']");
//  Take a Face Identity Photo
    public static By objTakeAFaceIdentityPhoto = By.xpath("//*[@name='Take a Face Identity Photo']");
//  Phil Health
    public static By objPhilHealth = By.xpath("//*[@name='PHILHEALTH']");
//  Scan Front of ID Info
    public static By objScanFrontOfIDInfo = By.xpath("//*[@name='Scan Front of ID']/following-sibling::XCUIElementTypeStaticText");
//  Scan Back of ID Info
    public static By objScanBackOfIDInfo = By.xpath("//*[@name='Scan Back of ID']/following-sibling::XCUIElementTypeStaticText");
//  Capture Screen
    public static By objCaptureScreen = By.xpath("(//XCUIElementTypeOther[@name=\"Please align your face inside the shape and take a snapshot\"])[3]/XCUIElementTypeOther[2]");
//  Capture button
    public static By objCaptureButton = By.xpath("(//XCUIElementTypeOther[@name=\"Please align your face inside the shape and take a snapshot\"])[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther");
    //  Capture Screen
    public static By objCaptureScreenBackID = By.xpath("(//*[@name='Scan Back of ID']/following-sibling::XCUIElementTypeOther)[1]");
    //  Capture button
    public static By objCaptureButtonBackID = By.xpath("(//*[@name='Scan Back of ID']/following-sibling::XCUIElementTypeOther)[2]");


    //
    public static By objTakeAFaceIdentityPhotoInfo = By.xpath("(//*[@name='Please align your face inside the shape and take a snapshot'])[4]");
//  Company/Employee Name Error Msg
    public static By objCompanyEmployerNameErrorMsg  = By.xpath("//*[@name='Company/Employer Name is required']");
//  Company/Employee Name Invalid input Error Msg
    public static By objInvalidInputErrorMsg = By.xpath("//*[@name='Organization Name must contain letters and numbers only']");
//  Work Address Error Msg
    public static By objWorkAddressErrorMsg  = By.xpath("//*[@name='Work Address is required']");
//  Field required error msg
    public static By objFieldRequiredErrorMSg = By.xpath("//*[@name='Field is is required']");
//  Product/Services offered Name Error Msg
    public static By objProductServicesOfferedErrorMsg  = By.xpath("//*[@name='Product/Services Offered is required']");
//  Company/Employer Input Field
    public static By objCompanyEmployerNameInputField = By.xpath("(//*[@name='Company/Employer Name'])[2]/child::XCUIElementTypeTextField");
//  Choose Product Services Offered
    public static By objChooseProductServicesOffered = By.xpath("//*[@name='Product/Services Offered']/following-sibling::XCUIElementTypeOther");
//  Product Services Offered Header
    public static By objProductServicesOfferedHeader = By.xpath("//*[@name='Product/Services Offered']");
//  Product Services Offered Option
    public static By objProductServicesOfferedOption = By.xpath("(//*[@name='KNOWLEDGE'])[2]");
//  Work Address Input Field
    public static By objWorkAddressInputField = By.xpath("(//*[@name='Work Address'])[2]/child::XCUIElementTypeTextField");
//  Work Address Invalid Error Msg
    public static By objWorkAddressInvalidErrorMsg = By.xpath("//*[@name='Address must contain letters and numbers only']");
//  Position at work required error msg
    public static By objPositionAtWorkRequiredErrorMsg = By.xpath("//*[@name='Position at Work is required']");
//  Position at work Header
    public static By objPositionAtWorkHeader = By.xpath("//*[@name='Position at Work']");
//  Choose Position at work
    public static By objChoosePositionAtWork= By.xpath("//*[@name='Position at Work']/following-sibling::XCUIElementTypeOther");
//  Product Services Offered Option
    public static By objPositionAtWorkOption = By.xpath("(//*[@name='STAFF/CLERK/WORKER (OFFICE)'])[2]");
//  Nature of work required error msg
    public static By objNatureOfWorkRequiredErrorMsg = By.xpath("//*[@name='Nature of Work is required']");



//  Receiving Pension from error msg
    public static By objReceivingPensionFromErrorMsg = By.xpath("//*[@name='Receiving Pension From is required']");
//  Choose Receiving Pension from
    public static By objChooseReceivingPensionFrom = By.xpath("//*[@name='Receiving Pension From']/following-sibling::XCUIElementTypeOther");
//  Receiving Pension from Header
    public static By objReceivingPensionFromHeader = By.xpath("//*[@name='Receiving Pension From']");
//  Year Retired error msg
    public static By objYearRetiredErrorMsg = By.xpath("//*[@name='Year Retired is required']");
// Year retired input field
    public static By objYearRetiredInputField = By.xpath("//*[@name='Year Retired']/child::XCUIElementTypeTextField");
//  Position Upon Retirement is required error msg
    public static By objPositionUponRetirementErrorMsg = By.xpath("//*[@name='Position Upon Retirement is required']");
//  Remarks is required error msg
    public static By objRemarksErrorMsg = By.xpath("//*[@name='Remarks is required']");
//  School/University is required error msg
    public static By objSchoolUniversityErrorMsg = By.xpath("//*[@name='School/University is required']");
//  School/University Input Field
    public static By objSchoolUniversityInputField = By.xpath("//*[@name='School/University']/child::XCUIElementTypeTextField");
//  School Address  is required error msg
    public static By objSchoolAddressErrorMsg = By.xpath("//*[@name='School Address is required']");
//  School Address Input Field
    public static By objSchoolAddressInputField = By.xpath("//*[@name='School Address']/child::XCUIElementTypeTextField");
//  School Address Invalid Input
    public static By objSchoolAddressInvalidErrorMsg = By.xpath("//*[@name='Address must contain letters and numbers only']");
//  Grant/Program Type require error msg
    public static By objGrantProgramType = By.xpath("//*[@name='Grant/Program Type is required']");
//  Grant/Program Type Input Field
    public static By objGrantProgramTypeInputField = By.xpath("//*[@name='Grant/Program Type']/child::XCUIElementTypeTextField");
//  Occupation is required Error msg
    public static By objOccupationRequiredErrorMsg = By.xpath("//*[@name='Occupation is required']");
//  Occupation Input Field
    public static By objOccupationInputField = By.xpath("//*[@name='Occupation']/child::XCUIElementTypeTextField");
//  Source of Income required error Msg
    public static By objSourceOfFundsRequiredErrorMSg = By.xpath("//*[@name='Source of Funds is required']");
//    Company/Employer Name Input Value
    public static By objCompanyEmployerNameInputValue = By.xpath("(//*[@name='Company/Employer Name'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Work Address Input Value
    public static By objWorkAddressInputValue = By.xpath("(//*[@name='Work Address'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Year Retired Input value
    public static By objYearRetiredInputValue = By.xpath("(//*[@name='Year Retired'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  School/university Input value
    public static By objSchoolUniversityInputValue = By.xpath("(//*[@name='School/University'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  School Address Input value
    public static By objSchoolAddressInputValue = By.xpath("(//XCUIElementTypeOther[@name=\"School Address\"])[2]/XCUIElementTypeOther/XCUIElementTypeTextField");
//  Grant/ProgramType Input value
    public static By objGrantProgramTypeInputValue = By.xpath("(//*[@name='Grant/Program Type'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  occupation Input value
    public static By objOccupationInputValue = By.xpath("(//*[@name='Occupation'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");
//  Source of Funds input
    public static By objSourceOfFundsInputField = By.xpath("//*[@name='Source of Funds']/child::XCUIElementTypeTextField");
//  Source of Funds Input value
    public static By objSourceOfFundsInputValue = By.xpath("(//*[@name='Source of Funds'])[3]/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeTextField");

}
