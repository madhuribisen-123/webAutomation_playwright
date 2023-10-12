package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;

import java.util.List;

public class BankOffers {
    Page page;
    BrowserFactory browserFactory;

    //write locator Add Campaign Info button and click on it
    private String bankOffers = "//span[normalize-space()='Bank Offers']";
    private String addCampaignInfo = "//button[normalize-space()='Add Campaign Info']";
    private String campaignId = "//p[normalize-space()='Campaign Id']";
    private String enterCompaignId = " //input[@type='text']";
    private String saveButton = "//button[normalize-space()='Save']";
    private String deleteButton = "(//button[normalize-space()='Delete'])[1]";
    private String confirmationDeleteMessage = "//p[normalize-space()='Are you sure you want to delete?']";
    private String yesButton = "//button[normalize-space()='Yes']";
    private String noButton = "//button[normalize-space()='No']";

    public BankOffers(Page _page) {
        page = _page;
        browserFactory = new BrowserFactory();
    }

    public String verifyBankOffers() {
        return page.innerText(bankOffers);
    }

    public void clickOnBankOffers() {
        page.click(bankOffers);
    }

    public void verifyAndClickOnAddCampaignInfo() {
        page.isVisible(addCampaignInfo);
        page.click(addCampaignInfo);
    }

    public boolean verifyCampaignId() {
        return page.isVisible(campaignId);
    }

    public boolean enterCampaignId(String campaignId) {
        return page.isVisible(enterCompaignId);
    }

    public void clickOnSaveButton() {
        page.click(saveButton);
    }

    public void setAddCampaignId() {
        // Generate a random 5-digit number
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        // Find the text box element and fill it with the random number
        page.fill(enterCompaignId, randomNumber + "");
        String randomString = Integer.toString(randomNumber);
        page.click(saveButton);
        page.waitForLoadState();
    }

    //write method to delete campaign id
    public void clickOnDeleteButton() {
        page.click(deleteButton);
    }

    //get confirmation message
    public String getConfirmationMessage() {
        return page.innerText(confirmationDeleteMessage);
    }

    //click on yes button
    public void clickOnYesButton() {
        page.click(yesButton);
    }

    //click on no button
    public void clickOnNoButton() {
        page.click(noButton);
    }


}


