
package com.mlwallet.test;

import com.aventstack.extentreports.ExtentTest;
import com.business.mlwallet.*;
import com.driverInstance.DriverManager;
import org.testng.annotations.*;
import com.driverInstance.AppiumServer;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import static com.utility.Utilities.softAssert;
import static com.utility.Utilities.*;

public class BaseTest {

    protected com.business.mlwallet.BaseClass baseClass;
    protected MLWalletLogin mlWalletLogin;
    protected MLWalletCashInViaBank mlWalletCashInViaBank;
    protected MLWalletCashInViaBranch mlWalletCashInViaBranch;
    protected MLWalletCashOutWithdraw mlWalletCashOutWithdraw;
    protected MLWalletSettings mlWalletSettings;
    protected MLWalletTransactionHistory mlWalletTransactionHistory;
    protected MLWalletLogOut mlWalletLogOut;
    protected MlWalletHomeAndDashBoard mlWalletHomeAndDashBoard;
    protected MLWalletTierUpgrade mlWalletTierUpgrade;
    protected MLWalletSendTransferToMLBranch mlWalletSendTransferToMLBranch;
    protected MLWalletSendTransferToMLWalletUser mlWalletSendTransferToMLWalletUser;
    protected MLWalletPayBills mlWalletPayBills;
    protected MLWalletBuyELoad mlWalletBuyELoad;
    protected MLWalletShopItems mlWalletShopItems;
    protected MLWalletBranchLocator mlWalletBranchLocator;
    protected MLWalletUseQR mlWalletUseQR;
    protected MLWalletTopUpGames mlWalletTopUpGames;

    public static ExtentTest testLogger;
    AppiumServer server = new AppiumServer();
    protected static LoggingUtils logger = new LoggingUtils();
    public static PropertyFileReader prop;
    public String osName = System.getProperty("os.name").toLowerCase();

    //To Read Properties File Based On Current OS Of Laptop
    public void propertyFileReader() {
        if (osName.contains("mac") || osName.contains("linux")) {
            System.out.println(osName);
            prop = new PropertyFileReader(".//properties//testdata.properties");
        } else {
            prop = new PropertyFileReader(".\\properties\\testdata.properties");
        }

    }



    //Start Application
    @Parameters({"deviceName", "portno"})
    @BeforeClass(alwaysRun = true)
    public void before(String deviceName, String portno) throws Exception {
        baseClass = new BaseClass("mlwallet", deviceName, portno);
        mlWalletLogin = new MLWalletLogin();
        mlWalletCashInViaBank = new MLWalletCashInViaBank();
        mlWalletCashInViaBranch = new MLWalletCashInViaBranch();
        mlWalletCashOutWithdraw = new MLWalletCashOutWithdraw();
        mlWalletSettings = new MLWalletSettings();
        mlWalletTransactionHistory = new MLWalletTransactionHistory();
        mlWalletLogOut = new MLWalletLogOut();
        mlWalletHomeAndDashBoard = new MlWalletHomeAndDashBoard();
        mlWalletTierUpgrade = new MLWalletTierUpgrade();
        mlWalletSendTransferToMLBranch = new MLWalletSendTransferToMLBranch();
        mlWalletSendTransferToMLWalletUser = new MLWalletSendTransferToMLWalletUser();
        mlWalletPayBills = new MLWalletPayBills();
        mlWalletBuyELoad = new MLWalletBuyELoad();
        mlWalletShopItems = new MLWalletShopItems();
        mlWalletBranchLocator = new MLWalletBranchLocator();
        mlWalletUseQR = new MLWalletUseQR();
        mlWalletTopUpGames = new MLWalletTopUpGames();
        propertyFileReader();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {
//        DriverManager.getAppiumDriver().manage().deleteAllCookies();
    }
    //Stop Application
    @AfterTest
    public void afterTest() {
        baseClass.tearDown();
    }


}
