package pages;

import com.microsoft.playwright.Page;
import factory.BrowserFactory;

import java.nio.file.Paths;

public class OfferPage {
    Page page;
    BrowserFactory browserFactory;

    //Login page locators
    private String rewardsPay = "(//span[normalize-space()='RewardsPay'])[1]";
    private String offers = "//a[normalize-space()='Offers']";
    private String ManageOffer = "//span[normalize-space()='Manage Offers']";
    private String offerDropdown = "//span[normalize-space()='Select']";
    private String offerUpload = "//li[normalize-space()='Offers - Upload']";
    private String uploadOffers = " //h2[normalize-space()='Upload Offers']";
    private String uploadFile = "//span[normalize-space()='Upload File']";
    private String chooseFileButton = " //input[@id='selectedFile']";
    private String sampleFile = "//span[normalize-space()='Sample File']";
    private String fileUploadedText = "(//div[@class='sAQn4'])[2]";
    private String uploadButton = "//button[normalize-space()='UPLOAD']";
    private String clearButton = "//button[normalize-space()='UPLOAD']";
    private String fileUploadSuccessfullyText = "//p[normalize-space()='File uploaded successfully']";
    private String blackoutDatesUpload = "//li[normalize-space()='Blackout dates - Upload']";
    private String uploadBlackoutDates = "//h2[normalize-space()='Upload Blackout Dates']";
    private String offerExisting = "//li[normalize-space()='Offers - Existing']";
    private String blackoutDatesDownload = "//li[normalize-space()='Blackout dates - Download']";
    private String downloadOffers = "//h2[normalize-space()='Download Offers']";
    private String downloadBlackoutDates = "//h2[normalize-space()='Download Blackout Dates']";
    private String warehouseId = "//li[normalize-space()='Warehouse Id']";
    private String pgmid = "//li[normalize-space()='PGMID']";
    private String enterWarehouseId = "//input[@placeholder='Enter Warehouse ID']";
    private String enterPgmId = "//input[@placeholder='Enter PGMID']";
    private String downloadButton = "//button[normalize-space()='DOWNLOAD']";
    private String warehouse_Id = "//p[normalize-space()='Warehouse Id']";
    private String enterWID = "//input[@placeholder='Enter WID (comma separated)']";

    //page constructor
    public OfferPage(Page _page) {
        page = _page;
        browserFactory = new BrowserFactory();
    }

    //write down verify and click on rewardsPay
    public void verifyAndClickOnRewardsPay() {
        page.isVisible(rewardsPay);
        page.click(rewardsPay);
        page.waitForLoadState();
    }

    //verify and click on offers
    public void verifyAndClickOnOffers() {
        page.isVisible(offers);
        page.click(offers);
        page.waitForLoadState();
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

    //verify upload offers text
    public String verifyUploadOffersText() {
        String text = page.innerText(uploadOffers);
        return text;
    }

    //verify upload offers page
    public boolean verifyUploadOffersPage() {
        boolean flag = true;
        if ((page.isVisible(uploadFile) && (page.isVisible(chooseFileButton) && (page.isVisible(sampleFile))))) {
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

    //upload file for default cohort
    public void uploadFileForDefaultCohort() {
        page.setInputFiles(chooseFileButton, Paths.get("src/test/resources/uploadFiles/Loffer_DEFAULT.csv"));
        page.isVisible(fileUploadedText);
        page.click(uploadButton);
    }

    //upload file for online cohort
    public void uploadFileForOnlineCohort() {
        page.setInputFiles(chooseFileButton, Paths.get("src/test/resources/uploadFiles/Loffer_ONLINE.csv"));
        page.isVisible(fileUploadedText);
        page.click(uploadButton);
    }

    //upload file for offline cohort
    public void uploadFileForOfflineCohort() {
        page.setInputFiles(chooseFileButton, Paths.get("src/test/resources/uploadFiles/Loffer_OFFLINE.csv"));
        page.isVisible(fileUploadedText);
        page.click(uploadButton);
    }

    //blackout dates upload file
    public void blackoutDatesUploadFile() {
        page.setInputFiles(chooseFileButton, Paths.get("src/test/resources/uploadFiles/Black_0ut_Date.csv"));
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

    //click on blackout dates upload value
    public void clickOnBlackoutDatesUploadValue() {
        page.isVisible(blackoutDatesUpload);
        page.click(blackoutDatesUpload);
    }

    //verify upload blackout dates page
    public String verifyUploadBlackoutDatesPage() {
        String text = page.innerText(uploadBlackoutDates);
        return text;
    }

    //click on offer existing value
    public void clickOnOfferExistingValue() {
        page.isVisible(offerExisting);
        page.click(offerExisting);
    }

    //click on blackout dates download value
    public void clickOnBlackoutDatesDownloadValue() {
        page.isVisible(blackoutDatesDownload);
        page.click(blackoutDatesDownload);
    }

    //get download offers text
    public String verifyDownloadOffersText() {
        String text = page.innerText(downloadOffers);
        return text;
    }

    //get download blackout dates text
    public String verifyDownloadBlackoutDatesText() {
        String text = page.innerText(downloadBlackoutDates);
        return text;
    }

    //click on warehouse id
    public void clickOnWarehouseId() {
        page.isVisible(warehouseId);
        page.click(warehouseId);
    }

    //click on pgmid
    public void clickOnPgmId() {
        page.isVisible(pgmid);
        page.click(pgmid);
    }

    //enter warehouse id
    public void enterWarehouseId(String warehouseId) {
        page.isVisible(enterWarehouseId);
        page.fill(enterWarehouseId, warehouseId);
    }

    //enter pgmid
    public void enterPgmId(String pgmid) {
        page.isVisible(enterPgmId);
        page.fill(enterPgmId, pgmid);
    }

    //click on download button
    public void clickOnDownloadButton() {
        page.isVisible(downloadButton);
        page.click(downloadButton);
    }

    //verify warehouse id
    public boolean verifyWarehouseId() {
       return page.isVisible(warehouse_Id);
    }

    //enter WID
    public void enterWID(String wid) {
        page.isVisible(enterWID);
        page.fill(enterWID, wid);
    }
}
