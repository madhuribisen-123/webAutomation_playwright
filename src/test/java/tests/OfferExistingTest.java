package tests;

import common.BaseTest;
import constants.AppConstants;
import factory.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OfferPage;

public class OfferExistingTest extends BaseTest {
    OfferPage offerPage;
    LoginPage loginPage;

    @Test(priority = 1, description = "Verify Offer Existing for warehouse Id")
    public void verifyOfferExistingForWarehouseId() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnOfferExistingValue();
        Assert.assertEquals(offerPage.verifyDownloadOffersText(), AppConstants.DOWNLOAD_OFFER, "Download Offers test is not visible");
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnWarehouseId();
        offerPage.enterWarehouseId(properties.getProperty("warehouseId"));
        offerPage.clickOnDownloadButton();
    }

    @Test(priority = 2, description = "Verify Offer Existing for pgmid")
    public void verifyOfferExistingForPgmid() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnOfferExistingValue();
        Assert.assertEquals(offerPage.verifyDownloadOffersText(), AppConstants.DOWNLOAD_OFFER, "Download Offers test is not visible");
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnPgmId();
        offerPage.enterPgmId(properties.getProperty("pgmid"));
        offerPage.clickOnDownloadButton();
    }

    @Test(priority = 3, description = "Verify blackout dates download for warehouse Id")
    public void verifyBlackoutDatesDownloadForWarehouseId() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnBlackoutDatesDownloadValue();
        Assert.assertEquals(offerPage.verifyDownloadBlackoutDatesText(), AppConstants.DOWNLOAD_BLACKOUT_DATES, "Download blackout dates test is not visible");
        Assert.assertTrue(offerPage.verifyWarehouseId(), "Warehouse Id is not visible");
        offerPage.enterWID(properties.getProperty("warehouseId"));
        offerPage.clickOnDownloadButton();
    }

}

