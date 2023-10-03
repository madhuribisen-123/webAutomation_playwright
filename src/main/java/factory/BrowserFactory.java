package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class BrowserFactory {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext browserContext;
    static Page page;
    Properties properties;
    PageManager pageManager;

    public Page initBrowser(Properties properties) {
        String browserName = properties.getProperty("browser").trim();
        System.out.println("browser name is : " + browserName);
        playwright = Playwright.create();
        PageManager.setPlaywright(playwright);

        switch (browserName.toLowerCase().trim()) {
            case "chromium":
                System.out.println("Create Chromium browser...");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                System.out.println("Create Chrome browser...");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                System.out.println("Create Firefox browser...");
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                System.out.println("Create Safari browser...");
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Set default chrome browser...");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        PageManager.setBrowser(browser);
        PageManager.setBrowserContext(browserContext);
        PageManager.setPage(page);
        return page;
    }

    /**
     * this method is used to initialize the properties from config file
     */
    public Properties init_prop() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     *
     * @return
     */
    public static String takeScreenshot() {
        String path = System.getProperty("./Users/madhuribisen/Automation/webAutomation_Playwright/ScreenShot") + "/screenshots/" + System.currentTimeMillis() + ".png";
        PageManager.getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }
}
