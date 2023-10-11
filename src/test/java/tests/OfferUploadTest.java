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

    @Test
    public void offerUploadTest() {
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
        Assert.assertTrue(offerPage.verifyUploadOffersPage(), "Upload Offers is not visible");
        offerPage.uploadFile();
        Assert.assertEquals(offerPage.verifyFileUploadedSuccessfully(), AppConstants.FILE_UPLOADED_SUCCESSFULLY, "File is not uploaded successfully");
        offerPage.clickOnClearButton();
    }
}

