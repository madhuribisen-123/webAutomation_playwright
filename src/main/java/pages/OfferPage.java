package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OfferPage {
    Page page;
    BrowserFactory browserFactory;

    //Login page locators
    private String rewardsPay = "(//span[normalize-space()='RewardsPay'])[1]";
    private String offers = "//a[normalize-space()='Offers']";
    private String ManageOffer = "//span[normalize-space()='Manage Offers']";
    private String offerDropdown = "//div[@class='IbrVV']";
    private String offerUpload = "//li[normalize-space()='Offers - Upload']";
    private String uploadOffers = " //h2[normalize-space()='Upload Offers']";
    private String uploadFile = "//span[normalize-space()='Upload File']";
    private String chooseFileButton = " //input[@id='selectedFile']";
    private String sampleFile = "//span[normalize-space()='Sample File']";
    private String fileUploadedText = "(//div[@class='sAQn4'])[2]";
    private String uploadButton = "//button[normalize-space()='UPLOAD']";
    private String clearButton = "//button[normalize-space()='UPLOAD']";
    private String fileUploadSuccessfullyText = "//p[@class='_3vGbr']";

    //page constructor
    public OfferPage(Page _page) {
        page = _page;
        browserFactory = new BrowserFactory();
    }

    //write down verify and click on rewardsPay
    public void verifyAndClickOnRewardsPay() {
        page.isVisible(rewardsPay);
        page.click(rewardsPay);
    }

    //verify and click on offers
    public void verifyAndClickOnOffers() {
        page.isVisible(offers);
        page.click(offers);
    }

    //verify manage offer
    public void verifyManageOffer() {
        page.isVisible(ManageOffer);
    }

    //verify and click on offer dropdown
    public void verifyAndClickOnOfferDropdown() {
        page.isVisible(offerDropdown);
        page.click(offerDropdown);
    }

    //click on dropdown and select value 'Offers - Upload'
    public void clickOnOffersUploadValue() {
        page.isVisible(offerUpload);
        page.click(offerUpload);
    }

    //verify upload offers page
    public boolean verifyUploadOffersPage() {
        boolean flag = true;
        if (page.isVisible(uploadOffers) && (page.isVisible(uploadFile) && (page.isVisible(chooseFileButton) && (page.isVisible(sampleFile))))) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    //click on choose file button
    public void clickOnChooseFileButton() {
        page.isVisible(chooseFileButton);
        page.click(chooseFileButton);
    }

    //upload file
    public void uploadFile() {
        page.setInputFiles(chooseFileButton, Paths.get("src/test/resources/uploadFiles/Loffer.csv"));
        page.isVisible(fileUploadedText);
        page.click(uploadButton);
    }

    //upload and clear file button
    public void clickOnClearButton() {
        page.isVisible(clearButton);
        page.click(clearButton);
    }

    //get file uploaded successfully text
    public String verifyFileUploadedSuccessfully() {
        String text = page.innerText(fileUploadSuccessfullyText);
        return text;
    }

}
