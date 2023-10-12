package tests;

import common.BaseTest;
import constants.AppConstants;
import factory.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankOffers;
import pages.LoginPage;
import pages.OfferPage;

public class BankOffersTest extends BaseTest {
    LoginPage loginPage;
    OfferPage offerPage;
    BankOffers bankOffers;

    @Test(priority = 1, description = "Verify Bank Offers for delete campaign id")
    public void verifyBankOffersForDeleteCampaignId() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        bankOffers = new BankOffers(PageManager.getPage());
        offerPage.verifyAndClickOnOffers();
        bankOffers.clickOnBankOffers();
        Assert.assertEquals(bankOffers.verifyBankOffers(), AppConstants.BANK_OFFERS, "Bank Offers is not visible");
        bankOffers.verifyAndClickOnAddCampaignInfo();
        bankOffers.verifyCampaignId();
        bankOffers.setAddCampaignId();
        bankOffers.clickOnDeleteButton();
        Assert.assertEquals(bankOffers.getConfirmationMessage(), AppConstants.DELETE_MESSAGE, "Delete Campaign Id is not visible");
        bankOffers.clickOnYesButton();
    }

    @Test(priority = 2, description = "Verify Bank Offers for no delete campaign id")
    public void verifyBankOffersForNoDeleteCampaignId() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
        offerPage = new OfferPage(PageManager.getPage());
        offerPage.verifyAndClickOnRewardsPay();
        bankOffers = new BankOffers(PageManager.getPage());
        offerPage.verifyAndClickOnOffers();
        bankOffers.clickOnBankOffers();
        Assert.assertEquals(bankOffers.verifyBankOffers(), AppConstants.BANK_OFFERS, "Bank Offers is not visible");
        bankOffers.verifyAndClickOnAddCampaignInfo();
        bankOffers.verifyCampaignId();
        bankOffers.setAddCampaignId();
        bankOffers.clickOnDeleteButton();
        Assert.assertEquals(bankOffers.getConfirmationMessage(), AppConstants.DELETE_MESSAGE, "Delete Campaign Id is not visible");
        bankOffers.clickOnNoButton();
    }

}


