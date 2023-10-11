package tests;

import common.BaseTest;
import constants.AppConstants;
import factory.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OfferPage;

public class OfferUploadTest extends BaseTest {
    OfferPage offerPage;
    LoginPage loginPage;

    @Test(priority = 1, description = "Verify Offer Upload for Default Cohort")
    public void offerUploadForDefaultCohortTest() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnOffersUploadValue();
        Assert.assertEquals(offerPage.verifyUploadOffersText(), AppConstants.UPLOAD_OFFER, "Upload Offers test is not visible");
        Assert.assertTrue(offerPage.verifyUploadOffersPage(), "Upload Offers is not visible");
        offerPage.uploadFileForDefaultCohort();
        Assert.assertEquals(offerPage.verifyFileUploadedSuccessfully(), AppConstants.FILE_UPLOADED_SUCCESSFULLY, "File is not uploaded successfully");
        offerPage.clickOnClearButton();
    }

    @Test(priority = 2, description = "Verify Offer Upload for Online Cohort")
    public void offerUploadForOnlineCohortTest() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnOffersUploadValue();
        Assert.assertEquals(offerPage.verifyUploadOffersText(), AppConstants.UPLOAD_OFFER, "Upload Offers test is not visible");
        Assert.assertTrue(offerPage.verifyUploadOffersPage(), "Upload Offers is not visible");
        offerPage.uploadFileForOnlineCohort();
        Assert.assertEquals(offerPage.verifyFileUploadedSuccessfully(), AppConstants.FILE_UPLOADED_SUCCESSFULLY, "File is not uploaded successfully");
        offerPage.clickOnClearButton();
    }

    @Test(priority = 3, description = "Verify Offer Upload for Offline Cohort")
    public void offerUploadForOfflineCohortTest() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnOffersUploadValue();
        Assert.assertEquals(offerPage.verifyUploadOffersText(), AppConstants.UPLOAD_OFFER, "Upload Offers test is not visible");
        Assert.assertTrue(offerPage.verifyUploadOffersPage(), "Upload Offers is not visible");
        offerPage.uploadFileForOfflineCohort();
        Assert.assertEquals(offerPage.verifyFileUploadedSuccessfully(), AppConstants.FILE_UPLOADED_SUCCESSFULLY, "File is not uploaded successfully");
        offerPage.clickOnClearButton();
    }

    @Test(priority = 4, description = "Verify blackout dates offer Upload")
    public void offerBlackoutDatesUploadTest() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        offerPage.verifyAndClickOnOffers();
        offerPage.verifyManageOffer();
        offerPage.verifyAndClickOnOfferDropdown();
        offerPage.clickOnBlackoutDatesUploadValue();
        Assert.assertEquals(offerPage.verifyUploadBlackoutDatesPage(), AppConstants.UPLOAD_BLACKOUT_DATES, "Upload Blackout Dates is not visible");
        Assert.assertTrue(offerPage.verifyUploadOffersPage(), "Upload Offers is not visible");
        offerPage.blackoutDatesUploadFile();
        Assert.assertEquals(offerPage.verifyFileUploadedSuccessfully(), AppConstants.FILE_UPLOADED_SUCCESSFULLY, "File is not uploaded successfully");
        offerPage.clickOnClearButton();
    }

}

