package tests;

import common.BaseTest;
import constants.AppConstants;
import factory.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginOnStaging() {
        loginPage = new LoginPage(PageManager.getPage());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        String url = loginPage.getPageURL();
        Assert.assertEquals(url, AppConstants.DEV_URL, "URL is not correct");
    }
}

